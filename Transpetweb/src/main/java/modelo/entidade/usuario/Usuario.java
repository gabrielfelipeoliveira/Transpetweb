package modelo.entidade.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table (name = "usuario")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private long idUsuario;

	@Column(name = "nome_usuario", length = 25, nullable = false, unique = false)
	private String nomeUsuario;
	
	@Column(name = "sobrenome_usuario", length = 25, nullable = false, unique = false)
	private String sobreNomeUsuario;
	
	@Column(name = "cpf_usuario", length = 11, nullable = false, unique = true)
	private String cpfUsuario;
	
	@Column(name = "telefone_usuario", length = 15, nullable = false, unique = true)
	private String telefoneUsuario;
	
	@Column(name = "login_usuario", length = 25, nullable = false, unique = true)
	private String login_usuario;
	
	@Column(name = "senha_usuario", length = 25, nullable = false, unique = false)
	private String senha_usuario;

	public Usuario(long idUsuario, String nomeUsuario, String sobreNomeUsuario, String cpfUsuario, String telefoneUsuario,
			String login_usuario, String senha_usuario) {
		
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.sobreNomeUsuario = sobreNomeUsuario;
		this.cpfUsuario = cpfUsuario;
		this.telefoneUsuario = telefoneUsuario;
		this.login_usuario = login_usuario;
		this.senha_usuario = senha_usuario;
	}

	public Usuario(String nomeUsuario, String sobreNomeUsuario, String cpfUsuario, String telefoneUsuario,
			String login_usuario, String senha_usuario) {
		
		this.nomeUsuario = nomeUsuario;
		this.sobreNomeUsuario = sobreNomeUsuario;
		this.cpfUsuario = cpfUsuario;
		this.telefoneUsuario = telefoneUsuario;
		this.login_usuario = login_usuario;
		this.senha_usuario = senha_usuario;
	}

	public Usuario() {
		
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSobreNomeUsuario() {
		return sobreNomeUsuario;
	}

	public void setSobreNomeUsuario(String sobreNomeUsuario) {
		this.sobreNomeUsuario = sobreNomeUsuario;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public String getTelefoneUsuario() {
		return telefoneUsuario;
	}

	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}

	public String getLogin_usuario() {
		return login_usuario;
	}

	public void setLogin_usuario(String login_usuario) {
		this.login_usuario = login_usuario;
	}

	public String getSenha_usuario() {
		return senha_usuario;
	}

	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}


}

