package org.scoula.frontcontroller.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeController {
    // HttpServletRequest를 먼저 받고, HttpServletResponse를 두 번째로 받도록 수정
    public String getIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "index"; // index.jsp 이름을 반환
    }
}