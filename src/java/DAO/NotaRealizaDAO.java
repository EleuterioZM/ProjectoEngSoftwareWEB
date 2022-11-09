/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Model.Avaliacao;
import Model.Notarealiza;
import Utilitarios.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Vanio Anibal Macamo
 */
public class NotaRealizaDAO {
    Session sessao = HibernateUtil.getSessionFactory().openSession();
     
     public void guardar(Notarealiza notaRealiza){
         int codigo = 1000;
         if(listarNotasRealizas().size()==0){
             notaRealiza.setCodigo(codigo);
         }else{
            codigo= listarNotasRealizas().get(listarNotasRealizas().size()-1).getCodigo()+1;
            notaRealiza.setCodigo(codigo);
         }
           sessao.beginTransaction();
            sessao.save(notaRealiza);
            sessao.getTransaction().commit();
            sessao.flush();
          //sessao.close();
        }
      public List<Notarealiza> listarNotasRealizas(){
          //  sessao.beginTransaction();
            List<Notarealiza> listaNotaRealizas=new ArrayList();
            Query requisitar=sessao.createQuery("From Notarealiza");
            listaNotaRealizas=requisitar.list();
            return listaNotaRealizas;
        }
          public void remover(int codigo){    
//           sessao.beginTransaction();
            for(Notarealiza notaRealiza: listarNotasRealizas()){
                if(notaRealiza.getCodigo() == codigo){
                    sessao.beginTransaction();
                    sessao.delete(notaRealiza);
                    sessao.getTransaction().commit();
                    sessao.flush();
                }
            }
            
          //sessao.close();
        }
         public void actualizar(int codigo,double nota){
     
            for(Notarealiza notaRealiza: listarNotasRealizas()){
                if(notaRealiza.getCodigo() == codigo){
                    notaRealiza.setNota(nota);
                    sessao.beginTransaction();
                    sessao.update(notaRealiza);
                    sessao.getTransaction().commit();
                    sessao.flush();
                }
             }
         }
    
}
