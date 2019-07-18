package servlet;

import Dao.GoodsinfoDao;
import com.table.Goodsinfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GoodsinfoLoadDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 要实现Update功能需要2步
//        // 第1步要将旧数据加载或设置到修改页面
//        String errMsg = "";
//        try {
//            // 1、获取学号
//            String stuNo = req.getParameter("stuNo");
//
//            // 2、验证学号是否非空
//            if(stuNo == null || "".equals(stuNo)){
//                throw new RuntimeException("学号不能为空");
//            }
//
//            // 3、根据学号查询学生信息
//            StudentDao studentDao = new StudentDao();
//            Student queryStu = new Student(stuNo);
//            List<Student> list = studentDao.findByStudent(queryStu);
//            if(list==null && list.size()<1){
//                throw new RuntimeException("该学号找不到");
//            }
//            // 4、设置到作用域中用于在修改页面获取
//            req.setAttribute("stu", list.get(0));
//        } catch (Exception e) {
//            e.printStackTrace();
//            errMsg = e.getMessage();
//        }
//
//        if("".equals(errMsg)){
//            // 表示取到数据
//            req.getRequestDispatcher("stu_update.jsp").forward(req, resp);
//        }else{
//            PrintWriter out = resp.getWriter();
//            out.println("<script type='text/javascript'>alert('数据加载失败：'"+errMsg+");history.back();</script>");
//        }
        //第一步将旧数据加载或设置到新页面
        //获得商品名
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html:charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        String errMsg = "";
        try {
            String goodsinfoName = req.getParameter("goodsinfoName");
            //判断商品名是否为空
            if(goodsinfoName == null && "".equals(goodsinfoName)){
                throw new Exception("商品名不能为空");
            }
            //根据商品名进行查询
            GoodsinfoDao goodsinfoDao = new GoodsinfoDao();
            Goodsinfo goodsinfo = new Goodsinfo(goodsinfoName);
            List<Goodsinfo> list = goodsinfoDao.findByGoodsinfo(goodsinfo);
            if(list == null && list.size() < 1){
                throw new Exception("查找不到该商品");
            }
            req.setAttribute("goodsinfo",list.get(0));
        } catch (Exception e) {
            e.printStackTrace();
            errMsg = e.getMessage();
        }
        PrintWriter out = resp.getWriter();
        if("".equals(errMsg)){
            req.getRequestDispatcher("goodsinfoUpdate.jsp").forward(req,resp);
        }else{
            out.println("<script type='text/javascript'>alert('数据修改失败:'"+errMsg+");history.back();</script>");
        }
    }
}
