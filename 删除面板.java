package ѧ������ϵͳ�Ӵ�;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import database.Test;


public class ɾ����� extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	/**
	 * Create the panel.
	 */
	public ɾ�����() {
setLayout(null);
		
		JLabel label = new JLabel("����Ҫɾ��ѧ����ѧ�ţ�");
		label.setBounds(37, 22, 189, 18);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(201, 19, 154, 24);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("����");
		label_1.setBounds(72, 60, 40, 18);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(112, 60, 150, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("�绰");
		label_2.setBounds(72, 100, 52, 18);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(112, 100, 150, 24);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("�Ա�");
		label_3.setBounds(72, 140, 41, 18);
		add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(112, 140, 150, 24);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("����");
		label_4.setBounds(72, 180, 45, 18);
		add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(112, 180, 150, 24);
		add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton = new JButton("��ѯ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Connection sin=Test.getconnectin();
					String id=textField.getText();
					ResultSet rs=null;
					PreparedStatement stmt=null;
					try {
						//ţ�Ʋ���
						 stmt=sin.prepareStatement("select * from student where id=?");
					    stmt.setObject(1,id);
						rs=stmt.executeQuery();
						boolean flag=false;
						while(rs.next()){
							JOptionPane.showMessageDialog(null,"��ѯ�ɹ�","��ʾ",JOptionPane.NO_OPTION );
						textField_1.setText(rs.getString("name"));
						textField_2.setText(rs.getString("mobile"));
						textField_3.setText(rs.getString("sex"));
						textField_4.setText(rs.getString("age"));
						flag=true;
						}
						if(flag==false) {
							JOptionPane.showMessageDialog(null,"���޴���","��ѯ���",JOptionPane.NO_OPTION );
						}
					 		stmt.close();//�ر����ݿ�
					 		sin.close();
						} catch (SQLException h) {
							// TODO Auto-generated catch block
							h.printStackTrace();
						}
					}
		});
		btnNewButton.setBounds(366, 17, 77, 27);
		add(btnNewButton);
		
		JButton button = new JButton("ɾ��");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//ɾ������
				String id=textField.getText();
				boolean flag;
				Connection sin=Test.getconnectin();
				flag=Test.chongfu(sin,id);
				System.out.println(flag);
				if(flag) {
				
				Test.delete(sin, id);
				JOptionPane.showMessageDialog(null,"��Ϣɾ���ɹ�!","��Ϣ",JOptionPane.INFORMATION_MESSAGE );
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");

			}
				else
					JOptionPane.showMessageDialog(null,"��ѧ����Ϣ������!","��Ϣ",JOptionPane.INFORMATION_MESSAGE );
			}
		});
		button.setBounds(72, 257, 113, 27);
		add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				JOptionPane.showMessageDialog(null,"���óɹ�","��ʾ",JOptionPane.NO_OPTION );
				
			}
		});
		button_1.setBounds(217, 257, 113, 27);
		add(button_1);


	}

}
