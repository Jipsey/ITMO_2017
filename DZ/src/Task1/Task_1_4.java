package Task1;

public class Task_1_4 {

    public static void main(String[] args) {

        int a = 678;
        int i=0;
        int n=0;
        int num1 = 0;
        int num2 = 0;

           if (a>100 & a<1000){
            for(i=0;i<(a/100);i++) {
                num1 = a % 100;
                }

                if (num1>10 & num1<100){
                   for (n = 0; n < (num1/10); n++) {
                    num2 = num1 % 10;
                    }
                }

            }

        System.out.println(i + n + num2);
    }
        }




