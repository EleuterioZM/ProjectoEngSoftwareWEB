/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validar(){
    let codigo=frmCadastrarAvaliacao.codigo.value
    let descricao = frmCadastrarAvaliacao.descricao.value
    
        if(codigo ===""){
            alert("Preencha O Campo Codigo")
            frmCadastrarAvaliacao.codigo.focus()
            return false
        }else if (descricao ===""){
            alert("Preencha O Campo Descricao")
            frmCadastrarAvaliacao.codigo.focus()
            return false
    }else{
            alert("Avaliacao Inserida Com Sucesso!")
            document.forms["frmCadastrarAvaliacao"].submt();   
    }
}
function validarActualizar(){
     let codigo=frmActualizarAvaliacao.codigo.value
    let descricao = frmActualizarAvaliacao.descricao.value
    
        if(codigo ===""){
            alert("Preencha O Campo Codigo")
            frmCadastrarAvaliacao.codigo.focus()
            return false
        }else if (descricao ===""){
            alert("Preencha O Campo Descricao")
            frmActualizarAvaliacao.codigo.focus()
            return false
    }else{
            document.forms["frmActualizarAvaliacao"].submt();   
    }
}


