package 学籍管理系统视窗;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class 主窗口 extends JFrame {
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					主窗口 frame = new 主窗口();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public 主窗口() throws SQLException {
		//this.setLocationRelativeTo(null);
		setBounds(100, 100, 800, 500);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout card=new CardLayout();
		contentPane.setLayout(card);
		欢迎面板 欢迎面板=new 欢迎面板();
		contentPane.add("0",欢迎面板);
		修改面板 修改面板=new 修改面板();
		contentPane.add("2",修改面板);
		录入面板 录入面板=new 录入面板();
		contentPane.add("1",录入面板);
		删除面板 删除面板=new 删除面板();
		contentPane.add("3",删除面板);
		查询面板  查询面板=new 查询面板();
		contentPane.add("4",查询面板);
		查看面板  查看面板=new 查看面板();
		contentPane.add("5",查看面板);

		setTitle("大学生综合测评管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("操作菜单");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("录入学生信息");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "1");
			}
		});
		
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("修改学生信息");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "2");
			}
		});
		
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("删除学生信息");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "3");
			}
		});
		menu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("查询学生信息");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "4");
			}
		});
		menu.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("显示所有信息");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "5");
			}
		});
		menu.add(menuItem_4);
	
		
	
		
		
	}
}
