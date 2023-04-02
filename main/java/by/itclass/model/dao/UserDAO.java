package by.itclass.model.dao;

import by.itclass.model.beans.Image;
import by.itclass.model.beans.User;
import by.itclass.model.db.ConnectionManager;
import by.itclass.model.db.SQLRequest;
import by.itclass.model.enums.ImageAction;

import java.sql.*;

//В классе будут определяться методы, которые можно будет
//вызвать из контроллеров для работы с моделью пользователя
public class UserDAO {

    public boolean update(User user, String password){
        boolean result = false;
        String sql = (password.isEmpty() ? SQLRequest.UPDATE_USER : SQLRequest.UPDATE_USER_PASSWORD);
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement pst = cn.prepareStatement(sql)) {

            pst.setString(1, user.getLogin());
            pst.setString(2, user.getEmail());

            if(password.isEmpty()){
                pst.setInt(3,user.getId());
            }else{
                pst.setString(3,password);
                pst.setInt(4, user.getId());
            }
            result = pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //Метод испльзуется для регистрации(сохранения в БД)
    //переданного пользователя с данным паролем
    public boolean registration(User user, String password) {
        boolean isRegistration = false;

        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement pst = cn.prepareStatement(SQLRequest.INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {
            //Заполняем параметры запроса значениями, полученными от пользователя
            pst.setString(1, user.getLogin());
            pst.setString(2, password);
            pst.setString(3, user.getEmail());

            //Исполняем запрос на вставку
            //Метод executeUpdate() вернет количество добавленных строк
            isRegistration = pst.executeUpdate() > 0;//0 > 0

            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                user.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRegistration;
    }

    public User authorization(String email, String password){
       User user = null;

        try(Connection cn = ConnectionManager.getConnection();
            PreparedStatement pst = cn.prepareStatement(SQLRequest.SELECT_USER)) {
            pst.setString(1, email);
            pst.setString(2,email);
            pst.setString(3, password);
            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                user = new User(rs.getInt("id_user"),
                        rs.getString("login"),
                        rs.getString("email"));
                Image image = new Image(rs.getInt("id_image"),
                        rs.getString("name"),
                        rs.getBytes("content"));
                user.setImage(image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public void saveImage(User user, ImageAction action) {
        String sql = action.getSql();
        try (Connection cn = ConnectionManager.getConnection();
             PreparedStatement pst = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, user.getImage().getName());
            pst.setBytes(2, user.getImage().getContent());
            pst.setInt(3, user.getId());
            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next()){
                int id= rs.getInt(1);
                user.getImage().setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
