package cn.lntu.t12;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frames extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frames frame = new frames();
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
	public frames() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8BFE\u7A0B");
		label.setBounds(66, 6, 61, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u6210\u7EE9");
		label_1.setBounds(263, 6, 61, 16);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(218, 34, 134, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(218, 74, 134, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8BED\u6587");
		label_2.setBounds(76, 40, 61, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u6570\u5B66");
		label_3.setBounds(76, 80, 61, 16);
		contentPane.add(label_3);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(75, 169, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.setBounds(235, 169, 117, 29);
		contentPane.add(btnNewButton_1);
	}
}
