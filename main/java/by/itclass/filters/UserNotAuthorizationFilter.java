package by.itclass.filters;

import by.itclass.constants.AppConstant;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "UserNotAuthorizationFilter", value = {AppConstant.CABINET_JSP, AppConstant.MY_NEWS_JSP, AppConstant.ADD_NEWS_JSP,
        AppConstant.EDIT_NEWS_JSP, AppConstant.UPDATE_CABINET_CONT_URL, AppConstant.DELETE_NEWS_CONT_URL,
        AppConstant.SAVE_NEWS_CONT_URL, AppConstant.USER_LIST_NEWS_CONT_URL, AppConstant.LOGOUT_CONT_URL, AppConstant.LIKE_NEWS_CONT_URL})
public class UserNotAuthorizationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //для того чтобы понять авторизирован пользователь или нет, обратимся к сессии
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session =  request.getSession();
        Object user = session.getAttribute(AppConstant.USER_ATTR);

        if(user != null){
            //Если в цепочки фильтров их несколько, то метод doFilter позволяет перейти
            //к следующему фильтру, или если цепочка закончилась, то в конце перейдет в назначенный ресурс
            //т.е. к тому, к которому был адресован запрос
            chain.doFilter(req, resp);
        }else{
            //Если мы хотим запретить доступ к ресурсу, то метод doFilter не должен вызываться
            request.setAttribute(AppConstant.MESSAGE_ATTR, AppConstant.USER_IS_NOT_AUTHORIZATION_MESSAGE);
            request.getRequestDispatcher(AppConstant.AUTH_JSP).forward(request,resp);
        }
    }
}
