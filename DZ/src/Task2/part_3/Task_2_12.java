/*
   Электронные часы показывают время в формате от 00:00 до 23:59. Подсчитать сколько
   раз за сутки случается так, что слева от двоеточия показывается симметричная комбинация
   для той, что справа от двоеточия (например, 02:20, 11:11 или 15:51).
*/

package Task2.part_3;

public class Task_2_12 {
    public static void main(String[] args) {

        int m=0; //минуты
        int h=0; //часы


        int x =0; // счётчик совпадений
        String n;

        while(h<= 23&& m<=59){

            m++;

            if (h==23 && m ==59){ break;}
            if (m == 60){h++; m=0; }

            n = String.format("%02d : %02d",h,m);
            int m1= Integer.parseInt(n.substring(5,6));
            int m2= Integer.parseInt(n.substring(6));

            int h1= Integer.parseInt(n.substring(0,1));
            int h2= Integer.parseInt(n.substring(1,2));

            if(h1==m2 && h2==m1 ){x++;
                System.out.println(n);
            }
        }System.out.println("Всего совпадений " + x);

    }
}