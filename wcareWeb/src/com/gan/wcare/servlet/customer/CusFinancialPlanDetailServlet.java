package com.gan.wcare.servlet.customer;

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
import com.gan.wcare.ejb.model.LoginInfo;
import com.gan.wcare.ejb.user.LoginServiceEJB;
import com.gan.wcare.ejb.user.WcCustomerEJB;
import com.gan.wcare.ejb.user.WcGoalEJB;
import com.gan.wcare.jpa.entity.WcCustomer;
import com.gan.wcare.jpa.entity.WcGoal;


@WebServlet(name = "CusFinancialPlanDetailServlet", urlPatterns = {"/CusFinancialPlanDetail"})
public class CusFinancialPlanDetailServlet extends HttpServlet {

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
            
        	//Read it from param 
        	String goalIdString = request.getParameter("goalId");
        	if (goalIdString != null) {
        		request.getSession().setAttribute("goalId",  NumberUtil.stringToInt(goalIdString));
        	} 
           
            int goalId = (int) request.getSession().getAttribute("goalId");
        		
            GoalInfo goalInfo = wcGoalEJB.findInfo(goalId);
    		request.setAttribute("mainData", goalInfo);
    		String nextPage = "/cus/cus_fp_detail.jsp";
        	
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request,response);
        }
    }
    
    

}

