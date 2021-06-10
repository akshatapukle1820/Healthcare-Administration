<jsp:useBean id='doctorBean' scope='request' class='com.asap.ha.beans.DoctorBean' />
<jsp:setProperty name='doctorBean' property='*' />
<jsp:forward page='/appointment' />