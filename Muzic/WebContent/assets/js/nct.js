$(document).ready(function(){
  
    console.log(username);
    $('#user').html(username);
    var url = 'http://localhost:8089/Muzic/rest/mymusic/'+username;
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
              idMusic: myJson[i].idmusic,
              id: myJson[i].idTrack,
              index: i,
              musicname: myJson[i].musicname,
              iduser: myJson[i].iduser,
              author: myJson[i].author,
            }
          );
        }
        let html = '';
        favoriteList.forEach(element=>{
          html +=  '<li class="item" >\
                      <div href="'+pathMusic+'/idparam'+'" >\
                      <div class="TrackItem " data-trackIndex="'+element.index+'">\
                        <div class="media-wrapper">\
                          <img src="' + element.iduser + '"/>\
                        </div>\
                        <p class="title">'+element.musicname+'</p>\
                        <p class="authors">'+element.author+'</p>\
                      </div>\
                      <div class="Track-edit"><a class="btn-remove btnremove" href="'+pathMusic+'/UploadDownloadFileServlet?fileName='+ element.musicname + '">Download</a></div></div></li>';
        });
          $('#nct').html(html);
        });
       
      });
      