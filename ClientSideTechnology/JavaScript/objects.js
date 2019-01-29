// An object in JS is a collection key value pairs


// An object literal
let person = {
    name:"Adam",
    sayHello : () => {
        console.log("Hello Everyone")
    }
}

//console.log(person.name) 
person.sayHello()
// you can just add to an object
person.profession = "Trainer";
//console.log(person.profession)

// you can also use a constructor
function Player(name, jersey, team){
    this.name = name;
    this.jersey = jersey;
    this.team = team;
}

let dwanye = new Player("Dwanye Wade",3,"The Heat");
let bosh = new Player("Chris Bosh",10,"The Heat")

//console.log(dwanye.jersey)

// dwanye.dribble = () =>{
//     console.log("Dribble the ball")
// }

//dwanye.dribble();

// JSON JavaScript Object Notation
// a JSON is just a string format for storing information


//console.log(dwanye)
dwanyeJSON = JSON.stringify(dwanye)

//console.log(dwanyeJSON)
let team = [dwanye,bosh]
//console.log(JSON.stringify(team))

let dwayne2 = JSON.parse(dwanyeJSON);
//console.log(dwayne2.name)

// Fun with arrays

let numbers = [10,20,30,40,50];

// will remove the latest element
numbers.pop()

//map will perform an operation on each element
let numbers2 = numbers.map(num => num*10)
console.log(numbers2)


// the array prototype is where the methods are stored for arrays
// JavaScript does not have classes
let ray = [];










