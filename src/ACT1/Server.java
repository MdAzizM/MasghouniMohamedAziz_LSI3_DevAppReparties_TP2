package ACT1;
import java.io.*;
import java.net.*;
import java.util.regex.Pattern;
import ACT1.Validator;

import static ACT1.Validator.searchOP;

//import static ACT1.Validator.searchOP;

public class Server {
    public static int[] transform(String req){
        char op = searchOP(req);
        String word = req.replaceAll("\\s", "");
        String[] numbers = word.split(Pattern.quote(String.valueOf(op)));
        int[] nums = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            nums[i] = Integer.valueOf(numbers[i]);
        }
        return nums;
    }
    public static void main(String[] args){
        try{
            int port = 8000;
            ServerSocket serveur = new ServerSocket(port);
            System.out.println("server online on "+port);
            while (true) {
                Socket socketClient = serveur.accept();
                System.out.println("New Client1 connected!");

                //declaring variables
                PrintWriter os = new PrintWriter(socketClient.getOutputStream(), true);
                BufferedReader is = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

                String req = is.readLine();
                System.out.println("Printing Client1 Request: " + req);

                //refining the request
                char op = searchOP(req);
                int[] numbers = transform(req);


                //selecting OPERATOR
                int result = 0;
                switch (op) {
                    case '+':
                        result = Calculator.add(numbers);
                        break;
                    case '-':
                        result = Calculator.subtract(numbers);
                        break;
                    case '*':
                        result = Calculator.multiply(numbers);
                        break;
                    case '/':
                        result = Calculator.divide(numbers);
                        break;
                    default:
                        System.out.println("unknow operation");
                }
                System.out.println("res: " + result);
                os.println(result);

                socketClient.close();
                System.out.println("connection closed");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}