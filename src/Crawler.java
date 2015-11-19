import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.net.URL;

public class Crawler {

    private LinkedBlockingQueue<Runnable> tasks;
    private HashSet downloadedURLS;
    ExecutorService executor;
    private int counter;
    private int maxSites;

    public Crawler(int workersPool, int maxSites) {
        this.tasks = new LinkedBlockingQueue<>();
        this.executor = Executors.newFixedThreadPool(workersPool);
        this.counter = 0;
        this.maxSites = maxSites;
        this.downloadedURLS = new HashSet();
    }

    public void putURL(URL url) throws InterruptedException {
        tasks.put(new DownloadTask(url));
    }

    public void startCrawling() throws InterruptedException {
        DownloadTask task;
        URL url;
        while(notFinished()) {
            task = (DownloadTask) tasks.take();
            url = task.getURL();
            if(isDownloaded(url))
                continue;
            executor.execute(task);
            markDownloaded(url);
            increaseCounter();
        }
    }

    synchronized boolean notFinished() {
        return (counter < maxSites);
    }

    private synchronized void increaseCounter() { counter++; }
    private synchronized void markDownloaded(URL url){
        downloadedURLS.add(url);
    }

    private synchronized boolean isDownloaded(URL url){
        return downloadedURLS.contains(url);
    }

}