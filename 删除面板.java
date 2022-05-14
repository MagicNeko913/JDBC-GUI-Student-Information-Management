package 学籍管理系统视窗;

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


public class 删除面板 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	/**
	 * Create the panel.
	 */
	public 删除面板() {
setLayout(null);
		
		JLabel label = new JLabel("输入要删除学生的学号：");
		label.setBounds(37, 22, 189, 18);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(201, 19, 154, 24);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("姓名");
		label_1.setBounds(72, 60, 40, 18);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(112, 60, 150, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("电话");
		label_2.setBounds(72, 100, 52, 18);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(112, 100, 150, 24);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("性别");
		label_3.setBounds(72, 140, 41, 18);
		add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(112, 140, 150, 24);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("年龄");
		label_4.setBounds(72, 180, 45, 18);
		add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(112, 180, 150, 24);
		add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Connection sin=Test.getconnectin();
					String id=textField.getText();
					ResultSet rs=null;
					PreparedStatement stmt=null;
					try {
						//牛逼查找
						 stmt=sin.prepareStatement("select * from student where id=?");
					    stmt.setObject(1,id);
						rs=stmt.executeQuery();
						boolean flag=false;
						while(rs.next()){
							JOptionPane.showMessageDialog(null,"查询成功","提示",JOptionPane.NO_OPTION );
						textField_1.setText(rs.getString("name"));
						textField_2.setText(rs.getString("mobile"));
						textField_3.setText(rs.getString("sex"));
						textField_4.setText(rs.getString("age"));
						flag=true;
						}
						if(flag==false) {
							JOptionPane.showMessageDialog(null,"查无此人","查询结果",JOptionPane.NO_OPTION );
						}
					 		stmt.close();//关闭数据库
					 		sin.close();
						} catch (SQLException h) {
							// TODO Auto-generated catch block
							h.printStackTrace();
						}
					}
		});
		btnNewButton.setBounds(366, 17, 77, 27);
		add(btnNewButton);
		
		JButton button = new JButton("删除");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//删除操作
				String id=textField.getText();
				boolean flag;
				Connection sin=Test.getconnectin();
				flag=Test.chongfu(sin,id);
				System.out.println(flag);
				if(flag) {
				
				Test.delete(sin, id);
				JOptionPane.showMessageDialog(null,"信息删除成功!","信息",JOptionPane.INFORMATION_MESSAGE );
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");

			}
				else
					JOptionPane.showMessageDialog(null,"该学号信息不存在!","信息",JOptionPane.INFORMATION_MESSAGE );
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
				JOptionPane.showMessageDialog(null,"重置成功","提示",JOptionPane.NO_OPTION );
				
			}
		});
		button_1.setBounds(217, 257, 113, 27);
		add(button_1);


	}

}
