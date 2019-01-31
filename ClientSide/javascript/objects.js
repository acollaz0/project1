//Objects in JavaScript
//An object is a collections of key-value pairs
//Several ways to create objects


//Through an object literal:
let person = {
    name:"Adam",
    sayHello:()=>{
        console.log("Adam says Hi!");
    }
}
//Using an object literal
// console.log(person.name);
// person.sayHello();
//Can just add whatever you want to an object
person.profession = "Trainer";
//console.log(person.profession);

//You can also use a constructor to create an object
function Player(name,jersey,team){
    this.name=name;
    this.jersey=jersey;
    this.team=team;
    // The "this" keyword refers to this chunk of code that I am using
}
//Use the new keyword so that you assign new memory when you call the constructor
let dwayne = new Player("Dwanye Wade", 3, "The Heat");
let bosh = new Player("Cris Bosh",10,"The Heat");
//console.log(dwayne.jersey);
// dwayne.dribble = ()=>{
//     console.log("Dribblin the ball.")
// }
//dwayne.dribble();

// JSON: JavaScript Object Notation
// a json is just a string format for storing information

// console.log(dwayne);
let dwJSON = JSON.stringify(dwayne)
// console.log(dwJSON); // JSON just contains information, not functions
let team=[dwayne,bosh]; //Making an array
// console.log(JSON.stringify(team));
let dwayne2 = JSON.parse(dwJSON);
// console.log(dwayne2.name);

//Fun with arrays:
let numbers=[10,20,30,40,50];
console.log(numbers);
//Arrays have a lot of methods you can run on them
//numbers.pop()

//map will perform an operation on each element
let numbers2 = numbers.map(num =>num*10);
console.log(numbers2);

//The array prototype is where the methods are stored for arrays
//Javascript does not have classes
let ray = [];















