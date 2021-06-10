package com.asap.ha.servlets;
import javax.servlet.http.*;
import javax.servlet.*;
import com.asap.ha.beans.*;
import com.asap.ha.dl.*;
public class DoctorView extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
doPost(request,response);
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
RequestDispatcher requestDispatcher;
try
{
String doctorString=request.getParameter("doctorId");
if(doctorString==null)
{
requestDispatcher=request.getRequestDispatcher("/Doctors.jsp");
requestDispatcher.forward(request,response);
return;
}
DoctorDAO doctorDAO=new DoctorDAO();
try
{
DoctorDTO doctor=doctorDAO.getByDoctorId(doctorString);
String name=doctor.getName().trim();
String workingPlace=doctor.getWorkingPlace().trim();
String workingHours=doctor.getWorkingHours().trim();
String specialization=doctor.getSpecialization().trim();
long contactNumber=doctor.getContactNumber();
String aboutDoctor=doctor.getAboutDoctor().trim();
DoctorBean doctorBean;
doctorBean=new DoctorBean();
request.setAttribute("doctorBean",doctorBean);
doctorBean.setDoctorId(doctorString);
doctorBean.setName(name);
doctorBean.setWorkingPlace(workingPlace);
doctorBean.setWorkingHours(workingHours);
doctorBean.setSpecialization(specialization);
doctorBean.setContactNumber(contactNumber);
doctorBean.setAboutDoctor(aboutDoctor);
requestDispatcher=request.getRequestDispatcher("/DoctorViewForm.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
requestDispatcher=request.getRequestDispatcher("/Doctors.jsp");
requestDispatcher.forward(request,response);
}
}catch(Exception exception)
{
requestDispatcher=request.getRequestDispatcher("/ErrorPage.jsp");
try
{
requestDispatcher.forward(request,response); 
}catch(Exception e)
{
//do nothing
}
}
}
}