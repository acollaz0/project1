function outer(){

    console.log("I am the outer function")
    let count = 0;

   return function inner(){
        console.log(" Hi I am the inner function")
        console.log(count)
        // the count variable has been enclosed
        // even though the outer function has already executed and 
        // is not being called that variable is still able to be used
        count = count +1;
    }

}

let func = outer();
console.log(func)
func()
func()

let func2 = outer();
func()
func2()
func()
// a closure is a function that returns a function
// where the inner function still has access to variables
// declared in the outer function