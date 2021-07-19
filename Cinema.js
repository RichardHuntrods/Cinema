`use strict`//avoids writing code that looks like its working but isnt!
//query selector is used to get the elements/methods from my domain class
const NAME = document.querySelector("#name");
const GENRE = document.querySelector("#genre");
const RUNTIME = document.querySelector("#runTime");
const CERTIFICATION = document.querySelector("certification");
const NUMBEROFTICKETS =document.querySelector("NumberOfTickets");
const DIV = document.querySelector("#btn");


let submitButton = document.querySelector("#btn");
//creating delete button
const DELETEID = document.querySelector("deleteID");
let delBTN = document.querySelector("#delBtn");

const printToScreen = (msg) => {
const P = document.createElement("p");
const TEXT = document.createTextNode(msg);

P.appendChild(TEXT);
DIV.appendChild(P);
}
//preventing null return
const createCinema = (e) => {
e.preventDefault();
//getting the values
const NAME_VALUE = NAME.value;
const GENRE_VALUE = GENRE.value;
const RUNTIME_VALUE = RUNTIME.value;
const CERTIFICATION_VALUE = CERTIFICATION.value;
const NUMBEROFTICKETS_VALUE = NUMBEROFTICKETS.value;

console.log(NAME_VALUE,GENRE_VALUE,RUNTIME_VALUE,CERTIFICATION_VALUE,NUMBEROFTICKETS_VALUE);
//link to api
let data ={
    name: NAME_VALUE,
    genre: GENRE_VALUE,
    runTime: RUNTIME_VALUE,
    certification: CERTIFICATION_VALUE,
    numberOfTickets: NUMBEROFTICKETS_VALUE
};
//installing database to run on port 8080 which is the default port for my project through spring boot
axios.post(`http://localhost:8080/cinema/create`, data, {
headers:{
    `Access-Control-Allow-Origin`: `*`,
 
}})

.then((response) => printToScreen("It's working!!!"))
.catch((error) => printToScreen("It's bolloxed!!"));

}

const deleteFilm = () => {

const DELID = Number(DELETEID.value);

axios.delete(`http://localhost:8080/films/delete/${DELID}`,{
headers:{   
`Access-Control-Allow-Origin`: `*`
}
})
axios.get("https://reqres.in/api/users/2")
.then((response) => printToScreen(response.data.data.first_name))
.catch((error) => printToScreen("Something went tits up again!"));
}

submitButton.addEventListener(`click`, createFilms);
delBTN.addEventListener(`click`, deleteFilm);
