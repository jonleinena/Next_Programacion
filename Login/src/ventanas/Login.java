package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Ficheros;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

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
					Login frame = new Login();
					frame.setVisible(true);
					//Ficheros.leerFichero()
				
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(161, 110, 186, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(21, 110, 92, 29);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(21, 160, 136, 26);
		contentPane.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(161, 157, 186, 32);
		contentPane.add(passwordField);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(161, 33, 92, 26);
		contentPane.add(lblLogin);
		
		JButton btnIniciarSesin = new JButton("Iniciar sesi\u00F3n");
		
		
		
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuario = textField.getText();
				String contrasenya = passwordField.getText();
				
				HashMap<String, String> mapUsuarios = Ficheros.leerUsuarios();
				
				if(mapUsuarios.containsKey(usuario)) {
					if(mapUsuarios.get(usuario).equals(contrasenya)) {
						JOptionPane.showMessageDialog(contentPane, "Inicio de sesión correcto");
					}else {
						JOptionPane.showMessageDialog(contentPane, "Contraseña incorrecta");
					}
				}else {
					System.out.println("El usuario no existe");
				}
				
				
				
				
				
			}
		});
		btnIniciarSesin.setBounds(163, 238, 184, 35);
		contentPane.add(btnIniciarSesin);
	}
}
