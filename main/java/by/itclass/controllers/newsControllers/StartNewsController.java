package by.itclass.controllers.newsControllers;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.newsControllers.AbstractNewsController;
import by.itclass.model.beans.News;
import by.itclass.model.enums.NewsAction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StartNewsController", value = AppConstant.START_NEWS_CONT_URL)
public class StartNewsController extends AbstractNewsController {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<News> newsListSorted = newsDAO.news(NewsAction.SORTED);
        List<News> newsListTop = newsDAO.news(NewsAction.TOP);

        request.setAttribute(AppConstant.NEWS_LIST_ATTR, newsListSorted);
        request.setAttribute(AppConstant.NEWS_LIST_TOP_ATTR, newsListTop);
        forward(request, response, AppConstant.INDEX_JSP);
    }
}
