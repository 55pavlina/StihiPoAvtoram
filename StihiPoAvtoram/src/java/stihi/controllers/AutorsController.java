package stihi.controllers;

import java.util.List;
import stihi.dal.AutorsDal;
import stihi.model.Autors;

/*
* Прослойка контроллер взаимодействует с DAL и API.
* Позволяет работать с полученными объктами модели Autors.java.
* Смотри StihiController!
*
*/
public class AutorsController 
{
    protected AutorsDal autorsDal;

    public AutorsController () 
    {
        this.autorsDal = new AutorsDal();
    }
    
    public List<Autors> getAllAutors()
    {
        return autorsDal.selectAll();
    }
    
    public Autors getAutor(int id)
    {
        return autorsDal.selectById(id);
    }
    
    public int insertAutors(Autors autors)
    {
       return autorsDal.insert(autors);
    }
    
    public int updateAutors(Autors autors)
    {
       return autorsDal.update(autors);
    }
    
    public int deleteAutors(int id)
    {
       return autorsDal.deleteById(id);
    }
}
