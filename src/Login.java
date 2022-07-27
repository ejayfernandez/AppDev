import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Login extends JFrame {
	private static final long serialVersionUID = -8611985006278409232L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 476);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		

		JLabel lblCloseButton = new JLabel("X");
		lblCloseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		
		lblCloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseButton.setForeground(Color.WHITE);
		lblCloseButton.setFont(new Font("Aemstel", Font.PLAIN, 18));
		lblCloseButton.setBounds(701, 0, 25, 27);
		contentPane.add(lblCloseButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(399, 102, 291, 282);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(28, 35, 114, 14);
		panel_1.add(lblUsername);
		lblUsername.setFont(new Font("Montserrat", Font.PLAIN, 15));
		
				txtUsername = new JTextField();
				txtUsername.setFont(new Font("Montserrat", Font.PLAIN, 17));
				txtUsername.setBounds(28, 61, 240, 42);
				panel_1.add(txtUsername);
				txtUsername.setColumns(10);
				
				JLabel lblPassword = new JLabel("PASSWORD");
				lblPassword.setBounds(28, 125, 130, 14);
				panel_1.add(lblPassword);
				lblPassword.setFont(new Font("Montserrat", Font.PLAIN, 15));
				
				txtPassword = new JPasswordField();
				txtPassword.setFont(new Font("Montserrat", Font.PLAIN, 17));
				txtPassword.setBounds(28, 150, 240, 42);
				panel_1.add(txtPassword);
				
				Button btnLogin = new Button("LOG IN");
				btnLogin.setBounds(49, 212, 197, 42);
				panel_1.add(btnLogin);
				btnLogin.setFont(new Font("Montserrat", Font.BOLD, 17));
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						System.out.println(txtUsername.getText());
						System.out.println(txtPassword.getPassword());
						System.out.println("user".toCharArray());
						System.out.print(txtPassword.getPassword() == "user".toCharArray());

						if( (txtUsername.getText() == "user") && (txtPassword.getPassword() == "user".toCharArray()) ) {
							setVisible(false);
							new Main();							
						}
						else {
							JPanel pane = new JPanel();
							JOptionPane.showMessageDialog(pane, "Credentials invalid!", "Oops.",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				
				btnLogin.setForeground(Color.DARK_GRAY);
				btnLogin.setBackground(new Color(255, 215, 0));
				
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ejaay\\eclipse-workspace\\AccountingSystem\\src\\img\\wallp.png"));
				lblNewLabel.setBounds(0, 0, 348, 476);
				contentPane.add(lblNewLabel);
				
				JLabel lblWelcomeBack = new JLabel("WELCOME BACK!");
				lblWelcomeBack.setHorizontalAlignment(SwingConstants.CENTER);
				lblWelcomeBack.setForeground(Color.WHITE);
				lblWelcomeBack.setBounds(419, 46, 251, 44);
				contentPane.add(lblWelcomeBack);
				lblWelcomeBack.setFont(new Font("Montserrat", Font.BOLD, 25));

	}
}
