package test;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TestField extends JFrame {

	private static final long serialVersionUID = 1158502547456169048L;
	private JPanel contentPane;
	private JLabel label1;
	private JLabel label2;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton button;
	private JComboBox<String> comboBox;

	/* Run this frame */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					TestField frame = new TestField();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TestField() throws Exception {
		setResizable(false);
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 228, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		label1 = new JLabel();
		label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		label1.setBounds(12, 48, 188, 16);
		contentPane.add(label1);

		textField = new JTextField();
		textField.setBounds(12, 77, 188, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		label2 = new JLabel();
		label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		label2.setBounds(12, 112, 188, 16);
		contentPane.add(label2);

		passwordField = new JPasswordField();
		passwordField.setBounds(12, 141, 188, 22);
		contentPane.add(passwordField);

		comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()==ItemEvent.SELECTED){
					LanguageList.setLanguageIndex(comboBox.getSelectedIndex());
					initialize();
				}
			}
		});
		comboBox.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));

		comboBox.setBounds(12, 13, 94, 22);
		contentPane.add(comboBox);

		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "English", "\u4E2D\u6587" }));

		button = new JButton();
		button.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 12));
		button.setBounds(12, 179, 97, 25);
		contentPane.add(button);

		initialize();
	}

	private void initialize() {
		comboBox.setSelectedIndex(LanguageList.getLanguageIndex());
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.messages", LanguageList.get());
		label1.setText(resourceBundle.getString("username"));
		label2.setText(resourceBundle.getString("password"));
		button.setText(resourceBundle.getString("login"));
	}
}