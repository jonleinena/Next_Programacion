package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Maquina;
import utilidades.Utilidades;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ListadoMaquinas extends JFrame {

	private JPanel contentPane;
	private JList list;
	private DefaultListModel<Maquina> model;
	private ArrayList<Maquina> maquinas;
	

	/**
	 * Create the frame.
	 * @param padre 
	 */
	public ListadoMaquinas(VentanaPrincipal padre) {
		
		
		//Inicializamos las variables
		maquinas = Utilidades.leerMaquinas("maquinas.txt");
		model = new DefaultListModel<Maquina>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMquinas = new JLabel("M\u00E1quinas");
		lblMquinas.setBounds(75, 29, 65, 14);
		contentPane.add(lblMquinas);
		
		list = new JList();
		list.setBounds(43, 74, 136, 176);
		contentPane.add(list);
		cargarJList();
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maquinas.remove((Maquina)list.getSelectedValue());
				model.remove(list.getSelectedIndex());
				Utilidades.guardarMaquinas(maquinas);
			}
		});
		btnEliminar.setBounds(262, 90, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				padre.setVisible(true);
				ListadoMaquinas.this.setVisible(false);
				ListadoMaquinas.this.dispose();
			}
		});
		btnAtrs.setBounds(262, 169, 89, 23);
		contentPane.add(btnAtrs);
	}
	
	public void cargarJList() {
		for (Maquina maquina : maquinas) {
			model.addElement(maquina);
		}
		list.setModel(model);
	}

}
