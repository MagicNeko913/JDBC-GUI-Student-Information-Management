package ѧ������ϵͳ�Ӵ�;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ������ extends JFrame {
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					������ frame = new ������();
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
	public ������() throws SQLException {
		//this.setLocationRelativeTo(null);
		setBounds(100, 100, 800, 500);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout card=new CardLayout();
		contentPane.setLayout(card);
		��ӭ��� ��ӭ���=new ��ӭ���();
		contentPane.add("0",��ӭ���);
		�޸���� �޸����=new �޸����();
		contentPane.add("2",�޸����);
		¼����� ¼�����=new ¼�����();
		contentPane.add("1",¼�����);
		ɾ����� ɾ�����=new ɾ�����();
		contentPane.add("3",ɾ�����);
		��ѯ���  ��ѯ���=new ��ѯ���();
		contentPane.add("4",��ѯ���);
		�鿴���  �鿴���=new �鿴���();
		contentPane.add("5",�鿴���);

		setTitle("��ѧ���ۺϲ�������ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("�����˵�");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("¼��ѧ����Ϣ");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "1");
			}
		});
		
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("�޸�ѧ����Ϣ");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "2");
			}
		});
		
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("ɾ��ѧ����Ϣ");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "3");
			}
		});
		menu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("��ѯѧ����Ϣ");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "4");
			}
		});
		menu.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("��ʾ������Ϣ");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "5");
			}
		});
		menu.add(menuItem_4);
	
		
	
		
		
	}
}
