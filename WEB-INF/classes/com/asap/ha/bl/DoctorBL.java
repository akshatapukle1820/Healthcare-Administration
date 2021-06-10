package com.asap.ha.bl;
import com.asap.ha.dl.*;
import com.asap.ha.beans.*;
import java.util.*;
import java.text.*;
public class DoctorBL
{
public List<DoctorBean> getAll()
{
List<DoctorBean> doctors=new LinkedList<>();
try
{
DoctorDAO doctorDAO=new DoctorDAO();
List<DoctorDTO>dlDoctors=doctorDAO.getAll();
DoctorBean doctorBean;
for(DoctorDTO dlDoctor: dlDoctors)
{
doctorBean=new DoctorBean();
doctorBean.setDoctorId(dlDoctor.getDoctorId());
doctorBean.setName(dlDoctor.getName());
doctorBean.setWorkingPlace(dlDoctor.getWorkingPlace());
doctorBean.setWorkingHours(dlDoctor.getWorkingHours());
doctorBean.setSpecialization(dlDoctor.getSpecialization());
doctorBean.setContactNumber(dlDoctor.getContactNumber());
doctorBean.setAboutDoctor(dlDoctor.getAboutDoctor());
doctors.add(doctorBean);
}
}catch(DAOException daoException)
{
System.out.println(daoException);
}
return doctors;
}
}