
package stihi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * Тестирование класса Autors.java
 * Создание и сравнение
 */
public class AutorsTest {
    
    public AutorsTest() {
    }
    

   /*
    * Тест правильности создания класса.
    * @Test задает функцию теста.
    * assertEquals(x, y) сравнивает параметры x и y.
    * Тест пройден, если параметры равны.
     */
    @Test
    public void testCreateAutors() {
        
            // Создание 2 объектов Stihi для добавления List<Stihi> в объект класса Autors
            Stihi stih1 = new Stihi(1, "title1", "fullDescription1", new Date(2017, 9, 25), 1);
            Stihi stih2 = new Stihi(2, "title2", "fullDescription2", new Date(2013, 9, 25), 2);
            // Создание List<Stihi> и добавления туда stih1, stih2
            List<Stihi> stihiList = new ArrayList<>();
            stihiList.add(stih1);
            stihiList.add(stih2);
            // Создание объекта класса Autors(1, "name", stihiList);
            Autors autors = new Autors(1, "name", stihiList);
            // // сравнивает параметры
            assertEquals(autors.getid_Autors(), 1);
            assertEquals(autors.getName(), "name");
            assertEquals(autors.getStihi(), stihiList);
    }
    /**
     * Тест проверки равенства и неравенства Category
     */
    @Test
    public void testEquals() {

             // Создание 2 объектов Stihi для добавления List<Stihi> в объект класса Autors
            Stihi stih1 = new Stihi(1, "title1", "fullDescription1", new Date(2017, 9, 25), 1);
            Stihi stih2 = new Stihi(2, "title2", "fullDescription2", new Date(2013, 9, 25), 2);
            // Создание List<Stihi> и добавления туда stih1, stih2
            List<Stihi> stihiList = new ArrayList<>();
            stihiList.add(stih1);
            stihiList.add(stih2);

            // Создание 3 объектов класса Autors
            Autors autors1 = new Autors(1, "name1", stihiList);
            Autors autors2 = new Autors(1, "name1", stihiList);
            Autors autors3 = new Autors(1, "name2", stihiList);
            
            // Сравнение объектов autors1, autors2, autors3
            assertTrue(autors1.equals(autors2)); // тест пройден, если autors1 == autors2;
            assertFalse(autors1.equals(autors3)); // тест пройден, если autors1 == autors3;
    }  
    
}
