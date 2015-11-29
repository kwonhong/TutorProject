<%--Tag Library for jsp--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <title>CSS Registration Form</title>
  <style>
    @font-face{
      font-family: trench;
      src: url('css/Junction-light.otf') format('opentype');
    }
  body {
    color: #fff;
    font-family: sans-serif;
    font-size: 16px;
    background-image: url(http://www.soccer.com/guide/wp-content/uploads/2013/10/HO13_FB_CR7_Athlete.jpg);
    background-size: cover;
    }
  </style>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <link rel="stylesheet" type="text/css" href="css/default.css"/>
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
      <label>Password*
      </label>
      <input type="text" name="password" required/>
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
      <label>Gender</label>
      <input type="radio" name = "gender" value="Male"/>
      <input type="radio" name = "gender" value="Female"/>
    </p>
      <input type="text" name="age"size="4" maxlength="4"/>
    </p>
    <div class="infobox"><h4>Helpful Information</h4>
      <p>Here comes some explaining text, sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
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

