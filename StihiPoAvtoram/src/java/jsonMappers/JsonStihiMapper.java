
package jsonMappers;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper; //подрубается библиотека jackson
import stihi.model.Stihi;

/*Класс позволяет достаточно просто преобразовывать JSON в модель Stihi.java и наоборот*/
// Используется в сервлетах

public class JsonStihiMapper {
    
    // в json 1 объект ( на вход получает объект Stihi)
     public static String toJson(Stihi stih)   {
        try {
            ObjectMapper mapper = new ObjectMapper(); // создается объект ObjectMapper
            return mapper.writeValueAsString(stih); // возвращает строку json, созданную из объекта модели
        } 
        catch (IOException ex) // или возвращает исключение(ловит ошибку и выводит ее)
        {
            Logger.getLogger(JsonStihiMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
     // в json лист объектов ( на вход получает лист объектов Stihi)
     public static String toJson(List<Stihi> stihi)   {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(stihi);
        } catch (IOException ex) {
            Logger.getLogger(JsonStihiMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     // из json'a в объект (на вход получает строку json)
     public static Stihi fromJson(String json)   {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, Stihi.class); // читает json строку и преобразовывает ее в объект класса Stihi
        } catch (IOException ex) {
            Logger.getLogger(JsonStihiMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
