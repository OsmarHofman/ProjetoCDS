package br.edu.ifsc.cds.frames.user.telaRotina;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.DTO.ExercicioDTO;
import br.edu.ifsc.cds.DTO.RefeicaoDTO;
import br.edu.ifsc.cds.classes.domain.Pessoa;
import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.frames.telaLogin.ExecutorLogin;
import br.edu.ifsc.cds.frames.user.telaCadExercicio.ExecutorTelaCadExercicio;
import br.edu.ifsc.cds.frames.user.telaCadRefeicao.ExecutorCadRefeicao;
import br.edu.ifsc.cds.frames.user.telaDados.ExecutorDados;
import br.edu.ifsc.cds.frames.user.telaHistorico.ExecutorHistorico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RotinaController implements Initializable {

	// Pessoa que logou

	private static List<RefeicaoDTO> listaRefeicao;
	private static List<ExercicioDTO> listaExercicio;

	public static List<RefeicaoDTO> getListaRefeicao() {
		return listaRefeicao;
	}

	public static void setListaRefeicao(List<RefeicaoDTO> listaRefeicao) {
		RotinaController.listaRefeicao = listaRefeicao;
	}

	public static void addListaRefeicao(RefeicaoDTO refeicao) {
		RotinaController.listaRefeicao.add(refeicao);
	}

	public static List<ExercicioDTO> getListaExercicio() {
		return listaExercicio;
	}

	public static void setListaExercicio(List<ExercicioDTO> listaExercicio) {
		RotinaController.listaExercicio = listaExercicio;
	}

	public static void addListaExercicio(ExercicioDTO exercicio) {
		RotinaController.listaExercicio.add(exercicio);
	}

	@FXML
	private JFXButton btnAtualizar;

	@FXML
	private TableView<RefeicaoDTO> refeicaoSegunda;

	@FXML
	private TableView<ExercicioDTO> ativFisSegunda;

	@FXML
	private TableColumn<RefeicaoDTO, Float> calorSeg;

	@FXML
	private TableColumn<RefeicaoDTO, String> alimentoSeg;

	@FXML
	private TableColumn<RefeicaoDTO, String> titSeg;

	@FXML
	private TableColumn<RefeicaoDTO, String> unidSeg;

	@FXML
	private TableColumn<RefeicaoDTO, Float> qtdSeg;

	@FXML
	private TableColumn<RefeicaoDTO, Date> inicioSeg;

	@FXML
	private TableColumn<RefeicaoDTO, Date> terminoSeg;

	@FXML
	private TableColumn<ExercicioDTO, String> titEx;

	@FXML
	private TableColumn<ExercicioDTO, Date> iniEx;

	@FXML
	private TableColumn<ExercicioDTO, Date> terEx;

	@FXML
	private TableColumn<ExercicioDTO, Float> calEx;

	@FXML
	private BorderPane paneTela;

	@FXML
	private JFXButton btnLogout;

	@FXML
	private JFXButton btnDados;

	@FXML
	private JFXButton btnCadExercicio;

	@FXML
	private JFXButton btnEditExercicio;

	@FXML
	private JFXButton btnExcExercicio;

	@FXML
	private JFXButton btnCadRefeicao;

	@FXML
	private JFXButton btnEditRefeicao;

	@FXML
	private JFXButton btnExcRefeicao;

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
		RefeicaoDTO refDto = new RefeicaoDTO();
		refeicaoSegunda.setItems(refDto.geraListaRefeicao());

		ExercicioDTO exeDto = new ExercicioDTO();
		ativFisSegunda.setItems(exeDto.geraExercicioDTO());
	}

	/**
	 * Abre a tela para cadastrar um Exercicio, que sera adicionada a Tabela
	 * 
	 * @param event Clique do Botão
	 */
	@FXML
	void novoExercicio(ActionEvent event) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("CDS - Cadastro Exercício");
		ExecutorTelaCadExercicio exeCadExercicio = new ExecutorTelaCadExercicio();
		exeCadExercicio.start(stage);
	}

	/**
	 * Abre a tela para cadastrar uma Refeicao, que sera adicionada a Tabela
	 * 
	 * @param event Clique do Botão
	 */
	@FXML
	void novaRefeicao(ActionEvent event) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setResizable(false);
		stage.setTitle("CDS - Cadastro Exercício");
		ExecutorCadRefeicao exeCadRefeicao = new ExecutorCadRefeicao();
		exeCadRefeicao.start(stage);
	}

	/**
	 * Exclui a Refeicao selecionada na tabela. Verifica antes de excluir a
	 * Refeicao, e após a exclusão a tela é atualizada
	 * 
	 * @param event
	 */
	@FXML
	void excluirRefeicao(ActionEvent event) {
		RefeicaoDTO dto = refeicaoSegunda.getSelectionModel().getSelectedItem();
		int decisaoEx = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir essa Refeicão?");
		if (decisaoEx == 0) {
			RotinaController.getListaRefeicao().remove(dto);
			btnExcRefeicao.setDisable(true);
			this.atualizar(event);
		}

	}

	/**
	 * Exclui o Exercicio selecionado na tabela. Verifica antes de excluir o
	 * Exercicio, e após a exclusão a tela é atualizada
	 * 
	 * @param event
	 */
	@FXML
	void excluirExercicio(ActionEvent event) {
		ExercicioDTO dto = ativFisSegunda.getSelectionModel().getSelectedItem();
		int decisaoEx = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir esse Exercício?");
		if (decisaoEx == 0) {
			RotinaController.getListaExercicio().remove(dto);
			btnExcExercicio.setDisable(true);
			this.atualizar(event);
		}

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
		// instanciando a lista de Refeicoes e Exercicios
		listaRefeicao = new ArrayList<RefeicaoDTO>();
		listaExercicio = new ArrayList<ExercicioDTO>();

		// desabilitando os botoes
		btnEditExercicio.setDisable(true);
		btnEditRefeicao.setDisable(true);
		btnExcExercicio.setDisable(true);
		btnExcRefeicao.setDisable(true);

		// formata as celulas da Tabela
		titSeg.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		alimentoSeg.setCellValueFactory(new PropertyValueFactory<>("listaAlimento"));
		qtdSeg.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		unidSeg.setCellValueFactory(new PropertyValueFactory<>("unidadeMedida"));
		inicioSeg.setCellValueFactory(new PropertyValueFactory<>("horarioInicio"));
		terminoSeg.setCellValueFactory(new PropertyValueFactory<>("horarioFim"));
		calorSeg.setCellValueFactory(new PropertyValueFactory<>("calorias"));
		titEx.setCellValueFactory(new PropertyValueFactory<>("tituloEx"));
		iniEx.setCellValueFactory(new PropertyValueFactory<>("inicioEx"));
		terEx.setCellValueFactory(new PropertyValueFactory<>("fimEx"));
		calEx.setCellValueFactory(new PropertyValueFactory<>("caloriasEx"));

		// formata a coluna do Inicio, para a data ficar com o formato "HH:mm"
		ControleComponente controle = new ControleComponente();
		controle.setCellFactory(inicioSeg);
		controle.setCellFactory(terminoSeg);
        controle.setCellFactory(iniEx);
        controle.setCellFactory(terEx);        
        
		// Verifica se algum item das tabelas de Refeicao e Exercicios foi selecionado
        controle.isSelecionado(refeicaoSegunda, btnExcRefeicao);
        controle.isSelecionado(ativFisSegunda, btnExcExercicio);

		// adiciona as refeicoes a tabela
		RefeicaoDTO dto = new RefeicaoDTO();
		refeicaoSegunda.setItems(dto.geraListaRefeicao());
	}

}
