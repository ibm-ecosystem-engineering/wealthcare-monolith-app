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
import com.gan.wcare.ejb.model.LoginInfo;
import com.gan.wcare.ejb.user.LoginServiceEJB;
import com.gan.wcare.ejb.user.WcCustomerEJB;
import com.gan.wcare.ejb.user.WcGoalEJB;
import com.gan.wcare.jpa.entity.WcCustomer;


@WebServlet(name = "WmFinancialPlanListServlet", urlPatterns = {"/WmFinancialPlanList"})
public class WmFinancialPlanListServlet extends HttpServlet {

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

        	int customerId =0;
        			
        	//Select the customer
        	if ("selectCustomer".equalsIgnoreCase(action)) {
            	
        		customerId = NumberUtil.stringToInt(request.getParameter("customerId"));

                String customerName = "";
                WcCustomer wcCustomer = wcCustomerEJB.find(customerId);
                if (wcCustomer != null) {
                	customerName = wcCustomer.getFirstName() + " " + wcCustomer.getLastName();
                }

                request.getSession().setAttribute("customerId", customerId);
                request.getSession().setAttribute("customerName", customerName);
                request.getSession().setAttribute("customerDisplayText", "Selected Customer : " + customerName);


            	//Delete Goal
        	} else if ("deleteGoal".equalsIgnoreCase(action)) {
        		
        		int goalId = NumberUtil.stringToInt(request.getParameter("goalId"));
        		wcGoalEJB.delete(goalId);
        		
            	customerId = (int)request.getSession().getAttribute("customerId");

        	} else {
            	customerId = (int)request.getSession().getAttribute("customerId");
        	}
        	
        	
    		List<GoalInfo> list = (List<GoalInfo>) wcGoalEJB.findInfoListByCustomerId(customerId);
    		request.setAttribute("mainData", list);
    		String nextPage = "/wm/wm_fp_list.jsp";        		
        	
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request,response);
        }
    }
    
    

}

