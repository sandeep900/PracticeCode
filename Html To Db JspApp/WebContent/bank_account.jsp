<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank page</title>
</head>
<body>


<%!
private Connection con=null;
private PreparedStatement ps1,ps2=null;
 private ResultSet rs=null;
public void jspInit(){
ServletConfig cg=getServletConfig();
ServletContext sc=getServletContext();

String dbuser=sc.getInitParameter("dbuser");
String dbpwd=cg.getInitParameter("dbpwd");
String driver=sc.getInitParameter("driver");
String url=sc.getInitParameter("url");


System.out.print(dbuser+"\n"+dbpwd+"\n"+driver+"\n"+url);

try{
 Class.forName(driver);
 con=DriverManager.getConnection(url,dbuser,dbpwd);
 
 ps1=con.prepareStatement("insert into jsp_bank_account values(?,?,?,?)");
 ps2=con.prepareStatement("select ACNO,HOLDERNAME,ADDRESS,BALANCE from jsp_bank_account");
}
catch(ClassNotFoundException e){
e.printStackTrace();
}
catch(Exception e1){
e1.printStackTrace();
}



}
 %>

<%  

String type= request.getParameter("submit");
if(type.equalsIgnoreCase("submit")){
 int acno=Integer.parseInt(request.getParameter("acno"));
 String hname=request.getParameter("aname");
String addrs=request.getParameter("addrs");
Double balance= Double.parseDouble(request.getParameter("ibal"));
ps1.setInt(1, acno);
ps1.setString(2,hname);
ps1.setString(3, addrs);
ps1.setDouble(4, balance);
int count=ps1.executeUpdate();
if (count==1)
out.print("Account opened successfully");
else 
out.print("account not opened");
}

else
{
//excute query

  rs=ps2.executeQuery();
 
//out.print("");

while(rs.next()){
%>
  Account no is::<%=rs.getInt(1)%>
  account holder name::<%= rs.getString(2) %>
  address::<%=rs.getString(3) %>
  Balance::<%=rs.getDouble(4) %>
  
  <% 
}
%>

<% 
}
%>



<%!
public void jspDestroy(){
try{
if(rs!=null)
rs.close();
}
catch (Exception se){
se.printStackTrace();
}


try{
if(con!=null)
con.close();
}
catch (Exception se){
se.printStackTrace();
}
try{
if(ps1!=null)
ps1.close();
}
catch (Exception se){
se.printStackTrace();
}
try{
if(ps2!=null)
ps2.close();
}
catch (Exception se){
se.printStackTrace();
}
}

 %> 



</body>
</html>