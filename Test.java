package database;

import java.sql.*;

import javax.swing.JOptionPane;
public class Test {
public final static Connection getconnectin(){

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
		String url = "jdbc:mysql://localhost:3306/student1";
		return DriverManager.getConnection(url, "root", "142857");//创建连接
	}
	catch(SQLException sqle){
	       System.out.println(sqle+"连接错误");
	            }
	    	catch(Exception e){
	    		System.out.println(e+"第二个错误");
	    	
	    	}
	return null;
}
//添加数据
public final static void insert(Connection con,Object obj[]){
	PreparedStatement stmt=null;
	
	try {
		
		
	stmt=con.prepareStatement("insert into student(id,name,mobile,sex,age) values(?,?,?,?,?)");
		
		stmt.setString(1,obj[0].toString());
		stmt.setString(2,obj[1].toString());
		stmt.setString(3,obj[2].toString());
		stmt.setString(4,obj[3].toString());
		stmt.setString(5,obj[4].toString());
		stmt.execute();
		
		
		
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,"失败","操作提示",JOptionPane.NO_OPTION );
	}
}
//查询数据
public final static ResultSet query(Connection con){
	
	ResultSet rs=null;
	PreparedStatement stmt=null;
	try {
		stmt=con.prepareStatement("select * from student");
		 rs=stmt.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
}
//判断学号重复
public final static boolean chongfu(Connection con,String a){
	
	ResultSet rs=null;
	PreparedStatement stmt=null;
	boolean flag=true;;
	try {
		stmt=con.prepareStatement("select id from student");
		 rs=stmt.executeQuery();
		 while(rs.next())
		 {
			 if(a.equalsIgnoreCase(rs.getString("id")))
			
				 return true;
			 
		 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}

//删除数据
public final static void delete(Connection con,String s){
	try {
		PreparedStatement stmt;
		 stmt=con.prepareStatement("delete from student where id=?");
	    stmt.setObject(1,s);
		stmt.execute();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
		
	}
}

//更新修改数据
public final static void update(Connection con,Object obj[]){
	PreparedStatement stmt=null;
	try {
		stmt=con.prepareStatement("update student set name=?,mobile=?,sex=?,age=? where id=?");
		
		stmt.setString(5,obj[0].toString());
		stmt.setString(1,obj[1].toString());
		stmt.setString(2,obj[2].toString());
		stmt.setString(3,obj[3].toString());
		stmt.setString(4,obj[4].toString());
		stmt.execute();
		
		
		
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,"失败","操作提示",JOptionPane.NO_OPTION );
	}
}


}