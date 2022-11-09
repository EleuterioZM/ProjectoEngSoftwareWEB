/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validar(){
  
 //  let codigo=frmActualizarDisciplina.codigo.value
    let cargaHoraria = frmActualizarDisciplina.cargaHoraria.value
    let descricao = frmActualizarDisciplina.descricao.value
    
    if(cargaHoraria ===""){
        alert("Preencha O Campo Carga Horaria")
        frmActualizarDisciplina.cargaHoraria.focus()
         return false
    }else if(desricao ===""){
        alert("Preencha o Campo Descricao")
        frmActualizarDisciplina.descricao.focus()
         return false
    }else{
        document.forms["frmActualizarDisciplina"].submt();   
    }
}
function validarCadastro(){
    
    let codigo=frmCadastrarDisciplina.codigo.value
    let cargaHoraria = frmCadastrarDisciplina.cargaHoraria.value
    let descricao = frmCadastrarDisciplina.descricao.value
   
    if(codigo ===""){
         alert("Preencha O Campo Codigo")
         frmCadastrarDisciplina.codigo.focus();
         return false
    }
    else if(cargaHoraria ===""){
        alert("Preencha O Campo Carga Horaria")
         frmCadastrarDisciplina.cargaHoraria.focus()
         return false
    }else if(desricao ===""){
        alert("Preencha o Campo Descricao")
         frmCadastrarDisciplina.descricao.focus()
         return false
    }else{
        alert("Disciplina Cadastrada Com Sucesso!")
        document.forms[" frmCadastrarDisciplina"].submt();   
    }
}

