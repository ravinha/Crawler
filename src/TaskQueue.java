import java.net.URL;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaskQueue implements IUrlPutter{

    private BlockingQueue<DownloadTask> tasks;

    public TaskQueue() {
        this.tasks = new LinkedBlockingQueue<>();
    }

    DownloadTask get() throws InterruptedException {
        return this.tasks.take();
    }

    @Override
    public void put(URL url, int depth) {
        try {
            this.tasks.put(new DownloadTask(url, depth));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
