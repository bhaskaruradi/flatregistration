package com.cg.frs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;


import com.cg.frs.dto.FlatRegistrationDTO;

public class FlatRegistrationDAOImpl implements IFlatRegistrationDAO {

	public FlatRegistrationDTO registerFlat(FlatRegistrationDTO dto) {
		FlatRegistrationDTO user = new FlatRegistrationDTO();
		int owner = dto.getOwnerid();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
			PreparedStatement pst = connection.prepareStatement("insert into flat_Registration values(?,?,?,?,?,?)");
			pst.setInt(1,dto.getFlatreg());
			pst.setInt(2,dto.getOwnerid());
			pst.setInt(3,dto.getFlattype());
			pst.setInt(4,dto.getFlatarea());
			pst.setInt(5,dto.getRent() );
			pst.setInt(6,dto.getDepositamount());
			
			pst.executeUpdate();
           PreparedStatement st =connection.prepareStatement("select flatreg_number from flat_Registration where owner_ID = ?" );
           st.setInt(1, owner);
           ResultSet rs = st.executeQuery();
			
			
			
			
			while(rs.next())
			{
				
					
				
				user.setFlatreg(rs.getInt(1));
				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;	
		
		
		
		
	}

	public ArrayList<Integer> getAllOwnerIds() {
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
			
			Statement st = connection.createStatement();
			
			ResultSet rs = st.executeQuery("select * from flat_owners");
			int c =0;
			while(rs.next())
			{
				arraylist.add(rs.getInt(1));
			}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arraylist;
	}

	

}
