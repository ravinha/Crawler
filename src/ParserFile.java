import javax.activation.MimeType;
import java.net.URL;

public class ParserFile {

    private MimeType mime;
    private String content;
    private int depth;
    private URL url;

    public ParserFile(MimeType mime, String content, int depth, URL url) {
        this.mime = mime;
        this.content = content;
        this.depth = depth;
        this.url = url;
    }

    public MimeType getMime() {
        return mime;
    }

    public void setMime(MimeType mime) {
        this.mime = mime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

}

