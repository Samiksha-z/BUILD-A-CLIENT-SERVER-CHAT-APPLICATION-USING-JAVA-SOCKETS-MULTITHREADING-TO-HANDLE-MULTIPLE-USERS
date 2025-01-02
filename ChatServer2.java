import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer2 {
    private static final int PORT = 12345;
    private static Set<PrintWriter> clientWriters = new HashSet<>();

    public static void main(String[] args) throws IOException {
        System.out.println("Chat server started...");
        ServerSocket serverSocket = new ServerSocket(PORT);
        
        try {
            while (true) {
                new ClientHandler(serverSocket.accept()).start(); // Handle new client connection
            }
        } finally {
            serverSocket.close();
        }
    }

    // ClientHandler thread to handle each client
    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                synchronized (clientWriters) {
                    clientWriters.add(out); // Add new client to the set of writers
                }

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    synchronized (clientWriters) {
                        for (PrintWriter writer : clientWriters) {
                            writer.println(message);  // Broadcast message to all clients
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error handling client.");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Error closing socket.");
                }
                synchronized (clientWriters) {
                    clientWriters.remove(out); // Remove client from the set
                }
            }
        }
    }
}
