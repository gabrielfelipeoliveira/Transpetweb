package modelo.entidade.usuario.tutor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import modelo.entidade.animal.AnimalDomestico;
import modelo.entidade.corrida.Corrida;
import modelo.entidade.endereco.Endereco;
import modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "tutor")
public class Tutor extends Usuario {
	

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "tutor_endereco", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_endereco"))
	private List<Endereco> enderecos = new ArrayList<Endereco>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tutor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AnimalDomestico> animais = new ArrayList<AnimalDomestico>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tutor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Corrida> corridas = new ArrayList<Corrida>();

	public Tutor(String nomeUsuario, String sobreNomeUsuario, String cpfUsuario, int idadeUsuario, String emailUsuario,
			String telefoneUsuario, String login_usuario, String senha_usuario) {
		super(nomeUsuario, sobreNomeUsuario, cpfUsuario, idadeUsuario, emailUsuario, telefoneUsuario, login_usuario,
				senha_usuario);
	}
	
	public Tutor() {}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco enderecos) {
		this.enderecos.add(enderecos);
	}

	public List<AnimalDomestico> getAnimais() {
		return animais;
	}

	public void setAnimais(AnimalDomestico animais) {
		this.animais.add(animais);
	}

	public List<Corrida> getCorridas() {
		return corridas;
	}

	public void setCorridas(Corrida corridas) {
		this.corridas.add(corridas);
	}
	
	public void removerEndereco(Endereco endereco) {
		
		this.enderecos.remove(endereco);
		
	}
	

	
}