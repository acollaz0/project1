

function outer(){
    console.log("I am the outer function");
    let count = 0;

    return function inner(){
        console.log("Hi! I'm the inner function");
        console.log(count);
        //The count variable has been enclosed
        //Even though the outer function has already executed and is not being called,
        //the count variable is still able to be used.
        count=count+1;
    }

}

let func = outer();
console.log(func);
func();
func();
func();
let func2 = outer();
func();//The count variable did not reset its value for func();
func2();
func();

// A closer is a function that returns a function, where the inner function still has access
// to variables declared in the outer function.