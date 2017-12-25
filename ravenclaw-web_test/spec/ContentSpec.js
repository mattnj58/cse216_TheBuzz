describe("Content", function(){
	it("Gets data from server and shows in handlebars", function() {

		var content = getAndShow();
		expect(content).toEqual(content.show);
		
	}