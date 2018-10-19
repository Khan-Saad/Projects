var squares = document.querySelectorAll(".square");
var squares2 = document.querySelectorAll(".hide");
var colorDisplay = document.getElementById("colorDisplay");
var messageDisplay = document.querySelector("#message")
var h1 = document.querySelector("h1");
var newColor = document.querySelector("button");
var easy = document.querySelector("#easy");
var hard = document.querySelector("#hard");
var amount = 6;

easy.addEventListener("click", function(){
	amount = 3;
	easy.classList.add("selected");
	hard.classList.remove("selected");

	colors = generateRandom(amount);
	pickedColor = pickColor();
	set();
	h1.style.backgroundColor = "steelblue";
	squares2[0].style.backgroundColor = "#232323";
	squares2[1].style.backgroundColor = "#232323";
	squares2[2].style.backgroundColor = "#232323";


});

hard.addEventListener("click", function(){
	amount = 6;
	hard.classList.add("selected");
	easy.classList.remove("selected");

	colors = generateRandom(amount);
	pickedColor = pickColor();
	set();
	h1.style.backgroundColor = "steelblue";

});

var colors = generateRandom(amount);
var pickedColor = pickColor();
set();

newColor.addEventListener("click", function(){
	newColor.textContent = "New Colors";
	colors = generateRandom(amount);
	pickedColor = pickColor();
	set();
	h1.style.backgroundColor = "steelblue";

});


function set(){
	for(var i = 0; i < squares.length;  i++){
		squares[i].style.backgroundColor = colors[i];
		squares[i].addEventListener("click", function(){

			if (this.style.backgroundColor === pickedColor) {
				messageDisplay.textContent = "Correct";
				changeColors(this.style.backgroundColor);
				newColor.textContent = "Play Again";
			}
			else{
				this.style.backgroundColor = "#232323";
				messageDisplay.textContent = "Try Again";
			}
		});
	}
	messageDisplay.textContent = "";
}

function changeColors(color){
	for(var i = 0; i < amount; i++){
		squares[i].style.backgroundColor = color;
	}

	h1.style.backgroundColor = color;
}

function pickColor(){
	col = colors[Math.floor(Math.random()*colors.length)]
	colorDisplay.textContent = col ;
	return col;
}

function generateRandom(num){
	var arr = [];
	for(var i = 0; i<num; i++){
		arr[i] = randomColor();
	}
	return arr;

}

function randomColor(){
	var r = Math.floor(Math.random() *256);
	var g = Math.floor(Math.random() *256);
	var b = Math.floor(Math.random() *256);
	return "rgb(" + r + ", " + g + ", " + b + ")";
}

