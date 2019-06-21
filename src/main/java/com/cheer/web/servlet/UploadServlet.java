package com.cheer.web.servlet;

import com.cheer.service.QuestionService1;
import com.cheer.util.IOUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UploadServlet", urlPatterns = "/servlet/UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String src=null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        File repository = (File) request.getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Parse the request
        List<FileItem> items = null;

        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        if (items!=null) {
            for (FileItem item : items) {
                if (item!=null) {
                    // 判断是否是普通表单字段还是文件上传字段
                    String name = item.getName();
                    String tmpDir = System.getProperty("user.home");

                    File avatarDir = new File(tmpDir + "/avatar");
                    if (!avatarDir.exists()) {
                        // 创建路径
                        if(!avatarDir.mkdirs()) {
                            throw new ServletException("注册失败");
                        }
                    }
                    String fileName =name;
                    src=avatarDir+"/"+fileName;
                    System.out.println(src);
                    IOUtils.writeToFile(item.getInputStream(), avatarDir + "/" + fileName);
                }
            }
        }

        new QuestionService1().insertQuestion(src);
       response.sendRedirect("../page_admin_index1.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
