//Some people argue that JavaScript has no types, others say it doesn't
//Javascript has datatypes: primitives and objects
//Primitives:
let bool =true;     //booleans
let nothing = null; //null type
let adam="Adam R";  //String type
let x;              //Undefined type
let number=1000;    //Number type
console.log(typeof(number));
//Difference between null and undefined:
//null is when an object has no value
//undefined is when an object doesn't even exist. It's a fine point.

//Truthy Falsey, and type coercion
// let num1=100;
// let num2=100;
// let num3="100";
// console.log(num1==num2);
// console.log(num1==num3); //With double equals, javascript performs type coercion
//where it tries to ignore the type and see if two things are equal. The "truthy" value
// console.log(num1===num2);
// console.log(num1===num3); //With triple equals, the type of the variables is enforced. The "falsey" value

let tboo = true;
let fboo = false;

console.log(tboo=="true");          //false
console.log(tboo=="jouinberuop");   //false
console.log(fboo=="false");         //false
console.log(fboo=="");              //true. Empty strings are considered falsey
console.log(fboo==[]);              //true. Empty arrays are also considered falsey
console.log(fboo==0);               //true. zero is considered falsey
console.log(fboo=="0");             //true. the string zero is also falsey
console.log(fboo==null);            //false. null is not falsey. Always false for things that aren't null
console.log(null==null);            //true. null always equals itself

let result = 100/0;
console.log(result);                //Infinity. Not a number
console.log(typeof(result));        //Number
let b=NaN;
console.log(typeof(b));             //NaN is of type number
console.log(b==b);                  //NaN is always false, even against itself