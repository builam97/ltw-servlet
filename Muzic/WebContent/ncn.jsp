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
      </head>
      <body>
        <div id="app">
          <nav class="menu-wrapper">
            <div class="logo">
              <img src="assets/images/bee.png" alt="Bee music">
              <span class="text">Bee Music</span>
            </div>
      
            <ul class="menu-01">
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
                    <span class="name">Duy</span>
                  </div>
                </div>
                <ul class="menu-sidebar">
                  <li class="item">
                    <a href="dsyt.html">Danh sách yêu thích</a>
                  </li>
                  <li class="item">
                    <a class="active" href="ncn.html">Nhạc cá nhân</a>
                  </li>
                </ul>
              </nav>
      
              <div class="main-content">
                <h3 class="title">
                  Nhạc cá nhân
                </h3>
      
                <ul class="favourite-list">
                  <li class="item">
                    <div class="TrackItem">
                      <div class="textbox">
                        <div class="media-wrapper">
                          <img src="http://unsplash.it/300/300" alt="" />
                        </div>
                        <p class="title">Pho xa</p>
                        <p class="author">Bee</p>
                      </div>
                    </div>
                    <div class="Track-edit">
                      <button class="btn-remove">Xóa</button>
                    </div>
                  </li>
                  <li class="item">
                    <div class="TrackItem">
                      <div class="media-wrapper">
                        <img src="http://unsplash.it/300/300" alt="" />
                      </div>
                      <p class="title">Pho xa</p>
                      <p class="author">Bee</p>
                    </div>
                    <div class="Track-edit">
                      <button class="btn-remove">Xóa</button>
                    </div>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </body>
      <!-- js -->
      <script src="assets/js/background.js"></script>
      <script src="https://connect.soundcloud.com/sdk/sdk-3.3.0.js"></script>
      <script src="http://code.jquery.com/jquery-1.7.2.js"></script>
      <!-- <script src="assets/js/SC.js"></script> -->
      <script src="assets/js/main.js"></script>
      </html>
      