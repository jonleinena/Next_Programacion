package examen.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import examen.clases.Asignatura;
import examen.utilidades.Utilidades;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CrearAsignatura extends JFrame {
	private JPanel contentPane;
	private JTextField txtAsignatura;
	private JFrame padre;


	public CrearAsignatura(JFrame padre) {
		this.padre = padre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setBounds(56, 50, 88, 16);
		contentPane.add(lblAsignatura);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(56, 78, 335, 26);
		contentPane.add(txtAsignatura);
		txtAsignatura.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Asignatura a = new Asignatura(txtAsignatura.getText());
				ArrayList<Asignatura> asignaturas = ((VentanaListadoAsignaturas)padre).getDatos();
				asignaturas.add(a);
				((VentanaListadoAsignaturas)padre).setDatos(asignaturas);
				Utilidades.guardarFicheroAsignaturas(asignaturas);
				//padre.cargarJList();
			}
		});
		
		btnAceptar.setBounds(67, 176, 117, 29);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				padre.setVisible(true);
				CrearAsignatura.this.setVisible(false);
				CrearAsignatura.this.dispose();
			}
		});
		
		btnCancelar.setBounds(245, 176, 117, 29);
		contentPane.add(btnCancelar);

	}
}
