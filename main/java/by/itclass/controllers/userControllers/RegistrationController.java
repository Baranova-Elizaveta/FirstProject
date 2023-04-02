package by.itclass.controllers.userControllers;


import by.itclass.constants.AppConstant;
import by.itclass.controllers.userControllers.AbstractUserController;
import by.itclass.model.beans.Image;
import by.itclass.model.beans.User;
import by.itclass.model.enums.ImageAction;
import by.itclass.model.utils.ImageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegistrationController", value = AppConstant.REGISTRATION_CONT_URL)
public class RegistrationController extends AbstractUserController {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(AppConstant.LOGIN_LABEL);
        String password = request.getParameter(AppConstant.PASSWORD_LABEL);
        String email = request.getParameter(AppConstant.EMAIL_LABEL);

        //Создание бизнес объекта модели для дальнейшей возможности работы с ним
        User user = new User(login, email);

        //Выполняем обращние к модели и говорим что нам нужно сделать
        boolean isRegistration = userDAO.registration(user, password);

        //Опделеяем дальнейшую логику обработки запроса
        if (isRegistration) {
            //Основной сценарий обработки запроса
            //Объект класса HttpSession позволяет помнить пользователя
            //в рамках некоторого времени(по умолчанию 30 мин)
            //и хранить информацию о действиях пользователя
            //в течении этого времени
            Image image = ImageUtil.getImage(getServletContext().getRealPath(AppConstant.IMAGE_FOLDER_NAME), AppConstant.DEFAULT_USER_IMAGE_NAME);
            user.setImage(image);
            userDAO.saveImage(user, ImageAction.SAVE);
            HttpSession session = request.getSession();
            session.setAttribute(AppConstant.USER_ATTR, user);

            //Любое действие пользователя, которое изменяет модель(изменят
            //данные в БД) должно заканчиваться методом redirect()
            redirect(response, AppConstant.CABINET_JSP);
        } else {
            //Альтернативный сценарий обработки запроса
            forward(request, response, AppConstant.REG_JSP, AppConstant.NOT_USER_REGISTRATION_MESSAGE);
        }
    }
}
