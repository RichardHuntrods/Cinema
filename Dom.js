`use strict`;

let logo1 = document.querySelector("#logo1");
logo1.setAttribute("width","200");

console.dir(logo1);

Let newHeading = document.createElement("h1");
Let text = document.createTextNode("Porky's Cinema");

newHeading.appendChild(text);

Let divAddToMe = document.querySelector("#addToMe");
divAddToMe.appendChild(newHeading);