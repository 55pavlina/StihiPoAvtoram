package stihi.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jsonMappers.JsonAutorsMapper;
import stihi.controllers.AutorsController;
import stihi.model.Autors;

/* Сервлет является интерфейсом Java, реализация которого расширяет
 * функциональные возможности сервера. Сервлет взаимодействует с клиентами 
 * посредством принципа запрос-ответ. Есть Get(мало данных посылаешь, много получаешь) и Post запрос (наоборот)
 */

@WebServlet(name = "getAllAutors", urlPatterns = {"/getAllAutors"}) // если кто-то обращается по ссылке http://localhost:8084/Stihi/getAllAutors, то это обрабатывает сервлет
public class getAllAutors extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // request - принимаемый запрос(вбиваемая ссылка в браузере с GET параметрами), response - ответ сервера на основе полученных get параметров(ниже)
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // устанавливает тип контента, который возвращает сервлет и его кодировку
        try (PrintWriter out = response.getWriter()) //вывод
        {

            AutorsController autorController = new AutorsController();// создает объект КОНТРОЛЛЕР AutorsController()
            List<Autors> stihi = autorController.getAllAutors(); // при помощи контроллера записывает в в лист stihi полученные от DAL объекты
            String json = JsonAutorsMapper.toJson(stihi); // переводит в строковый формат json
            out.println(json); // выводит строку формата json
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
