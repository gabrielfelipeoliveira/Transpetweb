package controle;

import java.util.ArrayList;
import java.util.List;

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
import modelo.enumeracao.TipoAnimal;

public class Principal {
	public static void main(String[] args) {

		GenericoDAO<AnimalDomestico> animalDao = new AnimalDomesticoDAOSGDBImpl<AnimalDomestico>(AnimalDomestico.class);
		GenericoDAO<Corrida> corridaDao = new CorridaDAOSGDBImpl(Corrida.class);
		GenericoDAO<Endereco> enderecoDao = new EnderecoDAOSGDBImpl(Endereco.class);
		GenericoDAO<Tutor> tutorDao = new TutorDAOSGDBImpl(Tutor.class);
		GenericoDAO<Motorista> motoristaDao = new MotoristaDAOSGDBImpl(Motorista.class);
		GenericoDAO<Veiculo> veiculoDao = new VeiculoDAOSGDBImpl(Veiculo.class);

		//Corrida corrida = new Corrida();

		Endereco endereco = new Endereco();
		endereco.setNumeroEndereco(32);
		endereco.setRuaEndereco("G. Fahrenheit");
		endereco.setCepEndereco(89057510);
		enderecoDao.inserir(endereco);

	//	corrida.setEndere�oInicial(endereco);

		Motorista motorista;
		motorista = new Motorista();
		motorista.setLogin_usuario("motoristaLogin3");
		motorista.setSenha_usuario("Senha motorista3");
		motorista.setNomeUsuario("motorista nome3");
		motorista.setSobreNomeUsuario("motorista Sobre nome3");
		motorista.setTelefoneUsuario("123412");
		motorista.setCpfUsuario("241241");
		motorista.setCnh(4212134);
		motoristaDao.inserir(motorista);

		Veiculo veiculo = new Veiculo();
		veiculo.setAnoVeiculo(2010);
		veiculo.setMarcaVeiculo("Toyota");
		veiculo.setModeloVeiculo("corolla");
		veiculo.setPlacaVeiculo("mdl5045");
		veiculo.setMotoristaVeiculo(motorista);
		veiculoDao.inserir(veiculo);

		endereco = new Endereco();
		endereco.setNumeroEndereco(20);
		endereco.setRuaEndereco("Xv novembro");
		endereco.setCepEndereco(84050100);
		enderecoDao.inserir(endereco);

		//corrida.setEnderecoFinal(endereco);

		endereco = new Endereco();
		endereco.setNumeroEndereco(53);
		endereco.setRuaEndereco("Alameda");
		endereco.setCepEndereco(89150400);
		enderecoDao.inserir(endereco);

		Tutor tutor;
		tutor = new Tutor();
		tutor.setLogin_usuario("TutorLogin2");
		tutor.setSenha_usuario("Senha tutor2");
		tutor.setNomeUsuario("Tutor nome2");
		tutor.setSobreNomeUsuario("Tutor Sobre nome2");
		tutor.setTelefoneUsuario("111112");
		tutor.setCpfUsuario("12381213");
		tutor.setEnderecos(endereco);
		tutorDao.inserir(tutor);

		//corrida.setTutor(tutor);
		//corridaDao.inserir(corrida);

		TipoAnimal tipo = null;
		AnimalDomestico animal = new AnimalDomestico();
		animal.setNomeAnimal("TOB");
		animal.setObservacao("PATADA");
		animal.setPeso(15.2);
		animal.setRaca("KOKER");
		animal.setTamanho(15);
		animal.setTipoAnimal(tipo.CACHORRO);
		animal.setTutor(tutor);
		animalDao.inserir(animal);
		
		tutor = tutorDao.listar().get(0);

		List<Endereco> enderecos = new ArrayList<Endereco>();
		enderecos= ((EnderecoDAOSGDBImpl) enderecoDao).listarEnderecoPorIdUsuario(tutor);
		
		for (int i = 0; i < enderecos.size(); i++) {

			System.out.println(enderecos.get(i).getCepEndereco());
			System.out.println(enderecos.get(i).getNumeroEndereco());
			System.out.println(enderecos.get(i).getRuaEndereco());
			
			System.out.println();

		}

	}
	

}
