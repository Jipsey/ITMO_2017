package MultiThread.chat;

import java.io.IOException;

public class StartServer {

    public static void main(String[] args) {
        try {
            startServer( "12345");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void startServer(String... string) throws IOException {

    ChatServer.main(string);

    }
}
