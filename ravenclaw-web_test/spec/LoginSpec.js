describe("login", function(){

	it("should generate the login screen", function() {
	
	var welcome;
	welcome.putDom();
	expect($("#indexMain").html(Handlebars.templates['login.hb']())
        $("#buttonLogin").click(login.onLoginClick);
        $("#buttonNewUser").click(login.onNewUserClick););
        
        }
    }
    