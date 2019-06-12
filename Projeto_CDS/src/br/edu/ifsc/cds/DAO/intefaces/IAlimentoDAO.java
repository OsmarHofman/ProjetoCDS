package br.edu.ifsc.cds.DAO.intefaces;

import java.util.List;

import br.edu.ifsc.cds.classes.domain.Alimento;

public interface IAlimentoDAO {

    public void create(Alimento alimento);
	
	public List<Alimento> retrieveAll();
	
	public Alimento retrieve(Integer id);
	
	public void update(Alimento alimento);
	
	public void delete(Integer id);
	
}
