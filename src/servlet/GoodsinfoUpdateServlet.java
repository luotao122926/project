package servlet;

import Dao.GoodsinfoDao;
import com.table.Goodsinfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class GoodsinfoUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int rows = 0;
        String errMsg = "";
        try {
            String id = req.getParameter("id");
            if(id == null & "".equals(id)){
                throw new Exception("商品没有该id");
            }
            String goodsinfoName = req.getParameter("goodsinfoName");
            String goodsinfoPic = req.getParameter("goodsinfoPic");
            double goodsinfoPrice = Double.parseDouble(req.getParameter("goodsinfoPrice"));
            String goodsinfoDescription = req.getParameter("goodsinfoDescription");
            int goodsinfoStock = Integer.parseInt(req.getParameter("goodsinfoStock"));
            if(goodsinfoName == null || "".equals(goodsinfoName)){
                throw new Exception("商品名不能为空");
            }

            Goodsinfo goodsinfo = new Goodsinfo(id,goodsinfoName,goodsinfoPic,goodsinfoPrice,
                    goodsinfoDescription,goodsinfoStock);

            GoodsinfoDao goodsinfoDao = new GoodsinfoDao();

            rows = goodsinfoDao.goodsinfoUpdate(goodsinfo);
        } catch (Exception e) {
            e.printStackTrace();
            errMsg = e.getMessage();
        }

        PrintWriter out = resp.getWriter();
        if( rows > 0){
            req.getRequestDispatcher("goodsinfoQueryServlet").forward(req,resp);
        }else{
            out.println("<script type='text/javascript'>alert('数据保存失败:"+errMsg+"');history.back();</script>");
        }

    }
}
