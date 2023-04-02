package by.itclass.model.db;

public final class SQLRequest {
    public static final String INSERT_USER ="insert into users(login,password,email) value(?,?,?)";
    public static final String SELECT_USER = "select users.id as id_user, login, email, user_images.id " +
            "as id_image,name, content from users " +
            "left join user_images on users.id=user_images.id_user where (login=? or email=?) and password=?";
    public static final String SELECT_NEWS_BY_ID_USER = "select id, title, text, date from news where id_user=?";
    public static final String SELECT_NEWS_BY_ID = "select news.id, title, text, date,(select count(*) from likes where id_news = ?) as likes from news " +
            "where id = ?";
    public static final String SELECT_NEWS_SORTED_BY_DATE = "(select news.id,title,text,date, 0 as likes from news order by date desc)";
    public static final String SELECT_NEWS_BY_TOP_LIKES = "select news.id, title, text, date,count(*) as likes from news " +
            "inner join likes on news.id = likes.id_news " +
            "group by news.id, title, text, date " +
            "order by likes desc limit 3";
    public static final String UPDATE_NEWS = "update news set title=?, text = ? WHERE id = ?";
    public static final String INSERT_NEWS = "insert into news(title,text,id_user) value(?,?,?)";
    public static final String DELETE_NEWS_BY_ID = "delete from news where id = ?";
    public static final String UPDATE_USER = "update users set login=?, email = ? where id=?";
    public static final String UPDATE_USER_PASSWORD = "update users set login=?, email = ?, password = ? where id = ?";
    public static final String INSERT_LIKE_FOR_NEWS = "insert into likes(id_news,id_user) value(?,?)";
    public static final String DELETE_LIKE_FOR_NEWS = "delete from likes(id_news,id_user) value(?,?)";
    public static final String IS_LIKE_NEWS = "select id from likes where id_news = ? and id_user = ?";
    public static final String DISLIKE_FOR_NEWS = "delete from likes where id_news = ? and id_user = ?";
    public static final String INSERT_USER_IMAGE = "insert into user_images(name,content,id_user) value(?,?,?)";
    public static final String UPDATE_USER_IMAGE = "update user_images set name=?,content=? where id_user=?";

    public static final String ID_COLUMN = "id";
    public static final String TITLE_COLUMN = "title";
    public static final String TEXT_COLUMN = "text";
    public static final String DATE_COLUMN = "date";
    public static final String LIKES_COLUMN = "likes";



}
