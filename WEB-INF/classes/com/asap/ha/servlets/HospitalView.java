package com.asap.ha.servlets;
import javax.servlet.http.*;
import javax.servlet.*;
import com.asap.ha.beans.*;
import com.asap.ha.dl.*;
public class HospitalView extends HttpServlet
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
String hospitalString=request.getParameter("hospitalId");
if(hospitalString==null)
{
requestDispatcher=request.getRequestDispatcher("/Hospitals.jsp");
requestDispatcher.forward(request,response);
return;
}
HospitalDAO hospitalDAO=new HospitalDAO();
try
{
HospitalDTO hospital=hospitalDAO.getByHospitalId(hospitalString);
String name=hospital.getName().trim();
String address=hospital.getAddress().trim();
long contactNumber=hospital.getContactNumber();
int totalBeds=hospital.getTotalBeds();
boolean isCovidPatient=hospital.getIsCovidPatient();
String category=hospital.getCategory().trim();
String aboutHospital=hospital.getAboutHospital().trim();
HospitalBean hospitalBean;
hospitalBean=new HospitalBean();
request.setAttribute("hospitalBean",hospitalBean);
hospitalBean.setName(name);
hospitalBean.setAddress(address);
hospitalBean.setContactNumber(contactNumber);
hospitalBean.setTotalBeds(totalBeds);
hospitalBean.setIsCovidPatient(isCovidPatient);
hospitalBean.setCategory(category);
hospitalBean.setAboutHospital(aboutHospital);
requestDispatcher=request.getRequestDispatcher("/HospitalViewForm.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
requestDispatcher=request.getRequestDispatcher("/Hospitals.jsp");
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