package Task2.part_2;

public class Task_2_2 {
    public static void main(String[] args) {

        System.out.println();

        int i =(int)(Math.random()*1000);

        String str = String.valueOf(i);
        if (str.length()==3){
        String a = str.substring(0,1);
        String b = str.substring(1,2);
        String c = str.substring(2);
            int x = Integer.parseInt(a);
            int y = Integer.parseInt(b);
            int z = Integer.parseInt(c);

        if(x > y && x > z){
            System.out.println(x +" Наибольшее число");

         }
           else if(y > x && y > z) System.out.println(y +" Наибольшее число")     ;
           else if(z > x && z > y) System.out.println(z +" Наибольшее число")   ;

        System.out.println(str );
        System.out.println( a );
        System.out.println( b );
        System.out.println( c) ;
        }
        else System.out.println("Число не подходит! - случайное чило не попало в интервал [100;999]");
    }


}


