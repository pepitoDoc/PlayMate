window.addEventListener(
    "DOMContentLoaded",
    () => {
        const table = document.querySelector('.table');
        table.style.display = 'none';

        const findButton = document.querySelector('.btn-primary');
        findButton.addEventListener('click', () => {
            if (document.querySelector(".nickname").value != "") {
                extractData(table);
            } else {
                alert("Tiene que introducir un nombre!");
            }
        });

        const menuButton = document.querySelector('.btn-secondary');
        menuButton.addEventListener('click', () => {
            window.location.replace('http://localhost:8080/WebProject/index.jsp');
        });

        function extractData(table) {
            const name = document.querySelector(".nickname").value;
            const url = "http://localhost:8080/WebProject/busqueda-raya?name=" + name;
            fetch(url, {
                method: "GET"
            })
                .then((response) => {
                    if (response.headers.get("Content-Type").includes("application/json")) {
                        // Handle JSON response
                        return response.json();
                    } else {
                        // Handle text response
                        return response.text();
                    }
                })
                .then((data) => {
                    if (data.length == 0) {
                        alert("No hay resultado");
                        table.style.display = "none";
                    } else {
                        console.log(data);
                        populateTable(data,table);
                        
                    }
                })
        }
    });

function populateTable(data, table) {

    const wins = data.winCount;
    const tableBody = document.querySelector('.table-body');
    document.querySelector('#total').textContent = "Total de partidas: " + data.gameData.length;
    document.querySelector('#wins').textContent = "Partidas ganadas: " + wins;
    document.querySelector('#loss').textContent = "Partidas perdidas: " + (data.gameData.length - wins);
    document.querySelector('.table-body').innerHTML = '';
    table.style.display = 'initial';

    data.gameData.forEach((item, index) =>{
        const row = document.createElement("tr");

        // Add row number
        const rowNumberCell = document.createElement("th");
        rowNumberCell.setAttribute('scope','row')
        rowNumberCell.textContent = index + 1;
        row.appendChild(rowNumberCell);
    
        // Add Name
        const player1Name = document.createElement("td");
        player1Name.textContent = item.player1;
        row.appendChild(player1Name);
    
        // Add Name2
        const player2Name = document.createElement("td");
        player2Name.textContent = item.player2;
        row.appendChild(player2Name);
    
        // Add Winner
        const winnerName = document.createElement("td");
        winnerName.textContent = item.winner;
        row.appendChild(winnerName);
    
        // Add Date
        const dateCell = document.createElement("td");
        dateCell.textContent = item.date;
        row.appendChild(dateCell);
    
        // Append the row to the table body
        tableBody.appendChild(row);
    });
}