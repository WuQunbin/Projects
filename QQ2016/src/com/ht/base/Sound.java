package com.ht.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import sun.audio.AudioData;
import sun.audio.AudioDataStream;
import sun.audio.AudioPlayer;

public class Sound {
	public Sound(int cmd){
		try {
			String filename = "sound/Global.wav";
			switch (cmd) {
			case Cmd.CMD_ADDFRI:
				filename = "sound/system.wav";
				break;
			case Cmd.CMD_SHAKE:
				filename = "sound/shake.wav";
				break;
			case Cmd.CMD_SEND:
				filename = "sound/Audio.wav";
				break;
			}
			File file = new File(filename);
			InputStream is = new FileInputStream(file);
			int size = is.available();
			byte b[] = new byte[size];
			is.read(b,0,size);
			AudioData ad = new AudioData(b);
			AudioDataStream ds = new AudioDataStream(ad);
			AudioPlayer.player.start(ds);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		new Sound(Cmd.CMD_ARGEE);
	}
}
