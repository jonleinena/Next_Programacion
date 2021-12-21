package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Usuario;
import utilidades.Ficheros;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<Usuario> users;
	private JList<Usuario> list;
	private DefaultListModel<Usuario> model1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana frame = new ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.setBounds(360, 44, 163, 32);
		contentPane.add(comboBox);
		
		list = new JList();
		list.setBounds(61, 102, 179, 213);
		contentPane.add(list);
		
		String[] opciones = {"M", "L", "XL"};
		comboBox.setModel(new DefaultComboBoxModel(opciones));
		
		
		this.cargarJList();
		
		textField = new JTextField();
		textField.setBounds(309, 130, 186, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnAnyadir = new JButton("Anyadir");
		btnAnyadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				VentanaAnyadir va = new VentanaAnyadir(ventana.this);
				va.setVisible(true);
				ventana.this.setVisible(false);
				
			}
		});
		btnAnyadir.setBounds(312, 233, 141, 35);
		contentPane.add(btnAnyadir);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Usuario u = (Usuario) list.getSelectedValue();
				System.out.println(u);
				users.remove(u); //borrar del arrayList
				Ficheros.escribirNuevoUsuario(users); //como lo he quitado del ArrayList, escribe el fichero SIN el que he borrado
				model1.remove(list.getSelectedIndex()); //borrando de la ventana
				//tengo que borrarlo del fichero
				//cargarJList();
			}
		});
		btnEliminar.setBounds(312, 292, 141, 35);
		contentPane.add(btnEliminar);
		
		JButton btnImprimir = new JButton("imprimir");
		btnImprimir.addActionListener(e-> {
			Usuario u = (Usuario) list.getSelectedValue();
			System.out.println(u.getDni() + " " + u.getNombre() + " " + u.getEdad());
			
		});
		btnImprimir.setBounds(312, 348, 141, 35);
		contentPane.add(btnImprimir);
		
		
		
		
		
	}

	public ArrayList<Usuario> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<Usuario> users) {
		this.users = users;
	}
	
	public void cargarJList() {
		this.users = Ficheros.leerTodosUsuarios(); 
		
		this.model1 = new DefaultListModel<Usuario>();
		for (Usuario usuario : users) {
			model1.addElement(usuario);
		}
		list.setModel(model1);
		
		
	}
	

}
