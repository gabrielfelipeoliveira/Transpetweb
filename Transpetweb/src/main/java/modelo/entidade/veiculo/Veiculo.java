package modelo.entidade.veiculo;

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

import modelo.entidade.usuario.motorista.Motorista;

@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_veiculo")
	private long idVeiculo;

	@Column(name = "marca_veiculo", length = 25, nullable = false, unique = false)
	private String marcaVeiculo;
	
	@Column(name = "modelo_veiculo", length = 35, nullable = false, unique = false)
	private String modeloVeiculo;
	
	@Column(name = "placa_veiculo", length = 7, nullable = false, unique = true)
	private String placaVeiculo;
	
	@Column(name = "ano_veiculo", length = 4, nullable = false, unique = false)
	private int anoVeiculo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_motorista")
	private Motorista motoristaVeiculo;

	public Veiculo(long idVeiculo, String marcaVeiculo, String modeloVeiculo, String placaVeiculo, int anoVeiculo,
			Motorista motorista) {
		this.idVeiculo = idVeiculo;
		this.marcaVeiculo = marcaVeiculo;
		this.modeloVeiculo = modeloVeiculo;
		this.placaVeiculo = placaVeiculo;
		this.anoVeiculo = anoVeiculo;
		this.motoristaVeiculo = motorista;
	}

	public Veiculo(String marcaVeiculo, String modeloVeiculo, String placaVeiculo, int anoVeiculo,
			Motorista motorista) {
		this.marcaVeiculo = marcaVeiculo;
		this.modeloVeiculo = modeloVeiculo;
		this.placaVeiculo = placaVeiculo;
		this.anoVeiculo = anoVeiculo;
		this.motoristaVeiculo = motorista;

	}

	public Veiculo() {
	}

	public long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getMarcaVeiculo() {
		return marcaVeiculo;
	}

	public void setMarcaVeiculo(String marcaVeiculo) {
		this.marcaVeiculo = marcaVeiculo;
	}

	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public int getAnoVeiculo() {
		return anoVeiculo;
	}

	public void setAnoVeiculo(int anoVeiculo) {
		this.anoVeiculo = anoVeiculo;
	}

	public Motorista getMotoristaVeiculo() {
		return motoristaVeiculo;
	}

	public void setMotoristaVeiculo(Motorista motoristaVeiculo) {
		this.motoristaVeiculo = motoristaVeiculo;
	}

}