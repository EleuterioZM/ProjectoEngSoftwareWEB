

package Controller;

import DAO.AvaliacaoDAO;
import Model.Avaliacao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vanio Anibal Macamo
 */
@WebServlet(name = "ControllerAvaliacao", urlPatterns = {"/ControllerAvaliacao","/formCadastrarAvaliacoes","/cadastrar","/removerAvaliacao",
    "/actualizarA","/frmActualizarAvaliacao"})
public class ControllerAvaliacao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String action = request.getServletPath();
            if(action.equals("/formCadastrarAvaliacoes")){
                chamarCadastrarAvaliacoes(request, response);
            }else if(action.equals("/cadastrar")){
                cadastrarAvaliacao(request, response);
                 chamarCadastrarAvaliacoes(request, response);
            }else if(action.equals("/frmActualizarAvaliacao")){
                   chamarCadastrarAvaliacoes(request, response);
            }else if(action.equals("/actualizarA")){
                actualizar(request, response);
                chamarCadastrarAvaliacoes(request, response);
            }else if(action.equals("/removerAvaliacao")){
                remover(request, response);
                chamarCadastrarAvaliacoes(request, response);
            }else{
                response.sendRedirect("index.jsp");
               }
    }
     protected void actualizar(HttpServletRequest request, HttpServletResponse response) throws IOException{
          if(request.getParameter("codigo")!=""){
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                String descricao = request.getParameter("descricao");
                AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
                avaliacaoDAO.actualizar(codigo, descricao);
          }
     }
     protected void remover(HttpServletRequest request, HttpServletResponse response) throws IOException{
          if(request.getParameter("codigo")!=""){
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                String descricao = request.getParameter("descricao");
                AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
                avaliacaoDAO.remover(codigo);
          }
     }
      protected void cadastrarAvaliacao(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //  int codigo = (( request.getAttribute("nome"));
          if(request.getParameter("codigo")!=""){
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                String descricao = request.getParameter("descricao");
                Avaliacao avaliacao = new Avaliacao(codigo, descricao);
                AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
                avaliacaoDAO.guardar(avaliacao);
          }
      }
     protected void chamarCadastrarAvaliacoes(HttpServletRequest request, HttpServletResponse response) throws IOException{
         response.sendRedirect("FRMCadastrarAvaliacao.jsp");
     }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

 
}
