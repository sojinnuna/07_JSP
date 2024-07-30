package org.scoula.ex03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sports")
public class SportsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String[] sports = request.getParameterValues("sports");
        String sex = request.getParameter("sex");

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.print("<html><body>");
//        체크된 값들을 돌면서 하나씩 출력한다
        for (String sport : sports) {
            out.print("좋아하는 운동: " + sport + "<br>");
        }
//        라디오값은 하나밖에 선택이 안되므로 배열처리할 필요 없음
            out.print("성별: " + sex + "<br>");
            out.print("</body></html>");
        }
    }
