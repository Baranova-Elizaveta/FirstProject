package by.itclass.controllers.newsControllers;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.newsControllers.AbstractNewsController;
import by.itclass.model.beans.News;
import by.itclass.model.enums.NewsAction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetNewsController", value = AppConstant.GET_NEWS_CONT_URL)
public class GetNewsController extends AbstractNewsController {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Параметр action будет хранить название действия, которые мы собираемся выполнять над новостью
        String action = request.getParameter(AppConstant.ACTION_LABEL);
        String id = request.getParameter(AppConstant.ID_LABEL);
        int idNews = Integer.parseInt(id);
        NewsAction newsAction = NewsAction.valueOf(action.toUpperCase());

        News news = newsDAO.getById(idNews);

        request.setAttribute(AppConstant.NEWS_ATTR, news);
        if(newsAction == NewsAction.VIEW){
            forward(request,response,AppConstant.VIEW_NEWS_JSP);
        }else if(newsAction == NewsAction.EDIT){
            forward(request,response,AppConstant.EDIT_NEWS_JSP);
        }
    }
}
