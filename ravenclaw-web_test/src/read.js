class read {

    /// putInDom will render the welcome.hb template, passing in the date
    public static putInDom(title: string, body: string, author: string, likes: number, dislikes: number) {
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
    }

        public static onReturnClick(){
            welcome.putInDom();
        }

        public static onLikeClick(title: string, body: string, author: string, likes: number, dislikes: number) {
            read.putInDom(title, body, author, likes, dislikes);
        }

        public static onDislikeClick() {
        $("#indexMain").html(Handlebars.templates['read.hb']({
            dislikes: 1
            }));
        }
}