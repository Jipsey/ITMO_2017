package Reflection_Annotation.DIFramework;

import java.util.Random;

public class Main {


    public static void main(String[] args) {

        Sacrifice sacr = new Sacrifice();
        System.out.println(sacr);

        DIContext.getInstance().changeField(sacr);
        System.out.println(sacr);

    }

  public static class Source {
      private final int val;
      public Source(){
          val = new Random().nextInt();
      }

      @Override
      public String toString() {
          return "Source{" +
                  "val=" + val +
                  '}';
      }
  }


    public static class Sacrifice {

       @Marker(Source.class)
       private Source a;

       @Marker(Source.class)
       private Source b;

       private Source c;

       @Marker(value = Source.class, makeNewDimension = true)
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
