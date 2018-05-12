package stihi.model;

import java.util.Date;
import java.util.Objects;


public class Stihi 
{
    // поля класса - хранят данные
    private int id;
    private String title;    
    private String fullDescription;
    private Date date;
    private int id_Autors;
    
    // конструктор без параметрами
    public Stihi() {
    }
    
    // конструктор с параметрами, т.к. у параметров полностью такие же названия, 
    // то нужно указать слово this(принадлежит этому объекту)
    public Stihi(int id, String title, String fullDescription, Date date, int id_Autors) {
        this.id = id;
        this.title = title;        
        this.fullDescription =  fullDescription;
        this.date = date;
        this.id_Autors = id_Autors;
    }

    // геттеры -  функции, которые получают значение полей объекта
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public Date getDate() {
        return date;
    }
    
    public int getId_Autors() {
        return id_Autors;
    }
    
    //сеттеры - устанавливают значения полей объекта(через параметр)

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setId_Autors(int id_Autors) {
        this.id_Autors = id_Autors;
    }

    /* переопределение метода hashCode(), который возвращает уникальное
    * битовую строку фиксированной длины объекта. Одинаковые объекты содержат равные строки
    * подробнее: https://habrahabr.ru/post/168195/
    */
    @Override //Метод, аннотированный как @Override, должен переопределять метод супер класса
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.title);        
        hash = 41 * hash + Objects.hashCode(this.fullDescription);
        hash = 41 * hash + Objects.hashCode(this.date);
        hash = 41 * hash + this.id_Autors;
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
        final Stihi other = (Stihi) obj; 
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.fullDescription, other.fullDescription)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (this.id_Autors != other.id_Autors) {
            return false;
        }
        
        return true;
    }

    // Переопределение метода toString() в более удобный формат
    @Override
    public String toString() {
        return "Stihi{" + "id=" + id + ", title=" + title + ", fullDescription=" + fullDescription + ", date=" + date + ", id_Autors=" + id_Autors + '}';
    }
}

