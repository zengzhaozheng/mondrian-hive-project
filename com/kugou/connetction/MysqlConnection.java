package kugou.connetction;


import java.io.PrintWriter;

import mondrian.olap.Connection;
import mondrian.olap.DriverManager;
import mondrian.olap.Query;
import mondrian.olap.Result;

public class MysqlConnection {
	public static void main(String[] args) {
		Connection connection =  DriverManager.getConnection(
                "Provider=mondrian;" +
                        "Jdbc=jdbc:mysql://localhost:3306/mondrian_test; JdbcUser=root;" +
                        "JdbcPassword=root;" +
                        "Catalog=files/MiniMart.xml;" +
                        "JdbcDrivers=com.mysql.jdbc.Driver", null);
	    Query query = connection.parseQuery(
                "select \n" +
                        "{[Measures].[numb],[Measures].[averPri],[Measures].[totalSale]} on columns,\n" +
                        "{([proType].[allPro],[cusGender].[allGender])} \n" +
                        "on rows\n" +
                        "from [Sales]\n");

        @SuppressWarnings("deprecation")
        Result result = connection.execute(query);
        PrintWriter pw = new PrintWriter(System.out);
        result.print(pw);
        pw.flush();
	}
}
