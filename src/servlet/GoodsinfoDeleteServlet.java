package servlet;

import Dao.GoodsinfoDao;
import com.table.Goodsinfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GoodsinfoDeleteServlet extends HttpServlet {
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
        String errMsg="";
        try {
            String id = req.getParameter("id");
            if(id == null && "".equals(id)){
                throw new Exception("编号不能为空");
            }
            GoodsinfoDao goodsinfoDao = new GoodsinfoDao();
            Goodsinfo goodsinfo = new Goodsinfo(id);
            rows = goodsinfoDao.goodsinfoDelete(goodsinfo);
        } catch (Exception e) {
            e.printStackTrace();
            errMsg = e.getMessage();
        }
        PrintWriter out = resp.getWriter();
        if(rows > 0){
            out.println(
                    "<script type='text/javascript'>alert('删除成功');location.href='goodsinfoQueryServlet'</script>"
            );
        }else{
            out.println(
                    "<script type='text/javascript'>alert('删除失败: "+errMsg+"');history.back();</script>"
            );
        }
    }
}
