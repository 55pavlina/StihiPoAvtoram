package stihi.model;


import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;


/*
* Тестирование класса Stihi.java
* Создание и сравнение
 */
public class StihiTest {

    public StihiTest() {
    }

    /*
    * Тест правильности создания  класса.
    * @Test задает функцию теста.
    * assertEquals(x, y) сравнивает параметры x и y.
    * Тест пройден, если параметры равны.
     */
    @Test
    public void testCreateStihi() {

        // Создание объекта класса Stihi
        Stihi stih = new Stihi(1, "title", "fullDescription", new Date(2017, 9, 25), 1);
        // сравнивает параметры
        assertEquals(stih.getId(), 1);
        assertEquals(stih.getTitle(), "title");
        assertEquals(stih.getFullDescription(), "fullDescription");
        assertEquals(stih.getDate(), new Date(2017, 9, 25));
        assertEquals(stih.getId_Autors(), 1);
    }

    /*
     *
     * Тест сравнения объектов класса Stihi
     */
    @Test
    public void testEquals() {
        // Создание 3 объектов: stih1 == stih2, stih1 != stih3
        Stihi stih1 = new Stihi(1, "title", "fullDescription", new Date(2017, 9, 25), 1);
        Stihi stih2 = new Stihi(1, "title", "fullDescription", new Date(2017, 9, 25), 1);
        Stihi stih3 = new Stihi(2, "title2", "fullDescription2", new Date(2017, 9, 27), 2);
        //.equals() - функция в классе Stihi переопределена
        assertTrue(stih1.equals(stih2)); // тест пройден, если stih1 == stih2;
        assertFalse(stih1.equals(stih3)); // тест пройден, если stih1 != stih3
    }

}
