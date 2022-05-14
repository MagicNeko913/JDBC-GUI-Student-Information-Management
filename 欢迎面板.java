package 学籍管理系统视窗;

import javax.swing.*;
import java.awt.*;

public class 欢迎面板 extends JPanel {

	/**
	 * Create the panel.
	 */
	public 欢迎面板() {
		setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("欢迎使用大学生综合测评管理系统");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(34, 90, 387, 62);
		add(lblNewLabel);
		
		JLabel label = new JLabel("请按左上角菜单栏提示进行操作");
		label.setBounds(100, 178, 233, 18);
		add(label);
		

	}
}
