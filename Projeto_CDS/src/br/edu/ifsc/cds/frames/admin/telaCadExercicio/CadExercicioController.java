package br.edu.ifsc.cds.frames.admin.telaCadExercicio;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.edu.ifsc.cds.DTO.AtividadeFisicaDTO;
import br.edu.ifsc.cds.classes.domain.Exercicio;
import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.classes.security.Validacao;
import br.edu.ifsc.cds.services.ExercicioService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class CadExercicioController implements Initializable {

	@FXML
	private JFXButton btnAdicionar;

	@FXML
	private JFXButton btnVoltar;

	@FXML
	private JFXTextField txtGasto;

	private Integer idExercicio;

	@FXML
	private JFXTextField txtNomeExer;

	@FXML
	private JFXTextField txtMet;

	ControleComponente ctrlComp = new ControleComponente();

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
		ExercicioService service = new ExercicioService();

		// Caso esteja cadastrando um Exercicio
		if (btnAdicionar.getText().matches("Adicionar")) {
			// tenta inserir o exercicio no Banco
			boolean insercao_exercicio = service.criaExercicio(exercicio);

			// Caso o exercicio seja inserido com sucesso
			if (insercao_exercicio) {
				JOptionPane.showMessageDialog(null, "Exercicio cadastrado com Sucesso!");
				ctrlComp.fechaBotao(btnVoltar);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar o Exercicio");
			}
			// Caso esteja atualizando um Exercicio
		} else {
			exercicio.setId(idExercicio);
			// tenta atualizar o exercicio no Banco
			boolean atualizacao_exercicio = service.atualizaExercicio(exercicio);

			// Caso o exercicio seja atualizado com sucesso
			if (atualizacao_exercicio) {
				JOptionPane.showMessageDialog(null, "Exercicio atualizado com Sucesso!");
				ctrlComp.fechaBotao(btnVoltar);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar o Exercicio");
			}
		}

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

	/**
	 * Insere os valores nos campos da interface, de acordo com um objeto
	 * {@link AtividadeFisicaDTO}
	 * 
	 * @param dto Objeto {@link AtividadeFisicaDTO} com os dados a serem inseridos
	 *            nos campos
	 */
	public void setCampos(AtividadeFisicaDTO dto) {
		txtNomeExer.setText(dto.getNome());
		txtGasto.setText(String.valueOf(dto.getGastoCaloria()));
		txtMet.setText(String.valueOf(dto.getMet()));
		idExercicio = dto.getId();
		btnAdicionar.setText("Salvar");
	}

}
