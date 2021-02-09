package modelo.dao.animal;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.dao.GenericoJPADAO;
import modelo.entidade.animal.AnimalDomestico;
import modelo.entidade.corrida.Corrida;
import modelo.entidade.usuario.tutor.Tutor;
import modelo.factory.conexao.ConexaoFactory;

public class AnimalDomesticoDAOSGDBImpl<AnimalDomesticoDAOSGDBImpl> extends GenericoJPADAO {

	public AnimalDomesticoDAOSGDBImpl(Class<AnimalDomestico> classe) {
		super(classe);
		
	}
	
	ConexaoFactory fabrica = new ConexaoFactory();

	
	public List<AnimalDomestico> listarAnimalPorIdTutor(Tutor tutor) {
		Session sessao = null;
		List<AnimalDomestico> animais = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<AnimalDomestico> criteria = construtor.createQuery(AnimalDomestico.class);
			Root<AnimalDomestico> raiz = criteria.from(AnimalDomestico.class);
			criteria.where(construtor.equal(raiz.get("tutor"), tutor.getIdUsuario()));

			criteria.select(raiz);

			animais = sessao.createQuery(criteria).getResultList();

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

		return animais;
	}

	
	}



