package examen.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import examen.clases.Alumno;
import examen.utilidades.Utilidades;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

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

	
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 145);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnListarAlumnos = new JButton("Listar Alumnos");
		btnListarAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaListadoAlumnos vl = new VentanaListadoAlumnos();
				vl.setVisible(true);
				VentanaPrincipal.this.setVisible(false);
			}
		});
		
		btnListarAlumnos.setBounds(60, 35, 138, 29);
		contentPane.add(btnListarAlumnos);
		
		JButton btnListarAsignaturas = new JButton("Listar Asignaturas");
		btnListarAsignaturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaListadoAsignaturas vl = new VentanaListadoAsignaturas();
				vl.setVisible(true);
				VentanaPrincipal.this.setVisible(false);
			}
		});
		
		btnListarAsignaturas.setBounds(244, 35, 153, 29);
		contentPane.add(btnListarAsignaturas);
	}
}
