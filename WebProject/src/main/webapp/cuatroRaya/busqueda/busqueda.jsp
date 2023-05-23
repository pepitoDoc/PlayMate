<%@ page contentType="text/html; charset=UTF-8" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="busqueda.css" rel="stylesheet" type="text/css" />
        <link rel="icon" href="../images/4raya_logo.png" type="image/x-icon" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <title>Buscar partidos 4Raya</title>
    </head>

    <body>
        <section>
            <div class="container">
                <div class="row">
                    <h1 class="text-center my-3">BUSQUEDA DE PARTIDOS <span class="badge bg-primary">4 EN RAYA</span>
                    </h1>
                </div>
                <div class="row d-flex justify-content-center">
                    <input class="nickname" type="text" class="form-control" placeholder="Nombre" aria-label="Nombre">
                </div>
                <div class="row justify-content-center my-5 justify-content-between">
                    <button type="button" class="btn btn-primary col-3">Buscar por nombre</button>
                    <button type="button" class="btn btn-secondary col-3">Menú principal</button>
                </div>
            </div>
        </section>
        <section>
            <div class="container text-center my-2">
                <div class="gamesPlayedWonLoss">
                    <div id="total">

                    </div>
                    <div id="wins">

                    </div>
                    <div id="loss">

                    </div>
                </div>
                <table class="table ">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Jugador 1</th>
                            <th scope="col">Jugador 2</th>
                            <th scope="col">Ganador</th>
                            <th scope="col">Fecha</th>
                        </tr>
                    </thead>
                    <tbody class="table-body">

                    </tbody>
                </table>
            </div>
        </section>

        <script src="busqueda.js"></script>
    </body>

    </html>