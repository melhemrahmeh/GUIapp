import java.sql.*;

public class DB {
    public static String getTechnicians(String location){
        String result = "";
        String url = "jdbc:mysql://localhost:3306/laboratory";
        String username = "root";
        String passwd = "####";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, passwd);

            Statement stmt = connection.createStatement();
            String getTechnicians = "select tno , tname, tjob , tmgr , thiredate  ,tsalary , tbonus  from  technician , lab  where technician.tlno = lab.lno and lab.llocation = \""+location+"\";";

            ResultSet resultSet = stmt.executeQuery(getTechnicians);

            while (resultSet.next()) {
                int id = resultSet.getInt("tno");
                String name = resultSet.getString("tname");
                String job = resultSet.getString("tjob");
                int mgr = resultSet.getInt("tmgr");
                Date hiredate = resultSet.getDate("thiredate");
                int salary = resultSet.getInt("tsalary");
                int bonus = resultSet.getInt("tbonus");

                String mgrnamequery = "select tname from technician where technician.tno = "+mgr+";";
                Statement statement = connection.createStatement();
                ResultSet mgrnameset = statement.executeQuery(mgrnamequery);
                String mgrname = "";
                while (mgrnameset.next()) {
                    mgrname = mgrnameset.getString("tname");
                }
                result+=("id & Name: " +id + " , "+ name + " ; Job: " + job +" , His manager is " + mgrname + " , hired on: " + (hiredate) +", Salary: " + salary + ", bonus: "+bonus+"\n");
            }

        } catch (ClassNotFoundException | SQLException e) { e.printStackTrace(); }
        return result;
    }

    public static String getLabInfo(String location){
        String result = "";
        String url = "jdbc:mysql://localhost:3306/laboratory";
        String username = "root";
        String passwd = "####";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, passwd);

            Statement stmt = connection.createStatement();
            String getLabInfo = "call getLabInfo(\""+location+"\");";

            ResultSet resultSet = stmt.executeQuery(getLabInfo);

            while (resultSet.next()) {
                String lname = resultSet.getString("lname");
                String maxSalary = resultSet.getString("max(tsalary)");
                String minSalary = resultSet.getString("min(tsalary)");
                String avgSalary = resultSet.getString("avg(tsalary)");
                String count = resultSet.getString("count(*)");

                result+= ("Lab Name: "+lname +", Max Salary: "+ maxSalary +" , Min Salary: "+ minSalary +" , Average Salary: "+ avgSalary +" , Number of Technicians: "+ count+"\n");
            }
        } catch (ClassNotFoundException | SQLException e) { e.printStackTrace(); }
        return result;
    }
}