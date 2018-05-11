package com.ht.base;

import java.io.Serializable;

import javax.swing.text.StyledDocument;

import com.ht.vo.AccountVo;

public class SendMsg implements Serializable{
	public int cmd;
	public AccountVo myInfo;
	public AccountVo friendInfo;
	public StyledDocument doc;
	public byte b[];
	public String fileName;
}
