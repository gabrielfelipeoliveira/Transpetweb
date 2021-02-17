package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		case "/deslogar":

			HttpSession session = request.getSession();
			session.invalidate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("tela-inicial.jsp");
			dispatcher.forward(request, response);

			break;

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

		case "/atualizar-corrida-tutor-tabela":

			atualizarCorridaTutor(request, response);

			break;

		case "/atualizar-corrida-tutor-dados":

			atualizarCorridaTutorDados(request, response);

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

		case "/cadastrar-animal":

			listarTutorAnimal(request, response);

			break;

		case "/cadastrar-animal-tutor":

			cadastrarAnimalTutor(request, response);

			break;

		case "/cadastrar-animal-tutor-inserir":

			cadastrarAnimalTutorInserir(request, response);

			break;

		case "/atualizar-animal":

			listarTutorAnimalAtualizar(request, response);

			break;

		case "/atualizar-animal-tutor":

			atualizarAnimalTutor(request, response);

			break;
		case "/atualizar-animal-tabela":

			atualizarAnimalTutorTabela(request, response);

			break;

		case "/atualizar-animal-tutor-dados":

			atualizarAnimalTutorDados(request, response);

			break;

		case "/deletar-animal":

			listarTutorAnimalDeletar(request, response);

			break;

		case "/deletar-animal-tutor":

			deletarAnimalTutor(request, response);

			break;

		case "/deletar-animal-tutor-del":

			deletarAnimalTutorDel(request, response);

			break;

		case "/dados-tutor":

			listarTutoresDados(request, response);

			break;

		case "/dados-tutor-atualizar":

			atualizarDadosTutor(request, response);

			break;

		case "/dados-tutor-atualizar-atu":

			atualizarDadosTutorDados(request, response);

			break;

		case "/listar-animal":

			listarAnimal(request, response);

			break;

		case "/listar-animal-tutor":

			listarAnimalTutor(request, response);

			break;

		case "/endereco-tutor":

			enderecoTutor(request, response);

			break;

		case "/cadastrar-endereco-tutor":

			enderecoTutorCadastrar(request, response);

			break;

		case "/atualizar-endereco":

			atualizarEndereco(request, response);

			break;

		case "/atualizar-endereco-tutor":

			atualizarEnderecoTutor(request, response);

			break;

		case "/atualizar-endereco-tabela":

			atualizarEnderecoTabela(request, response);

			break;

		case "/atualizar-endereco-tutor-dados":

			atualizarEndereocTutorDados(request, response);

			break;

		case "/deletar-endereco":

			deletarEndereco(request, response);

			break;

		case "/deletar-endereco-tutor":

			deletarEnderecoTutor(request, response);

			break;
		case "/deletar-endereco-tutor-del":

			deletarEnderecoTutorDel(request, response);

			break;

		case "/listar-endereco":

			listarEndereco(request, response);

			break;

		case "/listar-endereco-tutor":

			listarEnderecoTutor(request, response);

			break;

		// CASES MOTORISTAS

		case "/listar-motoristas-historico":

			listarMotoristasHistorico(request, response);

			break;

		case "/listar-corridas-motoristas":

			listarCorridasMotorista(request, response);

			break;

		case "/procurar-corrida":

			procurarCorrida(request, response);

			break;

		case "/procurar-corrida-motorista":

			carregarMotoristaCorrida(request, response);

			break;

		case "/procurar-corrida-motorista-aceitar":

			procurarCorridaMotorista(request, response);

			break;

		case "/cadastrar-veiculo":

			cadastrarVeiculo(request, response);

			break;

		case "/cadastrar-veiculo-motorista":

			cadastrarVeiculoMotorista(request, response);

			break;

		case "/atualizar-veiculo":

			atualizarVeiculo(request, response);

			break;

		case "/atualizar-veiculo-motorista":

			atualizarVeiculoMotorista(request, response);

			break;

		case "/atualizar-veiculo-tabela":

			atualizarVeiculoMotoristaTabela(request, response);

			break;

		case "/atualizar-veiculo-dados":

			atualizarDadosVeiculos(request, response);

			break;

		case "/deletar-veiculo":

			deletarVeiculo(request, response);

			break;

		case "/deletar-veiculo-motorista":

			deletarVeiculoMotorista(request, response);

			break;

		case "/deletar-veiculo-motorista-del":

			deletarVeiculoMotoristaDel(request, response);

			break;

		case "/dados-motorista":

			dadosMotorista(request, response);

			break;

		case "/atualizar-dados-motorista":

			atualizarDadosMotorista(request, response);

			break;

		case "/atualizar-dados-motorista-atu":

			atualizarDadosMotoristaAtu(request, response);

			break;

		case "/listar-veiculo":

			listarVeiculo(request, response);

			break;

		case "/listar-veiculo-motorista":

			listarVeiculoMotoristas(request, response);

			break;

		}

	}

	private void carregarMotoristaCorrida(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Motorista motoristas = ((MotoristaDAOSGDBImpl) motoristaDao).listarMotoristaId(usuario.getIdUsuario());
		request.setAttribute("motorista", motoristas);
		List<Corrida> corridas = ((CorridaDAOSGDBImpl) corridaDao).listarCorridaAberta();
		request.setAttribute("corridas", corridas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("procurar-corrida-motorista.jsp");
		dispatcher.forward(request, response);

	}

	private void listarEnderecoTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao).listarTutorId(usuario.getIdUsuario());
		List<Endereco> enderecos = ((EnderecoDAOSGDBImpl) enderecoDao).listarEnderecoPorIdUsuario(tutor);
		request.setAttribute("enderecos", enderecos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar-endereco-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void listarEndereco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Tutor> tutores;

		tutores = tutorDao.listar();
		request.setAttribute("tutores", tutores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listar-endereco-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void deletarEnderecoTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao).listarTutorId(usuario.getIdUsuario());
		List<Endereco> enderecos = ((EnderecoDAOSGDBImpl) enderecoDao).listarEnderecoPorIdUsuario(tutor);
		request.setAttribute("enderecos", enderecos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("deletar-endereco-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void deletarEnderecoTutorDel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Endereco endereco = ((EnderecoDAOSGDBImpl) enderecoDao)
				.listarEnderecoPorIdEndereco(Long.parseLong(request.getParameter("idEnderecoTutorDel")));
		enderecoDao.deletar(endereco);

		listarCorridaAbertoTutor(request, response);
	}

	private void deletarEndereco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Tutor> tutores;

		tutores = tutorDao.listar();
		request.setAttribute("tutores", tutores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/deletar-endereco-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarEndereocTutorDados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Endereco endereco = ((EnderecoDAOSGDBImpl) enderecoDao)
				.listarEnderecoPorIdEndereco(Long.parseLong(request.getParameter("idEnderecoDados")));
		endereco.setCepEndereco(Long.parseLong(request.getParameter("cepEnderecoTutor")));
		endereco.setNumeroEndereco(Integer.parseInt(request.getParameter("numeroEnderecoTutor")));
		endereco.setRuaEndereco(request.getParameter("ruaEnderecoTutor"));
		enderecoDao.atualizar(endereco);
		listarCorridaAbertoTutor(request, response);
	}

	private void atualizarEnderecoTabela(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Endereco endereco = ((EnderecoDAOSGDBImpl) enderecoDao)
				.listarEnderecoPorIdEndereco(Long.parseLong(request.getParameter("idEnderecoTabela")));
		request.setAttribute("endereco", endereco);
		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-endereco-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarEnderecoTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao).listarTutorId(usuario.getIdUsuario());
		List<Endereco> enderecos = ((EnderecoDAOSGDBImpl) enderecoDao).listarEnderecoPorIdUsuario(tutor);
		request.setAttribute("enderecos", enderecos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-endereco-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarEndereco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Tutor> tutores;

		tutores = tutorDao.listar();
		request.setAttribute("tutores", tutores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-endereco-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void enderecoTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao).listarTutorId(usuario.getIdUsuario());
		request.setAttribute("tutor", tutor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-endereco-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void enderecoTutorCadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao)
				.listarTutorId(Long.parseLong(request.getParameter("idTutorEnderecoAtu")));
		Endereco endereco = new Endereco();
		endereco.setCepEndereco(Long.parseLong(request.getParameter("cepEnderecoTutorIns")));
		endereco.setNumeroEndereco(Integer.parseInt(request.getParameter("numeroEnderecoTutorIns")));
		endereco.setRuaEndereco(request.getParameter("ruaEnderecoTutorIns"));
		enderecoDao.inserir(endereco);
		tutor.setEnderecos(endereco);
		tutorDao.atualizar(tutor);
		listarCorridaAbertoTutor(request, response);
	}

	private void listarVeiculoMotoristas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Motorista motorista = ((MotoristaDAOSGDBImpl) motoristaDao)
				.listarMotoristaId(Long.parseLong(request.getParameter(("idMotoristaLis"))));
		List<Veiculo> veiculos = ((VeiculoDAOSGDBImpl) veiculoDao).listarVeiculoPorIdMotorista(motorista);
		request.setAttribute("veiculos", veiculos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar-veiculo-motorista.jsp");
		dispatcher.forward(request, response);

	}

	private void listarVeiculo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Motorista> motoristas = motoristaDao.listar();
		request.setAttribute("motoristas", motoristas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar-veiculo-motorista.jsp");
		dispatcher.forward(request, response);

	}

	private void listarAnimalTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao).listarTutorId(usuario.getIdUsuario());
		List<AnimalDomestico> animais = ((AnimalDomesticoDAOSGDBImpl) animalDao).listarAnimalPorIdTutor(tutor);
		request.setAttribute("animais", animais);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar-animal-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void listarAnimal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Tutor> tutores;

		tutores = tutorDao.listar();
		request.setAttribute("tutores", tutores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar-animal-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void abrirPaginaCadastroUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro-usuario.jsp");
		dispatcher.forward(request, response);
	}

	private void logarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuarioLogin = new Usuario();
		usuarioLogin.setLogin_usuario(request.getParameter("usuario"));
		usuarioLogin.setSenha_usuario(request.getParameter("senha"));

		Usuario usuario = ((UsuarioDAO<Tutor>) tutorDao).procurarUsuarioLogin(usuarioLogin);
		HttpSession session = request.getSession();
		if (usuario instanceof Tutor) {

			session.setAttribute("usuario", usuario);
			listarCorridaAbertoTutor(request, response);

		} else {
			session.setAttribute("usuario", usuario);
			carregarMotoristaCorrida(request, response);

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
		listarCorridaAbertoTutor(request, response);
	}

	private void cadastrarMotorista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Motorista motorista = new Motorista();
		motorista.setNomeUsuario(request.getParameter("nomeMotoristaCad"));
		motorista.setSobreNomeUsuario(request.getParameter("sobreNomeCad"));
		motorista.setCpfUsuario(request.getParameter("cpfMotoristaCad"));
		motorista.setCnh(Long.parseLong(request.getParameter("cnhMotoristaCad")));
		motorista.setTelefoneUsuario(request.getParameter("telefoneMotoristaCad"));
		motorista.setEmailUsuario(request.getParameter("emailMotoristaCad"));
		motorista.setIdadeUsuario(Integer.parseInt(request.getParameter("idadeMotoristaCad")));
		motorista.setLogin_usuario(request.getParameter("loginMotoristaCad"));
		motorista.setSenha_usuario(request.getParameter("senhaMotoristaCad"));
		motoristaDao.inserir(motorista);

		Usuario usuarioLogin = new Usuario();
		usuarioLogin.setLogin_usuario(request.getParameter("loginMotoristaCad"));
		usuarioLogin.setSenha_usuario(request.getParameter("senhaMotoristaCad"));
		Usuario usuario = ((UsuarioDAO<Motorista>) tutorDao)
				.procurarUsuarioLogin(((MotoristaDAOSGDBImpl) motoristaDao).procurarUsuarioLogin(usuarioLogin));
		request.getSession().setAttribute("usuario", usuario);
		carregarMotoristaCorrida(request, response);

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
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		tutor.setIdUsuario(usuario.getIdUsuario());

		List<Corrida> corridasFeitas;
		corridasFeitas = ((CorridaDAOSGDBImpl) corridaDao).listarCorridaFeitaPorTutor(tutor);
		List<Corrida> corridasAbertas;
		corridasAbertas = ((CorridaDAOSGDBImpl) corridaDao).listarCorridaAbertaPorTutor(tutor);
		request.setAttribute("corridasAbertas", corridasAbertas);
		request.setAttribute("corridasFeitas", corridasFeitas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar-corrida-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void iniciarCorridaTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao).listarTutorId(Long.parseLong(request.getParameter("idTutorIns")));
		Corrida corrida = new Corrida();
		corrida.setTutor(tutor);
		Endereco enderecoInicial = ((EnderecoDAOSGDBImpl) enderecoDao)
				.listarEnderecoPorIdEndereco(Long.parseLong(request.getParameter("idEnderecoInicial")));
		Endereco enderecoFinal = ((EnderecoDAOSGDBImpl) enderecoDao)
				.listarEnderecoPorIdEndereco(Long.parseLong(request.getParameter("idEnderecoFinal")));
		corrida.setEnderecoInicial(enderecoInicial);
		corrida.setEnderecoFinal(enderecoFinal);
		AnimalDomestico animal = (AnimalDomestico) ((AnimalDomesticoDAOSGDBImpl) animalDao)
				.listarAnimalPorIdAnimal(Long.parseLong(request.getParameter("idAnimal")));
		corrida.setAnimal(animal);
		corridaDao.inserir(corrida);
		listarCorridaAbertoTutor(request, response);
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

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao).listarTutorId(usuario.getIdUsuario());
		List<Corrida> corridas = ((CorridaDAOSGDBImpl) corridaDao).listarCorridaAbertaPorTutor(tutor);
		request.setAttribute("corridas", corridas);
		request.setAttribute("tutor", tutor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-corrida-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarCorridaTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao)
				.listarTutorId(Long.parseLong(request.getParameter("idTutorTabela")));
		request.setAttribute("tutor", tutor);
		Corrida corrida = ((CorridaDAOSGDBImpl) corridaDao)
				.listarCorridaPorIdCorrida(Long.parseLong(request.getParameter("idCorridaTabela")));
		request.setAttribute("corrida", corrida);

		Endereco enderecoInicial = corrida.getEnderecoInicial();
		Endereco enderecoFinal = corrida.getEnderecoFinal();
		request.setAttribute("enderecoFinal", enderecoFinal);
		request.setAttribute("enderecoInicial", enderecoInicial);

		AnimalDomestico animal = corrida.getAnimal();
		request.setAttribute("animalSelecionado", animal);
		List<Endereco> enderecos = ((EnderecoDAOSGDBImpl) enderecoDao).listarEnderecoPorIdUsuario(tutor);
		List<AnimalDomestico> animais = ((AnimalDomesticoDAOSGDBImpl) animalDao).listarAnimalPorIdTutor(tutor);
		request.setAttribute("enderecos", enderecos);
		request.setAttribute("animais", animais);

		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-corrida-tutor.jsp");
		dispatcher.forward(request, response);
	}

	private void atualizarCorridaTutorDados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Corrida corrida = ((CorridaDAOSGDBImpl) corridaDao)
				.listarCorridaPorIdCorrida(Long.parseLong(request.getParameter("idCorridaAtu")));
		request.setAttribute("corrida", corrida);
		Endereco enderecoInicial = ((EnderecoDAOSGDBImpl) enderecoDao)
				.listarEnderecoPorIdEndereco(Long.parseLong(request.getParameter("idEnderecoInicialAtu")));
		Endereco enderecoFinal = ((EnderecoDAOSGDBImpl) enderecoDao)
				.listarEnderecoPorIdEndereco(Long.parseLong(request.getParameter("idEnderecoFinalAtu")));
		corrida.setEnderecoInicial(enderecoInicial);
		corrida.setEnderecoFinal(enderecoFinal);
		AnimalDomestico animal = (AnimalDomestico) ((AnimalDomesticoDAOSGDBImpl) animalDao)
				.listarAnimalPorIdAnimal(Long.parseLong(request.getParameter("idAnimalAtu")));
		corrida.setAnimal(animal);
		corridaDao.atualizar(corrida);
		listarCorridaAbertoTutor(request, response);
	}

	private void carregarDadosTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao).listarTutorId(usuario.getIdUsuario());
		List<Endereco> enderecos = (List<Endereco>) ((EnderecoDAOSGDBImpl) enderecoDao)
				.listarEnderecoPorIdUsuario(tutor);
		List<AnimalDomestico> animais = ((AnimalDomesticoDAOSGDBImpl) animalDao).listarAnimalPorIdTutor(tutor);
		request.setAttribute("enderecos", enderecos);
		request.setAttribute("animais", animais);
		request.setAttribute("tutor", tutor);
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

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao).listarTutorId(usuario.getIdUsuario());
		List<Corrida> corridas = ((CorridaDAOSGDBImpl) corridaDao).listarCorridaAbertaPorTutor(tutor);
		request.setAttribute("corridas", corridas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("deletar-corrida-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void deletarCorridaTutorDel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Corrida corridaDel = ((CorridaDAOSGDBImpl) corridaDao)
				.listarCorridaPorIdCorrida(Long.parseLong(request.getParameter("idCorridaTabela")));

		corridaDao.deletar(corridaDel);
		listarCorridaAbertoTutor(request, response);
	}

	private void listarTutorAnimal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao).listarTutorId(usuario.getIdUsuario());
		request.setAttribute("tutor", tutor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-animal-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void cadastrarAnimalTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao)
				.listarTutorId(Long.parseLong(request.getParameter("idTutorAnimalCad")));
		request.setAttribute("tutor", tutor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-animal-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void cadastrarAnimalTutorInserir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao).listarTutorId(Long.parseLong(request.getParameter("idTutorAnimalCad")));

		AnimalDomestico animal = new AnimalDomestico();
		animal.setNomeAnimal(request.getParameter("nomeAnimalTutorIns"));
		animal.setPeso(Double.parseDouble(request.getParameter("pesoAnimalTutorIns")));
		animal.setRaca(request.getParameter("racaAnimalTutorIns"));
		animal.setTamanho(Double.parseDouble(request.getParameter("tamanhoAnimalTutorIns")));
		animal.setObservacao(request.getParameter("observacaoAnimalTutorIns"));
		TipoAnimal tipoAnimal = TipoAnimal.values()[Integer.parseInt(request.getParameter("selectTipoAnimal"))];
		animal.setTipoAnimal(tipoAnimal);
		animal.setTutor(tutor);
		animalDao.inserir(animal);
		listarCorridaAbertoTutor(request, response);
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

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao).listarTutorId(usuario.getIdUsuario());

		List<AnimalDomestico> animais = ((AnimalDomesticoDAOSGDBImpl) animalDao).listarAnimalPorIdTutor(tutor);
		request.setAttribute("tutor", tutor);
		request.setAttribute("animais", animais);

		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-animal-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarAnimalTutorTabela(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AnimalDomestico animal = ((AnimalDomesticoDAOSGDBImpl) animalDao)
				.listarAnimalPorIdAnimal(Long.parseLong(request.getParameter("idAnimalTabelaAtu")));
		request.setAttribute("animal", animal);
		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-animal-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarAnimalTutorDados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AnimalDomestico animal = ((AnimalDomesticoDAOSGDBImpl) animalDao)
				.listarAnimalPorIdAnimal(Long.parseLong(request.getParameter("idAnimalDados")));
		animal.setNomeAnimal(request.getParameter("nomeAnimalTutorAtu"));
		animal.setRaca(request.getParameter("racaAnimalTutorAtu"));
		animal.setPeso(Double.parseDouble(request.getParameter("pesoAnimalTutorAtu")));
		animal.setTamanho(Double.parseDouble(request.getParameter("tamanhoAnimalTutorAtu")));
		animalDao.atualizar(animal);
		listarCorridaAbertoTutor(request, response);
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

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao).listarTutorId(usuario.getIdUsuario());

		List<AnimalDomestico> animais = ((AnimalDomesticoDAOSGDBImpl) animalDao).listarAnimalPorIdTutor(tutor);
		request.setAttribute("tutor", tutor);
		request.setAttribute("animais", animais);

		RequestDispatcher dispatcher = request.getRequestDispatcher("deletar-animal-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void deletarAnimalTutorDel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AnimalDomestico animal = ((AnimalDomesticoDAOSGDBImpl) animalDao)
				.listarAnimalPorIdAnimal(Long.parseLong(request.getParameter("idAnimalTutorDel")));
		animalDao.deletar(animal);
		listarCorridaAbertoTutor(request, response);
	}

	private void listarTutoresDados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Tutor> tutores;

		tutores = tutorDao.listar();
		request.setAttribute("tutores", tutores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-dados-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarDadosTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao).listarTutorId(usuario.getIdUsuario());

		request.setAttribute("tutor", tutor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-dados-tutor.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarDadosTutorDados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Tutor tutor = ((TutorDAOSGDBImpl) tutorDao).listarTutorId(Long.parseLong(request.getParameter("idTutorAtu")));
		tutor.setNomeUsuario(request.getParameter("nomeTutorAtu"));
		tutor.setSobreNomeUsuario(request.getParameter("sobrenomeTutorAtu"));
		tutor.setCpfUsuario((request.getParameter("cpfTutorAtu")));
		tutor.setTelefoneUsuario(request.getParameter("telefoneTutorAtu"));
		tutor.setIdadeUsuario(Integer.parseInt(request.getParameter("idadeTutorAtu")));
		tutor.setEmailUsuario(request.getParameter("emailTutorAtu"));
		tutor.setLogin_usuario(request.getParameter("usuarioTutorAtu"));
		tutor.setSenha_usuario(request.getParameter("senhaTutorAtu"));
		tutorDao.atualizar(tutor);
		listarCorridaAbertoTutor(request, response);
	}

	private void listarMotoristasHistorico(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Motorista> motoristas = motoristaDao.listar();
		request.setAttribute("motoristas", motoristas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar-corridas-motorista.jsp");
		dispatcher.forward(request, response);

	}

	private void listarCorridasMotorista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Motorista motorista = ((MotoristaDAOSGDBImpl) motoristaDao)
				.listarMotoristaId(Long.parseLong(request.getParameter(("idMotorista"))));

		List<Corrida> corridas = ((CorridaDAOSGDBImpl) corridaDao).listarCorridaPorIdMotorista(motorista);
		request.setAttribute("corridas", corridas);

		RequestDispatcher dispatcher = request.getRequestDispatcher("listar-corridas-motorista.jsp");
		dispatcher.forward(request, response);

	}

	private void procurarCorrida(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Motorista> motoristas = motoristaDao.listar();
		request.setAttribute("motoristas", motoristas);

		RequestDispatcher dispatcher = request.getRequestDispatcher("procurar-corrida-motorista.jsp");
		dispatcher.forward(request, response);

	}

	private void procurarCorridaMotorista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Motorista motoristas = ((MotoristaDAOSGDBImpl) motoristaDao)
				.listarMotoristaId(Long.parseLong(request.getParameter("idMotoristaTabela")));

		Corrida corridaAtu = ((CorridaDAOSGDBImpl) corridaDao)
				.listarCorridaPorIdCorrida(Long.parseLong(request.getParameter("idCorrida")));
		corridaAtu.setMotorista(motoristas);
		corridaDao.atualizar(corridaAtu);
		listarMotoristasHistorico(request, response);
	}

	private void cadastrarVeiculo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Motorista> motoristas = motoristaDao.listar();
		request.setAttribute("motoristas", motoristas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-carro-motorista.jsp");
		dispatcher.forward(request, response);

	}

	private void cadastrarVeiculoMotorista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Motorista motorista = ((MotoristaDAOSGDBImpl) motoristaDao)
				.listarMotoristaId(Long.parseLong(request.getParameter("idMotorista")));
		Veiculo veiculo = new Veiculo();
		veiculo.setMarcaVeiculo(request.getParameter("marcaVeiculoMotoristaIns"));
		veiculo.setModeloVeiculo(request.getParameter("modeloVeiculoMotoristaIns"));
		veiculo.setPlacaVeiculo(request.getParameter("placaVeiculoMotoristaIns"));
		veiculo.setAnoVeiculo(Integer.parseInt(request.getParameter("anoVeiculoMotoristaIns")));
		veiculo.setMotoristaVeiculo(motorista);
		veiculoDao.inserir(veiculo);
		listarMotoristasCorrida(request, response);
	}

	private void atualizarVeiculo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Motorista> motoristas = motoristaDao.listar();
		request.setAttribute("motoristas", motoristas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-veiculo-motorista.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarVeiculoMotorista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Motorista motorista = ((MotoristaDAOSGDBImpl) motoristaDao)
				.listarMotoristaId(Long.parseLong(request.getParameter("idMotorista")));
		List<Veiculo> veiculos = ((VeiculoDAOSGDBImpl) veiculoDao).listarVeiculoPorIdMotorista(motorista);
		request.setAttribute("veiculos", veiculos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-veiculo-motorista.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarVeiculoMotoristaTabela(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Veiculo veiculo = ((VeiculoDAOSGDBImpl) veiculoDao)
				.listarVeiculoPorIdVeiculo(Long.parseLong(request.getParameter("idVeiculoTabela")));
		request.setAttribute("veiculo", veiculo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-veiculo-motorista.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarDadosVeiculos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Veiculo veiculo = ((VeiculoDAOSGDBImpl) veiculoDao)
				.listarVeiculoPorIdVeiculo(Long.parseLong(request.getParameter("IdVeiculoAtu")));
		veiculo.setMarcaVeiculo(request.getParameter("marcaVeiculoMotoristaAtu"));
		veiculo.setModeloVeiculo(request.getParameter("modeloVeiculoMotoristaAtu"));
		veiculo.setPlacaVeiculo(request.getParameter("placaVeiculoMotoristaAtu"));
		veiculo.setAnoVeiculo(Integer.parseInt(request.getParameter("anoVeiculoMotoristaAtu")));
		veiculoDao.atualizar(veiculo);
		listarMotoristasCorrida(request, response);
	}

	private void deletarVeiculo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Motorista> motoristas = motoristaDao.listar();
		request.setAttribute("motoristas", motoristas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("deletar-veiculo-motorista.jsp");
		dispatcher.forward(request, response);

	}

	private void deletarVeiculoMotorista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Motorista motorista = ((MotoristaDAOSGDBImpl) motoristaDao)
				.listarMotoristaId(Long.parseLong(request.getParameter("idMotorista")));
		List<Veiculo> veiculos = ((VeiculoDAOSGDBImpl) veiculoDao).listarVeiculoPorIdMotorista(motorista);
		request.setAttribute("veiculos", veiculos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("deletar-veiculo-motorista.jsp");
		dispatcher.forward(request, response);

	}

	private void deletarVeiculoMotoristaDel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Veiculo veiculo = ((VeiculoDAOSGDBImpl) veiculoDao)
				.listarVeiculoPorIdVeiculo(Long.parseLong(request.getParameter("idVeiculoTabela")));
		veiculoDao.deletar(veiculo);
		listarMotoristasCorrida(request, response);

	}

	private void dadosMotorista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Motorista> motoristas = motoristaDao.listar();
		request.setAttribute("motoristas", motoristas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-dados-motorista.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarDadosMotorista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Motorista motorista = ((MotoristaDAOSGDBImpl) motoristaDao)
				.listarMotoristaId(Long.parseLong(request.getParameter("idMotoristaDados")));
		request.setAttribute("motorista", motorista);
		RequestDispatcher dispatcher = request.getRequestDispatcher("atualizar-dados-motorista.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarDadosMotoristaAtu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Motorista motorista = ((MotoristaDAOSGDBImpl) motoristaDao)
				.listarMotoristaId(Long.parseLong(request.getParameter("idMotoristaAtu")));
		motorista.setNomeUsuario(request.getParameter("nomeMotoristaAtu"));
		motorista.setSobreNomeUsuario(request.getParameter("sobrenomeMotoristaAtu"));
		motorista.setCnh(Long.parseLong(request.getParameter("cnhMotoristaAtu")));
		motorista.setCpfUsuario(request.getParameter("cpfMotoristaAtu"));
		motorista.setEmailUsuario(request.getParameter("emailMotoristaAtu"));
		motorista.setIdadeUsuario(Integer.parseInt(request.getParameter("idadeMotoristaAtu")));
		motorista.setLogin_usuario(request.getParameter("loginMotoristaAtu"));
		motorista.setTelefoneUsuario(request.getParameter("telefoneMotoristaAtu"));
		motoristaDao.atualizar(motorista);
		listarMotoristasHistorico(request, response);
	}
}
