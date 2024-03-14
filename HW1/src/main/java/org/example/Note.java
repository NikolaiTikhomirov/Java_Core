package org.example;

import java.util.Date;
/**Класс создания заметки*/
public class Note {
    /**Поле время*/
    Date date;
    /**Поле текст заметки*/
    String message;

    /**Конструктор заметки*/
    public Note(String message){
        date = new Date();
        this.message = message;
    }

    /**Метод возвращающий данные заметки в виде строки*/
    @Override
    public String toString() {
        return date.toString() + " " + message;
    }
}
