package clustering_humano;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorEvent;
import javax.swing.AbstractListModel;
import java.awt.CardLayout;

public class AplicacionView extends JFrame {

	private JPanel contentPane;
	private JTextField input_nombre;
	private JTextField input_interes_musical;
	private JTextField input_interes_cientifico;
	private JTextField input_interes_espectaculo;
	private JTextField input_interes_deportivo;
	private Aplicacion app;
	private JPanel panelPersonas_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacionView frame = new AplicacionView();
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
	public AplicacionView() {
		this.app = new Aplicacion();
		initialize();
	}

	private void initialize() {
		iniciarFrame();
		
		JPanel panelAggPersona = iniciarPanelAggPersona();
		
		agregarPanelPersonas();
		agregarLabels(panelAggPersona);
		agregarInputs(panelAggPersona);
		agregarBotones(panelAggPersona);
		
	}

	private void agregarPanelPersonas() {
		panelPersonas_1 = new JPanel();
		panelPersonas_1.setBackground(new Color(128, 128, 128));
		panelPersonas_1.setBounds(0, 269, 656, 205);
		contentPane.add(panelPersonas_1);
	}

	
	//Metodos de conveniencia
	private JPanel iniciarPanelAggPersona() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 45, 656, 226);
		contentPane.add(panel);
		panel.setLayout(null);
		return panel;
	}

	private void agregarLabels(JPanel panel) {
		JLabel label_nombre = new JLabel("Nombre");
		label_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		label_nombre.setFont(new Font("Tahoma", Font.ITALIC, 14));
		label_nombre.setBounds(33, 86, 241, 14);
		panel.add(label_nombre);
		
		JLabel label_musica = new JLabel("Interés por la música");
		label_musica.setHorizontalAlignment(SwingConstants.CENTER);
		label_musica.setLabelFor(input_interes_musical);
		label_musica.setFont(new Font("Tahoma", Font.ITALIC, 14));
		label_musica.setBounds(33, 135, 241, 14);
		panel.add(label_musica);
		
		JLabel label_espectaculo = new JLabel("Interés por las noticias del espectáculo");
		label_espectaculo.setHorizontalAlignment(SwingConstants.CENTER);
		label_espectaculo.setLabelFor(input_interes_espectaculo);
		label_espectaculo.setFont(new Font("Tahoma", Font.ITALIC, 14));
		label_espectaculo.setBounds(33, 160, 241, 14);
		panel.add(label_espectaculo);
		
		JLabel label_deportes = new JLabel("Interés por los deportes");
		label_deportes.setHorizontalAlignment(SwingConstants.CENTER);
		label_deportes.setFont(new Font("Tahoma", Font.ITALIC, 14));
		label_deportes.setBounds(33, 111, 241, 14);
		panel.add(label_deportes);
		
		JLabel label_ciencia = new JLabel("Interés por la ciencia");
		label_ciencia.setHorizontalAlignment(SwingConstants.CENTER);
		label_ciencia.setLabelFor(input_interes_cientifico);
		label_ciencia.setFont(new Font("Tahoma", Font.ITALIC, 14));
		label_ciencia.setBounds(33, 185, 241, 14);
		panel.add(label_ciencia);
		
		JLabel lbl_agregar_persona = new JLabel("Agregar persona");
		lbl_agregar_persona.setBounds(257, 23, 150, 22);
		panel.add(lbl_agregar_persona);
		lbl_agregar_persona.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_agregar_persona.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbl_titulo_app = new JLabel("Clustering humano");
		lbl_titulo_app.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lbl_titulo_app.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo_app.setBounds(184, 11, 280, 23);
		contentPane.add(lbl_titulo_app);
	}

	private void agregarInputs(JPanel panel) {
		input_interes_musical = new JTextField();
		input_interes_musical.setHorizontalAlignment(SwingConstants.CENTER);
		input_interes_musical.setBounds(284, 134, 187, 20);
		panel.add(input_interes_musical);
		input_interes_musical.setColumns(10);
		
		input_interes_espectaculo = new JTextField();
		input_interes_espectaculo.setHorizontalAlignment(SwingConstants.CENTER);
		input_interes_espectaculo.setBounds(284, 159, 187, 20);
		panel.add(input_interes_espectaculo);
		input_interes_espectaculo.setColumns(10);
		
		input_interes_cientifico = new JTextField();
		input_interes_cientifico.setHorizontalAlignment(SwingConstants.CENTER);
		input_interes_cientifico.setBounds(284, 184, 187, 20);
		panel.add(input_interes_cientifico);
		input_interes_cientifico.setColumns(10);
		
		input_nombre = new JTextField();
		input_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		input_nombre.setBounds(284, 85, 187, 20);
		panel.add(input_nombre);
		input_nombre.setColumns(10);
		
		input_interes_deportivo = new JTextField();
		input_interes_deportivo.setHorizontalAlignment(SwingConstants.CENTER);
		input_interes_deportivo.setBounds(284, 110, 187, 20);
		panel.add(input_interes_deportivo);
		input_interes_deportivo.setColumns(10);
	}

	private void agregarBotones(JPanel panel) {
		JButton btn_agregar_persona = new JButton("Agregar persona");
		btn_agregar_persona.setBackground(new Color(0, 255, 64));
		btn_agregar_persona.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_agregar_persona.setBounds(481, 116, 165, 52);
		panel.add(btn_agregar_persona);
		
		JButton btn_ejecutar_algoritmo = new JButton("Ejecutar algorítmo");
		btn_ejecutar_algoritmo.setBounds(503, 183, 121, 23);
		panel.add(btn_ejecutar_algoritmo);
		
		agregarListeners(btn_agregar_persona, btn_ejecutar_algoritmo);
	}

	private void agregarListeners(JButton btn_agregar_persona, JButton btn_ejecutar_algoritmo) {
		btn_agregar_persona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputNombre = input_nombre.getText();
				Integer inputDeportes = Integer.parseInt(input_interes_deportivo.getText());
				Integer inputMusica = Integer.parseInt(input_interes_musical.getText());
				Integer inputEspectaculos = Integer.parseInt(input_interes_espectaculo.getText());
				Integer inputCiencia = Integer.parseInt(input_interes_cientifico.getText());
				app.agregarPersona(inputNombre, inputDeportes, inputMusica, inputEspectaculos, inputCiencia);
				
			}
		});
		
		btn_ejecutar_algoritmo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					app.armarGrupoPersonas();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
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
