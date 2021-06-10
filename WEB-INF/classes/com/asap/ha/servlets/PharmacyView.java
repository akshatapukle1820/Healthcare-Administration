package com.asap.ha.servlets;
import javax.servlet.http.*;
import javax.servlet.*;
import com.asap.ha.beans.*;
import com.asap.ha.dl.*;
public class PharmacyView extends HttpServlet
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
String pharmacyString=request.getParameter("pharmacyId");
if(pharmacyString==null)
{
requestDispatcher=request.getRequestDispatcher("/Pharmacies.jsp");
requestDispatcher.forward(request,response);
return;
}
PharmacyDAO pharmacyDAO=new PharmacyDAO();
try
{
PharmacyDTO pharmacy=pharmacyDAO.getByPharmacyId(pharmacyString);
String name=pharmacy.getName().trim();
String address=pharmacy.getAddress().trim();
long contactNumber=pharmacy.getContactNumber();
String aboutPharmacy=pharmacy.getAboutPharmacy().trim();
PharmacyBean pharmacyBean;
pharmacyBean=new PharmacyBean();
request.setAttribute("pharmacyBean",pharmacyBean);
pharmacyBean.setName(name);
pharmacyBean.setAddress(address);
pharmacyBean.setContactNumber(contactNumber);
pharmacyBean.setAboutPharmacy(aboutPharmacy);
requestDispatcher=request.getRequestDispatcher("/PharmacyViewForm.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);
requestDispatcher=request.getRequestDispatcher("/Pharmacies.jsp");
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