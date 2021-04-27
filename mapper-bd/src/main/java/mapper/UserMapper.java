package mapper;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserMapper {
    private final Connection connection;

    public UserMapper(Connection c) {
        this.connection = c;
    }

    public User findById (String uuid) throws SQLException {
        PreparedStatement statement = this.connection.prepareStatement("SELECT uuid, name, age WHERE uuid = ?");
        statement.setString(1, uuid);
        try (ResultSet resultSet = statement.executeQuery()) {
            while(resultSet.next()) {
                User user = new User(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                return User;
            }
        }
    }
}
