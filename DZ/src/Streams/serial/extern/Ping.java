package Streams.serial.extern;

import java.io.*;

/**
 * Created by xmitya on 17.04.17.
 */
class Ping implements Externalizable, Command {
    transient int code;

    public Ping() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(code);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        code = in.readInt();
    }


    @Override
    public int getCode() {
        return code;
    }
}
