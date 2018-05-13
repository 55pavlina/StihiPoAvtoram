package stihi.dal;

import java.util.Date;
import java.util.List;
import stihi.model.Stihi;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * Тестирование класса StihiDal.java
 */
public class StihiDalTest {

    public StihiDalTest() {
    }


    /*
     * Тест SelectAll(), который должен вернуть все стихи из БД
     */
    @Test
    public void testSelectAll() {
        StihiDal instance = new StihiDal(); // Создаем сам объект класса Dal
        // Создаем лист, куда заносятся результаты функции selectAll(), т.е. объекты класса Stihi.java
        List<Stihi> result = instance.selectAll();
        // Тест пройден, если результат не равен null и размер листа стал больше 0
        assertTrue(result != null && result.size() > 0);
        // Вывод для каждого элемента листа функции toString()(она в классе Stihi.java).
        // в функции листа .forEach() используется лямбда выражение. Пример https://www.mkyong.com/java8/java-8-foreach-examples/
        result.forEach(x -> System.out.println(x.toString()));

    }

    /*
     * Тест SelectById(), который должен вернуть стих по id
     */
    @Test
    public void testSelectById() {
        int id = 1; // id стихотворения
        StihiDal instance = new StihiDal(); // создаем объект StihiDal
        /*
         * selectById(id) возвращает объект Stihi по id( получает из БД и 
         * при помощи маппера stihi.xml конвертирует в объект класса Stihi)
         */
        Stihi result = instance.selectById(id);
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
        StihiDal dal = new StihiDal();// создание объекта StihiDal
        
        /**
         * Тест Insert в таблицу stihi
         */
        //Создание нового объекта Stihi 
        Stihi stih = new Stihi(12,"title","fullDescription", new Date(2017, 9, 25), 5); 
        // Переменная INSERT показывает количество добавленных строк в таблицу stihi
        // dal.insert(X) добавляет в таблицу данные объекта "X"
        int INSERT =  dal.insert(stih);
        //Проверка на INSERT == 1
        assertTrue(INSERT == 1);
        
        /**
         * Тест Update в таблицу stihi
         */
        stih = new Stihi(12,"UPDATE","UPDATE", new Date(2017, 9, 25), 5); // изменим объект        
        // Переменная UPDATE показывает количество обновленных строк в таблице stihi
        // dal.update(x) обновляет данные в таблице stihi объектом x с id = x.getID()
        int UPDATE =  dal.update(stih);
        //Проверка на DUPDATE == 1
        assertTrue(UPDATE == 1);
        
        /**
         * Тест DeleteById в таблице stihi
         */
        // Переменная DELETE показывает количество удаленных строк в таблице stihi(в данном случае либо 0, либо 1)
        // dal.deleteById(x) удаляет из таблицы stihi запись с id = x
        int DELETE =  dal.deleteById(12);
        //Проверка на DELETE == 1
        assertTrue(DELETE == 1);        
    }     
    
    /* Возвращает автоинкремент id в таблице stihi к 11:
     * ALTER TABLE stihi AUTO_INCREMENT = 11;
     */
}
