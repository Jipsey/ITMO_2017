/*  В городе N проезд в трамвае осуществляется по бумажным отрывным билетам. Каждую
 неделю трамвайное депо заказывает в местной типографии рулон билетов с номерами от
 000001 до 999999. «Счастливым» считается билетик у которого сумма первых трёх цифр
 номера равна сумме последних трёх цифр, как, например, в билетах с номерами 003102 или
 567576. Трамвайное депо решило подарить сувенир обладателю каждого счастливого билета
 и теперь раздумывает, как много сувениров потребуется. С помощью программы подсчитайте
 сколько счастливых билетов в одном рулоне?
 */
package Task2.part_3;


public class Taks_2_10_new {
    public static void main(String[] args) {
        int x=0;

        for (int i = 1; i <999999 ; i++) {


        String n = String.format("%06d\n",i);

                String s1 = n.substring(0,1);
                int v1= Integer.parseInt(s1);
                String s2 = n.substring(1,2);
                int v2= Integer.parseInt(s2);
                String s3 = n.substring(2,3);
                int v3= Integer.parseInt(s3);
                String s4 = n.substring(3,4);
                int v4= Integer.parseInt(s4);
                String s5 = n.substring(4,5);
                int v5= Integer.parseInt(s5);
                String s6 = n.substring(5,6);
                int v6= Integer.parseInt(s6);

                int Sum1 = v1+v2+v3;
                int Sum2= v4+v5+v6;
                if(Sum1==Sum2){
                    x++;}


            }  System.out.println("Всего счастливых билетов: " + x);



        }    }

