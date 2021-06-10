package com.asap.ha.dl;
import java.sql.*;
import java.util.*;
public class LinkDAO
{
public List<LinkDTO> getAll() throws DAOException
{
List<LinkDTO> facilities;
try
{
facilities=new LinkedList<>();
Connection connection=DAOConnection.getConnection();
Statement statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from link where hospital_code=?");
while(resultSet.next())
{
String facility=resultSet.getString("facilities");
LinkDTO linkDTO=new LinkDTO();
String name=resultSet.getString("hospital_name").trim();
linkDTO.setFacilities(facility);
facilities.add(linkDTO);
}
resultSet.close();
statement.close();
connection.close();
}catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
return facilities;
}
}