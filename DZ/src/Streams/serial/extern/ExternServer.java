package Streams.serial.extern;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xmitya on 17.04.17.
 */
public class ExternServer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket ssocket = new ServerSocket(12345);

        while (true) {
            Socket socket = ssocket.accept();

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            Object object = new ObjectInputStream(in).readObject();

            if (object instanceof Command) {
                switch (((Command)object).getCode()) {
                    case 1:
                        Ping p = (Ping) object;
                        break;
                }


                Ping ping = (Ping) object;

                System.out.println("Server: received code: " + ping.code);

                ping.code = 2;

                ObjectOutputStream objOut = new ObjectOutputStream(out);

                objOut.writeObject(ping);
                objOut.flush();
            }
        }

    }

}
