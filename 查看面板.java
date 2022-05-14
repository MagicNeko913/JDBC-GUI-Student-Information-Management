package 学籍管理系统视窗;

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

public class 查看面板 extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public 查看面板() throws SQLException {
		setLayout(new BorderLayout(0, 0));
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.getTableHeader().setFont(new Font("宋体", Font.PLAIN, 20));
		table.setFont(new Font("宋体", Font.PLAIN, 18));
		table.setRowHeight(50);
	
		
		 DefaultTableModel dtmUser;
			Vector<String>head =new Vector<String>();
			head.add("学号");
			head.add("姓名");
			head.add("电话");
			head.add("性别");
			head.add("年龄");
			//准备表中数据
			Vector<Vector<String>> data=new Vector<Vector<String>>();
			Vector<String> row =new Vector<String>();
			//使用查询方法
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
			//关闭数据库
			if(sin!=null&&sin.isClosed()) {
				sin.close();
			}

			dtmUser=new DefaultTableModel(data,head);
			table.setModel(dtmUser);
			
			JButton btnNewButton = new JButton("刷新");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//准备表中数据
					Vector<Vector<String>> data=new Vector<Vector<String>>();
					Vector<String> row =new Vector<String>();
					//使用查询方法
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
						JOptionPane.showMessageDialog(null,"刷新成功","提示",JOptionPane.NO_OPTION );
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//关闭数据库
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
