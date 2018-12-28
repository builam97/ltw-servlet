<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>Bee Music</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no">
  <meta name="format-detection" content="telephone=no">

  <!-- font -->
  <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900" rel="stylesheet">
  <!-- css -->
  <link rel="stylesheet" href="assets/css/main.css">
<script>
	function validate(){
		var username = document.form.username.value;
		var password = document.form.password.value;
		if(username == null || username == ""){
			alert("username cannot be blank");
			return false;
		}
		else if(password== null || password ==""){
			alert("password cannot be blank");
			return false;
		}
	}
</script>
</head>
<body>
<div class="auth-page">
    <div class="auth-page-wrapper">
      <div class="bg-wrapper">
        <canvas id="Background-Canvas" height="981" class="bg-01" width="1372"></canvas>
      </div>  

      <div class="auth-login-content">
        <div class="logo">
          <img src="assets/images/bee.png" alt="bee team">
        </div>

        <div class="auth-form">
          <p class="title">
            Đăng nhập
          </p>
          <span class="sub-title">
            Hãy đăng nhập để khám phá Bee Music
          </span>

          <form action="LoginServlet" name="form" method="post" onsubmit="return validate()">
            <div class="input-item">
              <input type="text" name="username" placeholder="username" required id="email-input">
              <i class="iconmo-email font-icon"></i>
            </div>

            <div class="input-item">
              <input type="password" placeholder="password" name="password" required id="">
              <i class="iconmo-password font-icon"></i>
            </div>
            
            <input type="submit" value="Đăng nhập" class="auth-button-01">
          </form>

          <div class="register-suggest">
            <span>Bạn chưa có tài khoản ?</span>
            <a href="Register.jsp" class="link-suggest">Đăng kí</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
<script src="assets/js/background2.js"></script>
<script src="https://connect.soundcloud.com/sdk/sdk-3.3.0.js"></script>
<script src="http://code.jquery.com/jquery-1.7.2.js"></script>
</html>