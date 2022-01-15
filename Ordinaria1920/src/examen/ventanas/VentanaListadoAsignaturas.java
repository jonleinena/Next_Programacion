package examen.ventanas;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import examen.clases.Asignatura;
import examen.utilidades.Utilidades;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class VentanaListadoAsignaturas extends JFrame {
	private JPanel contentPane;
	private JList list;
	private ArrayList<Asignatura> datos;

	public VentanaListadoAsignaturas() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				cargarAsignaturas(list);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100,617,395 );
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 24, 133, 151);
		contentPane.add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnNuevaAsignatura = new JButton("Nueva Asignatura");
		btnNuevaAsignatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearAsignatura ca = new CrearAsignatura(VentanaListadoAsignaturas.this);
				ca.setVisible(true);
				VentanaListadoAsignaturas.this.setVisible(false);
			}
		});
		
		btnNuevaAsignatura.setBounds(248, 21, 162, 29);
		contentPane.add(btnNuevaAsignatura);
		
		JButton btnVolver = new JButton("Volver");
		
		btnVolver.setBounds(248, 146, 162, 29);
		contentPane.add(btnVolver);
	}
	
	/**
	 * M�todo que carga todas las asignaturas que disponemos en el fichero asignaturas.txt
	 */
	public void cargarAsignaturas(JList list) {
		//Escribe aqu� tu c�digo
		DefaultListModel<Asignatura> model = new DefaultListModel<Asignatura>();
		datos = Utilidades.leerAsignatura("asignaturas.txt");
		for (Asignatura asignatura : datos) {
			model.addElement(asignatura);
		}
		list.setModel(model);
		
	}
	public ArrayList<Asignatura> getDatos() {
		return datos;
	}
	public void setDatos(ArrayList<Asignatura> datos) {
		this.datos = datos;
	}
}
