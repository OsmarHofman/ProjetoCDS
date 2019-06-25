package br.edu.ifsc.cds.frames.admin.telaCadExercicio;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.edu.ifsc.cds.DAO.ExercicioDAO;
import br.edu.ifsc.cds.classes.domain.Exercicio;
import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.classes.security.Validacao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class CadExercicioController implements Initializable {

	@FXML
	private JFXButton btnVoltar;

	@FXML
	private JFXTextField txtGasto;

	@FXML
	private JFXTextField txtNomeExer;

	@FXML
	private JFXTextField txtMet;

	/**
	 * A partir dos campos na tela, cria um objeto {@link Exercicio} para inserir um
	 * Exercicio no banco de dados
	 * 
	 * @param event Clique do botão
	 */
	@FXML
	void addExercicio(ActionEvent event) {
		String nome = txtNomeExer.getText();
		float gasto = Float.parseFloat(txtGasto.getText());
		float met = Float.parseFloat(txtMet.getText());
		Exercicio exercicio = new Exercicio();
		exercicio.setNome(nome);
		exercicio.setGastoCaloria(gasto);
		exercicio.setMet(met);
		ExercicioDAO dao = new ExercicioDAO();
		dao.create(exercicio);
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
	}

	/**
	 * Fecha esta tela e Retorna a tela que a chamou
	 * 
	 * @param Clique no botão
	 */
	@FXML
	void cancelar(ActionEvent event) {
		ControleComponente controle = new ControleComponente();
		controle.fechaBotao(btnVoltar);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// inicia os validadores dos Text Field da tela
		Validacao.criaValidadorTxtField(Arrays.asList(txtNomeExer, txtMet, txtGasto));

	}

}
