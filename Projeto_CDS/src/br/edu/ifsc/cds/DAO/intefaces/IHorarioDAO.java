package br.edu.ifsc.cds.DAO.intefaces;

import java.util.List;
import br.edu.ifsc.cds.classes.domain.Horario;

public interface IHorarioDAO {

	public void create(Horario horario);
	
    public List<Horario> retrieveAll();
		
	public Horario retrieve(Integer id);
		
	public void update(Horario horario);
		
	public void delete(Integer id);
}
