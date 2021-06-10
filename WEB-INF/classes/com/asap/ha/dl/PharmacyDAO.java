package com.asap.ha.dl;
import java.sql.*;
import java.util.*;
public class PharmacyDAO
{
public PharmacyDTO getByPharmacyId(String pharmacyId) throws DAOException
{
if(pharmacyId.trim()==null) throw new DAOException("Invalid pharmacy id : "+pharmacyId);
int actualPharmacyId=Integer.parseInt(pharmacyId.substring(1));
Connection connection;
connection=DAOConnection.getConnection();
PharmacyDTO pharmacyDTO;
try
{
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from pharmacies where pharmacy_id=?");
preparedStatement.setInt(1,actualPharmacyId);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Pharmacy Id does not exists : "+pharmacyId);
}
pharmacyDTO=new PharmacyDTO();
String name=resultSet.getString("pharmacy_name").trim();
String address=resultSet.getString("pharmacy_address").trim();
Long contactNumber=resultSet.getLong("pharmacy_contact_number");
String aboutHospital=resultSet.getString("about_pharmacy").trim();
pharmacyDTO.setName(name);
pharmacyDTO.setAddress(address);
pharmacyDTO.setContactNumber(contactNumber);
pharmacyDTO.setAboutPharmacy(aboutHospital);
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return pharmacyDTO;
}

public List<PharmacyDTO> getAll() throws DAOException
{
List<PharmacyDTO> pharmacies;
pharmacies=new LinkedList<>();
try
{
Connection connection=DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from pharmacies");
PharmacyDTO pharmacyDTO;
while(resultSet.next())
{
int pharmacyId=resultSet.getInt("pharmacy_id");
String name=resultSet.getString("pharmacy_name").trim();
String address=resultSet.getString("pharmacy_address").trim();
Long contactNumber=resultSet.getLong("pharmacy_contact_number");
String aboutPharmacy=resultSet.getString("about_pharmacy").trim();
pharmacyDTO=new PharmacyDTO();
pharmacyDTO.setPharmacyId("P"+pharmacyId);
pharmacyDTO.setName(name);
pharmacyDTO.setAddress(address);
pharmacyDTO.setContactNumber(contactNumber);
pharmacyDTO.setAboutPharmacy(aboutPharmacy);
pharmacies.add(pharmacyDTO);
}
resultSet.close();
statement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
return pharmacies;
}


public boolean pharmacyIdExists(String pharmacyId) throws DAOException
{
boolean exists=false;
try
{
if(pharmacyId.trim()==null) throw new DAOException("Invalid pharmacy id : "+pharmacyId);
int actualPharmacyId=Integer.parseInt(pharmacyId.substring(1));
Connection connection;
connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select name from pharmacies where pharmacy_id=?");
preparedStatement.setInt(1,actualPharmacyId);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
exists=resultSet.next();
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return exists;
}
}
