package 学籍管理系统视窗;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import database.Test;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class 查询面板 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public 查询面板() {
		setLayout(null);
		
		JLabel label = new JLabel("输入要查询信息的学号：");
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
		
		JLabel label_2 = new JLabel("性别");
		label_2.setBounds(72, 100, 52, 18);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(112, 100, 150, 24);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("电话");
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
					String sno=textField.getText();
					ResultSet rs=null;
					PreparedStatement stmt=null;
					try {
						//查找
						 stmt=sin.prepareStatement("select * from student where id=?");
					    stmt.setObject(1,sno);
						rs=stmt.executeQuery();
						boolean flag=false;
						while(rs.next()){
						String msg=rs.getString("id")+"\n"+rs.getString("name")+"\n"+rs.getString("mobile")+"\n"+rs.getString("sex")+"\n"+rs.getString("age")+"\n";
						JOptionPane.showMessageDialog(null,msg,"查询结果：",JOptionPane.NO_OPTION );
						textField_1.setText(rs.getString("name"));
						textField_2.setText(rs.getString("sex"));
						textField_3.setText(rs.getString("mobile"));
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

	}

}
