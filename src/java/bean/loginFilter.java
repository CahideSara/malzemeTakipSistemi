/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.user;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
@WebFilter("/*")
public class loginFilter implements Filter {

    user u;
    user u2;
    user u3;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = req.getRequestURI();
        u = (user) req.getSession().getAttribute("valid_user");
        u2 = (user) req.getSession().getAttribute("valid_amir");
        u3 = (user) req.getSession().getAttribute("valid_calisan");

        if (u == null && u2 == null && u3 == null) {

            if (url.contains("admin") || url.contains("amir") || url.contains("calısan")) {
                res.sendRedirect(req.getContextPath() + "/index.xhtml");
            } else {
                chain.doFilter(request, response);
            }

        } else {
            if (u2 == null && u3 == null && u != null) {
                if (url.contains("amir") || url.contains("calısan")) {
                    res.sendRedirect(req.getContextPath() + "/index.xhtml");
                } else if (url.contains("index")) {
                    res.sendRedirect(req.getContextPath() + "/admin/user/malzeme.xhtml");
                } else if (url.contains("logout")) {

                    res.sendRedirect(req.getContextPath() + "/index.xhtml");
                } else {
                    chain.doFilter(request, response);
                }

            } else if (u == null && u3 == null && u2 != null) {
                if (url.contains("admin") || url.contains("calısan")) {
                    res.sendRedirect(req.getContextPath() + "/index.xhtml");
                } else if (url.contains("index")) {
                    res.sendRedirect(req.getContextPath() + "/amir/user/malzeme.xhtml");
                } else if (url.contains("logout")) {

                    res.sendRedirect(req.getContextPath() + "/index.xhtml");
                } else {
                    chain.doFilter(request, response);
                }

            } else if (u == null && u2 == null && u3 != null) {
                if (url.contains("admin") || url.contains("amir")) {
                    res.sendRedirect(req.getContextPath() + "/index.xhtml");
                } else if (url.contains("index")) {
                    res.sendRedirect(req.getContextPath() + "/calısan/user/malzeme.xhtml");
                } else if (url.contains("logout")) {

                    res.sendRedirect(req.getContextPath() + "/index.xhtml");
                } else {
                    chain.doFilter(request, response);
                }

            }
        }

    }

}
