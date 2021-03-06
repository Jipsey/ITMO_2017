/*
  В городе N есть большой склад на котором существует 50000 различных полок. Для
  удобства работников руководство склада решило заказать для каждой полки табличку с
  номером от 00001 до 50000 в местной типографии, но когда таблички напечатали, оказалось
  что печатный станок из-за неисправности не печатал цифру 2, поэтому все таблички, в
  номерах которых содержалась одна или более двойка (например, 00002 или 20202) — надо
  перепечатывать. Напишите программу, которая подсчитает сколько всего таких ошибочных
  табличек оказалось в бракованной партии
 */
package Task2_loops.part_3;

public class Task_2_11_old {
    public static void main(String[] args) {

        int n =5; // количество цифр в номере
        int t[] = new int[n] ;
        int m = t.length;
        int r = 1;// разряд

        int x =0; // счётчик совпадений

        for (int j = 0; j < 600000; j++) {
            t[m-r]++;

            if( t[m-5]==2 || t[m-4]==2 || t[m-3]==2 || t[m-2]==2 || t[m-1]==2){
                System.out.print("***Совпадение!***");x++;}


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


            if (t[m-5]==5 && t[m-4]==0 && t[m-3]==0 && t[m-2]==0 && t[m-1]==0 )
            {
                System.out.println("Конец программы! Всего заменить "+x+" номеров");
                break;}

    }
    }
}