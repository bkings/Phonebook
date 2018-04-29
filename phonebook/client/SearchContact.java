package com.phonebook.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import com.phonebook.models.Contact;
import com.phonebook.serviceImpl.PhoneServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchContact extends JFrame {

	private JPanel contentPane;
	private JLabel lblSearchForA;
	private JLabel lblEnterNameOr;
	private JTextField textField;
	private JButton btnSearch;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchContact frame = new SearchContact();
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
	public SearchContact() {
		setTitle("Find a contact");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblSearchForA());
		contentPane.add(getLblEnterNameOr());
		contentPane.add(getTextField());
		contentPane.add(getBtnSearch());
		contentPane.add(getBtnBack());
	}
	private JLabel getLblSearchForA() {
		if (lblSearchForA == null) {
			lblSearchForA = new JLabel("Search for a contact");
			lblSearchForA.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 17));
			lblSearchForA.setBounds(174, 47, 194, 37);
		}
		return lblSearchForA;
	}
	private JLabel getLblEnterNameOr() {
		if (lblEnterNameOr == null) {
			lblEnterNameOr = new JLabel("Enter name or phone no:");
			lblEnterNameOr.setBounds(69, 145, 160, 28);
		}
		return lblEnterNameOr;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(241, 148, 171, 22);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Contact c = new Contact();
					
					String fname = textField.getText();
					
					PhoneServiceImpl psi = new PhoneServiceImpl();
					if(psi.searchContact(c,fname)){
						JOptionPane.showMessageDialog(null, " Contact found");			
						dispose();
					}
				}
			});
			btnSearch.setBounds(207, 238, 97, 25);
		}
		return btnSearch;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					IndexPage ip = new IndexPage();
					ip.setVisible(true);
					dispose();
					
				}
			});
			btnBack.setBounds(207, 309, 97, 25);
		}
		return btnBack;
	}
}
