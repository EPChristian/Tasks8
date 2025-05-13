package com.dmdev.streams;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class ReaderWriterFiles {

        public static void main(String[] args) throws IOException {
            InputStream input = new FileInputStream("input.txt");
            String outputFile = "output.txt";


            try (
                    Reader reader = new InputStreamReader(input, StandardCharsets.UTF_8);
                    Writer writer = new OutputStreamWriter(new FileOutputStream(outputFile), StandardCharsets.UTF_8);
            ) {
                int ch;
                while ((ch = reader.read()) != -1) {
                    writer.write(ch); // побуквенная копия
                    System.out.print((char) ch);
                }
                System.out.println(" Файл успешно скопирован.");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

}
