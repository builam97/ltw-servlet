<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Bee Music</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no">
  <meta name="format-detection" content="telephone=no">

  <!-- font -->
  <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900" rel="stylesheet">
  <!-- css -->
  <link rel="stylesheet" href="assets/css/main.css">
  <script type="text/javascript">
  var username = '<%=session.getAttribute("username") %>';
  var pathMusic= '${pageContext.request.contextPath}';
  </script>
</head>
<body>
  <div id="app">
    <nav class="menu-wrapper">
      <div class="logo">
      <a href="${pageContext.request.contextPath}/idparam">
        <img src="assets/images/bee.png" alt="Bee music">
        <span class="text">Bee Music</span>
        </a>
      </div>

      <ul class="menu-01">
        <!-- ////////////////////////chua login//////////////////////////// -->
        <!-- <li class="item">
          <a href="login.html">Đăng nhập</a>
        </li>

        <li class="item">
          <a href="register.html">Đăng kí</a>
        </li> -->
        <!-- ////////////////////////chua login//////////////////////////// -->
        <li class="item account-item">
          <div class="account">
            <ul class="account-box">
              <li class="item">
                <a href="#" id="favorite-list-btn">Danh sách yêu thích</a>
              </li>

              <li class="item">
                <a href="#" id="my-music">Nhạc của tôi</a>
              </li>

              <li class="item upload-item">
                <form action="">
                  <input type="file" name="" id="music-file">
                  <label id="music-label" for="music-file">Upload nhạc</label>
                </form>
              </li>
            </ul>
          </div>
        </li>

        <li class="item">
          <a href="login.html">Đăng xuất</a>
        </li>
      </ul>
    </nav>
          <div class="Dashboard-02">
            <div class="content">
              <nav class="menu-sidebar-wrapper">
                <div class="account">
                  <div class="user-images-wrapper">
                    <img src="assets/images/user.png" alt="user">
                  </div>
                  <div class="user-infor">
                    <span href="" class="name" id="user"></span>
                  </div>
                </div>
                <ul class="menu-sidebar">
                  <li class="item">
                    <a class="active" href="dsyt.html">Danh sách yêu thích</a>
                  </li>
                  <li class="item">
                    <a href="ncn.html">Nhạc cá nhân</a>
                  </li>
                </ul>
              </nav>
      
              <div class="main-content">
                <h3 class="title">
                  Danh sách yêu thích
                </h3>
      
                <ul class="favourite-list" id="dsyt">
                </ul>
              </div>
            </div>
          </div>
        </div>
      </body>
      <!-- js -->
      <script src="https://connect.soundcloud.com/sdk/sdk-3.3.0.js"></script>
      <script src="http://code.jquery.com/jquery-1.7.2.js"></script>
      <script src="assets/js/SC.js"></script>
      <script src="assets/js/main.js"></script>
      <script src="assets/js/dsyt.js"></script>
 </html>