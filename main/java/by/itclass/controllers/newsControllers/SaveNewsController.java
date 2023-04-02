package by.itclass.controllers.newsControllers;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.newsControllers.AbstractNewsController;
import by.itclass.model.beans.News;
import by.itclass.model.beans.User;
import by.itclass.model.enums.NewsAction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SaveNewsController", value = AppConstant.SAVE_NEWS_CONT_URL)
public class SaveNewsController extends AbstractNewsController {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter(AppConstant.ID_LABEL);
        String title = request.getParameter(AppConstant.TITLE_LABEL);
        String text = request.getParameter(AppConstant.TEXT_LABEL);
        News news = null;
        NewsAction action = null;

        if(id != null){
            int idNews = Integer.parseInt(id);
            news = new News(idNews,title,text);
            action = NewsAction.EDIT;

        }else{
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(AppConstant.USER_ATTR);
            news = new News(title,text,user);
            action = NewsAction.ADD;
        }

        boolean isSave = newsDAO.save(news, action);

        if(isSave){
            redirect(response, AppConstant.USER_LIST_NEWS_CONT_URL);
        }else{
            request.setAttribute(AppConstant.MESSAGE_ATTR, AppConstant.NOT_UPDATE_NEWS_MESSAGE);
            request.setAttribute(AppConstant.NEWS_ATTR, news);
        }
    }
}
