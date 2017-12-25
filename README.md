The Buzz

The Buzz is a dynamic social network platform for employees of our company to post, read, and react to messages in a
secure environment. The general user interface currently consists of a list of posts, a field to add a new post, and a 
like/dislike button attached to each post.

REST API

The Buzz utilizes the REST API for communication between the front and backends. Within these parameters, we have used two GET
routes, one for the total list of all messages in the database and one to retrieve more information on a specific message.
In addition, we have one POST route for adding new messages, and two PUT routes for likes and dislikes.

Testing

For testing, we used Junit for testing the backend, and Jasmine for the frontend.

User Interfaces

The Buzz uses two front ends: a web client and an android app. Both offer similar functionality, but right now only the web
client is able to access the backend database.

How to Run

To run the android app, navigate to the android folder and pull the source folder into android studio. The app can be run
natively on an android phone or via an emulator installed on a Mac or PC.

For the web interface, first pull and run the backend program on a docker virtual machine using maven. Then run index.html,
which should be able to communicate with the database running on your machine.