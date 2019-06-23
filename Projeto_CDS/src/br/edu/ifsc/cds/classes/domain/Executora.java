package br.edu.ifsc.cds.classes.domain;

import br.edu.ifsc.cds.DAO.AdminDAO;

public class Executora {

	public static void main(String[] args) {
		Admin admin = new Admin(null, "Admin", "admin@cds.com", "admin", "123.456.789-01", "Rua Zero, Bairro Um",
				"(49)99999-9999");
		AdminDAO admindao = new AdminDAO();
		admindao.create(admin);

	}

}
