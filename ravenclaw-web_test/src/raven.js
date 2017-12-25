var Post = (function () {
    function Post(title, body) {
        this.title = title;
        this.body = body;
        this.fullMessage = title + "\n " + body;
    }
    return Post;
}());
var numLikes = 0;
function like() {
    numLikes = numLikes + 1;
    alert(numLikes);
}
var numDisLikes = 0;
function dislike() {
    numDisLikes = numDisLikes + 1;
    alert(numDisLikes);
}

function greeter(message) {
    return message.title + "<br>" + message.body;
}

function submitButton() {
    var val1 = document.getElementById("new_val1").value;
    var val2 = document.getElementById("new_val2").value;
    alert(val1);
    alert(val2);
}
/**
    var val1  = (<HTMLInputElement>document.getElementById("new_val1")).value;
            val1 = (val1 === "") ? null : val1;
            var val2  = (<HTMLInputElement>document.getElementById("new_val2")).value;
            val2 = (val2 === "") ? null : val2;
            $.ajax({
                type: "POST",
                url: "/data",
                data: JSON.stringify({ val1: val1, val2: val2 }),
                dataType: "json",
                success: function (data) {
                if (data.res === "ok"){
                    ("#new_val1").val("");
                    ("#new_val2").val("");
                    getDataFromServer();
                }else {
                    window.alert("error");
                    }
                }
            });
            getDataFromServer();
}


        function getDataFromServer(){
        $.ajax({
            type: "GET",
            url: "/data",
            dataType: "json",
            success: function (data){
                var res = "<table>"
                for (var i = 0; i < data.length; ++i){
                    var d = data[i];
                    res += "<tr><td>" + d.val1 + "</td><td>" + d.val2 +
                    "</td><td><button onClick='deleteRow(" + d.index +
                    ")'>Delete Row</button></td></tr>"
                }
                res += "</table>";
                $("#listing").html(res);
            }
        });
    };
*/