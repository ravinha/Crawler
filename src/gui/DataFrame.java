package gui;

import data.CrawlingData;
import javax.swing.*;

/**
 * Created by Rav on 2015-11-25.
 */
public class DataFrame extends JFrame {
    private JButton submitButton;
    private CrawlingData crawlingData;
    public DataFrame() {
        super("Frazeusz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        add(new InitialDataPanel(crawlingData));
        add(new PatternMatcherPanel());
    }
}
