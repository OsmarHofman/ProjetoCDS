package br.edu.ifsc.cds.frames.admin.telaGeralAlimento;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.classes.domain.Admin;
import br.edu.ifsc.cds.DTO.InfoNutricionalDTO;
import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.frames.admin.telaCadAlimento.CadAlimentoController;
import br.edu.ifsc.cds.frames.admin.telaCadAlimento.ExecutorCadAlimento;
import br.edu.ifsc.cds.services.AlimentoService;
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

/**
 * Controller da tela Geral de Alimentos vizualizada pelo {@link Admin}.
 */
public class GeralAlimentoController implements Initializable {
	@FXML
	private TableColumn<InfoNutricionalDTO, Float> colGordSat;

	@FXML
	private JFXButton btnCadastrar;

	@FXML
	private TableView<InfoNutricionalDTO> tbvAlimento;

	@FXML
	private JFXButton btnEditar;

	@FXML
	private TableColumn<InfoNutricionalDTO, String> colNome;

	@FXML
	private TableColumn<InfoNutricionalDTO, Float> colFibra;

	@FXML
	private TableColumn<InfoNutricionalDTO, Float> colGordTot;

	@FXML
	private TableColumn<InfoNutricionalDTO, Float> colCaloria;

	@FXML
	private TableColumn<InfoNutricionalDTO, Float> colProteina;

	@FXML
	private TableColumn<InfoNutricionalDTO, Float> colSodio;

	@FXML
	private TableColumn<InfoNutricionalDTO, Float> colGordTrans;

	@FXML
	private TableColumn<InfoNutricionalDTO, Integer> colId;

	@FXML
	private JFXButton btnExcluir;

	@FXML
	private TableColumn<InfoNutricionalDTO, Float> colCarboidrato;

	/**
	 * Inicia uma tela de Cadastro de Alimento
	 * 
	 * @param event Evento do clique
	 */
	@FXML
	void cadastrar(ActionEvent event) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("CDS - Cadastro Alimentos");

		ExecutorCadAlimento exeCadAlimento = new ExecutorCadAlimento();
		exeCadAlimento.start(stage);
	}

	/**
	 * Inicia uma tela de Edição de Alimento
	 * 
	 * @param event Evento do clique
	 */
	@FXML
	void editar(ActionEvent event) {
		InfoNutricionalDTO dto = tbvAlimento.getSelectionModel().getSelectedItem();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../telaCadAlimento/CadAlimento.fxml"));
			Parent root = (Parent) loader.load();

			CadAlimentoController controller = loader.getController();
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
	 * Exclui um Alimento selecionado na tabela
	 * 
	 * @param event Evento do clique
	 */
	@FXML
	void excluir(ActionEvent event) {
		InfoNutricionalDTO dto = tbvAlimento.getSelectionModel().getSelectedItem();
		int decisaoEx = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir esse Alimento?");
		if (decisaoEx == 0) {
			AlimentoService service = new AlimentoService();
			service.excluirAlimento(dto.getId());
			btnExcluir.setDisable(true);
			btnEditar.setDisable(true);
			this.atualizar(event);
		}
	}

	/**
	 * Atualiza a tabela de Alimento
	 * 
	 * @param event Evento do clique
	 */
	@FXML
	void atualizar(ActionEvent event) {
		tbvAlimento.setItems(new InfoNutricionalDTO().geraInfoDTO());
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
		ctrl.isSelecionado(tbvAlimento, btnEditar);
		ctrl.isSelecionado(tbvAlimento, btnExcluir);

		// formata as celulas da tabela
		colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colCaloria.setCellValueFactory(new PropertyValueFactory<>("caloria"));
		colCarboidrato.setCellValueFactory(new PropertyValueFactory<>("carboidrato"));
		colProteina.setCellValueFactory(new PropertyValueFactory<>("proteinas"));
		colFibra.setCellValueFactory(new PropertyValueFactory<>("fibras"));
		colSodio.setCellValueFactory(new PropertyValueFactory<>("sodio"));
		colGordSat.setCellValueFactory(new PropertyValueFactory<>("gordurasSaturadas"));
		colGordTot.setCellValueFactory(new PropertyValueFactory<>("gordurasTotais"));
		colGordTrans.setCellValueFactory(new PropertyValueFactory<>("gordurasTrans"));
		tbvAlimento.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue,
					Boolean newPropertyValue) {
				if (newPropertyValue) {
					tbvAlimento.setItems(new InfoNutricionalDTO().geraInfoDTO());
				}
			}
		});
	}

}
