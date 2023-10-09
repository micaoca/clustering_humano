package clustering_humano;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;

public class SolucionClusteringView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private Aplicacion app;
	DefaultTableModel modeloTabla1 = new DefaultTableModel();
	DefaultTableModel modeloTabla2 = new DefaultTableModel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolucionClusteringView frame = new SolucionClusteringView();
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
	public SolucionClusteringView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setBounds(82, 74, 218, 232);
		contentPane.add(scrollpane);
		
		table = new JTable();
		scrollpane.setViewportView(table);
		
		modeloTabla1.setColumnIdentifiers(new Object[]{
				"Grupo 1" 
		});	
		
		table.setModel(modeloTabla1);
		
		JScrollPane scrollpane2= new JScrollPane();
		scrollpane2.setBounds(363, 74, 218, 232);
		contentPane.add(scrollpane2);
		
		table_1 = new JTable();
		scrollpane2.setViewportView(table_1);
		
		modeloTabla2.setColumnIdentifiers(new Object[]{
				"Grupo 2"
		});	
		
		table_1.setModel(modeloTabla2);
		
		
		JLabel lblNewLabel = new JLabel("Solución Clustering Humano");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(168, 11, 315, 46);
		contentPane.add(lblNewLabel);
	}
	
	public void agregarPersonas(String[] nombres1,String[] nombres2) {
		
		for (String cadena : nombres1) {
		    modeloTabla1.addRow(new Object[]{cadena});
		}
		
		for (String cadena : nombres2) {
		    modeloTabla2.addRow(new Object[]{cadena});
		}
		
		
	}

	
	
}
