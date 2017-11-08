package es.deusto.ssdd.bittorrent.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class InformacionInstancias extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7522511921182685756L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public InformacionInstancias() {
		setBackground(Color.DARK_GRAY);
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblTrackerInstances = new JLabel("Active trackers");
		lblTrackerInstances.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTrackerInstances.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackerInstances.setForeground(Color.WHITE);
		lblTrackerInstances.setFont(new Font("Nimbus Sans", Font.BOLD, 23));
		add(lblTrackerInstances, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setShowGrid(false);
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"10000", "Myself", "10:00:30"},
				{"10001", "10000", "10:00:31"},
			},
			new String[] {
				"Tracker ID", "Master ID", "Last keepalive"
			}
		));
		table.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.WHITE);
		table.setOpaque(true);
		
		scrollPane.setOpaque(true);
		scrollPane.getViewport().setBackground(Color.DARK_GRAY);

	}
	
}
