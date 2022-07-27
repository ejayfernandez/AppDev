import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import com.toedter.calendar.JCalendar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.SystemColor;
import java.awt.Label;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private JTextField txtDebit;
	private JTextField txtCredit;
	
    DefaultTableModel modelEntries = new DefaultTableModel(){
		private static final long serialVersionUID = 4061691425374337651L;
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
        }
    };
    private JTextField textField;

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
	void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.scrollbar);
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 943, 587);
		frame.getContentPane().setLayout(null);
		
		JPanel panelInputs = new JPanel();
		panelInputs.setBackground(SystemColor.text);
		panelInputs.setBounds(679, 100, 235, 461);
		frame.getContentPane().add(panelInputs);
		panelInputs.setLayout(null);
		
		JLabel lblDebit = new JLabel("DEBIT");
		lblDebit.setBounds(28, 86, 114, 14);
		panelInputs.add(lblDebit);
		lblDebit.setFont(new Font("Montserrat", Font.PLAIN, 17));
		
		txtDebit = new JTextField();
		txtDebit.setBounds(28, 111, 169, 36);
		panelInputs.add(txtDebit);
		txtDebit.setFont(new Font("Montserrat", Font.PLAIN, 17));
		txtDebit.setColumns(10);
		
		JLabel lblCredit = new JLabel("CREDIT");
		lblCredit.setBounds(28, 158, 96, 14);
		panelInputs.add(lblCredit);
		lblCredit.setFont(new Font("Montserrat", Font.PLAIN, 17));
		
		txtCredit = new JTextField();
		txtCredit.setBounds(28, 183, 169, 36);
		panelInputs.add(txtCredit);
		txtCredit.setFont(new Font("Montserrat", Font.PLAIN, 17));
		txtCredit.setColumns(10);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setBounds(28, 230, 96, 14);
		panelInputs.add(lblDate);
		lblDate.setFont(new Font("Montserrat", Font.PLAIN, 17));
		
		Button btnSubmit = new Button("SUBMIT");
		btnSubmit.setBounds(33, 364, 169, 36);
		panelInputs.add(btnSubmit);
		btnSubmit.setFont(new Font("Montserrat", Font.BOLD, 17));
		btnSubmit.setForeground(new Color(0, 0, 0));
		btnSubmit.setBackground(new Color(255, 215, 0));
		
		Label lblInputs = new Label("ADD ENTRY");
		lblInputs.setForeground(SystemColor.text);
		lblInputs.setAlignment(Label.CENTER);
		lblInputs.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblInputs.setBackground(new Color(51, 51, 51));
		lblInputs.setBounds(0, 0, 235, 43);
		panelInputs.add(lblInputs);
		
		textField = new JTextField();
		textField.setFont(new Font("Montserrat", Font.PLAIN, 17));
		textField.setColumns(10);
		textField.setBounds(28, 255, 135, 36);
		panelInputs.add(textField);
		
		JPanel panelCalendar = new JPanel();
		panelCalendar.setBorder(null);
		panelCalendar.setBackground(SystemColor.text);
		panelCalendar.setBounds(5, 255, 224, 173);
		panelInputs.add(panelCalendar);
			panelCalendar.setVisible(false);
		panelCalendar.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 11, 206, 153);
		panelCalendar.add(calendar);
		
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
		
		JPanel panelJournal = new JPanel();
		panelJournal.setLayout(null);
		panelJournal.setBackground(Color.WHITE);
		panelJournal.setBounds(237, 100, 415, 461);
		frame.getContentPane().add(panelJournal);
		
		Button btnClearJournal = new Button("CLEAR");
		btnClearJournal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClearJournal.setForeground(SystemColor.text);
		btnClearJournal.setFont(new Font("Montserrat", Font.BOLD, 17));
		btnClearJournal.setBackground(new Color(51,51,51));
		btnClearJournal.setBounds(0, 412, 415, 49);
		panelJournal.add(btnClearJournal);
		
		Label lblJournal = new Label("GENERAL JOURNAL");
		lblJournal.setForeground(SystemColor.text);
		lblJournal.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblJournal.setBackground(new Color(51, 51, 51));
		lblJournal.setAlignment(Label.CENTER);
		lblJournal.setBounds(0, 0, 415, 43);
		panelJournal.add(lblJournal);

		Object[][] data = {
			{"Sample Date", "Accounts Receivable", "500", ""}
		};

        JTable tableEntries = new JTable(data, new Object[]{"Entry No & Date","Account","Debit","Credit"});
        JScrollPane tableScroll = new JScrollPane(tableEntries);        
        JTableHeader tableHeader = tableEntries.getTableHeader();
        
	        tableHeader.setBackground(new Color(250,215,0)); // change the Background color
	        tableHeader.setFont(new Font("Montserrat", Font.PLAIN, 17)); // font name style size
	        ((DefaultTableCellRenderer)tableHeader.getDefaultRenderer())
	                .setHorizontalAlignment(JLabel.CENTER); // center header text
	        tableEntries.setFont(new Font("Montserrat", Font.PLAIN, 15));
	        tableHeader.setReorderingAllowed(false);
        tableScroll.setBounds(21, 64, 373, 326);
        panelJournal.add(tableScroll);
        
		JPanel panelTabs = new JPanel();
		panelTabs.setLayout(null);
		panelTabs.setBackground(Color.WHITE);
		panelTabs.setBounds(27, 100, 183, 461);
		frame.getContentPane().add(panelTabs);
		
		Label lblTabs = new Label("TABS");
		lblTabs.setForeground(SystemColor.text);
		lblTabs.setFont(new Font("Montserrat", Font.BOLD, 23));
		lblTabs.setBackground(new Color(51, 51, 51));
		lblTabs.setAlignment(Label.CENTER);
		lblTabs.setBounds(0, 0, 183, 43);
		panelTabs.add(lblTabs);
		
		Button btnJournal = new Button("SUBMIT");
		btnJournal.setForeground(Color.BLACK);
		btnJournal.setFont(new Font("Montserrat", Font.BOLD, 17));
		btnJournal.setBackground(new Color(255, 215, 0));
		btnJournal.setBounds(1, 66, 183, 114);
		panelTabs.add(btnJournal);
		
		Button btnTrial = new Button("SUBMIT");
		btnTrial.setForeground(Color.BLACK);
		btnTrial.setFont(new Font("Montserrat", Font.BOLD, 17));
		btnTrial.setBackground(SystemColor.inactiveCaptionBorder);
		btnTrial.setBounds(0, 194, 183, 114);
		panelTabs.add(btnTrial);
		
		Button btnStatement = new Button("SUBMIT");
		btnStatement.setForeground(Color.BLACK);
		btnStatement.setFont(new Font("Montserrat", Font.BOLD, 17));
		btnStatement.setBackground(SystemColor.inactiveCaptionBorder);
		btnStatement.setBounds(0, 324, 183, 114);
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

//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
	}
}
