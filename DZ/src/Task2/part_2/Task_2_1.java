package Task2.part_2;

public class Task_2_1 {

    public static void main(String[] args) {

        double b = (Math.random() * 150) +5;
                int a = (int) Math.round(b);


        if(a>=25&a<=100){
        System.out.println( "число "+ a +" входит в интервал ");}
        else System.out.println("число "+ a +" не входит в интервал ");

    }
}
