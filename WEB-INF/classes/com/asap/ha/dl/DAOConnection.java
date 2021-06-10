package com.asap.ha.dl;
import java.sql.*;
import java.lang.reflect.*;
public class DAOConnection
{
private DAOConnection(){}
public static Connection getConnection() throws DAOException
{
Connection connection=null;
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/apdb","apdbuser","apdbuser");
return connection;
}catch(Throwable t)
{
throw new DAOException(t.getMessage());
}
}
}