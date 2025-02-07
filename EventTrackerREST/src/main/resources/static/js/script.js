window.addEventListener('load', function(e) {
	init();
});

function init() {
	loadBands();
}

function loadBands() {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/bands');

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) { //readState 4 means the request was completed 
			if (xhr.status === 200) {
				let bands = JSON.parse(xhr.responseText);
				createTable(bands);
			}
		}
	}
	xhr.send();
}

function createTable(bands) {
	let table = document.createElement('table');
	table.classList.add('table');


	let head = buildTableHead();
	table.appendChild(head);

	let body = buildTableBody(bands);
	table.appendChild(body);

	let mainDiv = document.getElementById('main');
	mainDiv.appendChild(table);
}

function buildTableHead() {
	let head = document.createElement('thead');

	let headerRow = document.createElement('tr');

	let th = document.createElement('th');
	th.textContent = 'Band Name';
	headerRow.appendChild(th);

	th = document.createElement('th');
	headerRow.appendChild(th);

	th = document.createElement('th');
	th.textContent = 'Vinlys In Collection'
	headerRow.appendChild(th);


	head.appendChild(headerRow);

	return head;

}

function buildTableBody(bands) {
	let body = document.createElement('tbody');
	bands.forEach(function(band) {
		let row = createRow(band);
		body.appendChild(row);
	});
	return body;
}

function createRow(band) {
	let row = document.createElement('tr');
	row.id = band.id;
	row.addEventListener('click', loadVinylsCallback);

	let td = document.createElement('td');
	td.textContent = band.name;
	row.appendChild(td);

	td = document.createElement('td');
	img = document.createElement('img');
	//img.classList.add("w-25", "h-25"); // Makes it responsive and limits width to 50% of parent
	img.classList.add("band-table-img");
	img.src = band.imageUrl;
	td.appendChild(img);
	row.appendChild(td);


	td = document.createElement('td');
	td.textContent = band.numberOfVinyls;
	row.appendChild(td);
	return row;
}

function loadVinylsCallback(event) {
	let bandId = event.target.parentElement.id;
	loadVinylsByBandId(bandId, event.target.parentElement);
}


function loadVinylsByBandId(bandId, tableRow) {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', `api/bands/${bandId}/vinyls`);

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let vinyls = JSON.parse(xhr.responseText);
				createVinylsTable(vinyls, tableRow);
			}
		}
	}
	xhr.send();
}

function createVinylsTable(vinyls, tableRow) {
	let vinylTable = document.createElement('table');
	vinylTable.classList.add('table');
	let tableBody = document.createElement('tbody');
	vinylTable.appendChild(tableBody);
	vinyls.forEach(function(vinyl) {
		let row = document.createElement('tr');

		let td = document.createElement('td');
		td.textContent = vinyl.title;
		row.appendChild(td);

		td = document.createElement('td');
		img = document.createElement('img');
		//img.classList.add( "w-25", "h-25");
		img.classList.add("vinyl-table-img");


		img.src = vinyl.imageUrl;
		td.appendChild(img);
		row.appendChild(td);

		row.appendChild(td);
		tableBody.appendChild(row);
	});
	
	tableRow.parentElement.insertBefore(vinylTable, tableRow.nextElementSibling);

}