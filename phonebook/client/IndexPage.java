package com.phonebook.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

import com.phonebook.models.Contact;
import com.phonebook.serviceImpl.PhoneServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class IndexPage extends JFrame {

	private JPanel contentPane;
	private JLabel lblPhonebook;
	private JButton btnAdd;
	private JLabel lblAddAContact;
	private JLabel lblSearchAContact;
	private JButton btnSearch;
	private JLabel lblListAllContacts;
	private JButton btnList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IndexPage frame = new IndexPage();
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
	public IndexPage() {
		setTitle("Welcome to Phonebook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblPhonebook());
		contentPane.add(getBtnAdd());
		contentPane.add(getLblAddAContact());
		contentPane.add(getLblSearchAContact());
		contentPane.add(getBtnSearch());
		contentPane.add(getLblListAllContacts());
		contentPane.add(getBtnList());
	}
	private JLabel getLblPhonebook() {
		if (lblPhonebook == null) {
			lblPhonebook = new JLabel("Phonebook");
			lblPhonebook.setForeground(new Color(70, 130, 180));
			lblPhonebook.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 20));
			lblPhonebook.setBounds(265, 24, 131, 41);
		}
		return lblPhonebook;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					NewContact nc = new NewContact();
					nc.setVisible(true);
					dispose();
					
					
				}
			});
			btnAdd.setBounds(344, 123, 97, 25);
		}
		return btnAdd;
	}
	private JLabel getLblAddAContact() {
		if (lblAddAContact == null) {
			lblAddAContact = new JLabel("Add a contact :");
			lblAddAContact.setBounds(199, 125, 97, 21);
		}
		return lblAddAContact;
	}
	private JLabel getLblSearchAContact() {
		if (lblSearchAContact == null) {
			lblSearchAContact = new JLabel("Search a contact :");
			lblSearchAContact.setBounds(199, 179, 117, 30);
		}
		return lblSearchAContact;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					SearchContact sc = new SearchContact();
					sc.setVisible(true);
					dispose();
					
				}
			});
			btnSearch.setBounds(344, 182, 97, 25);
		}
		return btnSearch;
	}
	private JLabel getLblListAllContacts() {
		if (lblListAllContacts == null) {
			lblListAllContacts = new JLabel("List all contacts :");
			lblListAllContacts.setBounds(199, 236, 104, 25);
		}
		return lblListAllContacts;
	}
	private JButton getBtnList() {
		if (btnList == null) {
			btnList = new JButton("List");
			btnList.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					AllContacts ac = new AllContacts();
					ac.populateData();
					ac.setVisible(true);
					dispose();
					
				}
			});
			btnList.setBounds(344, 236, 97, 25);
		}
		return btnList;
	}
	
	
	
}
