package com.ht.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.ht.vo.AccountVo;


public class LookInfoUI extends JFrame implements MouseListener{
	private JLabel lblQQcode,lblnickName,lblHeadImg,lblAge;
	private JLabel lblSex,lblNation,lblStar,lblBlood;
	private JLabel lblRemark,lblHobit,lblBg;
	
	public LookInfoUI(){}
	public LookInfoUI(AccountVo myInfo){
		setIconImage(new ImageIcon("images/tubiao.png").getImage());
		lblBg = new JLabel(new ImageIcon("images/5.jpg"));
		add(lblBg);
		lblBg.setLayout(null);
		JLabel title = new JLabel("好友资料",JLabel.CENTER);
		title.setFont(new Font("黑体",Font.BOLD,20));
		title.setForeground(Color.BLACK);
		title.setBounds(0, 30, 200, 40);
		lblBg.add(title);
		
		lblQQcode = new JLabel("QQ号码:"+myInfo.getQqCode(),JLabel.LEFT);
		lblnickName = new JLabel("昵称:"+myInfo.getNickName(),JLabel.LEFT);
		
		lblHeadImg = new JLabel(new ImageIcon(myInfo.getHeadImg()));
		
		lblAge = new JLabel("年龄:"+myInfo.getAge(),JLabel.LEFT);
		
		lblSex = new JLabel("性别:"+myInfo.getSex(),JLabel.LEFT);
		
		lblNation = new JLabel("民族:"+myInfo.getNation(),JLabel.LEFT);
		
		lblStar = new JLabel("星座:"+myInfo.getStar(),JLabel.LEFT);
		
		lblBlood = new JLabel("血型:"+myInfo.getBlood()+"型",JLabel.LEFT);
		
		lblHobit = new JLabel("兴趣爱好:"+myInfo.getHobit(),JLabel.LEFT);
		
		lblRemark = new JLabel("备注:"+myInfo.getRemark(),JLabel.LEFT);

		
		
		
		
		lblQQcode.setBounds(50, 100, 120, 30);
		lblnickName.setBounds(50, 140, 120, 30);
		lblHeadImg.setBounds(300, 100, 80, 60);
		lblAge.setBounds(50, 180, 120, 30);
		lblSex.setBounds(300, 180, 80, 60);
		lblNation.setBounds(50, 220, 120, 30);
		lblStar.setBounds(50, 260, 120, 30);
		lblBlood.setBounds(50, 300, 120, 30);
		lblHobit.setBounds(10, 340, 300, 30);
		lblRemark.setBounds(10, 380, 300, 30);
		lblBg.add(lblQQcode);
		lblBg.add(lblnickName);
		lblBg.add(lblHeadImg);
		lblBg.add(lblAge);
		lblBg.add(lblSex);
		lblBg.add(lblNation);
		lblBg.add(lblStar);
		lblBg.add(lblBlood);
		lblBg.add(lblHobit);
		lblBg.add(lblRemark);
		addMouseListener(this);
		
		setUndecorated(true);
		setResizable(false);
		setSize(500, 480);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public static void main(String[] args){
		new LookInfoUI();
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		dispose();
		
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
