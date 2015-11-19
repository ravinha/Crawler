import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class Parser extends Thread {

    int max;
    Crawler crawler;

    public Parser(int max, Crawler crawler) {
        this.max = max;
        this.crawler = crawler;
    }

    public void run() {
        int num;
        Random random = new Random();
        for(int i = 0; i< max; i++){

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num = random.nextInt(max/3);

            try {
                crawler.putURL(new URL("http://example" + num + ".com/"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }
}
