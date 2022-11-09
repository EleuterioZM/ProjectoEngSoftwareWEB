/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Model.Avaliacao;
import Model.Disciplina;
import Utilitarios.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Vanio Anibal Macamo
 */
public class AvaliacaoDAO {
     Session sessao = HibernateUtil.getSessionFactory().openSession();
     
     public void guardar(Avaliacao avaliacao){    
           sessao.beginTransaction();
            sessao.save(avaliacao);
            sessao.getTransaction().commit();
            sessao.flush();
          //sessao.close();
        }
       public List<Avaliacao> listarAvaliacoes(){
          //  sessao.beginTransaction();
            List<Avaliacao> listaAvaliacoes=new ArrayList();
            Query requisitar=sessao.createQuery("From Avaliacao");
            listaAvaliacoes=requisitar.list();
            return listaAvaliacoes;
        }
          public void remover(int codigo){    
//           sessao.beginTransaction();
            for(Avaliacao avaliacao: listarAvaliacoes()){
                if(avaliacao.getCodigo() == codigo){
                    sessao.beginTransaction();
                    sessao.delete(avaliacao);
                    sessao.getTransaction().commit();
                    sessao.flush();
                }
            }
            
          //sessao.close();
        }
         public void actualizar(int codigo,String  descricao){
     
             for(Avaliacao avaliacao: listarAvaliacoes()){
                if(avaliacao.getCodigo() == codigo){
                    avaliacao.setDescricao(descricao);
                    sessao.beginTransaction();
                    sessao.update(avaliacao);
                    sessao.getTransaction().commit();
                    sessao.flush();
                }
             }
         }
    
}
