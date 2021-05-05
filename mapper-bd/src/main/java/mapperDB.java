import db.InitDB;
import mapper.UserMapper;
import model.User;

import java.sql.SQLException;

public class mapperDB {
    public static void main(String[] args) throws SQLException {
        InitDB initDB = new InitDB();
        UserMapper userMapper = new UserMapper(initDB.getConnection());
        //System.out.println(userMapper.findAll().toString());
        User user = new User("2", "Bill", 50);
        userMapper.saveOrUpdate(user);
        System.out.println(userMapper.getUsers().toString());
        System.out.println(userMapper.findAll().toString());
        User user2 = new User("3", "Bill", 30);
        userMapper.saveOrUpdate(user2);
        System.out.println(userMapper.getUsers().toString());
        System.out.println(userMapper.findAll().toString());
        System.out.println(userMapper.delete(user));
        System.out.println("-- " + userMapper.findAll().toString());
        System.out.println(userMapper.delete(user));



    }
}
