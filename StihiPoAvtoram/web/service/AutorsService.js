class AutorsService
{
    
    /* Класс отправляет GET запрос к серверу(согласно его api), и получает строку формата JSON.
     * Далее функция "JSON.parse(request.responseText)" создает из 
     *  json-строки массив данных с аналогичными названиями. 
     */
    
    // возвращает всех авторов
    getAllAutorsService() {
        // запрос к серверу GetAllAutors

        var request = new XMLHttpRequest(); // Объект XMLHttpRequest (или, сокращенно, XHR) дает возможность браузеру делать HTTP-запросы к серверу без перезагрузки страницы.
        request.open('GET', '/Stihi/getAllAutors', false); // открывает GET запрос и по какой ссылке обращаться, false - синхронный запрос(ждет загрузки данных)
        request.send(); // отправить запрос
       
       //если код 200, то все ок
        if (request.status == 200)
        {
            /* request.responseText - возвращает текст ответа; JSON.parse() - арсит полученную json строку в массив */
            var autors = JSON.parse(request.responseText);
            return autors;
        } 
        else //иначе выводит ошибку
        {
            alert(request.status + ': ' + request.statusText);
            return null;
        }
    }

    // возвращает автора по id
    getAutorByIdService(id) {
        
        // запрос к серверу /getAutor?id=3
        
        var request = new XMLHttpRequest();
        request.open('GET', '/Stihi/getAutor?id=' + id, false);
        request.send();
        if (request.status == 200)
        {            
            var autor = JSON.parse(request.responseText);
            return autor;  
        } else
        {
            alert(request.status + ': ' + request.statusText);
            return null;
        }
    }


    getStihiByAutorId(id) {
        var autor = this.getAutorByIdService(id);
        return autor.stihi;
    }

}



