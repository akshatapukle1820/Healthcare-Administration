package com.asap.ha.dl;
import java.sql.*;
import java.util.*;
public class DoctorDAO
{
public DoctorDTO getByDoctorId(String doctorId) throws DAOException
{
DoctorDTO doctorDTO=null;
try
{
int actualDoctorId=0;
try
{
actualDoctorId=Integer.parseInt(doctorId.substring(1));
}catch(NumberFormatException nfe)
{
throw new DAOException("Invalid doctor's id : "+doctorId);
}
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select doctor_name,working_place,working_hours,specialization,doctor_contact_number,about_doctor from doctors where doctor_id=?");
preparedStatement.setInt(1,actualDoctorId);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid doctor id : "+doctorId);
}
String name=resultSet.getString("doctor_name").trim();
String workingPlace=resultSet.getString("working_place").trim();
String workingHours=resultSet.getString("working_hours").trim();
String specialization=resultSet.getString("specialization").trim();
Long contactNumber=resultSet.getLong("doctor_contact_number");
String aboutDoctor=resultSet.getString("about_doctor");
doctorDTO=new DoctorDTO();
doctorDTO.setDoctorId(doctorId);
doctorDTO.setName(name);
doctorDTO.setWorkingPlace(workingPlace);
doctorDTO.setSpecialization(specialization);
doctorDTO.setContactNumber(contactNumber);
doctorDTO.setAboutDoctor(aboutDoctor);
doctorDTO.setWorkingHours(workingHours);
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}
return doctorDTO;
}

public List<DoctorDTO> getAll() throws DAOException
{
List<DoctorDTO> doctors;
doctors=new LinkedList<>();
try
{
DoctorDTO doctorDTO;
Connection connection=DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select * from doctors");
PharmacyDTO pharmacyDTO;
while(resultSet.next())
{
int doctorId=resultSet.getInt("doctor_id");
String name=resultSet.getString("doctor_name").trim();
String workingPlace=resultSet.getString("working_place").trim();
String workingHours=resultSet.getString("working_hours").trim();
String specialization=resultSet.getString("specialization").trim();
Long contactNumber=resultSet.getLong("doctor_contact_number");
String aboutDoctor=resultSet.getString("about_doctor").trim();
doctorDTO=new DoctorDTO();
doctorDTO.setDoctorId("D"+doctorId);
doctorDTO.setName(name);
doctorDTO.setWorkingPlace(workingPlace);
doctorDTO.setWorkingHours(workingHours);
doctorDTO.setSpecialization(specialization);
doctorDTO.setContactNumber(contactNumber);
doctorDTO.setAboutDoctor(aboutDoctor);
doctors.add(doctorDTO);
}
resultSet.close();
statement.close();
connection.close();
}catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
return doctors;
}
}