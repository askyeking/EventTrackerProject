window.addEventListener('load', function(e) {
	init();
	getGames();

});

function init() {

	document.searchForm.lookup.addEventListener('click', function(e) {
		e.preventDefault();
		var gameId = document.searchForm.gameId.value;
		if (!isNaN(gameId) && gameId > 0) {
			getGame(gameId);
		}
	});

	document.searchForm.newGame.addEventListener('click', function(e) {
		e.preventDefault();
		let game = 'undefined';
		// call display game without passing a game to display the
		// form without data in it. And to only show the submit button
		displayGame();
		console.log('testing addgame button');
	});

}

function getGames() {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/games');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let response = xhr.responseText; // pull response text from
				// xhr response
				let games = JSON.parse(response); // convert JSON text to JS
				// Object
				displayGames(games);
			} else {

			}
		}
	}

	xhr.send();
}

function getGame(id) {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/games/' + id);
	xhr.onreadystatechange = function() {

		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let response = xhr.responseText;
				let game = JSON.parse(response);
				displayGame(game);
			}
		}
	}
	xhr.send();
}

function deleteGame(id) {
	let xhr = new XMLHttpRequest();
	xhr.open('DELETE', 'api/games/' + id);

	if (xhr.readyState === 4) {
		if (xhr.status === 200 || xhr.status === 201) {
			let response = xhr.responseText;
			let gameDeletion = JSON.parse(response);
				
		}
	}
	xhr.send();
}



function updateGame(game){
	let xhr = new XMLHttpRequest();
	xhr.open('PUT','api/games/' + game.id);
	xhr.setRequestHeader("Content-type", "application/json");
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200 || xhr.status === 201){
				let response = xhr.responseText;
				let game = JSON.parse(response);
				
			}
		}
	}
	let gameJSON = JSON.stringify(game);
	xhr.send(gameJSON);
	
}


function createGame(game) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/games');
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let response = xhr.responseText;
				let game = JSON.parse(response);
				console.log(game);
				let newRow = createRow(game);
				let gamesTableBody = document.getElementById('gamesTableBody');
				showForm(game);
				console.log(game);
				gamesTableBody.appendChild(newRow);
			}
		}
	}

	let gameJSON = JSON.stringify(game);
	xhr.send(gameJSON);
}

function displayGames(games) {
	console.log(games);
	var table = document.createElement('table');
	table.setAttribute('id', 'gamesTable');

	var tableBody = document.createElement('tbody');
	tableBody.setAttribute('id', 'gamesTableBody')
	var tableHead = createHead(tableBody);
	table.appendChild(tableHead);

	for (let i = 0; i < games.length; i++) {
		let gameRow = createRow(games[i]);
		tableBody.appendChild(gameRow);
	}
	table.appendChild(tableBody);
	var tableDiv = document.createElement('div');
	tableDiv.appendChild(table);
	document.body.appendChild(tableDiv);

}

function displayGame(game) {
	var gameDiv = document.getElementById('gameDiv');
	gameDiv.textContent = '';
	// create form for details
	var form = showForm(game);
	gameDiv.appendChild(form);

}

function showForm(game) {
	console.log(game);
	var form = document.createElement('form');
	form.setAttribute('name', 'gameForm');
	form.setAttribute('id', 'gameForm');
	var label = document.createElement('label')
	label.textContent = 'Opponent: ';
	form.appendChild(label);
	var opponentTextbox = document.createElement('input');
	opponentTextbox.setAttribute('type', 'text');
	opponentTextbox.setAttribute('name', 'opponentName');
	opponentTextbox.setAttribute('placeholder', 'Opponent\'s name')
	form.appendChild(opponentTextbox);
	form.appendChild(createBr());
	var hiddenId = document.createElement('input');
	hiddenId.setAttribute('type','hidden');
	hiddenId.setAttribute('name','id');
	form.appendChild(hiddenId);
	var label = document.createElement('label')
	label.textContent = 'Wins: ';
	form.appendChild(label);
	var winsNumberbox = document.createElement('input');
	winsNumberbox.setAttribute('type', 'number');
	winsNumberbox.setAttribute('name', 'gameWins');
	winsNumberbox.setAttribute('placeholder', '# of wins');
	form.appendChild(winsNumberbox);
	form.appendChild(createBr());
	var label = document.createElement('label')
	label.textContent = 'losses: ';
	form.appendChild(label);
	var lossesNumberbox = document.createElement('input');
	lossesNumberbox.setAttribute('type', 'number');
	lossesNumberbox.setAttribute('name', 'gameLosses');
	lossesNumberbox.setAttribute('placeholder', '# of losses');
	form.appendChild(lossesNumberbox);
	form.appendChild(createBr());
	var label = document.createElement('label')
	label.textContent = 'Draws: ';
	form.appendChild(label);
	var drawsNumberbox = document.createElement('input');
	drawsNumberbox.setAttribute('type', 'number');
	drawsNumberbox.setAttribute('name', 'gameDraws');
	drawsNumberbox.setAttribute('placeholder', '# of draws');
	form.appendChild(drawsNumberbox);
	form.appendChild(createBr());
	var label = document.createElement('label')
	label.textContent = 'Deck: ';
	form.appendChild(label);
	var deckBox = document.createElement('input');
	deckBox.setAttribute('type', 'text');
	deckBox.setAttribute('name', 'deck');
	deckBox.setAttribute('placeholder', 'Your deck\'s name')
	form.appendChild(deckBox);
	form.appendChild(createBr());
	var label = document.createElement('label')
	label.textContent = 'Opponent Deck: ';
	form.appendChild(label);
	var opponentDeckBox = document.createElement('input');
	opponentDeckBox.setAttribute('type', 'text');
	opponentDeckBox.setAttribute('name', 'opponentDeck');
	opponentDeckBox.setAttribute('placeholder', 'Opponent\'s deck name')
	form.appendChild(opponentDeckBox);
	form.appendChild(createBr());
	if (typeof game !== 'undefined') {
		hiddenId.setAttribute('value', game.id);
		opponentTextbox.setAttribute('value', game.opponentName);
		winsNumberbox.setAttribute('value', game.gameWins);
		lossesNumberbox.setAttribute('value', game.gameLosses);
		drawsNumberbox.setAttribute('value', game.gameDraws);
		deckBox.setAttribute('value', game.deck);
		opponentDeckBox.setAttribute('value', game.opponentDeck);
		// create edit button only if the game already exists
		var editButton = document.createElement('BUTTON');
		editButton.appendChild(document.createTextNode('Submit Edit'));
		editButton.addEventListener('click', function(e) {
			e.preventDefault();
			var form = e.target.parentElement;
			var game = {
					id: e.target.parentElement.id.value,
					opponentName : form.opponentName.value,
					gameWins : form.gameWins.value,
					gameLosses : form.gameLosses.value,
					gameDraws : form.gameDraws.value,
					deck : form.deck.value,
					opponentDeck : form.opponentDeck.value	
			}
			updateGame(game);
			updateRow(game);
		});
		form.appendChild(editButton);
		form.appendChild(createBr());
		console.log('testing button creation');
		console.log(form);
		// create the delete button only if the game exists
		var deleteButton = document.createElement('BUTTON');
		deleteButton.appendChild(document.createTextNode('Delete'));
		deleteButton.addEventListener('click', function(e) {
			e.preventDefault();
			var gameId = e.target;
			deleteGame(game.id);
			removeRow(game);
		});
		form.appendChild(deleteButton);
		form.appendChild(createBr());
		form.appendChild(createBr());
	}
	// if a game does not exist when this method is called, show form and create
	// game button
	else if (typeof game === 'undefined') {
		var createButton = document.createElement('BUTTON');
		createButton.setAttribute('id', 'submitButton')
		createButton.appendChild(document.createTextNode('Submit Game'));
		createButton.addEventListener('click', function(e) {
			e.preventDefault();
			var gameForm = e.target.parentElement;
			var game = {
				opponentName : form.opponentName.value,
				gameWins : form.gameWins.value,
				gameLosses : form.gameLosses.value,
				gameDraws : form.gameDraws.value,
				deck : form.deck.value,
				opponentDeck : form.opponentDeck.value
			}
			console.log(game);
			createGame(game);

		});
		form.appendChild(createButton);
		form.appendChild(createBr());
	}

	return form;
}



function createHead(tableBody) {
	var headRow = document.createElement('tr');

	var opponentName = document.createElement('td');
	opponentName.setAttribute('class', 'head');
	opponentName.textContent = 'Opponent';
	headRow.appendChild(opponentName);

	var wins = document.createElement('td');
	wins.setAttribute('class', 'head');
	wins.textContent = 'Wins';
	headRow.appendChild(wins);

	var losses = document.createElement('td');
	losses.setAttribute('class', 'head');
	losses.textContent = 'Losses';
	headRow.appendChild(losses);

	var draws = document.createElement('td');
	draws.setAttribute('class', 'head');
	draws.textContent = 'Draws';
	headRow.appendChild(draws);

	var deck = document.createElement('td');
	deck.setAttribute('class', 'head');
	deck.textContent = 'Deck';
	headRow.appendChild(deck);

	var opponentDeck = document.createElement('td');
	opponentDeck.setAttribute('class', 'head');
	opponentDeck.textContent = 'Opponent\'s Deck';
	headRow.appendChild(opponentDeck);

	return headRow;
}

function createRow(game) {
	var gameRow = document.createElement('tr');
	gameRow.addEventListener('click', function(e) {
		getGame(game.id);
	});
	for ( var variable in game) {
		if (variable !== 'id') {
			var tableData = document.createElement('td');
			gameRow.setAttribute('id' ,  game.id + "");
			tableData.textContent = game[variable];
			gameRow.appendChild(tableData)
		}
	}

	return gameRow;
}

function updateRow(game){
	var row = document.getElementById( game.id+"");
	var rowData = row.children;
	console.log(row);
	console.log(rowData);
		let i = 0;
		for ( var gameData in game) {
			if(gameData !== 'id'){
				console.log(rowData[i].textContent);
				console.log(game[gameData]);
				rowData[i].textContent = game [gameData];
				i++;
			}
	
		}
		
	
	
}

function removeRow(game){
	var tableBody = document.querySelector('tbody')
	var rows = document.querySelectorAll('tr');
	for (let i = 0; i < rows.length; i++) {
		console.log('testing remove row');
		console.log(rows[i]);
		console.log(rows[i].parentElement);
		console.log(rows[i].getAttribute('id'));
		console.log(game.id);
		if(rows[i].getAttribute('id') ===  game.id + ""){
			tableBody.removeChild(rows[i]);
			console.log('testing remove row');
		}
		
	}
	
}

function createBr() {
	var br = document.createElement('br');
	return br;
}
