package br.edu.ifsc.cds.frames.telaDados;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.edu.ifsc.cds.DAO.PessoaDAO;
import br.edu.ifsc.cds.classes.domain.Pessoa;
import br.edu.ifsc.cds.frames.telaRotina.RotinaController;
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

			Pessoa usuario = RotinaController.pessoa;
			usuario.setAltura(Float.parseFloat(txtAltura.getText()));
			usuario.setPeso_inicial(Float.parseFloat(txtPeso.getText()));

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.update(usuario);
			JOptionPane.showMessageDialog(null, "Informações Salvas com sucesso!");

		}

	}

	@FXML
	void voltarTela(ActionEvent event) {
		Stage telaAtual = (Stage) btnVoltar.getScene().getWindow();
		telaAtual.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtAltura.setText(String.valueOf(RotinaController.pessoa.getAltura()));
		txtPeso.setText(String.valueOf(RotinaController.pessoa.getPeso_inicial()));
		txtAltura.setEditable(false);
		txtPeso.setEditable(false);

	}

}
