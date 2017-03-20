package Task3_Arrays;

/*
 *
 */
import java.util.Arrays;
public class Task_XOR {

    public static void main(String[] args) {

        int[] source = new int[7];
        int[] key  =new int[5];


        for (int m = 0; m< key.length; m++){
            int z = (int)(Math.random()*100);
            key[m] =z;
        }
            System.out.println("Ключ " + Arrays.toString(key));

        for(int i=0;i<source.length;i++){

            int r =(int)(Math.random()*100);
            source[i]= r ;}
            System.out.println("До шифровки " + Arrays.toString(source));

            for (int j = 0; j <source.length ; j++) {

            source[j] =source[j]^ key [ j % key.length ];
             }
            System.out.println("После после шифровки " + Arrays.toString(source) );

        for (int j = 0; j <source.length ; j++) {

            source[j] =source[j]^key [ j % key.length ];
        }
            System.out.println("После после ДЕшифровки " + Arrays.toString(source) );

        System.out.println((5% key.length));


    }


    //public void crypto(int[],int[]){

        //int j;
       // a[j]=a[j]^b[j%b.length];
    }


//}
