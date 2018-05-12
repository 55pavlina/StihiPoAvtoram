package stihi.model;

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

public class Autors 
{
    // поля класса - хранят данные
    private int id_Autors;
    private String name;
    private List<Stihi> stihi;
    
    
    // конструктор без параметрами
    public Autors() {
    }
    
    // конструктор с 3 параметрами, т.к. у параметров полностью такие же названия, 
    // то нужно указать слово this(принадлежит этому объекту)
    public Autors(int id_Autors,String name, List<Stihi> stihi) {
        this.id_Autors = id_Autors;
        this.name = name; 
        this.stihi = stihi;
    }
    
    // конструктор с 2 параметрами, кидаем пустой ArrayList<> в стихи
    public Autors(int id_Autors,String name) {
        this.id_Autors = id_Autors;
        this.name = name; 
        stihi = new ArrayList<>();
    }

    // геттеры -  функции, которые получают значение полей объекта
    public int getid_Autors() {
        return id_Autors;
    }

    public String getName() {
        return name;
    }
    
    public List<Stihi> getStihi() {
        return stihi;
    }

    //сеттеры - устанавливают значения полей объекта(через параметр)

    public void setId_Autors(int id_Autors) {
        this.id_Autors = id_Autors;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setStihi(List<Stihi> stihi) {
        this.stihi = stihi;
    }

    /* переопределение метода hashCode(), который возвращает уникальное
    * битовую строку фиксированной длины объекта. Одинаковые объекты содержат равные строки
    * подробнее: https://habrahabr.ru/post/168195/
    */
    @Override //Метод, аннотированный как @Override, должен переопределять метод супер класса
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id_Autors;
        hash = 41 * hash + Objects.hashCode(this.name);
        return hash;
    }

    /* переопределение метода equals(Object obj); 
    * Этот метод получает объект в качестве аргумента, выполняет сравнение 
    * и возвращает true, если два экземпляра объекта равны, 
    * и false в случае их неравенства.
    * 
    * метод equals по умолчанию сравнивает только адреса двух объектов, 
    * а не их содержимое. Чтобы сравнить содержимое двух объектов мы должны 
    * переопределить метод equals. 
    */
    @Override
    public boolean equals(Object obj) {
        // если этот объект(у которого вызвана функция) равен объекту с параметра
        if (this == obj) {
            return true;
        }
        // если переданный объект == null
        if (obj == null) {
            return false;
        }
        // если у сравниваемых объектов разные классы
        if (getClass() != obj.getClass()) {
            return false;
        }
        /* Просто сравнение всех полей у объектов
        * Переменные final не инициализируются по умолчанию, им необходимо явно присвоить 
        *значение при объявлении или в конструкторе, иначе – ошибка компиляции: 
        *(Stihi) - показывает с каким классом ассоциировать переданный объект
        */
        final Autors other = (Autors) obj; 
        if (this.id_Autors != other.id_Autors) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }        
        
        return true;
    }

    // Переопределение метода toString() в более удобный формат
    @Override
    public String toString() {
        return "Category{" + "id_Autors=" + id_Autors + ", name=" + name + ", stihi=" + stihi + '}';
    }
}

