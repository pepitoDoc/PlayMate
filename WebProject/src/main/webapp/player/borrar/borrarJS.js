window.addEventListener(
    "DOMContentLoaded",
    () => {
      document.querySelector('#botonEliminarFirst').addEventListener('click', () => {
        const nameInput = document.querySelector('#nickname').value;
        const passInput = document.querySelector('#password').value;
  
        if (nameInput == "" || passInput == "") { 
          alert("Faltan datos por introducir!");
        } else {
          showPopup();
          document.querySelector('#eliminarUsuario').addEventListener('click', () => {
            const dataSend = {
              nickname: nameInput,
              password: passInput
            };
            fetch('http://localhost:8080/WebProject/validate-player', {
              method: 'POST',
              headers: { 'Content-Type': 'application/json' },
              body: JSON.stringify(dataSend),
            })
              .then(response => {
                if (response.status == 500) {
                  window.location.replace("http://localhost:8080/WebProject/error/error.jsp");
                } else {
                  return response.text();
                }
              })
              .then(data => {
                if (data == "1") { 
                  fetch("http://localhost:8080/WebProject/delete-player", {
                    method: 'POST',
                    headers: {
                      "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                      nickname: nameInput,
                      password: passInput
                    })
                  })
                    .then(response => {
                      if (response.status == 500) {
                        window.location.replace("http://localhost:8080/WebProject/error/error.jsp");
                      } else {
                        return response.text();
                      }
                    })
                    .then(data => {
                      if (data == "1") { 
                        window.alert("Usuario eliminado correctamente!")
                        window.location.replace("http://localhost:8080/WebProject/index.jsp");
                      } else {
                        window.alert("Usuario no se ha eliminado, error!")
                        //window.location.replace("http://localhost:8080/WebProject/index.jsp");
                      }
                    });
                } else {
                  window.alert("El usuario con estos datos no existe!");
                  cancelAction();
                }
              });
              confirmAction();
          });
        }
      });
  
      function showPopup() {
        var popup = document.getElementById("popup");
        popup.style.display = "flex";
      }
  
      function hidePopup() {
        var popup = document.getElementById("popup");
        popup.style.display = "none";
      }
  
      function confirmAction() {
        // Handle confirm action here
        hidePopup();
      }
  
      function cancelAction() {
        // Handle cancel action here
        hidePopup();
      }
    });