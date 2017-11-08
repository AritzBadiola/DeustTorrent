package es.deusto.ssdd.bittorrent.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import es.deusto.ssdd.bittorrent.vista.InformacionSwarms;
import es.deusto.ssdd.bittorrent.vista.InformacionInicial;
import es.deusto.ssdd.bittorrent.vista.InformacionInstancias;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class MainFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 926, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelInformacionInicial = new InformacionInicial();
		tabbedPane.addTab("Inicial", null, panelInformacionInicial, null);
		
		JPanel panelInformacionInstancias = new InformacionInstancias();
		tabbedPane.addTab("Instancias", null, panelInformacionInstancias, null);
		
		JPanel panelInformacionSwarms = new InformacionSwarms();
		tabbedPane.addTab("Swarms", null, panelInformacionSwarms, null);
	}
}
