package kugou.connetction;


import java.io.PrintWriter;

import mondrian.olap.Connection;
import mondrian.olap.DriverManager;
import mondrian.olap.Query;
import mondrian.olap.Result;

public class HiveConnection {
	public static void main(String[] args) {
        Connection connection = DriverManager.getConnection(
                "Provider=mondrian;" +
                "Jdbc=jdbc:hive://10.1.0.200:10000/mondriantest;" +
                "JdbcUser=hadoop;JdbcPassword=kugou#_hadoop;" +
                "Catalog=MiniMart.xml;" +
                "JdbcDrivers=org.apache.hadoop.hive.jdbc.HiveDriver", null);
        System.out.println("..............................1");
	    Query query = connection.parseQuery(
                "select \n" +
                        "{[Measures].[numb],[Measures].[averPri],[Measures].[totalSale]} on columns,\n" +
                        "{([proType].[allPro],[cusGender].[allGender])} \n" +
                        "on rows\n" +
                        "from [Sales]\n");
	    System.out.println("..............................2");
        @SuppressWarnings("deprecation")
        Result result = connection.execute(query);
        PrintWriter pw = new PrintWriter(System.out);
        result.print(pw);
        pw.flush();
        System.out.println("..............................3");
	}
}
