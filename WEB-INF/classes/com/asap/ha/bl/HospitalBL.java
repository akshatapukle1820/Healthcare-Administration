package com.asap.ha.bl;
import com.asap.ha.dl.*;
import com.asap.ha.beans.*;
import java.util.*;
import java.text.*;
public class HospitalBL
{
public List<HospitalBean> getAll() throws DAOException 
{
List<HospitalBean> hospitals=new LinkedList<>();
try
{
HospitalDAO hospitalDAO=new HospitalDAO();
List<HospitalDTO>dlHospitals=hospitalDAO.getAll();
HospitalBean hospitalBean;
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
for(HospitalDTO dlHospital: dlHospitals)
{
hospitalBean=new HospitalBean();
hospitalBean.setHospitalId(dlHospital.getHospitalId());
hospitalBean.setName(dlHospital.getName());
hospitalBean.setAddress(dlHospital.getAddress());
hospitalBean.setFacilities(dlHospital.getFacilities());
hospitalBean.setContactNumber(dlHospital.getContactNumber());
hospitalBean.setTotalBeds(dlHospital.getTotalBeds());
hospitalBean.setIsCovidPatient(dlHospital.getIsCovidPatient());
hospitalBean.setCategory(dlHospital.getCategory());
hospitalBean.setAboutHospital(dlHospital.getAboutHospital());
hospitals.add(hospitalBean);
}
}catch(DAOException daoException)
{
System.out.println(daoException);
}
return hospitals;
}
}