/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.AvaliacaoDAO;
import DAO.DisciplinaDAO;
import DAO.EstudanteDAO;
import DAO.NotaRealizaDAO;
import Model.Avaliacao;
import Model.Disciplina;
import Model.Estudante;
import Model.Notarealiza;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vanio Anibal Macamo
 */
@WebServlet(name = "ControllerNotaRealiza", urlPatterns = {"/ControllerNotaRealiza","/formGestaoNotas","/lancarNota","/removerG",
    "/actualizarG"})
public class ControllerNotaRealiza extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
         if(action.equals("/formGestaoNotas")){
                chamar(request, response);
            }else if(action.equals("/lancarNota")){
                cadastrar(request, response);
                chamar(request, response);
            }else if(action.equals("/removerG")){
                remover(request, response);
                chamar(request, response);
            }else if(action.equals("/actualizarG")){
                actualizar(request, response);
                chamar(request, response);
            }
         
         else{
                 response.sendRedirect("index.jsp");
         }
    }
     protected void remover(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int codigo=Integer.parseInt(request.getParameter("codigo"));
            NotaRealizaDAO dao = new NotaRealizaDAO();
            dao.remover(codigo);
            
            
     }
     protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int codigo=Integer.parseInt(request.getParameter("codigo"));
            double nota=Double.parseDouble(request.getParameter("nota"));
            NotaRealizaDAO dao = new NotaRealizaDAO();
            dao.actualizar(codigo, nota);  
     }
    protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String disc = request.getParameter("disciplina");
            String ava = request.getParameter("avaliacao");
            String est= request.getParameter("estudante");
            double nota = Double.parseDouble(request.getParameter("nota"));
           
            DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
            AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
            EstudanteDAO estudanteDAO = new EstudanteDAO();
            
            Notarealiza notaRealiza = new Notarealiza();
           NotaRealizaDAO dao = new NotaRealizaDAO();
            
            for(Disciplina disciplina: disciplinaDAO.listarDisciplinas()){
                if(disciplina.getDescricao().equals(disc)){
                    notaRealiza.setDisciplina(disciplina);
                }
            }
            for(Avaliacao avaliacao: avaliacaoDAO.listarAvaliacoes()){
                if(avaliacao.getDescricao().equals(ava)){
                    notaRealiza.setAvaliacao(avaliacao);
                }
            }
             for(Estudante estudante: estudanteDAO.listarEstudantes()){
                if(estudante.getNome().equals(est)){
                    notaRealiza.setEstudante(estudante);
                }
            }
             if((nota>=0)&&(nota<=20) ){
                 notaRealiza.setNota(nota);
                 dao.guardar(notaRealiza);
             }
    }
    protected void chamar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.sendRedirect("FRMGestaoNotas.jsp");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

   

}
