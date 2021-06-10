package com.asap.ha.beans;
public class LinkBean implements java.io.Serializable,Comparable<LinkBean>
{
private String hospitalCode;
private String facilities;
public LinkBean()
{
this.hospitalCode="";
this.facilities="";
}
public void setHospitalCode(String hospitalCode)
{
this.hospitalCode=hospitalCode;
}
public String getHospitalCode()
{
return this.hospitalCode;
}
public void setFacilities(String facilities)
{
this.facilities=facilities;
}
public String getFacilities()
{
return this.facilities;
}
public int hashCode()
{
return hospitalCode.hashCode();
}
public boolean equals(Object object)
{
if(!(object instanceof LinkBean)) return false;
LinkBean link=(LinkBean)object;
return this.hospitalCode.equalsIgnoreCase(link.hospitalCode);
}
public int compareTo(LinkBean link)
{
return this.hospitalCode.compareTo(link.hospitalCode);
}
}	