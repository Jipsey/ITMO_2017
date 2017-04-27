package Reflection_Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StringUtils {

    private static final Set<Class<?>> READY;
    static {

        Set <Class<?>> types = new HashSet<>();
        types.add(String.class);
        types.add(Integer.class);
        types.add(int.class);
        types.add(Double.class);
        types.add(double.class);
        types.add(Float.class);
        types.add(float.class);
        types.add(Character.class);
        types.add(char.class);
        types.add(Byte.class);
        types.add(byte.class);

        READY = Collections.unmodifiableSet(types);

    }

    public static void main(String[] args) {

        System.out.println(toString(new B()));

    }


    public static String toString(Object obj){
        StringBuilder sb = new StringBuilder();

        toString(obj,sb);
        return sb.toString();
    }

    public static String toString(Object o, StringBuilder sb) {

        Class<?> c = o.getClass();

        sb.append(c.getSimpleName())
                .append(" class contains: {");

         Field[] fields = c.getDeclaredFields();

         for (Field field : fields) {
             // делаем проверку наличия аннотации, если ее нет, то добавляем её в Объект StringBuilder "sb"
            if ( !field.isAnnotationPresent(Exclude.class)) {
                sb.append("(" + field.getType().getSimpleName() + ") " + field.getName());
                try {
                  field.setAccessible(true);
                  Object val = field.get(o);
                  if (val ==null){sb.append("null");}
                  if(!READY.contains(val.getClass())){
                      if (val.getClass().isArray()){sb.append('='); arrayToString(val,sb);}
                                         else {
                                              sb.append(" = ");
                                              toString(val,sb);
                                              if (!field.equals(fields[fields.length-1])){sb.append(", ");}
                                              }
                   }
                   if (val.getClass().equals(String.class)){
                                sb.append("=")
                                        .append('"')
                                        .append(val)
                                        .append('"');
                  }
                   else if(READY.contains(val.getClass())) {sb.append(  "=" + val );}
                   if (!field.equals(fields[fields.length-1])){sb.append(", ");}
                }
                catch (Exception e){System.err.println("Exception catched " +e.getMessage());}
            }
         }   sb.append("}");
         return sb.toString();
         }


    static class A {
        int i = 10;
        double d = 1.2;
        String str = "Hello! I`m class A";
    }

    static class B extends A {

        @Exclude // помечаем аннотацией поле которое не будем выводить в общем списке, через toString
        int i = 12;


        double d = 23;

        int[] arr ={77,88,99};

        String str1 = "Hello! I`m class B, subclass of the class A";
        A a = new A();

       public class C{
          int x = 99;
      }

    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Exclude{

    }

    private static void arrayToString(Object o, StringBuilder sb) {
        if (o.getClass().getComponentType() == int.class) {
            int[] ints = (int[]) o;
            sb.append(Arrays.toString(ints));
        }
    }
}