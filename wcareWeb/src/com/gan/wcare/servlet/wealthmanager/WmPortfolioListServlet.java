package com.gan.wcare.servlet.wealthmanager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gan.wcare.common.NumberUtil;
import com.gan.wcare.ejb.model.GoalInfo;
import com.gan.wcare.ejb.user.WcCustomerEJB;
import com.gan.wcare.ejb.user.WcGoalEJB;


@WebServlet(name = "WmPortfolioListServlet", urlPatterns = {"/WmPortfolioList"})
public class WmPortfolioListServlet extends HttpServlet {

    @EJB
    private WcGoalEJB wcGoalEJB;
    @EJB
    private WcCustomerEJB wcCustomerEJB;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		process(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		process(request, response);
    }

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        	String action = request.getParameter("action");
        	
        	int customerId = (int)request.getSession().getAttribute("customerId");

        	String nextPage = null;

        	if (action == null || action.isEmpty()) {
        		List<GoalInfo> list = (List<GoalInfo>) wcGoalEJB.findInfoListByCustomerId(customerId);
        		request.setAttribute("mainData", list);
        		nextPage = "/wm/wm_portfolio_list.jsp";        		
        	}

        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request,response);
        }
    }

}

