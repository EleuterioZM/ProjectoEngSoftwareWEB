/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Model.Estudante;
import Utilitarios.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Vanio Anibal Macamo
 */
public class EstudanteDAO {
    
     Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        public void guardarEstudante(Estudante estudante){    
           sessao.beginTransaction();
            sessao.save(estudante);
            sessao.getTransaction().commit();
            sessao.flush();
          //sessao.close();
        }
        public List<Estudante> listarEstudantes(){
            //sessao.beginTransaction();
            List<Estudante> listaEstudantes=new ArrayList();
            Query requisitar=sessao.createQuery("From Estudante");
            listaEstudantes=requisitar.list();
            return listaEstudantes;
        }
        public void remover(int nrMatricula){
            sessao.beginTransaction();
            List<Estudante> listaEstudantes=new ArrayList();
            Query requisitar=sessao.createQuery("From Estudante");
            listaEstudantes=requisitar.list();
            for(Estudante estudante: listaEstudantes){
                if(estudante.getNrMatricula() == nrMatricula){
                    sessao.delete(estudante);
                    sessao.getTransaction().commit();
                    sessao.flush();
//                    JOptionPane.showMessageDialog(null, "Removido");
                }
            }
        }
        public void ActualizarEstudante(int nrMatricula, String nome,String  apelido,String contacto, String endereco){
            
             //Estudante estudante=(Estudante)sessao.load(Estudante.class, nrMatricula);
             
             for(Estudante estudante: listarEstudantes()){
                 if(estudante.getNrMatricula()==nrMatricula){            
                    estudante.setApelido(apelido);
                    estudante.setContacto(contacto);
                    estudante.setEndereco(endereco);
                    estudante.setNome(nome);
                    
                    sessao.beginTransaction();
                    sessao.update(estudante);
                    sessao.getTransaction().commit();
                    sessao.flush();
                 }
             }
        }
        
    
    
}
