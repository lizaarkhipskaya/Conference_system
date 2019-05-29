package model.dao.mysql;

import model.mapper.UserMapper;
import model.service.SourceEnum;
import model.dao.ConnectionPool;
import model.dao.UserDao;
import model.entity.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

public class MySqlUserDao implements UserDao {
    public  static final int INITIAL_REATING = 0;
    private  DataSource source = ConnectionPool.getDatasource();
    private UserMapper userMapper = new UserMapper();
    private ResourceBundle resourceBundle = ResourceBundle.getBundle(SourceEnum.SQL_STATEMENT.getName());

   /* public static Map<String, User.Role> roleHashMap = new HashMap<>();
    static{
        roleHashMap.put("m", User.Role.MODERATOR);
        roleHashMap.put("a", User.Role.ADMIN);
        roleHashMap.put("s", User.Role.SPEEKER);
        roleHashMap.put("u", User.Role.USER);
    }*/
   @Override
    public User checkEmailPassword(String email, String password){
        User user = null;
        try(Connection connection = source.getConnection()){
            PreparedStatement ps = connection.prepareStatement(resourceBundle.getString("user.getByEmailPassword"));
            System.out.println(email+" "+password);
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            rs.next();
            user = userMapper.mapToObject(rs);
        } catch (SQLException e) {
            e.printStackTrace();
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
            PreparedStatement st = con.prepareStatement(resourceBundle.getString("user.insert"),java.sql.Statement.RETURN_GENERATED_KEYS);
            st = mapStatementForInsertUser(st,user);
            st.executeUpdate();
            ResultSet idResultSet = st.getGeneratedKeys();
            idResultSet.next();
            id = Long.valueOf(idResultSet.getInt(1));
            if(user.getRole()== User.Role.SPEAKER) {
                st = con.prepareStatement(resourceBundle.getString("speaker.insert"));
                st = mapStatementForInsertSpeaker(st,id);
                st.execute();
            }
        }catch (SQLException e){
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return st;
    }

    private PreparedStatement mapStatementForInsertSpeaker(PreparedStatement ps, Long id){
        try {
            ps.setInt(1,id.intValue());
            ps.setInt(2,INITIAL_REATING);
        } catch (SQLException e) {
            e.printStackTrace();
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
