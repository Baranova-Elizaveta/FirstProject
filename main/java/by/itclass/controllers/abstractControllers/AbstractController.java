package by.itclass.controllers.abstractControllers;

import by.itclass.constants.AppConstant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AbstractController")
public abstract class AbstractController extends HttpServlet {
    //Делаем общую обработку запросав, передаваемых методами GET и POST
    //путем вызова в одном из методов do.. дургого метода do..
    //Тот метод, который вызваем , в нашем случае метод doPost()
    //будем реализовать в контроллерах наследниках
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void redirect(HttpServletResponse response, String url) throws IOException {
        //Для метода sendRedirect() необходимо указывать полный URL вместе с контекстом
        //Метод getContextPath() вернет название контекста (название папки на сервере
        //в которой лежит проект)
        //cripta.com/registration -
        //Название контекста - cripta.com
        //url - /registration
        response.sendRedirect(getServletContext().getContextPath() + url);
    }

    protected void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        request.getRequestDispatcher(url)
                .forward(request, response);
    }

    protected void forward(HttpServletRequest request, HttpServletResponse response, String url, String message) throws ServletException, IOException {
        request.setAttribute(AppConstant.MESSAGE_ATTR, message);
        forward(request, response, url);
    }
}
