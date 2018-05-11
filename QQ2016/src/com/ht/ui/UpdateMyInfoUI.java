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

import sun.applet.Main;

import com.ht.db.BaseDAO;
import com.ht.vo.AccountVo;


public class UpdateMyInfoUI extends JFrame implements ActionListener{
	private JLabel lblQQcode,lblnickName,lblHeadImg,lblAge;
	private JLabel lblSex,lblNation,lblStar,lblBlood;
	private JLabel lblRemark,lblHobit;
	private JTextField txtQQcode,txtNickName,txtAge,txtHobit;
	private JRadioButton rbMale,rbRemale;
	private JComboBox cbNation,cbStar,cbBlood,cbHeadImg;
	private JTextArea taRemark;
	private ButtonGroup bg;
	private JLabel lblBg;
	private JButton btnSave,btnClose;
	private AccountVo myInfo;
	private MainUI mainUI;
	
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
	public UpdateMyInfoUI(){
		
	}
	public UpdateMyInfoUI(AccountVo myInfo,MainUI mainUI){
		this.myInfo=myInfo;
		this.mainUI=mainUI;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("images/qt.png");
		setIconImage(image);
		lblBg = new JLabel(new ImageIcon("images/2.jpg"));
		add(lblBg);
		lblBg.setLayout(null);
		JLabel title = new JLabel("修改用户个人资料",JLabel.CENTER);
		title.setFont(new Font("黑体",Font.BOLD,20));
		title.setForeground(Color.BLACK);
		title.setBounds(150, 30, 200, 40);
		lblBg.add(title);
		
		lblQQcode = new JLabel("QQ号码:",JLabel.RIGHT);
		lblnickName = new JLabel("昵称:",JLabel.RIGHT);
		
		lblHeadImg = new JLabel("头像:",JLabel.RIGHT);
		
		lblAge = new JLabel("年龄:",JLabel.RIGHT);
		
		lblSex = new JLabel("性别:",JLabel.RIGHT);
		
		lblNation = new JLabel("民族:",JLabel.RIGHT);
		
		lblStar = new JLabel("星座:",JLabel.RIGHT);
		
		lblBlood = new JLabel("血型:",JLabel.RIGHT);
		
		lblHobit = new JLabel("兴趣爱好:",JLabel.RIGHT);
		
		lblRemark = new JLabel("备注:",JLabel.RIGHT);

		
		txtQQcode = new JTextField(10);
		txtQQcode.setText(myInfo.getQqCode()+"");
		txtNickName = new JTextField(myInfo.getNickName());
		cbHeadImg = new JComboBox(headIcon);
		for (int i=0;i<sHeadImg.length;i++) {
			if(sHeadImg[i].equals(myInfo.getHeadImg())){
				cbHeadImg.setSelectedIndex(i);
				break;
			}
		}
		txtAge = new JTextField(myInfo.getAge()+"");
		if(myInfo.getSex().equals("男")){
			rbMale = new JRadioButton("男",true);
			rbRemale = new JRadioButton("女");
		}else {
			rbMale = new JRadioButton("男");
			rbRemale = new JRadioButton("女",true);
		}
		bg = new ButtonGroup();
		bg.add(rbMale);
		bg.add(rbRemale);
		cbNation = new JComboBox(sNation);
		for (int i=0;i<sNation.length;i++) {
			if(sNation[i].equals(myInfo.getNation())){
				cbNation.setSelectedIndex(i);
				break;
			}
		}
		cbStar = new JComboBox(sStar);
		for (int i=0;i<sStar.length;i++) {
			if(sStar[i].equals(myInfo.getStar())){
				cbStar.setSelectedIndex(i);
				break;
			}
		}
		cbBlood = new JComboBox(sBlood);
		for (int i=0;i<sBlood.length;i++) {
			if(sBlood[i].equals(myInfo.getBlood())){
				cbBlood.setSelectedIndex(i);
				break;
			}
		}
		txtHobit = new JTextField(myInfo.getHobit());
		taRemark = new JTextArea(myInfo.getRemark());
		
		lblQQcode.setBounds(0, 100, 120, 30);
		txtQQcode.setBounds(130, 100, 180, 30);
		lblnickName.setBounds(0, 140, 120, 30);
		txtNickName.setBounds(130, 140, 180, 30);
		
		lblHeadImg.setBounds(360, 100, 80, 60);
		cbHeadImg.setBounds(440, 100, 80, 60);
		
		
		lblAge.setBounds(0, 180, 120, 30);
		txtAge.setBounds(130, 180, 90, 30);
		lblSex.setBounds(360, 210, 80, 60);
		rbMale.setBounds(440, 210, 80, 60);
		rbMale.setOpaque(false);
		rbRemale.setBounds(520, 210, 80, 60);
		rbRemale.setOpaque(false);
		
		lblNation.setBounds(0, 220, 120, 30);
		cbNation.setBounds(130, 220, 90, 30);
		lblStar.setBounds(0, 260, 120, 30);
		cbStar.setBounds(130, 260, 90, 30);
		lblBlood.setBounds(0, 300, 120, 30);
		cbBlood.setBounds(130, 300, 90, 30);
		lblHobit.setBounds(0, 340, 120, 30);
		txtHobit.setBounds(130, 340, 250, 30);
		lblRemark.setBounds(0, 380, 120, 30);
		taRemark.setBounds(130, 380, 250, 60);
		
		
		lblBg.add(lblQQcode);
		lblBg.add(txtQQcode);
		lblBg.add(lblnickName);
		lblBg.add(txtNickName);
		lblBg.add(lblHeadImg);
		lblBg.add(cbHeadImg);
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
		lblBg.add(lblRemark);
		lblBg.add(taRemark);
		
		btnSave = new JButton("保存(S)");
		btnSave.setMnemonic('S');
		btnClose = new JButton("退出(C)");
		btnClose.setMnemonic('C');
		
		btnSave.setBounds(180, 520, 90, 40);
		btnClose.setBounds(360, 520, 90, 40);
		lblBg.add(btnSave);
		lblBg.add(btnClose);
		btnSave.addActionListener(this);
		btnClose.addActionListener(this);
		setUndecorated(true);
		
		setResizable(false);
		setSize(560, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public static void main(String[] args){
		new UpdateMyInfoUI();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSave){
			String nickname = txtNickName.getText().trim();
			if(nickname.equals("")){
				JOptionPane.showMessageDialog(this, "请输入昵称");
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
			myInfo.setNickName(nickname);
			myInfo.setHeadImg(sHeadImg[cbHeadImg.getSelectedIndex()]);
			myInfo.setAge(age);
			if(rbMale.isSelected()){
				myInfo.setSex("男");
			}else {
				myInfo.setSex("女");
			}
			myInfo.setNation(sNation[cbNation.getSelectedIndex()]);
			myInfo.setStar(sStar[cbStar.getSelectedIndex()]);
			myInfo.setBlood(sBlood[cbBlood.getSelectedIndex()]);
			myInfo.setHobit(txtHobit.getText().trim());
			myInfo.setRemark(taRemark.getText().trim());
			BaseDAO baseDAO = new BaseDAO();
			myInfo=baseDAO.updateAccount(myInfo);
			JOptionPane.showConfirmDialog(this, "恭喜你修改成功!");
			ImageIcon icon = new ImageIcon(myInfo.getHeadImg());
			String nickName = myInfo.getNickName()+"("+myInfo.getQqCode()+")【"+myInfo.getRemark()+"】";
			mainUI.lblMyInfo.setIcon(icon);
			mainUI.lblMyInfo.setText(nickName);
			dispose();
			
		}else if(e.getSource()==btnClose){
			dispose();
		}
	}
	

}
