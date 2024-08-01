//package org.scoula.frontcontroller;
//
//import org.scoula.frontcontroller.command.Command;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.WebServlet;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Map;
//
//@WebServlet(name = "frontControllerServlet", value = "/")
//public class DispatcherServlet extends HttpServlet {
//    Map<String, Command> getMap;
//    Map<String, Command> postMap;
//
//    String prefix = "/WEB-INF/views/";
//    String suffix = ".jsp";
//
//    public void init() {
//        getMap = new HashMap<>();
//        postMap = new HashMap<>();
//        createMap(getMap, postMap);
//
//    }
//
//    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap){
//        getMap.put("/", homeController::getIndex);
//
//        getMap.put("/todo/list", todoController::getList);
//        getMap.put("/todo/view", todoController::getView);
//        getMap.put("/todo/create", todoController::getCreate);
//        getMap.put("/todo/update", todoController::getUpdate);
//
//        getMap.put("/todo/create", todoController::postCreate);
//        getMap.put("/todo/update", todoController::postUpdate);
//        getMap.put("/todo/delete", todoController::postDelete);
//    }
//
//    private String getCommandName(HttpServletRequest request) {
//        String requestURI = request.getRequestURI();
//        String contextPath = request.getContextPath();
//        return requestURI.substring(contextPath.length());
//    }
//
//    private Command getCommand(HttpServletRequest request) {
//        String commandName = getCommandName(request);
//
//        Command command;
//        if (request.getMethod().equalsIgnoreCase("GET")) {
//            command = getMap.get(commandName);
//        } else {
//            command = postMap.get(commandName);
//        }
//        return command;
//    }
//
//    public void execute(Command command, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//
//        String viewName = command.execute(request, response);
//        if (viewName.startsWith("redirect:")) {
//            response.sendRedirect(viewName.substring("redirect:".length()));
//        } else { // forward 처리
//            String view = prefix + viewName + suffix;
//            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
//            dispatcher.forward(request, response);
//        }
//    }
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        Command command = getCommand(request);
//
//        if (command != null) {
//            execute(command, request, response);
//        } else {
//            String view = prefix + "404" + suffix;
//            RequestDispatcher dis = request.getRequestDispatcher(view);
//            dis.forward(request, response);
//        }
//    }
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        doGet(request, response);
//    }
//}
//
