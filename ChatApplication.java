import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.*;
public class ChatApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'server' to start as server or 'client' to start as client:");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("server")) {
            startServer();
        } else if (choice.equalsIgnoreCase("client")) {
            startClient();
        } else {
            System.out.println("Invalid choice. Exiting.");
        }
    }

    private static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started. Waiting for clients to connect...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client: " + inputLine);
                System.out.print("You: ");
                String response = scanner.nextLine();
                out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startClient() {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String inputLine;
            while (true) {
                System.out.print("You: ");
                String message = scanner.nextLine();
                out.println(message);
                inputLine = in.readLine();
                System.out.println("Server: " + inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}