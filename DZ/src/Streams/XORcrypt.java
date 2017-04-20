package Streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 */
public class XORcrypt {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Education_ITMO\\ITMO_2017\\Storage\\Саша+Катя.jpg");
        cryptFile(file, "ITMO","C:\\Education_ITMO\\ITMO_2017\\Storage\\CryptedFile.jpg");

        File file2 = new File("C:\\Education_ITMO\\ITMO_2017\\Storage\\CryptedFile.jpg");
        cryptFile(file2, "ITMO","C:\\Education_ITMO\\ITMO_2017\\Storage\\UnCryptedFile.jpg");

    }

    public static byte[] crypt(byte[] b,byte[] key){
       for (int i =0; i<b.length; i++){
           b[i]=(byte)(b[i]^key[i%key.length]);
       } return b;


    }
   public static void cryptFile (File file,String key,String path) throws IOException{
       try (FileInputStream inp = new FileInputStream(file);
            FileOutputStream outp = new FileOutputStream(path)){


            byte[] buffer = new byte[512];
            byte[] byteKey =key.getBytes(); // переводим стрингвое значение key в массив байтов

            int length;

            while ((length=inp.read(buffer))>0){
                  outp.write(crypt(buffer,byteKey),0,length); //кодируем исходящий поток байтов
            }
       }
   }


   public static long timer(Runnable runnable){
        long startTime = System.currentTimeMillis();
        runnable.run();
        return System.currentTimeMillis() - startTime;
   }
}
