package modelo.dao.usuario;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.dao.GenericoJPADAO;
import modelo.entidade.usuario.Usuario;
import modelo.entidade.usuario.tutor.Tutor;
import modelo.factory.conexao.ConexaoFactory;

public abstract class UsuarioDAO <T> extends GenericoJPADAO{

	public UsuarioDAO(Class classe) {
		super(classe);
		// TODO Auto-generated constructor stub
	}
	
	ConexaoFactory fabrica = new ConexaoFactory();


	public long procurarUsuarioLogin(Usuario usuario) {
		Session sessao = null;
		Usuario usuarioRetorno= null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raiz = criteria.from(Usuario.class);
			criteria.where(construtor.and(construtor.equal(raiz.get("login_usuario"), usuario.getLogin_usuario()),construtor.equal(raiz.get("senha_usuario"), usuario.getSenha_usuario())));

			criteria.select(raiz);

			usuarioRetorno = sessao.createQuery(criteria).getSingleResult();
					
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

		return usuarioRetorno.getIdUsuario();
	}
	

}