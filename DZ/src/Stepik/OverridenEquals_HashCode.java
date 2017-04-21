package Stepik;
/**
 *
 */

public class OverridenEquals_HashCode {
    public static void main(String[] args) {

     ComplexNumber cn1 = new ComplexNumber(234,1);
     ComplexNumber cn2 = new ComplexNumber(1,1);

        System.out.println(Double.doubleToLongBits(2.4));
        System.out.println(Double.doubleToLongBits(2.4) >>> 32);
        System.out.println(Double.doubleToLongBits(2.4)^(Double.doubleToLongBits(2.4) >>> 32));
    }

    public static final class ComplexNumber {
        private final double re;
        private final double im;


        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override
        public boolean equals(Object obj){
            if(this == obj) {return true;}  // сначала сравнимаем по ссылкам
            if(obj == null || obj.getClass()!=this.getClass()){ // проверяем чтобы объект не был null
                                                                // затем сраниваем по типу, методом getClass
                return false;}
            ComplexNumber guest = (ComplexNumber) obj;          // затем сраниваме по переменным и полям, приведя к типу
                                                                // объект и создав переменную типа который будем сравнивать

            if ((re == guest.re && im == guest.im)){return true;}

            return false;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(re);
            result = (int) (temp ^ (temp >>> 32)); //>>> - оператор сдвиг право без учёта знака, для того чтобы
                                                   // генерировалось десятизначное интовое значение
            temp = Double.doubleToLongBits(im);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }
}
