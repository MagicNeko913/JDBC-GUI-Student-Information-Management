package ѧ������ϵͳ�Ӵ�;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


import database.Test;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ¼����� extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private JLabel lblNewLabel;


	/**
	 * Create the panel.
	 */
	public ¼�����() {
		setLayout(null);
		 lblNewLabel = new JLabel("ѧ��");
		lblNewLabel.setBounds(72, 24, 30, 18);
		add(lblNewLabel);

		JLabel label = new JLabel("����");
		label.setBounds(72, 55, 30, 18);
		add(label);

		JLabel label_1 = new JLabel("�绰");
		label_1.setBounds(72, 83, 30, 18);
		add(label_1);

		JLabel label_3 = new JLabel("����");
		label_3.setBounds(72, 145, 30, 18);
		add(label_3);

		textField = new JTextField("������ѧ��");
		textField.setBounds(116, 21, 130, 24);
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
			}
		});
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField("����������");
		textField_1.setBounds(116, 52, 130, 24);
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_1.setText("");
			}
		});
		add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField("������绰����");
		textField_2.setBounds(116, 83, 130, 24);
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_2.setText("");
			}
		});
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_2 = new JLabel("�Ա�");
		label_2.setBounds(72, 114, 30, 18);
		add(label_2);

		JRadioButton radioButton = new JRadioButton("��");
		radioButton.setBounds(126, 110, 43, 27);
		add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Ů");
		radioButton_1.setBounds(175, 110, 55, 27);
		add(radioButton_1);
		
		//����ButtonGroup����
				ButtonGroup btgSex = new ButtonGroup();
				btgSex.add(radioButton);
				btgSex.add(radioButton_1);
		
		JLabel label_4 = new JLabel("����");
		label_4.setBounds(72, 145, 30, 18);
		add(label_4);

		textField_3 = new JTextField("����������");
		textField_3.setBounds(116, 141, 130, 24);
		textField_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_3.setText("");
			}
		});
		add(textField_3);
		textField_3.setColumns(10);

		
		JButton button = new JButton("¼��");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sex="";
				if(radioButton.isSelected()) {
					sex=radioButton.getText();
				}else {
					sex=radioButton_1.getText();
				}
			
				if(textField_1.getText().equals("")||textField_1.getText().equals("����������")) {
					JOptionPane.showMessageDialog(null,"����������","����",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(textField.getText().equals("")||textField.getText().equals("������ѧ��")) {
					JOptionPane.showMessageDialog(null,"������ѧ��","����",JOptionPane.ERROR_MESSAGE);
					return;
				}

				if(textField_2.getText().equals("")||textField_2.getText().equals("������绰����")) {
					JOptionPane.showMessageDialog(null,"������绰����","����",JOptionPane.ERROR_MESSAGE);
					return;
				}

				if(textField_3.getText().equals("")||textField_3.getText().equals("����������")) {
					JOptionPane.showMessageDialog(null,"����������","����",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				//��������
				String id=textField.getText();
				String name=textField_1.getText();
				String mobile=textField_2.getText();
				String age=textField_3.getText();
				String ssex;
				if(radioButton.isSelected()) {
					 ssex="��";
				}
				else
					 ssex="Ů";

				//�����Լ��������ݿ��������test
				Connection sin=Test.getconnectin();
				boolean flag;
				flag=Test.chongfu(sin,id);
				System.out.println(flag);
				if(flag==false) {
				Object str[]={id,name,mobile,ssex,age};
				
				Test.insert(sin, str);
				JOptionPane.showMessageDialog(null,"¼��ɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
				radioButton.setSelected(false);
				radioButton_1.setSelected(false);
				textField.setText("������ѧ��");
				textField_1.setText("����������");
				textField_2.setText("");
				}
				else
					JOptionPane.showMessageDialog(null,"ʧ�ܣ�ѧ���ظ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
				
				
			
			}
		});
		button.setBounds(203, 232, 63, 27);
		add(button);
		
		JButton button_1 = new JButton("����");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				radioButton.setSelected(false);
				radioButton_1.setSelected(false);
				textField.setText("������ѧ��");
				textField_1.setText("����������");
				textField_2.setText("");
				JOptionPane.showMessageDialog(null,"���óɹ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
			
			}
		});
		button_1.setBounds(106, 232, 63, 27);
		add(button_1);
		

		
	}

	}
		

