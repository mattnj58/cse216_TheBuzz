///Content object is responsible for filling the 'indexMain' div with the
///result of an AJAX query to get the most recent date.
class content {
    public static getAndShow() {
        $("#indexMain").html(Handlebars.templates['content.hb']({
            user: "Evan Vomund",
            email: "evanvomund@gmail.com",
            comment: "My life is really interesting..."
    }));
    }
}