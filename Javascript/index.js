
document.getElementById("paragraph").innerText = "Different text"

function changeColor() {
	var currentClass = document.getElementById("title").className
	if(currentClass != "blue") {
		document.getElementById("title").className = "blue"
	} else {
		document.getElementById("title").className = "red"
	}	
}

function addHtml() {
	document.getElementById("stuff").insertAdjacentHTML("beforeend", "<p>Here is more stuff</p>")
}


console.log(document.getElementsByClassName("red"))