package org.example;

/**Основной класс*/
public class Main {

    public static void main(String[] args) {
        Note note = new Note("Hello world!");
        Writer writer = new Writer();

        for (String path: args) {
            writer.addNoteToFile(path, note.toString());
        }
    }
}