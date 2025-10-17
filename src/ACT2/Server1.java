package ACT2;

import java.io.*;
import java.net.*;

public class Server1 {
    public static void main(String[] args) {
        int port = 8000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server1 listening on port " + port);

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client1 connected!");

            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

            // Receive the object
            Oper op = (Oper) in.readObject();

            // Perform the calculation
            int result = calculate(op.getNum1(), op.getNum2(), op.getOperator());

            // Send result back to client
            out.writeInt(result);
            out.flush();

            clientSocket.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num2 != 0 ? num1 / num2 : 0;
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}

