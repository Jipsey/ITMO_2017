package Reflection_Annotation.DIFramework;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class DIContext {

    private Map<Class,Object> singleton = new HashMap<>();
    private static final DIContext INSTANCE = new DIContext();

    public static DIContext getInstance (){return INSTANCE;}


    public void changeField(Object obj){
        if(obj == null)return;

        Class<?> cls = obj.getClass();

        Field [] fields =cls.getDeclaredFields();
        for ( Field field:fields ) {

            if (field.isAnnotationPresent(Marker.class)) {
               Class<?> type = field.getAnnotation(Marker.class).value();
               boolean makeNewDimension =  field.getAnnotation(Marker.class).makeNewDimension();

               Object dependancy = getDependancy(type,makeNewDimension);

               setDependancy(field,obj,dependancy);
               }
            }
        }



    private Object getDependancy(Class<?> type, boolean makeNewDimension){
       Object result = singleton.get(type);
       if(!makeNewDimension && result != null)return result;
        try{ result = type.newInstance();
            singleton.putIfAbsent(type, result);} catch (InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
       return result;

    }

    private void setDependancy(Field field, Object sacrifice,Object dependancy) {
         try {field.setAccessible(true);

         field.set(sacrifice,dependancy);
         } catch (Exception e){System.err.println("Cathed exception: " + e.getMessage());}
    }
}
