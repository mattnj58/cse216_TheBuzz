/// The navigation bar has two buttons, one for the 'Welcome' page and
/// one for the 'content' page
class nav {
    /// put the navbar onto the page, and configure its buttons
    public static init() {
    $("#indexNav").html(Handlebars.templates['nav.hb']());
    $("#navContentBtn").click(nav.onContentClick);
    $("#navWelcomeBtn").click(nav.onWelcomeClick);
    $("#navLoginBtn").click(nav.onLoginClick);
    }

    /// manage highlighting of whichever button coresponds to
    /// the active content on the page
    private static highlight(which: any) {
        $("#indexNav li").removeClass("active");
        $(which).parent().addClass("active");
    }

    /// handle a click of the "Content" button
    public static onContentClick() {
    // NB: 'this' is whatever DOM element was clicked
    nav.highlight(this);
    content.getAndShow();
    }

    /// Handle a click of the "Welcome" button
    public static onWelcomeClick() {
        nav.highlight(this);
        welcome.putInDom();
    }

    public static onLoginClick() {
        nav.highlight(this);
        login.putInDom();
    }
};