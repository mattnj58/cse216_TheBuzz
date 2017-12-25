{{! Panel prints whatever time is passed to it}}
<button id="return" type="button" class="btn btn-outline-primary">Return to articles</button>
<button id="buttonLike" type="button" class="btn btn-success">Like</button>
<button id="buttonDislike" type="button" class="btn btn-danger">Dislike</button>
<div align="center">
    <a class="text" data-toggle="modal" data-target="#myModal">By: {{author}}</a>
    <p class="text">created on {{when}}</p>
</div>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3>{{title}}</h3>
        <h5>Likes: {{likes}}, Dislikes:{{dislikes}}</h5>
    </div>
    <div class="panel-body">
        {{body}}
    </div>
</div>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Comments</h3>
    </div>
    <div class="list-group">
        <a class="text" data-toggle="modal" data-target="#myModal">author</a>
        <h4>comment</h4>
          <a class="text" data-toggle="modal" data-target="#myModal">author2</a>
          <h4>Wow dude great story</h4>
          <a class="text" data-toggle="modal" data-target="#myModal">author3</a>
          <h4>I didn't find that interesting</h4>
          <a class="text" data-toggle="modal" data-target="#myModal">author4</a>
          <h4>So cool!</h4>
    </div>
</div>

<!-- Menu opens up when creating a new user-->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

    <div class="modal-content">
        <div class="modal-header">
            <div align="center">
                <h2>Get Users Name</h2>
                <h3>userid@gmail.com</h3>
                <h4>I am the coolest. I am really interesting.<h4>
            </div>
        </div>

        <div class="modal-body">
            <h3>Comments</h3>
        </div>

        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
    </div>
    </div>
</div>