package Task2.part_3;


public class Task_2_5 {
    public static void main(String[] args) {

        int num = 8;



        for (int i = 1, num1 = 1; num >= i; i++) {

              int num2=num1*i;
              num1=num2;

              System.out.println(num2);
        }

    }
}
