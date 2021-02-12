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
import modelo.enumeracao.TipoAnimal;

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
		veiculoDao = new VeiculoDAOSGDBImpl(Veiculo.class) ;

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

			listarTutoresIniciarCorrida(request, response);

			break;

		case "/iniciar-corrida-tutor":

			carregarDadosTutor(request, response);

			break;

		case "/iniciar-corrida-tutor-ins":

			iniciarCorridaTutor(request, response);

			break;

		case "/atualizar-corrida":

			listarTutoresAtualizar(request, response);

			break;

		case "/atualizar-corrida-tutor":

			listarCorridasTutor(request, response);

			break;

		case "/atualizar-corrida-tutor-campos":

			atualizarCorridaTutor(request, response);

			break;

		case "/deletar-corrida":

			deletarCorrida(request, response);

			break;

		case "/deletar-corrida-tutor":

			deletarCorridaTutor(request, response);

			break;

		case "/deletar-corrida-tutor-del":

			deletarCorridaTutorDel(request, response);

			break;

		case "cadastrar-animal":

			listarTutorAnimal(request, response);

			break;

		case "cadastrar-animal-tutor":

			cadastrarAnimalTutor(request, response);

			break;

		case "cadastrar-animal-tutor-inserir":

			cadastrarAnimalTutorInserir(request, response);

			break;

		case "atualizar-animal":

			listarTutorAnimalAtualizar(request, response);

			break;

		case "atualizar-animal-tutor":

			atualizarAnimalTutor(request, response);

			break;

		case "atualizar-animal-tutor-atu":

			atualizarAnimalTutorDados(request, response);

			break;

		case "deletar-animal":

			listarTutorAnimalDeletar(request, response);

			break;

		case "deletar-animal-tutor":

			deletarAnimalTutor(request, response);

			break;

		case "deletar-animal-tutor-del":

			deletarAnimalTutorDel(request, response);

			break;

		case "dados-tutor":

			listarTutoresDados(request, response);

			break;

		case "dados-tutor-atualizar":

			atualizarDadosTutor(request, response);

			break;
			
		case "dados-tutor-atualizar-atu":
			
			atualizarDadosTutorDados(request,response);
			
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

			listarTutoresCorrida(request, response);

		} else {

			listarMotoristasCorrida(request, response);

		}

	}

	private void cadastrarTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = new Tutor();
		tutor.setNomeUsuario(request.getParameter("nomeTutorCad"));
		tutor.setSobreNomeUsuario(request.getParameter("sobrenomeTutorCad"));
		tutor.setCpfUsuario(request.getParameter("cpfTutorCad"));
		tutor.setTelefoneUsuario(request.getParameter("telefoneTutorCad"));
		tutor.setIdadeUsuario(Integer.parseInt(request.getParameter("idadeTutorCad")));
		tutor.setEmailUsuario(request.getParameter("emailTutorCad"));
		tutor.setLogin_usuario(request.getParameter("loginTutorCad"));
		tutor.setSenha_usuario(request.getParameter("senhaTutorCad"));
		tutorDao.inserir(tutor);
		listarTutoresCorrida(request, response);

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
		listarMotoristasCorrida(request, response);

	}

	private void listarTutoresCorrida(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Tutor> tutores;

		tutores = tutorDao.listar();
		request.setAttribute("tutores", tutores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar-corrida-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void listarTutoresIniciarCorrida(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Tutor> tutores;

		tutores = tutorDao.listar();
		request.setAttribute("tutores", tutores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("iniciar-corrida-tutor.jsp");
		dispatcher.forward(request, response);
	}

	private void listarMotoristasCorrida(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Motorista> motoristas = motoristaDao.listar();
		request.setAttribute("motoristas", motoristas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("procurar-corrida-motorista.jsp");
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
		AnimalDomestico animal = (AnimalDomestico) ((AnimalDomesticoDAOSGDBImpl) animalDao)
				.listarAnimalPorIdTutor(tutor);
		corrida.setAnimal(animal);
		corridaDao.inserir(corrida);
		listarTutoresCorrida(request, response);
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

	private void atualizarCorridaTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao)
				.listarTutorId(Long.parseLong(request.getParameter("idTutorIniciarCorrida")));
		request.setAttribute("tutor", tutor);
		Endereco enderecoInicial = ((EnderecoDAOSGDBImpl) enderecoDao)
				.listarEnderecoPorIdEndereco(Long.parseLong(request.getParameter("idEnderecoInicialCorrida")));
		Endereco enderecoFinal = ((EnderecoDAOSGDBImpl) enderecoDao)
				.listarEnderecoPorIdEndereco(Long.parseLong(request.getParameter("idEnderecoFinalCorrida")));
		request.setAttribute("enderecoFinal", enderecoFinal);
		request.setAttribute("enderecoInicial", enderecoInicial);
		AnimalDomestico animalId = new AnimalDomestico();
		animalId.setIdAnimal(Long.parseLong(request.getParameter("idAnimalCorrida")));
		AnimalDomestico animal = (AnimalDomestico) ((AnimalDomesticoDAOSGDBImpl) animalDao)
				.listarAnimalPorIdAnimal(animalId);
		request.setAttribute("animal", animal);
		List<Endereco> enderecos = ((EnderecoDAOSGDBImpl) enderecoDao).listarEnderecoPorIdUsuario(tutor);
		List<AnimalDomestico> animais = ((AnimalDomesticoDAOSGDBImpl) animalDao).listarAnimalPorIdTutor(tutor);
		request.setAttribute("enderecos", enderecos);
		request.setAttribute("animais", animais);

		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-corrida-tutor.jsp");
		dispatcher.forward(request, response);
	}

	private void carregarDadosTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao)
				.listarTutorId(Long.parseLong(request.getParameter("idTutorIniciarCorrida")));
		List<Endereco> enderecos = (List<Endereco>) ((EnderecoDAOSGDBImpl) enderecoDao)
				.listarEnderecoPorIdUsuario(tutor);
		List<AnimalDomestico> animais = ((AnimalDomesticoDAOSGDBImpl) animalDao).listarAnimalPorIdTutor(tutor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("iniciar-corrida-tutor.jsp");
		dispatcher.forward(request, response);
	}

	private void deletarCorrida(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Tutor> tutores;

		tutores = tutorDao.listar();
		request.setAttribute("tutores", tutores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("deletar-corrida-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void deletarCorridaTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao)
				.listarTutorId(Long.parseLong(request.getParameter("idTutorIniciarCorrida")));
		List<Corrida> corridas = ((CorridaDAOSGDBImpl) corridaDao).listarCorridaAbertaPorTutor(tutor);
		request.setAttribute("corridas", corridas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("deletar-corrida-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void deletarCorridaTutorDel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Corrida corrida = new Corrida();
		corrida.setIdCorrida(Long.parseLong(request.getParameter("idCorridaTutor")));
		Corrida corridaDel = ((CorridaDAOSGDBImpl) corridaDao).listarCorridaPorIdCorrida(corrida);

		corridaDao.deletar(corridaDel);
		listarTutoresCorrida(request, response);

	}

	private void listarTutorAnimal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Tutor> tutores;

		tutores = tutorDao.listar();
		request.setAttribute("tutores", tutores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-animal-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void cadastrarAnimalTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao)
				.listarTutorId(Long.parseLong(request.getParameter("idTutorIniciarCorrida")));
		request.setAttribute("tutor", tutor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-animal-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void cadastrarAnimalTutorInserir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao)
				.listarTutorId(Long.parseLong(request.getParameter("idTutorIniciarCorrida")));

		AnimalDomestico animal = new AnimalDomestico();
		animal.setNomeAnimal(request.getParameter("nomeAnimalTutorCad"));
		animal.setRaca(request.getParameter("racaAnimalTutorCad"));
		animal.setPeso(Double.parseDouble(request.getParameter("pesoAnimalTutorCad")));
		animal.setTamanho(Double.parseDouble(request.getParameter("tamanhoAnimalTutorCad")));
		TipoAnimal tipoAnimal = TipoAnimal.values()[Integer.parseInt(request.getParameter("tipoAnimalTutorCad"))];
		animal.setTipoAnimal(tipoAnimal);
		animal.setTutor(tutor);
		animalDao.inserir(animal);
		listarTutoresCorrida(request, response);

	}

	private void listarTutorAnimalAtualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Tutor> tutores;

		tutores = tutorDao.listar();
		request.setAttribute("tutores", tutores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-animal-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarAnimalTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao)
				.listarTutorId(Long.parseLong(request.getParameter("idTutorIniciarCorrida")));

		List<AnimalDomestico> animais = ((AnimalDomesticoDAOSGDBImpl) animalDao).listarAnimalPorIdTutor(tutor);
		request.setAttribute("tutor", tutor);
		request.setAttribute("animais", animais);

		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-animal-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarAnimalTutorDados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao)
				.listarTutorId(Long.parseLong(request.getParameter("idTutorIniciarCorrida")));

		AnimalDomestico animal = new AnimalDomestico();
		animal.setNomeAnimal(request.getParameter("nomeAnimalTutorCad"));
		animal.setRaca(request.getParameter("racaAnimalTutorCad"));
		animal.setPeso(Double.parseDouble(request.getParameter("pesoAnimalTutorCad")));
		animal.setTamanho(Double.parseDouble(request.getParameter("tamanhoAnimalTutorCad")));
		animalDao.atualizar(animal);
		listarTutoresCorrida(request, response);

	}

	private void listarTutorAnimalDeletar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Tutor> tutores;

		tutores = tutorDao.listar();
		request.setAttribute("tutores", tutores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("deletar-animal-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void deletarAnimalTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao)
				.listarTutorId(Long.parseLong(request.getParameter("idTutorIniciarCorrida")));

		List<AnimalDomestico> animais = ((AnimalDomesticoDAOSGDBImpl) animalDao).listarAnimalPorIdTutor(tutor);
		request.setAttribute("tutor", tutor);
		request.setAttribute("animais", animais);

		RequestDispatcher dispatcher = request.getRequestDispatcher("deletar-animal-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void deletarAnimalTutorDel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AnimalDomestico animalId = new AnimalDomestico();
		animalId.setIdAnimal(Long.parseLong(request.getParameter("idAnimalTutorDel")));
		AnimalDomestico animal = ((AnimalDomesticoDAOSGDBImpl) animalDao).listarAnimalPorIdAnimal(animalId);
		listarTutoresCorrida(request, response);

	}

	private void listarTutoresDados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Tutor> tutores;

		tutores = tutorDao.listar();
		request.setAttribute("tutores", tutores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-dados-tutor.jsp");
		dispatcher.forward(request, response);

	}
	
	

	private void atualizarDadosTutor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao)
				.listarTutorId(Long.parseLong(request.getParameter("idTutorIniciarCorrida")));
		
		request.setAttribute("tutor", tutor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-dados-tutor.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void atualizarDadosTutorDados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao)
				.listarTutorId(Long.parseLong(request.getParameter("idTutorIniciarCorrida")));
		tutor.setNomeUsuario(request.getParameter("nomeTutorAtu"));
		tutor.setSobreNomeUsuario(request.getParameter("sobrenomeTutorAtu"));
		tutor.setCpfUsuario((request.getParameter("cpfutorAtu")));
		tutor.setTelefoneUsuario(request.getParameter("telefoneTutorAtu"));
		tutor.setIdadeUsuario(Integer.parseInt(request.getParameter("idadeTutorAtu")));
		tutor.setEmailUsuario(request.getParameter("emailTutorAtu"));
		tutor.setLogin_usuario(request.getParameter("usuarioTutorAtu"));
		tutor.setSenha_usuario(request.getParameter("senhaTutorAtu"));
		tutorDao.atualizar(tutor);
		listarTutoresCorrida(request, response);
		
		
	}

}
