import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.SwingConstants;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class WinFriendShipDelete extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfNid;
	private JTextField tfName;
	private JTextField tfMoblie;
	private JTextField tfaddr;
	private JTextField tfaddr2;
	private JTextField tfEmail;
	private JTextField tfBirth;
	private String numpattern = "^[0-9]*$";
	private String fileName;
	private JComboBox cbEmail;
	private JLabel lblPic;
	private JComboBox cbGradYear;
	private JCheckBox cbxSLType;
	private boolean check;
	private JButton okButton;
	private Container container;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WinFriendShipDelete dialog = new WinFriendShipDelete();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WinFriendShipDelete() {
		
		setBounds(100, 100, 482, 351);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblPic = new JLabel("");
		
		lblPic.setOpaque(true);
		lblPic.setBackground(new Color(255, 255, 0));
		lblPic.setBounds(12, 10, 131, 134);
		contentPanel.add(lblPic);
		
		JLabel lblNID = new JLabel("\uD559\uBC88");
		lblNID.setBounds(155, 26, 57, 15);
		contentPanel.add(lblNID);
		
		tfNid = new JTextField();
		tfNid.setBounds(224, 23, 116, 21);
		contentPanel.add(tfNid);
		tfNid.setColumns(10);
		
		JLabel lblName = new JLabel("\uC774\uB984");
		lblName.setBounds(155, 54, 57, 15);
		contentPanel.add(lblName);
		
		tfName = new JTextField();
		tfName.setEnabled(false);
		tfName.setColumns(10);
		tfName.setBounds(224, 51, 116, 21);
		contentPanel.add(tfName);
		
		JLabel lblMoblie = new JLabel("\uC804\uD654\uBC88\uD638");
		lblMoblie.setBounds(155, 82, 57, 15);
		contentPanel.add(lblMoblie);
		
		tfMoblie = new JTextField();
		tfMoblie.setEnabled(false);
		tfMoblie.setColumns(10);
		tfMoblie.setBounds(224, 79, 116, 21);
		contentPanel.add(tfMoblie);
		
		JLabel lbladdr = new JLabel("\uC8FC\uC18C");
		lbladdr.setBounds(12, 154, 44, 15);
		contentPanel.add(lbladdr);
		
		tfaddr = new JTextField();
		tfaddr.setEnabled(false);
		tfaddr.setEditable(false);
		tfaddr.setBounds(81, 152, 260, 18);
		contentPanel.add(tfaddr);
		tfaddr.setColumns(10);
		
		tfaddr2 = new JTextField();
		tfaddr2.setEnabled(false);
		tfaddr2.setColumns(10);
		tfaddr2.setBounds(81, 179, 342, 18);
		contentPanel.add(tfaddr2);
		
		JButton btnAddrSearch = new JButton("\uAC80\uC0C9...");
		btnAddrSearch.setEnabled(false);
		
		btnAddrSearch.setBounds(349, 151, 74, 21);
		contentPanel.add(btnAddrSearch);
		
		tfEmail = new JTextField();
		tfEmail.setEnabled(false);
		tfEmail.setColumns(10);
		tfEmail.setBounds(224, 107, 74, 21);
		contentPanel.add(tfEmail);
		
		JLabel lblEmail = new JLabel("\uC774\uBA54\uC77C");
		lblEmail.setBounds(155, 110, 57, 15);
		contentPanel.add(lblEmail);
		
		JLabel lblBirth = new JLabel("\uC0DD\uC77C");
		lblBirth.setBounds(12, 215, 57, 15);
		contentPanel.add(lblBirth);
		
		tfBirth = new JTextField();
		tfBirth.setEnabled(false);
		tfBirth.setEditable(false);
		tfBirth.setBounds(81, 212, 116, 21);
		contentPanel.add(tfBirth);
		tfBirth.setColumns(10);
		
		JLabel lblGradYear = new JLabel("\uC878\uC5C5\uB144\uB3C4");
		lblGradYear.setBounds(12, 243, 57, 15);
		contentPanel.add(lblGradYear);
		
		cbxSLType = new JCheckBox("\uC559\uB825");
		cbxSLType.setEnabled(false);
		
		cbxSLType.setBounds(204, 211, 57, 23);
		contentPanel.add(cbxSLType);
		
		cbGradYear = new JComboBox();
		cbGradYear.setEnabled(false);
		cbGradYear.setEditable(true);
		cbGradYear.setBounds(81, 239, 116, 23);
		contentPanel.add(cbGradYear);
		
		JLabel lbladdr2 = new JLabel("\uC0C1\uC138 \uC8FC\uC18C");
		lbladdr2.setBounds(12, 179, 57, 15);
		contentPanel.add(lbladdr2);
		
		JLabel lblNewLabel = new JLabel("@");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(280, 110, 57, 15);
		contentPanel.add(lblNewLabel);
		
		cbEmail = new JComboBox();
		cbEmail.setEnabled(false);
		cbEmail.setModel(new DefaultComboBoxModel(new String[] {"\uC9C1\uC811\uC785\uB825", "naver.com", "daum.net", "google.com"}));
		cbEmail.setEditable(true);
		cbEmail.setBounds(319, 106, 104, 23);
		contentPanel.add(cbEmail);

	
		
	
		
		
		JButton btnsearch = new JButton("\uD559\uC0DD\uC870\uD68C");
		
		btnsearch.setBounds(352, 22, 102, 23);
		contentPanel.add(btnsearch);
		
		JButton btnCalendar = new JButton("\uC120\uD0DD");
		btnCalendar.setEnabled(false);
		btnCalendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WinCalendar calendar = new WinCalendar();
				calendar.setModal(true);
				calendar.setVisible(true);
				tfBirth.setText(calendar.getDate());
			}
		});
		btnCalendar.setBounds(262, 211, 74, 23);
		contentPanel.add(btnCalendar);
		{
			okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					delete();
				}
			});
			okButton.setBounds(319, 279, 57, 23);
			contentPanel.add(okButton);
			okButton.setEnabled(false);
			
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setBounds(381, 279, 73, 23);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
	}

	protected void reset() {
		Component[] com = contentPanel.getComponents();
		System.out.println(com.length);
		for(Component c : com) {
			if(c instanceof JTextField) {
				((JTextField) c).setText("");
			}else if (c instanceof JComboBox) {
				((JComboBox) c).setSelectedIndex(0);
			}
			
		}
		lblPic.setIcon(null);
		okButton.setEnabled(false);
	}

	

	protected void delete() {
		
		
			Connection conn = null ;
			PreparedStatement pstmt = null;
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb", "root","1234");
	//	        System.out.println("DB ���� �Ϸ�");  
		        
		        String sql = "DELETE FROM addrbooktbl WHERE nid = ?";
		        // nid / name / moblie / address / email / pic /gradyear / brith / sltype
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, tfNid.getText());
		        pstmt.executeUpdate();
		        
		      
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					
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

	
}
