
/**
 *
 */

package Task6_Objects.SqarePerimeter;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle extends Figure {

      public Circle(double x1,double y1, double x2, double y2){
      super(x1,y1,x2,y2);}


   // public double radius(double x1,double x2,double y1,double y2){

        // в данном методе вычисляем радиус Круга, используя классы import java.math.BigDecimal и  java.math.RoundingMode
        // создавая объект класса BigDecimal в сигнатуру вносим нашу формулу для вычисления, применяем на
        // созданном объекте метод setScale, в сигнатуре которого указываем до скольки знаков округлить и
        // каким способом (.CELLING), для того чтобы наш метод radius мог возвращать полученное значение
        // используем метод перевода в тип double .doubleValue.
        //
//        return (new BigDecimal(Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2))).setScale(3, RoundingMode.CEILING).doubleValue());
  //  }


    @Override
    public double edgeL() {
        return super.edgeL(x1,y1,x2,y2);
    }

    @Override
public double perimeter(){
          return Math.round(2*Math.PI*super.edgeL(x1,y1,x2,y2));
      }



    @Override
      public double square(){
          return Math.round(Math.PI*(Math.pow(super.edgeL(x1,y1,x2,y2),2)));
      }

   }


