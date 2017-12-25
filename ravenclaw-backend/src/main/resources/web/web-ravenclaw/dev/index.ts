/// if we say that '$' and 'Handlebars' are both variables of type "any", then
/// we lose all static checking of thier use by the TypeScript compiler, but we
/// don't get any error messages when compiling.
///
/// In general, this is a bad thing to do, becasue it means that it is on us to
/// make sure we are using jQuery and Handlebars correctly. For this tutorial,
/// we'll let it slide...
var $: any;
var Handlebars: any;

/// This is equivalent to 'public static main()' in Java. It runs once all of
/// the files that comprise our program have been loaded. In this demo, all it
/// does is initialize the navbar and simulate a click on the 'Welcome' button
$(document).ready(function () {
    nav.init();
    nav.onWelcomeClick();
});