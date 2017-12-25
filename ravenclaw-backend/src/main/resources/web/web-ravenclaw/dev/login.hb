{{! Shows how to use handlebars template to show (a) filds of an}}
{{! object and (b) rows of an array. This expects to recieve and object with}}
{{! one field, called 'array', which is an array of objects, each with a field called 'data'}}
<div class="form-group">
    <label for="user">Username:</label>
    <input type="text" class="form-control" id="user">
</div>
<div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" id="pwd">
</div>
<button id="buttonLogin" type="button" class="btn btn-outline-primary">Login</button>
<button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#myModal">Create New User</button>

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
                <label for="newUser">Username:</label>
                <input type="text" class="form-control" id="newUser">
            </div>
            <div class="form-group">
                <label for="newPwd">Password:</label>
                <input type="password" class="form-control" id="newPwd">
            </div>
        </div>

        <div class="modal-footer">
            <button id="buttonNewUser" type="button" class="btn btn-default" data-dismiss="modal">Create Account</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
    </div>
    </div>
</div>