package org.scoula.ex05;

import org.scoula.ex05.domain.Member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
    ServletContext sc;

    @Override
    public void init(ServletConfig config) throws ServletException {
        sc = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        sc.setAttribute("scopeName", "applicationScope 값");

        // session Scope
        // 현재 세션을 가져오거나 존재하지 않으면 새로 생성
        HttpSession session = request.getSession();
//        session scope에 속성 설정
        session.setAttribute("scopeName", "sessionScope 값");

        request.setAttribute("scopeName", "requestScope 값");

        Member member = new Member("홍길동", "hong");
        request.setAttribute("member", member);

//        scope.jsp 화면 포워딩
//        대소문자 구분 필수 => Scope.jsp 로 입력해서 안 떴었음
        request.getRequestDispatcher("scope.jsp").forward(request, response);
    }
}
