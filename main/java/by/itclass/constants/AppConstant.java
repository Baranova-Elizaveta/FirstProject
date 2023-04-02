package by.itclass.constants;

//Класс содержит определение некоторых глобальных констант приложения
public final class AppConstant {
    public static final String IO_TEMP_REPOSITORY = "java.io.tmpdir";


    public static final String USER_LIST_NEWS_CONT_URL = "/mynews";
    public static final String REGISTRATION_CONT_URL = "/registration";
    public static final String AUTHORIZATION_CONT_URL = "/authorization";
    public static final String LOGOUT_CONT_URL = "/logout";
    public static final String GET_NEWS_CONT_URL = "/news";
    public static final String SAVE_NEWS_CONT_URL = "/save";
    public static final String START_NEWS_CONT_URL = "/index";
    public static final String DELETE_NEWS_CONT_URL = "/delete";
    public static final String UPDATE_CABINET_CONT_URL = "/update";
    public static final String LIKE_NEWS_CONT_URL = "/like";
    public static final String UPLOAD_IMAGE_CABINET_CONT_URL = "/upload";

    public static final String CABINET_JSP = "/cabinet.jsp";
    public static final String REG_JSP = "/reg.jsp";
    public static final String AUTH_JSP = "/auth.jsp";
    public static final String MY_NEWS_JSP = "/mynews.jsp";
    public static final String EDIT_NEWS_JSP = "/editnews.jsp";
    public static final String INDEX_JSP = "/index.jsp";
    public static final String O_NAS_JSP = "/onas.jsp";
    public static final String ADD_NEWS_JSP = "/addnews.jsp";
    public static final String VIEW_NEWS_JSP = "/news.jsp";

    //Названия тегов input на страницах jsp
    public static final String LOGIN_LABEL = "login";
    public static final String PASSWORD_LABEL = "password";
    public static final String EMAIL_LABEL = "email";
    public static final String ID_LABEL = "id";
    public static final String TITLE_LABEL = "title";
    public static final String TEXT_LABEL = "text";
    public static final String ACTION_LABEL = "action";


    //Аттрибуты
    public static final String USER_ATTR = "user";
    public static final String MESSAGE_ATTR = "message";
    public static final String NEWS_LIST_ATTR = "newsList";
    public static final String NEWS_ATTR = "news";
    public static final String NEWS_LIST_TOP_ATTR = "newsListTop";

    //Сообщения
    public static final String NOT_USER_REGISTRATION_MESSAGE = "User is not registration";
    public static final String NOT_USER_AUTHORIZATION_MESSAGE = "User is not authorization";
    public static final String NOT_UPDATE_NEWS_MESSAGE = "News is not update";
    public static final String USER_IS_NOT_AUTHORIZATION_MESSAGE = "Authorization please";
    public static final String USER_IS_AUTHORIZATION_MESSAGE = "You are authorization";


    public static final String IMAGE_FOLDER_NAME = "/image";
    public static final String DEFAULT_USER_IMAGE_NAME = "user.png";
}
