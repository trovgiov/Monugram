//inizializza - setup facebook js sdk
window.fbAsyncInit = function() {
    FB.init({
        appId      : '406915483005816',
        xfbml      : true,
        version    : 'v2.8'
    });

    FB.AppEvents.logPageView();
    console.log("Hello");

    FB.getLoginStatus(function (response) {
             if (response.status=='connected'){
                document.getElementById('status').innerHTML = 'You are Connected';
                //se mi trovo, qui sono connesso su facebook e quindi mi deve reindirizzare nella home con i parametri
                // il link va creato con ?
            }
            else if (response.status=='not_authorized'){
                document.getElementById('status').innerHTML = 'You are not logged in';
            }
            else {
                document.getElementById('status').innerHTML = 'You are not logged';

            }
        }
    )
};

(function(d, s, id){
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) {return;}
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));


function login(){
    FB.login(function (response) {

        if (response.status=='connected'){
            document.getElementById('status').innerHTML = 'You are Connected';
        }
        else if (response.status=='not_authorized'){
            document.getElementById('status').innerHTML = 'You are not logged in';
        }
        else {
            document.getElementById('status').innerHTML = 'You are not logged';
        }
    })
}

function getInfo(){
    FB.api('/me','GET', {fields: 'first_name,last_name,email,id'}, function(response){
         document.getElementById('status').innerHTML=response.id;
         window.location.href = "/Monugram/facebook_login.action?nome=" + response.first_name + "&cognome=" + response.last_name + "&email=" + response.email;
    });
}




