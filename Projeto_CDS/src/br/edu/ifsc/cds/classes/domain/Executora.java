package br.edu.ifsc.cds.classes.domain;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifsc.cds.DAO.AdminDAO;

public class Executora {
	
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("cds-jpa");

	public static void main(String[] args) {
		
		Admin a1 = new Admin(null,"Adriel","adriel.g","popopopopo","1111111111", "Guatelama - São João udheu", "99191991");
		AdminDAO da = new AdminDAO();
		da.create(a1);
		
		//da.delete(6);
		
	}

}
