package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import clases.Empleado;
import clases.Maquina;
import utilidades.Utilidades;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoEmpleados extends JFrame {

	private JPanel contentPane;
	private JList lista;
	private ArrayList<Empleado> empleados;
	private DefaultListModel<Empleado> model;
	

	
	/**
	 * Create the frame.
	 */
	public ListadoEmpleados(VentanaPrincipal padre) {
		
		//Inicializamos las variables en el constructor
		this.empleados = Utilidades.leerEmpleados();
		this.model = new DefaultListModel<Empleado>();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListadoEmpleados = new JLabel("Listado Empleados");
		lblListadoEmpleados.setBounds(76, 22, 98, 14);
		contentPane.add(lblListadoEmpleados);
		
		//La lista de la clase debe ser la misma que la que añadimos al frame
		lista = new JList();
		lista.setBounds(41, 63, 166, 237);
		contentPane.add(lista);
		cargarJList();
		
		JButton btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Maquina[] maquinas = ((Empleado)lista.getSelectedValue()).getMaquinas();
				String s = ""+maquinas[0];
				if(maquinas[1] != null) {
					s += " ; " +maquinas[1];
				}
				JOptionPane.showMessageDialog(ListadoEmpleados.this, "Máquinas: "+s);
			}
		});
		btnVer.setBounds(332, 76, 89, 23);
		contentPane.add(btnVer);
		
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarMaquina mod = new ModificarMaquina(ListadoEmpleados.this, (Empleado)lista.getSelectedValue());
				mod.setVisible(true);
				ListadoEmpleados.this.setVisible(false);
			}
		});
		btnModificar.setBounds(332, 141, 89, 23);
		contentPane.add(btnModificar);
		
		
		lista.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
				if(((Empleado)lista.getSelectedValue()).getMaquinas()[0]== null){
					
				btnVer.setEnabled(false);
				} else {
					btnVer.setEnabled(true);
				}
				
				
			}
		});
	}
	
	public void cargarJList() {
		
		for (Empleado empleado : empleados) {
			model.addElement(empleado);
		}
		lista.setModel(model);
		
	}
	
	
	
}
