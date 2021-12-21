package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Usuario;
import utilidades.Ficheros;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaAnyadir extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	private ventana padre;
	

	/**
	 * Create the frame.
	 */
	public VentanaAnyadir(ventana padre) {
		
		
		this.padre = padre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(40, 157, 92, 26);
		contentPane.add(lblNombre);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(40, 211, 92, 26);
		contentPane.add(lblDni);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(40, 260, 92, 26);
		contentPane.add(lblEdad);
		
		textField = new JTextField();
		textField.setBounds(210, 154, 186, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 208, 186, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(210, 257, 186, 32);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		
		ArrayList<Usuario> u = padre.getUsers();
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				u.add(new Usuario(textField.getText(), textField_1.getText(), Integer.parseInt(textField_2.getText())));
				Ficheros.escribirNuevoUsuario(u);
				
				
				padre.cargarJList();
				padre.setVisible(true);
				//ventana v = new ventana();
				//v.setVisible(true);
				VentanaAnyadir.this.setVisible(false); //oculto la ventana
				VentanaAnyadir.this.dispose(); // para borrar la ventana y liberar memoria
			}
		});
		btnGuardar.setBounds(148, 310, 141, 35);
		contentPane.add(btnGuardar);
	}

}
