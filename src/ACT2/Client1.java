package ACT2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import static ACT2.Valid.opValid;

public class Client1 {
    public static Oper input(Scanner scn){
        System.out.println("put numbers: ");
        int num1 = scn.nextInt();
        System.out.println("put numbers: ");
        int num2 = scn.nextInt();

        String chr = scn.next();
        char op = chr.charAt(0);
        if (opValid(op)) {System.out.println("error, OP is not valide");}
    return new Oper(num1, num2, op);
    }
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8000;

        try (Socket socket = new Socket(host, port);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
             Scanner scn = new Scanner(System.in);
            Oper op = input(scn);

            out.writeObject(op);

            int result = in.readInt();
            System.out.println("Result from server: " + result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
