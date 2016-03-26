package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Properties;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.junit.Test;


public class HostInfo {
	
	//ViewInterface viewInterface = new ViewInterface();
	@Test
	public void test() {
		InetAddress ip = null ;
		String name = ip.getHostName();
		System.out.println(ip.getAddress());
		Map<String, String> map = System.getenv(); 
        String userName = map.get("COMPUTERNAME");// 获取计算机名 
		System.out.println(userName);
	}
	
	public void getHostInfo() throws UnknownHostException {
	
		Properties propeties = System.getProperties();

		//显示操作系统
		String systemName = propeties.getProperty("os.name");
		String systemArch = propeties.getProperty("os.arch");
		systemArch = systemArch.substring(3);
		ViewInterface.osInfo.setText(systemName + " " + systemArch + " 位操作系统"); 
		 
		//显示用户名
		String systemUser = propeties.getProperty("user.name");
		ViewInterface.userNameInfo.setText(systemUser);
		
		//显示电脑名
		InetAddress ip = null;
		String hostName = ip.getLocalHost().getHostName();
		ViewInterface.hostNameInfo.setText(hostName);
		
		//显示
		String sql = "reg query reg query HKEY_LOCAL_MACHINE\\SOFTWARE\\360Safe\\360Scan\\NetProbe";
		Process ps;
		try {
			ps = Runtime.getRuntime().exec(sql);
			ps.getOutputStream().close();  
            InputStreamReader i = new InputStreamReader(ps.getInputStream());  
            String line;  
            BufferedReader ir = new BufferedReader(i);  
            while ((line = ir.readLine()) != null) {  
                System.out.println(line);  
            }  
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//显示内存
		Sigar sigar = new Sigar();
        Mem mem = null;
		try {
			mem = sigar.getMem();
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        float total = mem.getTotal();
        // 内存总量
        
        ViewInterface.memoryInfo.setText(mem.getTotal() / 1024L/1024L/1000L + "G");
        System.out.println("内存总量:   " + mem.getTotal() / 1024L/1024L + "M av");
	}
}
