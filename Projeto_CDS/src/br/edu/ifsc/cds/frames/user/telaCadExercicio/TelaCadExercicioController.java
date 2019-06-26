package br.edu.ifsc.cds.frames.user.telaCadExercicio;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;

import br.edu.ifsc.cds.DAO.ExercicioDAO;
import br.edu.ifsc.cds.DTO.ExercicioDTO;
import br.edu.ifsc.cds.classes.domain.Exercicio;
import br.edu.ifsc.cds.classes.domain.Horario;
import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.frames.user.telaRotina.RotinaController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TelaCadExercicioController implements Initializable {

	@FXML
	private JFXButton btnSalvarExercicio;

	@FXML
	private TableColumn<ExercicioDTO, String> colNome;

	@FXML
	private TableColumn<ExercicioDTO, Float> colCaloria;

	@FXML
	private TableColumn<ExercicioDTO, Integer> colId;

	@FXML
	private TableColumn<ExercicioDTO, Date> colInicio;

	@FXML
	private TableColumn<ExercicioDTO, Date> colFim;

	@FXML
	private TableView<ExercicioDTO> tbvExercicio;

	@FXML
	private ChoiceBox<String> boxDiaSemana;

	@FXML
	private ChoiceBox<String> boxExercicios;

	@FXML
	private JFXButton btnVoltar;

	@FXML
	private TextField txtInicio;

	@FXML
	private TextField txtFim;

	/**
	 * A partir dos campos na tela, converte e cria um objeto {@link ExercicioDTO}
	 * para inserir na lista de Exercicios da Rotina
	 * 
	 * @param event Clique do botão
	 * @throws ParseException
	 */

	@FXML
	void salvarExercicio(ActionEvent event) throws ParseException {
		// pega os dados da inteface gráfica
		String titulo = boxExercicios.getValue();
		String diaSemana = boxDiaSemana.getValue();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date horarioInicio = new Date();
		Date horarioFim = new Date();
		try {
			horarioInicio = sdf.parse(txtInicio.getText());
			horarioFim = sdf.parse(txtFim.getText());
		} catch (ParseException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Data Inválida");
		}

		// consulta no banco a partir do nome do exercicio, para recuperar seu
		// gastoCaloria
		ExercicioDAO exeDao = new ExercicioDAO();
		Exercicio exercicioBox = exeDao.retrieveDadosExer(titulo);
		float gastocalorias = exercicioBox.getGastoCaloria();

		// constroi o objeto ExercicioDTO
		ExercicioDTO dt = new ExercicioDTO(titulo, gastocalorias, horarioInicio, horarioFim);
		Horario horario = new Horario();
		// compara o horario para verificar se há alguma refeicao no mesmo horario
		if (horario.verificaRefeicaoHorario(horarioInicio, horarioFim, diaSemana)) {
			RotinaController.addListaExercicio(dt);
			JOptionPane.showMessageDialog(null, "Exercicio Cadastrado com sucesso");
			ControleComponente controle = new ControleComponente();
			controle.fechaBotao(btnSalvarExercicio);
		} else {
			JOptionPane.showMessageDialog(null, "Data de Inicio/Fim inválido(s)");
		}

	}

	/**
	 * Adiciona o Exercicio na tabela para visualização
	 * 
	 * @param event Clique do Botão
	 * @throws ParseException
	 */

	/**
	 * Inicializa os dias da semana e os exercicios nas {@link ChoiceBox}
	 * respectivas. Além disso também cria e ajusta as células da tabela para o tipo
	 * de dados que irão mostrar
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		boxDiaSemana.getItems().add("Segunda-Feira");
		boxDiaSemana.getItems().add("Terça-Feira");
		boxDiaSemana.getItems().add("Quarta-Feira");
		boxDiaSemana.getItems().add("Quinta-Feira");
		boxDiaSemana.getItems().add("Sexta-Feira");
		boxDiaSemana.getItems().add("Sábado");
		boxDiaSemana.getItems().add("Domingo");

		ExercicioDAO dao = new ExercicioDAO();
		List<Exercicio> exercicios = dao.retrieveAll();
		List<String> exerciciosNome = new ArrayList<>();
		for (Exercicio alimentoLista : exercicios) {
			exerciciosNome.add(alimentoLista.getNome());
		}
		ObservableList<String> lista = FXCollections.observableArrayList(exerciciosNome);
		boxExercicios.setItems(lista);

	}

	/**
	 * Fecha a tela atual e abre a tela de Cadastro de Rotina novamente
	 * 
	 * @param event Clique do Botão
	 */
	@FXML
	void voltar(ActionEvent event) {
		ControleComponente controle = new ControleComponente();
		// fecha a tela
		controle.fechaBotao(btnVoltar);
	}

}
