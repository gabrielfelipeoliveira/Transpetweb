package modelo.dao.corrida;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.dao.GenericoJPADAO;
import modelo.entidade.corrida.Corrida;
import modelo.entidade.usuario.Usuario;
import modelo.entidade.usuario.motorista.Motorista;
import modelo.entidade.usuario.tutor.Tutor;
import modelo.factory.conexao.ConexaoFactory;

public class CorridaDAOSGDBImpl extends GenericoJPADAO {

	ConexaoFactory fabrica = new ConexaoFactory();

	public CorridaDAOSGDBImpl(Class<Corrida> classe) {
		super(classe);

	}

	public List<Corrida> listarCorridaAberta() {
		Session sessao = null;
		List<Corrida> corridas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Corrida> criteria = construtor.createQuery(Corrida.class);
			Root<Corrida> raiz = criteria.from(Corrida.class);
			ParameterExpression<Long> id_motorista = construtor.parameter(Long.class);
			criteria.where(construtor.isNull(raiz.get("motorista")));

			criteria.select(raiz);

			corridas = sessao.createQuery(criteria).getResultList();

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

		return corridas;
	}

	public List<Corrida> listarCorridaFeita() {
		Session sessao = null;
		List<Corrida> corridas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Corrida> criteria = construtor.createQuery(Corrida.class);
			Root<Corrida> raiz = criteria.from(Corrida.class);
			ParameterExpression<Long> id_motorista = construtor.parameter(Long.class);
			criteria.where(construtor.isNotNull(raiz.get("motorista")));

			criteria.select(raiz);

			corridas = sessao.createQuery(criteria).getResultList();

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

		return corridas;
	}

	public List<Corrida> listarCorridaPorIdMotorista(Motorista motorista) {
		Session sessao = null;
		List<Corrida> corridas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Corrida> criteria = construtor.createQuery(Corrida.class);
			Root<Corrida> raiz = criteria.from(Corrida.class);
			ParameterExpression<Long> id_motorista = construtor.parameter(Long.class);
			criteria.where(construtor.equal(raiz.get("motorista"), motorista.getIdUsuario()));

			criteria.select(raiz);

			corridas = sessao.createQuery(criteria).getResultList();

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

		return corridas;
	}

	public List<Corrida> listarCorridaPorIdTutor(Tutor tutor) {
		Session sessao = null;
		List<Corrida> corridas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Corrida> criteria = construtor.createQuery(Corrida.class);
			Root<Corrida> raiz = criteria.from(Corrida.class);
			ParameterExpression<Long> id_tutor = construtor.parameter(Long.class);
			criteria.where(construtor.equal(raiz.get("tutor"), tutor.getIdUsuario()));

			criteria.select(raiz);

			corridas = sessao.createQuery(criteria).getResultList();

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

		return corridas;
	}

	public List<Corrida> listarCorridaFeitaPorTutor(Tutor tutor) {
		Session sessao = null;
		List<Corrida> corridas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Corrida> criteria = construtor.createQuery(Corrida.class);
			Root<Corrida> raiz = criteria.from(Corrida.class);
			ParameterExpression<Long> id_motorista = construtor.parameter(Long.class);
			criteria.where(construtor.and(construtor.isNotNull(raiz.get("motorista")),
					construtor.equal(raiz.get("tutor"), tutor.getIdUsuario())));

			criteria.select(raiz);

			corridas = sessao.createQuery(criteria).getResultList();

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

		return corridas;
	}

	public List<Corrida> listarCorridaAbertaPorTutor(Tutor tutor) {
		Session sessao = null;
		List<Corrida> corridas = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Corrida> criteria = construtor.createQuery(Corrida.class);
			Root<Corrida> raiz = criteria.from(Corrida.class);
			ParameterExpression<Long> id_motorista = construtor.parameter(Long.class);
			criteria.where(construtor.and(construtor.isNull(raiz.get("motorista")),
					construtor.equal(raiz.get("tutor"), tutor.getIdUsuario())));

			criteria.select(raiz);

			corridas = sessao.createQuery(criteria).getResultList();

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

		return corridas;
	}


	public Corrida listarCorridaPorIdCorrida(Long id) {
		Session sessao = null;
		Corrida corridaReturn = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Corrida> criteria = construtor.createQuery(Corrida.class);
			Root<Corrida> raiz = criteria.from(Corrida.class);
			ParameterExpression<Long> id_tutor = construtor.parameter(Long.class);
			criteria.where(construtor.equal(raiz.get("idCorrida"), id));

			criteria.select(raiz);

			corridaReturn = sessao.createQuery(criteria).getSingleResult();

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

		return corridaReturn;
	}

}
