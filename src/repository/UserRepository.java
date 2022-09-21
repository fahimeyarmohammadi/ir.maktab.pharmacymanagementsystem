package repository;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    public void insertUser(User user) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into User_tbl" +
                " (username , nationalcode) values (?,?)");
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getNationalCode());

        preparedStatement.executeUpdate();
    }

    public boolean userSignIn(User user) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from User_tbl" +
                " where username=? , password=?");
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getNationalCode());

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
            return true;
        else
            return false;
    }
}
