package examen.ventanas;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import examen.clases.Alumno;
import examen.clases.Asignatura;
import examen.utilidades.Utilidades;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;

public class VentanaListadoAlumnos extends JFrame {
	private JPanel contentPane;
	private JList<Object> list;
	private JButton btnVerAsignaturas;
	private JButton btnAadirAsignatura;
	private JButton btnEliminarAsignatura;

	public VentanaListadoAlumnos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setBounds(100, 100, 511, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 24, 134, 229);
		contentPane.add(scrollPane);

		list = new JList<Object>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// A�ade el m�todo necesario para habilitar los botones cuando haya un
		// alumno seleccionado en el JList

		cargarLista(list);
		scrollPane.setViewportView(list);

		btnVerAsignaturas = new JButton("Ver Asignaturas");

		btnVerAsignaturas.setBounds(248, 21, 162, 29);
		contentPane.add(btnVerAsignaturas);

		btnAadirAsignatura = new JButton("A�adir Asignatura");
		btnAadirAsignatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AnadirAsignatura aa = new AnadirAsignatura(VentanaListadoAlumnos.this,
						(Alumno) list.getSelectedValue());
				aa.setVisible(true);
				VentanaListadoAlumnos.this.setVisible(false);
			}
		});

		btnAadirAsignatura.setBounds(248, 58, 162, 29);
		contentPane.add(btnAadirAsignatura);

		btnEliminarAsignatura = new JButton("Eliminar Asignatura");
		btnEliminarAsignatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarAsignatura aa = new EliminarAsignatura(VentanaListadoAlumnos.this,
						(Alumno) list.getSelectedValue());
				aa.setVisible(true);
				VentanaListadoAlumnos.this.setVisible(false);
			}
		});

		btnEliminarAsignatura.setBounds(248, 99, 162, 29);
		contentPane.add(btnEliminarAsignatura);

		JButton btnVolver = new JButton("Volver");

		btnVolver.setBounds(248, 181, 162, 29);
		contentPane.add(btnVolver);

		btnAadirAsignatura.setEnabled(false);
		btnEliminarAsignatura.setEnabled(false);
		btnVerAsignaturas.setEnabled(false);

		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				btnAadirAsignatura.setEnabled(true);
				btnEliminarAsignatura.setEnabled(true);
				btnVerAsignaturas.setEnabled(true);

			}
		});

	}

	/**
	 * M�todo que cargar� en el JList todos los estudiantes que hay en el
	 * fichero estudiantes.txt
	 */
	public void cargarLista(JList<Object> lista) {
		// Escribe aqu� tu c�digo
		DefaultListModel model = new DefaultListModel<>();
		ArrayList<Alumno> alumnos = Utilidades.leerAlumno("estudiantes.txt");
		for (Alumno alumno : alumnos) {
			model.addElement(alumno);
		}
		lista.setModel(model);

	}
}
