package com.phonebook.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.phonebook.models.Contact;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactProfile extends JFrame {

	private JPanel contentPane;
	private JLabel lblContactInformation;
	private JLabel lblFirstName;
	private JTextField fname;
	private JLabel lblLastName;
	private JTextField lname;
	private JLabel lblPhone;
	private JTextField phone;
	private JLabel lblEmail;
	private JTextField email;
	private JLabel lblAddress;
	private JTextField address;
	private JLabel lblNickName;
	private JTextField nickname;
	private JLabel lblWebsite;
	private JTextField website;
	private JButton btnBack;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactProfile frame = new ContactProfile();
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
	public ContactProfile() {
		setTitle(fname +"'s Info");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblContactInformation());
		contentPane.add(getLblFirstName());
		contentPane.add(getFname());
		contentPane.add(getLblLastName());
		contentPane.add(getLname());
		contentPane.add(getLblPhone());
		contentPane.add(getPhone());
		contentPane.add(getLblEmail());
		contentPane.add(getEmail());
		contentPane.add(getLblAddress());
		contentPane.add(getAddress());
		contentPane.add(getLblNickName());
		contentPane.add(getNickname());
		contentPane.add(getLblWebsite());
		contentPane.add(getWebsite());
		contentPane.add(getBtnBack());
		contentPane.add(getLblNewLabel());
	}
	private JLabel getLblContactInformation() {
		if (lblContactInformation == null) {
			lblContactInformation = new JLabel("Contact Information");
			lblContactInformation.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 17));
			lblContactInformation.setBounds(185, 32, 163, 37);
		}
		return lblContactInformation;
	}
	private JLabel getLblFirstName() {
		if (lblFirstName == null) {
			lblFirstName = new JLabel("First Name:");
			lblFirstName.setBounds(28, 92, 67, 16);
		}
		return lblFirstName;
	}
	private JTextField getFname() {
		if (fname == null) {
			fname = new JTextField();
			fname.setBounds(165, 89, 116, 22);
			fname.setColumns(10);
		}
		return fname;
	}
	private JLabel getLblLastName() {
		if (lblLastName == null) {
			lblLastName = new JLabel("Last Name:");
			lblLastName.setBounds(28, 141, 67, 16);
		}
		return lblLastName;
	}
	private JTextField getLname() {
		if (lname == null) {
			lname = new JTextField();
			lname.setBounds(165, 138, 116, 22);
			lname.setColumns(10);
		}
		return lname;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("Phone:");
			lblPhone.setBounds(28, 192, 56, 16);
		}
		return lblPhone;
	}
	private JTextField getPhone() {
		if (phone == null) {
			phone = new JTextField();
			phone.setBounds(165, 189, 116, 22);
			phone.setColumns(10);
		}
		return phone;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email:");
			lblEmail.setBounds(28, 244, 56, 16);
		}
		return lblEmail;
	}
	private JTextField getEmail() {
		if (email == null) {
			email = new JTextField();
			email.setBounds(165, 241, 116, 22);
			email.setColumns(10);
		}
		return email;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address:");
			lblAddress.setBounds(28, 292, 56, 16);
		}
		return lblAddress;
	}
	private JTextField getAddress() {
		if (address == null) {
			address = new JTextField();
			address.setBounds(165, 292, 116, 22);
			address.setColumns(10);
		}
		return address;
	}
	private JLabel getLblNickName() {
		if (lblNickName == null) {
			lblNickName = new JLabel("Nick Name:");
			lblNickName.setBounds(28, 342, 67, 16);
		}
		return lblNickName;
	}
	private JTextField getNickname() {
		if (nickname == null) {
			nickname = new JTextField();
			nickname.setBounds(165, 339, 116, 22);
			nickname.setColumns(10);
		}
		return nickname;
	}
	private JLabel getLblWebsite() {
		if (lblWebsite == null) {
			lblWebsite = new JLabel("Website:");
			lblWebsite.setBounds(28, 393, 56, 16);
		}
		return lblWebsite;
	}
	private JTextField getWebsite() {
		if (website == null) {
			website = new JTextField();
			website.setBounds(165, 390, 116, 22);
			website.setColumns(10);
		}
		return website;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					SearchContact sc = new SearchContact();
					sc.setVisible(true);
					dispose();
					
				}
			});
			btnBack.setBounds(222, 463, 97, 25);
		}
		return btnBack;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblNewLabel.setBounds(331, 92, 163, 168);
		}
		return lblNewLabel;
	}
	
	public void displayContactProfile(Contact c){
		
		fname.setText(c.getFname());
		lname.setText(c.getLname());
		phone.setText(new Integer(c.getPhone()).toString());
		email.setText(c.getEmail());
		address.setText(c.getAddress());
		nickname.setText(c.getNickname());
		website.setText(c.getWebsite());
		
		fname.setEditable(false);
		lname.setEditable(false);
		phone.setEditable(false);
		email.setEditable(false);
		address.setEditable(false);
		nickname.setEditable(false);
		website.setEditable(false);
		
	}
	
	
}













