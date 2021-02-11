package modelo.dao.usuario;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidade.animal.AnimalDomestico;
import modelo.entidade.usuario.Usuario;
import modelo.entidade.usuario.tutor.Tutor;
import modelo.factory.conexao.ConexaoFactory;

public class TutorDAOSGDBImpl  extends UsuarioDAO<Tutor>{

	public TutorDAOSGDBImpl(Class<Tutor> classe) {
		super(classe);
	}
	ConexaoFactory fabrica = new ConexaoFactory();
	
	public boolean procurarTutorId(long id ) {
		Session sessao = null;
		Tutor tutorRetorno= null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Tutor> criteria = construtor.createQuery(Tutor.class);
			Root<Tutor> raiz = criteria.from(Tutor.class);
			criteria.where(construtor.equal(raiz.get("id_usuario"), id));

			criteria.select(raiz);

			tutorRetorno = sessao.createQuery(criteria).getSingleResult();
					
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

		return tutorRetorno!=null;
	}
	
	
	public Tutor listarTutorId(long id ) {
		Session sessao = null;
		Tutor tutorRetorno= null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Tutor> criteria = construtor.createQuery(Tutor.class);
			Root<Tutor> raiz = criteria.from(Tutor.class);
			criteria.where(construtor.equal(raiz.get("id_usuario"), id));

			criteria.select(raiz);

			tutorRetorno = sessao.createQuery(criteria).getSingleResult();
					
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

		return tutorRetorno;
	}
	
}
