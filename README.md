# ConsumeRestWs
This is a simple Android App that consumes a RESTful webservice using retrofit 2.0.2

I have used a public RESTful webservice just to demonstrate how you can consume one:

The ws basic URL is http://jsonplaceholder.typicode.com/

There are some object that you can get from this ws (posts/comments/albums/photos etc.).

In this App I decided to work with posts. 
To get a `Post` object the full URL would be http://jsonplaceholder.typicode.com/posts/postId

There is a simple class named `Post.java` under `model` package.
For further explanation you can explore the App which is very simple, it only contains 4 java classes and 1 layout file.

Here it is the input and the output of the App
In the first image there is an `EditText` when the user enters the id of a Post he wants.
In the 2nd one there is the result. You can process it after your needs.

<p align="center">
  <img src="https://s16.postimg.org/i39k5g3id/req.png" width="350"/>
  <img src="https://s16.postimg.org/ecr1mlrth/res.png" width="350"/>
</p>
