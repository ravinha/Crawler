import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Parser extends Thread implements IParser{

    private BlockingQueue<ParserFile> fileQueue;
    private IUrlPutter urlQueue;
    private PatternMatcher pm;
    private int maxDepth;

    int max = 10000;

    public Parser(BlockingQueue<ParserFile> fileQueue, IUrlPutter urlQueue,
                  PatternMatcher pm, int maxDepth) {
        this.fileQueue = fileQueue;
        this.urlQueue = urlQueue;
        this.pm = pm;
        this.maxDepth = maxDepth;
    }

    public void run() {
        int num;
        Random random = new Random();
        for(int i = 0; i< max; i++){

            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num = random.nextInt(max/3);

            try {
                urlQueue.put(new URL("http://example" + num + ".com/"), 1);
            } catch (MalformedURLException e) {
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
