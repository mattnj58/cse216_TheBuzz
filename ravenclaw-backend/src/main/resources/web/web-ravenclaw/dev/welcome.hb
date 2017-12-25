{{! Panel prints whatever time is passed to it}}
<div class="pull-right">
    <button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#myModal">Post Article</button>
</div>
<div>
</div>
<div align="center">
    <h2>Welcome, {{user}}</h2>
</div>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Current Articles:</h3>
    </div>
<div class="list-group">
  <a a id="buttonOne" href="#" class="list-group-item list-group-item-action">you loaded this class at</a>
  <a a id="buttonTwo" href="#" class="list-group-item list-group-item-action">{{dataTitle}}</a>
  <a a id="buttonThree" href="#" class="list-group-item list-group-item-action">News Story</a>
  <a a id="buttonFour" href="#" class="list-group-item list-group-item-action">More news</a>
</div>
</div>


<!-- Menu opens up when creating a new user-->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Enter your information:</h4>
        </div>

        <div class="modal-body">
            <div class="form-group">
                <label for="newTitle">Title:</label>
                <input type="text" class="form-control" id="newTitle" #newTitle>
            </div>
            <div class="form-group">
                <label for="newBody">Article:</label>
                <input type="text" class="form-control" id="newBody>
            </div>
        </div>

        <div class="modal-footer">
            <button class="btn btn-default" (click)="onPostClick(newTitle)">Post Article</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
    </div>
    </div>
</div>