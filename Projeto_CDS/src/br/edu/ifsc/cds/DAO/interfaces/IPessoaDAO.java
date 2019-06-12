package br.edu.ifsc.cds.DAO.interfaces;

import java.util.List;

import br.edu.ifsc.cds.classes.domain.Pessoa;

public interface IPessoaDAO {

	public void create(Pessoa pessoa);
	
    public List<Pessoa> retrieveAll();
		
	public Pessoa retrieve(Integer id);
		
	public void update(Pessoa pessoa);
		
	public void delete(Integer id);
}
