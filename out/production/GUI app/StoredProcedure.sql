DELIMITER //

CREATE procedure getLabInfo(
	IN location VARCHAR(20)
)
Begin
	select lname , max(tsalary) , min(tsalary) , avg(tsalary) , count(*) from  technician, lab where technician.tlno = lab.lno and lab.llocation=location group by lname , lno ;
End //

DELIMITER ;