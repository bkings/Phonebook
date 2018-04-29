package com.phonebook.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.phonebook.client.ContactProfile;
import com.phonebook.db.DB;
import com.phonebook.models.Contact;
import com.phonebook.services.PhoneService;

public class PhoneServiceImpl implements PhoneService{
	
	Connection con = null;
	
	public PhoneServiceImpl(){
		con = DB.getConDB();
	}
	
	@Override
	public boolean addContact(Contact c) {
		
		String sql = "insert into contactdata(FirstName,LastName,Phone,Email,Address,NickName,Website)values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, c.getFname());
			pstm.setString(2, c.getLname());
			pstm.setInt(3, c.getPhone());
			pstm.setString(4, c.getEmail());
			pstm.setString(5, c.getAddress());
			pstm.setString(6, c.getNickname());
			pstm.setString(7, c.getWebsite());
			pstm.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean searchContact(Contact c,String fname) {
		
		int id = 0;
		String sql = "select Id from contactdata where FirstName = ?";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, fname);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				id = rs.getInt("Id");
			}
			
			Contact ct = getById(id);
			ContactProfile cp = new ContactProfile();
			cp.displayContactProfile(ct);
			
			if(fname.equals("") || id == 0){
				JOptionPane.showMessageDialog(null, "Contact mismatch");
			}else{
				cp.setVisible(true);
			}
			
			if(id!=0){
				return true;
			}else{
				return false;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Contact getById(int id) {
		
		Contact c = new Contact();
		String sql = "select * from contactdata where Id = ' "+id+" ' ";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()){
				c.setFname(rs.getString("FirstName"));
				c.setLname(rs.getString("LastName"));
				c.setPhone(rs.getInt("Phone"));
				c.setEmail(rs.getString("Email"));
				c.setAddress(rs.getString("Address"));
				c.setNickname(rs.getString("Nickname"));			// NickName
				c.setWebsite(rs.getString("Website"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return c;
	}

	@Override
	public List<Contact> getContact() {
		
		List<Contact> clist = new ArrayList<Contact>();
		String sql = "select * from contactdata";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()){
				Contact c = new Contact();
				c.setId(rs.getInt("id"));
				c.setFname(rs.getString("FirstName"));
				clist.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return clist;
	}

	
	
}
