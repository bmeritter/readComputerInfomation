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

	public static JLabel userName = new JLabel("�û�����");
	public static JEditorPane userNameInfo = new JEditorPane();

	public static JLabel hostName = new JLabel("��������");
	public static JEditorPane hostNameInfo = new JEditorPane();
	
	public static JLabel os = new JLabel("����ϵͳ��");
	public static JEditorPane osInfo = new JEditorPane();
	
	public static JLabel memory = new JLabel("�ڴ棺");
	public static JEditorPane memoryInfo = new JEditorPane();
	
	public static JLabel cpu = new JLabel("�Կ���");
	public static JEditorPane cpuInfo = new JEditorPane();

	public static JButton localInfo = new JButton("������Ϣ");
	public static JButton netInfo = new JButton("������Ϣ");

	public ViewInterface() {
		
	}

	public void start() {
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setLayout(null);

		// �û���
		userName.setBounds(165, 30, 71, 15);
		getContentPane().add(userName);

		userNameInfo.setBounds(232, 24, 226, 21);
		getContentPane().add(userNameInfo);

		// ������
		hostName.setBounds(165, 67, 71, 15);
		getContentPane().add(hostName);

		hostNameInfo.setBounds(232, 61, 226, 21);
		getContentPane().add(hostNameInfo);

		// ����ϵͳ
		os.setBounds(165, 109, 71, 15);
		getContentPane().add(os);

		osInfo.setBounds(232, 103, 226, 21);
		getContentPane().add(osInfo);

		// �ڴ�
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

		// ������Ϣ
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
		

		// ������Ϣ
		netInfo.setBounds(10, 79, 93, 23);
		panel.add(netInfo);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(128, 0, 511, 257);
		getContentPane().add(panel_1);

		setTitle("�������Ϣ");
		setBounds(400, 150, 527, 296);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ViewInterface().start();
	}

}
