package Dao;

import com.table.User;
import servlet.LoginServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends ParentDao{
    public List<User> findByUser(User user){
        Connection connection = null;
        PreparedStatement sta = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        try {
//            connection = this.getConnection();
//            String sql = "select * from User where username = ?";
//            sta = connection.prepareStatement(sql);
//            sta.setString(1,username);
//            rs = sta.executeQuery();
//            while(rs.next()){
//                User user = new User();
//                user.setUsername(rs.getString("username"));
//                user.setPassword(rs.getString("password"));
//                list.add(user);
            //创建集合
            List<Object> userList = new ArrayList<>();
            //连接数据库
            connection = super.getConnection();
            //编译SQL语句
            StringBuffer sql = new StringBuffer();
            sql.append("select * from user where 1=1 ");
            if(user.getUsername() != null){
                sql.append(" and username = ? ");
                userList.add(user.getUsername());
            }
            if(user.getPassword() != null){
                sql.append(" and password = ? ");
                userList.add(user.getPassword());
            }
            //执行预编译语句
            sta = connection.prepareStatement(sql.toString());
            //设置占位符的值
            if(userList != null && userList.size() >0){
                for(int i= 0 ; i < userList.size() ; i++){
                    sta.setObject(i+1,userList.get(i));
                }
            }
            rs = sta.executeQuery();
            while(rs.next()){
                User entity = new User();
                entity.setUsername(rs.getString("userName"));
                entity.setPassword(rs.getString("password"));
                list.add(entity);
            }
            /*
            connection = this.getConnection();
            String sql = "select * form user where username = ?";
            sta = connection.prepareStatement(sql);
            sta.setString(1,userName);
            //获得语句集
            rs = sta.executeQuery();
            if(!rs.next()){
               flag = true;
               return flag;
            }else{
                throw new Exception("用户名已存在");
            }
            */
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.closeAll(connection,sta,rs);
        }
        return list;
    }

    //更新数据
    public int updateUser(User user){
        Connection connection = null;
        PreparedStatement sta = null;
        ResultSet rs = null;

        try {
            connection = this.getConnection();
            String sql = "insert into user(username,password) " +
                    "values(?,?)";
            sta = connection.prepareStatement(sql);
            sta.setString(1,user.getUsername());
            sta.setString(2,user.getPassword());
            int rows = sta.executeUpdate();
            return rows;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(connection,sta,rs);
        }
        return 0;
    }
}
