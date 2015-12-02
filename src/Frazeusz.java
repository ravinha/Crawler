import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Timer;
import javax.activation.MimetypesFileTypeMap;

public class Frazeusz {

    public static void main(String args[]) throws InterruptedException, IOException {

        Crawler crawler = new Crawler(1, 1, 10);
        crawler.startCrawling();

    }
}
