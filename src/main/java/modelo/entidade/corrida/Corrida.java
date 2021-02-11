package modelo.entidade.corrida;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import modelo.entidade.animal.AnimalDomestico;
import modelo.entidade.endereco.Endereco;
import modelo.entidade.usuario.motorista.Motorista;
import modelo.entidade.usuario.tutor.Tutor;

@Entity
@Table(name = "corrida")
public class Corrida implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_corrida")
	private long idCorrida;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_endereco_inicial", foreignKey = @ForeignKey(name = "fk_endereco_inicial"))
	private Endereco enderecoInicial;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_endereco_final", foreignKey = @ForeignKey(name = "fk_endereco_final"))
	private Endereco enderecoFinal;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tutor")
	private Tutor tutor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_motorista")
	private Motorista motorista;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_animal")
	private AnimalDomestico animal;

	public Corrida(long idCorrida, Endereco enderecoInicial, Endereco enderecoFinal, Tutor tutor, Motorista motorista) {
		this.idCorrida = idCorrida;
		this.enderecoInicial = enderecoInicial;
		this.enderecoFinal = enderecoFinal;
		this.tutor = tutor;
		this.motorista = motorista;
	}

	public Corrida(Endereco enderecoInicial, Endereco enderecoFinal, Tutor tutor, Motorista motorista) {
		this.enderecoInicial = enderecoInicial;
		this.enderecoFinal = enderecoFinal;
		this.tutor = tutor;
		this.motorista = motorista;
	}

	public Corrida() {
	}

	public long getIdCorrida() {
		return idCorrida;
	}

	public void setIdCorrida(long idCorrida) {
		this.idCorrida = idCorrida;
	}

	public Endereco getEnderecoInicial() {
		return enderecoInicial;
	}

	public void setEnderecoInicial(Endereco enderecoInicial) {
		this.enderecoInicial = enderecoInicial;
	}

	public Endereco getEnderecoFinal() {
		return enderecoFinal;
	}

	public void setEnderecoFinal(Endereco enderecoFinal) {
		this.enderecoFinal = enderecoFinal;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public AnimalDomestico getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalDomestico animal) {
		this.animal = animal;
	}
}