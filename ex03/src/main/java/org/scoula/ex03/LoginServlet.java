package org.scoula.ex03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 요청에서 파라미터 얻기
        String userid = request.getParameter("userid");
        String passwd = request.getParameter("passwd");

        // 응답 내보내기
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.print("<html><body>");
        out.print("아이디값: " + userid + "<br>");
        out.print("비밀번호값: " + passwd + "<br>");
        out.print("</body></html>");
    }

    protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }
}
