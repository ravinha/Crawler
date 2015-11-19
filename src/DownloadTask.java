import java.net.URL;

public class DownloadTask implements Runnable{

    private URL url;

    public DownloadTask(URL url) {
        this.url = url;
    }

    public URL getURL() {
        return url;
    }

    @Override
    public void run() {
        System.out.println("Downloading from: " + url);
    }
}
