//There are several ways to create functions in JavaScript

//1st way to make a function
//JS does not support overloading
function hello(){
    console.log("Hello Everyone");
}
hello();
//to store a function in a variable

//we are storing code in a variable
//the code is a the value
let hola = function(){
    console.log("Hola");
}
console.log(hola);
hola();//always remember to invoke your functions
//this is also calle dan anonymous function
//because we never really gave the function a name
//aka function expression
let add = function(num1,num2){
    console.log(num1+num2);
    return (num1+num2);
}
console.log(add(70,50));
add(90,60)

let gutentag = () => {

    console.log("gutentag")
}

let subtract = (num1,num2) => {
    return num1+num2;
}

gutentag();
console.log(subtract(100,85));

//because functions can be stored in variables
//technically functions are also objects
//we can pass code around
//we can put functions as parameters to other functions

//this function takes in 2 functions and calls them both
function greetings(greet1, greet2){
    greet1();
    greet2();
}
//this is a callback function
//a callback function is a function that is passed a parameter
//to another function
greeetings(hola,gutentag)

let multiply = (num1,num2) =>{

    return num1*num2;
}
//avoid making functions like this for right now
//store funcitons in a variable
function addminus(num1,num2,op1,op2){
    console.log( op1(num1,num2))
   console.log(op2(num1,num2))
    
}

addminus(25,5,add,subtract);

//a self invoking function
//encapsulation, want some code to always execute, protects name space
//anonymous IIFE functions Immediatly Invoked Function Expressions
function s(){

    console.log("I am a self invoking function");
}