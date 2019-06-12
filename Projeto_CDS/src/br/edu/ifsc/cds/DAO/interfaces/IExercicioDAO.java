package br.edu.ifsc.cds.DAO.interfaces;

import java.util.List;
import br.edu.ifsc.cds.classes.domain.Exercicio;

public interface IExercicioDAO {

	public void create(Exercicio exercicio);
	
    public List<Exercicio> retrieveAll();
		
	public Exercicio retrieve(Integer id);
		
	public void update(Exercicio exercicio);
		
	public void delete(Integer id);
}
