package clustering_humano;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class AplicacionView extends JFrame {

	private JPanel contentPane;
	private JTextField input_nombre;
	private JTextField input_interes_musical;
	private JTextField input_interes_cientifico;
	private JTextField input_interes_espectaculo;
	private JTextField input_interes_deportivo;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 513);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 45, 656, 226);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_nombre = new JLabel("Nombre");
		label_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		label_nombre.setFont(new Font("Tahoma", Font.ITALIC, 14));
		label_nombre.setBounds(33, 86, 241, 14);
		panel.add(label_nombre);
		
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
		
		JLabel lblIntersDeInteres = new JLabel("Interés por la música");
		lblIntersDeInteres.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntersDeInteres.setLabelFor(input_interes_musical);
		lblIntersDeInteres.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblIntersDeInteres.setBounds(33, 135, 241, 14);
		panel.add(lblIntersDeInteres);
		
		input_nombre = new JTextField();
		label_nombre.setLabelFor(input_nombre);
		input_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		input_nombre.setBounds(284, 85, 187, 20);
		panel.add(input_nombre);
		input_nombre.setColumns(10);
		
		JLabel label_interes_espectaculo = new JLabel("Interés por las noticias del espectáculo");
		label_interes_espectaculo.setHorizontalAlignment(SwingConstants.CENTER);
		label_interes_espectaculo.setLabelFor(input_interes_espectaculo);
		label_interes_espectaculo.setFont(new Font("Tahoma", Font.ITALIC, 14));
		label_interes_espectaculo.setBounds(33, 160, 241, 14);
		panel.add(label_interes_espectaculo);
		
		JLabel lblIntersDeInteres_1 = new JLabel("Interés por los deportes");
		lblIntersDeInteres_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntersDeInteres_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblIntersDeInteres_1.setBounds(33, 111, 241, 14);
		panel.add(lblIntersDeInteres_1);
		
		JLabel lblIntersPorLa = new JLabel("Interés por la ciencia");
		lblIntersPorLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntersPorLa.setLabelFor(input_interes_cientifico);
		lblIntersPorLa.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblIntersPorLa.setBounds(33, 185, 241, 14);
		panel.add(lblIntersPorLa);
		
		input_interes_deportivo = new JTextField();
		lblIntersDeInteres_1.setLabelFor(input_interes_deportivo);
		input_interes_deportivo.setHorizontalAlignment(SwingConstants.CENTER);
		input_interes_deportivo.setBounds(284, 110, 187, 20);
		panel.add(input_interes_deportivo);
		input_interes_deportivo.setColumns(10);
		
		JLabel lbl_agregar_persona = new JLabel("Agregar persona");
		lbl_agregar_persona.setBounds(257, 23, 150, 22);
		panel.add(lbl_agregar_persona);
		lbl_agregar_persona.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_agregar_persona.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btn_agregar_persona = new JButton("Agregar persona");
		btn_agregar_persona.setBackground(new Color(0, 255, 64));
		btn_agregar_persona.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_agregar_persona.setBounds(481, 116, 165, 52);
		panel.add(btn_agregar_persona);
		
		JButton btn_ejecutar_algoritmo = new JButton("Ejecutar algorítmo");
		btn_ejecutar_algoritmo.setBounds(503, 183, 121, 23);
		panel.add(btn_ejecutar_algoritmo);
		
		JLabel lbl_titulo_app = new JLabel("Clustering humano");
		lbl_titulo_app.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lbl_titulo_app.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo_app.setBounds(184, 11, 280, 23);
		contentPane.add(lbl_titulo_app);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(0, 269, 656, 205);
		contentPane.add(panel_1);
	}
}
