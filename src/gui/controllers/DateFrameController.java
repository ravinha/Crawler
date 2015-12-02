package gui.controllers;

import Frazeusz.Frazeusz;
import data.CrawlingData;
import gui.DataFrame;

import javax.swing.*;


/**
 * Created by Rav on 2015-12-02.
 */
public class DateFrameController {

    private CrawlingData crawlingData;
    private DataFrame dataFrame;

    public DateFrameController() {
        this.crawlingData = new CrawlingData();
    }

    public void deleteUrl(){
        String deletedUrl = (String) dataFrame.getInitialDataPanel().getListOfUrlsPane().getSelectedValue();
        crawlingData.getUrls().remove(deletedUrl);

        DefaultListModel model = (DefaultListModel) dataFrame.getInitialDataPanel().getListOfUrlsPane().getModel();
        int selectedIndex = dataFrame.getInitialDataPanel().getListOfUrlsPane().getSelectedIndex();
        if (selectedIndex != -1) {
            model.remove(selectedIndex);
        }
    }

    public void addUrl(){
        crawlingData.getUrls().add(dataFrame.getInitialDataPanel().getAddUrlField().getText());
        ((DefaultListModel) dataFrame.getInitialDataPanel().getListOfUrlsPane().getModel()).addElement(dataFrame.getInitialDataPanel().getAddUrlField().getText());
    }

    public void start() {
        crawlingData.setMaxDepth(Integer.parseInt(dataFrame.getInitialDataPanel().getMaxDepthField().getText()));
        crawlingData.setMaxNumberOfFiles(Integer.parseInt(dataFrame.getInitialDataPanel().getMaxNumberOfFilesField().getText()));
        try {
            Frazeusz.start(crawlingData);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close(){

    }

    public void setDateFrame(DataFrame dataFrame) {
        this.dataFrame = dataFrame;
    }

    public CrawlingData getCrawlingData() {
        return crawlingData;
    }
}
