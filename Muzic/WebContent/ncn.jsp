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
        var pathMusic = '${pageContext.request.contextPath}';
        </script>
      </head>
<body>
        <div id="app">
          <nav class="menu-wrapper menu-wrapper-02">
            <a href="${pageContext.request.contextPath}/idparam" class="logo">
              <img src="assets/images/bee.png" alt="Bee music">
              <span class="text">Bee Music</span>
            </a>
      
            <div class="trigger">
              <img src="assets/images/menu.png" alt="trigger">
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
                      <a href="dsyt.jsp" id="favorite-list-btn">Danh sách yêu thích</a>
                    </li>
      
                    <li class="item">
                      <a href="#" id="my-music">Nhạc của tôi</a>
                    </li>
      
                    <li class="item upload-item">
                      <!-- <form action="">
                        <input type="file" name="" id="music-file">
                        <label id="music-label" for="music-file">Upload nhạc</label>
                      </form> -->
                      <a href="#" id="upload_link">Upload nhạc</a>
                    </li>
                  </ul>
                </div>
              </li>
      
              <li class="item">
                <a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
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
                    <span class="name" id="user"></span>
                  </div>
                </div>
                <ul class="menu-sidebar">
                  <li class="item">
                    <a href="dsyt.jsp">Danh sách yêu thích</a>
                  </li>
                  <li class="item">
                    <a class="active" href="#">Nhạc cá nhân</a>
                  </li>
                </ul>
              </nav>
      
              <div class="main-content">
                <h3 class="title">
                  Nhạc cá nhân
                </h3>
      
                <ul class="favourite-list" id="nct">
                </ul>
              </div>
            </div>
      
            <div class="modal-01" id="modalUpload">
              <div class="modal-header">
                <p class="modal__title">Tải nhạc lên website</p>
                <div class="close-btn"></div>
              </div>
              <div class="modal-body">
                <form action="/login.html" class="upload-form-01">
                  <div class="left-content">
                    <div class="input-item">
                      <label for="file-upload__name" class="desc">
                        Tên bài hát
                      </label>
                      <span class="err">* Trường này bắt buộc phải nhập</span>
                      <input type="text" name="" id="file-upload__name" class="input-song-name" required="">
                    </div>
      
                    <div class="input-item">
                      <span class="desc">Định dạng nhạc</span>
                      <select name="extendFile" id="">
                        <option value="mp3" selected>MP3</option>
                        <option value="wav">WAV</option>
                        <option value="flac">FLAC</option>
                        <option value="ape">APE</option>
                      </select>
                    </div>
      
                    <div class="input-item">
                      <span class="desc">Chọn file</span>
                      <label for="file-upload__file" class="file-upload__file-label">
                        <span class="name">Click me!</span>
                       <input type="file" name="" id="file-upload__file" required="">
                      </label>
                    </div>
                  </div>
                  
                  <div class="right-content">
                    <div class="input-item">
                      <span class="desc">Chọn chất lượng nhạc</span>
                      <select name="quality" id="">
                        <option value="128" selected>128</option>
                        <option value="164">164</option>
                        <option value="320">320</option>
                      </select>
                    </div>
                    
                    <textarea name="" id="" cols="30" rows="10" placeholder="Nhập lời bài hát ... " class="file-upload__lyric"></textarea>
                  </div> 
      
                  <div class="btn-wrapper">
                    <button class="file-upload__button" id="submit-upload-music">Upload</button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </body>
      <!-- js -->
      <script src="http://code.jquery.com/jquery-1.7.2.js"></script>
      <script src="assets/js/modal.js"></script>
      <script src="assets/js/nct.js"></script>
      </html>
      