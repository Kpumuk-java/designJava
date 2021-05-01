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

    public User findById (String id) throws SQLException {
        if (!users.isEmpty()) {
            for (User u : users) {
                if (u.getId().equals(id)) {
                    return u;
                }
            }
        }

        PreparedStatement statement = this.connection.prepareStatement("SELECT id, name, age FROM users WHERE id = ?");
        statement.setString(1, id);
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
                users.add(user);
            }
            return users;
        }
    }
}
