<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel='stylesheet' type='text/css' href='/minorProject/css/styles.css'>
<title>Healthcare Administration</title>
<script type="text/javascript">
window.history.forward();
function onBack()
{
window.history.forward();
}
</script>
</head>
<body background='/minorProject/images/dr4.jpg;background-size:contain;background-attachment:fixed'>
<div class="main-container">
<div class="title"><img src='/minorProject/images/asap1.png' class='header-Image' ></div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<br>
<div class="header">
<div class="row">
<div class="col-md-8">
<ul class="menu">
<li><a href="/minorProject/index.jsp">HOME</a></li>
<li><a href="/minorProject/Hospitals.jsp">HOSPITALS</a></li>
<li><a href="/minorProject/Pharmacies.jsp">PHARMACIES</a></li>
<li><a href="/minorProject/Doctors.jsp">DOCTORS</a></li>
<li><a href="/minorProject/About.jsp">ABOUT</a></li>
</ul>
</div>
<div class="col-md-4 text-white">
<ul class="menu pull-right">
<li><img src='/minorProject/images/user.png' ></li>
<li>${username}&nbsp&nbsp&nbsp;</li>
<li><a href='/minorProject/logout'>Logout</a></li>
</ul>
</div>
</div>
</div>

<div class='container'>
<div="row">
<form action="/minorProject/Appointment.jsp">
<input type='hidden' id='doctorId' name='doctorId' value='${doctorBean.doctorId}'>
<script src='/minorProject/js/createAccount.js'></script>
<br><br>
<div class="col-md-12 font-ti text-white">
Doctor Name : ${doctorBean.name}
</div>
<br><br>
<div class="col-md-12  font-ti text-white">
Doctor Address : ${doctorBean.workingPlace}
</div>
<br><br>
<div class="col-md-12 font-ti text-white">
Contact Number : ${doctorBean.contactNumber}
</div>
<br><br>
<div class="col-md-12 font-ti text-white">
Specialization : ${doctorBean.specialization}
</div>
<br><br>
<div class="col-md-12 font-ti text-white">
Working Hours : ${doctorBean.workingHours}
</div>
<br><br>
<div class="col-md-12 font-ti text-white">
About : ${doctorBean.aboutDoctor}
</div>
<br><br>
<div class="container">
<div class="row">
<div class="col-md-2">
<button type="submit" class="btn  btn-info">Appointment</button>
</div>
<div class="col-md-2">
<button type='button' class="btn  btn-info" onclick='cancel()'>Cancel</button>
</div>
</div>
</div>
</form>
<form id='cancelForm' action='/minorProject/Doctors.jsp'>
</form>
</div>
</div>
</div>
</body>
</html>