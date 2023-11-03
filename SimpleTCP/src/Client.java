import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            //Establishing connection with the server
            Socket clientSocket = new Socket("localhost", 8888);
            System.out.println("Connected to the server!");

            //Sending a message to the server
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
            System.out.println("Please type your message");
            Scanner scan = new Scanner(System.in);
            String message = scan.nextLine();
            pw.println(message);
            pw.flush();

            //Receiving a message from the server
            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String receivedMsg = br.readLine();
            System.out.println("Server: "+receivedMsg);

            //Closing the input and output streams
            br.close();
            pw.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}