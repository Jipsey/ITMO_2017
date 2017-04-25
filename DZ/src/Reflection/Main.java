package Reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(toString(new B()));

    }

    // создаём аннотацию
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Exclude{

    }
    public static String toString(Object o) throws Exception {
        Class<?> c = o.getClass();

        String simpleName ="Name of the class: "+ c.getSimpleName();
        // делаем проверку с выводом адреса суперкласса на консоль
        if(c.getSuperclass()!=null){simpleName = simpleName + " ,superclass: " +
                (c.getSuperclass()).getCanonicalName();}
        // делаем проверку на имплементацию интерфейсов, с выводом адреса и имени интерфейса
        if (c.getInterfaces().length > 0){simpleName = simpleName+ " and implements  " +
                Arrays.toString((c.getInterfaces()));}

        Field[] fields = c.getDeclaredFields();

        for (Field field : fields) {
           Exclude an = field.getAnnotation(Exclude.class);
            if(an == null){
            String name = field.getName();
            field.setAccessible(true);
            Object val = field.get(o);
            String forPrint = "Name of the variable: " + name + ", the value: " + val +
                    ", type: " + field.getType().getSimpleName();

            System.out.println( forPrint );}
        }
        return simpleName;
    }


    static class A {
        int i = 10;
        double d = 1.2;
        String str = "Hello! I`m class A";
    }

    static class B extends A {

        @Exclude // помечаем аннотацие поле которое не будем выводить в общем списке, через toString
        int i = 12;

        double d = 23;
        String str1 = "Hello! I`m class B, subclass of the class A";
        A a ;
    }

}