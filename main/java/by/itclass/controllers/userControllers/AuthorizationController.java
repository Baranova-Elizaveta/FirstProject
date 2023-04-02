package by.itclass.controllers.userControllers;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.userControllers.AbstractUserController;
import by.itclass.model.beans.Image;
import by.itclass.model.beans.User;
import by.itclass.model.utils.ImageUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AuthorizationController", value = AppConstant.AUTHORIZATION_CONT_URL)
public class AuthorizationController extends AbstractUserController {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter(AppConstant.EMAIL_LABEL);
        String password = request.getParameter(AppConstant.PASSWORD_LABEL);

        User user = userDAO.authorization(email, password);

        if(user != null){
            HttpSession session = request.getSession();
            ImageUtil.createImageFile(getServletContext().getRealPath(AppConstant.IMAGE_FOLDER_NAME), user.getImage());
            session.setAttribute(AppConstant.USER_ATTR, user);

            redirect(response, AppConstant.CABINET_JSP);
        }else{
            forward(request, response, AppConstant.AUTH_JSP, AppConstant.NOT_USER_AUTHORIZATION_MESSAGE);
        }

    }
}
