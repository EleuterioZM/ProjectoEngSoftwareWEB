/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validar(){
    
   let codigo = frmGestaoNotas.codigo.value
   let nota = frmGestaoNotas.nota.value
   
   
   if(nota===""){
        alert("Preencha O Campo Carga Horaria")
       frmGestaoNotas.nota.focus()
         return false
   }else if((nota<0)){
         alert("Nota Invalida")
       frmGestaoNotas.nota.focus()
         return false
   }else if((nota>20)){
         alert("Nota Invalida")
       frmGestaoNotas.nota.focus()
         return false
     }else{
        document.forms["frmGestaoNotas"].submt();
   }
}
