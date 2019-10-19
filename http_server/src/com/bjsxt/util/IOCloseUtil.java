package com.bjsxt.util;

import java.io.Closeable;
import java.io.IOException;

public class IOCloseUtil {
    public static void closeAll(Closeable...close){
        for (Closeable closeable:close){
            if (closeable != null){
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
