/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import database.database;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import setting.setting;

/**
 * FXML Controller class
 *
 * @author User
 */
public class HomeController implements Initializable {
    @FXML
    private AnchorPane racine;
    @FXML
    private StackPane root;
    @FXML
    private JFXButton btnHome;
    @FXML
    private JFXButton btnRequest;
    @FXML
    private Label lblnum;
   Connection con;
    database db = new database();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        onActiveHome();
                 con = db.getcon();

        initData();
    }    

    @FXML
    private void onHome(ActionEvent event) {
         onActiveHome();
    }

    @FXML
    private void onRequest(ActionEvent event) {
        onActiveRequest();
    }
    
    
     public void onActiveHome() {
        gotos("/vue/accueil.fxml");
        btnHome.setStyle(setting.activeStyle);
        btnRequest.setStyle(setting.defaultStyle);
    }
        public void onActiveRequest() {
        gotos("/vue/demande.fxml");
        btnHome.setStyle(setting.defaultStyle);
        btnRequest.setStyle(setting.activeStyle);
    }
     
     
     public void gotos(String path) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource(path).openStream());
            AnchorPane anchorPane = fXMLLoader.getRoot();
            root.getChildren().clear();
            root.getChildren().add(anchorPane);
        } catch (IOException ex) {
            System.err.println("error occured " + ex);
        }
    }

    private void initData() {
        try {
            PreparedStatement ps=con.prepareStatement("SELECT count(*) as nb from v_sujet as sujet where sujet.etat=0");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                setting.nbDemande=rs.getString("nb");
                lblnum.setText(setting.nbDemande);
            }
        } catch (Exception e) {
            System.err.println("erreur de lbl num "+e.getMessage());
        }
   
    }
}
