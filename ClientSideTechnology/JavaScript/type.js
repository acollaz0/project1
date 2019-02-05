//JavaScript has datatypes
//it has primitives and objects
let boolean =  true; //boolean
let nothing = null; //null
let adam = "Adam R" //string
let x; //undefined type
let number = 1000; //number type

console.log(typeof(adam))



//truthy falsy and type coercion
let num1 = 100;
let num2 = 100;
let num3 = "100";

console.log(num1 == num2); // true

console.log(num1 == num3); // true with double equals JavaScript performs
//type coercion where it tries to ignor the type
//and see if two things are equal truthy value

console.log(num1 === num3); //false
//type of the variable is enforced

let tboo = true;
let fboo = false;
// "" empty strings are considered falsy
console.log(false == "")

//empty arrays are also considered falsy
console.log(false == [])

//0 is considered falsy
console.log(false == 0)

//"0" is also falsy
console.log(false == "0")

//null is falsy for things that are not null or undefined
console.log(false == null)

//null is equal to itself
console.log(null == null)

let result = 100/0;

console.log(result)
console.log(typeof(result))

//Not a Number is of type number
//NaN is always false even against itself is false
let b = NaN;
let c = NaN;
console.log(typeof(b));
console.log(b === c);
