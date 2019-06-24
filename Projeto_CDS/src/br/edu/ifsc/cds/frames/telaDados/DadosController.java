package br.edu.ifsc.cds.frames.telaDados;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.edu.ifsc.cds.DAO.PessoaDAO;
import br.edu.ifsc.cds.classes.domain.Pessoa;
import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.frames.telaRotina.RotinaController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class DadosController implements Initializable {

	@FXML
	private JFXButton btnEditar;

	@FXML
	private JFXTextField txtAltura;

	@FXML
	private JFXTextField txtPeso;

	@FXML
	private JFXButton btnVoltar;

	/**
	 * Editar e Salvar os dados da {@link Pessoa}. Quando clicado no botão para
	 * Editar, e os campos estiverem desabilitados, pode-se alterar os valores da
	 * Altura e Peso da Pessoa. E quando clicado no botão Salvar, irá armazenar as
	 * informações nos campos, na Pessoa correspondente.
	 * 
	 * @param Clique no botão
	 */
	@FXML
	void editarInfo(ActionEvent event) {
		// Caso deseja alterar
		if (!txtPeso.isEditable() && !txtAltura.isEditable()) {
			txtAltura.setEditable(true);
			txtPeso.setEditable(true);
			txtPeso.requestFocus();
			btnEditar.setText("Salvar");
			// Caso deseja salvar
		} else {
			txtAltura.setEditable(false);
			txtPeso.setEditable(false);
			btnEditar.setText("Editar Informações");

			Pessoa usuario = RotinaController.pessoa;
			usuario.setAltura(Float.parseFloat(txtAltura.getText()));
			usuario.setPeso_inicial(Float.parseFloat(txtPeso.getText()));
			// altera no banco de dados
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.update(usuario);
			JOptionPane.showMessageDialog(null, "Informações Salvas com sucesso!");

		}

	}

	/**
	 * Fecha esta tela e Retorna a tela que a chamou
	 * 
	 * @param Clique no botão
	 */
	@FXML
	void voltarTela(ActionEvent event) {
		ControleComponente.fechaBotao(btnVoltar);
	}

	// Inicializa a Classe obtendo os valores de Altura e Peso da Pessoa, e
	// desabilitando os seus campos
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtAltura.setText(String.valueOf(RotinaController.pessoa.getAltura()));
		txtPeso.setText(String.valueOf(RotinaController.pessoa.getPeso_inicial()));
		txtAltura.setEditable(false);
		txtPeso.setEditable(false);

	}

}
