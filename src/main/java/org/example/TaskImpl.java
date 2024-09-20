package org.example;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
//Задание 5
public class TaskImpl implements Task{
    private final String host;
    private final int startPort;
    private final int endPort;
    private final AtomicBoolean running = new AtomicBoolean(false);
    public TaskImpl(String host, int startPort, int endPort) {
        this.host = host;
        this.startPort = startPort;
        this.endPort = endPort;
    }

    @Override
    public void start() {
        if (running.compareAndSet(false, true)) {
            new Thread(() -> {
                try {
                    scanPorts();
                } catch (IOException e) {
                    System.err.println("Ошибка сканирования порта: " + e.getMessage());
                } finally {
                    running.set(false);
                }
            }).start();
        }
    }

    @Override
    public void stop() {
        running.set(false);
    }
    private void scanPorts() throws IOException {
        InetAddress inetAddress = InetAddress.getByName(host);

        for (int port = startPort; port <= endPort && running.get(); port++) {
            try (Socket socket = new Socket(inetAddress, port)) {
                System.out.println("Порт " + port + " открыт");
            } catch (IOException ignored) {
            }
        }
    }
    public static void main(String[] args) {
        TaskImpl scanner = new TaskImpl("localhost", 1, 9000);
        scanner.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {
        }
        scanner.stop();
    }
}
