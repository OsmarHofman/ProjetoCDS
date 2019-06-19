package br.edu.ifsc.cds.frames.telaDados;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.edu.ifsc.cds.DAO.PessoaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class DadosController implements Initializable {

	@FXML
	private JFXButton btnEditar;

	@FXML
	private JFXTextField txtAltura;

	@FXML
	private JFXTextField txtPeso;

	@FXML
	private JFXButton btnVoltar;

	@FXML
	void editarInfo(ActionEvent event) {
		if (!txtPeso.isEditable() && !txtAltura.isEditable()) {
			txtAltura.setEditable(true);
			txtPeso.setEditable(true);
			txtPeso.requestFocus();
			btnEditar.setText("Salvar");
		} else {
			txtAltura.setEditable(false);
			txtPeso.setEditable(false);
			btnEditar.setText("Editar Informações");
			PessoaDAO pessoaDAO = new PessoaDAO();
		}

	}

	@FXML
	void voltarTela(ActionEvent event) {
		Stage telaAtual = (Stage) btnVoltar.getScene().getWindow();
		telaAtual.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtAltura.setEditable(false);
		txtPeso.setEditable(false);
	}

}
