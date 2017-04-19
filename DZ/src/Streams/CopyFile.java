package Streams;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Екатерина\\Downloads\\Гербердт Шилдт, Руководсво для начинающих.pdf");
        copyFile(file, "C:\\Users\\Екатерина\\Downloads\\COPY777.pdf");
    }

    public static void copyFile (File file, String path) throws IOException {
        try (FileInputStream inp = new FileInputStream(file);
             FileOutputStream outp = new FileOutputStream(path)) {

            byte[] buffer = new byte[256];

            int length;
            while ((length = inp.read(buffer)) > 0)
                outp.write(buffer, 0, length);
        }
    }
}