package by.itclass.controllers.userControllers;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.userControllers.AbstractUserController;
import by.itclass.model.beans.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateCabinetController", value = AppConstant.UPDATE_CABINET_CONT_URL)
public class UpdateCabinetController extends AbstractUserController {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(AppConstant.LOGIN_LABEL);
        String email = request.getParameter(AppConstant.EMAIL_LABEL);
        String password = request.getParameter(AppConstant.PASSWORD_LABEL);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(AppConstant.USER_ATTR);

        User newUser = new User(user.getId(), login, email);

       if(userDAO.update(newUser, password)) {
           session.setAttribute(AppConstant.USER_ATTR, newUser);
       }

        redirect(response, AppConstant.CABINET_JSP);
    }
}
