package com.asap.ha.bl;
import com.asap.ha.dl.*;
import com.asap.ha.beans.*;
import java.util.*;
import java.text.*;
public class PharmacyBL
{
public List<PharmacyBean> getAll()
{
List<PharmacyBean> pharmacies=new LinkedList<>();
try
{
PharmacyDAO pharmacyDAO=new PharmacyDAO();
List<PharmacyDTO>dlPharmacies=pharmacyDAO.getAll();
PharmacyBean pharmacyBean;
for(PharmacyDTO dlPharmacy: dlPharmacies)
{
pharmacyBean=new PharmacyBean();
pharmacyBean.setPharmacyId(dlPharmacy.getPharmacyId());
pharmacyBean.setName(dlPharmacy.getName());
pharmacyBean.setAddress(dlPharmacy.getAddress());
pharmacyBean.setContactNumber(dlPharmacy.getContactNumber());
pharmacyBean.setAboutPharmacy(dlPharmacy.getAboutPharmacy());
pharmacies.add(pharmacyBean);
}
}catch(DAOException daoException)
{
System.out.println(daoException);
}
return pharmacies;
}
}