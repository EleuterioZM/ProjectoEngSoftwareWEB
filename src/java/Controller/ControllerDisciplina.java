/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.DisciplinaDAO;
import Model.Disciplina;
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
@WebServlet(name = "ControllerDisciplina", urlPatterns = {"/ControllerDisciplina","/formListarDisciplinas","/remover",
    "/actualizar","/formCadastrarDisciplinas","/cadastrarDisciplina"})
public class ControllerDisciplina extends HttpServlet {
   
    DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String action = request.getServletPath();
        if(action.equals("/formListarDisciplinas")){
            chamarListar(request, response);
        }else if(action.equals("/remover")){
            remover(request, response);
            chamarListar(request, response);
        }
        else if(action.equals("/actualizar")){
            actualizar(request, response);
            chamarListar(request, response);
        }else if(action.equals("/formCadastrarDisciplinas")){
            response.sendRedirect("FRMCadastrarDisciplina.jsp");
        }else if(action.equals("/cadastrarDisciplina")){
            cadatrar(request, response);
            response.sendRedirect("FRMCadastrarDisciplina.jsp");
        }
        else{
            response.sendRedirect("index.jsp");
        }
     }
    public void chamarListar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        response.sendRedirect("FRMListarDisciplina.jsp");
    
    }
     public void remover(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            disciplinaDAO.remover(codigo);
    }
      public void cadatrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
          if(request.getParameter("codigo")!=""){
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                String cargaHoraria= request.getParameter("cargaHoraria");
                String  descricao= request.getParameter("descricao");
                Disciplina disciplina = new Disciplina(codigo, cargaHoraria, descricao);
                disciplinaDAO.guardar(disciplina);
            }
    }
    
    public void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            String cargaHoraria= request.getParameter("cargaHoraria");
            String  descricao= request.getParameter("descricao");
            disciplinaDAO.actualizar(codigo, cargaHoraria, descricao);
    }
    
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

             
    }   
    
       
        
}

   

