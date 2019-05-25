package model.dao.mysql;

import model.dao.ConnectionPool;
import model.dao.DaoUser;
import model.entity.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySqlDaoUser implements DaoUser {
    private  DataSource source = ConnectionPool.getDatasource();
    public static Map<String, User.Role> roleHashMap = new HashMap<>();
    static{
        roleHashMap.put("m", User.Role.MODERATOR);
        roleHashMap.put("a", User.Role.ADMIN);
        roleHashMap.put("s", User.Role.SPEEKER);
        roleHashMap.put("u", User.Role.USER);
    }
    public User checkEmailPassword(String email, String password){
        User user = null;
        try(Connection connection = source.getConnection()){
            PreparedStatement ps = connection.prepareStatement("select * from user where user.email = ? and user.password = ?");
            System.out.println(email+" "+password);
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            rs.next();
            user = new User.Builder()
                    .setId(rs.getLong("id"))
                    .setName(rs.getString("name"))
                    .setSureName(rs.getString("surname"))
                    .setEmail(rs.getString("email"))
                    .setPassword(rs.getString("password"))
                    .setRole(roleHashMap.get(rs.getString("role")))
                    .build();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public Long getById(User id) {
        return null;
    }

    @Override
    public User insert(Long aLong) {
        try(Connection con = ConnectionPool.getDatasource().getConnection()){
            Statement st = con.prepareStatement("insert into user (?,?,?,?,?)");
            st.getGeneratedKeys();
        }catch (SQLException e){

        }
        return null;
    }

    @Override
    public boolean update(Long aLong) {
        return false;
    }

    @Override
    public boolean remove(Long aLong) {
        return false;
    }

}
