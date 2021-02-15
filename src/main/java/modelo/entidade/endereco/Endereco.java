package modelo.entidade.endereco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import modelo.entidade.corrida.Corrida;
import modelo.entidade.usuario.tutor.Tutor;

@Entity
@Table(name = "endereco", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "rua_endereco", "numero_endereco" }) })
public class Endereco implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private long idEndereco;

	@Column(name = "rua_endereco", length = 30, nullable = false, unique = false)
	private String ruaEndereco;

	@Column(name = "numero_endereco", length = 5, nullable = false, unique = false)
	private int numeroEndereco;
	
	@Column(name = "cep_endereco", length = 8, nullable = false, unique = true)
	private long cepEndereco;

	@ManyToMany(mappedBy = "enderecos")
	private List<Tutor> tutores = new ArrayList<Tutor>();;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enderecoInicial", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Corrida> corridasInicial = new ArrayList<Corrida>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enderecoFinal", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Corrida> corridasFinal = new ArrayList<Corrida>();

	public Endereco(int idEndereco, String ruaEndereco, int numeroEndereco, long cepEndereco, List<Tutor> tutores,
			List<Corrida> corridasInicial, List<Corrida> corridasFinal) {
		this.idEndereco = idEndereco;
		this.ruaEndereco = ruaEndereco;
		this.numeroEndereco = numeroEndereco;
		this.cepEndereco = cepEndereco;
		this.tutores = tutores;
		this.corridasInicial = corridasInicial;
		this.corridasFinal = corridasFinal;
	}

	public Endereco(String ruaEndereco, int numeroEndereco, long cepEndereco, List<Tutor> tutores,
			List<Corrida> corridasInicial, List<Corrida> corridasFinal) {
		this.ruaEndereco = ruaEndereco;
		this.numeroEndereco = numeroEndereco;
		this.cepEndereco = cepEndereco;
		this.tutores = tutores;
		this.corridasInicial = corridasInicial;
		this.corridasFinal = corridasFinal;
	}

	public Endereco() {
		super();
	}

	public long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getRuaEndereco() {
		return ruaEndereco;
	}

	public void setRuaEndereco(String ruaEndereco) {
		this.ruaEndereco = ruaEndereco;
	}

	public int getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(int numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public long getCepEndereco() {
		return cepEndereco;
	}

	public void setCepEndereco(long cepEndereco) {
		this.cepEndereco = cepEndereco;
	}

	public List<Tutor> getTutores() {
		return tutores;
	}

	public void setTutores(Tutor tutores) {
		this.tutores.add(tutores);
	}

	public List<Corrida> getCorridasInicial() {
		return corridasInicial;
	}

	public void setCorridasInicial(Corrida corridasInicial) {
		this.corridasInicial.add(corridasInicial);
	}

	public List<Corrida> getCorridasFinal() {
		return corridasFinal;
	}

	public void setCorridasFinal(Corrida corridasFinal) {
		this.corridasFinal.add(corridasFinal);
	}

}