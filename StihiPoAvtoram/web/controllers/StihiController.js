class StihiController {

    /*Класс управляет полученными данными из сервиса StihiService*/
    

    // DATA
    // Создание функции с параметром id, которая создает объект StihiService и при помощи функции в нем и id, возвращает данные(стихи автора) 
    getStihiByAutorIdController(id) {
        var service = new StihiService(); //создает объект StihiService
        return service.getStihiByAutorIdService(id); //возвращает стихи
    }

    getStihByIdController(id) {        
        var service = new StihiService(); //создает объект StihiService
        
        return service.getStihById(id); //возвращает стих по id
    }

    //VIEW
    // Работа с полученными данными из Сервиса и вставка в страницу html
    getStihiByAutorIdViewList(id) {
        var data = this.getStihiByAutorIdController(id); //вызывает функцию этого класса getStihiByAutorIdController(id) и получает массив стихов автора
        var res = ""; // пустая строчная переменная

        // цикл по всем стихам массива data
        for (var i = 0; i < data.length; i++)
        {
            // записываем данные из массива по переменным
            var id = data[i].id;
            var title = data[i].title;
            var fullDescription = data[i].fullDescription;

            var date = new Date(data[i].date);// формат данных Date в js
            //массив для названия месяца
            var months = ['январь', 'февраль', 'март', 'апрель', 'май', 'июнь', 'июль', 'август', 'сентябрь', 'октябрь', 'ноябрь', 'декабрь'];

            var id_Autors = data[i].id_Autors;

            // оформляем html код в переменную res. date.getFullYear/getMonth() возвращают форматированную дату из милисек. months[] - возвращает название месяца 
            res += "<div onclick='stihiClick(" + id + ")' class='row onenews'>  " +
                    "<div class='jumbotron'>" +
                    "<h2>" + title + "</h2>" +
                    "<p>" + fullDescription.substr(0, 200) + "...</p>" +
                    "<p align='right' >" + date.getFullYear() + ", " + months[date.getMonth()] + "</p>" +
                    "</div>" +
                    "</div>";
        }
        var element = document.getElementById("stihi"); // находим на странице элемент с id = stihi
        element.innerHTML = res; // вставка туда строки res
    }


    //для отображения стихотворения на странице stihi.html
    getStihByIdViewList(id) {
        var data = this.getStihByIdController(id);
        var res = "";
        
        // записываем данные из массива по переменным
        var id = data.id;        
        var title = data.title;        
        var fullDescription = data.fullDescription;

        var date = new Date(data.date);// формат данных Date в js
        //массив для названия месяца
        var months = ['январь', 'февраль', 'март', 'апрель', 'май', 'июнь', 'июль', 'август', 'сентябрь', 'октябрь', 'ноябрь', 'декабрь'];

        var id_Autors = data.id_Autors;        

        // оформляем html код в переменную res. date.getFullYear/getMonth() возвращают форматированную дату из милисек. months[] - возвращает название месяца 
        res += "<div class='row onenews'>" +
                "<div class='jumbotron'>" +
                "<h2>" + title + "</h2>" +
                "<p>" + fullDescription+"</p>" +
                "<p align='right' >" + date.getFullYear() + ", " + months[date.getMonth()] + "</p>" +
                "</div>" +
                "</div>";
        
        
        var element = document.getElementById("oneStih"); // находим на странице элемент с id = stihi
        element.innerHTML = res; // вставка туда строки res



    }

}


