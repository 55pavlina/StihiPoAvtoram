
package jsonMappers;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import stihi.model.Autors;

// аналогично классу JsonStihiMapper

public class JsonAutorsMapper {
    
     public static String toJson(Autors stih)   {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(stih);
        } catch (IOException ex) {
            Logger.getLogger(JsonAutorsMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public static String toJson(List<Autors> stihi)   {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(stihi);
        } catch (IOException ex) {
            Logger.getLogger(JsonAutorsMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public static Autors fromJson(String json)   {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, Autors.class);
        } catch (IOException ex) {
            Logger.getLogger(JsonAutorsMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
