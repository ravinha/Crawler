import java.net.MalformedURLException;

public class Frazeusz {

    public static void main(String args[]) throws InterruptedException, MalformedURLException {

        Crawler crawler = new Crawler(100, 500);
        Parser parser = new Parser(1000, crawler);
        parser.start();
        crawler.startCrawling();
    }

}
