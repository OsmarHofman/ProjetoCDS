package br.edu.ifsc.cds.DAO.interfaces;

import java.util.List;

import br.edu.ifsc.cds.classes.domain.Admin;

public interface IAdminDAO {

	public void create(Admin admin);

	public List<Admin> retrieveAll();

	public Admin retrieve(Integer id);

	public Admin retrieveCount(String user, String password);

	public void update(Admin admin);

	public void delete(Integer id);

}
