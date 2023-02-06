import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Winmain extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Winmain dialog = new Winmain();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JButton btnInsert;
	private JButton btnDelete;
	private AbstractButton btnUpdate;
	private JButton brnSearch;

	/**
	 * Create the dialog.
	 */
	public Winmain() {
		setTitle("\uB3D9\uCC3D\uD68C \uC8FC\uC18C\uB85D \uAD00\uB9AC\uD504\uB85C\uADF8\uB7A8");
		setBounds(100, 100, 304, 299);
		getContentPane().setLayout(new GridLayout(2, 2, 0, 0));
		
		btnInsert = new JButton("");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				WinFriendShipInsert insert = new WinFriendShipInsert();
				insert.setModal(true);
				insert.setVisible(true);
				
		
				
				
			}
		});
		btnInsert.setIcon(new ImageIcon(Winmain.class.getResource("/image/memberAdd.png")));
		getContentPane().add(btnInsert);
		
		btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDelete.setIcon(new ImageIcon(Winmain.class.getResource("/image/memberRemove.png")));
		getContentPane().add(btnDelete);
		
		btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon(Winmain.class.getResource("/image/memberUpdate.png")));
		getContentPane().add(btnUpdate);
		
		brnSearch = new JButton("");
		brnSearch.setIcon(new ImageIcon(Winmain.class.getResource("/image/memberSearch.png")));
		getContentPane().add(brnSearch);

	}

}
