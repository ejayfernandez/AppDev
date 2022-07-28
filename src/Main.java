import java.awt.Button;
import java.awt.Color;
//import java.awt.Component;
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
//import javax.swing.table.TableCellRenderer;

import java.text.DecimalFormat;


import com.toedter.calendar.JDateChooser;
import javax.swing.UIManager;

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
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    DecimalFormat fdf = new DecimalFormat("0.00");
    
    float accrec,
	    cash,
	    supplies,
	    land ,
	    equipment,
	    accpay,
	    unearned,
	    capital,
	    drawing,
	    sales,
	    revenue,
	    rent,
	    salary,
	    utility;
	float totalDebit = 0, totalCredit = 0;
	float netIncome, totalExpenses;
	float endingBalance;
	float totalAssets, totalLiabs, totalFinal;


	int ctr = 1;
	
    JTable tableEntries = new JTable(new DefaultTableModel(new Object[]{"Entry No & Date","Account","Debit","Credit"},0));
    JTable tableTrial = new JTable(new DefaultTableModel(new Object[]{"Account","Debit","Credit"},0));
    JTable tableStatement = new JTable(new DefaultTableModel(new Object[]{" "," "},0));
    JTable tableEquity = new JTable(new DefaultTableModel(new Object[]{" "," "},0));
    JTable tablePosition = new JTable(new DefaultTableModel(new Object[]{" "," "},0));
    
	DefaultTableModel entJournal = (DefaultTableModel) tableEntries.getModel();
	DefaultTableModel entTrial = (DefaultTableModel) tableTrial.getModel();
	DefaultTableModel entStatement = (DefaultTableModel) tableStatement.getModel();
	DefaultTableModel entEquity = (DefaultTableModel) tableEquity.getModel();
	DefaultTableModel entPosition = (DefaultTableModel) tablePosition.getModel();

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
		btnJournal.setBounds(-12, 68, 183, 63);
		panelTabs.add(btnJournal);
		
		Button btnTrial = new Button("Trial Balance");
		btnTrial.setForeground(Color.BLACK);
		btnTrial.setFont(new Font("Montserrat", Font.BOLD, 17));
		btnTrial.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnTrial.setBounds(-12, 150, 183, 55);
		panelTabs.add(btnTrial);
		
		Button btnStatement = new Button("Income Statement");
		btnStatement.setForeground(Color.BLACK);
		btnStatement.setFont(new Font("Montserrat", Font.BOLD, 17));
		btnStatement.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnStatement.setBounds(-12, 224, 183, 55);
		panelTabs.add(btnStatement);
		
		Button btnEquity = new Button("Owner's Equity");
		btnEquity.setForeground(Color.BLACK);
		btnEquity.setFont(new Font("Montserrat", Font.BOLD, 17));
		btnEquity.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnEquity.setBounds(-12, 298, 183, 55);
		panelTabs.add(btnEquity);

		Button btnPosition = new Button("Financial Position");
		btnPosition.setForeground(Color.BLACK);
		btnPosition.setFont(new Font("Montserrat", Font.BOLD, 17));
		btnPosition.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnPosition.setBounds(-12, 372, 183, 55);
		panelTabs.add(btnPosition);
		
		
		
		

		
		
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
					entJournal.setRowCount(0);
					//resets the journal to 0
						accrec = 0;
					    cash = 0;
					    supplies = 0;
					    land  = 0;
					    equipment = 0;
					    accpay = 0;
					    unearned = 0;
					    capital = 0;
					    drawing = 0;
					    sales = 0;
					    revenue = 0;
					    rent = 0;
					    salary = 0;
					    utility = 0;;
					    trialBalance();
				}
			});
			btnClearJournal.setForeground(SystemColor.text);
			btnClearJournal.setFont(new Font("Montserrat", Font.BOLD, 23));
			btnClearJournal.setBackground(new Color(51,51,51));
			btnClearJournal.setBounds(0, 412, 442, 49);
			panelJournal.add(btnClearJournal);
			
        JScrollPane tableScroll = new JScrollPane(tableEntries);        
        JTableHeader tableHeader = tableEntries.getTableHeader();
        
	        tableHeader.setBackground(new Color(250,215,0)); // change the Background color
	        tableHeader.setFont(new Font("Montserrat", Font.PLAIN, 17)); // font name style size
	        ((DefaultTableCellRenderer)tableHeader.getDefaultRenderer())
	                .setHorizontalAlignment(JLabel.CENTER); // center header text

	        	centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		        tableEntries.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		        tableEntries.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );

	        tableEntries.setFont(new Font("Montserrat", Font.PLAIN, 14));
	        tableEntries.getColumnModel().getColumn(0).setPreferredWidth(150);
	        tableHeader.setReorderingAllowed(false);
	        tableHeader.setResizingAllowed(false);
        tableScroll.setBounds(21, 64, 400, 326);
        panelJournal.add(tableScroll);
		
		
		
		
		
		
		
		JPanel panelTrial = new JPanel();
		panelTrial.setLayout(null);
		panelTrial.setBackground(Color.WHITE);
		panelTrial.setBounds(210, 100, 704, 461);
		frame.getContentPane().add(panelTrial);
		
		Label lblTrial = new Label("TRIAL BALANCE");
		lblTrial.setForeground(SystemColor.text);
		lblTrial.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblTrial.setBackground(new Color(51, 51, 51));
		lblTrial.setAlignment(Label.CENTER);
		lblTrial.setBounds(0, 0, 704, 43);
		panelTrial.add(lblTrial);

        JScrollPane tableScroll_Trial = new JScrollPane(tableTrial);        
        JTableHeader tableHeader_Trial = tableTrial.getTableHeader();

	        tableHeader_Trial.setBackground(new Color(250,215,0)); // change the Background color
	        tableHeader_Trial.setFont(new Font("Montserrat", Font.PLAIN, 17)); // font name style size
	        	((DefaultTableCellRenderer)tableHeader_Trial.getDefaultRenderer())
	                .setHorizontalAlignment(JLabel.CENTER); // center header text

	        	centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		        tableTrial.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		        tableTrial.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
	        
		        tableTrial.setFont(new Font("Montserrat", Font.PLAIN, 14));
	        tableHeader_Trial.setReorderingAllowed(false);
	        tableHeader_Trial.setResizingAllowed(false);
	        tableTrial.setRowHeight(23);

	        entTrial.addRow(new Object[]{"Accounts Receivable", 0, 0});
	        entTrial.addRow(new Object[]{"Cash", 0, 0});
	        entTrial.addRow(new Object[]{"Supplies", 0, 0});
	        entTrial.addRow(new Object[]{"Land", 0, 0});
	        entTrial.addRow(new Object[]{"Equipment", 0, 0});
	        entTrial.addRow(new Object[]{"Accounts Payable", 0, 0});
	        entTrial.addRow(new Object[]{"Unearned Income", 0, 0});
	        entTrial.addRow(new Object[]{"Capital", 0, 0});
	        entTrial.addRow(new Object[]{"Drawing", 0, 0});
	        entTrial.addRow(new Object[]{"Sales", 0, 0});
	        entTrial.addRow(new Object[]{"Service Revenue", 0, 0});
	        entTrial.addRow(new Object[]{"Rent Expense", 0, 0});
	        entTrial.addRow(new Object[]{"Salary Expense", 0, 0});
	        entTrial.addRow(new Object[]{"Utility Expense", 0, 0});
	        entTrial.addRow(new Object[]{"Total", 0, 0});
	    tableScroll_Trial.setBounds(21, 64, 660, 372);
        panelTrial.add(tableScroll_Trial);
        panelTrial.setVisible(false);
	        //Object c = tableTrial.getCellRenderer(13, 0);
			//((Component) c).setBackground(new Color(250,215,0));
		
        
        
        
        
        
        
        
        
        JPanel panelStatement = new JPanel();
		panelStatement.setLayout(null);
		panelStatement.setBackground(Color.WHITE);
		panelStatement.setBounds(210, 100, 704, 461);
		frame.getContentPane().add(panelStatement);
		
        JTableHeader tableHeader_Statement = tableStatement.getTableHeader();
        tableHeader_Statement.setBackground(new Color(250,215,0)); // change the Background color
        
		Label lblStatement = new Label("INCOME STATEMENT");
		lblStatement.setForeground(SystemColor.text);
		lblStatement.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblStatement.setBackground(new Color(51, 51, 51));
		lblStatement.setAlignment(Label.CENTER);
		lblStatement.setBounds(0, 0, 704, 43);
		panelStatement.add(lblStatement);

        JScrollPane tableScroll_Statement = new JScrollPane(tableStatement);        
	        	centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	        	tableStatement.setFont(new Font("Montserrat", Font.PLAIN, 14));
        	tableStatement.setRowHeight(30);

	        entStatement.addRow(new Object[]{"Service Revenue", 0});
	        entStatement.addRow(new Object[]{"EXPENSES  (LESS)----------------------------", 0});
	        entStatement.addRow(new Object[]{"Rent Expense", 0});
	        entStatement.addRow(new Object[]{"Salaries Expense", 0});
	        entStatement.addRow(new Object[]{"Utilities Expense", 0, 0});
	        entStatement.addRow(new Object[]{"NET INCOME  (LOSS)-------------------------", 0, 0});

	    tableScroll_Statement.setBounds(21, 64, 660, 372);
        panelStatement.add(tableScroll_Statement);
        panelStatement.setVisible(false);
        
        
        
        
        
        
        
        
        
        
        JPanel panelEquity = new JPanel();
		panelEquity.setLayout(null);
		panelEquity.setBackground(Color.WHITE);
		panelEquity.setBounds(210, 100, 704, 461);
		frame.getContentPane().add(panelEquity);
		
        JTableHeader tableHeader_Equity = tableEquity.getTableHeader();
        tableHeader_Equity.setBackground(new Color(250,215,0)); // change the Background color

        Label lblEquity = new Label("CHANGES IN OWNER'S EQUITY");
		lblEquity.setForeground(SystemColor.text);
		lblEquity.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblEquity.setBackground(new Color(51, 51, 51));
		lblEquity.setAlignment(Label.CENTER);
		lblEquity.setBounds(0, 0, 704, 43);
		panelEquity.add(lblEquity);

        JScrollPane tableScroll_Equity = new JScrollPane(tableEquity);        
	        	centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	        	tableEquity.setFont(new Font("Montserrat", Font.PLAIN, 14));
	        	tableEquity.setRowHeight(30);

	        entEquity.addRow(new Object[]{"Beginning Capital Balance", 0});
	        entEquity.addRow(new Object[]{"NET INCOME (ADD)--------------------------", 0});
	        entEquity.addRow(new Object[]{"Investment", 0});
	        entEquity.addRow(new Object[]{"Withdrawal", 0});
	        entEquity.addRow(new Object[]{"CAPITAL BALANCE (END)--------------------", 0, 0});

	        tableScroll_Equity.setBounds(21, 64, 660, 372);
        panelEquity.add(tableScroll_Equity);
        panelEquity.setVisible(false);
        
        
        
        
        
        
        
        
        JPanel panelPosition = new JPanel();
		panelPosition.setLayout(null);
		panelPosition.setBackground(Color.WHITE);
		panelPosition.setBounds(210, 100, 704, 461);
		frame.getContentPane().add(panelPosition);
		
        JTableHeader tableHeader_Position = tablePosition.getTableHeader();
        tableHeader_Position.setBackground(new Color(250,215,0)); // change the Background color

        Label lblPosition = new Label("FINANCIAL POSITION");
		lblPosition.setForeground(SystemColor.text);
		lblPosition.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblPosition.setBackground(new Color(51, 51, 51));
		lblPosition.setAlignment(Label.CENTER);
		lblPosition.setBounds(0, 0, 704, 43);
		panelPosition.add(lblPosition);

        JScrollPane tableScroll_Position = new JScrollPane(tablePosition);        
	        	centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	        	tablePosition.setFont(new Font("Montserrat", Font.PLAIN, 14));
	        	tablePosition.setRowHeight(30);

	        //entPosition.addRow(new Object[]{"ASSETS------------------------------------", 0});
	        entPosition.addRow(new Object[]{"Cash", 0});
	        entPosition.addRow(new Object[]{"Accounts Receivable", 0});
	        entPosition.addRow(new Object[]{"Supplies", 0});
	        entPosition.addRow(new Object[]{"Land", 0});
	        entPosition.addRow(new Object[]{"Equipment", 0});
	        entPosition.addRow(new Object[]{"TOTAL ASSETS---------", 0});
	        //entPosition.addRow(new Object[]{"LIABILITIES-------------------------------", 0});
	        entPosition.addRow(new Object[]{"Unearned Income", 0});
	        entPosition.addRow(new Object[]{"Accounts Payable", 0});
	        entPosition.addRow(new Object[]{"TOTAL LIABILITIES-------", 0});
	        entPosition.addRow(new Object[]{"Capital", 0});
	        entPosition.addRow(new Object[]{"TOTAL LIABILITIES AND CAPITAL-------------", 0});

	        tableScroll_Position.setBounds(170, 64, 350, 372);
        panelPosition.add(tableScroll_Position);
        panelPosition.setVisible(false);
        
        
        
        
        
        
        
        
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
								entJournal.addRow(new Object[]{(ctr* + 1) + "  " + df.format(dateChooser.getDate()), cmbDebit.getSelectedItem(), txtDebit.getText(), ""});
								tableTrial.getModel().setValueAt(txtDebit.getText(), 5, 1);
								compute(); ctr++; reset();
							}
							else if ( (cmbDebit.getSelectedItem().equals("") && txtDebit.getText().equals("")) && (!cmbCredit.getSelectedItem().equals("") && !txtCredit.getText().equals("")))		{			
								entJournal.addRow(new Object[]{(ctr* + 1) + "  " + df.format(dateChooser.getDate()), cmbCredit.getSelectedItem(), "", txtCredit.getText()});
								compute(); ctr++; reset();
							}
							else if ( (!cmbDebit.getSelectedItem().equals("") && !txtDebit.getText().equals("")) && (!cmbCredit.getSelectedItem().equals("") && !txtCredit.getText().equals(""))) {				
								entJournal.addRow(new Object[]{(ctr* + 1) + "  " + df.format(dateChooser.getDate()), cmbDebit.getSelectedItem(), txtDebit.getText(), ""});
								entJournal.addRow(new Object[]{"", cmbCredit.getSelectedItem(), "", txtCredit.getText()});
								compute(); ctr++; reset();
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
				
				btnSubmit.setBounds(32, 346, 169, 36);
				panelInputs.add(btnSubmit);
				btnSubmit.setFont(new Font("Montserrat", Font.BOLD, 17));
				btnSubmit.setForeground(new Color(0, 0, 0));
				btnSubmit.setBackground(new Color(255, 215, 0));
				
				Button btnReset = new Button("RESET");
				btnReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						reset();
					}
				});
				btnReset.setForeground(Color.WHITE);
				btnReset.setFont(new Font("Montserrat", Font.BOLD, 17));
				btnReset.setBackground(Color.DARK_GRAY);
				btnReset.setBounds(33, 390, 169, 36);
				panelInputs.add(btnReset);
        
        
        
        
        
				
				
				
				
				
		
		
		

		btnJournal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnJournal.setBackground(new Color(255, 215, 0));
				btnTrial.setBackground(SystemColor.inactiveCaptionBorder);
				btnStatement.setBackground(SystemColor.inactiveCaptionBorder);
				btnEquity.setBackground(SystemColor.inactiveCaptionBorder);
				btnPosition.setBackground(SystemColor.inactiveCaptionBorder);
				
				panelJournal.setVisible(true);
					panelInputs.setVisible(true);
				panelTrial.setVisible(false);
				panelStatement.setVisible(false);
				panelEquity.setVisible(false);
				panelPosition.setVisible(false);
			}
		});
		btnTrial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnJournal.setBackground(SystemColor.inactiveCaptionBorder);
				btnTrial.setBackground(new Color(255, 215, 0));
				btnStatement.setBackground(SystemColor.inactiveCaptionBorder);
				btnEquity.setBackground(SystemColor.inactiveCaptionBorder);
				btnPosition.setBackground(SystemColor.inactiveCaptionBorder);
				
				panelJournal.setVisible(false);
					panelInputs.setVisible(false);
				panelTrial.setVisible(true);
				panelStatement.setVisible(false);
				panelEquity.setVisible(false);
				panelPosition.setVisible(false);
			}
		});
		btnStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnJournal.setBackground(SystemColor.inactiveCaptionBorder);
				btnTrial.setBackground(SystemColor.inactiveCaptionBorder);
				btnStatement.setBackground(new Color(255, 215, 0));
				btnEquity.setBackground(SystemColor.inactiveCaptionBorder);
				btnPosition.setBackground(SystemColor.inactiveCaptionBorder);
				
				panelJournal.setVisible(false);
					panelInputs.setVisible(false);
				panelTrial.setVisible(false);
				panelStatement.setVisible(true);
				panelEquity.setVisible(false);
				panelPosition.setVisible(false);
			}
		});
		btnEquity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnJournal.setBackground(SystemColor.inactiveCaptionBorder);
				btnTrial.setBackground(SystemColor.inactiveCaptionBorder);
				btnStatement.setBackground(SystemColor.inactiveCaptionBorder);
				btnEquity.setBackground(new Color(255, 215, 0));
				btnPosition.setBackground(SystemColor.inactiveCaptionBorder);
				
				panelJournal.setVisible(false);
					panelInputs.setVisible(false);
				panelTrial.setVisible(false);
				panelStatement.setVisible(false);
				panelEquity.setVisible(true);
				panelPosition.setVisible(false);
			}
		});
		btnPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnJournal.setBackground(SystemColor.inactiveCaptionBorder);
				btnTrial.setBackground(SystemColor.inactiveCaptionBorder);
				btnStatement.setBackground(SystemColor.inactiveCaptionBorder);
				btnEquity.setBackground(SystemColor.inactiveCaptionBorder);
				btnPosition.setBackground(new Color(255, 215, 0));
				
				panelJournal.setVisible(false);
					panelInputs.setVisible(false);
				panelTrial.setVisible(false);
				panelStatement.setVisible(false);
				panelEquity.setVisible(false);
				panelPosition.setVisible(true);
			}
		});

		
        frame.setVisible(true);
	}

	public void compute() {
		String[] accs = { "Accounts Receivable", 
				"Cash", 
				"Supplies", 
				"Land", 
				"Equipment", 
				"Accounts Payable", 
				"Unearned Income", 
				"Capital", 
				"Drawing", 
				"Sales", 
				"Service Revenue", 
				"Rent Expense ", 
				"Salary Expense", 
				"Utility Expense"};

		for (int c = 0; c < 14; c++) {
			if(cmbDebit.getSelectedItem().equals(accs[c])) {
				if(c == 0) accrec += Float.parseFloat(txtDebit.getText().toString()); 
				else if(c == 1) cash += Float.parseFloat(txtDebit.getText().toString()); 
				else if(c == 2) supplies += Float.parseFloat(txtDebit.getText().toString()); 
				else if(c == 3) land += Float.parseFloat(txtDebit.getText().toString()); 
				else if(c == 4) equipment += Float.parseFloat(txtDebit.getText().toString()); 
				else if(c == 5) accpay += Float.parseFloat(txtDebit.getText().toString()); 
				else if(c == 6) unearned += Float.parseFloat(txtDebit.getText().toString()); 
				else if(c == 7) capital += Float.parseFloat(txtDebit.getText().toString()); 
				else if(c == 8) drawing += Float.parseFloat(txtDebit.getText().toString()); 
				else if(c == 9) sales += Float.parseFloat(txtDebit.getText().toString()); 
				else if(c == 10) revenue += Float.parseFloat(txtDebit.getText().toString()); 
				else if(c == 11) rent += Float.parseFloat(txtDebit.getText().toString()); 
				else if(c == 12) salary += Float.parseFloat(txtDebit.getText().toString()); 
				else utility += Float.parseFloat(txtDebit.getText().toString()); 

				tableTrial.getModel().setValueAt(txtDebit.getText(), c, 1);
			}
			
			if(cmbCredit.getSelectedItem().equals(accs[c])) {
				if(c == 0) accrec -= Float.parseFloat(txtCredit.getText().toString()); 
				else if(c == 1) cash -= Float.parseFloat(txtCredit.getText().toString()); 
				else if(c == 2) supplies -= Float.parseFloat(txtCredit.getText().toString()); 
				else if(c == 3) land -= Float.parseFloat(txtCredit.getText().toString()); 
				else if(c == 4) equipment -= Float.parseFloat(txtCredit.getText().toString()); 
				else if(c == 5) accpay -= Float.parseFloat(txtCredit.getText().toString()); 
				else if(c == 6) unearned -= Float.parseFloat(txtCredit.getText().toString()); 
				else if(c == 7) capital -= Float.parseFloat(txtCredit.getText().toString()); 
				else if(c == 8) drawing -= Float.parseFloat(txtCredit.getText().toString()); 
				else if(c == 9) sales -= Float.parseFloat(txtCredit.getText().toString()); 
				else if(c == 10) revenue -= Float.parseFloat(txtCredit.getText().toString()); 
				else if(c == 11) rent -= Float.parseFloat(txtCredit.getText().toString()); 
				else if(c == 12) salary -= Float.parseFloat(txtCredit.getText().toString()); 
				else utility -= Float.parseFloat(txtCredit.getText().toString()); 

				tableTrial.getModel().setValueAt(txtCredit.getText(), c, 2);
			}
			trialBalance();
		}				
	}
	public void trialBalance() {
		fdf.setMaximumFractionDigits(2);
		totalDebit = 0; totalCredit = 0;

		for(int r = 0; r<=14; r++) {
			for(int c = 1; c<=2; c++) {
				tableTrial.getModel().setValueAt("0.00", r, c);
			}
		}

			if (accrec >= 0) {
				tableTrial.getModel().setValueAt(fdf.format(accrec).toString(), 0, 1);
				totalDebit += accrec;			}
			else{
				tableTrial.getModel().setValueAt(fdf.format(Math.abs(accrec)).toString(), 0, 2);
				totalCredit += Math.abs(accrec);			}
			if (cash >= 0) {
				tableTrial.getModel().setValueAt(fdf.format(cash).toString(), 1, 1);
				totalDebit += cash;			}
			else{
				tableTrial.getModel().setValueAt(fdf.format(Math.abs(cash)).toString(), 1, 2);
				totalCredit += Math.abs(cash);			}
			if (supplies >= 0) {
				tableTrial.getModel().setValueAt(fdf.format(supplies).toString(), 2, 1);
				totalDebit += supplies;			}
			else{
				tableTrial.getModel().setValueAt(fdf.format(Math.abs(supplies)).toString(), 2, 2);
				totalCredit += Math.abs(supplies);			}
			if (land >= 0) {
				tableTrial.getModel().setValueAt(fdf.format(land).toString(), 3, 1);
				totalDebit += land;			}
			else{
				tableTrial.getModel().setValueAt(fdf.format(Math.abs(land)).toString(), 3, 2);
				totalCredit += Math.abs(land);			}
			if (equipment >= 0) {
				tableTrial.getModel().setValueAt(fdf.format(equipment).toString(), 4, 1);
				totalDebit += equipment;			}
			else{
				tableTrial.getModel().setValueAt(fdf.format(Math.abs(equipment)).toString(), 4, 2);
				totalCredit += Math.abs(equipment);			}
			if (accpay >= 0) {
				tableTrial.getModel().setValueAt(fdf.format(accpay).toString(), 5, 1);
				totalDebit += accpay;			}
			else{
				tableTrial.getModel().setValueAt(fdf.format(Math.abs(accpay)).toString(), 5, 2);
				totalCredit += Math.abs(accpay);			}
			if (unearned >= 0) {
				tableTrial.getModel().setValueAt(fdf.format(unearned).toString(), 6, 1);
				totalDebit += unearned;			}
			else{
				tableTrial.getModel().setValueAt(fdf.format(Math.abs(unearned)).toString(), 6, 2);
				totalCredit += Math.abs(unearned);			}
			if (capital >= 0) {
				tableTrial.getModel().setValueAt(fdf.format(capital).toString(), 7, 1);
				totalDebit += capital;			}
			else{
				tableTrial.getModel().setValueAt(fdf.format(Math.abs(capital)).toString(), 7, 2);
				totalCredit += Math.abs(capital);			}
			if (drawing >= 0) {
				tableTrial.getModel().setValueAt(fdf.format(drawing).toString(), 8, 1);
				totalDebit += drawing;			}
			else{
				tableTrial.getModel().setValueAt(fdf.format(Math.abs(drawing)).toString(), 8, 2);
				totalCredit += Math.abs(drawing);			}
			if (sales >= 0) {
				tableTrial.getModel().setValueAt(fdf.format(sales).toString(), 9, 1);
				totalDebit += sales;			}
			else{
				tableTrial.getModel().setValueAt(fdf.format(Math.abs(sales)).toString(), 9, 2);
				totalCredit += Math.abs(sales);			}
			if (revenue >= 0) {
				tableTrial.getModel().setValueAt(fdf.format(revenue).toString(), 10, 1);
				totalDebit += revenue;			}
			else{
				tableTrial.getModel().setValueAt(fdf.format(Math.abs(revenue)).toString(), 10, 2);
				totalCredit += Math.abs(revenue);			}
			if (rent >= 0) {
				tableTrial.getModel().setValueAt(fdf.format(rent).toString(), 11, 1);
				totalDebit += rent;			}
			else{
				tableTrial.getModel().setValueAt(fdf.format(Math.abs(rent)).toString(), 11, 2);
				totalCredit += Math.abs(rent);			}
			if (salary >= 0) {
				tableTrial.getModel().setValueAt(fdf.format(salary).toString(), 12, 1);
				totalDebit += salary;			}
			else{
				tableTrial.getModel().setValueAt(fdf.format(Math.abs(salary)).toString(), 12, 2);
				totalCredit += Math.abs(salary);			}
			if (utility >= 0) {
				tableTrial.getModel().setValueAt(fdf.format(utility).toString(), 13, 1);
				totalDebit += utility;			}
			else{
				tableTrial.getModel().setValueAt(fdf.format(Math.abs(utility)).toString(), 13, 2);
				totalCredit += Math.abs(utility);			}
			
			tableTrial.getModel().setValueAt(fdf.format(totalDebit).toString(), 14, 1);
			tableTrial.getModel().setValueAt(fdf.format(totalCredit).toString(), 14, 2);
			
			incomeStatement();
	}
	
	public void incomeStatement() {
		tableStatement.getModel().setValueAt(fdf.format(Math.abs(revenue)).toString(), 0, 1);
		tableStatement.getModel().setValueAt(fdf.format(Math.abs(rent)).toString(), 2, 1);
		tableStatement.getModel().setValueAt(fdf.format(Math.abs(salary)).toString(), 3, 1);
		tableStatement.getModel().setValueAt(fdf.format(Math.abs(utility)).toString(), 4, 1);
			totalExpenses = Math.abs(rent)+Math.abs(salary)+Math.abs(utility);
			netIncome = Math.abs(revenue) - totalExpenses;
		tableStatement.getModel().setValueAt(fdf.format(netIncome).toString(), 5, 1);
		
		ownerEquity();
	}
	
	public void ownerEquity() {
		tableEquity.getModel().setValueAt(fdf.format(Math.abs(netIncome)).toString(), 1, 1);
		tableEquity.getModel().setValueAt(fdf.format(Math.abs(capital)).toString(), 2, 1);
		tableEquity.getModel().setValueAt(fdf.format(Math.abs(drawing)).toString(), 3, 1);
			endingBalance = netIncome + Math.abs(capital) - Math.abs(drawing);
			tableEquity.getModel().setValueAt(fdf.format(Math.abs(drawing)).toString(), 4, 1);
			
		finPosition();
	}
	
	public void finPosition() {
		tablePosition.getModel().setValueAt(fdf.format(Math.abs(cash)).toString(), 0, 1);
		tablePosition.getModel().setValueAt(fdf.format(Math.abs(accrec)).toString(), 1, 1);
		tablePosition.getModel().setValueAt(fdf.format(Math.abs(supplies)).toString(), 2, 1);
		tablePosition.getModel().setValueAt(fdf.format(Math.abs(land)).toString(), 3, 1);
		tablePosition.getModel().setValueAt(fdf.format(Math.abs(equipment)).toString(), 4, 1);
			totalAssets = Math.abs(cash) + Math.abs(accrec) + Math.abs(supplies) + Math.abs(land) + Math.abs(equipment);
			tablePosition.getModel().setValueAt(fdf.format(Math.abs(totalAssets)).toString(), 5, 1);
		tablePosition.getModel().setValueAt(fdf.format(Math.abs(unearned)).toString(), 6, 1);
		tablePosition.getModel().setValueAt(fdf.format(Math.abs(accpay)).toString(), 7, 1);
			totalLiabs = Math.abs(unearned) + Math.abs(accpay);
			tablePosition.getModel().setValueAt(fdf.format(Math.abs(totalLiabs)).toString(), 8, 1);
		tablePosition.getModel().setValueAt(fdf.format(Math.abs(capital)).toString(), 9, 1);
			totalFinal = endingBalance + totalLiabs;
			tablePosition.getModel().setValueAt(fdf.format(Math.abs(totalFinal)).toString(), 10, 1);
	}
	
	public void reset() {
		cmbDebit.setSelectedItem("");
		cmbCredit.setSelectedItem("");
		txtDebit.setText("");
		txtCredit.setText("");
		dateChooser.setDate(null);
	}
}



























