package com.asap.ha.servlets;
import javax.servlet.http.*;
import javax.servlet.*;
import com.asap.ha.beans.*;
import com.asap.ha.dl.*;
public class CreateAccount extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
doPost(request,response);
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
try
{
AdministratorBean administratorBean;
administratorBean=(AdministratorBean)request.getAttribute("administratorBean");
if(administratorBean==null)
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/createAccountForm.jsp");
requestDispatcher.forward(request,response);
return;
}
String username=administratorBean.getUsername();
String email=administratorBean.getEmail();	
String password=administratorBean.getPassword();	
AdministratorDAO administratorDAO=new AdministratorDAO();
try
{
AdministratorDTO administratorDTO=new AdministratorDTO();
administratorDTO.setUsername(username);
administratorDTO.setEmail(email);
administratorDTO.setPassword(password);
administratorDAO.addUser(administratorDTO);
HttpSession session=request.getSession();
session.setAttribute("username",username);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/index.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError("Invalid username/email/password");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/createAccountForm.jsp");
requestDispatcher.forward(request,response);
return;
}
}catch(Exception exception)
{
RequestDispatcher requestDispatcher;
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