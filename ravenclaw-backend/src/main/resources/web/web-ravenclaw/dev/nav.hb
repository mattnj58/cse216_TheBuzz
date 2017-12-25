{{! Creates the Bootstrap navbar at the top of the page}}
<nav id="nav" class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
    {{! When on a small screen, the NavBar will consist of an 'expant'}}
    {{! button and our 'brand', which is CSE 216}}
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed"
                data-toggle="collapse"
                data-target='#bs-example-navbar-collapse-1" area-expanded="false'>
            <span class="sr-only">Toggle navigaton</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">BUZZ</a>
    </div>

    {{! div is wither showing (large screen), or a menu that expands when 'expand' is clicked}}
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li><a id="navWelcomeBtn" href="#">Home</a></li>
            <li><a id="navContentBtn" href="#">Profile</a></li>
	    <li><a id="navLoginBtn" hreg="#">Login/Switch Users</a></li>
        </ul>
    </div>
    </div>
</nav>