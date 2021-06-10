package com.asap.ha.dl;
import java.sql.*;
import java.io.*;
import java.util.*;
public class AdministratorDAO
{
public void addUser(AdministratorDTO administratorDTO) throws DAOException
{
try
{
String username=administratorDTO.getUsername().trim();

String email=administratorDTO.getEmail().trim();

String password=administratorDTO.getPassword().trim();

if(username==null || email==null || password==null)
{
throw new DAOException("username/email/password should not be null");
}
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from login where username=?");
preparedStatement.setString(1,username);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Username : "+username+" already exists.");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("insert into login values (?,?,?)");
preparedStatement.setString(1,username);
preparedStatement.setString(2,email);
preparedStatement.setString(3,password);
preparedStatement.executeUpdate();
resultSet.close();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}

public AdministratorDTO getByUsername(String username) throws DAOException
{
try
{
if(username==null) throw new DAOException("Invalid username");
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from login where username=?");
preparedStatement.setString(1,username);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid username");
}
AdministratorDTO administratorDTO=new AdministratorDTO();
String email=resultSet.getString("email").trim();
String password=resultSet.getString("password").trim();
administratorDTO.setUsername(username);
administratorDTO.setEmail(email);
administratorDTO.setPassword(password);
resultSet.close();
preparedStatement.close();
connection.close();
return administratorDTO;
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}
}