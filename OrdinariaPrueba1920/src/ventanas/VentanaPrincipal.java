package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton verEmpleados = new JButton("Ver empleados");
		verEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoEmpleados le = new ListadoEmpleados(VentanaPrincipal.this);
				le.setVisible(true);
				VentanaPrincipal.this.setVisible(false);
			}
		});
		verEmpleados.setBounds(21, 162, 172, 45);
		contentPane.add(verEmpleados);
		
		JButton verMaquinas = new JButton("Ver maquinas");
		verMaquinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoMaquinas lm = new ListadoMaquinas(VentanaPrincipal.this);
				lm.setVisible(true);
				VentanaPrincipal.this.setVisible(false);
			}
		});
		verMaquinas.setBounds(267, 162, 161, 45);
		contentPane.add(verMaquinas);
	}
}
