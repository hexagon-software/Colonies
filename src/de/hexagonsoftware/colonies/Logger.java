package de.hexagonsoftware.colonies;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

public class Logger {
	private String name;
	private File log;
	
	private Logger(String name) {
		this.name = name;
		String wd = null;
		try {
			wd = Logger.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		wd = new File(wd).getParentFile().getPath();
		this.log = new File(wd+"/latest-"+name+".log");
		try {
			if (!this.log.exists())  {
				this.log.createNewFile(); 
				return;
			}
			
			this.log.delete();
			this.log.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public static Logger getLogger(String name) {
		return new Logger(name);
	}

	public void info(String msg) {
		System.out.println("["+name+"][INFO] "+msg);
		addLog("["+name+"][INFO] "+msg);
	}
	
	public void warn(String msg) {
		System.out.println("["+name+"][WARN] "+msg);
		addLog("["+name+"][WARN] "+msg);
	}
	
	public void error(String msg) {
		System.out.println("["+name+"][ERROR] "+msg);
		addLog("["+name+"][ERROR] "+msg);
	}
	
	private void addLog(String msg) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(log, true)); 
			out.write(msg+"\n"); 
			out.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
