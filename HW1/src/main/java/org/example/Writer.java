package org.example;

import java.io.FileWriter;
import java.io.IOException;

/**Класс записи данных в файл*/
public class Writer {

    /**Метод записи данных в файл*/
    void addNoteToFile (String path, String text){
        try(FileWriter writer = new FileWriter(path, true))
        {
            writer.write(text + '\n');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
