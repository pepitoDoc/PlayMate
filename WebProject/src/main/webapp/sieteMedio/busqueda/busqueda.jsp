<%@ page contentType="text/html; charset=UTF-8" %>

  <!doctype html>
  <html lang="en">

  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="../../resources/sieteymedio.png" type="image/x-icon" />
    <title>Busqueda por nombre</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>

  <body>
    <div class="container">
      <div class="row text-center">
        <h1 class="my-lg-4 display-7 fw-bold ls-tight" style="color: hsl(0, 0%, 0%)">
          <img src="../../resources/logoPlayMate.png" class="img-fluid me-3" style="width: 100px; height: 100px;"
            alt="Responsive image">Play
          <span style="color: hsl(216, 100%, 50%)">MATE</span>
        </h1>
      </div>
      <div class="row">
        <h3 class="text-center my-2">BUSQUEDA DE PARTIDOS <span class="badge bg-primary">SIETE Y MEDIO</span>
        </h3>
      </div>
      <div class="row d-flex justify-content-center">
        <label for="nickname" class="col-sm-2 col-form-label my-5">Nombre</label>
        <div class="col-4">
          <input type="text" class="form-control my-5" id="nickname" name="nickname" placeholder="Nombre de usuario">
        </div>
      </div>
    </div>
    <div class="row justify-content-center my-2">
      <button id="botonBusqueda" type="button" class="btn btn-primary col-1">Buscar por nombre</button>
      <div class="col-2"></div>
      <button type="button" class="btn btn-secondary col-1">Menú principal</button>
    </div>
    <div class="row mt-4" id="juegos">
      <div class="row" id="ranking">
        <p id="total" class="text-center"></p>
        <p id="wins" class="text-center"></p>
        <p id="loss" class="text-center"></p>
        <!--<p id="most"></p>-->
      </div>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">Jugador 1</th>
            <th scope="col">Jugador 2</th>
            <th scope="col">Jugador 3</th>
            <th scope="col">Banca</th>
            <th scope="col">Puntuación jugador 1</th>
            <th scope="col">Puntuación jugador 2</th>
            <th scope="col">Puntuación jugador 3</th>
            <th scope="col">Puntuación banca</th>
            <th scope="col">Apuesta jugador 1</th>
            <th scope="col">Apuesta jugador 2</th>
            <th scope="col">Apuesta jugador 3</th>
            <th scope="col">Fecha partida</th>
          </tr>
        </thead>
        <tbody id="campos">
        </tbody>
      </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"></script>
    <script src="busqueda.js"></script>
  </body>

  </html>