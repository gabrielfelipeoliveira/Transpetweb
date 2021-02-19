package modelo.entidade.usuario.motorista;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import modelo.entidade.corrida.Corrida;
import modelo.entidade.usuario.Usuario;
import modelo.entidade.veiculo.Veiculo;

@Entity
@Table(name = "motorista")
public class Motorista extends Usuario {

	
	@Column(name = "cnh_motorista", length = 11, nullable = false, unique = true)
	private long cnh;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "motoristaVeiculo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "motorista", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Corrida> corridas = new ArrayList<Corrida>();

	public Motorista(String nomeUsuario, String sobreNomeUsuario, String cpfUsuario, int idadeUsuario,
			String emailUsuario, String telefoneUsuario, String login_usuario, String senha_usuario, long cnh,
			List<Veiculo> veiculos, List<Corrida> corridas) {
		super(nomeUsuario, sobreNomeUsuario, cpfUsuario, idadeUsuario, emailUsuario, telefoneUsuario, login_usuario,
				senha_usuario);
		this.cnh = cnh;
		this.veiculos = veiculos;
		this.corridas = corridas;
	}

	public Motorista(String nomeUsuario, String sobreNomeUsuario, String cpfUsuario, int idadeUsuario,
			String emailUsuario, String telefoneUsuario, String login_usuario, String senha_usuario) {
		super(nomeUsuario, sobreNomeUsuario, cpfUsuario, idadeUsuario, emailUsuario, telefoneUsuario, login_usuario,
				senha_usuario);
	}
	
	public Motorista() {}

	public long getCnh() {
		return cnh;
	}

	public void setCnh(long cnh) {
		this.cnh = cnh;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(Veiculo veiculos) {
		this.veiculos.add(veiculos);
	}

	public List<Corrida> getCorridas() {
		return corridas;
	}

	public void setCorridas(List<Corrida> corridas) {
		this.corridas = corridas;
	}
	

}