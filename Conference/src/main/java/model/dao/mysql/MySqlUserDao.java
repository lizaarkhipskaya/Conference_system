package model.dao.mysql;

import controller.manager.SqlStatementManager;
import model.mapper.UserMapper;
import model.dao.ConnectionPool;
import model.dao.UserDao;
import model.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class MySqlUserDao implements UserDao {
    private static final Logger LOGGER = LogManager.getLogger(MySqlUserDao.class);
    public  static final int INITIAL_REATING = 0;
    private  DataSource source = ConnectionPool.getDatasource();
    private UserMapper userMapper = new UserMapper();
   @Override
    public User checkEmailPassword(String email, String password){
        User user = null;
        try(Connection connection = source.getConnection()){
            PreparedStatement ps = connection.prepareStatement(SqlStatementManager.getProperty("user.getByEmailPassword"));
            System.out.println(email+" "+password);
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            rs.next();
            user = userMapper.mapToObject(rs);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return user;
    }
    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public Long insert(User user) {
        Long id = null;
        try(Connection con = ConnectionPool.getDatasource().getConnection()){
            PreparedStatement st = con.prepareStatement(SqlStatementManager.getProperty("user.insert"),java.sql.Statement.RETURN_GENERATED_KEYS);
            st = mapStatementForInsertUser(st,user);
            st.executeUpdate();
            ResultSet idResultSet = st.getGeneratedKeys();
            idResultSet.next();
            id = Long.valueOf(idResultSet.getInt(1));
            if(user.getRole()== User.Role.SPEAKER) {
                st = con.prepareStatement(SqlStatementManager.getProperty("speaker.insert"));
                st = mapStatementForInsertSpeaker(st,id);
                st.execute();
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return id;
    }

    private PreparedStatement mapStatementForInsertUser(PreparedStatement st, User user) {
        try {
            st.setString(1, user.getName());
            st.setString(2, user.getSurname());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.setString(5, user.getRole().toString().toLowerCase());
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return st;
    }

    private PreparedStatement mapStatementForInsertSpeaker(PreparedStatement ps, Long id){
        try {
            ps.setInt(1,id.intValue());
            ps.setInt(2,INITIAL_REATING);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return ps;
    }
    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean remove(User user) {
        return false;
    }

}
