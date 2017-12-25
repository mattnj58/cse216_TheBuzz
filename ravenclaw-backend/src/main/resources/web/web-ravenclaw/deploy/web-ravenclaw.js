var login = (function () {
    function login() {
    }
    login.putInDom = function () {
        $("#indexMain").html(Handlebars.templates['login.hb']());
        $("#buttonLogin").click(login.onLoginClick);
        $("#buttonNewUser").click(login.onNewUserClick);
    };
    login.onLoginClick = function () {
        var username = $('#user').val();
        var pwd = $('#pwd').val();
        $.post("login.html", { name: username, password: pwd })
            .done(function (data) {
            alert("Data Loaded: " + data);
        });
        welcome.putInDom();
    };
    login.onNewUserClick = function () {
        var username = $('#newUser').val();
        var pwd = $('#newPwd').val();
        ///$.post("newlogin.html", {name: username, password: pwd})
        ///.done(function( data ) {
        ///alert( "Data Loaded: " + data );
        ///}
    };
    return login;
}());
var read = (function () {
    function read() {
    }
    /// putInDom will render the welcome.hb template, passing in the date
    read.putInDom = function (title, body, author, likes, dislikes) {
        ///Attempt to connect to server
        ///    (function() {
        ///    var BuzzAPI = "http://";
        ///    $.getJson( BuzzAPI, {
        ///    tags: "message",
        ///    tagmode: "any",
        ///    format: "json"
        ///    })
        ///        .done(function( data ) {
        ///            $.each( data.items, function(i, item) {
        ///                $( "<title>" ).attr( "src", item.text.m ).appendTo( "#title");
        ///            });
        ///        });
        ///    })();
        $("#indexMain").html(Handlebars.templates['read.hb']({
            when: new Date(),
            title: title,
            body: body,
            author: author,
            likes: likes,
            dislikes: dislikes
        }));
        $("#return").click(read.onReturnClick);
        $("#buttonLike").click(read.onLikeClick(title, body, author, likes, dislikes));
        $("#buttonDislike").click(read.onDislikeClick);
    };
    read.onReturnClick = function () {
        welcome.putInDom();
    };
    read.onLikeClick = function (title, body, author, likes, dislikes) {
        read.putInDom(title, body, author, likes, dislikes);
    };
    read.onDislikeClick = function () {
        $("#indexMain").html(Handlebars.templates['read.hb']({
            dislikes: 1
        }));
    };
    return read;
}());
///Content object is responsible for filling the 'indexMain' div with the
///result of an AJAX query to get the most recent date.
var content = (function () {
    function content() {
    }
    content.getAndShow = function () {
        $("#indexMain").html(Handlebars.templates['content.hb']({
            user: "Evan Vomund",
            email: "evanvomund@gmail.com",
            comment: "My life is really interesting..."
        }));
    };
    return content;
}());
/// The navigation bar has two buttons, one for the 'Welcome' page and
/// one for the 'content' page
var nav = (function () {
    function nav() {
    }
    /// put the navbar onto the page, and configure its buttons
    nav.init = function () {
        $("#indexNav").html(Handlebars.templates['nav.hb']());
        $("#navContentBtn").click(nav.onContentClick);
        $("#navWelcomeBtn").click(nav.onWelcomeClick);
        $("#navLoginBtn").click(nav.onLoginClick);
    };
    /// manage highlighting of whichever button coresponds to
    /// the active content on the page
    nav.highlight = function (which) {
        $("#indexNav li").removeClass("active");
        $(which).parent().addClass("active");
    };
    /// handle a click of the "Content" button
    nav.onContentClick = function () {
        // NB: 'this' is whatever DOM element was clicked
        nav.highlight(this);
        content.getAndShow();
    };
    /// Handle a click of the "Welcome" button
    nav.onWelcomeClick = function () {
        nav.highlight(this);
        welcome.putInDom();
    };
    nav.onLoginClick = function () {
        nav.highlight(this);
        login.putInDom();
    };
    return nav;
}());
;
///Welcome object has a method for putting a message into the main content panel,
// and show that the content is updated on refresh by displaying a date
var welcome = (function () {
    function welcome() {
    }
    /// putInDom will render the welcome.hb template, passing in the date
    welcome.putInDom = function () {
        $("#indexMain").html(Handlebars.templates['welcome.hb']({
            user: "please log in",
            dataTitle: "d djf"
        }));
        $("#buttonOne").click(welcome.onListClick);
        $("#buttonTwo").click(welcome.onListClick);
        $("#buttonThree").click(welcome.onListClick);
        $("#buttonFour").click(welcome.onListClick);
        $("#buttonPost").click(welcome.onPostClick);
    };
    /// manage highlighting of whichever button coresponds to
    /// the active content on the page
    welcome.highlight = function (which) {
        $("#indexMain li").removeClass("active");
        $(which).parent().addClass("active");
    };
    /// Handle a click of the "Welcome" button
    welcome.onListClick = function () {
        welcome.highlight(this);
        read.putInDom("Interesting article", "This is an article about something interesting.", "random author", 5, 2);
    };
    welcome.onPostClick = function (newTitle) {
        read.putInDom("cat", "blah", "blah", 4, 3);
    };
    return welcome;
}());
/// if we say that '$' and 'Handlebars' are both variables of type "any", then
/// we lose all static checking of thier use by the TypeScript compiler, but we
/// don't get any error messages when compiling.
///
/// In general, this is a bad thing to do, becasue it means that it is on us to
/// make sure we are using jQuery and Handlebars correctly. For this tutorial,
/// we'll let it slide...
var $;
var Handlebars;
/// This is equivalent to 'public static main()' in Java. It runs once all of
/// the files that comprise our program have been loaded. In this demo, all it
/// does is initialize the navbar and simulate a click on the 'Welcome' button
$(document).ready(function () {
    nav.init();
    nav.onWelcomeClick();
});
