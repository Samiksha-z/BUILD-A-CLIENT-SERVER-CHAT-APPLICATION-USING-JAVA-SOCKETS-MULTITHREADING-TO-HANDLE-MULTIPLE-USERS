import java.io.*;
import java.net.*;

public class ChatClient2 {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        System.out.println("Connected to the chat server.");

        // Input and output streams
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Start a thread to listen for incoming messages from the server
        new Thread(new ServerListener(serverInput)).start();

        // Send messages to the server
        String message;
        while ((message = consoleInput.readLine()) != null) {
            serverOutput.println(message);  // Send message to server
        }

        socket.close();
    }

    // Thread to listen for messages from the server
    private static class ServerListener implements Runnable {
        private BufferedReader serverInput;

        public ServerListener(BufferedReader serverInput) {
            this.serverInput = serverInput;
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = serverInput.readLine()) != null) {
                    System.out.println("Server: " + message);  // Display received message
                }
            } catch (IOException e) {
                System.out.println("Connection lost.");
            }
        }
    }
}
