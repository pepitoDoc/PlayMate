const gamesPlayed = JSON.parse(sessionStorage.getItem("gamesPlayed"));
window.addEventListener('DOMContentLoaded', gameResults, false);
console.log(gamesPlayed);
//Create a table to display all data retrieved from session
function gameResults() {
    const bodyTable = document.getElementById('bodyTable');


    gamesPlayed.forEach(game => {
        const tr = document.createElement('tr');
        bodyTable.appendChild(tr);

        const tdGame = document.createElement('td');
        tdGame.setAttribute('scope', 'row');
        tdGame.textContent = "1";
        tr.appendChild(tdGame);

        const Player1name = document.createElement('td');
        Player1name.textContent = game.player1;
        tr.appendChild(Player1name);

        const Player2name = document.createElement('td');
        Player2name.textContent = game.player2;
        tr.appendChild(Player2name);

        const winnerNameColor = document.createElement('td');
        winnerNameColor.textContent = game.winner;
        tr.appendChild(winnerNameColor);

        const date = document.createElement('td');
        date.textContent = game.date;
        tr.appendChild(date);
    });


    //Clean the session of unnecesary data
    // sessionStorage.clear();
}

