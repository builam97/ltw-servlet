    function callRegister(){
        var data = {
                "username": document.form.username.value,
                "password": document.form.password.value
        }
        console.log("username",document.form.password.value);
        var url="http://localhost:8089/Muzic/rest/users";
        fetch(url, {
            method: 'POST', // or 'PUT'
            body: JSON.stringify(data),
            headers:{
              'Content-Type': 'application/json'
            }
          }).then(res => res.json())
          .then(response => {
        $(document).ready(function(){
              if(response.response == "Success"){
                  $('#content').html("Success");
              }else{
                $('#content').html("Fail");
              }
              $('#modalUpload').addClass('show');
              $('#close-btn').remove('show');
            });
          })
          .catch(error => console.error('Error:', error));
    }