package stihi.dal;

import java.util.List;
import stihi.model.Stihi;
import org.apache.ibatis.session.SqlSession;

public class StihiDal extends BaseDal {

    public StihiDal() {
        // super() может использоваться в конструкторе для вызова конструктора 
        //родительского класса. Т.е. наследует создание фабрики sql-сессий
        super();
    }

    public List<Stihi> selectAll() {
        // Создает и открывает sql сессию(подключение к бд) при помощи фабрики sqlSessionFactory
        SqlSession session = sqlSessionFactory.openSession();

        /* 
       * В лист<Stihi> загружаются все стихи из таблицы. При помощи xml мапперов,
       * переводятся данные из сущностей БД(строка и связанные с ней строки) в данные 
       * модели Stihi.java. Используются функции из того маппера stihi.xml
         */
        List<Stihi> list = session.selectList("stihi.selectAll");
        // закрывает сессии
        session.close();
        // возвращает List<Stihi> list
        return list;
    }

    /* Выбор стихотворения по id */
    public Stihi selectById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        Stihi stihi = session.selectOne("stihi.selectById", id);
        session.close();
        return stihi;
    }

    /* Удаления стихотворения по id */
    public int deleteById(int id) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.delete("stihi.deleteById", id);
        session.commit(); // принять изменение
        session.close();
        return count; // возвращает количество удаленных данных
    }

    /* Ввод стихотворения по передаваемому объекту */
    public int insert(Stihi stihi) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.insert("stihi.insert", stihi);
        session.commit();
        session.close();
        return count; // возвращает количество введеных данных
    }

    /* Обновление стихотворения по передаваемому объекту */
    public int update(Stihi stihi) {
        SqlSession session = sqlSessionFactory.openSession();
        int count = session.update("stihi.update", stihi);
        session.commit();
        session.close();
        return count; // возвращает количество измененных данных
    }
}
