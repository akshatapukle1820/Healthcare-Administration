package com.asap.ha.servlets;
import javax.servlet.http.*;
import javax.servlet.*;
import com.asap.ha.beans.*;
import com.asap.ha.dl.*;
public class Login extends HttpServlet
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
String username=administratorBean.getUsername().trim();
String password=administratorBean.getPassword().trim();
int us=username.length();
int ps=password.length();
if(us==0)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError("Please enter username/password");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;
}
if(ps==0)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError("Please enter username/password");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;
}
AdministratorDAO administratorDAO=new AdministratorDAO();
try
{
AdministratorDTO administratorDTO=administratorDAO.getByUsername(username);
String DTOpassword=administratorDTO.getPassword();
if(password.equals(DTOpassword)==false)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError("Invalid password");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
requestDispatcher.forward(request,response);
return;
}
HttpSession session=request.getSession();
session.setAttribute("username",username);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/index.jsp");
requestDispatcher.forward(request,response);
}catch(DAOException daoException)
{
ErrorBean errorBean;
errorBean=new ErrorBean();
errorBean.setError("Invalid username/password");
request.setAttribute("errorBean",errorBean);
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
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