package es.deusto.ssdd.bittorrent.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

public class InformacionSwarms extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5308013985137539282L;
	private JTable tableSwarms;
	private JTable tablePeers;

	/**
	 * Create the panel.
	 */
	public InformacionSwarms() {
		setBackground(Color.DARK_GRAY);
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblSwarmsInformation = new JLabel("Swarms information");
		lblSwarmsInformation.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSwarmsInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblSwarmsInformation.setForeground(Color.WHITE);
		lblSwarmsInformation.setFont(new Font("Nimbus Sans", Font.BOLD, 23));
		add(lblSwarmsInformation, BorderLayout.NORTH);
		
		JScrollPane swarmScrollPane = new JScrollPane();
		add(swarmScrollPane, BorderLayout.WEST);
		
		tableSwarms = new JTable();
		tableSwarms.setShowVerticalLines(false);
		tableSwarms.setShowHorizontalLines(false);
		tableSwarms.setShowGrid(false);
		tableSwarms.setRowSelectionAllowed(false);
		tableSwarms.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Content name", "Size", "#Seeders", "#Leechers"
			}
		));
		tableSwarms.setBackground(Color.DARK_GRAY);
		tableSwarms.setForeground(Color.WHITE);
		swarmScrollPane.setViewportView(tableSwarms);
		
		JScrollPane peersScrollPane = new JScrollPane();
		add(peersScrollPane, BorderLayout.CENTER);
		
		tablePeers = new JTable();
		tablePeers.setBackground(Color.LIGHT_GRAY);
		tablePeers.setForeground(Color.BLACK);
		tablePeers.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Peer ID", "Peer IP", "Peer port", "Download"
			}
		));
		tablePeers.setRowSelectionAllowed(false);
		tablePeers.setShowGrid(false);
		tablePeers.setShowVerticalLines(false);
		tablePeers.setShowHorizontalLines(false);
		peersScrollPane.setViewportView(tablePeers);

	}

}
