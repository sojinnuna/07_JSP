package org.scoula.ex03.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class PerformanceFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 초기화 코드가 필요하면 여기에 추가
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        long start = System.currentTimeMillis();

        // 요청을 필터 체인으로 전달
        chain.doFilter(request, response);

        long end = System.currentTimeMillis();
        System.out.println("실행 시간: " + (end - start) + " ms");
    }

    @Override
    public void destroy() {
        // 필터가 제거될 때 수행할 정리 코드가 필요하면 여기에 추가
    }
}
