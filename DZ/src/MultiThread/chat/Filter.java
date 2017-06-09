package MultiThread.chat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Filter {
    private static List<String> durtyWords = new ArrayList<>();

    public Filter(String filePath) throws IOException {
        File file = new File(filePath);
        List<String> lines = Files.readAllLines(file.toPath());
        for (String line : lines) {

            String[] temp = line.toLowerCase().replaceAll("\\p{Punct}", " ").trim().split("\\s");

            for (String s : temp) {

                if (s.length() > 0)
                    durtyWords.add(s.trim());

            }
        }
    }

    public static String doFilter(String stringMessage) throws IOException {

        if(durtyWords.contains(stringMessage.toLowerCase()))
        {
            StringBuilder sb = new StringBuilder();
            for(int i =0;i<stringMessage.length();i++){
                sb.append("*");
            }   return stringMessage = sb.toString(); }

        return stringMessage;
    }
}
