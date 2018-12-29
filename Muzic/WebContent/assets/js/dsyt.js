$(document).ready(function(){
  
  console.log(username);
  $('#user').html(username);
  var url = 'http://localhost:8089/Muzic/rest/favorite/'+username;
  var favoriteList = [];
  fetch(url)
    .then(function(response) {
      return response.json();
    })
    .then(function(myJson) {
      console.log((myJson));
      for(var i =0;i< myJson.length;i++){
        favoriteList.push(
          {
            idMusic: myJson[i].id,
            id: myJson[i].idTrack,
            index: i,
            title: myJson[i].title,
            user: {
              avatar_url: myJson[i].avatar_url,
              username: myJson[i].authorname
            }
          }
        );
      }
      let html = '';
      favoriteList.forEach(element=>{
        html +=  '<li class="item" >\
                    <a href="'+pathMusic+'/idparam?idmusic='+element.id+'&url='+element.user.avatar_url+'&title='+element.title+'&authorname='+element.user.username+'" >\
                    <div class="TrackItem " data-trackIndex="'+element.index+'">\
                      <div class="media-wrapper">\
                        <img src="' + element.user.avatar_url + '" alt="'+element.user.username+'" />\
                      </div>\
                      <p class="title">'+element.title+'</p>\
                      <p class="authors">'+element.user.username+'</p>\
                    </div>\
                    <div class="Track-edit"><button class="btn-remove btnremove" id="'+ element.idMusic + '">Xóa</button></div></a></li>';
      });
        $('#dsyt').html(html);
        $(document).on('click', '.btn-remove', function(event) {
          // code here
          let index = parseInt($(this).attr('id'));
          console.log(index);
          var url ='http://localhost:8089/Muzic/rest/favorite/'+index;
          fetch(url, {
            method: 'DELETE', // or 'PUT'
            headers:{
              'Content-Type': 'application/json'
            }
          }).then(res => res.json())
          .then(response => console.log('Success:', console.log(response)))
          .catch(error => console.error('Error:', error));
        });
      });
     
    });
    