<%--Tag Library for jsp--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <title>Registration Page</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<form role="create new user" method="POST">
  <h1>Registration</h1>
  <fieldset class="row1">
    <legend>Account Details
    </legend>
    <p>
      <label>User Name
      </label>
      <input type ="text" name="username" required/>
    </p>
    <p>
      <label>E-mail
      </label>
      <input type ="email" name="email" required/>
    </p>
    <p>
      <label>Password
      </label>
      <input type="password" name="password" required/>
    </p>
  </fieldset>
  <fieldset class="row2">
    <legend>Personal Details
    </legend>
    <p>
      <label>First Name
      </label>
      <input type="text" class="long" name = "firstname"/>
    </p>
    <p>
      <label>Last Name
      </label>
      <input type="text" class="long"name = "lastname"/>
    </p>
    <p>
      <label class="optional">Street
      </label>
      <input type="text" class="long" name = "address"/>
    </p>
    <p>
      <label>City
      </label>
      <input type="text" class="long" name = "city"/>
    </p>
    <p>
      <label>Country
      </label>
      <input type="text" class="long" name = "country"/>
    </p>
    <p>
      <label>Postal Code
      </label>
      <input type="text" class="long" name = "postalcode" maxlength = "7"/>
    </p>
  </fieldset>
  <fieldset class="row3">
    <legend>Further Information
    </legend>
    <p>
      <label>Gender</label><br>
        <p>  </p><label>Male <input type="radio" name = "gender" value="Male"/></label>
       <label>Female <input type="radio" name = "gender" value="Female"/></label>
    </p>
      <label>Age <input type="text" name="age"size="4" maxlength="4"/></label>
    </p>
    <div class="infobox"><h4>About FootyFix</h4>
      <p>We are a football meet up site based in Toronto. We allow all amateur players of all ages and both gender</p>
      <p>to half and full friendly football games that are otherwise very difficult to organize!</p>
    </div>
  </fieldset>
  <fieldset class="row4">
    <legend>Terms and Mailing
    </legend>
    <p class="agreement">
      <input type="checkbox" value="" required/>
      <label>I accept the <a href="terms">Terms and Conditions</a></label>
    </p>
    <p class="agreement">
      <input type="checkbox" value=""/>
      <label>I want to receive personalized offers by your site</label>
    </p>
    <p class="agreement">
      <input type="checkbox" value=""/>
      <label>Allow partners to send me personalized offers and related services</label>
    </p>
    <button type="submit" href="index.html" class="btn btn-lg btn-success btn-block"
            onclick="form.action='registerSubmit'">Submit</button>
    <button type="submit" href="index.html" class="btn btn-lg btn-success btn-block"
            onclick="form.action='login'">Cancel</button>
  </fieldset>
</form>
</body>
</html>

