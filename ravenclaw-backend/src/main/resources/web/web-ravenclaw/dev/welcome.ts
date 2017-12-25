///Welcome object has a method for putting a message into the main content panel,
// and show that the content is updated on refresh by displaying a date
class welcome {

    /// putInDom will render the welcome.hb template, passing in the date

        public static putInDom() {
            $("#indexMain").html(Handlebars.templates['welcome.hb']({
            user: "please log in",
            dataTitle: "d djf",
            }));
            $("#buttonOne").click(welcome.onListClick);
            $("#buttonTwo").click(welcome.onListClick);
            $("#buttonThree").click(welcome.onListClick);
            $("#buttonFour").click(welcome.onListClick);
            $("#buttonPost").click(welcome.onPostClick);
        }

        /// manage highlighting of whichever button coresponds to
        /// the active content on the page
        private static highlight(which: any) {
            $("#indexMain li").removeClass("active");
            $(which).parent().addClass("active");
        }

        /// Handle a click of the "Welcome" button
        public static onListClick() {
            welcome.highlight(this);
            read.putInDom("Interesting article", "This is an article about something interesting.", "random author", 5, 2);
        }

        public static onPostClick(newTitle) {
            read.putInDom("cat", "blah", "blah", 4, 3);
        }
}