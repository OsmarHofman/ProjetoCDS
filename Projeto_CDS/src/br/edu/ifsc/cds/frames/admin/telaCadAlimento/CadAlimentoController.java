package br.edu.ifsc.cds.frames.admin.telaCadAlimento;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.edu.ifsc.cds.classes.domain.Alimento;
import br.edu.ifsc.cds.classes.domain.InfoNutricional;
import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.services.AlimentoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CadAlimentoController {

	@FXML
	private JFXTextField txtGordSat;

	@FXML
	private JFXTextField txtGordTot;

	@FXML
	private JFXTextField txtCarboidrato;

	@FXML
	private JFXTextField txtProteina;

	@FXML
	private JFXTextField txtFibras;

	@FXML
	private JFXTextField txtCaloria;

	@FXML
	private JFXTextField txtGordTrans;

	@FXML
	private JFXTextField txtNomeExer;

	@FXML
	private JFXTextField txtSodio;

	@FXML
	private JFXButton btnAdd;

	@FXML
	private JFXButton btnVoltar;

	ControleComponente ctrlComp = new ControleComponente();

	/**
	 * A partir dos campos na tela, cria um objeto {@link InfoNutricional} e um
	 * {@link Alimento} para inserir um alimento no banco de dados
	 * 
	 * @param event Clique do botão
	 */
	@FXML
	void adicionar(ActionEvent event) {
		String nome = txtNomeExer.getText();
		float caloria = Float.parseFloat(txtCaloria.getText());
		float carboidrato = Float.parseFloat(txtCarboidrato.getText());
		float proteina = Float.parseFloat(txtProteina.getText());
		float gord_totais = Float.parseFloat(txtGordTot.getText());
		float gord_trans = Float.parseFloat(txtGordTrans.getText());
		float gord_sat = Float.parseFloat(txtGordSat.getText());
		float fibras = Float.parseFloat(txtFibras.getText());
		float sodio = Float.parseFloat(txtSodio.getText());
		InfoNutricional info = new InfoNutricional.Builder(null).caloria(caloria).carboidrato(carboidrato)
				.proteinas(proteina).gordurasTotais(gord_totais).gordurasTrans(gord_trans).gordurasSaturadas(gord_sat)
				.fibras(fibras).sodio(sodio).build();
		Alimento alimento = new Alimento();
		alimento.setNome(nome);
		alimento.setInfoNutri(info);
		alimento.setCaloriaTotal(info.getCaloria());
		AlimentoService service = new AlimentoService();
		// tenta inserir o alimento no Banco
		boolean insercao_alimento = service.criaAlimento(alimento);
		// Caso o alimento seja inserido com sucesso
		if (insercao_alimento) {
			JOptionPane.showMessageDialog(null, "Alimento cadastrado com Sucesso!");
			ctrlComp.fechaBotao(btnAdd);
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o Alimento");
		}
	}

	/**
	 * Fecha esta tela e Retorna a tela que a chamou
	 * 
	 * @param Clique no botão
	 */
	@FXML
	void voltar(ActionEvent event) {
		ControleComponente controle = new ControleComponente();
		controle.fechaBotao(btnVoltar);
	}

}
