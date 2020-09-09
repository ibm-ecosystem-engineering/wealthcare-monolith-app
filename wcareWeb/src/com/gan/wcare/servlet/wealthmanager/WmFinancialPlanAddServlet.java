package com.gan.wcare.servlet.wealthmanager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.Column;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gan.wcare.common.DateUtil;
import com.gan.wcare.common.NumberUtil;
import com.gan.wcare.ejb.model.GoalInfo;
import com.gan.wcare.ejb.model.LoginInfo;
import com.gan.wcare.ejb.user.LoginServiceEJB;
import com.gan.wcare.ejb.user.WcCustomerEJB;
import com.gan.wcare.ejb.user.WcGoalEJB;
import com.gan.wcare.ejb.user.WcInvestmentEJB;
import com.gan.wcare.jpa.entity.WcCustomer;
import com.gan.wcare.jpa.entity.WcGoal;
import com.gan.wcare.jpa.entity.WcInvestment;


@WebServlet(name = "WmFinancialPlanAddServlet", urlPatterns = {"/WmFinancialPlanAdd"})
public class WmFinancialPlanAddServlet extends HttpServlet {

    @EJB
    private WcGoalEJB wcGoalEJB;
    @EJB
    private WcCustomerEJB wcCustomerEJB;
    @EJB
    private WcInvestmentEJB wcInvestmentEJB;

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
        	String nextPage = null;
        	
        	//goalAdd
        	if ("goalAdd".equalsIgnoreCase(action)) {
        		
        		String goalReference =request.getParameter("goalReference");
        		String goalDescription =request.getParameter("goalDescription");
        		String targetDate =request.getParameter("targetDate");
        		double targetAmount = NumberUtil.stringToDouble(request.getParameter("targetAmount"));

        		WcGoal wcGoal = new WcGoal();

        		wcGoal.setWcCustomerId((int) request.getSession().getAttribute("customerId"));
        		wcGoal.setWcWealthManagerId((int) request.getSession().getAttribute("wealthManagerId"));
        		                
        		wcGoal.setGoalReference(goalReference);
        		wcGoal.setGoalDesc(goalDescription);
        		wcGoal.setTargetDate(DateUtil.getDateDefaultToNYear(targetDate,5));
        		wcGoal.setTargetAmount(targetAmount);

                wcGoalEJB.create(wcGoal);
                
                nextPage = "/WmFinancialPlanList";

        	} else { //Open Add Goal page
        
            	nextPage = "/wm/wm_fp_add.jsp";
        	}
        	
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request,response);
        }
    }
    
    

}

