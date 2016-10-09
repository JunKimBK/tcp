package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import bean.Vacxin;
import model.ModelVacxin;

public class UDPServer {
		public static void main(String[] args) {
		UDPServer udp = new UDPServer();
		try{
			udp.newServer();
		}catch(Exception e){}
	}
	public void newServer(){
		try{
			DatagramSocket socket = new DatagramSocket(6678);
			byte [] receiveData = new byte[1024];
			byte [] sendData; 
			while(true){
				//nhan 1
				DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
				socket.receive(receivePacket);
				
				String receiveString = new String(receivePacket.getData());
				//sendData = receiveString.getBytes();
				ModelVacxin mVacxin = new ModelVacxin();
				if(mVacxin.checkItem(receiveString)==0){
					String sender = "Khong co vac xin nay";
					sendData = sender.getBytes();
					DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,
							receivePacket.getAddress(),receivePacket.getPort());
							socket.send(sendPacket);	
				}else{
					Vacxin vx = mVacxin.getItem(receiveString);
					String sender = "so mui can tiem cho vac xin "+vx.getTenvacxin()+" la  :"  + vx.getSomui();
					sendData = sender.getBytes();
					DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,
							receivePacket.getAddress(),receivePacket.getPort());
							socket.send(sendPacket);	
				}							
			}
		}catch(Exception e){}
	}
}
