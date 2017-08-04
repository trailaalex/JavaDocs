package ro.teamnet.zerotohero.exceptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public class ExampleTryFinally {
    private static void printFile() throws IOException {
        InputStream input = null;

        try {
            input = new FileInputStream("file.txt");

            int data = input.read();
            while(data != -1){
                System.out.print((char) data);
                data = input.read();
            }
        } finally {
            if(input != null){
                input.close();
            }
        }
    }
}
