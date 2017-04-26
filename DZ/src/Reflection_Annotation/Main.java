package Reflection_Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(toString(new B()));

    }

    // создаём аннотацию
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Exclude{

    }
    public static String toString(Object o) {

        Class<?> c = o.getClass();

        StringBuilder sb = new StringBuilder("Class name: "+ c.getSimpleName());

        if(c.getSuperclass()!=null){sb.append("\tsuperclass: "+ (c.getSuperclass()).getCanonicalName()+"\t");}
        // делаем проверку на имплементацию интерфейсов, с выводом адреса и имени интерфейса
        if (c.getInterfaces().length > 0){
            sb.append(" and implements  " + Arrays.toString((c.getInterfaces())));}

        Field[] fields = c.getDeclaredFields();
         sb.append("Fields: { ");
         for (Field field : fields) {
             // делаем проверку наличия аннотации, если ее нет, то добавляем её в Объект StringBuilder "sb"
            if ( !field.isAnnotationPresent(Exclude.class)) {
                sb.append("(" + field.getType().getSimpleName() + ") " + field.getName());
                try {
            field.setAccessible(true);
            Object val = field.get(o);
            sb.append(  " = " + val +", ") ;
                      }
                      catch (Exception e){
                    System.err.println("Exception catched " +e.getMessage());
                }
            }
         }   sb.append("}");
         Class[] classes = c.getClasses();
         if(classes.length<0){return String.valueOf(sb);}
         else {
         for (Class cls:classes) {
            String border =("------------ Inner Class(-es) ------------");
            sb.append("\n" + border+ "\n" + toString(cls));}
         }return String.valueOf(sb);
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
        String str1 = "Hello! I`m class B, subclass of the class A";
        A a ;

        public static class C{

            int x = 13;


        }
        public static class D{
            int y=14;
        }

    }

}