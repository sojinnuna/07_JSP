package org.scoula.ex04.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cart_view")
public class CartViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("장바구니 리스트");

        // 세션객체 얻기
        HttpSession session = request.getSession(false);
        session.setMaxInactiveInterval(20);

        if (session != null) {
//            세션이 존재하는 경우
            ArrayList<String> list = (ArrayList<String>) session.getAttribute("product");
//            product에 저장된 상품들을 모두 출력
            out.print("상품: " + list + "<br>");
        } else {
//            세션이 존재하지 않는 경우
            out.print("세션 없음" + "<br>");
        }
        out.print("<a href='session_product.jsp'>상품 선택 페이지</a><br>");
        out.print("<a href='cart_view'>장바구니 비우기</a>");
        out.print("</body></html>");
    }
}

