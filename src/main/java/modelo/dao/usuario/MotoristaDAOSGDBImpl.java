package modelo.dao.usuario;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidade.usuario.motorista.Motorista;
import modelo.entidade.usuario.tutor.Tutor;

public class MotoristaDAOSGDBImpl extends UsuarioDAO<Motorista> {

	public MotoristaDAOSGDBImpl(Class<Motorista> classe) {
		super(classe);

	}

	public boolean procurarMotoristaId(long id) {
		Session sessao = null;
		Motorista motoristaRetorno = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Motorista> criteria = construtor.createQuery(Motorista.class);
			Root<Motorista> raiz = criteria.from(Motorista.class);
			criteria.where(construtor.equal(raiz.get("id_usuario"), id));

			criteria.select(raiz);

			motoristaRetorno = sessao.createQuery(criteria).getSingleResult();

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

		return motoristaRetorno != null;
	}

}
