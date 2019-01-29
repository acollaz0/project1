console.log("Hello World"); //semicolons are optional but good practice

// the scopes in JavaScript are defined by the declaration
// Global scope which is not delcararion (in general avoid)
// block scope which is the let or const declaration
// function (awful)  scope which is var

//the let keyword prevent the variable from escaping the block
{
    let x =100;
    console.log(x)
}
//console.log(x)

// the global variable is accessible anywhere
// try to avoid global variables when you can
{
    y = 200
    console.log(y)
}
console.log(y)

// var scope limits the variable to the function it was declared in
// but it is not bound by those petty brackets
function awfulness(){

{
    var v = 1000;
}

console.log(v)
}
//console(v)

awfulness()

