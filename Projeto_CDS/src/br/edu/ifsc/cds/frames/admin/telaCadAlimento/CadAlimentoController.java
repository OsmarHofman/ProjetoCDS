package br.edu.ifsc.cds.frames.admin.telaCadAlimento;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import br.edu.ifsc.cds.DTO.InfoNutricionalDTO;
import br.edu.ifsc.cds.classes.domain.Alimento;
import br.edu.ifsc.cds.classes.domain.InfoNutricional;
import br.edu.ifsc.cds.classes.security.ControleComponente;
import br.edu.ifsc.cds.services.AlimentoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class CadAlimentoController implements Initializable {

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

	private Integer idAlimento;

	@FXML
	private JFXTextField txtNomeAli;

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
		String nome = txtNomeAli.getText();
		InfoNutricional info = this.getCampos();
		Alimento alimento = new Alimento();
		alimento.setNome(nome);
		alimento.setInfoNutri(info);
		alimento.setCaloriaTotal(info.getCaloria());
		AlimentoService service = new AlimentoService();

		if (btnAdd.getText().matches("Adicionar")) {
			// tenta inserir o alimento no Banco
			boolean insercao_alimento = service.criaAlimento(alimento);
			// Caso o alimento seja inserido com sucesso
			if (insercao_alimento) {
				JOptionPane.showMessageDialog(null, "Alimento cadastrado com Sucesso!");
				ctrlComp.fechaBotao(btnAdd);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar o Alimento");
			}
		} else {
			alimento.setId(idAlimento);
			// tenta atualizar o alimento no Banco
			boolean atualizacao_alimento = service.atualizaAlimento(alimento);
			// Caso o alimento seja atualizado com sucesso
			if (atualizacao_alimento) {
				JOptionPane.showMessageDialog(null, "Alimento atualizado com Sucesso!");
				ctrlComp.fechaBotao(btnAdd);
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar o Alimento");
			}
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	private InfoNutricional getCampos() {
		float caloria = Float.parseFloat(txtCaloria.getText());
		float carboidrato = Float.parseFloat(txtCarboidrato.getText());
		float proteina = Float.parseFloat(txtProteina.getText());
		float gord_totais = Float.parseFloat(txtGordTot.getText());
		float gord_trans = Float.parseFloat(txtGordTrans.getText());
		float gord_sat = Float.parseFloat(txtGordSat.getText());
		float fibras = Float.parseFloat(txtFibras.getText());
		float sodio = Float.parseFloat(txtSodio.getText());
		return new InfoNutricional.Builder(null).caloria(caloria).carboidrato(carboidrato).proteinas(proteina)
				.gordurasTotais(gord_totais).gordurasTrans(gord_trans).gordurasSaturadas(gord_sat).fibras(fibras)
				.sodio(sodio).build();
	}

	public void setCampos(InfoNutricionalDTO dto) {
		txtNomeAli.setText(dto.getNome());
		txtCaloria.setText(String.valueOf(dto.getCaloria()));
		txtCarboidrato.setText(String.valueOf(dto.getCarboidrato()));
		txtProteina.setText(String.valueOf(dto.getProteinas()));
		txtGordTot.setText(String.valueOf(dto.getGordurasTotais()));
		txtGordTrans.setText(String.valueOf(dto.getGordurasTrans()));
		txtGordSat.setText(String.valueOf(dto.getGordurasSaturadas()));
		txtFibras.setText(String.valueOf(dto.getFibras()));
		txtSodio.setText(String.valueOf(dto.getSodio()));
		idAlimento = dto.getId();
		btnAdd.setText("Salvar");
	}

}
