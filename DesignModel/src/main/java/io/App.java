package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        File file = new File("d:/io/folder-02/HelloWorld.java");
        try {
            FileReader reader = new FileReader(file);
            StringBuffer text = new StringBuffer();
            char[] b = new char[10];
            int x = 0;
            while ((x = reader.read(b)) != -1) {
                String l = new String(b);
                text.append(l);
            }
            System.out.println(b);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
