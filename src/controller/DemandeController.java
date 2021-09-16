/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXTextField;
import database.database;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import model.EtudiantModel;

/**
 * FXML Controller class
 *
 * @author User
 */
public class DemandeController implements Initializable {

    @FXML
    private TableView<EtudiantModel> table;
    @FXML
    private TableColumn<EtudiantModel, String> colmat;
    @FXML
    private TableColumn<EtudiantModel, String> colnom;
    @FXML
    private TableColumn<EtudiantModel, String> colprenom;
    @FXML
    private TableColumn<EtudiantModel, String> colsexe;
    @FXML
    private JFXTextField trecherche;
    @FXML
    private ImageView irecherche;
    Connection con;
    database db = new database();

    ObservableList<EtudiantModel> o = FXCollections.observableArrayList();
    @FXML
    private StackPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        con = db.getcon();
        irecherche.setImage(new Image("/images/search.png"));
        initCellule();
    }

    @FXML
    private void onSearch(MouseEvent event) {
        if(trecherche.getText().equals("")){
            getData();
        }else{
            getData2();
        }
    }

    private void initCellule() {
        colmat.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colsexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));

        getData();

        table.getSelectionModel().selectedIndexProperty().addListener((obs, old, newv) -> {
            gotoDetail();
        });

    }

    public void getData() {
        table.getItems().clear();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM `v_sujet` WHERE `etat`=0");

            ResultSet rs = ps.executeQuery();

            int n = 1;

            while (rs.next()) {
                o.add(new EtudiantModel(rs.getString("mat_etudiant"), rs.getString("nom_etudiant"), rs.getString("prenom_etudiant"), rs.getString("sexe_etudiant")));

                n++;
            }

        } catch (Exception e) {
            System.err.println("erreur " + e.getMessage());
        }

        table.setItems(o);
    }

    private void gotoDetail() {
        EtudiantModel e = table.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource("/vue/detail.fxml").openStream());
            DetailController cont = fXMLLoader.getController();
            cont.initData(e, 2);
            AnchorPane anchorPane = fXMLLoader.getRoot();
            root.getChildren().clear();
            root.getChildren().add(anchorPane);
        } catch (IOException ex) {
            System.err.println("error occured " + ex);
        }
    }

    public void getData2() {
        table.getItems().clear();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM `t_etudiant` WHERE mat_etudiant like ?");
            ps.setString(1, trecherche.getText() + "%");
            ResultSet rs = ps.executeQuery();

            int n = 1;

            while (rs.next()) {
                o.add(new EtudiantModel(rs.getString("mat_etudiant"), rs.getString("nom"), rs.getString("prenom"), rs.getString("sexe")));

                n++;
            }

        } catch (Exception e) {
            System.err.println("erreur " + e.getMessage());
        }

        table.setItems(o);
    }

}
