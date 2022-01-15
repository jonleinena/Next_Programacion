package examen.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import examen.clases.Alumno;
import examen.clases.Asignatura;
import examen.utilidades.Utilidades;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminarAsignatura extends JFrame {

	private JPanel contentPane;
	private JComboBox comboAsignaturas;
	private JFrame padre;
	private Alumno alumno;
	
	/**
	 * Create the frame.
	 */
	public EliminarAsignatura(JFrame padre, Alumno alumno) {
		this.padre=padre;
		this.alumno=alumno;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAadirAsignatura = new JLabel("Eliminar Asignatura");
		lblAadirAsignatura.setBounds(54, 87, 113, 16);
		contentPane.add(lblAadirAsignatura);
		
		comboAsignaturas = new JComboBox();
		
		comboAsignaturas.setBounds(179, 83, 227, 27);
		contentPane.add(comboAsignaturas);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alumno.eliminarAsignatura(comboAsignaturas.getSelectedIndex());
				Utilidades.guardarFicheroAlumno(alumno);
			}
		});
		
		btnAceptar.setBounds(67, 176, 117, 29);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				padre.setVisible(true);
				EliminarAsignatura.this.setVisible(false);
				EliminarAsignatura.this.dispose();
			}
		});
		
		btnCancelar.setBounds(245, 176, 117, 29);
		contentPane.add(btnCancelar);
		cargarAsignaturas();
		
	}
	/**
	 * M�todo que carga en el combobox las asignaturas que tiene asignadas ese alumno.
	 */
	public void cargarAsignaturas() {
		//Escribe aqu� tu c�digo
		DefaultComboBoxModel<Asignatura> model = new DefaultComboBoxModel<Asignatura>();
		ArrayList<Asignatura> asignaturas = Utilidades.leerAsignatura(alumno.getNombre()+".txt");
		for (Asignatura asignatura : asignaturas) {
			model.addElement(asignatura);
		}
		comboAsignaturas.setModel(model);
	}
}
