/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSnackbar;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import model.EtudiantModel;
import setting.setting;

/**
 * FXML Controller class
 *
 * @author User
 */
public class DetailController implements Initializable {

    @FXML
    private Label enom;
    @FXML
    private Label eprenom;
    @FXML
    private Label esexe;
    @FXML
    private Label titre;
    @FXML
    private Label domaine;
    @FXML
    private Label directeur;
    @FXML
    private Label codirecteur;
    @FXML
    private Label etat;
    @FXML
    private Label date;
    @FXML
    private JFXButton btnConfirmer;
    @FXML
    private JFXButton btnRejet;
    @FXML
    private AnchorPane pstate;
    @FXML
    private Text state;
    @FXML
    private StackPane root;
    @FXML
    private ImageView iclose;
    Connection con;
    database db = new database();
    int et = -1;
    int page = -1;
    int emat = -1;
    @FXML
    private Label lnoInfo;
    @FXML
    private Pane otherinfo;
    @FXML
    private AnchorPane p2;
EtudiantModel e;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        iclose.setImage(new Image("/images/close.png"));

        con = db.getcon();

    }

    @FXML
    private void onConfirmer(ActionEvent event) {
        updateData(1);
    }

    @FXML
    private void onRejet(ActionEvent event) {
        updateData(2);
    }

    @FXML
    private void onReturn(MouseEvent event) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource(this.page == 1 ? "/vue/accueil.fxml" : "/vue/demande.fxml").openStream());
            // DetailController cont=
            AnchorPane anchorPane = fXMLLoader.getRoot();
            root.getChildren().clear();
            root.getChildren().add(anchorPane);
        } catch (IOException ex) {
            System.err.println("error occured " + ex);
        }
    }

    public void initData(EtudiantModel e, int page) {
        System.out.println("Etudiant " + e.getNom());
        enom.setText(e.getNom());
        eprenom.setText(e.getPrenom());
        esexe.setText(e.getSexe());
        getData(Integer.parseInt(e.getMatricule()));
        this.page = page;
        this.emat = Integer.parseInt(e.getMatricule());
        this.e=e;

    }

    public void getData(int mat) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM `v_sujet` WHERE `mat_etudiant`=?");
            ps.setInt(1, mat);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                otherinfo.setVisible(true);
                lnoInfo.setVisible(false);
                pstate.setVisible(true);
                String current_state = rs.getInt("etat") == 0 ? "Non Confirmé" : rs.getInt("etat") == 1 ? "Confirmé" : "rejeter";
                titre.setText(rs.getString("sujet"));
                domaine.setText(rs.getString("domaine"));
                directeur.setText(rs.getString("prenom_prof") + " " + rs.getString("nom_prof"));
                codirecteur.setText(rs.getString("prenom_assistant") + " " + rs.getString("nom_assistant"));
                etat.setText(current_state);
                state.setText(current_state);
                date.setText(rs.getString("date"));
                this.et = rs.getInt("etat");
                pstate.setStyle(this.et == 0 ? setting.NConf : this.et == 1 ? setting.OConf : setting.RConf);

            } else {
                System.err.println("Pas de sujet");
                otherinfo.setVisible(false);
                lnoInfo.setVisible(true);
                pstate.setVisible(false);

            }
            btnConfirmer.setVisible(this.et == 0);
            btnRejet.setVisible(this.et == 0);

        } catch (Exception e) {
            System.err.println("erreur " + e.getMessage());
        }

    }

    private void updateData(int level) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE `t_sujet` SET `etat` = ? WHERE `t_sujet`.`mat_etudiant` = ?;");
            ps.setInt(1, level);
            ps.setInt(2, this.emat);
            int r = ps.executeUpdate();
            System.out.println("Mise à jour reussi!! " + r);
            showSnack(level==1?"Sujet confirmé avec succés":"Sujet rejeté avec succés");
            initData(e, page);
        } catch (Exception e) {
            System.err.println("Echec de mise à jour !");
        }
    }

 
    
    
    public void showSnack(String msg) {
        JFXSnackbar snackBar = new JFXSnackbar(p2);
      snackBar.show(msg, 4000);
      
    }

}
