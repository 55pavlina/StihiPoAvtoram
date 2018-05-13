package stihi.controllers;

import java.util.List;
import stihi.dal.StihiDal;
import stihi.model.Stihi;

/*
* Прослойка контроллер взаимодействует с DAL и API.
* Позволяет работать с полученными объктами модели Stihi.java.
* Но здесь ничего не происходит.
*
*/

public class StihiController 
{
    protected StihiDal stihiDal; // Объявляется объект StihiDal

    // конструктор класса
    public StihiController() 
    {
        this.stihiDal = new StihiDal(); // Создается переменная
    }
    
    // Обертка к функции selectAll() 
    public List<Stihi> getAllStihi()
    {
        return stihiDal.selectAll(); // вызов функции объекта StihiDal, далее аналогично
    }
    
     // Обертка к функции selectById(id);
    public Stihi getStihi(int id)
    {
        return stihiDal.selectById(id);
    }
    // Обертка к функции insert(stihi);
    public int insertStihi(Stihi stihi)
    {
       return stihiDal.insert(stihi);
    }
     // Обертка к функции update(stihi);
    public int updateStihi(Stihi stihi)
    {
       return stihiDal.update(stihi);
    }
    // Обертка к функции deleteById(id);
    public int deleteStihi(int id)
    {
       return stihiDal.deleteById(id);
    }
}
