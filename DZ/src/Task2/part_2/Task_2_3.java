package Task2.part_2;


public class Task_2_3 {
    public static void main(String[] args) {



        int a = (int) (Math.random()*10);
        int b = (int) (Math.random()*10);
        int c = (int) (Math.random()*10);

        System.out.printf("%s %s %s\n",a, b, c +" - рандомные число" );

        if(a==b||a==c){a++;
           if(a==c && a!=9)  a++;
                   else a=(b--);}
        if(b==c||b==a){b++;
           if (b==a && b!=9) b++;
           else b=(c--);}
        System.out.printf("%s %s %s\n",a, b, c + " - числа после проверки");
        if(a!=b && b!=c && a!=c)

        {
            if (a > b && b > c)
                System.out.printf("%s %s %s",a, b, c );
             else if ( a > c && c > b )
                System.out.printf("%s %s %s",a, c, b );
             else if (b > a && a > c)
                System.out.printf("%s %s %s",b, a, c );
             else if (b > c && c > a)
                System.out.printf("%s %s %s",b, c, a );
             else if (c > a && a > b)
                System.out.printf("%s %s %s",c, a, b );
             else if (c > b && b > a)
                System.out.printf("%s %s %s",c, b, a );
         }
        System.out.println(" - порядок цифр по убыванию");
        }
    }

