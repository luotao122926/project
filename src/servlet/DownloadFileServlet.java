package servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class DownloadFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、设置编码（请求和响应）
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");


        // 下载文件的url
        //   http://localhost:8080/downloadServlet?fileName=1.jpg

        // 1、获得下载文件的文件名
        String fileName = req.getParameter("fileName");
        System.out.println("fileName" + fileName);
        // 2、判断文件是否存在
        // upload目录在tomcat下的绝对路径
        String parentPath = req.getServletContext().getRealPath("/upload");
        // 获得下载文件的对象
        File downFile = new File(parentPath,fileName);
        if(downFile.canExecute()){
            //  2.1、如果文件存在就提供下载
            // 设置文件在客户端的打开方式
            // inline/attachment：inline（在线打开）/attachment(以附件的形式打开)
            // 如果文件名不带中文，那么下面配置就可以了
//            resp.setHeader("content-disposition", "attachment;filename="+fileName);
            // 如果文件名带中文，那么上面配置的代码就要改
            String newFileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
            resp.setHeader("content-disposition", "attachment;filename="+newFileName);

            // 获得输入流和输出流
            // 读文件
            InputStream is = new FileInputStream(downFile);
            // 获得响应输出：写文件
            OutputStream os = resp.getOutputStream();
            // 写文件
            IOUtils.copy(is, os);
            // 关闭资源
            os.close();
            is.close();
        }else{
            //  2.2、如果文件不存在就给客户端错误提示
            PrintWriter out = resp.getWriter();
            out.println("<script type='text/javascript'>alert('文件不存在');history.back();</script>");
        }
    }
}
