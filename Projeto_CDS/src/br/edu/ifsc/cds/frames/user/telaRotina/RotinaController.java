package br.edu.ifsc.cds.frames.user.telaRotina;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.DTO.RefeicaoDTO;
import br.edu.ifsc.cds.classes.domain.Pessoa;
import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.frames.telaLogin.ExecutorLogin;
import br.edu.ifsc.cds.frames.user.telaCadRotina.ExecutorCadRotina;
import br.edu.ifsc.cds.frames.user.telaDados.ExecutorDados;
import br.edu.ifsc.cds.frames.user.telaHistorico.ExecutorHistorico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RotinaController implements Initializable {

	// Pessoa que logou
	public static Pessoa pessoa;

	// lista de refeicoes
	private static List<RefeicaoDTO> listaRefeicao;

	public static List<RefeicaoDTO> getListaRefeicao() {
		return listaRefeicao;
	}

	public static void setListaRefeicao(List<RefeicaoDTO> listaRefeicao) {
		RotinaController.listaRefeicao = listaRefeicao;
	}

	public static void addListaRefeicao(RefeicaoDTO refeicao) {
		RotinaController.listaRefeicao.add(refeicao);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		RotinaController.pessoa = pessoa;
	}

	@FXML
	private JFXButton btnAtualizar;

	@FXML
	private TableView<RefeicaoDTO> refeicaoSegunda;

	@FXML
	private TableColumn<RefeicaoDTO, Float> calorSeg;

	@FXML
	private TableColumn<RefeicaoDTO, String> alimentoSeg;

	@FXML
	private TableColumn<RefeicaoDTO, Float> qtdSeg;

	@FXML
	private TableColumn<RefeicaoDTO, String> unSeg;

	@FXML
	private TableColumn<RefeicaoDTO, Date> inicioSeg;

	@FXML
	private TableColumn<RefeicaoDTO, Date> terminoSeg;

	@FXML
	private BorderPane paneTela;

	@FXML
	private JFXButton btnAlimentos;

	@FXML
	private JFXButton btnRefeicoes;

	@FXML
	private JFXButton btnExercicios;

	@FXML
	private JFXButton btnLogout;

	@FXML
	private JFXButton btnDados;

	@FXML
	private Button BtnNovoAlimento;

	/**
	 * Mostra a tela com os dados pessoais da {@link Pessoa}.
	 * 
	 * @param Clique do botão
	 */
	@FXML
	void mostraDados(ActionEvent event) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("CDS - Meus Dados");

		ExecutorDados exeDados = new ExecutorDados();
		exeDados.start(stage);
	}

	/**
	 * Mostra a tela com os dados do histórico de Rotinas da {@link Pessoa}.
	 * 
	 * @param Clique do botão
	 */
	@FXML
	void mostraHistorico(ActionEvent event) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("CDS - Histórico");
		ExecutorHistorico exeHistorico = new ExecutorHistorico();
		exeHistorico.start(stage);
	}

	/**
	 * Atualiza as informações sobre a Refeicao
	 * 
	 * @param event
	 */
	@FXML
	void atualizar(ActionEvent event) {
		RefeicaoDTO dto = new RefeicaoDTO();
		refeicaoSegunda.setItems(dto.geraListaRefeicao());
	}

	/**
	 * Abre a tela para cadastrar um Exercicio ou Refeicao, que sera adicionada a
	 * Rotina
	 * 
	 * @param event Clique do Botão
	 */
	@FXML
	void novaRotina(ActionEvent event) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("CDS - Rotina");
		ExecutorCadRotina exeCadRotina = new ExecutorCadRotina();
		exeCadRotina.start(stage);
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
	 * Inicializa a lista de refeicoes e as adiciona as Refeicoes a Tabela
	 * respectiva. Além disso também cria e ajusta as células da tabela para o tipo
	 * de dados que irão mostrar
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listaRefeicao = new ArrayList<RefeicaoDTO>();

		// formata as celulas da Tabela
		alimentoSeg.setCellValueFactory(new PropertyValueFactory<>("listaAlimento"));
		qtdSeg.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		unSeg.setCellValueFactory(new PropertyValueFactory<>("unidadeMedida"));
		inicioSeg.setCellValueFactory(new PropertyValueFactory<>("horarioInicio"));
		terminoSeg.setCellValueFactory(new PropertyValueFactory<>("horarioFim"));
		calorSeg.setCellValueFactory(new PropertyValueFactory<>("calorias"));

		// formata a coluna do Inicio, para a data ficar com o formato "HH:mm"
		inicioSeg.setCellFactory((TableColumn<RefeicaoDTO, Date> column) -> {
			return new TableCell<RefeicaoDTO, Date>() {
				protected void updateItem(Date item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(null);
					} else {
						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
						setText(sdf.format((item)));
					}
				}
			};
		});

		// formata a coluna do Fim, para a data ficar com o formato "HH:mm"
		terminoSeg.setCellFactory((TableColumn<RefeicaoDTO, Date> column) -> {
			return new TableCell<RefeicaoDTO, Date>() {
				protected void updateItem(Date item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(null);
					} else {
						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
						setText(sdf.format((item)));
					}
				}
			};
		});

		// adiciona as refeicoes a tabela
		RefeicaoDTO dto = new RefeicaoDTO();
		refeicaoSegunda.setItems(dto.geraListaRefeicao());
	}

}
