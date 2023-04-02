package by.itclass.controllers.newsControllers;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.newsControllers.AbstractNewsController;
import by.itclass.model.beans.News;
import by.itclass.model.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserListNewsController", value = AppConstant.USER_LIST_NEWS_CONT_URL)
public class UserListNewsController extends AbstractNewsController {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(AppConstant.USER_ATTR);

        List<News> newsList = newsDAO.getAllByIdUser(user);
        request.setAttribute(AppConstant.NEWS_LIST_ATTR,newsList);

        forward(request,response,AppConstant.MY_NEWS_JSP);
    }
}
