package br.edu.ifsc.cds.frames.admin.telaGeralExercicio;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.DTO.AtividadeFisicaDTO;
import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.frames.admin.telaCadExercicio.CadExercicioController;
import br.edu.ifsc.cds.frames.admin.telaCadExercicio.ExecutorCadExercicio;
import br.edu.ifsc.cds.services.ExercicioService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GeralExercicioController implements Initializable {

	@FXML
	private JFXButton btnCadastrar;

	@FXML
	private TableView<AtividadeFisicaDTO> tbvExercicio;

	@FXML
	private JFXButton btnEditar;

	@FXML
	private TableColumn<AtividadeFisicaDTO, String> colNome;

	@FXML
	private TableColumn<AtividadeFisicaDTO, Float> colGCalorico;

	@FXML
	private TableColumn<AtividadeFisicaDTO, Float> colMet;

	@FXML
	private TableColumn<AtividadeFisicaDTO, Integer> colId;

	@FXML
	private JFXButton btnExcluir;

	/**
	 * Inicia uma tela de Cadastro de Exercicio
	 * 
	 * @param event Evento do clique
	 */
	@FXML
	void cadastrar(ActionEvent event) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("CDS - Cadastro Alimentos");

		ExecutorCadExercicio exeCadExercicio = new ExecutorCadExercicio();
		exeCadExercicio.start(stage);
	}

	/**
	 * Inicia uma tela de Edição de Exercicio
	 * 
	 * @param event Evento do clique
	 */
	@FXML
	void editar(ActionEvent event) {
		AtividadeFisicaDTO dto = tbvExercicio.getSelectionModel().getSelectedItem();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../telaCadExercicio/CadExercicio.fxml"));
			Parent root = (Parent) loader.load();

			CadExercicioController controller = loader.getController();
			controller.setCampos(dto);

			// Contrói a nova tela
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.setTitle("CDS");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Exclui um Exercicio selecionado na tabela
	 * 
	 * @param event Evento do clique
	 */
	@FXML
	void excluir(ActionEvent event) {
		AtividadeFisicaDTO dto = tbvExercicio.getSelectionModel().getSelectedItem();
		int decisaoEx = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir esse Exercicio?");
		if (decisaoEx == 0) {
			ExercicioService service = new ExercicioService();
			service.excluirExercicio(dto.getId());
			btnExcluir.setDisable(true);
			btnEditar.setDisable(true);
			this.atualizar(event);
		}
	}

	/**
	 * Atualiza a tabela de Exercicio
	 * 
	 * @param event Evento do clique
	 */
	@FXML
	void atualizar(ActionEvent event) {
		tbvExercicio.setItems(new AtividadeFisicaDTO().geraExercDTO());
	}

	/**
	 * Formata as colunas da tabela para os tipos de dados corretos, e inicializa as
	 * Pessoas já cadastradas no sistema
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// desabilita os botoes de editar e excluir
		btnEditar.setDisable(true);
		btnExcluir.setDisable(true);

		// adiciona um Listener para verificar se um elemento da tabela foi selecionado
		ControleComponente ctrl = new ControleComponente();
		ctrl.isSelecionado(tbvExercicio, btnEditar);
		ctrl.isSelecionado(tbvExercicio, btnExcluir);

		colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colGCalorico.setCellValueFactory(new PropertyValueFactory<>("gastoCaloria"));
		colMet.setCellValueFactory(new PropertyValueFactory<>("met"));
		tbvExercicio.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue,
					Boolean newPropertyValue) {
				if (newPropertyValue) {
					tbvExercicio.setItems(new AtividadeFisicaDTO().geraExercDTO());
				}
			}
		});
	}

}
