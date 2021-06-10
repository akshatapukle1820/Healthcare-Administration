package com.asap.ha.dl;
import java.sql.*;
import java.util.*;
public class LinkDAO
{
public LinkDTO getByHospitalCode(String hospitalCode) throws DAOException
{
if(hospitalCode.trim()==null) throw new DAOException("Invalid hospital code : "+hospitalCode);
int actualHospitalCode=Integer.parseInt(hospitalCode.substring(1));
Connection connection;
connection=DAOConnection.getConnection();
LinkDTO linkDTO;
try
{
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from link where hospital_code=?");
preparedStatement.setInt(1,actualHospitalCode);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Hospital code does not exists : "+hospitalCode);
}
linkDTO=new LinkDTO();
while(resultSet.next())
{
String facilities=resultSet.getString("facilities").trim();
linkDTO.setFacilities(facilities);
}
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return linkDTO;
}
}