package by.itclass.controllers.newsControllers;

import by.itclass.controllers.abstractControllers.AbstractController;
import by.itclass.model.dao.NewsDAO;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "AbstractNewsController")
public abstract class AbstractNewsController extends AbstractController {
    protected NewsDAO newsDAO;

    public AbstractNewsController() {
        newsDAO = new NewsDAO();
    }
}
