package ѧ������ϵͳ�Ӵ�;

import database.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class �޸���� extends JPanel {
	
	private final JTextField textField;
	private final JTextField textField_1;
	private final JTextField textField_2;
	private final JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public �޸����() {
		setLayout(null);
		
		JLabel label = new JLabel("����Ҫ�޸���Ϣ��ѧ�ţ�");
		label.setFont(new Font("����", Font.PLAIN, 16));
		label.setBounds(42, 18, 177, 18);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(213, 15, 144, 24);
		add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("���£�������");
		label_1.setBounds(42, 76, 120, 18);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 73, 120, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		JRadioButton radioButton = new JRadioButton("��");
		radioButton.setBounds(107, 119, 51, 27);
		add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Ů");
		radioButton_1.setBounds(168, 119, 51, 27);
		add(radioButton_1);
		ButtonGroup btgSex = new ButtonGroup();
		btgSex.add(radioButton);
		btgSex.add(radioButton_1);

		JLabel lblNewLabel = new JLabel("���£��绰��");
		lblNewLabel.setBounds(40, 169, 76, 18);
		add(lblNewLabel);
		
		JLabel label_2 = new JLabel("���£����䣺");
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
		
		JButton button = new JButton("�޸�");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String name=textField_1.getText();
				String mobile=textField_2.getText();
				String age=textField_3.getText();
				String ssex;
				if(radioButton.isSelected()) {
					 ssex="��";
				}else
					 ssex="Ů";

				//�����Լ��������ݿ��������test
				Object str[]={id,name,mobile,ssex,age};
				Connection sin=Test.getconnectin();
				Test.update(sin, str);
				radioButton.setSelected(false);
				radioButton_1.setSelected(false);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				JOptionPane.showMessageDialog(null,"�޸ĳɹ�","��ʾ",JOptionPane.NO_OPTION );

			}
		});
		button.setBounds(82, 282, 114, 27);
		add(button);
		
		JButton button_1 = new JButton("����");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton.setSelected(false);
				radioButton_1.setSelected(false);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				JOptionPane.showMessageDialog(null,"���óɹ�!","��Ϣ",JOptionPane.INFORMATION_MESSAGE );
			}
		});
		button_1.setBounds(204, 282, 114, 27);
		add(button_1);
		
		JButton btnNewButton = new JButton("��ѯ");
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
						//����
						stmt=sin.prepareStatement("select * from student where id=?");
					    stmt.setObject(1,id);
						rs=stmt.executeQuery();
						while(rs.next()){
						String msg=rs.getString("id")+"\n"+rs.getString("name")+"\n"+rs.getString("mobile")+"\n"+rs.getString("sex")+"\n"+rs.getString("age")+"\n";
							//JOptionPane.showMessageDialog(null,msg,"��ѯ�����",JOptionPane.NO_OPTION );
							flag=true;
							//�޸�
							textField_1.setText(rs.getString("name"));
							String ssex=null;
							ssex=rs.getString("sex");
							if(ssex.equalsIgnoreCase("��")) {
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

	}
}
