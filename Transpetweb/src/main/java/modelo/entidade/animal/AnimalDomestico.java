package modelo.entidade.animal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import modelo.entidade.usuario.Usuario;
import modelo.entidade.usuario.tutor.Tutor;
import modelo.enumeracao.TipoAnimal;

@Entity
@Table(name = "animal")
public class AnimalDomestico implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_animal")
	private long idAnimal;

	@Column(name = "nome_animal", length = 25, nullable = false, unique = false)
	private String nomeAnimal;

	@Column(name = "peso_animal", length = 5, nullable = false, unique = false)
	private double peso;

	@Column(name = "raca_animal", length = 25, nullable = false, unique = false)
	private String raca;

	@Column(name = "tamanho_animal", length = 5, nullable = false, unique = false)
	private double tamanho;

	@Column(name = "observacao_animal", length = 100, nullable = false, unique = false)
	private String observacao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tutor")
	private Tutor tutor;
	
	@Column(name = "tipo_animal", length = 1, nullable = false, unique = false)
	private TipoAnimal tipoAnimal;

	public AnimalDomestico(Long idAnimal, String nomeAnimal, double peso, String raca, double tamanho,
			String observacao, Tutor tutor, TipoAnimal tipoAnimal) {
		this.idAnimal = idAnimal;
		this.nomeAnimal = nomeAnimal;
		this.peso = peso;
		this.raca = raca;
		this.tamanho = tamanho;
		this.observacao = observacao;
		this.tutor = tutor;
		this.tipoAnimal = tipoAnimal;
	}

	public AnimalDomestico(String nomeAnimal, double peso, String raca, double tamanho, String observacao,
			Tutor tutor, TipoAnimal tipoAnimal) {
		this.nomeAnimal = nomeAnimal;
		this.peso = peso;
		this.raca = raca;
		this.tamanho = tamanho;
		this.observacao = observacao;
		this.tutor = tutor;
		this.tipoAnimal = tipoAnimal;
	}

	public AnimalDomestico() {
		
	}

	public Long getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Long idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public double getTamanho() {
		return tamanho;
	}

	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}


}
