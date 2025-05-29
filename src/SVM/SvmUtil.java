package SVM;

import java.io.*;

public class SvmUtil {
    public static byte[] loadBytecodes(String filename) throws IOException {
        File file = new File(filename);
        byte[] bytecodes = new byte[(int) file.length()];
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(bytecodes);
        }
        return bytecodes;
    }
}
