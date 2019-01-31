//There are several ways to create a function in js
//1st way 
//javascript does not support overloading, btw.
function hello(){
    console.log("Hello with function keyword");
}
hello();

//2nd way: store a function in a variable
//We are storing code within a variable.
//the itself code is the value.
let hola = function(){
    console.log("Hola from hola variable");
}
hola(); // Always remember to invoke your functions
console.log(hola);

//This is also an anonymous function, since we never actually named the function
//It is stored in add, but the function itself is not actually named.
let add=function(num1,num2){
    // console.log(num1+num2);
    return(num1+num2);
}
add(90,60);
console.log(add); //not actually calling the function, just printing the code

//3rd way to make function: arrow notation
let gutentag = () => {
    console.log("Guten tag.")
}
gutentag();
console.log(gutentag);

let subtract = (num1,num2) => {
    return num1-num2;
}
console.log(subtract(30,9));
console.log(subtract);

// because functions are stored as variables, since functions are also objects,
// we can pass code around, and put functions as parameters to other functions.

function greetings(greet1,greet2) {
    greet1();
    greet2();
}
//this function takes in two functions, and calls them both.
// this is a callback function
// it is a function that is passed as a parameter to another function.
greetings(hola,gutentag);

let multiply=(num1,num2)=>{
    return num1*num2;
}

//Should probably get used to storing functions in variables, and not like this:
function doubleOp(num1,num2,op1,op2){
    console.log(op1(num1,num2));
    console.log(op2(num1,num2));
}
doubleOp(21,5,add,subtract);
doubleOp(21,5,add,multiply);

//A self invoking function is called as soon as it is defined.
//Useful for encapsulation, or if you want some code to always execute while protecting the namespace
//IIFE function: Immediately Invoked Function Experession
(function(){
    console.log("I'm a self invoking function");
})();