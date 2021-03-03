package org.geektimes.projects.user.service.impl;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;

import java.sql.*;
import java.util.Properties;

public class UserServiceImpl implements UserService {

    public static final String CREATE_USERS_TABLE_DDL_SQL = "CREATE TABLE users(" +
            "id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
            "name VARCHAR(16) NOT NULL, " +
            "password VARCHAR(64) NOT NULL, " +
            "email VARCHAR(64) NOT NULL, " +
            "phoneNumber VARCHAR(64) NOT NULL" +
            ")";


    @Override
    public boolean register(User user) throws Exception {
//        DatabaseUserRepository repository = new DatabaseUserRepository(new DBConnectionManager());
//
//        boolean re = repository.save(user);
        boolean re =false;
        Connection connection ;

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
             Driver driver = DriverManager.getDriver("jdbc:derby:D:/db/user-platform;create=true");

            connection = driver.connect("jdbc:derby:/db/user-platform;create=true",new Properties());
            Statement statement = connection.createStatement();
             statement.execute(CREATE_USERS_TABLE_DDL_SQL);
            re =  statement.execute( "INSERT INTO users(name,password,email,phoneNumber) VALUES (" +1
                    +","+user.getPassword()+","+
                    "'"+user.getEmail()+"'"+","
                    +12333+")" );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return re;
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return null;
    }
}
