package br.edu.ifsc.cds.frames.user.telaDados;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.edu.ifsc.cds.classes.domain.Pessoa;
import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.services.PessoaService;
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

			PessoaService service = new PessoaService();
			Pessoa usuario = service.retornaPessoa(Integer.parseInt(System.getProperty("id")));
			usuario.setAltura(Float.parseFloat(txtAltura.getText()));
			usuario.setPeso_inicial(Float.parseFloat(txtPeso.getText()));
			// altera no banco de dados
			service.editarUsuario(usuario);
			this.atualizarSystem(usuario);
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
		ControleComponente controle = new ControleComponente();
		controle.fechaBotao(btnVoltar);
	}

	/**
	 * Inicializa a Classe obtendo os valores de Altura e Peso da Pessoa, e
	 * desabilitando os seus campos
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtAltura.setText(System.getProperty("altura"));
		txtPeso.setText(System.getProperty("peso"));
		txtAltura.setEditable(false);
		txtPeso.setEditable(false);

	}

	/**
	 * Realiza a atualição da propriedade id do system
	 * @param usuario
	 */
	public void atualizarSystem(Pessoa usuario) {
		System.setProperty("id", String.valueOf(usuario.getId()));
		System.setProperty("altura", String.valueOf(usuario.getAltura()));
		System.setProperty("peso", String.valueOf(usuario.getPeso_inicial()));
	}

}
