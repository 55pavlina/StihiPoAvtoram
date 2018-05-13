class StihiService {

    /* Класс отправляет GET запрос к серверу(согласно его api), и получает строку формата JSON.
     * Далее функция "JSON.parse(request.responseText)" создает из 
     *  json-строки массив данных с аналогичными названиями. 
     */

    getStihiByAutorIdService(id) {

        // GET-запрос к серверу, который получает все стихи определенного по id автора

        var request = new XMLHttpRequest(); // Объект XMLHttpRequest (или, сокращенно, XHR) дает возможность браузеру делать HTTP-запросы к серверу без перезагрузки страницы.
        request.open('GET', '/Stihi/getAutor?id=' + id, false); // открывает GET запрос и по какой ссылке обращаться, false - синхронный запрос(ждет загрузки данных)
        request.send(); // отправить запрос

        //если любой код, кроме 200, выводит ошибку
        if (request.status != 200)
        {
            alert(request.status + ': ' + request.statusText);
            return null;
        } else //иначе все ок
        {
            /* request.responseText - возвращает текст ответа; JSON.parse() - арсит полученную json строку в массив */
            var autor = JSON.parse(request.responseText); //получает автора по id(но у него внутри есть список его стихов)

            return autor.stihi; //возвращает массив стихов автора
        }
    }

    // стих по ID
    getStihById(id) {
        var request = new XMLHttpRequest();
        request.open('GET', '/Stihi/getStih?id=' + id, false);
        request.send();
        if (request.status != 200) {
            alert(request.status + ': ' + request.statusText);
            return null;
        } else {
            var stih = JSON.parse(request.responseText);            
            return stih;
        }
    }
}



