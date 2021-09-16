/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class SujetModel {
    private String mat_etudiant;
    private String nom_etudiant;
    private String prenom_etudiant;
    private String sexe_etudiant;
    private String mat_prof;
    private String nom_prof;
    private String prenom_prof;
    private String email_prof;
    private String id_ass;
    private String nom_ass;
    private String prenom_ass;
    private String sexe_ass;
    private String mail_ass;
    private String sujet;
    private String domaine;
    private String etat;
    private String date;

    public SujetModel() {
    }

    public SujetModel(String mat_etudiant, String nom_etudiant, String prenom_etudiant, String sexe_etudiant, String mat_prof, String nom_prof, String prenom_prof, String email_prof, String id_ass, String nom_ass, String prenom_ass, String sexe_ass, String mail_ass, String sujet, String domaine, String etat, String date) {
        this.mat_etudiant = mat_etudiant;
        this.nom_etudiant = nom_etudiant;
        this.prenom_etudiant = prenom_etudiant;
        this.sexe_etudiant = sexe_etudiant;
        this.mat_prof = mat_prof;
        this.nom_prof = nom_prof;
        this.prenom_prof = prenom_prof;
        this.email_prof = email_prof;
        this.id_ass = id_ass;
        this.nom_ass = nom_ass;
        this.prenom_ass = prenom_ass;
        this.sexe_ass = sexe_ass;
        this.mail_ass = mail_ass;
        this.sujet = sujet;
        this.domaine = domaine;
        this.etat = etat;
        this.date = date;
    }
    public SujetModel(String mat_etudiant, String nom_etudiant, String prenom_etudiant, String mat_prof, String nom_prof, String prenom_prof,  String nom_ass, String prenom_ass, String sujet, String domaine, String etat, String date) {
        this.mat_etudiant = mat_etudiant;
        this.nom_etudiant = nom_etudiant;
        this.prenom_etudiant = prenom_etudiant;
        this.mat_prof = mat_prof;
        this.nom_prof = nom_prof;
        this.prenom_prof = prenom_prof;
        this.nom_ass = nom_ass;
        this.prenom_ass = prenom_ass;
        this.sujet = sujet;
        this.domaine = domaine;
        this.etat = etat;
        this.date = date;
    }

    /**
     * @return the mat_etudiant
     */
    public String getMat_etudiant() {
        return mat_etudiant;
    }

    /**
     * @param mat_etudiant the mat_etudiant to set
     */
    public void setMat_etudiant(String mat_etudiant) {
        this.mat_etudiant = mat_etudiant;
    }

    /**
     * @return the nom_etudiant
     */
    public String getNom_etudiant() {
        return nom_etudiant;
    }

    /**
     * @param nom_etudiant the nom_etudiant to set
     */
    public void setNom_etudiant(String nom_etudiant) {
        this.nom_etudiant = nom_etudiant;
    }

    /**
     * @return the prenom_etudiant
     */
    public String getPrenom_etudiant() {
        return prenom_etudiant;
    }

    /**
     * @param prenom_etudiant the prenom_etudiant to set
     */
    public void setPrenom_etudiant(String prenom_etudiant) {
        this.prenom_etudiant = prenom_etudiant;
    }

    /**
     * @return the sexe_etudiant
     */
    public String getSexe_etudiant() {
        return sexe_etudiant;
    }

    /**
     * @param sexe_etudiant the sexe_etudiant to set
     */
    public void setSexe_etudiant(String sexe_etudiant) {
        this.sexe_etudiant = sexe_etudiant;
    }

    /**
     * @return the mat_prof
     */
    public String getMat_prof() {
        return mat_prof;
    }

    /**
     * @param mat_prof the mat_prof to set
     */
    public void setMat_prof(String mat_prof) {
        this.mat_prof = mat_prof;
    }

    /**
     * @return the nom_prof
     */
    public String getNom_prof() {
        return nom_prof;
    }

    /**
     * @param nom_prof the nom_prof to set
     */
    public void setNom_prof(String nom_prof) {
        this.nom_prof = nom_prof;
    }

    /**
     * @return the prenom_prof
     */
    public String getPrenom_prof() {
        return prenom_prof;
    }

    /**
     * @param prenom_prof the prenom_prof to set
     */
    public void setPrenom_prof(String prenom_prof) {
        this.prenom_prof = prenom_prof;
    }

    /**
     * @return the email_prof
     */
    public String getEmail_prof() {
        return email_prof;
    }

    /**
     * @param email_prof the email_prof to set
     */
    public void setEmail_prof(String email_prof) {
        this.email_prof = email_prof;
    }

    /**
     * @return the id_ass
     */
    public String getId_ass() {
        return id_ass;
    }

    /**
     * @param id_ass the id_ass to set
     */
    public void setId_ass(String id_ass) {
        this.id_ass = id_ass;
    }

    /**
     * @return the nom_ass
     */
    public String getNom_ass() {
        return nom_ass;
    }

    /**
     * @param nom_ass the nom_ass to set
     */
    public void setNom_ass(String nom_ass) {
        this.nom_ass = nom_ass;
    }

    /**
     * @return the prenom_ass
     */
    public String getPrenom_ass() {
        return prenom_ass;
    }

    /**
     * @param prenom_ass the prenom_ass to set
     */
    public void setPrenom_ass(String prenom_ass) {
        this.prenom_ass = prenom_ass;
    }

    /**
     * @return the sexe_ass
     */
    public String getSexe_ass() {
        return sexe_ass;
    }

    /**
     * @param sexe_ass the sexe_ass to set
     */
    public void setSexe_ass(String sexe_ass) {
        this.sexe_ass = sexe_ass;
    }

    /**
     * @return the mail_ass
     */
    public String getMail_ass() {
        return mail_ass;
    }

    /**
     * @param mail_ass the mail_ass to set
     */
    public void setMail_ass(String mail_ass) {
        this.mail_ass = mail_ass;
    }

    /**
     * @return the sujet
     */
    public String getSujet() {
        return sujet;
    }

    /**
     * @param sujet the sujet to set
     */
    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    /**
     * @return the domaine
     */
    public String getDomaine() {
        return domaine;
    }

    /**
     * @param domaine the domaine to set
     */
    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    /**
     * @return the etat
     */
    public String getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(String etat) {
        this.etat = etat;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    
}
