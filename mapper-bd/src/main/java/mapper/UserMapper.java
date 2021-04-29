package mapper;

import exceptions.ResourceNotFoundException;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    private final Connection connection;
    private List<User> users;

    public UserMapper(Connection c) {
        this.connection = c;
        users = new ArrayList<>();
    }

    public User findById (String uuid) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT uuid, name, age FROM users WHERE uuid = ?");
        statement.setString(1, uuid);
        try (ResultSet resultSet = statement.executeQuery()) {
            while(resultSet.next()) {
                User user = new User(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                return user;
            }
        }
        throw new ResourceNotFoundException("User not found");
    }

    public List<User> findAll () throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM users");
        try (ResultSet resultSet = statement.executeQuery()) {
            while(resultSet.next()) {
                User user = new User(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                System.out.println(user.toString());
                users.add(user);
            }
            return users;
        }
        //throw new ResourceNotFoundException("User not found");
    }
}
