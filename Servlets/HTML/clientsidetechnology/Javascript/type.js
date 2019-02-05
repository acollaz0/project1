//Javascript has datatypes
//it has promitives and objects
let boolean = true;//boolean
let nothing = null;//null
let adam = "AdamR";//string is a primitive in JS
let x;//undefined type
let number = 1000;//number type

console.log(typeof(x));


//truthy falsy and type coercion
let num1 = 100;
let num2 = 100;
let num3 = "100";

console.log(num1 == num2)//true

console.log(num1 == num3)//with double equals JS performs
//type conversion where it tries to ignore the type
//and see if two things are equal truthy value

console.log(num1 === num2)//true
console.log(num1 === num3)//false
//the type of the variable is enforced

let tboo = true;
let fboo = false;
//"" empty strings are considered falsy 
console.log(false == "")

//empty arrays are also considered false
console.log(false==[])

//0 is considered falsy
console.log(false==0)
//"0" is also falsy
console.log(false =="0")
//null is false for things that are not null or undefined
console.log(false==null)
//null is equal to itself
console.log(null==null)
let result = 100/0;
console.log(result);
console.log(typeof(result))
//Not a number is of type number
//NaN is always false even against itself  it is false
let b = NaN;
let c = NaN;
console.log(typeof(b))
console.log(b == c);