package br.edu.ifsc.cds.DAO.interfaces;

import java.util.List;
import br.edu.ifsc.cds.classes.domain.InfoNutricional;

public interface IinfoNutricionalDAO {
	
	public void create(InfoNutricional infnutri);
	
    public List<InfoNutricional> retrieveAll();
		
	public InfoNutricional retrieve(Integer id);
		
	public void update(InfoNutricional infnutri);
		
	public void delete(Integer id);
}
