import java.awt.EventQueue;
import java.util.Calendar;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class WinCalendar extends JDialog {
	private JPanel panelCalendar;
	private JComboBox cbMonth;
	private JComboBox cbYear;
	protected String strDate;
	
	public String getDate() {
		return strDate;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinCalendar dialog = new WinCalendar();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	/**
	 * Create the dialog.
	 */
	public WinCalendar() {
		setTitle("�޷� ����");
		setBounds(100, 100, 614, 472);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;		
		System.out.println(year + "��, " + month +"��");
		
		JButton btnPrevYear = new JButton("<<");
		btnPrevYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���� �⵵
				int year = (int) cbYear.getSelectedItem();
				year--;
				if(year==1923)
					year=1923;
				cbYear.setSelectedItem(year);
				
				ShowCalendar();
			}
		});
		panel.add(btnPrevYear);
		
		JButton btnPrevMonth = new JButton("<");
		btnPrevMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int month = (int) cbMonth.getSelectedItem();
				int year = (int) cbYear.getSelectedItem();
				month--;
				if(month==0) {
					month=12;
					year--;
					if(year==1923)
						year = 1923;
					cbYear.setSelectedItem(year);
				}				
				cbMonth.setSelectedItem(month);
				
				ShowCalendar();
			}
		});
		panel.add(btnPrevMonth);
		
		cbYear = new JComboBox();
		
		
		panel.add(cbYear);
		
		for(int y=1923; y<=2123;y++)
			cbYear.addItem(y);
		cbYear.setSelectedItem(year);
		
		JLabel lblYear = new JLabel("��");
		panel.add(lblYear);
		
		cbMonth = new JComboBox();
		
		for(int m=1; m<=12; m++)
			cbMonth.addItem(m);
		cbMonth.setSelectedItem(month);
		
		panel.add(cbMonth);
		
		
		
		JLabel lblMonth = new JLabel("��");
		panel.add(lblMonth);
		
		JButton btnNextMonth = new JButton(">");
		btnNextMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int year = (int) cbYear.getSelectedItem();
				int month = (int) cbMonth.getSelectedItem();
				// ���� Ȯ���� �������� �ۼ��ϼ���. (2123�� 12�� ����)
				month++;
				if(month==13) {
					month=1;
					year++;
					cbYear.setSelectedItem(year);
				}
				cbMonth.setSelectedItem(month);
				
				ShowCalendar();
			}
		});
		panel.add(btnNextMonth);
		
		JButton btnNextYear = new JButton(">>");
		btnNextYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���� �⵵
				int year = (int) cbYear.getSelectedItem();
				year++;
				if(year==2123)
					year=2123;
				cbYear.setSelectedItem(year);
				
				ShowCalendar();
			}
		});
		panel.add(btnNextYear);
		
		JButton btnToday = new JButton("����");
		btnToday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar calendar = Calendar.getInstance();
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH)+1;
				cbYear.setSelectedItem(year);
				cbMonth.setSelectedItem(month);
				ShowCalendar();
			}
		});
		panel.add(btnToday);
		
		panelCalendar = new JPanel();
		getContentPane().add(panelCalendar, BorderLayout.CENTER);
		panelCalendar.setLayout(new GridLayout(0, 7, 0, 0));
		
		cbYear.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ShowCalendar();
			}
		});
		cbMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowCalendar();
			}
		});
		ShowCalendar();
	}

	protected void ShowCalendar() {
		Calendar calendar = Calendar.getInstance();
		int curYear = calendar.get(Calendar.YEAR);
		int curMonth = calendar.get(Calendar.MONTH) + 1;		
		int curDate = calendar.get(Calendar.DATE);
		System.out.println(curYear + "��" + curMonth +"��" + curDate + "��");
		
		// ������(��ư) �����ϱ�
		Component [] componentList = panelCalendar.getComponents();
		for(Component c : componentList) {
			if(c instanceof JButton)
				panelCalendar.remove(c);
		}
		panelCalendar.revalidate();
		panelCalendar.repaint();
		
		int Month[]= {31,28,31,30,31,30,31,31,30,31,30,31};
		String Yoil[] = {"��","��","ȭ","��","��","��","��"};
		int index = 1; // 1923�� 1�� 1�� ������(1)
		int sum=0;
		int year = (int) cbYear.getSelectedItem();
		int month = cbMonth.getSelectedIndex();	
		// ���� ��ư �����ϱ�
		for(int i=0 ; i<7 ; i++) {
			JButton btn = new JButton(Yoil[i]);	
			btn.setBackground(Color.RED);
			panelCalendar.add(btn);
		}
		// ���� �ر����� �� ���ϱ� 1923~
		for(int y=1923; y<year; y++) {
			if(y%4==0 && y%100 != 0 || y%400==0)
				sum = sum + 366;
			else
				sum = sum + 365;
		}					
		// ������ ���� �ޱ����� �� ���ϱ�
		for(int i=0; i<month; i++) {
			if(i==1 && (year%4==0 && year%100 != 0 || year%400==0))
				sum = sum + ++Month[i];
			else
				sum = sum + Month[i];
		}
		
		index = (sum+index)%7; // 1�� ������ġ
		
		// �� ��ư �����ϱ�
		for(int i=0 ; i < index ; i++) {
			JButton btn = new JButton("");	
			panelCalendar.add(btn);
			//btn.setVisible(false);
		}
		// �����ϱ�		
		int lastDay = Month[month];
		if(month==1 && (year%4==0 && year%100 != 0 || year%400==0))
			lastDay++;
		
		for(int i=1 ; i<= lastDay ; i++) {
			JButton btn = new JButton(i + "");	
			if(curYear == year && curMonth == month+1 &&  i == curDate)
				btn.setBackground(Color.GREEN);
			panelCalendar.add(btn);
			
			btn.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					String sm;
					String sdate;
					JButton btnSrc = (JButton)e.getSource();
					System.out.println(btnSrc.getText());
					int year = (int) cbYear.getSelectedItem();
					
					int month = (int) cbMonth.getSelectedItem();
					if(month<10) {
						sm = "0"+month;
						
					}else {
						sm=month+"";
					}
					String srcdate =btnSrc.getText();
					if(srcdate.length()<2) {
						sdate = "0"+srcdate;
						
					}else {
						sdate = srcdate;
					}
					strDate = year + "-" + sm + "-" + sdate; 
					System.out.println(strDate);
					setVisible(false);
				}
			});
		}
		
		// �ڿ� �� ��ư ����
		for(int i = (7-(index+Month[month])%7)%7; i>0; i--){
			JButton btn = new JButton("");	
			panelCalendar.add(btn);
			//btn.setVisible(false);
		}
		
		panelCalendar.revalidate();
	}

}