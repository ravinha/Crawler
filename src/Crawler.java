import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.net.URL;

public class Crawler {

    TaskQueue taskQueue;
    BlockingQueue<ParserFile> fileQueue;
    private HashSet downloadedURLS;
    ExecutorService executor;
    private int counter;
    private int maxSites;
    private int maxDepth;

    public Crawler(int workersPool, int maxSites, int maxDepth) {
        this.taskQueue = new TaskQueue();
        this.fileQueue = new LinkedBlockingQueue<>();
        this.executor = Executors.newFixedThreadPool(workersPool);
        this.counter = 0;
        this.maxSites = maxSites;
        this.downloadedURLS = new HashSet();
        this.maxDepth = maxDepth;
        new Parser(fileQueue, taskQueue, new PatternMatcher(), maxDepth).start();
    }

    public void startCrawling() throws InterruptedException {
        DownloadTask task;
        URL url;
        while(notFinished()) {
            task = taskQueue.get();
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