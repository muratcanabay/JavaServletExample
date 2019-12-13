package com.uniyaz.javaOdev;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SavePeople implements Servlet {
    List<String> personList = new ArrayList<>();

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        String tip = servletRequest.getParameter("tip");
        String ad = servletRequest.getParameter("ad");
        String soyad = servletRequest.getParameter("soyad");

        servletResponse.setCharacterEncoding("UTF-8");

        if (tip.equals("kaydet")&&(ad!=null && soyad!=null)){
            personList.add(ad+" "+soyad);
            System.out.println(ad+" "+soyad +" kaydi basariyla eklendi.");
        }
        else if (tip.equals("listele")&&personList.size()!=0){
            for (int i = 0; i < personList.size(); i++) {
                servletResponse.getWriter().write(personList.get(i) + "\n");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
