describe("nav", function() {

	it("should create and configure user interface", function() {
	var initial = init();
	expect(initial).toEqual(
	$("#indexNav").html(Handlebars.templates['nav.hb']());
    $("#navContentBtn").click(nav.onContentClick);
    $("#navWelcomeBtn").click(nav.onWelcomeClick);
    $("#navLoginBtn").click(nav.onLoginClick););
    
    });
    
    it("should highlight", function() {
    var high = highlight();
    expect(high).toEqual(
    $("#indexNav li").removeClass("active");
        $(which).parent().addClass("active"););
        
    });
});
    
    
	