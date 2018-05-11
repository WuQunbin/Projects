package com.ht.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
 
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.Element;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.ht.base.Cmd;
import com.ht.base.SendCmd;
import com.ht.base.SendMsg;
import com.ht.vo.AccountVo;



public class ChatUI extends JFrame implements ActionListener,ItemListener{
	JLabel title;
	JTextPane txtReceive,txtsend;
	JButton btnSend,btnClose;
	JButton btnShake,btnFile,btnColor,btnFace;
	JComboBox cbFont,cbSize;
	AccountVo myInfo,friendInfo;
	Vector<AccountVo> familyGroup;
	String sFont[] = {"宋体","黑体","楷体","隶书"};
	String sSize[] = {"8","10","12","14","16","18","24","28","32","36","72"};
	Font font;
	public ChatUI(AccountVo myInfo,AccountVo friendInfoVo,Vector<AccountVo> familyGroup){
		this.myInfo = myInfo;
		this.friendInfo = friendInfoVo;
		this.familyGroup = familyGroup;
		String str = myInfo.getNickName()+"("+myInfo.getQqCode()+")和";
		str += friendInfo.getNickName()+"("+friendInfo.getQqCode()+")正在聊天...";
		setTitle(str);
		setIconImage(new ImageIcon(friendInfo.getHeadImg()).getImage());
		title = new JLabel(str,new ImageIcon(friendInfo.getHeadImg()),JLabel.LEFT);
		title.setForeground(Color.WHITE);
		title.setOpaque(false);
		JLabel titlelebg = new JLabel(new ImageIcon("images/26.jpg"));
		titlelebg.setLayout(new FlowLayout(FlowLayout.LEFT));
		titlelebg.add(title);
		add(titlelebg,BorderLayout.NORTH);
		JPanel centerPanel= new JPanel(new GridLayout(2,1,1,1));
		txtReceive = new JTextPane();
		centerPanel.add(new JScrollPane(txtReceive));
		JPanel sendPanel = new JPanel(new BorderLayout());
		JLabel btnPanel = new JLabel(new ImageIcon("images/1 (2).jpg"));
		btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		cbFont = new JComboBox(sFont);
		cbSize = new JComboBox(sSize);
		cbFont.addItemListener(this);
		cbSize.addItemListener(this);
		btnShake = new JButton(new ImageIcon("images/zd.png"));
		btnShake.setMargin(new Insets(0,0,0,0));
		btnFile = new JButton("文件");
		btnColor = new JButton("颜色");
		btnFace = new JButton(new ImageIcon("images/sendFace.png"));
		btnFace.setMargin(new Insets(0,0,0,0));
		
		btnColor.addActionListener(this);
		btnShake.addActionListener(this);
		btnFile.addActionListener(this);
		btnFace.addActionListener(this);

		btnPanel.add(cbFont);
		btnPanel.add(cbSize);
		btnPanel.add(btnColor);
		btnPanel.add(btnShake);
		btnPanel.add(btnFace);
		btnPanel.add(btnFile);
		sendPanel.add(btnPanel,BorderLayout.NORTH);
	
		txtsend = new JTextPane();
		sendPanel.add(txtsend,BorderLayout.CENTER);
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnSend = new JButton("发送(S)");
		btnSend.setMnemonic('S');
		btnClose = new JButton("关闭(X)");
		btnClose.setMnemonic('X');
		btnSend.addActionListener(this);
		btnClose.addActionListener(this);
		JLabel bottombg = new JLabel(new ImageIcon("images/1 (2).jpg"));
		bottombg.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bottombg.add(btnSend);
		bottombg.add(btnClose);
		sendPanel.add(bottombg,BorderLayout.SOUTH);
		centerPanel.add(new JScrollPane(sendPanel)); 
		add(centerPanel);
		JLabel lblboy = new JLabel(new ImageIcon("images/fpi.jpg"));
		add(lblboy,BorderLayout.EAST);
		
		
		setSize(700,500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public void appendView(String name,StyledDocument xx)throws BadLocationException{
		StyledDocument vdoc = txtReceive.getStyledDocument();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(date);
		SimpleAttributeSet as = new SimpleAttributeSet();
		String s = name + "    "+ time + "\n";
		vdoc.insertString(vdoc.getLength(), s, as);
		int end = 0;
		while(end<xx.getLength()){
				Element e0 = xx.getCharacterElement(end);
				SimpleAttributeSet as1 = new SimpleAttributeSet();
				StyleConstants.setForeground(as1, StyleConstants.getForeground(e0.getAttributes()));
				StyleConstants.setFontSize(as1, StyleConstants.getFontSize(e0.getAttributes()));
				StyleConstants.setFontFamily(as1, StyleConstants.getFontFamily(e0.getAttributes()));
				s = e0.getDocument().getText(end, e0.getEndOffset() - end);
				if("icon".equals(e0.getName())){
					vdoc.insertString(vdoc.getLength(), s, e0.getAttributes());
				}else {
					vdoc.insertString(vdoc.getLength(), s, as1);
				}
				end = e0.getEndOffset();
		}
			vdoc.insertString(vdoc.getLength(), "\n", as);
			txtReceive.setCaretPosition(vdoc.getLength());
	}
	public static void main(String[] args){
		new ChatUI(null,null,null);
	}
	public void shake(){
		int x = this.getLocation().x;
		int y = this.getLocation().y;
		for(int i=0;i<20;i++){
			if(i%2==0){
				this.setLocation(x+2, y+2);
			}else{
				this.setLocation(x-2, y-2);
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnShake){
			SendMsg msg = new SendMsg();
			msg.cmd = Cmd.CMD_SHAKE;
			msg.myInfo = myInfo;
			msg.friendInfo = friendInfo;
			SendCmd.send(msg);
			shake();
		}else if(e.getSource()==btnColor){
			JColorChooser colordig = new JColorChooser();
			Color color = colordig.showDialog(this, "请选择字体颜色", Color.BLACK);
			txtsend.setForeground(color);
		}else if(e.getSource()==btnFace){
			int x,y;
			x=this.getLocation().x+250;
			y=this.getLocation().y-60;
			new BqUI(this,x,y);
		}else if(e.getSource()==btnFile){
			FileDialog dlg = new FileDialog(this,"选择要发送的文件(64K以下)",FileDialog.LOAD);
			dlg.show();
			String filename = dlg.getDirectory() + dlg.getFile();
			try {
				FileInputStream fis = new FileInputStream(filename);
				int size = fis.available();
				byte b[] = new byte[size];
				fis.read(b);
				SendMsg msg = new SendMsg();
				msg.cmd = Cmd.CMD_FILE;
				msg.myInfo = myInfo;
				msg.friendInfo = friendInfo;
				msg.b = b;
				msg.fileName = dlg.getFile();
				SendCmd.send(msg);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.print(filename);
		}else if(e.getSource()==btnSend){
			if(txtsend.getText().equals("")){
				JOptionPane.showMessageDialog(this, "请输入你要发送的内容");
				return;
			}
			try {
				appendView(myInfo.getNickName(), txtsend.getStyledDocument());
				if(friendInfo.getGroupName()!=null && friendInfo.getGroupName().equals(Cmd.GROUPNAME[2])){
					SendCmd.sendAll(familyGroup, myInfo, Cmd.CMD_SEND,txtsend.getStyledDocument());
				}else{
					SendMsg msg = new SendMsg();
					msg.cmd = Cmd.CMD_SEND;
					msg.myInfo = myInfo;
					msg.friendInfo = friendInfo;
					msg.doc = txtsend.getStyledDocument();
					SendCmd.send(msg);
				}
				txtsend.setText("");
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource()==btnClose){
			dispose();
		}
		
	}
	public void setFont(){
		String sf = sFont[cbFont.getSelectedIndex()];
		String size = sSize[cbSize.getSelectedIndex()];
		font = new Font(sf,Font.PLAIN,Integer.parseInt(size));
		txtsend.setFont(font);
	}
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==cbFont){
			setFont();
		}else if(e.getSource()==cbSize){
			setFont();
		}
	}
	
	
	
}
