
class login {
    public static putInDom() {
        $("#indexMain").html(Handlebars.templates['login.hb']())
        $("#buttonLogin").click(login.onLoginClick);
        $("#buttonNewUser").click(login.onNewUserClick);
     }

    public static onLoginClick(){
            var username = $('#user').val();
            var pwd = $('#pwd').val();
            $.post("login.html", {name: username, password: pwd})
                .done(function( data ) {
                    alert( "Data Loaded: " + data );
                });
        welcome.putInDom();
    }

    public static onNewUserClick() {
            var username = $('#newUser').val();
            var pwd = $('#newPwd').val();
            ///$.post("newlogin.html", {name: username, password: pwd})
                ///.done(function( data ) {
                    ///alert( "Data Loaded: " + data );
                ///}
    }

}