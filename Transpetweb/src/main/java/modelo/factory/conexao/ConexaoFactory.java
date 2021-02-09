package modelo.factory.conexao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConexaoFactory {

	public SessionFactory getConexao() {

		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(modelo.entidade.usuario.motorista.Motorista.class);
		configuracao.addAnnotatedClass(modelo.entidade.usuario.tutor.Tutor.class);
		configuracao.addAnnotatedClass(modelo.entidade.usuario.Usuario.class);
		configuracao.addAnnotatedClass(modelo.entidade.endereco.Endereco.class);
		configuracao.addAnnotatedClass(modelo.entidade.veiculo.Veiculo.class);
		configuracao.addAnnotatedClass(modelo.entidade.animal.AnimalDomestico.class);
		configuracao.addAnnotatedClass(modelo.entidade.corrida.Corrida.class);

		
		configuracao.configure("hibernate.cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();

		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;
	}
}