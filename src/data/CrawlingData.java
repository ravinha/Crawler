package data;

import java.util.List;

/**
 * Created by Rav on 2015-11-25.
 */
public class CrawlingData {
    private List<String> urls;
    private int maxDepth;
    private int maxNumberOfFiles;

    public CrawlingData(){

    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public int getMaxNumberOfFiles() {
        return maxNumberOfFiles;
    }

    public void setMaxNumberOfFiles(int maxNumberOfFiles) {
        this.maxNumberOfFiles = maxNumberOfFiles;
    }
}
