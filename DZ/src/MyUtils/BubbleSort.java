package MyUtils;

// метод сортировки пузырьком

import java.util.Arrays;

public class BubbleSort {

        int [] a1 =new int[7];

        int [] a2 =new int[6];


        public static void main(String[] args) {
            BubbleSort x = new BubbleSort();
            for(int i=0;i<x.a1.length;i++){
                x.a1[i]=RandmomMy.random(-10,10);
            }

            for(int i=0;i<x.a2.length;i++){
                x.a2[i]=RandmomMy.random(-10,10);
            }

            System.out.println(Arrays.toString(mergeArrays(x.a1,x.a2)));
        }

        public static int[] mergeArrays(int[] a1, int[] a2) {
            int j = 0;
            int arrSize = a1.length+a2.length;
            int[] arr = new int[arrSize];
            for (int i =0;i<arr.length;i++){
                if (i < a1.length){
                    arr[i] = a1[i];}
                else{arr[i] = a2[j++];}
            }


            int i=0;int cnt=0;
            while (i<=arr.length-1){

                if(arr[i] > arr[i+1] && arr[i] != arr[i+1]){
                    int x = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = x; cnt=0;
                }
                cnt++;
                i++;
                if(cnt == arr.length){break;}
                if(i == arr.length-1){i=0;}
            }

            return arr;
        }
    }