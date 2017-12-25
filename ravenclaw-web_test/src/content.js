///Content object is responsible for filling the 'indexMain' div with the
///result of an AJAX query to get the most recent date.
class content {
    ///fetAndShow will request some data from the server, via an AJAX call.
    /// When the data arrives, it will be passed to show()
    ///
    /// NB: remember that every file request is a GET, so we can put 'data.json'
    /// in the file hierarchy, and then GET it, as a way of mocking a REST route
    public static getAndShow(){
        $.ajax({
            method: "GET",
            url: "data.json",
            success: content.show
        });
    }

    /// When the data arrives from the server, render the content.hb template,
    /// using the data.
    private static show(data: any) {
        $("#indexMain").html(Handlebars.templates['content.hb'](data));
    }
}