package com.ht.db;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;

public class Demo {
	
	//只用来打开本地的html
	public Demo(String URL){
		
		String url="file:///"+new File(URL).getAbsolutePath().replace("\\", "/");
		try {
			
			URI uri=new URI(URL);
			
			Desktop desktop=null;
			if(Desktop.isDesktopSupported()){
				desktop=Desktop.getDesktop();
			}
			
			if(desktop!=null){
				
				desktop.browse(uri);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//只用来打开网页
	public Demo(String net,String URL){
		
		try {
			URI uri=new URI(URL);
			Desktop desktop=null;
			if(desktop!=null){
				desktop.browse(uri);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	public static void main(String[] args){
		new Demo("QQ音乐.lnk");
		new Demo("植物大战僵尸2");
//		new Openweb("QQkongjian.html");
//		new Openweb("酷狗音乐.lnk");
//		new Openweb("Starter.exe.lnk");
//		new Openweb("暴风影音5.lnk");
//		new Openweb("美图拍拍.lnk");
		
	}
	

}


