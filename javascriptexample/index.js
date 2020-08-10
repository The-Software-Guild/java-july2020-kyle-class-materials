document.getElementById("aDiv").innerText = "Here is a div"

var blueElements = document.getElementsByClassName("blue")

for (var i = 0; i < blueElements.length; i++) {
	blueElements[i].innerText = "This is a blue element"
}

var game = {
	"name" : "Mario",
	"genre" : "Platformer"	,
	"jump" : function() {
		console.log("mario jumps")
	}
}

console.log(game)
console.log(game.name)

document.getElementsByTagName("button")[0].onclick = game.jump;

console.log(document.getElementById("aDiv"))

function onButtonPress() {
	console.log("button press")
	document.getElementById("aDiv").insertAdjacentHTML("beforeend", "<p>the button was pressed</p>")
}

