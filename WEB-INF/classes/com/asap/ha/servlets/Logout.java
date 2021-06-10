package com.asap.ha.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
public class Logout extends HttpServlet
{
public void doPost(HttpServletRequest request, HttpServletResponse response)
{
doGet(request,response);
}
public void doGet(HttpServletRequest request, HttpServletResponse response)
{
HttpSession session=request.getSession();
//session.removeAttribute("username"); or
session.invalidate();
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/LoginForm.jsp");
try
{
requestDispatcher.forward(request,response);
}catch(Exception e)
{
//do nothing
}
}
}