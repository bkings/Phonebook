package com.phonebook.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

import com.phonebook.models.Contact;
import com.phonebook.serviceImpl.PhoneServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewContact extends JFrame {

	private JPanel contentPane;
	private JLabel lblFirstName;
	private JTextField fname;
	private JLabel lblLastName;
	private JTextField lname;
	private JLabel lblPhone;
	private JTextField phone;
	private JLabel lblEmailId;
	private JTextField email;
	private JLabel lblAddress;
	private JTextField address;
	private JLabel lblNickname;
	private JTextField nickname;
	private JLabel lblWebsite;
	private JTextField website;
	private JLabel imgbox;
	private JLabel lblClickToAdd;
	private JButton btnAdd;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewContact frame = new NewContact();
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
	public NewContact() {
		setTitle("Add new contact");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblFirstName());
		contentPane.add(getFname());
		contentPane.add(getLblLastName());
		contentPane.add(getLname());
		contentPane.add(getLblPhone());
		contentPane.add(getPhone());
		contentPane.add(getLblEmailId());
		contentPane.add(getEmail());
		contentPane.add(getLblAddress());
		contentPane.add(getAddress());
		contentPane.add(getLblNickname());
		contentPane.add(getNickname());
		contentPane.add(getLblWebsite());
		contentPane.add(getWebsite());
		contentPane.add(getImgbox());
		contentPane.add(getLblClickToAdd());
		contentPane.add(getBtnAdd());
		contentPane.add(getBtnBack());
	}

	private JLabel getLblFirstName() {
		if (lblFirstName == null) {
			lblFirstName = new JLabel("First Name");
			lblFirstName.setBounds(12, 32, 76, 25);
		}
		return lblFirstName;
	}
	private JTextField getFname() {
		if (fname == null) {
			fname = new JTextField();
			fname.setBounds(95, 33, 116, 22);
			fname.setColumns(10);
		}
		return fname;
	}
	private JLabel getLblLastName() {
		if (lblLastName == null) {
			lblLastName = new JLabel("Last Name");
			lblLastName.setBounds(12, 83, 76, 22);
		}
		return lblLastName;
	}
	private JTextField getLname() {
		if (lname == null) {
			lname = new JTextField();
			lname.setBounds(95, 83, 116, 22);
			lname.setColumns(10);
		}
		return lname;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("Phone");
			lblPhone.setBounds(12, 136, 76, 25);
		}
		return lblPhone;
	}
	private JTextField getPhone() {
		if (phone == null) {
			phone = new JTextField();
			phone.setBounds(95, 137, 116, 22);
			phone.setColumns(10);
		}
		return phone;
	}
	private JLabel getLblEmailId() {
		if (lblEmailId == null) {
			lblEmailId = new JLabel("Email Id");
			lblEmailId.setBounds(12, 184, 56, 16);
		}
		return lblEmailId;
	}
	private JTextField getEmail() {
		if (email == null) {
			email = new JTextField();
			email.setBounds(95, 181, 116, 22);
			email.setColumns(10);
		}
		return email;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setBounds(12, 231, 76, 25);
		}
		return lblAddress;
	}
	private JTextField getAddress() {
		if (address == null) {
			address = new JTextField();
			address.setBounds(95, 232, 116, 22);
			address.setColumns(10);
		}
		return address;
	}
	private JLabel getLblNickname() {
		if (lblNickname == null) {
			lblNickname = new JLabel("Nickname");
			lblNickname.setBounds(12, 282, 76, 25);
		}
		return lblNickname;
	}
	private JTextField getNickname() {
		if (nickname == null) {
			nickname = new JTextField();
			nickname.setBounds(95, 283, 116, 22);
			nickname.setColumns(10);
		}
		return nickname;
	}
	private JLabel getLblWebsite() {
		if (lblWebsite == null) {
			lblWebsite = new JLabel("Website");
			lblWebsite.setBounds(12, 330, 76, 25);
		}
		return lblWebsite;
	}
	private JTextField getWebsite() {
		if (website == null) {
			website = new JTextField();
			website.setBounds(95, 331, 116, 22);
			website.setColumns(10);
		}
		return website;
	}
	private JLabel getImgbox() {
		if (imgbox == null) {
			imgbox = new JLabel("");
			imgbox.setBorder(new LineBorder(new Color(72, 61, 139)));
			imgbox.setForeground(new Color(0, 0, 0));
			imgbox.setBounds(339, 36, 199, 171);
		}
		return imgbox;
	}
	private JLabel getLblClickToAdd() {
		if (lblClickToAdd == null) {
			lblClickToAdd = new JLabel("Click above to add a picture");
			lblClickToAdd.setBounds(360, 231, 167, 25);
		}
		return lblClickToAdd;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(fname.getText().equals("") || lname.getText().equals("") || phone.getText().equals("") || address.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Fill up all the fields");
					}else{
					
					Contact c = new Contact();
					c.setFname(fname.getText());
					c.setLname(lname.getText());
					c.setPhone(Integer.parseInt(phone.getText()));
					c.setEmail(email.getText());
					c.setAddress(address.getText());
					c.setNickname(nickname.getText());
					c.setWebsite(website.getText());
					
					PhoneServiceImpl psi = new PhoneServiceImpl();
					if(psi.addContact(c)){
						JOptionPane.showMessageDialog(null, c.getFname() + "'s" + " Contact saved");
					}else{
						JOptionPane.showMessageDialog(null, "Error");
					 }
					
					//clear all data
					fname.setText("");
					lname.setText("");
					phone.setText("");
					email.setText("");
					address.setText("");
					nickname.setText("");
					website.setText("");
					
				   }
				}
			});
			btnAdd.setBounds(204, 404, 97, 25);
		}
		return btnAdd;
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
			btnBack.setBounds(204, 442, 97, 25);
		}
		return btnBack;
	}
}
