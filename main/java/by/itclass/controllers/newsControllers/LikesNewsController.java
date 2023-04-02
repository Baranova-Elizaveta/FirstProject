package by.itclass.controllers.newsControllers;

import by.itclass.constants.AppConstant;
import by.itclass.model.beans.News;
import by.itclass.model.beans.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LikesNewsController", value = AppConstant.LIKE_NEWS_CONT_URL)
public class LikesNewsController extends AbstractNewsController {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter(AppConstant.ID_LABEL);
        int idNews = Integer.parseInt(id);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(AppConstant.USER_ATTR);
        News news = new News(idNews);


        if (newsDAO.isLike(news, user)) {
            newsDAO.disLike(news, user);
        } else {
            newsDAO.like(news, user);
        }
        forward(request,response,AppConstant.GET_NEWS_CONT_URL);

    }
}
