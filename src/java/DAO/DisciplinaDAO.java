/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Model.Disciplina;
import Utilitarios.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author Vanio Anibal Macamo
 */
public class DisciplinaDAO {
    
     Session sessao = HibernateUtil.getSessionFactory().openSession();
     
     public void guardar(Disciplina disciplina){    
           sessao.beginTransaction();
            sessao.save(disciplina);
            sessao.getTransaction().commit();
            sessao.flush();
          //sessao.close();
        }
          public List<Disciplina> listarDisciplinas(){
          //  sessao.beginTransaction();
            List<Disciplina> listaDisciplinas=new ArrayList();
            Query query = sessao.createQuery("From Disciplina");
            listaDisciplinas = query.list();
            return listaDisciplinas;
        }
          public void remover(int codigo){    
//           sessao.beginTransaction();
            for(Disciplina disciplina: listarDisciplinas()){
                if(disciplina.getCodigo() == codigo){
                    sessao.beginTransaction();
                    sessao.delete(disciplina);
                    sessao.getTransaction().commit();
                    sessao.flush();
                }
            }
            
          //sessao.close();
        }
         public void actualizar(int codigo, String cargaHoraria,String  descricao){
     
             for(Disciplina disciplina: listarDisciplinas()){
                if(disciplina.getCodigo() == codigo){
                    disciplina.setCargaHoraria(cargaHoraria);
                    disciplina.setDescricao(descricao);
                    sessao.beginTransaction();
                    sessao.update(disciplina);
                    sessao.getTransaction().commit();
                    sessao.flush();
                }
             }
        }
      public Disciplina findById(Long idDisciplina){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("SELECT d FROM Disciplina as d WHERE d.id=:idDisciplina");
        query.setParameter("idDisciplina", idDisciplina);
        List<Disciplina> disciplinas = query.list();

        session.getTransaction().commit();
        session.close();
        return disciplinas.get(0);
    }
        
    
}
