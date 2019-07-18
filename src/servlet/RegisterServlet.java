package servlet;

import Dao.UserDao;
import com.mysql.cj.Session;
import com.table.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=usf-8");
        int rows = 0;
        String errMsg = "";
        try {
            String userName = req.getParameter("username");
            String password = req.getParameter("password");
            String confirmPsd = req.getParameter("confirmPassword");
            HttpSession session = req.getSession();
            UserDao userDao = new UserDao();
            User user = new User(userName);
            List<User> list = userDao.findByUser(user);
            //判断用户名是否存在
            if(list != null && list.size() > 0){
                //如果存在，则注册失败
                req.setAttribute("msg","<script type='text/javascript'>alert('注册失败：用户名已存在');window.location.href='register.jsp';</script>");
                req.getRequestDispatcher("register.jsp").forward(req,resp);
            }else{
                if(!password.equals(confirmPsd)){
                    req.setAttribute("msg","<script type='text/javascript'>alert('注册失败：密码与原密码不符');window.location.href='register.jsp';</script>");
                    req.getRequestDispatcher("register.jsp").forward(req,resp);
                }else {
                    //以上条件都成立，则保存数据并更新至数据库
                    User userLoad = new User(userName, password);
                    session.setAttribute("userLoad", userLoad);
                    rows = userDao.updateUser(userLoad);
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            errMsg = e.getMessage();
        }
        PrintWriter out = resp.getWriter();
        if(rows>0){
            // 表示修改成功
            System.out.println("修改成功");
            out.println("<script type='text/javascript'>alert('修改成功');location.href='login.jsp';</script>");
        }else{
            // 修改失败
            out.println("<script type='text/javascript'>alert('修改失败："+errMsg+"');history.back();</script>");
        }
    }
}
