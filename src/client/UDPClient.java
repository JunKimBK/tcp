package client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
	public static void main(String[] args) {
		UDPClient udp = new UDPClient();
		try{
			udp.newClient();
		}catch(Exception e){}
	}

	public void newClient(){
		Scanner sc = new Scanner(System.in);
		try{
			DatagramSocket socket = new DatagramSocket();
			InetAddress address = InetAddress.getByName("localhost");
			byte [] receiveData = new byte[1024];
			byte [] sendData;
			System.out.println("Nhap chuoi ten vacxin:");
			String s = sc.nextLine();
			sendData = s.getBytes();
			//gui 1
			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,address,6678);
			socket.send(sendPacket);
			//nhan 1
			DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
			socket.receive(receivePacket);
			String receiveString = new String(receivePacket.getData()).trim();
			System.out.println(receiveString);
			socket.close();
		}catch(Exception e){
			e.printStackTrace();
		}
}
}
