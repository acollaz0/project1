{
    
    console.log(greeting);
    var greeting="Hello Everyone"; //You would expect the same error as if you hadn't declared it, but it's just undefined
    //Hoisting is a feature in javascript where variables are "hoisted" to the top of their scope, but their values are not
}
//above code is equivalent to this:
{
    var hello; //Only var is hoisted
    console.log(greeting);
    greeting="Hello Everyone"; 
}