package com.dmdev.streams;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class DirAndFile {

    public static boolean deleteRecursively(File file) {
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null) {
                for (File child : children) {
                    deleteRecursively(child);
                }
            }
        }
        return file.delete();
    }

        public static void main(String[] args) {

            File dir = new File("testDir");
            if (dir.mkdirs()) {
                System.out.println("Директория создана.");
            } else {
                System.out.println("Не удалось создать директорию или она уже существует.");
            }

            File file = new File("testDir/note.txt");

            try {
                if (file.createNewFile()) {
                    System.out.println("Файл создан: " + file.getName());
                } else {
                    System.out.println("Файл уже существует.");
                }

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                    writer.write("Привет, Костя!");
                    writer.newLine();
                    writer.write("Как дела?");
                    System.out.println("Текст успешно записан в файл.");
                }

            } catch (IOException e) {
                System.out.println("Произошла ошибка.");
                e.printStackTrace();
            }

            System.out.println("Относительный путь: " + file.getPath());
            System.out.println("Абсолютный путь: " + file.getAbsolutePath());

            if (deleteRecursively(dir)) {
                System.out.println("Папка и всё её содержимое удалены.");
            } else {
                System.out.println("Не удалось удалить папку.");
            }

        }

}
