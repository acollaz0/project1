// JavaScript has datatypes
// it has primitives and objects
// primitives
let boolean = true; // boolean
let nothing = null; // null
let adam = "Adam R" // string
let x; // undefined type
let number = 1000; //number type

//console.log(typeof(x))



// truthy falsy and type coercion
let num1 = 100;
let num2 = 100;
let num3 = "100";

// console.log(num1 == num2) // true
// console.log(num1 == num3)  // true
// with double equals JavaScript
// performs type coercion where it tries to ignore the type
// and see if two things are equal truthy vale

// console.log(num1 === num2 ) // true
// console.log(num1 === num3 ) // false
// the type of the variable is enforced

let tboo = true;
let fboo = false;

// "" empty strings are considered falsy
console.log(false == "")

//  empty arrays are also considered falsy
console.log(false == [])

// 0 is considered falsy
console.log(false == 0)

// "0" is also falsy
console.log(false == "0")

// null is false for things that are not null or undefined
console.log(false == null)

// null is equal to itself
console.log(null == null)
 
 let result = 100/0;

 console.log(result)
 console.log(typeof(result))

 // Not a number is of type number
 // NaN is always false even against itself it false
 let b = NaN;
 let c = NaN;
 console.log(typeof(b))
 console.log(100/0 == 100/0);











