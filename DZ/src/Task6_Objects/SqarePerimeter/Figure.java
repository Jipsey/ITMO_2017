/**
 *
 */

package Task6_Objects.SqarePerimeter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Figure extends Point {

    public double x2;
    public double y2;

    public Figure(double x1,double y1, double x2, double y2){
        super(x1,y1);
        this.x2 = x2;
        this.y2 = y2;
    }

    public double edgeL (double x1,double y1, double x2, double y2){
        // в данном методе вычисляем длину грани(у окружеости радиус), используя классы import java.math.BigDecimal и
        // java.math.RoundingMode
        // создавая объект класса BigDecimal в сигнатуру вносим нашу формулу для вычисления, применяем на
        // созданном объекте метод setScale, в сигнатуре которого указываем до скольки знаков округлить и
        // каким способом (.CELLING), для того чтобы наш метод radius мог возвращать полученное значение
        // используем метод перевода в тип double .doubleValue.
        //
        return (new BigDecimal(Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2)))
                .setScale(3, RoundingMode.CEILING).doubleValue());
    }

    public abstract double edgeL();

    public abstract double square();

    public abstract double perimeter();


}
