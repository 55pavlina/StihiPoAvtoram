class AutorsController
{
    // все аналогично StihiController
// DATA  
    getAllAutorsController()
    {
        var service = new AutorsService();
        return service.getAllAutorsService();
    }
    
// VIEW
    getAllAutorsViewButtons()
    {
        var data = this.getAllAutorsController();
        var res = "";
        
        // onclick='autorClick(...) обрабатывается на самой странице html
        for (var i = 0; i < data.length; i++)
        {
            res += "<div class='row'><button type='button' onclick='autorClick(" + data[i].id_Autors + ")'     class='btn btn-default col-md-11 col-sm-11'>" + data[i].name + "</button></div>";
        }
        
        var element = document.getElementById("autors"); //находит элемент на странице с id = autors
        element.innerHTML = res; // вписывает туда строчку res
    }

}

