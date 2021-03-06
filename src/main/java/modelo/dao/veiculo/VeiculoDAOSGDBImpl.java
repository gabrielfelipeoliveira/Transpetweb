package modelo.dao.veiculo;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.dao.GenericoJPADAO;
import modelo.entidade.usuario.motorista.Motorista;
import modelo.entidade.veiculo.Veiculo;
import modelo.factory.conexao.ConexaoFactory;

public class VeiculoDAOSGDBImpl extends GenericoJPADAO{

	public VeiculoDAOSGDBImpl(Class<Veiculo> classe) {
		super(classe);
	}
	
	
ConexaoFactory fabrica = new ConexaoFactory();

	
	public List<Veiculo> listarVeiculoPorIdMotorista(Motorista motorista) {
		Session sessao = null;
		List<Veiculo> veiculos = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Veiculo> criteria = construtor.createQuery(Veiculo.class);
			Root<Veiculo> raiz = criteria.from(Veiculo.class);
			criteria.where(construtor.equal(raiz.get("motoristaVeiculo"), motorista.getIdUsuario()));

			criteria.select(raiz);

			veiculos = sessao.createQuery(criteria).getResultList();

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}

		return veiculos;
	}

	public Veiculo listarVeiculoPorIdVeiculo(Long id) {
		Session sessao = null;
		Veiculo veiculoReturn = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Veiculo> criteria = construtor.createQuery(Veiculo.class);
			Root<Veiculo> raiz = criteria.from(Veiculo.class);
			criteria.where(construtor.equal(raiz.get("idVeiculo"), id));

			criteria.select(raiz);

			veiculoReturn = sessao.createQuery(criteria).getSingleResult();

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}

		return veiculoReturn;
	}

	
}
