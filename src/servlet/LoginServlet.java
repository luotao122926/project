package servlet;

import Dao.UserDao;
import com.table.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=usf-8");
        try {
            String userName = req.getParameter("username");
            String password = req.getParameter("password");
            UserDao userDao = new UserDao();
            User user = new User(userName,password);
            List<User> List = userDao.findByUser(user);
            if(userName != null && !"".equals(userName)){
                if(password != null && !"".equals(password)){
                    if(List != null && List.size() > 0){
                        req.setAttribute("msg","<script type='text/javascript'>alert('登录成功');window.location.href='goodsinfoQueryServlet';</script>");
                        req.getRequestDispatcher("login.jsp").forward(req,resp);
                    }else{
                        req.setAttribute("msg","<script type='text/javascript'>alert('账户或密码错误');history.back();</script>");
                        req.getRequestDispatcher("login.jsp").forward(req,resp);
                    }
                }else{
                    req.setAttribute("msg","<script type='text/javascript'>alert('登录失败：密码不能为空');history.back();</script>");
                    req.getRequestDispatcher("login.jsp").forward(req,resp);
                }
            }else{
                req.setAttribute("msg","<script type='text/javascript'>alert('登录失败：账户不能为空');history.back();</script>");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
