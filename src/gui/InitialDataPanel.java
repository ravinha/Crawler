package gui;

import gui.controllers.DateFrameController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rav on 2015-11-25.
 */
public class InitialDataPanel extends JPanel{
    private JButton deleteButton;
    private JButton submitButton;
    private JButton addButton;
    private JLabel maxDepthLabel;
    private JLabel maxNumberOfFilesLabel;
    private JLabel addUrlLabel;
    private JTextField maxDepthField;
    private JTextField addUrlField;
    private JTextField maxNumberOfFilesField;
    private JList listOfUrlsPane;

    private DateFrameController dateFrameController;

    public InitialDataPanel(DateFrameController dateFrameController) {
        this.dateFrameController = dateFrameController;
        setPreferredSize(new Dimension(100, 100));
        this.initComponents();
    }

    private void initComponents(){
        this.deleteButton = new JButton("Delete");
        this.submitButton = new JButton("Submit");
        this.addButton = new JButton("Add");
        this.maxDepthLabel = new JLabel("Max Depth:");
        this.maxNumberOfFilesLabel = new JLabel("Max number of files:");
        this.addUrlLabel = new JLabel("Add URL:");
        this.maxDepthField = new JTextField();
        this.maxNumberOfFilesField = new JTextField();
        this.addUrlField = new JTextField();
        this.listOfUrlsPane = new JList();
    }

    private void addListners(){
        addButton.addActionListener(e -> dateFrameController.addUrl());
        deleteButton.addActionListener(e -> dateFrameController.deleteUrl());
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    public JLabel getMaxDepthLabel() {
        return maxDepthLabel;
    }

    public void setMaxDepthLabel(JLabel maxDepthLabel) {
        this.maxDepthLabel = maxDepthLabel;
    }

    public JLabel getMaxNumberOfFilesLabel() {
        return maxNumberOfFilesLabel;
    }

    public void setMaxNumberOfFilesLabel(JLabel maxNumberOfFilesLabel) {
        this.maxNumberOfFilesLabel = maxNumberOfFilesLabel;
    }

    public JLabel getAddUrlLabel() {
        return addUrlLabel;
    }

    public void setAddUrlLabel(JLabel addUrlLabel) {
        this.addUrlLabel = addUrlLabel;
    }

    public JTextField getMaxDepthField() {
        return maxDepthField;
    }

    public void setMaxDepthField(JTextField maxDepthField) {
        this.maxDepthField = maxDepthField;
    }

    public JTextField getAddUrlField() {
        return addUrlField;
    }

    public void setAddUrlField(JTextField addUrlField) {
        this.addUrlField = addUrlField;
    }

    public JTextField getMaxNumberOfFilesField() {
        return maxNumberOfFilesField;
    }

    public void setMaxNumberOfFilesField(JTextField maxNumberOfFilesField) {
        this.maxNumberOfFilesField = maxNumberOfFilesField;
    }

    public JList getListOfUrlsPane() {
        return listOfUrlsPane;
    }

    public void setListOfUrlsPane(JList listOfUrlsPane) {
        this.listOfUrlsPane = listOfUrlsPane;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

}
