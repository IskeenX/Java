import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            //Opening a port and waiting for incoming connections
            ServerSocket sSocket = new ServerSocket(8888);
            System.out.println("Server has started");
            System.out.println("Waiting for incoming connections!");
            Socket socket = sSocket.accept();

            //Receiving a message from the client
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String msg = br.readLine();
            System.out.println("Client: "+msg);

            //Sending a message to the client
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            System.out.println("Please type your message");
            Scanner scan = new Scanner(System.in);
            String message = scan.nextLine();
            pw.println(message);
            pw.flush();

            //Closing the input and output streams
            pw.close();
            br.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}