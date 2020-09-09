--  This sql is executed automatically when H2 db is enabled in application.properties. This will not be executed for DB2/mysql.
--  This sql file should be available in both wealthusers and wealthfinancialplan services where application.properties exists

--    START WITH 10001;
    insert into Wcusers (UserName, Password, EmailId, Role) values ('harry','harry','harry@wcare.com', 'BM');
    insert into Wcusers (UserName, Password, EmailId, Role) values ('charlie','charlie','charlie@wcare.com', 'BM');
    insert into Wcusers (UserName, Password, EmailId, Role) values ('oliver','oliver','oliver@wcare.com', 'BM');
    insert into Wcusers (UserName, Password, EmailId, Role) values ('jerald','jerald','jerald@wcare.com', 'WM');
    insert into Wcusers (UserName, Password, EmailId, Role) values ('charlotte','charlotte','charlotte@wcare.com', 'WM');
    insert into Wcusers (UserName, Password, EmailId, Role) values ('mia','mia','mia@wcare.com', 'WM');
    insert into Wcusers (UserName, Password, EmailId, Role) values ('tod','tod','tod@wcare.com', 'WM');
    insert into Wcusers (UserName, Password, EmailId, Role) values ('sophia','sophia','sophia@wcare.com', 'WM');
    insert into Wcusers (UserName, Password, EmailId, Role) values ('sam','sam','sam@wcare.com', 'WM');
    insert into Wcusers (UserName, Password, EmailId, Role) values ('william','william','william@wcare.com', 'CU');
    insert into Wcusers (UserName, Password, EmailId, Role) values ('sandy','sandy','sandy@wcare.com', 'CU');
    insert into Wcusers (UserName, Password, EmailId, Role) values ('david','david','david@wcare.com', 'CU');
    insert into Wcusers (UserName, Password, EmailId, Role) values ('richard','richard','richard@wcare.com', 'CU');
    insert into Wcusers (UserName, Password, EmailId, Role) values ('emma','emma','emma@wcare.com', 'CU');
    insert into Wcusers (UserName, Password, EmailId, Role) values ('tom','tom','tom@wcare.com', 'CU');

--    START WITH 20001;
    insert into WcBusinessManager (WcUserId, FirstName, LastName, StartDate) values (10001, 'Harry', 'Jack', '2012-02-01');
    insert into WcBusinessManager (WcUserId, FirstName, LastName, StartDate) values (10002, 'Charlie', 'Jacob', '2013-02-01');
    insert into WcBusinessManager (WcUserId, FirstName, LastName, StartDate) values (10003, 'Oliver', 'Noah', '2014-02-01');


--    START WITH 30001;
    insert into WcWealthManager (WcUserId, FirstName, LastName, Gender, City, Phone, EmailId, StartDate, Country, ZipCode)
            values (10004, 'Jerald', 'Lewis', 'Male', 'Austin', '423234323', 'jerald@wcare.com', '2014-02-01', 'US', '73301');
    insert into WcWealthManager (WcUserId, FirstName, LastName, Gender, City, Phone, EmailId, StartDate, Country, ZipCode)
            values (10005, 'Charlotte', 'Joseph', 'Female', 'San Jose', '564232323', 'charlotte@wcare.com', '2014-07-01', 'US', '94088');
    insert into WcWealthManager (WcUserId, FirstName, LastName, Gender, City, Phone, EmailId, StartDate, Country, ZipCode)
            values (10006, 'Mia', 'Richard', 'Female', 'Columbus', '754234323', 'mia@wcare.com', '2015-09-01', 'US', '43004');
    insert into WcWealthManager (WcUserId, FirstName, LastName, Gender, City, Phone, EmailId, StartDate, Country, ZipCode)
            values (10007, 'Tod', 'Peter', 'Male', 'Boston', '344234323', 'tod@wcare.com', '2017-02-01', 'US', '02101');
    insert into WcWealthManager (WcUserId, FirstName, LastName, Gender, City, Phone, EmailId, StartDate, Country, ZipCode)
            values (10008, 'Sophia', 'Vega', 'Female', 'Boston', '4523234323', 'sophia@wcare.com', '2018-02-01', 'US', '02101');
    insert into WcWealthManager (WcUserId, FirstName, LastName, Gender, City, Phone, EmailId, StartDate, Country, ZipCode)
            values (10009, 'Sam', 'Kim', 'Female', 'Raleigh', '3432332', 'sam@wcare.com', '2018-02-01', 'US', '27513');


--    START WITH 40001;
    insert into WcCustomer (WcUserId, WcWealthManagerId, FirstName, LastName, Gender, Age, AvgIncome, Married, SpouseFirstName, SpouseLastName, SpouseGender, SpouseAge, SpouseAvgIncome, NoOfChildren, Child1FirstName, Child1LastName, Child1Gender, Child1Age, Child2FirstName, Child2LastName, Child2Gender, Child2Age, City, Phone, EmailId, StartDate, Country, ZipCode)
           values (10010, 30001, 'William', 'Joseph', 'Male', 32, 1000000, true, 'Grace', 'William', 'Female', 28, 0,
                    1, 'Stoker', 'William', 'Male', 2, '', '', '', 0 ,'Chicago', '2309439084', 'william@wcare.com', '2015-02-01', 'IN', '60007');
    insert into WcCustomer (WcUserId, WcWealthManagerId, FirstName, LastName, Gender, Age, AvgIncome, Married, SpouseFirstName, SpouseLastName, SpouseGender, SpouseAge, SpouseAvgIncome, NoOfChildren, Child1FirstName, Child1LastName, Child1Gender, Child1Age, Child2FirstName, Child2LastName, Child2Gender, Child2Age, City, Phone, EmailId, StartDate, Country, ZipCode)
           values (10011, 30001, 'Sandy', 'Thomas', 'Male', 38, 1500000, true, 'Camila', 'Sandy', 'Female', 33, 0,
                    1, 'Franco', 'Sandy', 'Male', 2, '', '', '', 0 , 'New York', '3509439084', 'sandy@wcare.com', '2015-07-01', 'IN', '10001');
    insert into WcCustomer (WcUserId, WcWealthManagerId, FirstName, LastName, Gender, Age, AvgIncome, Married, SpouseFirstName, SpouseLastName, SpouseGender, SpouseAge, SpouseAvgIncome, NoOfChildren, Child1FirstName, Child1LastName, Child1Gender, Child1Age, Child2FirstName, Child2LastName, Child2Gender, Child2Age, City, Phone, EmailId, StartDate, Country, ZipCode)
           values (10012, 30002, 'David', 'John', 'Male', 39, 1700000, true, 'Mila', 'David', 'Female', 34, 1000000,
                    2, 'Jason', 'David', 'Male', 3, '', '', '', 0 , 'Chicago', '8909439084', 'david@wcare.com', '2016-02-01', 'IN', '60007');
    insert into WcCustomer (WcUserId, WcWealthManagerId, FirstName, LastName, Gender, Age, AvgIncome, Married, SpouseFirstName, SpouseLastName, SpouseGender, SpouseAge, SpouseAvgIncome, NoOfChildren, Child1FirstName, Child1LastName, Child1Gender, Child1Age, Child2FirstName, Child2LastName, Child2Gender, Child2Age, City, Phone, EmailId, StartDate, Country, ZipCode)
           values (10013, 30003, 'Richard', 'Charles', 'Male', 35, 1400000, true, 'Natalie', 'Richard', 'Female', 31, 800000,
                    2, 'Alex', 'Richard', 'Male', 3, 'Eva', 'Jam', 'Female', 2, 'New York', '7509439084', 'richard@wcare.com', '2017-02-01', 'IN', '10001');
    insert into WcCustomer (WcUserId, WcWealthManagerId, FirstName, LastName, Gender, Age, AvgIncome, Married, SpouseFirstName, SpouseLastName, SpouseGender, SpouseAge, SpouseAvgIncome, NoOfChildren, Child1FirstName, Child1LastName, Child1Gender, Child1Age, Child2FirstName, Child2LastName, Child2Gender, Child2Age, City, Phone, EmailId, StartDate, Country, ZipCode)
           values (10014, 30004, 'Emma', 'Francis', 'Female', 32, 1000000, true, 'Eason', 'Zyaire', 'Male', 38, 1600000,
                    1, 'Samuel', 'Eason', 'Male', 3, 'Palani', 'Kum', 'Male', 2, 'Chicago', '659439084', 'emma@wcare.com', '2017-05-01', 'IN', '60007');
    insert into WcCustomer (WcUserId, WcWealthManagerId, FirstName, LastName, Gender, Age, AvgIncome, Married, SpouseFirstName, SpouseLastName, SpouseGender, SpouseAge, SpouseAvgIncome, NoOfChildren, Child1FirstName, Child1LastName, Child1Gender, Child1Age, Child2FirstName, Child2LastName, Child2Gender, Child2Age, City, Phone, EmailId, StartDate, Country, ZipCode)
           values (10015, 30006, 'Tom', 'Alex', 'Male', 32, 1000000, true, 'Claire', 'Alex', 'Female', 38, 1600000,
                    1, 'Peter', 'Tom', 'Male', 3,  '', '', '', 0 , 'Chicago', '659439084', 'tom@wcare.com', '2017-05-01', 'US', '60007');


--    START WITH 50001;
    insert into WcGoal (WcCustomerId, WcWealthManagerId, GoalReference, GoalDesc, StartDate, TargetDate, TargetAmount)
           values (40001, 30001, '1', 'Buy a House in a Villa Gated Community', '2015-05-01', '2025-05-01', 27000000);
    insert into WcGoal (WcCustomerId, WcWealthManagerId, GoalReference, GoalDesc, StartDate, TargetDate, TargetAmount)
           values (40001, 30001, '2', 'Travel to Europe', '2016-05-01', '2026-05-01', 9000000);
    insert into WcGoal (WcCustomerId, WcWealthManagerId, GoalReference, GoalDesc, StartDate, TargetDate, TargetAmount)
           values (40001, 30001, '3', 'Save for Child’s Higher Education H2', '2017-05-01', '2027-05-01', 8000000);
    insert into WcGoal (WcCustomerId, WcWealthManagerId, GoalReference, GoalDesc, StartDate, TargetDate, TargetAmount)
           values (40002, 30001, '1', 'Buy a Flat H2', '2015-05-01', '2025-05-01', 6000000);
    insert into WcGoal (WcCustomerId, WcWealthManagerId, GoalReference, GoalDesc, StartDate, TargetDate, TargetAmount)
           values (40002, 30001, '2', 'Travel to USA', '2017-05-01', '2027-05-01', 5000000);
    insert into WcGoal (WcCustomerId, WcWealthManagerId, GoalReference, GoalDesc, StartDate, TargetDate, TargetAmount)
           values (40003, 30002, '1', 'Higher Education', '2017-05-01', '2027-05-01', 4000000);
    insert into WcGoal (WcCustomerId, WcWealthManagerId, GoalReference, GoalDesc, StartDate, TargetDate, TargetAmount)
           values (40004, 30003, '1', 'Travel Abroad', '2017-05-01', '2027-05-01', 6000000);
    insert into WcGoal (WcCustomerId, WcWealthManagerId, GoalReference, GoalDesc, StartDate, TargetDate, TargetAmount)
           values (40006, 30006, '1', 'Travel to Asia', '2017-05-01', '2027-05-01', 7000000);
    insert into WcGoal (WcCustomerId, WcWealthManagerId, GoalReference, GoalDesc, StartDate, TargetDate, TargetAmount)
           values (40001, 30001, '4', 'Travel to USA', '2019-05-01', '2022-05-01', 800000);
    insert into WcGoal (WcCustomerId, WcWealthManagerId, GoalReference, GoalDesc, StartDate, TargetDate, TargetAmount)
           values (40001, 30001, '5', 'Buy a Flat H2', '2022-05-01', '2025-05-01', 800000);
    insert into WcGoal (WcCustomerId, WcWealthManagerId, GoalReference, GoalDesc, StartDate, TargetDate, TargetAmount)
           values (40001, 30001, '6', 'Buy a BMW', '2019-06-01', '2026-05-01', 3800000);
    insert into WcGoal (WcCustomerId, WcWealthManagerId, GoalReference, GoalDesc, StartDate, TargetDate, TargetAmount)
           values (40001, 30001, '7', 'Travel to Asia', '2019-07-01', '2027-05-01', 7000000);


--   START WITH 60001;
    insert into WcInvestment (WcGoalId, InvestmentDate, InvestmentAmount, StockAmount, MutualFundAmount, FixedDepositAmount)
           values (50001, '2015-05-01', 400000, 100000, 200000, 100000);
    insert into WcInvestment (WcGoalId, InvestmentDate, InvestmentAmount, StockAmount, MutualFundAmount, FixedDepositAmount)
           values (50001, '2015-06-01', 600000, 310000, 200000, 100000);
    insert into WcInvestment (WcGoalId, InvestmentDate, InvestmentAmount, StockAmount, MutualFundAmount, FixedDepositAmount)
           values (50001, '2015-07-01', 500000, 100000, 200000, 200000);
    insert into WcInvestment (WcGoalId, InvestmentDate, InvestmentAmount, StockAmount, MutualFundAmount, FixedDepositAmount)
           values (50001, '2016-06-01', 400000, 100000, 200000, 100000);
    insert into WcInvestment (WcGoalId, InvestmentDate, InvestmentAmount, StockAmount, MutualFundAmount, FixedDepositAmount)
           values (50001, '2017-05-01', 500000, 200000, 200000, 100000);
    insert into WcInvestment (WcGoalId, InvestmentDate, InvestmentAmount, StockAmount, MutualFundAmount, FixedDepositAmount)
           values (50001, '2017-06-01', 300000, 100000, 100000, 100000);
    insert into WcInvestment (WcGoalId, InvestmentDate, InvestmentAmount, StockAmount, MutualFundAmount, FixedDepositAmount)
           values (50002, '2016-05-01', 300000, 100000, 100000, 100000);
    insert into WcInvestment (WcGoalId, InvestmentDate, InvestmentAmount, StockAmount, MutualFundAmount, FixedDepositAmount)
           values (50002, '2016-05-01', 700000, 300000, 200000, 300000);
    insert into WcInvestment (WcGoalId, InvestmentDate, InvestmentAmount, StockAmount, MutualFundAmount, FixedDepositAmount)
           values (50002, '2016-06-01', 400000, 100000, 200000, 100000);
    insert into WcInvestment (WcGoalId, InvestmentDate, InvestmentAmount, StockAmount, MutualFundAmount, FixedDepositAmount)
           values (50003, '2017-05-01', 500000, 200000, 200000, 100000);
    insert into WcInvestment (WcGoalId, InvestmentDate, InvestmentAmount, StockAmount, MutualFundAmount, FixedDepositAmount)
           values (50004, '2015-05-01', 400000, 200000, 100000, 100000);
    insert into WcInvestment (WcGoalId, InvestmentDate, InvestmentAmount, StockAmount, MutualFundAmount, FixedDepositAmount)
           values (50005, '2017-05-01', 300000, 100000, 100000, 100000);
    insert into WcInvestment (WcGoalId, InvestmentDate, InvestmentAmount, StockAmount, MutualFundAmount, FixedDepositAmount)
           values (50006, '2017-05-01', 400000, 100000, 100000, 200000);
    insert into WcInvestment (WcGoalId, InvestmentDate, InvestmentAmount, StockAmount, MutualFundAmount, FixedDepositAmount)
           values (50007, '2017-05-01', 700000, 200000, 300000, 200000);
    insert into WcInvestment (WcGoalId, InvestmentDate, InvestmentAmount, StockAmount, MutualFundAmount, FixedDepositAmount)
           values (50007, '2017-06-01', 300000, 100000, 100000, 100000);
    insert into WcInvestment (WcGoalId, InvestmentDate, InvestmentAmount, StockAmount, MutualFundAmount, FixedDepositAmount)
           values (50008, '2017-05-01', 400000, 100000, 200000, 100000);
    insert into WcInvestment (WcGoalId, InvestmentDate, InvestmentAmount, StockAmount, MutualFundAmount, FixedDepositAmount)
           values (50008, '2017-06-01', 300000, 100000, 100000, 100000);