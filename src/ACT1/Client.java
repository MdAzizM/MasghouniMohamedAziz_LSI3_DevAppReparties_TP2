package ACT1;

// C'EST LE SOURCE CODE DE CLIENT MAIS DANS UN AUTRE MACHINE VIRTUELLE QUE LE SERVEUR

import java.io.*;
import java.net.*;
import java.util.Scanner;

import static ACT1.Validator.valide;

public class Client {
    public static String input(Scanner scn){
        System.out.println("put numbers: ");
        String req = scn.nextLine();
        if(!valide(req)){
            input(scn);
        }
        return req;
    }
    public static void main(String[] args){
        try{

            int port = 8000;
            Socket socket = new Socket("localhost",port);
            System.out.println("Client1 connected on "+port+"!");

            //Client1 Input
            Scanner scn = new Scanner(System.in);
            String req = input(scn);
            //Sending the CLIENT's data
            PrintWriter os = new PrintWriter(socket.getOutputStream(), true);
            os.println(req);

            //Recieving the Server1 results
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String nb = is.readLine();
            System.out.println("Result: \t"+nb);

            socket.close();
            System.out.println("connection closed !");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}