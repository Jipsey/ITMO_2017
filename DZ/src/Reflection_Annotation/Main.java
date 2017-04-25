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

        String simpleName ="Class name: "+ c.getSimpleName();

        if(c.getSuperclass()!=null){simpleName = simpleName +"  superclass: "+ (c.getSuperclass()).getCanonicalName();}
        // делаем проверку на имплементацию интерфейсов, с выводом адреса и имени интерфейса
        if (c.getInterfaces().length > 0){simpleName = simpleName+ " and implements  " +
                Arrays.toString((c.getInterfaces()));}

        System.out.println(simpleName);
        System.out.print("Fields {");
        Field[] fields = c.getDeclaredFields();

        for (Field field : fields) {
             // делаем проверку наличия аннотации, если ее нет, то записываем имя поля его значени и тип
             // в стринговую переменную forPrint, после чего выводим её на консоль
            if ( !field.isAnnotationPresent(Exclude.class)) {
                try {
            String name = field.getName();
            field.setAccessible(true);
            Object val = field.get(o);
            String forPrint = "(" + field.getType().getSimpleName() + ") " + name + " = " + val ;

            System.out.print( forPrint );} catch (Exception e){
                    System.err.println("Exception catched " +e.getMessage());
                }
            }
        }   System.out.println("}");
         Class[] classes = c.getClasses();
         if(classes.length>0){
         for (Class cls:classes) {
             System.out.println("------------ Inner Class(-es) ------------");
             toString(cls);
         }
         }
        return "";
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
    }

}