package modelo.dao;

import java.util.List;

public interface GenericoDAO <T> {

	void inserir(T t);
	void atualizar(T t);
	void deletar(T t);
	List<T> listar();
	
}
