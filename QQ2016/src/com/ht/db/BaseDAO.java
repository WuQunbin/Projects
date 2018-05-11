package com.ht.db;

import java.util.Random;
import java.util.Vector;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ht.base.Cmd;
import com.ht.base.DBConn;
import com.ht.vo.AccountVo;


public class BaseDAO {
	public int getQQCode(){
		boolean bExist = false;
		
		Connection conn = DBConn.openDB();
		String sql = "select qqcode from account where qqcode=?";
		int qqcode=0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			while(!bExist){
				Random rand = new Random();
				qqcode = rand.nextInt(8999)+1000;
				pstmt.setInt(1, qqcode);
				ResultSet rs = pstmt.executeQuery();
				if(!rs.next()){
					bExist = true;
					break;
				}
			}
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qqcode;
	}
	public int getPort(){
		boolean bExist=false;
		Connection conn = DBConn.openDB();
		String sql = "select port from account where onlinestatus<>? and  port=?";
		int port = 0;
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			while(!bExist){
				Random rand = new Random();
				port = rand.nextInt(64000)+1024;
				pstmt.setString(1, Cmd.STATUS[1]);
				pstmt.setInt(2, port);
				ResultSet rs = pstmt.executeQuery();
				if(!rs.next()){
					bExist=true;
					break;
				}
			}
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return port;
	}
	public AccountVo saveAccount(AccountVo acc){
		int qqcode = getQQCode();
		int port = getPort();
		acc.setQqCode(qqcode);
		acc.setPort(port);
		acc.setOnlinestatus(Cmd.STATUS[1]);
		String sql = "insert into account values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = DBConn.openDB();
		try {
			int i = 1;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(i++, acc.getQqCode());
			pstmt.setString(i++, acc.getNickName());
			pstmt.setString(i++, acc.getHeadImg());
			pstmt.setString(i++, acc.getPassword());
			pstmt.setInt(i++, acc.getAge());
			pstmt.setString(i++, acc.getSex());
			pstmt.setString(i++, acc.getStar());
			pstmt.setString(i++, acc.getBlood());
			pstmt.setString(i++, acc.getNation());
			pstmt.setString(i++, acc.getHobit());
			pstmt.setString(i++, acc.getIpAddr());
			pstmt.setInt(i++, acc.getPort());
			pstmt.setString(i++, acc.getOnlinestatus());
			pstmt.setString(i++, acc.getRemark());
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
		
	}
	public AccountVo updateAccount(AccountVo acc){
		String sql = "update account set nickName=?,headImg=?,age=?,sex=?,star=?,blood=?,nation=?,hobit=?,remark=? where qqCode=?";
		Connection conn = DBConn.openDB();
		try {
			int i = 1;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(i++, acc.getNickName());
			pstmt.setString(i++, acc.getHeadImg());
			pstmt.setInt(i++, acc.getAge());
			pstmt.setString(i++, acc.getSex());
			pstmt.setString(i++, acc.getStar());
			pstmt.setString(i++, acc.getBlood());
			pstmt.setString(i++, acc.getNation());
			pstmt.setString(i++, acc.getHobit());
			pstmt.setString(i++, acc.getRemark());
			pstmt.setInt(i++, acc.getQqCode());
			i = pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
		
	}
	public AccountVo login(AccountVo account) {
		Connection conn = DBConn.openDB();
		String sql = "select * from account where qqcode=? and password=?";
		int qqcode = 0;
		try {
			int port = getPort();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, account.getQqCode());
			pstmt.setString(2, account.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				account.setNickName(rs.getString("nickName").trim());
				account.setHeadImg(rs.getString("headImg").trim());
				account.setAge(rs.getInt("age"));
				account.setSex(rs.getString("sex").trim());
				account.setStar(rs.getString("star").trim());
				account.setBlood(rs.getString("blood").trim());
				account.setNation(rs.getString("nation").trim());
				account.setHobit(rs.getString("hobit").trim());
				InetAddress addr = null;
				try {
					addr = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				String ip = addr.getHostAddress();
				account.setIpAddr(ip);
				account.setPort(port);
				account.setOnlinestatus(Cmd.STATUS[0]);
				account.setRemark(rs.getString("remark"));
				sql = "update account set ipaddr='"+ip+"' ,port="+port +",onlinestatus='"+ Cmd.STATUS[0]+"'where qqcode="+account.getQqCode();
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				pstmt.close();
				stmt.close();
			}else{
				account=null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}
	public Vector<AccountVo> getMyFriend(int myQQcode){
		String sql = "select a.*,f.groupName from account a inner join Friends f on a.qqcode=f.friendQQcode where myqqcode=?";
		int qqcode = 0;
		Vector<AccountVo> vmyFriend = new Vector<AccountVo>(); 
		Connection conn = DBConn.openDB();
		try{
			int port =getPort();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, myQQcode);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				AccountVo account = new AccountVo();
				account.setQqCode(rs.getInt("qqCode"));
				account.setNickName(rs.getString("nickName").trim());
				account.setHeadImg(rs.getString("headImg").trim());
				account.setAge(rs.getInt("age"));
				account.setSex(rs.getString("sex").trim());
				account.setStar(rs.getString("star").trim());
				account.setBlood(rs.getString("blood").trim());
				account.setNation(rs.getString("nation").trim());
				account.setHobit(rs.getString("hobit").trim());
				account.setIpAddr(rs.getString("ipAddr"));
				account.setPort(rs.getInt("port"));
				account.setOnlinestatus(rs.getString("onlinestatus"));//在线
				account.setRemark(rs.getString("remark"));
				account.setGroupName(rs.getString("groupName").trim());
				
				vmyFriend.add(account);
			}
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return vmyFriend;
	}
	public void moveGroup(int myQQcode,int friendQQcode,String groupName){
		String sql = "update Friends set groupName=? where myQQcode=? and friendQQcode=?";
		try {
			Connection conn = DBConn.openDB();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int i=1;
			pstmt.setString(i++, groupName);
			pstmt.setInt(i++, myQQcode);
			pstmt.setInt(i++, friendQQcode);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Vector<Vector> friendFriend(final String sql){
		Vector<Vector> vData = new Vector<Vector>();
		Connection conn = DBConn.openDB();
		try {
			int port = getPort();
			Statement pstmt = conn.createStatement();
			ResultSet rs = pstmt.executeQuery(sql);
			while (rs.next()) {
				Vector rowData = new Vector();
				rowData.addElement(rs.getString("headImg").trim());
				rowData.addElement(rs.getInt("qqCode"));
				rowData.addElement(rs.getString("nickName").trim());
				rowData.addElement(rs.getInt("age"));
				rowData.addElement(rs.getString("sex").trim());
				rowData.addElement(rs.getString("blood").trim());
				rowData.addElement(rs.getString("star").trim());
				rowData.addElement(rs.getString("nation").trim());
				rowData.addElement(rs.getString("hobit").trim());
				rowData.addElement(rs.getString("onlinestatus").trim());
				rowData.addElement(rs.getString("remark"));
				vData.addElement(rowData);
			}
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vData;
		
	}
	public AccountVo getSelectedFriend(int myQQcode){
		String sql = "select * from Account where qqcode=?";
		int qqCode = 0;
		AccountVo account = new AccountVo();
		Connection conn = DBConn.openDB();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, myQQcode);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				account.setQqCode(rs.getInt("qqCode"));
				account.setNickName(rs.getString("nickName").trim());
				account.setHeadImg(rs.getString("headImg").trim());
				account.setAge(rs.getInt("age"));
				account.setSex(rs.getString("sex").trim());
				account.setStar(rs.getString("star").trim());
				account.setBlood(rs.getString("blood").trim());
				account.setNation(rs.getString("nation").trim());
				account.setHobit(rs.getString("hobit").trim());
				account.setIpAddr(rs.getString("ipAddr"));
				account.setPort(rs.getInt("port"));
				account.setOnlinestatus(rs.getString("onlinestatus"));
				account.setRemark(rs.getString("remark"));
				
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	public void addFriend(int myqqcode,int friendqqcode){
		try {
			Connection conn = DBConn.openDB();
			String sql = "insert into Friends values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, myqqcode);
			pstmt.setInt(2, friendqqcode);
			pstmt.setString(3, Cmd.GROUPNAME[1]);
			pstmt.executeUpdate();
			pstmt.setInt(1, friendqqcode);
			pstmt.setInt(2, myqqcode);
			pstmt.setString(3, Cmd.GROUPNAME[1]);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delFriend(int myqqcode,int friendqqcode){
		try {
			Connection conn = DBConn.openDB();
			String sql = "delete Friends where myqqcode=? and friendqqcode=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, myqqcode);
			pstmt.setInt(2, friendqqcode);
			pstmt.executeUpdate();
			pstmt.setInt(1, friendqqcode);
			pstmt.setInt(2, myqqcode);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean isFriend(int myQQcode,int friendqqcode){
		String sql = "select * from Friends where myqqcode=? and friendqqcode=?";
		boolean isok = false;
		AccountVo account = new AccountVo();
		Connection conn = DBConn.openDB();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, myQQcode);
			pstmt.setInt(2, friendqqcode);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				isok = true;
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isok;
		
	}
	public void changStatus(int qqcode,String status){
		String sql = "update Account set onlinestatus=? where qqCode=?";
		Connection conn = DBConn.openDB();
		try {
			int i=1;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(i++, status);
			pstmt.setInt(i++, qqcode);
			i = pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
