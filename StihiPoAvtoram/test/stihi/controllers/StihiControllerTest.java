package stihi.controllers;

import java.util.Date;
import java.util.List;
import stihi.model.Stihi;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * Тестирование класса StihiController.java
 */
public class StihiControllerTest {

    public StihiControllerTest() {
    }


    /*
     * Тест GetAllStihi(), который должен вернуть все стихи из БД
     */
    @Test
    public void testGetAllStihi() {
        StihiController instance = new  StihiController(); // Создаем сам объект класса StihiController
        // Создаем лист, куда заносятся результаты функции getAllStihi() из StihiController, т.е. объекты класса Stihi.java
        List<Stihi> result = instance.getAllStihi();
        // Тест пройден, если результат не равен null и размер листа стал больше 0
        assertTrue(result != null && result.size() > 0);
        // Вывод для каждого элемента листа функции toString()(она в классе Stihi.java).
        // в функции листа .forEach() используется лямбда выражение. Пример https://www.mkyong.com/java8/java-8-foreach-examples/
        result.forEach(x -> System.out.println(x.toString()));

    }

    /*
     * Тест getStihi(), который должен вернуть стих по id
     */
    @Test
    public void testGetStihi() {
        int id = 1; // id стихотворения
        StihiController instance = new StihiController(); // создаем объект StihiController
        /*
         * getStihi(id) возвращает объект Stihi по id( получает от слоя StihiDal)
         */
        Stihi result = instance.getStihi(id);
        // Тест пройден, если результат не равен null и id == 1
        assertTrue(result != null && result.getId() == 1);
    }

    /*
     * Тест testInsertUpdateDeleteById(), который должен последовательно:
     * 1) Добавить(insert) стих в БД;
     * 2) Обновить стих из п.1;
     * 3) Удалить его.
     */
    @Test
    public void testInsertUpdateDeleteById() {        
        StihiController controller = new StihiController();// создание объекта StihiController
        
        /**
         * Тест Insert в таблицу stihi
         */
        //Создание нового объекта Stihi 
        Stihi stih = new Stihi(12,"title","fullDescription", new Date(2017, 9, 25), 5); 
        // Переменная INSERT показывает количество добавленных строк в таблицу stihi
        // controller.insert(X) добавляет в таблицу данные объекта "X"
        int INSERT =  controller.insertStihi(stih);
        //Проверка на INSERT == 1
        assertTrue(INSERT == 1);
        
        /**
         * Тест Update в таблицу stihi
         */
        stih = new Stihi(12,"UPDATE","UPDATE", new Date(2017, 9, 25), 5); // изменим объект        
        // Переменная UPDATE показывает количество обновленных строк в таблице stihi
        // controller.update(x) обновляет данные в таблице stihi объектом x с id = x.getID()
        int UPDATE =  controller.updateStihi(stih);
        //Проверка на DUPDATE == 1
        assertTrue(UPDATE == 1);
        
        /**
         * Тест DeleteById в таблице stihi
         */
        // Переменная DELETE показывает количество удаленных строк в таблице stihi(в данном случае либо 0, либо 1)
        // controller.deleteById(x) удаляет из таблицы stihi запись с id = x
        int DELETE =  controller.deleteStihi(12);
        //Проверка на DELETE == 1
        assertTrue(DELETE == 1);        
    }     
    
    /* Возвращает автоинкремент id в таблице stihi к 11:
     * ALTER TABLE stihi AUTO_INCREMENT = 11;
     */
}
