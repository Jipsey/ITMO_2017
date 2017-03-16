package Task2.part_2;


public class Task_2_4 {
    public static void main(String[] args) {

        int time = (int) (Math.random()*8);

        System.out.println(time);
        if (time==1)
            System.out.println("до конца рабочего дня " + time +" час");
        else if(time >1 && time < 5)
            System.out.println("до конца рабочего дня " + time +" часa");
        else if (time > 4 && time < 9)System.out.println("до конца рабочего дня " + time +" часов");
            else System.out.println("до конца рабочего дня менее часа");
    }
}
