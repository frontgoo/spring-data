package org.frontgoo.springdata.test.objectpool;

import org.apache.commons.pool2.ObjectPool;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * Created by sunny on 16-2-23.
 */
public class ReadUtil {

    private static  ObjectPool<StringBuffer> pool;

    public ReadUtil(ObjectPool<StringBuffer> pool) {
        this.pool = pool;
    }

    /**
     * Dumps the contents of the {@link Reader} to a String, closing the {@link Reader} when done.
     */
    public static String readToString(Reader in)
            throws IOException {
        StringBuffer buf = null;
        try {
            buf = pool.borrowObject();
            for (int c = in.read(); c != -1; c = in.read()) {
                buf.append((char) c);
            }
            return buf.toString();
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Unable to borrow buffer from pool" + e.toString());
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                // ignored
            }
            try {
                if (null != buf) {
                    pool.returnObject(buf);
                }
            } catch (Exception e) {
                // ignored
            }
        }
    }

    public static void main(String args[]) throws IOException {
        StringReader stringReader = new StringReader("1234567");
        ReadUtil.readToString(stringReader);
        System.out.println(pool.getNumActive());
        System.out.println(pool.getNumIdle());
    }
}
