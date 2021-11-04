# MVI-Architecture-Android-Beginners
MVI Pattern Project

MVI is short for “Model, View, Intent”.

intent(): This function takes the input from the user (i.e. UI events, like click events) and translates it to “something” that will be passed as a parameter to model() function. This could be a simple string to set a value of the model to or more complex data structure like an Actions or Commands. Here in this blog post, we will stick with the word Action.

model(): The model function takes the output from intent() as input to manipulate the model. The output of this function is a new model (state changed). So it should not update an already existing model. We want immutability! We don’t change an already existing one. We copy the existing one and change the state (and afterward it can not be changed anymore). This function is the only piece of your code that is allowed to change a Model object. Then this new immutable Model is the output of this function.

view(): This method takes the model returned from model() function and gives it as input to the view() function. Then the view simply displays this model somehow.

![1_TTKpvdzyNXfPBhVyRqD6EA](https://user-images.githubusercontent.com/44297703/140246246-e9a67589-edc9-45b6-8075-19abb025277f.png)
