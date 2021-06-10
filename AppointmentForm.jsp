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
<body background='/minorProject/images/img10.jpg;background-size:contain;background-attachment:fixed'>
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
<br><br>
<div class="container-fluid">
<div class="row justify-content-center">
<div class="col-md-4 col-sm-6">
<div class="font-weight-bold font-log font-size-40px text-center">Appointment Form</div>
<form action="/futureWork" method='post' class="shadow-lg p-4">
<script src='/minorProject/js/createAccount.js'></script>
<div class="col-md-12  font-ti text-white text-center"> ${doctorBean.name}</div><br>
<div class="col-md-12  font-ti text-white text-center">(${doctorBean.specialization})</div><br>
<div class="form-group">
<script src='/minorProject/js'></script>
<span class='error error-msg'>
${errorBean.error}
</span>
<br>
<i class="fa fa-user-circle font-login"></i>
<label for="name" class="font-weight-bold pl-1 font-login">Name</label><input type="text" class="form-control" placeholder="name" id="name" name="name">
</div>
<div class="form-group">
<i class="fa fa-address-book-o font-login"></i>
<label for="address" class="font-weight-bold pl-1 font-login">Address</label><input type="address" class="form-control" placeholder="address" id="address" name="address">
</div>
<div class="form-group">
<i class="fa fa-child font-login"></i>
<label for="age" class="font-weight-bold pl-1 font-login">Age</label><input type="age" class="form-control" placeholder="age" id="age" name="age">
</div><br>
<div class="form-group">
<i class="fa fa-venus-double font-login"></i>
<label class="font-weight-bold pl-1 font-login">Gender</label><br>
<div class="custom-control custom-radio custom-control-inline">
<input type="radio"  class="custom-control-input" id="defaultInline1" name="inlineDefaultRadioExample">
<label class="custom-control-label font-weight-bold pl-1 font-login" for="defaultInline1">Male</label> 
</div>
<div class="custom-control custom-radio custom-control-inline">
<input type="radio"  class="custom-control-input" id="defaultInline2" name="inlineDefaultRadioExample">
<label class="custom-control-label font-weight-bold pl-1 font-login" for="defaultInline2">Female</label> 
</div>
</div>
<br>
<div class="form-group">
<i class="fa fa-phone font-login"></i>
<label for="contactNumber" class="font-weight-bold pl-1 font-login">Contact Number</label>
<input type="contactNumber" class="form-control" placeholder="contact number" id="contactNumber" name="contactNumber">
</div><br>
<div class="form-group">
<i class="fa fa-calendar font-login"></i>
<label for="contactNumber" class="font-weight-bold pl-1 font-login">Date of Appointment</label><br>
<input type='date' for="dateOfBirth" id='dateOfBirth' name='dateOfBirth'>
</div><br>
<div class="form-check">
<input type="checkbox" class="form-check-input" id="checkboxselect">
<label for="checkboxselect" class="form-check-label font-login font-weight-bold pl-1 font-login">Is Covid Patient?</label>
<i class="fa fa-user-md font-login"></i>
</div><br>
<div class="form-group">
<i class="fa fa-stethoscope font-login"></i>
<label for="anyDisease" class="font-weight-bold pl-1 font-login">Any Disease?</label><input type="anyDisease" class="form-control" placeholder="any disease" id="anyDisease" name="anyDisease">
</div>
<div class="row">
<div class="col-md-2">
<button type="submit" class="btn btn-secondary mt-3 font-weight-bold shadow-sm ">Submit</button>
</div>
<div class="col-md-2">
<button type='button' class="btn btn-secondary btn-sm font-weight-bold shadow-sm custom-button text-white" onclick='cancel()'>Cancel</button>
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