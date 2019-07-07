package br.edu.ifsc.cds.frames.admin.telaUsuarios;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.DTO.PessoaDTO;
import br.edu.ifsc.cds.classes.domain.Admin;
import br.edu.ifsc.cds.classes.domain.Alimento;
import br.edu.ifsc.cds.classes.domain.Exercicio;
import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.frames.admin.telaCadExercicio.ExecutorCadExercicio;
import br.edu.ifsc.cds.frames.admin.telaGeralAlimento.ExecutorGeralAlimento;
import br.edu.ifsc.cds.frames.telaLogin.ExecutorLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UsuariosController implements Initializable {

	// Administrador que logou
	public static Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		UsuariosController.admin = admin;
	}

	@FXML
	private TableView<PessoaDTO> tbvUsuarios;

	@FXML
	private TableColumn<PessoaDTO, Integer> colId;

	@FXML
	private TableColumn<PessoaDTO, String> colNome;

	@FXML
	private TableColumn<PessoaDTO, String> colEmail;

	@FXML
	private JFXButton btnLogout;

	@FXML
	private JFXButton btnAlimentos;

	/**
	 * Mostra a tela de cadastro dos {@link Exercicio} do sistema.
	 * 
	 * @param Clique do botão
	 */
	@FXML
	void mostraExercicios(ActionEvent event) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("CDS - Cadastro de Exercícios");
		ExecutorCadExercicio exeCadExercicio = new ExecutorCadExercicio();
		exeCadExercicio.start(stage);
	}

	/**
	 * Mostra a tela de cadastro dos {@link Alimento} do sistema.
	 * 
	 * @param Clique do botão
	 */
	@FXML
	void mostraAlimentos(ActionEvent event) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("CDS - Cadastro de Alimentos");
		ExecutorGeralAlimento exeGeralAlimento = new ExecutorGeralAlimento();
		exeGeralAlimento.start(stage);
	}

	/**
	 * Fecha esta tela e Retorna a tela que a chamou
	 * 
	 * @param Clique no botão
	 */
	@FXML
	void logout(ActionEvent event) {
		ControleComponente controle = new ControleComponente();
		controle.fechaBotao(btnLogout);
		ExecutorLogin login = new ExecutorLogin();
		login.start(new Stage());
	}

	/**
	 * Formata as colunas da tabela para os tipos de dados corretos, e inicializa as
	 * Pessoas já cadastradas no sistema
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		colNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		PessoaDTO listaPessoas = new PessoaDTO();
		tbvUsuarios.setItems(listaPessoas.geraListaPessoa());
	}

}
