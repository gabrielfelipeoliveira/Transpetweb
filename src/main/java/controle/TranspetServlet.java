package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.GenericoDAO;
import modelo.dao.animal.AnimalDomesticoDAOSGDBImpl;
import modelo.dao.corrida.CorridaDAOSGDBImpl;
import modelo.dao.endereco.EnderecoDAOSGDBImpl;
import modelo.dao.usuario.MotoristaDAOSGDBImpl;
import modelo.dao.usuario.TutorDAOSGDBImpl;
import modelo.dao.veiculo.VeiculoDAOSGDBImpl;
import modelo.entidade.animal.AnimalDomestico;
import modelo.entidade.corrida.Corrida;
import modelo.entidade.endereco.Endereco;
import modelo.entidade.usuario.motorista.Motorista;
import modelo.entidade.usuario.tutor.Tutor;
import modelo.entidade.veiculo.Veiculo;

public class TranspetServlet extends HttpServlet{

	GenericoDAO animalDao;
	GenericoDAO corridaDao;
	GenericoDAO enderecoDao;
	GenericoDAO tutorDao;
	GenericoDAO motoristaDao;
	GenericoDAO veiculoDao;
	
	
	public void init() {
		
		animalDao = new AnimalDomesticoDAOSGDBImpl(AnimalDomestico.class);
		corridaDao = new CorridaDAOSGDBImpl(Corrida.class);
		enderecoDao = new EnderecoDAOSGDBImpl(Endereco.class);
		tutorDao = new TutorDAOSGDBImpl(Tutor.class);
		motoristaDao = new MotoristaDAOSGDBImpl(Motorista.class);
		veiculoDao = new VeiculoDAOSGDBImpl(Veiculo.class);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getServletPath();
		
		switch(acao) {
		
		case "/inicial"
		
		
		break;
		
		
		}
	}
	
	
	
}
