describe("raven", function() {
  var post;

  beforeEach(function() {
    post = new Post();
    post.title = "Title";
    post.body = "Body";

    setFixtures('<input id="new_val1" type="text" value="test1" />');
    setFixtures('<input id="new_val2" type="text" value="test2" />');
  });

  it("should display message", function() {
    var greet = greeting(post);
    expect(greet).toEqual("Title<br>Body");
  });

  // demonstrates the submit actions; not sure two alerts are allowed?
  it("should display two alerts", function() {
    spyOn(window, 'alert');

    raven.submit();

    expect(window.alert).toHaveBeenCalledWith('test1');
    expect(window.alert).toHaveBeenCalledWith('test2');
  });


});