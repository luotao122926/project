package servlet;

import Dao.GoodsinfoDao;
import com.table.Goodsinfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodsinfoQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GoodsinfoDao goodsinfoDao = new GoodsinfoDao();

        List<Goodsinfo> goodsinfoList1 = goodsinfoDao.findByGoodsinfo(null);

        req.setAttribute("list",goodsinfoList1);

        req.getRequestDispatcher("page.jsp").forward(req,resp);
    }
}
