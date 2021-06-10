package com.asap.ha.dl;
public class LinkDTO implements java.io.Serializable,Comparable<LinkDTO>
{
private String hospitalCode;
private String facilities;
public LinkDTO()
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
if(!(object instanceof LinkDTO)) return false;
LinkDTO link=(LinkDTO)object;
return this.hospitalCode.equalsIgnoreCase(link.hospitalCode);
}
public int compareTo(LinkDTO link)
{
return this.hospitalCode.compareTo(link.hospitalCode);
}
}	