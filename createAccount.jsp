<jsp:useBean id='administratorBean' scope='request' class='com.asap.ha.beans.AdministratorBean' />
<jsp:setProperty name='administratorBean' property='*' />
<jsp:forward page='/createAccount' />