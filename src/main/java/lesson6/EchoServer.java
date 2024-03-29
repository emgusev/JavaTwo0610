package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        Socket socket = null;

        try (ServerSocket serverSocket = new ServerSocket(8089)) { //try with resources
            System.out.println("Сервер ожидает подключения... ");
            socket = serverSocket.accept(); //ждем подключения (БЛОКИРУЕМСЯ)
            System.out.println("Клиент подключился!");
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String message = dataInputStream.readUTF();
                //poison pill
                if (message.equals("/end")) {
                    dataOutputStream.writeUTF(message);
                    break;
                }
                System.out.println("Клиент прислал " + message);
                dataOutputStream.writeUTF("Echo: " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } //finally {serverSocket.close()}


    }


}
