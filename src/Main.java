import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

public class Main{

	private JFrame frame;
	private JTextField txtDebit;
	private JTextField txtCredit;
	@SuppressWarnings("rawtypes")
	JComboBox cmbCredit = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox cmbDebit = new JComboBox();
	JDateChooser dateChooser = new JDateChooser();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	

	int ctr = 1;
	
    JTable tableEntries = new JTable(new DefaultTableModel(new Object[]{"Entry No & Date","Account","Debit","Credit"},0));
	DefaultTableModel entries = (DefaultTableModel) tableEntries.getModel();

    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					Main frame = new Main();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initialize(){
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.scrollbar);
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 943, 587);
		frame.getContentPane().setLayout(null);

		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(51, 51, 51));
		panelHeader.setBounds(0, 0, 943, 75);
		frame.getContentPane().add(panelHeader);
		panelHeader.setLayout(null);
		
		JLabel lblLogOut = new JLabel("LOG OUT");
		lblLogOut.setForeground(new Color(255, 215, 0));
		lblLogOut.setBounds(820, 27, 87, 22);
		lblLogOut.setFont(new Font("Montserrat", Font.PLAIN, 17));
		panelHeader.add(lblLogOut);
		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
			}
		});
		
		JPanel panelTabs = new JPanel();
		panelTabs.setLayout(null);
		panelTabs.setBackground(Color.WHITE);
		panelTabs.setBounds(27, 100, 158, 461);
		frame.getContentPane().add(panelTabs);
		
		Label lblTabs = new Label("TABS");
		lblTabs.setForeground(SystemColor.text);
		lblTabs.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblTabs.setBackground(new Color(51, 51, 51));
		lblTabs.setAlignment(Label.CENTER);
		lblTabs.setBounds(0, 0, 158, 43);
		panelTabs.add(lblTabs);
		
		Button btnJournal = new Button("General Journal");
		btnJournal.setForeground(Color.BLACK);
		btnJournal.setFont(new Font("Montserrat", Font.BOLD, 17));
		btnJournal.setBackground(new Color(255, 215, 0));
		btnJournal.setBounds(-12, 66, 183, 114);
		panelTabs.add(btnJournal);
		
		Button btnTrial = new Button("Trial Balance");
		btnTrial.setForeground(Color.BLACK);
		btnTrial.setFont(new Font("Montserrat", Font.BOLD, 17));
		btnTrial.setBackground(SystemColor.inactiveCaptionBorder);
		btnTrial.setBounds(-12, 194, 183, 114);
		panelTabs.add(btnTrial);
		
		Button btnStatement = new Button("Income Statement");
		btnStatement.setForeground(Color.BLACK);
		btnStatement.setFont(new Font("Montserrat", Font.BOLD, 17));
		btnStatement.setBackground(SystemColor.inactiveCaptionBorder);
		btnStatement.setBounds(-12, 324, 183, 114);
		panelTabs.add(btnStatement);
		
		btnJournal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnJournal.setBackground(new Color(255, 215, 0));
				btnTrial.setBackground(SystemColor.inactiveCaptionBorder);
				btnStatement.setBackground(SystemColor.inactiveCaptionBorder);
			}
		});
		btnTrial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnJournal.setBackground(SystemColor.inactiveCaptionBorder);
				btnTrial.setBackground(new Color(255, 215, 0));
				btnStatement.setBackground(SystemColor.inactiveCaptionBorder);
			}
		});
		btnStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnJournal.setBackground(SystemColor.inactiveCaptionBorder);
				btnTrial.setBackground(SystemColor.inactiveCaptionBorder);
				btnStatement.setBackground(new Color(255, 215, 0));
			}
		});
		
		
		
		
		
		
		
		
		
		JPanel panelJournal = new JPanel();
		panelJournal.setLayout(null);
		panelJournal.setBackground(Color.WHITE);
		panelJournal.setBounds(210, 100, 442, 461);
		frame.getContentPane().add(panelJournal);
		
		Label lblJournal = new Label("GENERAL JOURNAL");
		lblJournal.setForeground(SystemColor.text);
		lblJournal.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblJournal.setBackground(new Color(51, 51, 51));
		lblJournal.setAlignment(Label.CENTER);
		lblJournal.setBounds(0, 0, 442, 43);
		panelJournal.add(lblJournal);
		
			Button btnClearJournal = new Button("CLEAR");
			btnClearJournal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					entries.setRowCount(0);
				}
			});
			btnClearJournal.setForeground(SystemColor.text);
			btnClearJournal.setFont(new Font("Montserrat", Font.BOLD, 17));
			btnClearJournal.setBackground(new Color(51,51,51));
			btnClearJournal.setBounds(0, 412, 442, 49);
			panelJournal.add(btnClearJournal);
			
        JScrollPane tableScroll = new JScrollPane(tableEntries);        
        JTableHeader tableHeader = tableEntries.getTableHeader();
        
	        tableHeader.setBackground(new Color(250,215,0)); // change the Background color
	        tableHeader.setFont(new Font("Montserrat", Font.PLAIN, 17)); // font name style size
	        ((DefaultTableCellRenderer)tableHeader.getDefaultRenderer())
	                .setHorizontalAlignment(JLabel.CENTER); // center header text
	        tableEntries.setFont(new Font("Montserrat", Font.PLAIN, 14));
	        tableEntries.getColumnModel().getColumn(0).setPreferredWidth(150);
	        tableHeader.setReorderingAllowed(false);
	        tableHeader.setResizingAllowed(false);
        tableScroll.setBounds(21, 64, 400, 326);
        panelJournal.add(tableScroll);
        
        
        
        
        
        
        
   
		JPanel panelInputs = new JPanel();
		panelInputs.setBackground(SystemColor.text);
		panelInputs.setBounds(679, 100, 235, 461);
		frame.getContentPane().add(panelInputs);
		panelInputs.setLayout(null);
	
			Label lblInputs = new Label("ADD ENTRY");
			lblInputs.setForeground(SystemColor.text);
			lblInputs.setAlignment(Label.CENTER);
			lblInputs.setFont(new Font("Montserrat", Font.BOLD, 23));
			lblInputs.setBackground(new Color(51, 51, 51));
			lblInputs.setBounds(0, 0, 235, 43);
			panelInputs.add(lblInputs);
		
		JLabel lblDebit = new JLabel("DEBIT");
		lblDebit.setBounds(28, 76, 114, 14);
		panelInputs.add(lblDebit);
		lblDebit.setFont(new Font("Montserrat", Font.PLAIN, 17));
			
			cmbDebit.setToolTipText("Debit");
			cmbDebit.setFont(new Font("Montserrat", Font.PLAIN, 17));
			cmbDebit.setModel(new DefaultComboBoxModel(new String[] {"", "Accounts Receivable", "Cash", "Supplies", "Land", "Equipment", "Accounts Payable", "Unearned Income", "Capital", "Drawing", "Sales", "Service Revenue", "Rent Expense ", "Salary Expense", "Utility Expense"}));
			cmbDebit.setBounds(38, 97, 159, 28);
			panelInputs.add(cmbDebit);
			
			txtDebit = new JTextField();
			txtDebit.setBounds(40, 135, 159, 28);
			panelInputs.add(txtDebit);
			txtDebit.setFont(new Font("Montserrat", Font.PLAIN, 17));
			txtDebit.setColumns(10);
		
		JLabel lblCredit = new JLabel("CREDIT");
		lblCredit.setBounds(28, 172, 96, 14);
		panelInputs.add(lblCredit);
		lblCredit.setFont(new Font("Montserrat", Font.PLAIN, 17));
			
			cmbCredit.setToolTipText("Credit");
			cmbCredit.setModel(new DefaultComboBoxModel(new String[] {"", "Accounts Receivable", "Cash", "Supplies", "Land", "Equipment", "Accounts Payable", "Unearned Income", "Capital", "Drawing", "Sales", "Service Revenue", "Rent Expense ", "Salary Expense", "Utility Expense"}));
			cmbCredit.setFont(new Font("Montserrat", Font.PLAIN, 17));
			cmbCredit.setBounds(38, 193, 159, 28);
			panelInputs.add(cmbCredit);
			
			txtCredit = new JTextField();
			txtCredit.setFont(new Font("Montserrat", Font.PLAIN, 17));
			txtCredit.setColumns(10);
			txtCredit.setBounds(40, 231, 159, 28);
			panelInputs.add(txtCredit);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setBounds(28, 273, 96, 14);
		panelInputs.add(lblDate);
		lblDate.setFont(new Font("Montserrat", Font.PLAIN, 17));
		
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser.getCalendarButton().setIcon(new ImageIcon("C:\\Users\\ejaay\\eclipse-workspace\\AccountingSystem\\src\\img\\cal.png"));
		dateChooser.getCalendarButton().setFont(new Font("Montserrat", Font.PLAIN, 17));
		dateChooser.setBounds(28, 298, 169, 28);
		panelInputs.add(dateChooser);
		
		Button btnSubmit = new Button("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(dateChooser.getDate() != null) {
					if ( (!cmbDebit.getSelectedItem().equals("") && !txtDebit.getText().equals("")) && (cmbCredit.getSelectedItem().equals("") && txtCredit.getText().equals("")))	{				
						entries.addRow(new Object[]{(ctr* + 1) + "  " + df.format(dateChooser.getDate()), cmbDebit.getSelectedItem(), txtDebit.getText(), ""});
						ctr++;reset();
					}
					else if ( (cmbDebit.getSelectedItem().equals("") && txtDebit.getText().equals("")) && (!cmbCredit.getSelectedItem().equals("") && !txtCredit.getText().equals("")))		{			
						entries.addRow(new Object[]{(ctr* + 1) + "  " + df.format(dateChooser.getDate()), cmbCredit.getSelectedItem(), "", txtCredit.getText()});
						ctr++;reset();
					}
					else if ( (!cmbDebit.getSelectedItem().equals("") && !txtDebit.getText().equals("")) && (!cmbCredit.getSelectedItem().equals("") && !txtCredit.getText().equals(""))) {				
						entries.addRow(new Object[]{(ctr* + 1) + "  " + df.format(dateChooser.getDate()), cmbDebit.getSelectedItem(), txtDebit.getText(), ""});
						entries.addRow(new Object[]{"", cmbCredit.getSelectedItem(), "", txtCredit.getText()});
						ctr++;reset();
					}
					else{
						JOptionPane.showMessageDialog(new JPanel(), "Please input Debit/Credit first.", "Oops.",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				else JOptionPane.showMessageDialog(new JPanel(), "Please select entry date first.", "Oops.",
							JOptionPane.WARNING_MESSAGE);
			}
		});
		
		btnSubmit.setBounds(33, 364, 169, 36);
		panelInputs.add(btnSubmit);
		btnSubmit.setFont(new Font("Montserrat", Font.BOLD, 17));
		btnSubmit.setForeground(new Color(0, 0, 0));
		btnSubmit.setBackground(new Color(255, 215, 0));
		
		frame.setVisible(true);
	}
	
	public void reset() {
		cmbDebit.setSelectedItem("");
		cmbCredit.setSelectedItem("");
		txtDebit.setText("");
		txtCredit.setText("");
		dateChooser.setDate(null);
	}
}
