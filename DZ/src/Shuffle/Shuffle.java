package Shuffle;
import java.util.ArrayList;

/**
 *
 */
public class Shuffle {
    public static void main(String[] args) {
        ArrayList<Integer> intAL = new ArrayList<>();
          for(int i = 0; i<20;i++ ){
        intAL.add(i);
    }

        System.out.println("----- исходный ArrayList -----");
        for(int i=0; i<intAL.size();i++) { System.out.println(intAL.get(i));}
        shuffle(intAL);
    }

    public static void shuffle(ArrayList <Integer> arrL){

        int i=0;
        while(i< arrL.size()) {
            int a = (int) (Math.random() * arrL.size());
                swap(arrL,a);
                i++;
        }

        System.out.println("----- перемешанный ArrayList -----");
        for(int j=0; j<arrL.size();j++) { System.out.println(arrL.get(j));}

    }

    private static void swap(ArrayList <Integer> arrL, int randomIndex) {

        int x = arrL.get(0);
        arrL.set(0,arrL.get(randomIndex));
        arrL.set(randomIndex,x);

}}
