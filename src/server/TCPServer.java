package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import bean.Vacxin;
import model.ModelVacxin;

public class TCPServer {
	public static void main(String[] args) {
		creatServer();
	}
	public static void creatServer(){
		try {
			ServerSocket server = new ServerSocket(1994);
			System.out.println("Server's welcome!");
			while(true){
				Socket skOfServer = server.accept();
				DataOutputStream out = new DataOutputStream(skOfServer.getOutputStream());
				DataInputStream in = new DataInputStream(skOfServer.getInputStream());
				String receive = in.readUTF();
				System.out.println(receive);
				ModelVacxin mVacxin = new ModelVacxin();
				if(mVacxin.checkItem(receive)==0){
					String sender = "Khong co vac xin nay";
					out.writeUTF(sender);
				}else{
					Vacxin vx = mVacxin.getItem(receive);
					String sender = "so mui can tiem cho vac xin "+vx.getTenvacxin()+" la  :"  + vx.getSomui()  ;
					out.writeUTF(sender);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
