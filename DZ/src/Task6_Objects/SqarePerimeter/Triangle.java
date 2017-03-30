/**
 *
 */
package Task6_Objects.SqarePerimeter;

public class Triangle extends Figure {
           public double x3; // т.к. в треугольнике три точки добавляем её
           public double y3; //
    public Triangle(double x1,double y1,double x2,double y2,double x3,double y3){
        super(x1,y1,x2,y2);
        this.x3 = x3;
        this.y3 = y3;
    }

    public double halfPerimeter (double e1,double e2,double e3){
        return (e1+e2+e3)/2;

    }

    double e1 = this.edgeL(x1,y1,x2,y2);
    double e2 = this.edgeL(x2,y2,x3,y3);
    double e3 = this.edgeL(x1,y1,x3,y3);

    double hp = this.halfPerimeter(e1,e2,e3);

    @Override
    public double edgeL() {
        return super.edgeL(x1,y1,x2,x2);
    }

    @Override
    public double square() {
        return Math.sqrt((hp*(hp-e1)*(hp-e2)*(hp-e3)));
    }

    @Override
    public double perimeter() {
        return e1+e2+e3;
    }
}
