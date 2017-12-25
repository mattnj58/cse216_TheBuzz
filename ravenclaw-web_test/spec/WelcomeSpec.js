describe("welcome", function() {

	it("should render the welcome.hb template", function() {
	var dom = putInDom();
	expect(dom).toEqual(
	$("#indexMain").html(Handlebars.templates['welcome.hb']({
            user: "get username"
            }));
            $("#buttonOne").click(welcome.onListClick););
    
    });
    
    it("should highlight", function() {
    var high = highlight();
    expect(high).toEqual(
    $("#indexNav li").removeClass("active");
        $(which).parent().addClass("active"););
        
    });
});
    
    
	