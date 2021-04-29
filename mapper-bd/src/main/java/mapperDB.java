import db.InitDB;
import mapper.UserMapper;

import java.sql.SQLException;

public class mapperDB {
    public static void main(String[] args) throws SQLException {
        InitDB initDB = new InitDB();
        UserMapper userMapper = new UserMapper(initDB.getConnection());
        System.out.println(userMapper.findAll().toString());
    }
}
