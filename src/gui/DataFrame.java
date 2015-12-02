package gui;

import gui.controllers.DateFrameController;

import javax.swing.*;
import java.awt.event.WindowEvent;

/**
 * Created by Rav on 2015-11-25.
 */
public class DataFrame extends JFrame {
    private JButton submitButton;
    private JButton closeButton;
    private JPanel monitorJPanel;
    private JPanel patternMatcherJPanel;
    private InitialDataPanel initialDataPanel;

    private DateFrameController dateFrameController;

    public DataFrame(DateFrameController dateFrameController) {
        super("Frazeusz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.dateFrameController = dateFrameController;
        dateFrameController.setDateFrame(this);
        initComponents();
        addListeners();
        add(initialDataPanel);
//        add(monitorJPanel);
//        add(patternMatcherJPanel);
    }

    private void initComponents() {
        submitButton = new JButton("Start");
        closeButton = new JButton("Close");
        initialDataPanel = new InitialDataPanel(dateFrameController);
    }

    private void addListeners() {
        addSubmitListener();
        addCloseListener();
    }

    private void addSubmitListener() {
        submitButton.addActionListener(e -> {
            dateFrameController.start();
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });
    }

    private void addCloseListener() {
        closeButton.addActionListener(e -> {
            dateFrameController.close();
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });
    }

    public InitialDataPanel getInitialDataPanel() {
        return initialDataPanel;
    }

    public JPanel getPatternMatcherJPanel() {
        return patternMatcherJPanel;
    }

    public JPanel getMonitorJPanel() {
        return monitorJPanel;
    }

}
