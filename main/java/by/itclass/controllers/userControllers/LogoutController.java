package by.itclass.controllers.userControllers;

import by.itclass.constants.AppConstant;
import by.itclass.controllers.userControllers.AbstractUserController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ExitController", value = AppConstant.LOGOUT_CONT_URL)
public class LogoutController extends AbstractUserController {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();

        //Построение сценария
        redirect(response, AppConstant.AUTH_JSP);
    }
}
