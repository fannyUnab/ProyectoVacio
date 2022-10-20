

function funcionColor(newColor){
    let elemento=document.getElementById('titulonosotros');
    elemento.style.color=newColor;
}


function funcionprod(){
    document.getElementById('product').innerHTML="nuevo texto";
}

function otrafuncion(){
    var x=document.getElementById('uno').innerHTML;
    document.getElementById('dos').innerHTML=x;

}

function validar(){
   let nombre=document.formudatos.querySelector("#validationCustom01").value;
   console.log(nombre);
   let lonombre=document.formudatos.querySelector("#validationCustom01").value.length;
   console.log(lonombre);
    if(lonombre<8){
        alert("ingrese un usuario mayor a 8 ");
    }
    else{
        document.location="login.html";
    }

}

function verificar(){
    let correo=document.getElementById("correo").value;
    let password=document.getElementById("password").value;
    console.log(correo+"."+password)

    fetch('http://localhost:8080/usuarios/login?correo='+correo+'&password='+password+'')
    .then(response => response.json())
    .then(data => {
        console.log(data)
        if(data.msj=="ok") {
            console.log("continuar")
            document.location="productos.html"
         } else { alert(data.msj) } 
        } 
        )
    .catch(error => console.log(error))    
}
