package com.asap.ha.servlets;
import com.asap.ha.beans.*;
import com.asap.ha.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Appointment extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
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
String specialization=doctor.getSpecialization().trim();
DoctorBean doctorBean;
doctorBean=new DoctorBean();
request.setAttribute("doctorBean",doctorBean);
doctorBean.setName(name);
doctorBean.setSpecialization(specialization);
doctorBean.setDoctorId(doctorString);
requestDispatcher=request.getRequestDispatcher("/AppointmentForm.jsp");
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