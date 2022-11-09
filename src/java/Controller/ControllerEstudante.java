/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.EstudanteDAO;
import Model.Estudante;
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
@WebServlet(name = "ControllerEstudante", urlPatterns = {"/ControllerEstudante","/formCadastrarEstudantes","/cadastrarEstudante"
        ,"/actualizarEstudante","/formListarEstudantes","/removerEst"})
public class ControllerEstudante extends HttpServlet {

    Estudante estudante = new Estudante();
    EstudanteDAO estudanteDAO = new EstudanteDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String action = request.getServletPath();
         
         if(action.equals("/formCadastrarEstudantes")){
             chamarCadastrarEstudante(request, response);
         }else if(action.equals("/cadastrarEstudante")){
             cadastrar(request, response);
             chamarCadastrarEstudante(request, response);
         }else if(action.equals("/actualizarEstudante")){
             actualizar(request, response);
             chamarVizualizarEstudante(request, response);
         }else if(action.equals("/removerEst")){
             remover(request, response);
             chamarVizualizarEstudante(request, response);
         }
         else if(action.equals("/formListarEstudantes")){
             chamarVizualizarEstudante(request, response);
         }
         else{
              response.sendRedirect("index.jsp");
         }
    
    }
    protected void remover(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
            int nrEstudante=Integer.parseInt(request.getParameter("nrMatricula"));
            estudanteDAO.remover(nrEstudante);
    
    }
      protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
            int nrEstudante=Integer.parseInt(request.getParameter("nrMatricula"));
            String nome = request.getParameter("nome");
            String apelido = request.getParameter("apelido");
            String contacto = request.getParameter("contacto");
            String endereco = request.getParameter("endereco");
          
            estudanteDAO.ActualizarEstudante(nrEstudante, nome, apelido, contacto, endereco);
     }
     protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
            int nrEstudante=Integer.parseInt(request.getParameter("nrMatricula"));
            String nome = request.getParameter("nome");
            String apelido = request.getParameter("apelido");
            String contacto = request.getParameter("contacto");
            String endereco = request.getParameter("endereco");
           
            estudante.setNrMatricula(nrEstudante);
            estudante.setNome(nome);
            estudante.setApelido(apelido);
            estudante.setContacto(contacto);
            estudante.setEndereco(endereco);
            
            estudanteDAO.guardarEstudante(estudante);
     }
      protected void chamarVizualizarEstudante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 response.sendRedirect("FRMListarEstudante.jsp");

    }
    protected void chamarCadastrarEstudante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 response.sendRedirect("FRMCadasdtrarEstudante.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
}
