
console.log("Hello World"); //semicolons are optional, but good practice

//The scopes in JavaScript are defined by the declaration
//Global scope which is no declaration. Avoid in general.
//Block scope which is the let or const declaration. "const" is the same as let, but states variable can't change
// var scope is very bad, don't use.

//Global scope is a variable accessible anywhere

{
    let x = 100; //The let keyword prevented the variable from escaping the block
    console.log(x);
}
// console.log(x);

{
    y=200;      //This is a global variable, and is accessible anywhere
                //Try to avoid global variables when you can
    console.log(y);
}
console.log(y);

function awfulness(){
    {
        var v = 1000;
    }
    console.log(v); //var means that you can call a variable from anywhere within a function
    //Don't use
}

awfulness();