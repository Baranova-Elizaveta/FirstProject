package by.itclass.controllers.newsControllers;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.newsControllers.AbstractNewsController;
import by.itclass.model.beans.News;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteNewsController", value = AppConstant.DELETE_NEWS_CONT_URL)
public class DeleteNewsController extends AbstractNewsController {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter(AppConstant.ID_LABEL);
        int isNews = Integer.parseInt(id);

        News news = new News(isNews);

        newsDAO.delete(news);
        redirect(response, AppConstant.USER_LIST_NEWS_CONT_URL);
    }
}
