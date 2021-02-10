package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.GenericoDAO;
import modelo.dao.animal.AnimalDomesticoDAOSGDBImpl;
import modelo.dao.corrida.CorridaDAOSGDBImpl;
import modelo.dao.endereco.EnderecoDAOSGDBImpl;
import modelo.dao.usuario.MotoristaDAOSGDBImpl;
import modelo.dao.usuario.TutorDAOSGDBImpl;
import modelo.dao.usuario.UsuarioDAO;
import modelo.dao.veiculo.VeiculoDAOSGDBImpl;
import modelo.entidade.animal.AnimalDomestico;
import modelo.entidade.corrida.Corrida;
import modelo.entidade.endereco.Endereco;
import modelo.entidade.usuario.Usuario;
import modelo.entidade.usuario.motorista.Motorista;
import modelo.entidade.usuario.tutor.Tutor;
import modelo.entidade.veiculo.Veiculo;

@WebServlet("/")
public class TranspetServlet extends HttpServlet {

	private GenericoDAO<AnimalDomestico> animalDao;
	private GenericoDAO<Corrida> corridaDao;
	private GenericoDAO<Endereco> enderecoDao;
	private GenericoDAO<Tutor> tutorDao;
	private GenericoDAO<Motorista> motoristaDao;
	private GenericoDAO<Veiculo> veiculoDao;

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

		switch (acao) {

		case "/inicial-cadastro":

			abrirPaginaCadastroUsuario(request, response);

			break;

		case "/login":

			logarUsuario(request, response);

			break;

		case "/cadastrar-tutor":

			cadastrarTutor(request, response);

			break;

		case "/cadastrar-motorista":

			cadastrarMotorista(request, response);

			break;

		case "/corrida-tutor":

			listarTutoresCorrida(request, response);

			break;

		case "/listar-corrida-tutor":

			listarCorridaAbertoTutor(request, response);

			break;

		case "/iniciar-corrida":

			listarTutoresCorrida(request, response);

			break;

		case "/iniciar-corrida-tutor":
			
			iniciarCorridaTutor(request, response);

			break;
			
		case "/atualizar-corrida":
			
			listarTutoresAtualizar(request, response);
			
			break;
			
		case "/atualizar-corrida-tutor":
			
			listarCorridasTutor(request, response);
			
			break;
			
		case "/atualizar-corrida-tutor-campos":
			
			break;

		}

	}

	private void abrirPaginaCadastroUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro-usuario.jsp");
		dispatcher.forward(request, response);
	}

	private void logarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = new Usuario();
		usuario.setLogin_usuario(request.getParameter("usuario"));
		usuario.setSenha_usuario(request.getParameter("senha"));

		long id = ((UsuarioDAO<Motorista>) tutorDao).procurarUsuarioLogin(usuario);
		if ((((TutorDAOSGDBImpl) tutorDao).procurarTutorId(id))) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("listar-corrida-aberto-tutor.jsp");
			dispatcher.forward(request, response);

		} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("procurar-corrida-motorista.jsp");
			dispatcher.forward(request, response);

		}

	}

	private void cadastrarTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = new Tutor();
		tutor.setNomeUsuario(request.getParameter("nomeTutorCad"));
		tutor.setSobreNomeUsuario(request.getParameter("sobreNomeTutorCad"));
		tutor.setCpfUsuario(request.getParameter("cpfTutorCad"));
		tutor.setTelefoneUsuario(request.getParameter("telefoneTutorCad"));
		tutor.setIdadeUsuario(Integer.parseInt(request.getParameter("idadeTutorCad")));
		tutor.setEmailUsuario(request.getParameter("emailTutorCad"));
		tutor.setLogin_usuario(request.getParameter("loginTutorCad"));
		tutor.setSenha_usuario(request.getParameter("senhaTutorCad"));
		tutorDao.inserir(tutor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("corrida-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void cadastrarMotorista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Motorista motorista = new Motorista();
		motorista.setNomeUsuario(request.getParameter("nomeMotoristaCad"));
		motorista.setSobreNomeUsuario(request.getParameter("sobreNomeMotoristaCad"));
		motorista.setCpfUsuario(request.getParameter("cpfMotoristaCad"));
		motorista.setCnh(Long.parseLong(request.getParameter("cnhMotoristaCad")));
		motorista.setTelefoneUsuario(request.getParameter("telefoneMotoristaCad"));
		motorista.setEmailUsuario(request.getParameter("emailMotoristaCad"));
		motorista.setIdadeUsuario(Integer.parseInt(request.getParameter("idadeMotoristaCad")));
		motorista.setLogin_usuario(request.getParameter("loginMotoristaCad"));
		motorista.setSenha_usuario(request.getParameter("senhaMotoristaCad"));
		motoristaDao.inserir(motorista);
		RequestDispatcher dispatcher = request.getRequestDispatcher("procurar-corrida-motorista.jsp");
		dispatcher.forward(request, response);

	}

	private void listarTutoresCorrida(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Tutor> tutores;

		tutores = tutorDao.listar();
		request.setAttribute("tutores", tutores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("corrida-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void listarCorridaAbertoTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = new Tutor();
		tutor.setIdUsuario(Integer.parseInt(request.getParameter("idTutor")));

		List<Corrida> corridasFeitas;
		corridasFeitas = ((CorridaDAOSGDBImpl) corridaDao).listarCorridaFeitaPorTutor(tutor);
		List<Corrida> corridasAbertas;
		corridasAbertas = ((CorridaDAOSGDBImpl) corridaDao).listarCorridaAbertaPorTutor(tutor);
		request.setAttribute("corridasAbertas", corridasAbertas);
		request.setAttribute("corridasFeitas", corridasFeitas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("corrida-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void iniciarCorridaTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao)
				.listarTutorId(Long.parseLong(request.getParameter("idTutorIniciarCorrida")));
		Corrida corrida = new Corrida();
		corrida.setTutor(tutor);
		Endereco enderecoInicial = ((EnderecoDAOSGDBImpl) enderecoDao)
				.listarEnderecoPorIdEndereco(Long.parseLong(request.getParameter("idEnderecoInicialCorrida")));
		Endereco enderecoFinal = ((EnderecoDAOSGDBImpl) enderecoDao)
				.listarEnderecoPorIdEndereco(Long.parseLong(request.getParameter("idEnderecoFinalCorrida")));
		corrida.setEnderecoInicial(enderecoInicial);
		corrida.setEnderecoFinal(enderecoFinal);
		corridaDao.inserir(corrida);
		RequestDispatcher dispatcher = request.getRequestDispatcher("corrida-tutor.jsp");
		dispatcher.forward(request, response);
	}

	private void listarTutoresAtualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Tutor> tutores;

		tutores = tutorDao.listar();
		request.setAttribute("tutores", tutores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-corrida-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void listarCorridasTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao)
				.listarTutorId(Long.parseLong(request.getParameter("idTutorIniciarCorrida")));
		List<Corrida> corridas = ((CorridaDAOSGDBImpl) corridaDao).listarCorridaAbertaPorTutor(tutor);
		request.setAttribute("corridas", corridas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-corrida-tutor.jsp");
		dispatcher.forward(request, response);

	}

}
