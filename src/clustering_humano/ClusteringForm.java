package clustering_humano;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.event.AncestorEvent;
import javax.swing.AbstractListModel;
import java.awt.CardLayout;
import java.awt.SystemColor;

public class ClusteringForm extends JFrame {

	private JPanel contentPane;
	private JTextField input_nombre;
	private JTextField input_interes_musical;
	private JTextField input_interes_cientifico;
	private JTextField input_interes_espectaculo;
	private JTextField input_interes_deportivo;
	private AplicacionNegocio app;
	private JTable table;
	DefaultTableModel modeloTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClusteringForm frame = new ClusteringForm();
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
	public ClusteringForm() {
		this.app = new AplicacionNegocio();
		this.setResizable(false);
		initialize();
	}

	private void initialize() {
		iniciarFrame();
		
		JPanel panelAggPersona = iniciarPanelAggPersona();
		
 		agregarLabels(panelAggPersona);
		agregarInputs(panelAggPersona);
		agregarBotones(panelAggPersona);
		
	}
	
	//Metodos de conveniencia
	private JPanel iniciarPanelAggPersona() {
		JPanel panel = crearPanel();
		JLabel lbl_titulo_app = new JLabel("Clustering humano");
		JScrollPane scrollpane = crearScrollPane();
		crearLabelTitulo(lbl_titulo_app);
		modeloTabla = new DefaultTableModel();
		
		panel.add(scrollpane);
		panel.add(lbl_titulo_app);
		
		table = new JTable();
		scrollpane.setViewportView(table);
	
		modeloTabla.setColumnIdentifiers(new Object[]{
				"Nombre", "Interes deporte", "Interes musica", "Interes espectaculos", "Interes ciencia"
		});	
		
		table.setModel(modeloTabla);
		return panel;
	}

	private void crearLabelTitulo(JLabel lbl_titulo_app) {
		lbl_titulo_app.setBounds(20, 24, 280, 23);
		
		lbl_titulo_app.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_titulo_app.setHorizontalAlignment(SwingConstants.LEFT);
	}

	private JScrollPane crearScrollPane() {
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setBounds(20, 279, 612, 173);
		return scrollpane;
	}

	private JPanel crearPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(1, 0, 656, 476);
		contentPane.add(panel);
		panel.setLayout(null);
		return panel;
	}

	private void agregarLabels(JPanel panel) {
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(20, 60, 241, 14);
		panel.add(lblNombre);
		
		JLabel lblIntersPorLa = new JLabel("Interés por la música:");
		lblIntersPorLa.setHorizontalAlignment(SwingConstants.LEFT);
		lblIntersPorLa.setLabelFor(input_interes_musical);
		lblIntersPorLa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIntersPorLa.setBounds(20, 109, 241, 14);
		panel.add(lblIntersPorLa);
		
		JLabel lblIntersPorLas = new JLabel("Interés por las noticias del espectáculo:");
		lblIntersPorLas.setHorizontalAlignment(SwingConstants.LEFT);
		lblIntersPorLas.setLabelFor(input_interes_espectaculo);
		lblIntersPorLas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIntersPorLas.setBounds(20, 134, 241, 14);
		panel.add(lblIntersPorLas);
		
		JLabel lblIntersPorLos = new JLabel("Interés por los deportes:");
		lblIntersPorLos.setHorizontalAlignment(SwingConstants.LEFT);
		lblIntersPorLos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIntersPorLos.setBounds(20, 85, 241, 14);
		panel.add(lblIntersPorLos);
		
		JLabel lblIntersPorLa_1 = new JLabel("Interés por la ciencia:");
		lblIntersPorLa_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblIntersPorLa_1.setLabelFor(input_interes_cientifico);
		lblIntersPorLa_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIntersPorLa_1.setBounds(20, 159, 241, 14);
		panel.add(lblIntersPorLa_1);
	}

	private void agregarInputs(JPanel panel) {
		input_interes_musical = new JTextField();
		input_interes_musical.setHorizontalAlignment(SwingConstants.CENTER);
		input_interes_musical.setBounds(265, 108, 187, 20);
		panel.add(input_interes_musical);
		input_interes_musical.setColumns(10);
		
		input_interes_espectaculo = new JTextField();
		input_interes_espectaculo.setHorizontalAlignment(SwingConstants.CENTER);
		input_interes_espectaculo.setBounds(265, 133, 187, 20);
		panel.add(input_interes_espectaculo);
		input_interes_espectaculo.setColumns(10);
		
		input_interes_cientifico = new JTextField();
		input_interes_cientifico.setHorizontalAlignment(SwingConstants.CENTER);
		input_interes_cientifico.setBounds(265, 158, 187, 20);
		panel.add(input_interes_cientifico);
		input_interes_cientifico.setColumns(10);
		
		input_nombre = new JTextField();
		input_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		input_nombre.setBounds(265, 59, 187, 20);
		panel.add(input_nombre);
		input_nombre.setColumns(10);
		
		input_interes_deportivo = new JTextField();
		input_interes_deportivo.setHorizontalAlignment(SwingConstants.CENTER);
		input_interes_deportivo.setBounds(265, 84, 187, 20);
		panel.add(input_interes_deportivo);
		input_interes_deportivo.setColumns(10);
	}

	private void agregarBotones(JPanel panel) {
		JButton btn_agregar_persona = new JButton("Agregar persona");
		btn_agregar_persona.setBackground(SystemColor.controlHighlight);
		btn_agregar_persona.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_agregar_persona.setBounds(290, 198, 137, 33);
		panel.add(btn_agregar_persona);
		
		JButton btn_ejecutar_algoritmo = new JButton("Ejecutar algorítmo");
		btn_ejecutar_algoritmo.setBackground(SystemColor.controlHighlight);
		btn_ejecutar_algoritmo.setBounds(20, 245, 123, 23);
		panel.add(btn_ejecutar_algoritmo);
		
		agregarListeners(btn_agregar_persona, btn_ejecutar_algoritmo);
	}

	private void agregarListeners(JButton btn_agregar_persona, JButton btn_ejecutar_algoritmo) {
		btn_agregar_persona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputNombre = input_nombre.getText();
				String inputDeportes = input_interes_deportivo.getText();
				String inputMusica = input_interes_musical.getText();
				String inputEspectaculos = input_interes_espectaculo.getText();
				String inputCiencia = input_interes_cientifico.getText();
				try {
					app.agregarPersona(inputNombre, Integer.parseInt(inputDeportes), Integer.parseInt(inputMusica), Integer.parseInt(inputEspectaculos), Integer.parseInt(inputCiencia));
					agregarPanelPersonas(inputNombre, Integer.parseInt(inputDeportes), Integer.parseInt(inputMusica), Integer.parseInt(inputEspectaculos), Integer.parseInt(inputCiencia));   
					limpiarControles();
				} catch(IllegalArgumentException error) {
					JOptionPane.showMessageDialog(null, error.getMessage());
				} catch(Exception error) {
					JOptionPane.showMessageDialog(null, "No se pueden enviar campos vacíos.");
				}	
			}
		});
		
		btn_ejecutar_algoritmo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					app.ejecutar();
	                ResultadoClusteringView solucionClustering = new ResultadoClusteringView();
	                solucionClustering.agregarPersonas(app.nombresGrupo1(), app.nombresGrupo2());
	                solucionClustering.setVisible(true);
	                
				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, error.getMessage());
				}
			}
		});
	}
	
	private void agregarPanelPersonas(String nombre, int d, int m, int e, int c) {
		
		modeloTabla.addRow(new Object[]{
				nombre,d,m,e,c
		});	
		
		
	}
	
	private void limpiarControles() {
		input_nombre.setText("");
		input_interes_deportivo.setText("");
		input_interes_musical.setText("");
		input_interes_espectaculo.setText("");
		input_interes_cientifico.setText("");
		input_nombre.requestFocus();
	}

	private void iniciarFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 513);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
