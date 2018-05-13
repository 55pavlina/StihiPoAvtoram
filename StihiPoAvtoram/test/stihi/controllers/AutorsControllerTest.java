package stihi.controllers;

import java.util.ArrayList;
import java.util.List;
import stihi.model.Autors;
import org.junit.Test;
import static org.junit.Assert.*;
import stihi.model.Stihi;

/*
 * Тестирование класса AutorsController.java
 */
public class AutorsControllerTest {
    
    public AutorsControllerTest() {
    }
    
    /*
     * Тест testGetAllAutors(), который должен вернуть всех авторов из БД
     */
    
    @Test
    public void testGetAllAutors() {
        
        AutorsController instance = new AutorsController(); // создание объекта AutorsController
         // Создаем лист, куда заносятся результаты функции getAllAutors(), т.е. объекты класса Autors.java
        List<Autors> result = instance.getAllAutors();
        // Тест пройден, если результат не равен null и размер листа стал больше 0
        assertTrue(result!=null && result.size()>0);

    }

     /*
     * Тест getAutors(id_Autor), который должен автора по id из БД
     */
     @Test
    public void testGetAutors() {       
        int id_Autor = 2; // задаем любое id автора
        AutorsController instance = new AutorsController(); // создание объекта AutorsController
        
         /*
         * getAutors(id_Autor) возвращает объект Autors по id( получает из БД
         * при помощи слоя DAL)
         */
        Autors result = instance.getAutor(id_Autor);
        System.out.println(result.toString()); // вывести результат
        assertTrue(result!=null && result.getid_Autors()==2); // Тест пройден, если результат не равен null и id_Autors() == 2
    }
    
    
    /*
     * Тест testInsertUpdateDeleteById(), который должен последовательно:
     * 1) Добавить(insert) автора в БД;
     * 2) Обновить автора из п.1;
     * 3) Удалить его.
     */
    @Test
    public void testInsertUpdateDeleteById() {        
        AutorsController controller = new AutorsController();// создание объекта AutorsController
        
        /**
         * Тест insertAutors() в таблицу autors
         */
        //Создание нового объекта Autors 
        List<Stihi> stihiList = new ArrayList<>(); // заглушка
        Autors autor = new Autors(11,"С. Маршак", stihiList); 
        // Переменная INSERT показывает количество добавленных строк в таблицу autors
        // controller.insertAutors(X) добавляет в таблицу данные объекта "X"
        int INSERT =  controller.insertAutors(autor);
        //Проверка на INSERT == 1
        assertTrue(INSERT == 1);
        
        /**
         * Тест updateAutors в таблицу  autors
         */
        autor = new Autors(11,"В. Маяковский", stihiList);  // изменим объект        
        // Переменная UPDATE показывает количество обновленных строк в таблице autors
        // controller.updateAutors(x) обновляет данные в таблице  autors объектом x с id = x.getID()
        int UPDATE =  controller.updateAutors(autor);
        //Проверка на DUPDATE == 1
        assertTrue(UPDATE == 1);
        
        /**
         * Тест deleteAutors в таблице autors
         */
        // Переменная DELETE показывает количество удаленных строк в таблице autors(в данном случае либо 0, либо 1)
        // controller.deleteAutors(x) удаляет из таблицы autors запись с id = x
        int DELETE =  controller.deleteAutors(11);
        //Проверка на DELETE == 1
        assertTrue(DELETE == 1);        
    }     
    
    /* Возвращает автоинкремент id в таблице autors к 10:
     * ALTER TABLE autors AUTO_INCREMENT = 10;
     */
}
