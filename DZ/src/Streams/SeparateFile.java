package Streams;

import java.io.*;

/**
 *
 */
public class SeparateFile {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Education_ITMO\\ITMO_2017\\Storage\\Фразы из советских фильмов.docx");
               // создаём объект указывающий на путь к файлу

        separator(file,"C:\\Education_ITMO\\ITMO_2017\\Storage\\temp\\part",2500);

    }
    //метод резделяющий файл на части
    public static void separator (File file,String pathOutput ,int size) throws IOException {
       try(InputStream fileInputStream = new FileInputStream(file)){

           byte[] buffer = new byte[size]; // создаём массив равный размеру, заданному в параметрах метода

            int length;
            int i =1;

           while ((length =fileInputStream.read(buffer))>0){

               try(OutputStream fileOutputStream = new FileOutputStream(pathOutput + i)){ //
                   fileOutputStream.write(buffer,0,length);
               } i ++;
           }


       }



    }

}
