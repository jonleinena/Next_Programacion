package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utilidades.Ficheros;
import utilidades.Utilidades;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(273, 87, 92, 26);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(33, 193, 146, 26);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(33, 250, 106, 26);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(215, 190, 186, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(215, 247, 186, 32);
		contentPane.add(passwordField);
		
		JButton btnIniciarSesin = new JButton("Iniciar sesi\u00F3n");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HashMap<String, String> users = Ficheros.leerUsuarios();
				if(Utilidades.comprobarLogin(users, textField.getText(), passwordField.getText())) {
					JOptionPane.showMessageDialog(contentPane, "login Correcto");
				} else {
					JOptionPane.showMessageDialog(contentPane, "login incorrecto");
				}
				
				
				
			}
		});
		btnIniciarSesin.setBounds(224, 343, 197, 35);
		contentPane.add(btnIniciarSesin);
		
		
		
		
		
		
	}
	
	
}
