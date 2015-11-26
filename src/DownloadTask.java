import java.net.URL;

public class DownloadTask implements Runnable{

    private URL url;
    private int depth;

    public DownloadTask(URL url, int depth) {
        this.url = url;
        this.depth = depth;
    }

    public URL getURL() {
        return url;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public void run() {
        System.out.println("Downloading from: " + url);
    }

}
