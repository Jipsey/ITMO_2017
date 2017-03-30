package Task6_Objects.SqarePerimeter;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
         Circle circle = new Circle(-98.868,44.68,-58.32,73.072);

          double s = circle.square();
          double p = circle.perimeter();
          double el = circle.edgeL();

        System.out.print("радиус равен:" + el + " мм\n");
        System.out.print("площадь равна:" + s + " кв. мм\n");
        System.out.print("периметр равен:" + p + " мм\n");

        System.out.println("---------треугольник----------");

        Triangle tri = new Triangle(-98.868,44.68,-58.32,73.072,0,-49.5);

        double triS = tri.square();
        double triP = tri.perimeter();
        double edgeT = tri.edgeL();

        System.out.print("площадь равен:" + triS + " мм\n");
        System.out.print("периметр равен:" + triP + " кв. мм\n");
        System.out.print("длина стороны:" + edgeT + " мм\n");

    }

}
