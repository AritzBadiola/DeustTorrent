package es.deusto.ssdd.bittorrent.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import javax.swing.UIManager;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class InformacionInicial extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6287009337411332425L;
	private JTextField IPField;
	private JTextField IDField;

	/**
	 * Create the panel.
	 */
	public InformacionInicial() {
		setBackground(Color.DARK_GRAY);
		setLayout(new BorderLayout(0, 0));
		
		JLabel panelLabel = new JLabel("Basic information");
		panelLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		panelLabel.setForeground(Color.WHITE);
		panelLabel.setFont(new Font("Nimbus Sans", Font.BOLD, 23));
		panelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(panelLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel, BorderLayout.WEST);
		
		JLabel IPLabel = new JLabel("IP Address:");
		IPLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IPLabel.setForeground(Color.WHITE);
		IPLabel.setFont(new Font("Monospaced", Font.BOLD, 17));
		
		JLabel IDLabel = new JLabel("ID:");
		IDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IDLabel.setForeground(Color.WHITE);
		IDLabel.setFont(new Font("Monospaced", Font.BOLD, 17));
		
		IPField = new JTextField();
		IPField.setHorizontalAlignment(SwingConstants.LEFT);
		IPField.setText("127.0.0.1");
		IPField.setBackground(Color.LIGHT_GRAY);
		IPField.setColumns(10);
		
		IDField = new JTextField();
		IDField.setText("10000");
		IDField.setColumns(10);
		IDField.setBackground(Color.LIGHT_GRAY);
		
		JList portList = new JList();
		portList.setBackground(Color.LIGHT_GRAY);
		portList.setForeground(Color.DARK_GRAY);
		portList.setFont(new Font("Liberation Mono", Font.PLAIN, 17));
		portList.setModel(new AbstractListModel() {
			String[] values = new String[] {"8000", "8001", "8002"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel portsLabel = new JLabel("Ports:");
		portsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		portsLabel.setForeground(Color.WHITE);
		portsLabel.setFont(new Font("Monospaced", Font.BOLD, 17));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(70, 130, 180));
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBackground(new Color(70, 130, 180));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(IPLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(IPField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(IDLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(IDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(portsLabel)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(24)
							.addComponent(portList, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRemove)
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(IPLabel)
						.addComponent(IPField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(IDLabel)
						.addComponent(IDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(portsLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(portList, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnAdd)
							.addGap(12)
							.addComponent(btnRemove)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.DARK_GRAY);
		add(buttonPanel, BorderLayout.SOUTH);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBackground(new Color(0, 204, 153));
		buttonPanel.add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.setBackground(new Color(0, 204, 153));
		buttonPanel.add(btnStop);
		
		JButton btnDisconnet = new JButton("Disconnect");
		btnDisconnet.setBackground(new Color(255, 51, 51));
		buttonPanel.add(btnDisconnet);

	}
}
