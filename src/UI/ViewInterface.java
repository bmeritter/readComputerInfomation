package UI;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class ViewInterface extends JFrame {

	public static JLabel userName = new JLabel("用户名：");
	public static JEditorPane userNameInfo = new JEditorPane();

	public static JLabel hostName = new JLabel("主机名：");
	public static JEditorPane hostNameInfo = new JEditorPane();
	
	public static JLabel os = new JLabel("操作系统：");
	public static JEditorPane osInfo = new JEditorPane();
	
	public static JLabel memory = new JLabel("内存：");
	public static JEditorPane memoryInfo = new JEditorPane();
	
	public static JLabel cpu = new JLabel("显卡：");
	public static JEditorPane cpuInfo = new JEditorPane();

	public static JButton localInfo = new JButton("本机信息");
	public static JButton netInfo = new JButton("网络信息");

	public ViewInterface() {
		
	}

	public void start() {
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setLayout(null);

		// 用户名
		userName.setBounds(165, 30, 71, 15);
		getContentPane().add(userName);

		userNameInfo.setBounds(232, 24, 226, 21);
		getContentPane().add(userNameInfo);

		// 主机名
		hostName.setBounds(165, 67, 71, 15);
		getContentPane().add(hostName);

		hostNameInfo.setBounds(232, 61, 226, 21);
		getContentPane().add(hostNameInfo);

		// 操作系统
		os.setBounds(165, 109, 71, 15);
		getContentPane().add(os);

		osInfo.setBounds(232, 103, 226, 21);
		getContentPane().add(osInfo);

		// 内存
		memory.setBounds(165, 151, 71, 15);
		getContentPane().add(memory);

		memoryInfo.setBounds(232, 145, 226, 21);
		getContentPane().add(memoryInfo);

		// cpu
		cpu.setBounds(165, 196, 61, 15);
		getContentPane().add(cpu);

		cpuInfo.setBounds(230, 190, 228, 21);
		getContentPane().add(cpuInfo);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 128, 257);
		getContentPane().add(panel);
		panel.setLayout(null);

		// 本机信息
		localInfo.setBounds(10, 33, 93, 23);
		panel.add(localInfo);
		localInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new HostInfo().getHostInfo();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		

		// 网络信息
		netInfo.setBounds(10, 79, 93, 23);
		panel.add(netInfo);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(128, 0, 511, 257);
		getContentPane().add(panel_1);

		setTitle("计算机信息");
		setBounds(400, 150, 527, 296);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ViewInterface().start();
	}

}
