package Streams.serial.extern;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by xmitya on 17.04.17.
 */
public class ExternClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket sock = new Socket();

        sock.connect(
                new InetSocketAddress(
                        "localhost", 12345));

        InputStream in = sock.getInputStream();
        OutputStream out = sock.getOutputStream();

        Ping ping = new Ping();

        ping.code = 1;

        ObjectOutputStream objOut = new ObjectOutputStream(out);

        objOut.writeObject(ping);
        objOut.flush();

        Object object = new ObjectInputStream(in).readObject();

        if (object instanceof Ping) {
            System.out.println("Client: " + ((Ping) object).code);
        }
    }
}
