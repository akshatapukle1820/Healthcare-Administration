package com.asap.ha.beans;
public class AdministratorBean implements java.io.Serializable,Comparable<AdministratorBean>
{
private String username;
private String email;
private String password;
public AdministratorBean()
{
this.username="";
this.email="";
this.password="";
}
public void setUsername(String username)
{
this.username=username;
}
public String getUsername()
{
return this.username;
}
public void setEmail(String email)
{
this.email=email;
}
public String getEmail()
{
return this.email;
}
public void setPassword(String password)
{
this.password=password;
}
public String getPassword()
{
return this.password;
}
public boolean equals(Object object)
{
if(!(object instanceof AdministratorBean)) return false;
AdministratorBean other=(AdministratorBean)object;
return this.username.equals(other.username);
}
public int compareTo(AdministratorBean administratorBean)
{
return this.username.compareToIgnoreCase(administratorBean.username);
}
public int hashCode()
{
return username.hashCode();
}
}
