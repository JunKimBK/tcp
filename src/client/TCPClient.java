package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {
	public static void main(String[] args) {
		creatCLient();
	}
	public static void creatCLient(){
		try {
			Socket skOfCLient = new Socket("localhost", 1994);
			DataOutputStream out = new DataOutputStream(skOfCLient.getOutputStream());
			DataInputStream in = new DataInputStream(skOfCLient.getInputStream());
			Scanner input = new Scanner(System.in);
			System.out.print("Nhap ten vac Xin:");
			String send = input.nextLine();
			out.writeUTF(send);
			String receive = in.readUTF();
			System.out.println(receive);
			in.close();
			out.close();
			skOfCLient.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
}
