/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validar(){
    alert("Estudante Inserido")
    let nrMatricula=frmCadastrarEstudante.nrMatricula.value
   let nome=frmCadastrarEstudante.nome.value
   let apelido=frmCadastrarEstudante.apelido.value
   let contacto=frmCadastrarEstudante.contacto.value
   let endereco=frmCadastrarEstudante.endereco.value
   
   document.forms["frmCadastrarEstudante"].submt();   
}
function validarActualizar(){
   alert("Teste")
    let nrMatricula=frmActualizarEstudante.nrMatricula.value
   let nome=frmActualizarEstudante.nome.value
   let apelido=frmActualizarEstudante.apelido.value
   let contacto=frmActualizarEstudante.contacto.value
   let endereco=frmActualizarEstudante.endereco.value
   
   document.forms["frmActualizarEstudante"].submt();   
}

