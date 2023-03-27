
import com.sun.tracing.dtrace.Attributes;

import java.util.List;

public class ServerListData {

    @ElementList(entry= "server", inline = true)
    private List<HandlerListData> server;

    public List<HandlerListData> getServer() {
        return server;
    }

    @Attributes
    public String name;

    public List<HandlerData> getHandler() {
        return handler;
    }

    public String getName() {
        return name;
    }

}
