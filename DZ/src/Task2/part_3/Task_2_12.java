/*
   Электронные часы показывают время в формате от 00:00 до 23:59. Подсчитать сколько
   раз за сутки случается так, что слева от двоеточия показывается симметричная комбинация
   для той, что справа от двоеточия (например, 02:20, 11:11 или 15:51).
*/

package Task2.part_3;

public class Task_2_12 {
    public static void main(String[] args) {

        int n =4; // количество цифр в номере
        int t[] = new int[n] ;
        int m = t.length;
        int r = 1;// разряд

        int x =0; // счётчик совпадений

        for (int j = 0; j < 1000; j++) {
            t[3]++;

            if( t[0]==t[3] && t[1]==t[2]){
                System.out.println("--- Совпадение комбинации цифр ---");x++;}


            for (int i = 0; i <m ; i++){System.out.print(" " + t[i]) ;
                if (i==(t.length-1)){System.out.println();}}

            if (t[3]==9 && t[2]!=6)
            {t[3]=0; t[2]++;
                for (int i = 0; i <m ; i++){System.out.print(" " + t[i]);
                    if (i==(t.length-1)){System.out.println();}}}

            if (t[2]==6 && t[3]==0 && t[1]!=3 && t[0]!=2 )
            {t[3]=t[2]=0; t[1]++;
                for (int i = 0; i <m ; i++){System.out.print(" " + t[i]);
                    if (i==(t.length-1)){System.out.println();}}}
                    else if (t[2]==6 && t[3]==0 && t[1]==3 && t[0]!=2 )
                    {t[3]=t[2]=0; t[1]++;
                    for (int i = 0; i <m ; i++){System.out.print(" " + t[i]);
                    if (i==(t.length-1)){System.out.println();}}}

            if (t[2]==6 && t[3]==0 && t[1]==9 && t[0]!=2)
            {t[2]=t[3]=t[1]=0; t[0]++;
                for (int i = 0; i <m ; i++){System.out.print(" " + t[i]);
                    if (i==(t.length-1)){System.out.println();}}}

            if (t[2]==6 && t[3]==0 && t[1]==0 && t[0]==2 )
            {t[2]=t[3]=t[0]=0; t[1]++;
                for (int i = 0; i <m ; i++){System.out.print(" " + t[i]);
                    if (i==(t.length-1)){System.out.println();}}}



            if (t[0]==2 && t[1]==3 && t[2]==5 && t[3]==9 )
            {
                System.out.println("***Конец программы!***");
                System.out.println(" всего совпадений комбинации " + x );

                break;}

        }
    }
}