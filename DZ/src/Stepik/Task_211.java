package Stepik;
/*Напишите метод, читающий входной поток и вычисляющий контрольную сумму прочитанных данных.

Контрольная сумма данных вычисляется по следующему алгоритму:

Контрольная сумма представляет собой число типа int. Контрольная сумма пустого набора данных равна нулю.
Контрольная сумма непустого набора данных вычисляется по следующей рекуррентной формуле:
Cn+1=rotateLeft(Cn) xor bn+1Cn+1=rotateLeft(Cn) xor bn+1 , где CnCn — контрольная сумма первых n байт данных,
rotateLeft — циклический сдвиг бит числа на один бит влево (чтобы не изобретать велосипед,
используйте Integer.rotateLeft), bnbn — n-ный байт данных.
Поскольку метод не открывал данный InputStream, то и закрывать его он не должен.
Выброшенное из методов InputStream исключение должно выбрасываться из метода.

    Пример
На вход подан InputStream, последовательно возвращающий три байта: 0x33 0x45 0x01.
В качестве контрольной суммы должно быть возвращено число 71.
*/

import java.io.*;

public class Task_211

{
    public static void main(String[] args) {

        int x = 0x33; // 51 // 110011 // after rotateLeft()  1100110
        int y = 0x45; // 69 // 1000101 // after rotateLeft()  10001010
        int z = 0x01; // 1  // 1 // after rotateLeft()  10

        // ---------71 = 1000111
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.parseInt(Integer.toBinaryString(Integer.rotateLeft(x, 1))));

        byte[] arr1 = {0x33, 0x45, 0x01};
        byte [] arr = {10, 20, 30, 50, 1, 125};

        InputStream inputStream = new ByteArrayInputStream(arr);

        try {
            System.out.println(checkSumOfStream(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


        public static int checkSumOfStream(InputStream inputStream) throws IOException {
             int x=0;

            byte [] data = new byte[8];
            int blockSize;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            while ((blockSize = inputStream.read(data))!=-1)
                outputStream.write(data, 0, blockSize);

                byte [] result = outputStream.toByteArray();

                for(int i =0;i<result.length;i++) {
                    x = Integer.rotateLeft(x, 1) ^ Byte.toUnsignedInt(result[i]);
                }

                return x;
        }

    }
