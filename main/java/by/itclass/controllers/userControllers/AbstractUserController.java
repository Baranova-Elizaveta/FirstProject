package by.itclass.controllers.userControllers;

import by.itclass.controllers.abstractControllers.AbstractController;
import by.itclass.model.dao.UserDAO;

import javax.servlet.annotation.WebServlet;

//Этот контроллер будет задавать общее описание и поведение
//все другим контроллерам, которые работают с бизнес-объектом User нашей модели
@WebServlet(name = "AbstractUserController")
public abstract class AbstractUserController extends AbstractController {
    protected UserDAO userDAO;

    public AbstractUserController() {
        userDAO = new UserDAO();
    }
}
