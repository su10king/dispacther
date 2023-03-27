import sun.plugin2.message.Serializer;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class ServerInitializer2 {

    public static void main(String[] args) {
        int port = 5000;
        System.out.println("Server ON : " + port);


        Reactor reactor = new Reactor(port);

        try{
            Serializer serializer = new Persister();
            File Source = new File("HandlerList.xml")
            ServerListData serverList = serializer.read(ServerListData.class, source);

            for (HandlerData handlerListData : serverList.getServer()){


                if ("server1".equals(handlerListData.getName))){
                    List<HandlerData> handlerList = handlerListData.getHandler()
                            for(HandlerData handler : handlerList) {
                                try {
                                    reactor.registerHandler(handler.getHeader(), (EventHandler) Class.forName(handler.getHandler()).newInstance());
                            } catch (InstantiationException e) {
                                    e.printStackTrace();
                                }catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                }
                            break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        reactor.registerHandler(new StreamSayHelloEventHandler());
        reactor.registerHandler(new StreamUpdateProfileEventHandler());
/*
        reactor.registerHandler(new StreamUpdateProfileEventHandler());
        reactor.registerHandler(new StreamUpdateProfileEventHandler());
        reactor.registerHandler(new StreamUpdateProfileEventHandler());
        reactor.registerHandler(new StreamUpdateProfileEventHandler());*/

        reactor.startServer();
    }
}
