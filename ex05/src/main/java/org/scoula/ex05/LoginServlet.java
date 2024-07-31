package org.scoula.ex05;

import org.scoula.ex05.domain.Member;
import org.scoula.ex05.dto.LoginDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //  getParameter 내에 있는 이름은 input의 name과 같은지 확인할 것
        String userid = request.getParameter("userid");
        String passwd = request.getParameter("passwd");

//        위에서 만들어진 변수 정보를 request 내에 세팅한다
//        생성자
        LoginDTO loginDTO = new LoginDTO(userid, passwd);


        request.setAttribute("userid", userid);
        request.setAttribute("passwd", passwd);

        request.setAttribute("login", loginDTO);

        //Session을 얻음 (로그인 처리)
        HttpSession sessin = request.getSession();
        Member member = new Member("홍길동", userid);
        request.setAttribute("user", member);

//설정한 request를 login.jsp로 보내서 화면을 띄어준다
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
