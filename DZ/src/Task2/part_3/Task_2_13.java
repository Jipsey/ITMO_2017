package Task2.part_3;

/* В американской армии считается несчастливым число 13, а в японской — 4. Перед
   международными учениями штаб российской армии решил исключить номера боевой
   техники, содержащие числа 4 или 13 (например, 40123, 13313, 12345 или 13040), чтобы не
   смущать иностранных коллег. Если в распоряжении армии имеется 100 тыс. единиц боевой
   техники и каждая боевая машина имеет номер от 00001 до 99999, то сколько всего номеров
   придётся исключить?
 */

    public class Task_2_13 {
        public static void main(String[] args) {

            int n =5; // количество цифр в номере
            int t[] = new int[n] ;
            int m = t.length;
            int r = 1;// разряд

            int x =0,y=0; // счётчики совпадений

            for (int j = 0; j < 100000; j++) {
                t[m-r]++;

                if( t[0]==1 && t[1]==3 || t[1]==1 && t[2]==3 || t[2]==1 && t[3]==3 || t[3]==1 && t[4]==3   ){
                    System.out.println("--- Совпадение числа 13 ---");x++;}

                if( t[0]==4 || t[1]==4 || t[2]==4 || t[3]==4 || t[4]==4 ){
                    System.out.println("--- Совпадение числа 4 ---");y++;}

                for (int i = 0; i <m ; i++){System.out.print(" " + t[i]) ;
                    if (i==(t.length-1)){System.out.println();}}

                if (t[m-1]==9 && t[m-2]!=9)
                {t[m-1]=0; t[m-2]++;
                    for (int i = 0; i <m ; i++){System.out.print(" " + t[i]);
                        if (i==(t.length-1)){System.out.println();}}}

                if (t[m-2]==9 && t[m-1]==9 && t[m-3]!=9 )
                {t[m-2]=t[m-1]=t[m-3]++;
                    for (int i = 0; i <m ; i++){System.out.print(" " + t[i]);
                        if (i==(t.length-1)){System.out.println();}}}

                if (t[m-3]==9 && t[m-2]==9 && t[m-1]==9 && t[m-4]!=9 )
                {t[m-1]=t[m-2]=t[m-3]=0; t[m-4]++;
                    for (int i = 0; i <m ; i++){System.out.print(" " + t[i]);
                        if (i==(t.length-1)){System.out.println();}}}

                if (t[m-4]==9 && t[m-3]==9 && t[m-2]==9 && t[m-1]==9 && t[m-5]!=9 )
                {t[m-4]=t[m-3]=t[m-2]=t[m-1]=0; t[m-5]++;
                    for (int i = 0; i <m ; i++){System.out.print(" " + t[i]);
                        if (i==(t.length-1)){System.out.println();}}}


                if (t[m-5]==9 && t[m-4]==9 && t[m-3]==9 && t[m-2]==9 && t[m-1]==9 )
                {
                    System.out.println("***Конец программы!***");
                    System.out.println(" Из-за числа 13 заменить " + x + " штук");
                    System.out.println(" Из-за числа 4 заменить " + y + " штук");
                    System.out.println(" Всего необходимо заменить " + (x + y) + " штук");
                    break;}

            }
        }
    }

