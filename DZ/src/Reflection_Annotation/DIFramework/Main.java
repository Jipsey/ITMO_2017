package Reflection_Annotation.DIFramework;

import java.util.Random;

public class Main {


    public static void main(String[] args) {

        Sacrifice sacr = new Sacrifice();
        System.out.println(sacr);

        DIContext.getIstance().changeField(sacr);
        System.out.println(sacr);

    }

  public class Source {
      private final int val;
      public Source(){
          val = new Random().nextInt();
      }

  }


    public static class Sacrifice {

       @Marker(value = Source.class,makeNewDimension = true)
       private Source a;

       @Marker(Source.class)
       private Source b;

       private Source c;

       @Marker(value = Source.class)
       private Source d;


        @Override
        public String toString() {
            return "Sacrifice{" +
                    "a=" + a +
                    ", b=" + b +
                    ", c=" + c +
                    ", d=" + d +
                    '}';
        }
    }

}
