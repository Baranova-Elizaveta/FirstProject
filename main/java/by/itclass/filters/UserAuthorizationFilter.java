package by.itclass.filters;

import by.itclass.constants.AppConstant;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "UserAuthorizationFilter", value = {AppConstant.AUTHORIZATION_CONT_URL, AppConstant.AUTH_JSP, AppConstant.REG_JSP, AppConstant.REGISTRATION_CONT_URL})
public class UserAuthorizationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session =  request.getSession();
        Object user = session.getAttribute(AppConstant.USER_ATTR);

        if(user == null){
            //Если в цепочки фильтров их несколько, то метод doFilter позволяет перейти
            //к следующему фильтру, или если цепочка закончилась, то в конце перейдет в назначенный ресурс
            //т.е. к тому, к которому был адресован запрос
            chain.doFilter(req, resp);
        }else{
            //Если мы хотим запретить доступ к ресурсу, то метод doFilter не должен вызываться
            request.setAttribute(AppConstant.MESSAGE_ATTR, AppConstant.USER_IS_AUTHORIZATION_MESSAGE);
            request.getRequestDispatcher(AppConstant.CABINET_JSP).forward(request,resp);
        }
    }
}
