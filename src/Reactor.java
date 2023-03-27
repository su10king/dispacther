import java.io.IOException;
import java.net.ServerSocket;

public class Reactor {

    private ServerSocket serverSocket;
    private HandleMap handleMap;

    public Reactor(int port) {
        handleMap = new HandleMap();
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void startServer() {

        Dispatcher dispatcher = new Dispatcher();

        while (true) {
            dispatcher.dispatch(serverSocket, handleMap);
        }
    }

    public void registerHandler(String header, EventHandler handler) {
        handleMap.put(header, handler);
    }


    public void registerHandler(EventHandler handler) {
        handleMap.put(handler.getHandler(), handler);
    }

    public void removeHandler(EventHandler handler) {
            handleMap.remove(handler.getHandler());
        }
    }
