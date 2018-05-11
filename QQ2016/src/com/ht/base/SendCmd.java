package com.ht.base;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Vector;

import javax.swing.text.StyledDocument;

import com.ht.vo.AccountVo;

public class SendCmd {
	public static void send(SendMsg msg){
		try {
			DatagramSocket socket = new DatagramSocket();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(msg);
			oos.flush();
			byte b[]= bos.toByteArray();
			InetAddress addr = InetAddress.getByName(msg.friendInfo.getIpAddr());
			int port = msg.friendInfo.getPort();
			DatagramPacket pack = new DatagramPacket(b,0,b.length,addr,port);
			socket.send(pack);
			System.out.println(msg.cmd +"==发送消息,b.size="+b.length);
			socket.close();
			oos.close();
		}catch (SocketException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	//发送广播
	public static void sendAll(Vector<AccountVo> allInfo,AccountVo myInfo,int cmd){
		for(AccountVo acc : allInfo){
			if(!acc.getOnlinestatus().equals(Cmd.STATUS[1]) && acc.getQqCode()!= myInfo.getQqCode()){
				SendMsg msg = new SendMsg();
				msg.cmd = cmd;				
				msg.myInfo = myInfo;
				msg.friendInfo = acc;
				send(msg);
			}
		}
	}
	//群聊
	public static void sendAll(Vector<AccountVo> allInfo,AccountVo myInfo,int cmd,StyledDocument doc){
		for(AccountVo acc : allInfo){
			if(!acc.getOnlinestatus().equals(Cmd.STATUS[1]) && acc.getQqCode()!= myInfo.getQqCode()){
				SendMsg msg = new SendMsg();
				msg.cmd = cmd;				
				msg.myInfo = myInfo;
				msg.friendInfo = acc;
				msg.doc = doc;
				send(msg);
			}
		}
	}
}
