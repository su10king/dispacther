import java.io.InputStream;

public interface EventHandler {
    public String getHandler();

    public void handlerEvent(InputStream inputStream);
}
