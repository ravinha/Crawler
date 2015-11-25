import com.sun.media.sound.DataPusher;
import data.CrawlingData;
import gui.DataFrame;
import java.awt.*;
import java.net.MalformedURLException;

public class Frazeusz {

    public static void main(String args[]) throws InterruptedException, MalformedURLException {
        NLProcessor nlProcessor = new NLProcessor();
        PatternMatcher patternMatcher = new PatternMatcher(nlProcessor);
        Plotter plotter = new Plotter();
        patternMatcher.addObserver(plotter);
        EventQueue.invokeLater(() -> {
            new DataFrame();
        });
    }

    public static void start(CrawlingData crawlingData) throws InterruptedException {

        Crawler crawler = new Crawler(100, 500);
        Parser parser = new Parser(1000, crawler);
        parser.start();
        crawler.startCrawling();
    }
}
