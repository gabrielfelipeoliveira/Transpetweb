package modelo.dao.endereco;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.dao.GenericoJPADAO;
import modelo.entidade.endereco.Endereco;
import modelo.entidade.usuario.tutor.Tutor;
import modelo.factory.conexao.ConexaoFactory;

public class EnderecoDAOSGDBImpl extends GenericoJPADAO {

	public EnderecoDAOSGDBImpl(Class<Endereco> classe) {
		super(classe);
		// TODO Auto-generated constructor stub
	}

	ConexaoFactory fabrica = new ConexaoFactory();

	public List<Endereco> listarEnderecoPorIdUsuario(Tutor tutor) {
		Session sessao = null;
		List<Endereco> enderecos = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Endereco> criteria = construtor.createQuery(Endereco.class);
			Root<Endereco> raiz = criteria.from(Endereco.class);
			
			Join<Endereco, Tutor> juncaoTutor = raiz.join("tutores");
			
			ParameterExpression<Long> idTutor = construtor.parameter(Long.class);
			
			criteria.where(construtor.equal(juncaoTutor.get("idUsuario") , idTutor));
			

			

			enderecos = sessao.createQuery(criteria).setParameter(idTutor, tutor.getIdUsuario()).getResultList();

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

		return enderecos;
	}
	

	public Endereco listarEnderecoPorIdEndereco(long id) {
		Session sessao = null;
		Endereco endereco = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Endereco> criteria = construtor.createQuery(Endereco.class);
			Root<Endereco> raiz = criteria.from(Endereco.class);
			
		
			criteria.where(construtor.equal(raiz.get("idEndereco") , id));
			
			
			criteria.select(raiz);

			endereco = sessao.createQuery(criteria).getSingleResult();
			
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

		return endereco;
	}
	
	
	
}


