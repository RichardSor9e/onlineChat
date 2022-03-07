package client;

public class NetworkThread extends Thread {

    @Override
    public void run() {
        ServerNetwork.network();
    }
}
