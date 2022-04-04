create schema laboratory;

create table LAB (  
	lno INT NOT NULL primary key,  
    	lname VARCHAR(20) NOT NULL,  
    	llocation VARCHAR(20) NOT NULL 
);

insert into LAB (lno , lname , llocation) 
values  
	(10, "King Wood Lab", "New York"), 
	(20, "Happiness Lab", "Dallas"), 
	(30, "Checklist Lab", "Chicago"), 
	(40, "Saint Peters Lab", "Boston");

create table TECHNICIAN (  
	tno INT NOT NULL primary KEY,  
	tname VARCHAR(20) NOT NULL,  
	tjob VARCHAR(20) NOT NULL,  
	tmgr INT,  
	thiredate DATE NOT NULL,  
	tsalary INT NOT NULL, 
	tbonus INT NULL, 
	tlno INT NOT NULL,    
	foreign key (tlno) references LAB(lno)      
	ON DELETE RESTRICT  ON UPDATE CASCADE,  
	foreign key (tmgr) references TECHNICIAN(tno)      
	ON DELETE RESTRICT  ON UPDATE CASCADE  );
 
insert into TECHNICIAN (tno , tname , tjob , tmgr  , thiredate , tsalary , tbonus , tlno)
values 
	(7839, "King", "President", NULL, "2003-11-17", 6500, 0, 10),
	(7566, "Jones", "Director", 7839, "2003-04-02", 3375, 0, 20),
	(7698, "Blake", "Director", 7839, "2003-05-01", 3250, 0, 30),
	(7782, "Clark", "Director", 7839, "2003-06-09", 2850, 0, 10),
	(7499, "Allen", "Head Technician", 7698,"2003-02-20", 2000, 500, 30),
	(7521, "Ward", "Head Technician", 7698, "2003-02-22", 1650, 800, 30),
	(7654, "Martin", "Head Technician", 7698, "2003-09-28", 1650, 1400, 30),
	(7844, "Turner", "Head Technician", 7698, "2003-09-08", 1900, 0, 30),
	(7900, "James", "Assistant Technician", 7698, "2003-12-03", 1350, 0, 30),
	(7788, "Scott", "Technician", 7566, "2002-06-27", 3500, 0, 20),
	(7902, "Ford","Technician", 7566, "2003-12-03", 3500, 0, 20),
	(7369, "Smith", "Assistant Technician", 7902, "2002-12-17", 1200, 0, 20),
	(7876, "Adams", "Assistant Technician", 7788, "2002-07-31", 1500, 0, 20),
	(7934, "Miller", "Assistant Technician", 7782, "2003-01-23", 1700, 0, 10);
