package Stepik;

import java.util.Arrays;

public class Task_358 {
    public static void main(String[] args) {

       String str = "Hello!";
       AsciiCharSequence acs = new AsciiCharSequence(str.getBytes());
        System.out.println(acs.length());
        System.out.println(acs.charAt(1));
        System.out.println(acs.subSequence(2,5));


    }

    public static class AsciiCharSequence implements CharSequence {
        byte[] arrByte;

        public AsciiCharSequence(byte[] arrByte){
         this.arrByte =arrByte;
        }

        @Override
        public int length() {
            int x = arrByte.length;
            return x;
        }

        @Override
        public char charAt(int index) {
             char ch = (char)arrByte[index];
             return ch;
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            byte[] arr = new byte[end-start];
            for (int i=0;i<arr.length;i++){
                arr[i] = arrByte[i+start];
            }
           return new AsciiCharSequence(arr);

        }


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<arrByte.length;i++){
              sb.append(Character.toChars(arrByte[i]));
            }
            return sb.toString();
        }
    }

}
