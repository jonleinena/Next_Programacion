package examen.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;

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

public class AnadirAsignatura extends JFrame {

	private JPanel contentPane;
	private JComboBox comboAsignaturas;
	private JFrame padre;
	private Alumno alumno;
	
	/**
	 * Create the frame.
	 */
	public AnadirAsignatura(JFrame padre, Alumno alumno) {
		this.padre=padre;
		this.alumno=alumno;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAadirAsignatura = new JLabel("A�adir Asignatura");
		lblAadirAsignatura.setBounds(54, 87, 113, 16);
		contentPane.add(lblAadirAsignatura);
		
		comboAsignaturas = new JComboBox();
		ArrayList<Asignatura> asignaturasList = Utilidades.leerAsignatura("asignaturas.txt");
		comboAsignaturas.setBounds(179, 83, 227, 27);
		
		contentPane.add(comboAsignaturas);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alumno.anyadirAsig(new Asignatura(comboAsignaturas.getSelectedItem()+""));
				Utilidades.guardarFicheroAlumno(alumno);
				
			}
		});
		
		btnAceptar.setBounds(67, 176, 117, 29);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				padre.setVisible(true);
				AnadirAsignatura.this.setVisible(false);
				AnadirAsignatura.this.dispose();
			}
		});
	
		btnCancelar.setBounds(245, 176, 117, 29);
		contentPane.add(btnCancelar);
		cargarAsignaturas();
		
	}
	
	/**
	 * M�todo que cargar� en el combobox las asignaturas posibles a asignar
	 */
	public void cargarAsignaturas() {
		//Escribe aquí tu código
		DefaultComboBoxModel<Asignatura> model = new DefaultComboBoxModel<Asignatura>();
		ArrayList<Asignatura> asignaturas = Utilidades.leerAsignatura("asignaturas.txt");
		for (Asignatura asignatura : asignaturas) {
			model.addElement(asignatura);
		}
		comboAsignaturas.setModel(model);
	}
}
