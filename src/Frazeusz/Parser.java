package Frazeusz;

import Frazeusz.Crawler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.BlockingQueue;

public class Parser extends Thread implements IParser{

    private BlockingQueue<ParserFile> fileQueue;
    private IUrlPutter urlQueue;
    private PatternMatcher pm;
    private int maxDepth;

    public Parser(BlockingQueue<ParserFile> fileQueue, IUrlPutter urlQueue,
                  PatternMatcher pm, int maxDepth) {
        this.fileQueue = fileQueue;
        this.urlQueue = urlQueue;
        this.pm = pm;
        this.maxDepth = maxDepth;
    }

    String[] addresses = {
            "http://www.onet.pl",
            "http://www.wp.pl",
            "http://www.gazeta.pl",
            "http://www.sport.pl",
            "http://www.agh.edu.pl",
    };


    public void run() {

        for(String address : addresses){

            try {
//                urlQueue.put(new URL("http://example" + num + ".com/"), 1);
                urlQueue.put(new URL(address), 1);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(! fileQueue.isEmpty()) {
            try {
                System.out.println(fileQueue.take().getContent());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void close() {

    }

    @Override
    public boolean isWorking() {
        return false;
    }
}
