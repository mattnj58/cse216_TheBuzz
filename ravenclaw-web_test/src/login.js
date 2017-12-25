class login {
    public static putInDom() {
        $("#indexMain").html(Handlebars.templates['login.hb']())
        $("#buttonLogin").click(login.onLoginClick);
        $("#buttonNewUser").click(login.onNewUserClick);
     }

    public static onLoginClick(){
        welcome.putInDom();
    }

    public static onNewUserClick() {

    }

}