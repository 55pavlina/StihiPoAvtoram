package stihi.dal;

import java.util.ArrayList;
import java.util.List;
import stihi.model.Autors;
import org.junit.Test;
import static org.junit.Assert.*;
import stihi.model.Stihi;

/*
 * Тестирование класса AutorsDal.java
 */
public class AutorsDalTest {
    
    public AutorsDalTest() {
    }
    
    /*
     * Тест SelectAll(), который должен вернуть всех авторов из БД
     */
    
    @Test
    public void testSelectAll() {
        
        AutorsDal instance = new AutorsDal(); // создание объекта AutorsDal
         // Создаем лист, куда заносятся результаты функции selectAll(), т.е. объекты класса Autors.java
        List<Autors> result = instance.selectAll();
        // Тест пройден, если результат не равен null и размер листа стал больше 0
        assertTrue(result!=null && result.size()>0);

    }

    /*
     * Тест selectById(id_Autor), который должен автора по id из БД
     */
     @Test
    public void testSelectById() {       
        int id_Autor = 2; // задаем любое id автора
        AutorsDal instance = new AutorsDal(); // создание объекта AutorsDal
        
         /*
         * selectById(id_Autor) возвращает объект Autors по id( получает из БД и 
         * при помощи маппера autors.xml конвертирует в объект класса Autors)
         */
        Autors result = instance.selectById(id_Autor);
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
        AutorsDal dal = new AutorsDal();// создание объекта AutorsDal
        
        /**
         * Тест Insert в таблицу autors
         */
        //Создание нового объекта Autors 
        List<Stihi> stihiList = new ArrayList<>(); // заглушка
        Autors autor = new Autors(11,"С. Маршак", stihiList); 
        // Переменная INSERT показывает количество добавленных строк в таблицу autors
        // dal.insert(X) добавляет в таблицу данные объекта "X"
        int INSERT =  dal.insert(autor);
        //Проверка на INSERT == 1
        assertTrue(INSERT == 1);
        
        /**
         * Тест Update в таблицу  autors
         */
        autor = new Autors(11,"В. Маяковский", stihiList);  // изменим объект        
        // Переменная UPDATE показывает количество обновленных строк в таблице autors
        // dal.update(x) обновляет данные в таблице  autors объектом x с id = x.getID()
        int UPDATE =  dal.update(autor);
        //Проверка на DUPDATE == 1
        assertTrue(UPDATE == 1);
        
        /**
         * Тест DeleteById в таблице autors
         */
        // Переменная DELETE показывает количество удаленных строк в таблице autors(в данном случае либо 0, либо 1)
        // dal.deleteById(x) удаляет из таблицы autors запись с id = x
        int DELETE =  dal.deleteById(11);
        //Проверка на DELETE == 1
        assertTrue(DELETE == 1);        
    }     
    
    /* Возвращает автоинкремент id в таблице autors к 10:
     * ALTER TABLE autors AUTO_INCREMENT = 10;
     */
}
