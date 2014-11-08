<%@ page session="true" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.tonbeller.com/jpivot" prefix="jp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<jp:mondrianQuery id="query01" 
    catalogUri="/WEB-INF/queries/tezz.xml" 
	jdbcDriver="com.mysql.jdbc.Driver" 
	jdbcUrl="jdbc:mysql://localhost:3306/mondrian_test;user=root;password=root"> 
select {[Measures].[数量],[Measures].[平均单价],[Measures].[总销售额]} ON columns,
  {([产品类别].[所有产品],[客户性别].[所有性别])} ON rows
from [Sales]

</jp:mondrianQuery>
<c:set var="title01" scope="session"> Sales </c:set>
