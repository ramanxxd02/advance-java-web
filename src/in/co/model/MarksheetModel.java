package in.co.model;


import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.cj.util.DnsSrv.SrvRecord;

import in.co.bean.MarksheetBean;
import in.co.util.JDBCDataSource;


public class MarksheetModel {
	ResourceBundle rb=ResourceBundle.getBundle("in.co.bundle.System");
	
	public void add(MarksheetBean bean) throws Exception {
		Class.forName(rb.getString("driver"));
		Connection conn=DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));
        PreparedStatement ps=conn.prepareStatement("insert into marksheet values (?,?,?,?,?,?)");
        
        ps.setInt(1, bean.getId());
        ps.setString(2, bean.getRollno());
        ps.setString(3, bean.getName());
        ps.setInt(4, bean.getPhysics());
        ps.setInt(5,bean.getChemistry());
        ps.setInt(6, bean.getMaths());
        
        int i=ps.executeUpdate();
        System.out.println("done"+i);
	}
	public void update(MarksheetBean bean) throws Exception  {
		
		Class.forName(rb.getString("driver"));
		Connection conn=DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));
        PreparedStatement ps=conn.prepareStatement("update marksheet set rollno=?,name=?,physics=?,chemistry=?,maths=? where id =?");
        
       
        ps.setString(1, bean.getRollno());
        ps.setString(2, bean.getName());
        ps.setInt(3, bean.getPhysics());
        ps.setInt(4,bean.getChemistry());
        ps.setInt(5, bean.getMaths());
        ps.setInt(6, bean.getId());
        int i=ps.executeUpdate();
        System.out.println("done"+i);
	}
	public void delete(int id) throws Exception {
		Class.forName(rb.getString("driver"));
		Connection conn=DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));
        PreparedStatement ps=conn.prepareStatement("delete from marksheet where id =?");
        
        ps.setInt(1,id);
        int i=ps.executeUpdate();
        		
        System.out.println("done"+i);
	}
	
	public MarksheetBean idget(int id) throws Exception {
		Class.forName(rb.getString("driver"));
		Connection conn=DriverManager.getConnection(rb.getString("url"),rb.getString("username"),rb.getString("password"));
        PreparedStatement ps=conn.prepareStatement("select*from marksheet where id=?");
         ps.setInt(1,id);
      
        ResultSet rs=ps.executeQuery();
        System.out.println("done"+rs);
        MarksheetBean bean=null;
        while(rs.next()) {
        	bean=new MarksheetBean();
           bean.setId(rs.getInt(1));
           bean.setRollno(rs.getString(2));
           bean.setName(rs.getString(3));
           bean.setPhysics(rs.getInt(4));
           bean.setChemistry(rs.getInt(5));
           bean.setMaths(rs.getInt(6));
        }
		return bean;
	}
	public List search(MarksheetBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" and id = " + bean.getId());
			}

			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + bean.getName() + "%'");
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}

		System.out.println("sql => " + sql);

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getString(2));
			bean.setName(rs.getString(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);
		}

		JDBCDataSource.closeConnection(conn);

		return list;
	}
	public MarksheetBean findByPk(int id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where id = ?");

		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		MarksheetBean bean = null;

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getString(2));
			bean.setName(rs.getString(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}

		JDBCDataSource.closeConnection(conn);

		return bean;
	}
}
