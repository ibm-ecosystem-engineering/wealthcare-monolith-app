package com.gan.wcare.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gan.wcare.common.NumberUtil;
import com.gan.wcare.ejb.model.LoginInfo;
import com.gan.wcare.ejb.user.LoginServiceEJB;


@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginServlet extends HttpServlet {

    @EJB
    private LoginServiceEJB loginServiceEJB;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		process(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		process(request, response);
    }

    protected void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        	String action = request.getParameter("action");
        	String nextPage = null;
        	
        	//Logout
        	if ("logout".equalsIgnoreCase(action)) { 
                request.getSession().removeAttribute("loginInfo");
                request.getSession().removeAttribute("userDisplayText");
                request.getSession().removeAttribute("userDisplayId");
                request.getSession().removeAttribute("goalId");
                request.getSession().removeAttribute("customerId");
                request.getSession().removeAttribute("customerName");
                request.getSession().removeAttribute("customerDisplayText");
                request.getSession().removeAttribute("wealthManagerId");
                nextPage = "/index.jsp";
        	} else { 
            	String loginId = request.getParameter("loginId");
                String password = request.getParameter("password");

                LoginInfo loginInfo = new LoginInfo();
                loginInfo.setLoginId(loginId);
                loginInfo.setPassword(password);
                
                loginServiceEJB.processLogin(loginInfo);
                
                String userRole = loginInfo.getUserRole();
                
                String userDisplayText = null;
                
                if ("BM".equalsIgnoreCase(userRole)) {
                	nextPage = "/BmCustomerList";
                	userDisplayText = "Bussiness Manager : " + loginInfo.getUserDisplayName();
                } else if ("WM".equalsIgnoreCase(userRole))  {
                	nextPage = "/WmCustomerList";
                	userDisplayText = "Welath Manager : " + loginInfo.getUserDisplayName();
                	request.getSession().setAttribute("wealthManagerId", NumberUtil.stringToInt(loginInfo.getUserDisplayId()));
                } else {
                	request.getSession().setAttribute("customerId", NumberUtil.stringToInt(loginInfo.getUserDisplayId()));
                	nextPage = "/CusFinancialPlanList";
                	userDisplayText = "Customer : " + loginInfo.getUserDisplayName();
                }

                request.getSession().setAttribute("loginInfo", loginInfo);
                request.getSession().setAttribute("userDisplayText", userDisplayText);
                request.getSession().setAttribute("userDisplayId", loginInfo.getUserDisplayId());
        	}
        	
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request,response);

        }
    }

}

