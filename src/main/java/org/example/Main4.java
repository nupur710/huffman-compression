package org.example;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Arrays;
import java.util.BitSet;

public class Main4 {

    public static void main(String[] args) throws IOException  {
        HuffmanCompression huffmanCompression= new HuffmanCompression();
        StringBuilder text= new StringBuilder();
        FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\Moby Dick.txt");
        BufferedReader br = new BufferedReader(file);
        int c= 0;
        while((c= br.read()) != -1) {
            text.append((char) c);
        }
        String compressed= huffmanCompression.compress(text.toString().toCharArray());
        char[] xy= huffmanCompression.decompress(compressed.toCharArray());
        BufferedWriter writer= new BufferedWriter(new FileWriter(System.getProperty("user.dir")+"\\src\\main\\resources\\Moby Dick Decoded.txt"));
        writer.write(xy);
        writer.close();
    }

}
