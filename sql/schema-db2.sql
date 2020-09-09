	--    This schema file is for DB2

    drop table Wcusers;
	create table Wcusers (
        id INTEGER  NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 10001, INCREMENT BY 1),
        UserName varchar(40),
        Password varchar(40),
        EmailId varchar(40),
        role varchar(40),
        PRIMARY KEY (id)
    );

    drop table WcBusinessManager;
    create table WcBusinessManager (
        id INTEGER  NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 20001, INCREMENT BY 1),
        WcUserId INTEGER,
        FirstName varchar(40),
        LastName varchar(40),
        StartDate date,
        PRIMARY KEY (id)
    );

    drop table WcWealthManager;
    create table WcWealthManager (
        id INTEGER  NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 30001, INCREMENT BY 1),
        WcUserId INTEGER,
        FirstName varchar(40),
        LastName varchar(40),
        Gender varchar(10),
        City varchar(40),
        Phone varchar(10),
        EmailId varchar(40),
        StartDate date,
        Country varchar (20),
        ZipCode varchar (20),
        PRIMARY KEY (id)
    );

    drop table WcCustomer;
    create table WcCustomer (
        id INTEGER  NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 40001, INCREMENT BY 1),

        WcUserId INTEGER,
        WcWealthManagerId INTEGER,

        FirstName varchar(40),
        LastName varchar(40),
        Gender varchar(10),
        Age INTEGER,
        AvgIncome double,

        Married BOOLEAN,

        SpouseFirstName varchar(40),
        SpouseLastName varchar(40),
        SpouseGender varchar(10),
        SpouseAge INTEGER,
        SpouseAvgIncome double,

        NoOfChildren INTEGER,

        Child1FirstName varchar(40),
        Child1LastName varchar(40),
        Child1Gender varchar(10),
        Child1Age INTEGER,

        Child2FirstName varchar(40),
        Child2LastName varchar(40),
        Child2Gender varchar(10),
        Child2Age INTEGER,

        City varchar(40),
        Phone varchar(10),
        EmailId varchar(40),
        StartDate date,
        Country varchar (20),
        ZipCode varchar (20),

        PRIMARY KEY (id)
    );

    drop table WcGoal;
    create table WcGoal (
       id INTEGER  NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 50001, INCREMENT BY 1),
       WcCustomerId INTEGER,

       WcWealthManagerId INTEGER,
       GoalReference varchar(80),
       GoalDesc varchar(80),
       StartDate date,
       TargetDate date,
       TargetAmount double,

       PRIMARY KEY (id)
    );

    drop table WcInvestment;
    create table WcInvestment(
       id INTEGER  NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 60001, INCREMENT BY 1),
       WcGoalId INTEGER,
       InvestmentDate date,
       InvestmentAmount double,
       StockAmount double,
       MutualFundAmount double,
       FixedDepositAmount double,

       PRIMARY KEY (id)
    );
