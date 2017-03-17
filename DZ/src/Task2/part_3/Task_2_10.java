
/*  В городе N проезд в трамвае осуществляется по бумажным отрывным билетам. Каждую
 неделю трамвайное депо заказывает в местной типографии рулон билетов с номерами от
 000001 до 999999. «Счастливым» считается билетик у которого сумма первых трёх цифр
 номера равна сумме последних трёх цифр, как, например, в билетах с номерами 003102 или
 567576. Трамвайное депо решило подарить сувенир обладателю каждого счастливого билета
 и теперь раздумывает, как много сувениров потребуется. С помощью программы подсчитайте
 сколько счастливых билетов в одном рулоне?
 */
package Task2.part_3;

public class Task_2_10 {
    public static void main(String[] args) {

        int n =6; // количество цифр в номере
        int t[] = new int[n] ;
        int m = t.length;
        int r = 1;// разряд

        int x =0; // счётчик счастливых билетов

        for (int j = 0; j < 570000; j++) {
            t[m-r]++;
            int sumR= t[3]+t[4]+t[5];
            int sumL= t[0]+t[1]+t[2];
            if(sumR == sumL){System.out.print("***Совпадение!***");x++;}


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

            if (t[m-5]==9 && t[m-4]==9 && t[m-3]==9 && t[m-2]==9 && t[m-1]==9 &&t[m-m]!=9 )
            {t[m-5]=t[m-4]=t[m-3]=t[m-2]=t[m-1]=0; t[m-6]++;
                for (int i = 0; i <m ; i++){System.out.print(" " + t[i] );
                    if (i==(t.length-1)){System.out.println();}}}


            if (t[m-5]==9 && t[m-4]==9 && t[m-3]==9 && t[m-2]==9 && t[m-1]==9 &&t[m-m]==9 )
            {
                System.out.println("Конец программы! Всего счасливых билетов "+x+" штук");
                break;}

    }
    }
}