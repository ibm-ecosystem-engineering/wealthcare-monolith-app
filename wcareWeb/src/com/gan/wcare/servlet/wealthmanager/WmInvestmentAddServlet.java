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


@WebServlet(name = "WmInvestmentAddServlet", urlPatterns = {"/WmInvestmentAdd"})
public class WmInvestmentAddServlet extends HttpServlet {

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
        	int goalId = (int)request.getSession().getAttribute("goalId");
        	String nextPage = null;
        	
        	//investmentAdd
        	if ("investmentAdd".equalsIgnoreCase(action)) {
        		
        		double investmentAmount = NumberUtil.stringToDouble(request.getParameter("investmentAmount"));

        		WcInvestment wcInvestment = new WcInvestment();
        		wcInvestment.setWcGoalId(goalId);
        		wcInvestment.setInvestmentDate(new Date());
        		wcInvestment.setInvestmentAmount(investmentAmount);

                wcInvestmentEJB.create(wcInvestment);
                
                nextPage = "/WmFinancialPlanDetail";

        	} else { //Open Add Investment page
        		
                GoalInfo goalInfo = wcGoalEJB.findInfo(goalId);
        		request.setAttribute("mainData", goalInfo);
        		
            	nextPage = "/wm/wm_investement_add.jsp";
        	}
        	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request,response);
        }
    }
    
    

}

