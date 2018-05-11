package com.ht.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.ht.db.BaseDAO;
import com.ht.vo.AccountVo;


public class RegUI extends JFrame implements ActionListener{
	private JLabel lblQQcode,lblnickName,lblHeadImg,lblPassword,lblcfgpassword,lblAge;
	private JLabel lblSex,lblNation,lblStar,lblBlood,lblIpAddr,lblPort;
	private JLabel lblRemark,lblHobit;
	private JTextField txtQQcode,txtNickName,txtAge,txtIpAddr,txtPort,txtHobit;
	private JPasswordField txtPassword,txtcfgPassword;
	private JRadioButton rbMale,rbRemale;
	private JComboBox cbNation,cbStar,cbBlood,cbHeadImg;
	private JTextArea taRemark;
	private ButtonGroup bg;
	private JLabel lblBg;
	private JButton btnSave,btnClose;
	
	private String sNation[]={
			"汉族","藏族","维吾尔族","傣族","高山族",
			"苗族","朝鲜族","壮族","回族","侗族",
	};
	private String sStar[]={
		"天蝎座","天秤座","水瓶座","处女座","摩羯座","双子座",	
		"白羊座","狮子座","射手座","金牛座","双鱼座","巨蟹座"
	};
	private String sBlood[]={
			"A","B","O","AB"
	};
	private String sHeadImg[]={
			"head/0.png","head/1.png","head/2.png",
			"head/3.png","head/4.png","head/5.png",
			"head/6.png","head/7.png","head/8.png",
			"head/9.png","head/10.png","head/11.png",
			"head/12.png","head/13.png","head/14.png",
			"head/15.png","head/16.png","head/17.png",
			"head/18.png","head/19.png","head/20.png",
			"head/21.png","head/22.png","head/23.png",
			"head/24.png",
	};
	private ImageIcon[] headIcon={
			new ImageIcon(sHeadImg[0]),
			new ImageIcon(sHeadImg[1]),
			new ImageIcon(sHeadImg[2]),
			new ImageIcon(sHeadImg[3]),
			new ImageIcon(sHeadImg[4]),
			new ImageIcon(sHeadImg[5]),
			new ImageIcon(sHeadImg[6]),
			new ImageIcon(sHeadImg[7]),
			new ImageIcon(sHeadImg[8]),
			new ImageIcon(sHeadImg[9]),
			new ImageIcon(sHeadImg[10]),
			new ImageIcon(sHeadImg[11]),
			new ImageIcon(sHeadImg[12]),
			new ImageIcon(sHeadImg[13]),
			new ImageIcon(sHeadImg[14]),
			new ImageIcon(sHeadImg[15]),
			new ImageIcon(sHeadImg[16]),
			new ImageIcon(sHeadImg[17]),
			new ImageIcon(sHeadImg[18]),
			new ImageIcon(sHeadImg[19]),
			new ImageIcon(sHeadImg[20]),
			new ImageIcon(sHeadImg[21]),
			new ImageIcon(sHeadImg[22]),
			new ImageIcon(sHeadImg[23]),
			new ImageIcon(sHeadImg[24]),
		
	};
	public RegUI(){
		super("QQ用户注册");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("images/qt.png");
		setIconImage(image);
		lblBg = new JLabel(new ImageIcon("images/1.jpg"));
		add(lblBg);
		lblBg.setLayout(null);
		JLabel title = new JLabel("用户注册",JLabel.CENTER);
		title.setFont(new Font("黑体",Font.BOLD,45));
		title.setForeground(Color.BLACK);
		title.setBounds(230, 30, 200, 40);
		lblBg.add(title);
		
		lblQQcode = new JLabel("QQ号码:",JLabel.RIGHT);
		lblQQcode.setFont(new Font("黑体",Font.BOLD,20));
		lblQQcode.setForeground(Color.BLACK);
		lblnickName = new JLabel("昵称:",JLabel.RIGHT);
		lblnickName.setFont(new Font("黑体",Font.BOLD,20));
		lblnickName.setForeground(Color.BLACK);
		lblHeadImg = new JLabel("头像:",JLabel.RIGHT);
		lblHeadImg.setFont(new Font("黑体",Font.BOLD,20));
		lblHeadImg.setForeground(Color.BLACK);
		lblPassword = new JLabel("登录密码:",JLabel.RIGHT);
		lblPassword.setFont(new Font("黑体",Font.BOLD,20));
		lblPassword.setForeground(Color.BLACK);
		lblcfgpassword = new JLabel("确认密码:",JLabel.RIGHT);
		lblcfgpassword.setFont(new Font("黑体",Font.BOLD,20));
		lblcfgpassword.setForeground(Color.BLACK);
		lblAge = new JLabel("年龄:",JLabel.RIGHT);
		lblAge.setFont(new Font("黑体",Font.BOLD,20));
		lblAge.setForeground(Color.BLACK);
		lblSex = new JLabel("性别:",JLabel.RIGHT);
		lblSex.setFont(new Font("黑体",Font.BOLD,20));
		lblSex.setForeground(Color.BLACK);
		lblNation = new JLabel("民族:",JLabel.RIGHT);
		lblNation.setFont(new Font("黑体",Font.BOLD,20));
		lblNation.setForeground(Color.BLACK);
		lblStar = new JLabel("星座:",JLabel.RIGHT);
		lblStar.setFont(new Font("黑体",Font.BOLD,20));
		lblStar.setForeground(Color.BLACK);
		lblBlood = new JLabel("血型:",JLabel.RIGHT);
		lblBlood.setFont(new Font("黑体",Font.BOLD,20));
		lblBlood.setForeground(Color.BLACK);
		lblHobit = new JLabel("兴趣爱好:",JLabel.RIGHT);
		lblHobit.setFont(new Font("黑体",Font.BOLD,20));
		lblHobit.setForeground(Color.BLACK);
		lblIpAddr = new JLabel("IP地址:",JLabel.RIGHT);
		lblIpAddr.setFont(new Font("黑体",Font.BOLD,20));
		lblIpAddr.setForeground(Color.BLACK);
		lblPort = new JLabel("端口:",JLabel.RIGHT);
		lblPort.setFont(new Font("黑体",Font.BOLD,20));
		lblPort.setForeground(Color.BLACK);
		lblRemark = new JLabel("备注:",JLabel.RIGHT);
		lblRemark.setFont(new Font("黑体",Font.BOLD,20));
		lblRemark.setForeground(Color.BLACK);
		
		txtQQcode = new JTextField(10);
		txtQQcode.setEditable(false);
		txtQQcode.setText("系统自动生成");
		txtNickName = new JTextField(10);
		cbHeadImg = new JComboBox(headIcon);
		txtPassword = new JPasswordField(10);
		txtPassword.setEchoChar('*');
		txtcfgPassword = new JPasswordField(10);
		txtcfgPassword.setEchoChar('*');
		txtAge = new JTextField(5);
		rbMale = new JRadioButton("男",true);
		rbMale.setFont(new Font("黑体",Font.BOLD,20));
		rbMale.setForeground(Color.BLACK);
		rbRemale = new JRadioButton("女");
		rbRemale.setFont(new Font("黑体",Font.BOLD,20));
		rbRemale.setForeground(Color.BLACK);
		bg = new ButtonGroup();
		bg.add(rbMale);
		bg.add(rbRemale);
		cbNation = new JComboBox(sNation);
		cbStar = new JComboBox(sStar);
		cbBlood = new JComboBox(sBlood);
		txtHobit = new JTextField(20);
		InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		txtIpAddr = new JTextField(addr.getHostAddress());
		txtPort = new JTextField(5);
		txtPort.setEditable(false);
		txtPort.setText("系统自动生成");
		taRemark = new JTextArea(3,80);
		
		lblQQcode.setBounds(0, 100, 120, 30);
		txtQQcode.setBounds(130, 100, 180, 30);
		lblnickName.setBounds(0, 140, 120, 30);
		txtNickName.setBounds(130, 140, 180, 30);
		
		lblHeadImg.setBounds(380, 100, 80, 60);
		cbHeadImg.setBounds(460, 100, 80, 60);
		lblPassword.setBounds(0, 180, 120, 30);
		txtPassword.setBounds(130, 180, 180, 30);
		lblcfgpassword.setBounds(340, 180, 120, 30);
		txtcfgPassword.setBounds(460, 180, 160, 30);
		
		
		lblAge.setBounds(0, 220, 120, 30);
		txtAge.setBounds(130, 220, 90, 30);
		lblSex.setBounds(380, 210, 80, 60);
		rbMale.setBounds(460, 210, 80, 60);
		rbMale.setOpaque(false);
		rbRemale.setBounds(520, 210, 80, 60);
		rbRemale.setOpaque(false);
		
		lblNation.setBounds(0, 260, 120, 30);
		cbNation.setBounds(130, 260, 90, 30);
		lblStar.setBounds(0, 300, 120, 30);
		cbStar.setBounds(130, 300, 90, 30);
		lblBlood.setBounds(0, 340, 120, 30);
		cbBlood.setBounds(130, 340, 90, 30);
		lblHobit.setBounds(0, 380, 120, 30);
		txtHobit.setBounds(130, 380, 490, 30);
		lblIpAddr.setBounds(340, 280, 120, 30);
		txtIpAddr.setBounds(460, 280, 160, 30);
		lblPort.setBounds(340, 320, 120, 30);
		txtPort.setBounds(460, 320, 160, 30);
		lblRemark.setBounds(0, 420, 120, 30);
		taRemark.setBounds(130, 420, 490, 60);
		
		
		lblBg.add(lblQQcode);
		lblBg.add(txtQQcode);
		lblBg.add(lblnickName);
		lblBg.add(txtNickName);
		lblBg.add(lblHeadImg);
		lblBg.add(cbHeadImg);
		lblBg.add(lblPassword);
		lblBg.add(txtPassword);
		lblBg.add(lblcfgpassword);
		lblBg.add(txtcfgPassword);
		lblBg.add(lblAge);
		lblBg.add(txtAge);
		lblBg.add(lblSex);
		lblBg.add(rbMale);
		lblBg.add(rbRemale);
		lblBg.add(lblNation);
		lblBg.add(cbNation);
		lblBg.add(lblStar);
		lblBg.add(cbStar);
		lblBg.add(lblBlood);
		lblBg.add(cbBlood);
		lblBg.add(lblHobit);
		lblBg.add(txtHobit);
		lblBg.add(lblIpAddr);
		lblBg.add(txtIpAddr);
		lblBg.add(lblPort);
		lblBg.add(txtPort);
		lblBg.add(lblRemark);
		lblBg.add(taRemark);
		
		btnSave = new JButton("保存(S)");
		btnSave.setMnemonic('S');
		btnClose = new JButton("退出(C)");
		btnClose.setMnemonic('C');
		
		btnSave.setBounds(210, 520, 90, 40);
		btnClose.setBounds(420, 520, 90, 40);
		lblBg.add(btnSave);
		lblBg.add(btnClose);
		btnSave.addActionListener(this);
		btnClose.addActionListener(this);
		setUndecorated(true);
		
		setResizable(false);
		setSize(650, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public static void main(String[] args){
		new RegUI();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSave){
			String nickname = txtNickName.getText().trim();
			if(nickname.equals("")){
				JOptionPane.showMessageDialog(this, "请输入昵称");
				return;
			}
			String pass = txtPassword.getText().trim();
			String cfgpass = txtcfgPassword.getText().trim();
			if(pass.equals("")){
				JOptionPane.showMessageDialog(this, "请输入登录密码");
				return;
			}
			if(!pass.equals(cfgpass)){
				JOptionPane.showMessageDialog(this, "登录密码与确认密码不一致");
				return;
			}
			int age=0;
			String sage = txtAge.getText().trim();
			if(sage.equals("")){
				JOptionPane.showMessageDialog(this, "请输入年龄");
				txtAge.setText("0");
				return;
			}
			try{
				age = Integer.parseInt(sage);
			}catch (Exception e1) {
				JOptionPane.showMessageDialog(this, "请输入0~150之间的年龄");
				return;
			}
			if(age<0 || age>150){
				JOptionPane.showMessageDialog(this, "请输入0~150之间的年龄");
				return;
				
			}
			AccountVo account = new AccountVo();
			account.setNickName(nickname);
			account.setHeadImg(sHeadImg[cbHeadImg.getSelectedIndex()]);
			account.setPassword(pass);
			account.setAge(age);
			if(rbMale.isSelected()){
				account.setSex("男");
			}else {
				account.setSex("女");
			}
			account.setNation(sNation[cbNation.getSelectedIndex()]);
			account.setStar(sStar[cbStar.getSelectedIndex()]);
			account.setBlood(sBlood[cbBlood.getSelectedIndex()]);
			account.setHobit(txtHobit.getText().trim());
			account.setIpAddr(txtIpAddr.getText().trim());
			account.setRemark(taRemark.getText().trim());
			BaseDAO baseDAO = new BaseDAO();
			account=baseDAO.saveAccount(account);
			txtQQcode.setText(account.getQqCode()+"");
			txtPort.setText("0");
			
			JOptionPane.showConfirmDialog(this, "恭喜你,注册成功！你的qq号码为"+account.getQqCode());
		}else if(e.getSource()==btnClose){
			dispose();
		}
	}
	

}
