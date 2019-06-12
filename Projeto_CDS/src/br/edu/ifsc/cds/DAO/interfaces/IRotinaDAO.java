package br.edu.ifsc.cds.DAO.interfaces;

import java.util.List;

import br.edu.ifsc.cds.classes.domain.Rotina;

public interface IRotinaDAO {

	public void create(Rotina rotina);
	
    public List<Rotina> retrieveAll();
		
	public Rotina retrieve(Integer id);
		
	public void update(Rotina rotina);
		
	public void delete(Integer id);
}
