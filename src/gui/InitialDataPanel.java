package gui;

import data.CrawlingData;

import javax.swing.*;
import java.util.List;

/**
 * Created by Rav on 2015-11-25.
 */
public class InitialDataPanel extends JPanel{
    private JButton deleteButton;
    private JButton submitButton;
    private JLabel maxDepthLabel;
    private JLabel maxNumberOfFilesLabel;
    private JLabel addUrlLabel;
    private JTextField maxDepthField;
    private JTextField addUrlField;
    private JTextField maxNumberOfFilesField;
    private JScrollPane listOfUrlsPane;
    private List<String> urls;
    public InitialDataPanel(CrawlingData crawlingData) {
    }
}
