package br.edu.ifsc.cds.frames.user.telaHistorico;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.classes.domain.Pessoa;
import br.edu.ifsc.cds.classes.domain.Rotina;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

/**
 * Controller da tela de histórico de {@link Rotina} do {@link Pessoa}.
 * @author luana
 *
 */
public class HistoricoController implements Initializable {

	@FXML
	private JFXButton btnExercicios;

	@FXML
	private TableColumn<?, ?> tituloRotina;

	@FXML
	private JFXButton btnVoltar;

	@FXML
	private TableColumn<?, ?> tituloRotina1;

	@FXML
	private Pane pnlOverview;

	@FXML
	private TableView<?> tbvRotina;

	@FXML
	private JFXButton btnaddRotina;

	@FXML
	private JFXButton btnRotinas;

	@FXML
	private JFXButton btnHistorico;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnaddRotina.setDisable(true);
	}

}
