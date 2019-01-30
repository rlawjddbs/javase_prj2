package day0108;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ZipcodeView extends JFrame {

	private JTextField jtfDong;
	private JButton jbtSearch;
	private DefaultTableModel dtmZipcode;
	
	public ZipcodeView() {
		super("�����ּ� �˻�");
		jtfDong = new JTextField(10);
		jbtSearch = new JButton("�˻�");
		
		String[] columnNames = {"������ȣ","�ּ�"};
		dtmZipcode = new DefaultTableModel(columnNames, 0);
		JTable tabZipcode = new JTable(dtmZipcode);
		
		tabZipcode.getTableHeader().setReorderingAllowed(false); //�÷� �̵� ����
		tabZipcode.setRowHeight(17);
		
		tabZipcode.getColumnModel().getColumn(0).setPreferredWidth(60);
		tabZipcode.getColumnModel().getColumn(1).setPreferredWidth(400);
		
		JScrollPane jsp = new JScrollPane(tabZipcode);
		
		JPanel panelNorth = new JPanel();
		panelNorth.add(new JLabel("�� �̸�"));
		panelNorth.add(jtfDong);
		panelNorth.add(jbtSearch);
		
		add("North", panelNorth);
		add("Center", jsp);
		
		ZipcodeViewEvt zve = new ZipcodeViewEvt(this);
		addWindowListener( zve );
		
		jtfDong.addActionListener(zve);
		jbtSearch.addActionListener(zve);
		
		setBounds(10, 100, 470, 500);
		setVisible(true);
		setResizable(false);
		
	}//ZipcodeView
	
	public JTextField getJtfDong() {
		return jtfDong;
	}

	public JButton getJbtSearch() {
		return jbtSearch;
	}

	public DefaultTableModel getDtmZipcode() {
		return dtmZipcode;
	}

	public static void main(String[] args) {
		new ZipcodeView();
	}//main

}//class