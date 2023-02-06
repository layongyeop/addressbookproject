import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class WinDoroList extends JDialog {

	private DefaultListModel model;
	String address;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinDoroList dialog = new WinDoroList();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JList list;

	/**
	 * Create the dialog.
	 */
	public WinDoroList() {
		setBounds(100, 100, 450, 300);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		list = new JList();
		list.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
		list.setForeground(new Color(0, 0, 0));
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2) {
					address = (String) list.getSelectedValue();
					setVisible(false);
				}
				
			}
		});
		scrollPane.setViewportView(list);
		
		
		
		
		
		
		
	
		
		

		
		
	
	
		
		
	}

	public WinDoroList(String doro) {
		this();
		showDoroList(doro);
		
	}

	
	private void showDoroList(String doro) {
		Connection conn = null ;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb", "root","1234");
//	        System.out.println("DB 연결 완료");  
	        
	        String sql = "SELECT distinct road,si,gu,dong from addresstbl where road Like ?";
	        Vector<String> vector= new Vector<>();
		       pstmt = conn.prepareStatement(sql);
		       pstmt.setString(1, "%"+doro+"%");
		       rs = pstmt.executeQuery();
		       while(rs.next()) {

		    	   String road = rs.getString("road").replaceAll(" ", "");
		    	   String si = rs.getString("si").replaceAll(" ", "");
		    	   String gu = rs.getString("gu").replaceAll(" ", "");
		    	   String dong = rs.getString("dong").replaceAll(" ", "");
//		    	;
		    	   if(dong==null||dong.equals("")) {
		    		   vector.add(si + " "+ gu+" "+ road);
		    	   }else {
		    		   vector.add(si + " "+ gu+" "+dong+" "+ road);
		    	   }
		    	   
		    	   
		    	   
		    	  
//		    	 
		       }
		  
		     
		   list.setListData(vector);
		   
	      
	        
	        
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null ) {
					rs.close();
				}
				if (pstmt != null) {
  				  pstmt.close();
  			  	}
  			  	if(conn != null) {
  				  conn.close();
  			  	}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}

	public String getAddress() {
		return address;
		
		
	}
		
	

}
