package ѧ������ϵͳ�Ӵ�;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.Test;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class �鿴��� extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public �鿴���() throws SQLException {
		setLayout(new BorderLayout(0, 0));
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.getTableHeader().setFont(new Font("����", Font.PLAIN, 20));
		table.setFont(new Font("����", Font.PLAIN, 18));
		table.setRowHeight(50);
	
		
		 DefaultTableModel dtmUser;
			Vector<String>head =new Vector<String>();
			head.add("ѧ��");
			head.add("����");
			head.add("�绰");
			head.add("�Ա�");
			head.add("����");
			//׼����������
			Vector<Vector<String>> data=new Vector<Vector<String>>();
			Vector<String> row =new Vector<String>();
			//ʹ�ò�ѯ����
			Connection sin=Test.getconnectin();
			ResultSet rs=null;
			rs=Test.query(sin);
			while(rs.next()) {
				
				row.add(rs.getString("id"));
				row.add(rs.getString("name"));
				row.add(rs.getString("mobile"));
				row.add(rs.getString("sex"));
				row.add(rs.getString("age"));
				data.add(row);
				row=new Vector<String>();
			}
			//�ر����ݿ�
			if(sin!=null&&sin.isClosed()) {
				sin.close();
			}

			dtmUser=new DefaultTableModel(data,head);
			table.setModel(dtmUser);
			
			JButton btnNewButton = new JButton("ˢ��");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//׼����������
					Vector<Vector<String>> data=new Vector<Vector<String>>();
					Vector<String> row =new Vector<String>();
					//ʹ�ò�ѯ����
					Connection sin=Test.getconnectin();
					ResultSet rs=null;
					rs=Test.query(sin);
					try {
						while(rs.next()) {

							row.add(rs.getString("id"));
							row.add(rs.getString("name"));
							row.add(rs.getString("mobile"));
							row.add(rs.getString("sex"));
							row.add(rs.getString("age"));
							data.add(row);
							row=new Vector<String>();
							
						}
						DefaultTableModel dtmUser1;
						dtmUser1=new DefaultTableModel(data,head);
						table.setModel(dtmUser1);
						JOptionPane.showMessageDialog(null,"ˢ�³ɹ�","��ʾ",JOptionPane.NO_OPTION );
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//�ر����ݿ�
					try {
						if(sin!=null&&sin.isClosed()) {
							sin.close();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
			add(btnNewButton, BorderLayout.NORTH);

	}
}
