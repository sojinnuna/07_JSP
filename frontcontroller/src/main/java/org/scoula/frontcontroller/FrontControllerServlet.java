package org.scoula.frontcontroller;

import org.scoula.frontcontroller.command.Command;
import org.scoula.frontcontroller.controller.HomeController;
import org.scoula.frontcontroller.controller.TodoController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//@WebServlet("/")와 동일
@WebServlet(name = "frontControllerServlet", value = "/")
public class FrontControllerServlet extends HttpServlet {

    // GET 요청이 들어왔을 경우 사용할 맵
    Map<String, Command> getMap;
    // POST 요청이 들어왔을 경우 사용할 맵
    Map<String, Command> postMap;
//    뷰의 기본 경로와 확장자를 설정해준다
    String prefix = "/WEB-INF/views/";
    String suffix = ".jsp";

//    HomeController 객체 생성
    HomeController homeController = new HomeController();

    TodoController todoController = new TodoController();


    // 서블릿 초기화 메소드
    public void init() {
        // Map은 인터페이스이므로 구현 클래스인 HashMap으로 객체 생성
        getMap = new HashMap<>();
        postMap = new HashMap<>();

        // "/" 경로로 HomeController의 getIndex 메소드를 찾을 수 있다.(메소드 참조)
        // put으로 Map에 아이템을 넣어준다
        getMap.put("/", homeController::getIndex);

        // GET 요청에 대한 매핑
        getMap.put("/todo/list", todoController::getList);
        getMap.put("/todo/view", todoController::getView);
        getMap.put("/todo/create", todoController::getCreate);
        getMap.put("/todo/update", todoController::getUpdate);

        // POST 요청에 대한 매핑
        postMap.put("/todo/create", todoController::postCreate);
        postMap.put("/todo/update", todoController::postUpdate);
        postMap.put("/todo/delete", todoController::postDelete);
    }

    // 요청 URL에서 식별값만 잘라서 반환하는 메소드
    private String getCommandName(HttpServletRequest request) {
        String requestURI = request.getRequestURI(); // "/context값/식별값"
        String contextPath = request.getContextPath(); // "/context값"
        // substring(시작인덱스): 해당 인덱스부터 문자열을 잘라줌
        return requestURI.substring(contextPath.length()); // "/식별값"
    }

    // 요청 URL에서 식별값에 해당하는 command를 반환해주는 메소드
    private Command getCommand(HttpServletRequest request) {
        // request에서 command 이름만 추출
        String commandName = getCommandName(request);

        Command command;

        // request에서 받아온 메소드가 GET이면 getMap에서 커맨드 찾기
        if (request.getMethod().equalsIgnoreCase("GET")) {
            command = getMap.get(commandName);
        } else {
            // request에서 받아온 메소드가 POST면 postMap에서 커맨드 찾기
            command = postMap.get(commandName);
        }

        return command; // command 반환
    }

    // 커맨드를 실행하는 메소드
    public void execute(Command command, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // 실행 결과는 jsp의 이름으로 받아옴
        String viewName = command.execute(request, response);

        if (viewName.startsWith("redirect:")) {
            // 리다이렉트 처리
            response.sendRedirect(viewName.substring("redirect:".length()));
        } else {
            // forward 처리
            String view = prefix + viewName + suffix;
            RequestDispatcher dis = request.getRequestDispatcher(view);
            dis.forward(request, response);
        }
    }

    // GET 요청을 처리해주는 메소드
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Command command = getCommand(request);

        if (command != null) {
            execute(command, request, response);
        } else {
            String view = prefix + "404" + suffix;
            RequestDispatcher dis = request.getRequestDispatcher(view);
            dis.forward(request, response);
        }
    }

    // POST 요청을 처리해주는 메소드
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
