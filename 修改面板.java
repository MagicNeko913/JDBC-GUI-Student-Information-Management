package 学籍管理系统视窗;

import database.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class 修改面板 extends JPanel {
	
	private final JTextField textField;
	private final JTextField textField_1;
	private final JTextField textField_2;
	private final JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public 修改面板() {
		setLayout(null);
		
		JLabel label = new JLabel("输入要修改信息的学号：");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(42, 18, 177, 18);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(213, 15, 144, 24);
		add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("（新）姓名：");
		label_1.setBounds(42, 76, 120, 18);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 73, 120, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton radioButton = new JRadioButton("男");
		radioButton.setBounds(107, 119, 51, 27);
		add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("女");
		radioButton_1.setBounds(168, 119, 51, 27);
		add(radioButton_1);
		ButtonGroup btgSex = new ButtonGroup();
		btgSex.add(radioButton);
		btgSex.add(radioButton_1);

		JLabel lblNewLabel = new JLabel("（新）电话：");
		lblNewLabel.setBounds(40, 169, 76, 18);
		add(lblNewLabel);
		
		JLabel label_2 = new JLabel("（新）年龄：");
		label_2.setBounds(40, 210, 76, 18);
		add(label_2);

		textField_2 = new JTextField();
		textField_2.setBounds(133, 166, 185, 24);
		add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(133, 207, 185, 24);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton button = new JButton("修改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String name=textField_1.getText();
				String mobile=textField_2.getText();
				String age=textField_3.getText();
				String ssex;
				if(radioButton.isSelected()) {
					 ssex="男";
				}else
					 ssex="女";

				//调用自己链接数据库操作方法test
				Object str[]={id,name,mobile,ssex,age};
				Connection sin=Test.getconnectin();
				Test.update(sin, str);
				radioButton.setSelected(false);
				radioButton_1.setSelected(false);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				JOptionPane.showMessageDialog(null,"修改成功","提示",JOptionPane.NO_OPTION );

			}
		});
		button.setBounds(82, 282, 114, 27);
		add(button);
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton.setSelected(false);
				radioButton_1.setSelected(false);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				JOptionPane.showMessageDialog(null,"重置成功!","信息",JOptionPane.INFORMATION_MESSAGE );
			}
		});
		button_1.setBounds(204, 282, 114, 27);
		add(button_1);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setToolTipText("");
		btnNewButton.setBounds(364, 15, 79, 27);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Connection sin=Test.getconnectin();
					String id=textField.getText();
					ResultSet rs=null;
					PreparedStatement stmt=null;
					boolean flag=false;
					try {
						//查找
						stmt=sin.prepareStatement("select * from student where id=?");
					    stmt.setObject(1,id);
						rs=stmt.executeQuery();
						while(rs.next()){
						String msg=rs.getString("id")+"\n"+rs.getString("name")+"\n"+rs.getString("mobile")+"\n"+rs.getString("sex")+"\n"+rs.getString("age")+"\n";
							//JOptionPane.showMessageDialog(null,msg,"查询结果：",JOptionPane.NO_OPTION );
							flag=true;
							//修改
							textField_1.setText(rs.getString("name"));
							String ssex=null;
							ssex=rs.getString("sex");
							if(ssex.equalsIgnoreCase("男")) {
								radioButton.setSelected(true);

							}else {
								radioButton_1.setSelected(true);
							}
							textField_2.setText(rs.getString("mobile"));
							textField_3.setText(rs.getString("age"));
						}
						if(flag==false) {
							radioButton.setSelected(false);
							radioButton_1.setSelected(false);
							
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
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

	}
}
