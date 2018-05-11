package com.ht.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.ht.db.BaseDAO;
import com.ht.vo.AccountVo;


public class LoginUI extends JFrame implements ActionListener,MouseListener,ItemListener,MouseMotionListener{
	JLabel lblMin,lblClose,lblHead,lblReg,lblForgetpwd;
	JButton btnLogin;
	JPasswordField txtPassword;
	JComboBox cbQQcode;
	JCheckBox cbpwd,cbAutologin;
	HashMap<Integer, AccountVo> user = null;
	public LoginUI(){
		setUndecorated(true);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("head/touxiang.png");
		setIconImage(img);
		JLabel bg = new JLabel(new ImageIcon("images/login.jpg"));
		bg.setLayout(null);
		add(bg);
		lblMin = new JLabel("-");
		lblMin.setForeground(Color.WHITE);
		lblMin.setFont(new Font("黑体",Font.BOLD,20));
		lblClose =  new JLabel("x");
		lblClose.setForeground(Color.WHITE);
		lblClose.setFont(new Font("黑体",Font.BOLD,20));
		lblMin.setBounds(380, 0, 20, 20);
		lblClose.setBounds(400, 0, 20, 20);
		lblMin.setToolTipText("最小化");
		lblClose.setToolTipText("关闭");
		lblMin.addMouseListener(this);
		lblClose.addMouseListener(this);
		bg.add(lblMin);
		bg.add(lblClose);
		bg.addMouseMotionListener(this);
		lblHead = new JLabel(new ImageIcon("head/tubiao.png"));
		lblReg = new JLabel("		");
		lblForgetpwd = new JLabel("		");
		cbQQcode = new JComboBox();
		txtPassword = new JPasswordField();
		btnLogin = new JButton("登录");
		cbpwd = new JCheckBox("记住密码");
		cbAutologin = new JCheckBox("自动登录");
		
		cbQQcode.setBounds(130, 185, 194, 30);
		cbQQcode.setEditable(true);
		cbQQcode.setToolTipText("账号");		
		txtPassword.setBounds(130, 215, 195, 30);
		txtPassword.setToolTipText("密码");
		lblReg.setBounds(335, 185, 80, 30);
		lblForgetpwd.setBounds(335, 215, 80, 30);
		lblHead.setBounds(70, 185, 60, 60);
		btnLogin.setBounds(130, 278, 195, 30);
		btnLogin.setBackground(Color.LIGHT_GRAY);
		cbpwd.setBounds(127, 243, 80, 30);
		cbAutologin.setBounds(254, 243, 80, 30);
		
		cbpwd.setOpaque(false);
		cbAutologin.setOpaque(false);
		cbQQcode.setOpaque(false);
		
		bg.add(cbQQcode);
		bg.add(txtPassword);
		bg.add(lblReg);
		bg.add(lblForgetpwd);
		bg.add(lblHead);
		bg.add(btnLogin);
		bg.add(cbpwd);
		bg.add(cbAutologin);
		
		lblForgetpwd.addMouseListener(this);
		lblReg.addMouseListener(this);
		cbpwd.addActionListener(this);
		cbAutologin.addActionListener(this);
		btnLogin.addActionListener(this);
		cbQQcode.addItemListener(this);
		readFile();
		
		setSize(427, 321);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new LoginUI();
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==lblMin){
			this.setState(JFrame.HIDE_ON_CLOSE);
		}else if(e.getSource()==lblClose){
			System.exit(0);
		}else if(e.getSource()==lblReg){
			JOptionPane.showMessageDialog(this, "注册账号");
			new RegUI();
		}else if(e.getSource()==lblForgetpwd){
			JOptionPane.showMessageDialog(this, "找回密码");
		
		}
	}
	
	public void mouseEntered(MouseEvent e) {
		
		
	}
	public void mouseExited(MouseEvent e) {
		
		
	}
	public void mousePressed(MouseEvent e) {
		x=this.getX();
		y=this.getY();
		
	}
	public void mouseReleased(MouseEvent e) {
		
		
	}
	public void actionPerformed(ActionEvent e) {	
		if(e.getSource()==btnLogin){
			String qqcode="";
			String pwd = txtPassword.getText().trim();
			if(cbQQcode.getSelectedItem() == null){
				JOptionPane.showMessageDialog(this, "请输入QQ号码");
				return;
			}
			if(pwd.equals("")){
				JOptionPane.showMessageDialog(this, "请输入登录密码");
				return;
			}
			qqcode = cbQQcode.getSelectedItem().toString();
			AccountVo account = new AccountVo();
			account.setQqCode(Integer.parseInt(qqcode));
			account.setPassword(pwd);
			account=new BaseDAO().login(account);
			if(account==null){
				JOptionPane.showMessageDialog(this, "登录失败，用户名或密码错误!");
				return;
			}else{
//				JOptionPane.showMessageDialog(this, "登录成功");
				save(account);
				dispose();
				new MainUI(account);
			}
			
		}else if (e.getSource()==cbpwd) {
			JOptionPane.showMessageDialog(this, "记住密码");
		}
	}
	private void save(AccountVo account) {
		HashMap<Integer, AccountVo> user = null;
		File file = new File("account.dat");
		try {
			if(!file.exists()){
				file.createNewFile();
				user = new HashMap<Integer, AccountVo>();
			}else{
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				user = (HashMap<Integer, AccountVo>)ois.readObject();
				fis.close();
				ois.close();
			}
			user.put(account.getQqCode(), account);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("account.dat"));
			oos.writeObject(user);
			oos.flush();
			oos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	private void readFile() {
		try {
			File file = new File("account.dat");
			if(!file.exists()){
				return;
			}
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			user = (HashMap<Integer, AccountVo>)ois.readObject();
			Set<Integer> set = user.keySet();
			Iterator<Integer> it = set.iterator();
			while (it.hasNext()) {
				cbQQcode.addItem(it.next());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==cbQQcode){
			if(!cbQQcode.getSelectedItem().equals("") && user!=null){
				int qqcode = Integer.parseInt(cbQQcode.getSelectedItem().toString());
				AccountVo account = user.get(qqcode);
				if(account!=null){
					txtPassword.setText(account.getPassword());
					lblHead.setIcon(new ImageIcon(account.getHeadImg()));
				}
				
			}
		}
	}
	int x,y;
	public void mouseDragged(MouseEvent e) {
		this.setLocation(e.getX()+x, e.getY()+y);
		this.getX();
		this.getY();
		
	}
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
