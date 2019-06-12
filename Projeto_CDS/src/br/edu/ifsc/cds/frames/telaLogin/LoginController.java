package br.edu.ifsc.cds.frames.telaLogin;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class LoginController implements Initializable{

    @FXML
    private JFXPasswordField txtSenha;

    @FXML
    private JFXTextField txtPesoCad;

    @FXML
    private JFXTextField txtEmailCad;

    @FXML
    private JFXButton btnMSignUp;

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private JFXButton btnMSignin;

    @FXML
    private JFXPasswordField txtxSenhaCad;

    @FXML
    private JFXTextField txtAlturaCad;

    @FXML
    private JFXButton txtSignin;

    @FXML
    private JFXTextField txtUsuario;

    @FXML
    private JFXTextField txtNomeCad;
    
    @FXML
    private AnchorPane anchorSignIn;
    
    @FXML
    private AnchorPane anchorSignUp;
    
    // Métodos

     @FXML
    void signUp(ActionEvent event) {
        anchorSignUp.setVisible(true);
    }

    @FXML
    void signin(ActionEvent event) {

    }
    
    @FXML
    void mSignin(ActionEvent event) {
		anchorSignIn.setVisible(true);
		anchorSignUp.setVisible(false);
    }

    @FXML
    void mSignUp(ActionEvent event) {
		anchorSignIn.setVisible(false);
		anchorSignUp.setVisible(true);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		anchorSignIn.setVisible(true);
		anchorSignUp.setVisible(false);
	}


}
