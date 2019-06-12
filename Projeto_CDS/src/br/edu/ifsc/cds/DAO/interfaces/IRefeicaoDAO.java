package br.edu.ifsc.cds.DAO.interfaces;

import java.util.List;

import br.edu.ifsc.cds.classes.domain.Refeicao;

public interface IRefeicaoDAO {

	public void create(Refeicao refeicao);
	
    public List<Refeicao> retrieveAll();
		
	public Refeicao retrieve(Integer id);
		
	public void update(Refeicao refeicao);
		
	public void delete(Integer id);
}
