package com.asap.ha.dl;
import java.util.*;
public class DoctorDTO implements java.io.Serializable,Comparable<DoctorDTO>
{
private String doctorId;
private String name;
private String workingPlace;
private String workingHours;
private String specialization;
private String aboutDoctor;
private long contactNumber;
public DoctorDTO()
{
this.doctorId="";
this.name="";
this.workingPlace="";
this.workingHours="";
this.specialization="";
this.aboutDoctor="";
this.contactNumber=0;
}
public void setDoctorId(String doctorId)
{
this.doctorId=doctorId;
}
public String getDoctorId()
{
return this.doctorId;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setWorkingPlace(String workingPlace)
{
this.workingPlace=workingPlace;
}
public String getWorkingPlace()
{
return this.workingPlace;
}
public void setSpecialization(String specialization)
{
this.specialization=specialization;
}
public String getSpecialization()
{
return this.specialization;
}
public void setAboutDoctor(String aboutDoctor)
{
this.aboutDoctor=aboutDoctor;
}
public String getAboutDoctor()
{
return this.aboutDoctor;
}
public void setContactNumber(long contactNumber)
{
this.contactNumber=contactNumber;
}
public long getContactNumber()
{
return this.contactNumber;
}
public void setWorkingHours(String workingHours)
{
this.workingHours=workingHours;
}
public String getWorkingHours()
{
return this.workingHours;
}
public boolean equals(Object object)
{
if(!(object instanceof DoctorDTO)) return false;
DoctorDTO doctors=(DoctorDTO)object;
return this.doctorId.equalsIgnoreCase(doctors.doctorId);
}
public int compareTo(DoctorDTO doctors)
{
return this.doctorId.compareTo(doctors.doctorId);
}
}