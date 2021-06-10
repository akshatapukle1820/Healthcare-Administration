package com.asap.ha.dl;
import java.sql.*;
import java.util.*;
public class HospitalDAO
{
public HospitalDTO getByHospitalId(String hospitalId) throws DAOException
{
HospitalDTO hospitalDTO=null;
try
{
int actualHospitalId=0;
try
{
actualHospitalId=Integer.parseInt(hospitalId.substring(1));
}catch(NumberFormatException nfe)
{
throw new DAOException("Invalid hospital's id : "+hospitalId);
}
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select hospitals.hospital_name,hospitals.hospital_address,hospitals.hospital_contact_number,hospitals.total_beds,hospitals.is_covid_patient,hospitals.category,hospitals.about_hospital from hospitals where hospital_id=?");
preparedStatement.setInt(1,actualHospitalId);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid Hospital Id : "+hospitalId);
}
hospitalDTO=new HospitalDTO();
String name=resultSet.getString("hospital_name").trim();
hospitalDTO.setHospitalId(hospitalId);
hospitalDTO.setName(name);
String address=resultSet.getString("hospital_address").trim();
hospitalDTO.setAddress(address);
Long contactNumber=resultSet.getLong("hospital_contact_number");
hospitalDTO.setContactNumber(contactNumber);
int totalBeds=resultSet.getInt("total_beds");
hospitalDTO.setTotalBeds(totalBeds);
boolean isCovidPatient=resultSet.getBoolean("is_covid_patient");
String category=resultSet.getString("category");
String aboutHospital=resultSet.getString("about_hospital");
hospitalDTO.setIsCovidPatient(isCovidPatient);
hospitalDTO.setAboutHospital(aboutHospital);
hospitalDTO.setCategory(category);
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
return hospitalDTO;
}

public List<HospitalDTO> getAll() throws DAOException
{
List<HospitalDTO> hospitals;
try
{
hospitals=new LinkedList<>();
Connection connection=DAOConnection.getConnection();
Statement statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from hospitals");
while(resultSet.next())
{
int hospitalId=resultSet.getInt("hospital_id");
String name=resultSet.getString("hospital_name").trim();
String address=resultSet.getString("hospital_address").trim();
Long contactNumber=resultSet.getLong("hospital_contact_number");
int totalBeds=resultSet.getInt("total_beds");
boolean isCovidPatient=resultSet.getBoolean("is_covid_patient");
String category=resultSet.getString("category").trim();
String aboutHospital=resultSet.getString("about_hospital").trim();
HospitalDTO hospitalDTO=new HospitalDTO();
hospitalDTO.setHospitalId("H"+hospitalId);
hospitalDTO.setName(name);
hospitalDTO.setAddress(address);
hospitalDTO.setContactNumber(contactNumber);
hospitalDTO.setTotalBeds(totalBeds);
hospitalDTO.setIsCovidPatient(isCovidPatient);
hospitalDTO.setCategory(category);
hospitalDTO.setAboutHospital(aboutHospital);
hospitals.add(hospitalDTO);
}
resultSet.close();
statement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return hospitals;
}

public boolean hospitalIdExists(String hospitalId) throws DAOException
{
if(hospitalId.trim()==null) throw new DAOException("Hospital Id should not be null");
boolean exists=false;
int actualHospitalId=Integer.parseInt(hospitalId.substring(1));
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select category from hospitals where hospital_id=?");
preparedStatement.setInt(1,actualHospitalId);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
exists=resultSet.next();
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
return exists;
}

public boolean hospitalAddressExists(String address) throws DAOException
{
if(address.trim()==null) throw new DAOException("Hospital Address should not be null");
boolean exists=false;
HospitalDTO hospital=new HospitalDTO();
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select category from hospital where hospital_address=?");
preparedStatement.setString(1,address);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
exists=resultSet.next();
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
return exists;
}

public boolean contactNumberExists(long contactNumber) throws DAOException
{
if(contactNumber==0) throw new DAOException("Hospital contact number should not be 0");
boolean exists=false;
HospitalDTO hospital=new HospitalDTO();
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select category from hospitals where hospital_contact_number=?");
preparedStatement.setLong(1,contactNumber);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
exists=resultSet.next();
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
return exists;
}
}