(function() {
  var template = Handlebars.template, templates = Handlebars.templates = Handlebars.templates || {};
templates['read.hb'] = template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "<button id=\"return\" type=\"button\" class=\"btn btn-outline-primary\">Return to articles</button>\r\n<button id=\"buttonLike\" type=\"button\" class=\"btn btn-success\">Like</button>\r\n<button id=\"buttonDislike\" type=\"button\" class=\"btn btn-danger\">Dislike</button>\r\n<div align=\"center\">\r\n    <a class=\"text\" data-toggle=\"modal\" data-target=\"#myModal\">By: "
    + alias4(((helper = (helper = helpers.author || (depth0 != null ? depth0.author : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"author","hash":{},"data":data}) : helper)))
    + "</a>\r\n    <p class=\"text\">created on "
    + alias4(((helper = (helper = helpers.when || (depth0 != null ? depth0.when : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"when","hash":{},"data":data}) : helper)))
    + "</p>\r\n</div>\r\n<div class=\"panel panel-default\">\r\n    <div class=\"panel-heading\">\r\n        <h3>"
    + alias4(((helper = (helper = helpers.title || (depth0 != null ? depth0.title : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"title","hash":{},"data":data}) : helper)))
    + "</h3>\r\n        <h5>Likes: "
    + alias4(((helper = (helper = helpers.likes || (depth0 != null ? depth0.likes : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"likes","hash":{},"data":data}) : helper)))
    + ", Dislikes:"
    + alias4(((helper = (helper = helpers.dislikes || (depth0 != null ? depth0.dislikes : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"dislikes","hash":{},"data":data}) : helper)))
    + "</h5>\r\n    </div>\r\n    <div class=\"panel-body\">\r\n        "
    + alias4(((helper = (helper = helpers.body || (depth0 != null ? depth0.body : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"body","hash":{},"data":data}) : helper)))
    + "\r\n    </div>\r\n</div>\r\n<div class=\"panel panel-default\">\r\n    <div class=\"panel-heading\">\r\n        <h3 class=\"panel-title\">Comments</h3>\r\n    </div>\r\n    <div class=\"list-group\">\r\n        <a class=\"text\" data-toggle=\"modal\" data-target=\"#myModal\">author</a>\r\n        <h4>comment</h4>\r\n          <a class=\"text\" data-toggle=\"modal\" data-target=\"#myModal\">author2</a>\r\n          <h4>Wow dude great story</h4>\r\n          <a class=\"text\" data-toggle=\"modal\" data-target=\"#myModal\">author3</a>\r\n          <h4>I didn't find that interesting</h4>\r\n          <a class=\"text\" data-toggle=\"modal\" data-target=\"#myModal\">author4</a>\r\n          <h4>So cool!</h4>\r\n    </div>\r\n</div>\r\n\r\n<!-- Menu opens up when creating a new user-->\r\n<div id=\"myModal\" class=\"modal fade\" role=\"dialog\">\r\n    <div class=\"modal-dialog\">\r\n\r\n    <div class=\"modal-content\">\r\n        <div class=\"modal-header\">\r\n            <div align=\"center\">\r\n                <h2>Get Users Name</h2>\r\n                <h3>userid@gmail.com</h3>\r\n                <h4>I am the coolest. I am really interesting.<h4>\r\n            </div>\r\n        </div>\r\n\r\n        <div class=\"modal-body\">\r\n            <h3>Comments</h3>\r\n        </div>\r\n\r\n        <div class=\"modal-footer\">\r\n            <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\r\n        </div>\r\n    </div>\r\n    </div>\r\n</div>";
},"useData":true});
})();
(function() {
  var template = Handlebars.template, templates = Handlebars.templates = Handlebars.templates || {};
templates['content.hb'] = template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "<div align=\"center\">\r\n    <h2>"
    + alias4(((helper = (helper = helpers.user || (depth0 != null ? depth0.user : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"user","hash":{},"data":data}) : helper)))
    + "</h2>\r\n    <h3> "
    + alias4(((helper = (helper = helpers.email || (depth0 != null ? depth0.email : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"email","hash":{},"data":data}) : helper)))
    + "</h3>\r\n    <label for=\"userComment\">About me:</label>\r\n    <h4>"
    + alias4(((helper = (helper = helpers.comment || (depth0 != null ? depth0.comment : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"comment","hash":{},"data":data}) : helper)))
    + "</h4>\r\n</div>\r\n<label for=\"changeComment\">Change Bio:</label>\r\n<input type=\"text\" class=\"form-control\" id=\"changeComment\">\r\n<button type=\"button\" class=\"btn btn-outline-primary\">Submit change</button>";
},"useData":true});
})();
(function() {
  var template = Handlebars.template, templates = Handlebars.templates = Handlebars.templates || {};
templates['nav.hb'] = template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    return "<nav id=\"nav\" class=\"navbar navbar-default navbar-fixed-top\">\r\n    <div class=\"container-fluid\">\r\n    <div class=\"navbar-header\">\r\n        <button type=\"button\" class=\"navbar-toggle collapsed\"\r\n                data-toggle=\"collapse\"\r\n                data-target='#bs-example-navbar-collapse-1\" area-expanded=\"false'>\r\n            <span class=\"sr-only\">Toggle navigaton</span>\r\n            <span class=\"icon-bar\"></span>\r\n            <span class=\"icon-bar\"></span>\r\n            <span class=\"icon-bar\"></span>\r\n        </button>\r\n        <a class=\"navbar-brand\" href=\"#\">BUZZ</a>\r\n    </div>\r\n\r\n    <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n        <ul class=\"nav navbar-nav\">\r\n            <li><a id=\"navWelcomeBtn\" href=\"#\">Home</a></li>\r\n            <li><a id=\"navContentBtn\" href=\"#\">Profile</a></li>\r\n	    <li><a id=\"navLoginBtn\" hreg=\"#\">Login/Switch Users</a></li>\r\n        </ul>\r\n    </div>\r\n    </div>\r\n</nav>";
},"useData":true});
})();
(function() {
  var template = Handlebars.template, templates = Handlebars.templates = Handlebars.templates || {};
templates['welcome.hb'] = template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    var helper, alias1=depth0 != null ? depth0 : {}, alias2=helpers.helperMissing, alias3="function", alias4=container.escapeExpression;

  return "<div class=\"pull-right\">\r\n    <button type=\"button\" class=\"btn btn-outline-primary\" data-toggle=\"modal\" data-target=\"#myModal\">Post Article</button>\r\n</div>\r\n<div>\r\n</div>\r\n<div align=\"center\">\r\n    <h2>Welcome, "
    + alias4(((helper = (helper = helpers.user || (depth0 != null ? depth0.user : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"user","hash":{},"data":data}) : helper)))
    + "</h2>\r\n</div>\r\n<div class=\"panel panel-default\">\r\n    <div class=\"panel-heading\">\r\n        <h3 class=\"panel-title\">Current Articles:</h3>\r\n    </div>\r\n<div class=\"list-group\">\r\n  <a a id=\"buttonOne\" href=\"#\" class=\"list-group-item list-group-item-action\">you loaded this class at</a>\r\n  <a a id=\"buttonTwo\" href=\"#\" class=\"list-group-item list-group-item-action\">"
    + alias4(((helper = (helper = helpers.dataTitle || (depth0 != null ? depth0.dataTitle : depth0)) != null ? helper : alias2),(typeof helper === alias3 ? helper.call(alias1,{"name":"dataTitle","hash":{},"data":data}) : helper)))
    + "</a>\r\n  <a a id=\"buttonThree\" href=\"#\" class=\"list-group-item list-group-item-action\">News Story</a>\r\n  <a a id=\"buttonFour\" href=\"#\" class=\"list-group-item list-group-item-action\">More news</a>\r\n</div>\r\n</div>\r\n\r\n\r\n<!-- Menu opens up when creating a new user-->\r\n<div id=\"myModal\" class=\"modal fade\" role=\"dialog\">\r\n    <div class=\"modal-dialog\">\r\n\r\n    <div class=\"modal-content\">\r\n        <div class=\"modal-header\">\r\n            <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n            <h4 class=\"modal-title\">Enter your information:</h4>\r\n        </div>\r\n\r\n        <div class=\"modal-body\">\r\n            <div class=\"form-group\">\r\n                <label for=\"newTitle\">Title:</label>\r\n                <input type=\"text\" class=\"form-control\" id=\"newTitle\" #newTitle>\r\n            </div>\r\n            <div class=\"form-group\">\r\n                <label for=\"newBody\">Article:</label>\r\n                <input type=\"text\" class=\"form-control\" id=\"newBody>\r\n            </div>\r\n        </div>\r\n\r\n        <div class=\"modal-footer\">\r\n            <button class=\"btn btn-default\" (click)=\"onPostClick(newTitle)\">Post Article</button>\r\n            <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\r\n        </div>\r\n    </div>\r\n    </div>\r\n</div>";
},"useData":true});
})();
(function() {
  var template = Handlebars.template, templates = Handlebars.templates = Handlebars.templates || {};
templates['login.hb'] = template({"compiler":[7,">= 4.0.0"],"main":function(container,depth0,helpers,partials,data) {
    return "<div class=\"form-group\">\r\n    <label for=\"user\">Username:</label>\r\n    <input type=\"text\" class=\"form-control\" id=\"user\">\r\n</div>\r\n<div class=\"form-group\">\r\n    <label for=\"pwd\">Password:</label>\r\n    <input type=\"password\" class=\"form-control\" id=\"pwd\">\r\n</div>\r\n<button id=\"buttonLogin\" type=\"button\" class=\"btn btn-outline-primary\">Login</button>\r\n<button type=\"button\" class=\"btn btn-outline-primary\" data-toggle=\"modal\" data-target=\"#myModal\">Create New User</button>\r\n\r\n<!-- Menu opens up when creating a new user-->\r\n<div id=\"myModal\" class=\"modal fade\" role=\"dialog\">\r\n    <div class=\"modal-dialog\">\r\n\r\n    <div class=\"modal-content\">\r\n        <div class=\"modal-header\">\r\n            <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n            <h4 class=\"modal-title\">Enter your information:</h4>\r\n        </div>\r\n\r\n        <div class=\"modal-body\">\r\n            <div class=\"form-group\">\r\n                <label for=\"newUser\">Username:</label>\r\n                <input type=\"text\" class=\"form-control\" id=\"newUser\">\r\n            </div>\r\n            <div class=\"form-group\">\r\n                <label for=\"newPwd\">Password:</label>\r\n                <input type=\"password\" class=\"form-control\" id=\"newPwd\">\r\n            </div>\r\n        </div>\r\n\r\n        <div class=\"modal-footer\">\r\n            <button id=\"buttonNewUser\" type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Create Account</button>\r\n            <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\r\n        </div>\r\n    </div>\r\n    </div>\r\n</div>";
},"useData":true});
})();
