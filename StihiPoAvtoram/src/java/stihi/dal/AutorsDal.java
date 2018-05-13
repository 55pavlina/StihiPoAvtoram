package stihi.dal;

import java.util.List;
import stihi.model.Autors;
import org.apache.ibatis.session.SqlSession;

public class AutorsDal extends BaseDal {

    /* 
        <класс наследуется от BaseDal, получая возможность создавать sql сессии>
        Сам класс преобразует данные из БД в объекты класса(модели) при помощи мапперов и библиотеки mybatis(my batis использует чужой connector к БД mysql-connector-java-5.1.23-bin.jar)
        Мапперы - (как шаблоны) показывают каким образом переводить сущности(связанные строки) из БД в объекты модели.
        А прослойка DAL уже преобразует, используя мапперы.
    */
    
    public AutorsDal() {
        // super() может использоваться в конструкторе для вызова конструктора 
        //родительского класса. Т.е. наследует создание фабрики sql-сессий
        super();
    }

    public List<Autors> selectAll() {
        // Создает и открывает sql сессию(подключение к бд) при помощи фабрики sqlSessionFactory
        SqlSession session = sqlSessionFactory.openSession();
        /* 
         * В лист<Autors> загружаются все авторы из таблицы. При помощи xml мапперов,
         * переводятся данные из сущностей БД(строка и связанные с ней строки) в данные 
         * модели Autors.java. Используются функции из того маппера autors.xml
         */
        List<Autors> list = session.selectList("autors.selectAll");
        session.close(); // закрывает sql сессию
        return list;
    }

    /* Выбор автора по id */
    public Autors selectById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        Autors autors = session.selectOne("autors.selectById", id);
        session.close();
        return autors;
    }

    /* Удаление автора по id */
    public int deleteById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.delete("autors.deleteById", id);
        session.commit(); // фиксация изменения в БД
        session.close();
        return count;
    }

    /* Ввод автора по передаваемому объекту */
    public int insert(Autors autors) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.insert("autors.insert", autors);
        session.commit();
        session.close();
        return count;
    }

    /* Обновление автора по передаваемому объекту */
    public int update(Autors autors) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.update("autors.update", autors);
        session.commit();
        session.close();
        return count;
    }
}
