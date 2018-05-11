package com.ht.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;

import com.ht.base.Cmd;
import com.ht.base.SendCmd;
import com.ht.base.SendMsg;
import com.ht.base.Sound;
import com.ht.db.BaseDAO;
import com.ht.db.Demo;
import com.ht.vo.AccountVo;

public class MainUI extends JFrame implements ActionListener,MouseListener,ItemListener,WindowListener{
	JLabel bgImg,lblMyInfo,lblMusic;
	JTabbedPane tabPanel;
	JList listFriend,listmate,listFamliy,listHmd;
	JButton btnGame,btnFind,btnChangebj;
	JPopupMenu popMenu;
	JMenuItem miChat,miFriend,mimate,miFamliy,miHmd,milookInfo,miDel;
	JComboBox cbstate;
	AccountVo myInfo,friendInfo;
	Vector<AccountVo> vAllInfo,vFriend,vmate,vFamliy,vHmd;
	BaseDAO baseDAO = new BaseDAO();
	TrayIcon trayIcon;
	PopupMenu popTray;
	MenuItem miOpen,miExit,miOnline,miLevel,miBuys;
	Hashtable<Integer, ChatUI> chatWin = new Hashtable<Integer, ChatUI>();
	public MainUI(){
		
	}
	public MainUI(AccountVo myInfo){
		this.myInfo = myInfo;
		addWindowListener(this);
		setIconImage(new ImageIcon(myInfo.getHeadImg()).getImage());
		setResizable(false);
		bgImg = new JLabel(new ImageIcon("images/106_2.jpg"));
		bgImg.setLayout(new BorderLayout());
		bgImg.setOpaque(false);
		add(bgImg);
		vAllInfo = new Vector<AccountVo>();
		vFriend = new Vector<AccountVo>();
		vmate = new Vector<AccountVo>();
		vFamliy = new Vector<AccountVo>();
		vHmd = new Vector<AccountVo>();
		listFriend = new JList();
		listmate = new JList();
		listFamliy = new JList();
		listHmd = new JList();
		refresh();

		listFriend.setBackground(new Color(0,0,0,0));
		listFriend.setOpaque(false);
		listmate.setBackground(new Color(0,0,0,0));
		listmate.setOpaque(false);
		listFamliy.setBackground(new Color(0,0,0,0));
		listFamliy.setOpaque(false);
		listHmd.setBackground(new Color(0,0,0,0));
		listHmd.setOpaque(false);

		listFriend.addMouseListener(this);
		listmate.addMouseListener(this);
		listFamliy.addMouseListener(this);
		listHmd.addMouseListener(this);
		
		
		UIManager.put("TabbedPane.contentOpaque", false);
		tabPanel = new JTabbedPane();
		tabPanel.setOpaque(false);
		tabPanel.addTab("好友",listFriend);
		tabPanel.addTab("同学",listmate);
		tabPanel.addTab("家人群",listFamliy);
		tabPanel.addTab("黑名单",listHmd);
		
		bgImg.add(tabPanel);

		
		ImageIcon icon = new ImageIcon(myInfo.getHeadImg());
		String nickName = myInfo.getNickName()+"("+myInfo.getQqCode()+")【"+myInfo.getRemark()+"】";
		lblMyInfo = new JLabel(nickName,icon,JLabel.LEFT);
		bgImg.add(lblMyInfo,BorderLayout.NORTH);
		lblMyInfo.addMouseListener(this);
		
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bottomPanel.setOpaque(false);
		lblMusic = new JLabel(new ImageIcon("images/music.png"));
		lblMusic.addMouseListener(this);
		btnGame = new JButton("游戏");
		btnFind = new JButton("查找");
		btnChangebj = new JButton("换肤");
		btnGame.addActionListener(this);
		btnFind.addActionListener(this);
		btnChangebj.addActionListener(this);
		cbstate = new JComboBox(Cmd.STATUS);
		cbstate.addItemListener(this);
		cbstate.removeItemAt(1);
		
		bottomPanel.add(lblMusic);
		bottomPanel.add(btnGame);
		bottomPanel.add(btnFind);
		bottomPanel.add(btnChangebj);
		bottomPanel.add(cbstate);
		bgImg.add(bottomPanel,BorderLayout.SOUTH);
		createMenu();
		new ReceiveThread().start();
		SendCmd.sendAll(vAllInfo, myInfo, Cmd.CMD_ONLINE);
		createTrayMenu();
		setTrayIcon();
		
		setSize(300,700);
		setVisible(true);
		setLocation(1050, 50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void createMenu(){
		miChat = new JMenuItem("聊天");
		miFriend = new JMenuItem("移动到好友");
		mimate = new JMenuItem("移动到同学");
		miFamliy = new JMenuItem("移动到家人群");
		miHmd = new JMenuItem("移动到黑名单");
		milookInfo = new JMenuItem("查看好友信息");
		miDel = new JMenuItem("删除好友资料");
		
		miChat.addActionListener(this);
		miFriend.addActionListener(this);
		mimate.addActionListener(this);
		miFamliy.addActionListener(this);
		miHmd.addActionListener(this);
		milookInfo.addActionListener(this);
		miDel.addActionListener(this);
		
		popMenu = new JPopupMenu();
		popMenu.add(miChat);
		popMenu.add(miFriend);
		popMenu.add(mimate);
		popMenu.add(miFamliy);
		popMenu.add(miHmd);
		popMenu.add(milookInfo);
		popMenu.add(miDel);
	}
	
	private void refresh(){
		vAllInfo = baseDAO.getMyFriend(myInfo.getQqCode());
		vmate.clear();
		vFriend.clear();
		vFamliy.clear();
		vHmd.clear();
		
		for(AccountVo acc : vAllInfo){
			String groupName = acc.getGroupName();
			if(groupName.equals(Cmd.GROUPNAME[0])){
				vmate.add(acc);
			}else if(groupName.equals(Cmd.GROUPNAME[1])){
				vFriend.add(acc);
			}else if(groupName.equals(Cmd.GROUPNAME[2])){
				vFamliy.add(acc);
			}else if(groupName.equals(Cmd.GROUPNAME[3])){
				vHmd.add(acc);
			}	
		}
		listFriend.setModel(new DataModel(vFriend));
		listmate.setModel(new DataModel(vmate));
		listFamliy.setModel(new DataModel(vFamliy));
		listHmd.setModel(new DataModel(vHmd));
		listFriend.setCellRenderer(new MyHeadImg(vFriend));
		listmate.setCellRenderer(new MyHeadImg(vmate));
		listFamliy.setCellRenderer(new MyHeadImg(vFamliy));
		listHmd.setCellRenderer(new MyHeadImg(vHmd));

		
		
	}
	public static void main(String[] args){
		new MainUI();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnChangebj){
				JFileChooser dlg = new JFileChooser();
				dlg.setDialogType(JFileChooser.OPEN_DIALOG);
				dlg.setFileSelectionMode(JFileChooser.FILES_ONLY);
				dlg.setDialogTitle("更换皮肤");
				if(dlg.showOpenDialog(this)==dlg.APPROVE_OPTION){
					java.io.File file = dlg.getSelectedFile();
					String path = file.getPath();
					bgImg.setIcon(new ImageIcon(path));
				}
		}else if(e.getSource()==milookInfo){
//			friendInfo = vFriend.get(listFriend.getSelectedIndex());
			new LookInfoUI(friendInfo);
		}else if(e.getSource()==miFriend){
			baseDAO.moveGroup(myInfo.getQqCode(), friendInfo.getQqCode(), Cmd.GROUPNAME[1]);
			refresh();
		}else if(e.getSource()==mimate){
			baseDAO.moveGroup(myInfo.getQqCode(), friendInfo.getQqCode(), Cmd.GROUPNAME[0]);
			refresh();
		}else if(e.getSource()==miFamliy){
			baseDAO.moveGroup(myInfo.getQqCode(), friendInfo.getQqCode(), Cmd.GROUPNAME[2]);
			refresh();
		}else if(e.getSource()==miHmd){
			baseDAO.moveGroup(myInfo.getQqCode(), friendInfo.getQqCode(), Cmd.GROUPNAME[3]);
			refresh();
		}else if(e.getSource()==btnFind){
			new FindUI(myInfo);
		}else if(e.getSource()==miChat){
			openChat();
		}else if(e.getSource()==miOpen){
			SystemTray tray = SystemTray.getSystemTray();
			tray.remove(trayIcon);
			MainUI.this.setVisible(true);
			MainUI.this.setState(JFrame.NORMAL);
		}else if(e.getSource()==miExit){
			baseDAO.changStatus(myInfo.getQqCode(), Cmd.STATUS[1]);
			myInfo.setOnlinestatus(Cmd.STATUS[1]);
			SendCmd.sendAll(vAllInfo, myInfo, Cmd.CMD_OFFLINE);
			System.exit(0);
		}else if(e.getSource()==miBuys){
			String status = Cmd.STATUS[2];
			changState(status);
			baseDAO.changStatus(myInfo.getQqCode(), status);
			SendCmd.sendAll(vAllInfo, myInfo, Cmd.CMD_CHANGESTATE);
		}else if(e.getSource()==miLevel){
			String status = Cmd.STATUS[3];
			changState(status);
			baseDAO.changStatus(myInfo.getQqCode(), status);
			SendCmd.sendAll(vAllInfo, myInfo, Cmd.CMD_CHANGESTATE);
		}else if(e.getSource()==miOnline){
			String status = Cmd.STATUS[0];
			changState(status);
			baseDAO.changStatus(myInfo.getQqCode(), status);
			SendCmd.sendAll(vAllInfo, myInfo, Cmd.CMD_CHANGESTATE);
		}else if(e.getSource()==miDel){
			baseDAO.delFriend(myInfo.getQqCode(), friendInfo.getQqCode());
			refresh();
			SendMsg msg = new SendMsg();
			msg.cmd = Cmd.CMD_DELETE;
			msg.myInfo = myInfo;
			msg.friendInfo = friendInfo;
			SendCmd.send(msg);
		}else if(e.getSource()==btnGame){
			new Demo("植物大战僵尸2");
		}
		
	}
	//显示文本信息
	class DataModel extends AbstractListModel {
		Vector<AccountVo> data;
		public DataModel() {
				
		}
		public DataModel(Vector<AccountVo> data) {
			this.data = data;
		}
	    //系统自动运行，下标从0开始计算
	    public Object getElementAt(int index) {
	    	AccountVo info = data.get(index);
	    	return info.getNickName()+"("+info.getQqCode()+")【"+info.getRemark()+"]";
	    }

	    public int getSize() {
	        return data.size();
	    }
	    
	}
	// 获取好友头像
	class MyHeadImg extends DefaultListCellRenderer {
		Vector<AccountVo> datas;
		public MyHeadImg(Vector<AccountVo> datas) {
			this.datas = datas;
		}
		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			Component c = super.getListCellRendererComponent(list, value,
					index, isSelected, cellHasFocus);
			if (index >= 0 && index < datas.size()) {
				AccountVo user =  datas.get(index);
				String status = user.getOnlinestatus();
				String headImag = user.getHeadImg();
				String filename="";
				if(status.equals(Cmd.STATUS[0])){
					filename = headImag;
				}else if (status.equals(Cmd.STATUS[1])) {
					int pos = headImag.indexOf('.');
					String pre = headImag.substring(0, pos);
					String fix = headImag.substring(pos,headImag.length());
					filename = pre + "_h"+fix;
					
				}else if (status.equals(Cmd.STATUS[2])) {
					int pos = headImag.indexOf('.');
					String pre = headImag.substring(0, pos);
					String fix = headImag.substring(pos,headImag.length());
					filename = pre + "_l"+fix;
					
				}else if (status.equals(Cmd.STATUS[3])) {
					int pos = headImag.indexOf('.');
					String pre = headImag.substring(0, pos);
					String fix = headImag.substring(pos,headImag.length());
					filename = pre + "_w"+fix;
					
				}
				// 给列表中好友状态设置头像
				System.out.println(filename);
				setIcon(new ImageIcon(filename));
				//设置文本内容
				setText(user.getNickName()+"("+user.getQqCode()+")【"+user.getRemark()+"]");
				System.out.println(user.getHeadImg());
			}
			// 设置字体颜色
			if (isSelected) {
				setBackground(list.getSelectionBackground());
				setForeground(list.getSelectionForeground());
			} else {
				setBackground(list.getBackground());
				setForeground(list.getForeground());
			}
			//设置有效
			setEnabled(list.isEnabled());
			//设置默认字体
			setFont(list.getFont());
//			setFont(new Font("宋体",Font.BOLD,14));
			//设置透明背景
			setOpaque(true);
			return this;
		}
	}
	public ChatUI openChat(){
		ChatUI chat = chatWin.get(friendInfo.getQqCode());
		if(chat==null){
			chat = new ChatUI(myInfo,friendInfo,vFamliy);
			chatWin.put(friendInfo.getQqCode(), chat);
		}
		chat.show();
		return chat;
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==lblMyInfo){
			if(e.getClickCount()==2){
				new UpdateMyInfoUI(myInfo,this);
			}
		}else if(e.getSource()==listFriend){
			if(listFriend.getSelectedIndex()>=0){
				friendInfo = vFriend.get(listFriend.getSelectedIndex());
			}
			//右键
			if(e.getButton()==3){
				if(listFriend.getSelectedIndex()>=0){
					popMenu.show(listFriend, e.getX(), e.getY());
				}
			}else if(e.getClickCount()==2){//双击
				if(listFriend.getSelectedIndex()>=0){
					openChat();
				}
			}
		}else if(e.getSource()==listmate){
			if(listmate.getSelectedIndex()>=0){
				friendInfo = vmate.get(listmate.getSelectedIndex());
			}
			if(e.getButton()==3){
				if(listmate.getSelectedIndex()>=0){
					popMenu.show(listmate, e.getX(), e.getY());
				}
			}else if(e.getClickCount()==2){//双击
				if(listmate.getSelectedIndex()>=0){
					openChat();
				}
			}
		}else if(e.getSource()==listFamliy){
			if(listFamliy.getSelectedIndex()>=0){
				friendInfo = vFamliy.get(listFamliy.getSelectedIndex());
			}
			if(e.getButton()==3){
				if(listFamliy.getSelectedIndex()>=0){
					popMenu.show(listFamliy, e.getX(), e.getY());
				}
			}else if(e.getClickCount()==2){//双击
				if(listFamliy.getSelectedIndex()>=0){
					openChat();
				}
			}
		}else if(e.getSource()==listHmd){
			if(e.getButton()==3){
				if(listHmd.getSelectedIndex()>=0){
					friendInfo = vHmd.get(listHmd.getSelectedIndex());
					popMenu.show(listHmd, e.getX(), e.getY());
				}
			}
		}else if(e.getSource()==lblMusic){
			new Demo("QQ音乐");
		}
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	class ReceiveThread extends Thread{
		public ReceiveThread(){
			
		}
		@Override
		public void run(){
			try {
				DatagramSocket socket = new DatagramSocket(myInfo.getPort());
				while(true){
					byte b[] = new byte[1024*520];
					DatagramPacket packet = new DatagramPacket(b,0,b.length);
					socket.receive(packet);
					ByteArrayInputStream bas = new ByteArrayInputStream(packet.getData());
					ObjectInputStream ois = new ObjectInputStream(bas);
					SendMsg msg = (SendMsg)ois.readObject();
					myInfo = msg.friendInfo;
					friendInfo = msg.myInfo;
					switch (msg.cmd) {
					case Cmd.CMD_ONLINE:
						refresh();
						new Sound(msg.cmd);
						new TipUI(friendInfo);
						break;
					case Cmd.CMD_LEVEF:
					case Cmd.CMD_BUYS:
						refresh();
						break;
					case Cmd.CMD_OFFLINE:
						refresh();
						new TipUI(friendInfo);
						break;
					case Cmd.CMD_CHANGESTATE:
						refresh();
						break;
					case Cmd.CMD_SEND:
						new Sound(msg.cmd);
						System.out.println("接收聊天消息...");
						ChatUI chat = openChat();
						try {
							chat.appendView(msg.myInfo.getNickName(), msg.doc);
						} catch (BadLocationException e) {
							e.printStackTrace();
						}
						break;
					case Cmd.CMD_SHAKE:
						new Sound(msg.cmd);
						chat = openChat();
						chat.shake();
						break;
					case Cmd.CMD_ADDFRI:
						new Sound(msg.cmd);
						String str = "【 "+friendInfo.getNickName()+"】请求添加你为好友,是否同意？";
						SendMsg msg2 = new SendMsg();
						if(JOptionPane.showConfirmDialog(null, str, "添加好友", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
							msg2.cmd = Cmd.CMD_ARGEE;
							baseDAO.addFriend(myInfo.getQqCode(), friendInfo.getQqCode());
							refresh();
						}else{
							msg2.cmd = Cmd.CMD_REFUSE;
						}
						msg2.myInfo = myInfo;
						msg2.friendInfo = friendInfo;
						SendCmd.send(msg2);
						break;
					case Cmd.CMD_ARGEE:
						refresh();
						break;
					case Cmd.CMD_DELETE:
						refresh();
						break;
					case Cmd.CMD_REFUSE:
						str = "【"+friendInfo.getNickName()+"】拒绝了你的好友请求。";
						JOptionPane.showMessageDialog(null, str);
						break;
					case Cmd.CMD_FILE:
						str = friendInfo.getNickName()+"发送了一个【"+msg.fileName+"文件】，是否接收？";
						if(JOptionPane.showConfirmDialog(null, "是否接收文件", "接收文件", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
							JFileChooser chooser = new JFileChooser(" ");
							chooser.setDialogType(JFileChooser.SAVE_DIALOG);
							chooser.setDialogTitle("保存文件");
							if(chooser.showOpenDialog(null)==chooser.APPROVE_OPTION){
								String ext = msg.fileName.substring(msg.fileName.indexOf('.'), msg.fileName.length());
								String filename = chooser.getSelectedFile().getAbsolutePath()+ext;
								FileOutputStream fos = new FileOutputStream(filename);
								fos.write(msg.b);
								fos.flush();
								fos.close();
							}
						}
					}
					
				}
			} catch(SocketException e) {
				e.printStackTrace();
			} catch(IOException e1) {
				e1.printStackTrace();
			} catch(ClassNotFoundException e2) {
				e2.printStackTrace();
			}
		}
	}
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==cbstate){
			String status = cbstate.getSelectedItem().toString();
			changState();
			baseDAO.changStatus(myInfo.getQqCode(), status);
			SendCmd.sendAll(vAllInfo, myInfo, Cmd.CMD_CHANGESTATE);
		}
		
		
	}
	public void changState(){
		String status = cbstate.getSelectedItem().toString();
		String filename = myInfo.getHeadImg();
		String headImag = myInfo.getHeadImg();
		if(status.equals(Cmd.STATUS[0])){
			filename = headImag;
		}else if (status.equals(Cmd.STATUS[2])) {
			int pos = headImag.indexOf('.');
			String pre = headImag.substring(0, pos);
			String fix = headImag.substring(pos,headImag.length());
			filename = pre + "_l"+fix;
			
		}else if (status.equals(Cmd.STATUS[3])) {
			int pos = headImag.indexOf('.');
			String pre = headImag.substring(0, pos);
			String fix = headImag.substring(pos,headImag.length());
			filename = pre + "_w"+fix;
			
		}
		lblMyInfo.setIcon(new ImageIcon(filename));
	}
	public void changState(String status){
		String filename = myInfo.getHeadImg();
		String headImag = myInfo.getHeadImg();
		if(status.equals(Cmd.STATUS[0])){
			filename = headImag;
		}else if (status.equals(Cmd.STATUS[2])) {
			int pos = headImag.indexOf('.');
			String pre = headImag.substring(0, pos);
			String fix = headImag.substring(pos,headImag.length());
			filename = pre + "_l"+fix;
			
		}else if (status.equals(Cmd.STATUS[3])) {
			int pos = headImag.indexOf('.');
			String pre = headImag.substring(0, pos);
			String fix = headImag.substring(pos,headImag.length());
			filename = pre + "_w"+fix;
			
		}
		lblMyInfo.setIcon(new ImageIcon(filename));
	}
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowClosing(WindowEvent e) {
		baseDAO.changStatus(myInfo.getQqCode(), Cmd.STATUS[1]);
		myInfo.setOnlinestatus(Cmd.STATUS[1]);
		SendCmd.sendAll(vAllInfo, myInfo, Cmd.CMD_OFFLINE);

		
	}
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void windowIconified(WindowEvent e) {
		SystemTray tray = SystemTray.getSystemTray();
		if(trayIcon !=null){
			tray.remove(trayIcon);
		}
		try {
			tray.add(trayIcon);
			MainUI.this.setVisible(false);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void createTrayMenu(){
		popTray = new PopupMenu();
		miOpen = new MenuItem("打开");
		miExit = new MenuItem("退出");
		miOnline = new MenuItem("在线");
		miLevel = new MenuItem("隐身");
		miBuys = new MenuItem("忙碌");
		miOpen.addActionListener(this);
		miExit.addActionListener(this);
		miOnline.addActionListener(this);
		miLevel.addActionListener(this);
		miBuys.addActionListener(this);
		
		popTray.add(miOpen);
		popTray.add(miExit);
		popTray.add(miOnline);
		popTray.add(miLevel);
		popTray.add(miBuys);
		
	}
	public void setTrayIcon(){
		Image image = new ImageIcon("images/tubiao.png").getImage();
		trayIcon = new TrayIcon(image,"QQ2016",popTray);
		trayIcon.setImageAutoSize(true);
		
	}
}
