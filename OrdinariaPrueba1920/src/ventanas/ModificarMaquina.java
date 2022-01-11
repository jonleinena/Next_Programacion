package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Empleado;
import clases.Maquina;
import utilidades.Utilidades;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ModificarMaquina extends JFrame {

	private JPanel contentPane;
	private JComboBox<Maquina> comboBox1, comboBox2;
	private Empleado empleado;
	private ArrayList<Maquina> maquinas;
	private DefaultComboBoxModel<Maquina> model1, model2;
	

	/**
	 * Create the frame.
	 */
	public ModificarMaquina(ListadoEmpleados padre, Empleado e) {
		
		this.empleado = e;
		//maquinas = Utilidades.leerMaquinas(empleado.getNombre()+ ".txt"); //asi lee las maquinas que tiene asignadas el empleado
		maquinas = Utilidades.leerMaquinas("maquinas.txt"); //Estaríamos leyendo todas las maquinas que hay
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmpleado = new JLabel("Empleado: ");
		lblEmpleado.setBounds(35, 33, 69, 14);
		contentPane.add(lblEmpleado);
		
		JLabel lblNombre = new JLabel(e.getNombre());
		lblNombre.setBounds(186, 33, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblMaq1 = new JLabel("M\u00E1quina 1");
		lblMaq1.setBounds(36, 105, 68, 14);
		contentPane.add(lblMaq1);
		
		JLabel lblMaq2 = new JLabel("M\u00E1quina 2");
		lblMaq2.setBounds(35, 146, 69, 14);
		contentPane.add(lblMaq2);
		
		comboBox1 = new JComboBox();
		comboBox1.setBounds(186, 102, 77, 20);
		contentPane.add(comboBox1);
		
		comboBox2 = new JComboBox();
		comboBox2.setBounds(186, 143, 77, 20);
		contentPane.add(comboBox2);
		
		cargarComboBox();
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Maquina[] nuevasMaquinas = new Maquina[2];
				nuevasMaquinas[0] = (Maquina)comboBox1.getSelectedItem();
				nuevasMaquinas[1] = (Maquina)comboBox2.getSelectedItem();
				empleado.setMaquinas(nuevasMaquinas);
				Utilidades.guardarEmpleados(empleado);
				
			}
		});
		btnGuardar.setBounds(78, 210, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				padre.setVisible(true);
				ModificarMaquina.this.setVisible(false);
				ModificarMaquina.this.dispose();
				
			}
		});
		btnCancelar.setBounds(235, 210, 89, 23);
		contentPane.add(btnCancelar);
	}
	
	public void cargarComboBox() {
		model1 = new DefaultComboBoxModel<Maquina>();
		model2 = new DefaultComboBoxModel<Maquina>();
		for (Maquina maquina : maquinas) {
			model1.addElement(maquina);
			model2.addElement(maquina);
		}
		comboBox1.setModel(model1);
		comboBox2.setModel(model2);	
		
	}
}
