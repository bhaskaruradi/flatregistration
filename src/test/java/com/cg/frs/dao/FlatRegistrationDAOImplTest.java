package com.cg.frs.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.frs.dto.FlatRegistrationDTO;

class FlatRegistrationDAOImplTest {
 static FlatRegistrationDAOImpl FlatRegistrationDAOImpl; 
 
	@BeforeAll
	 public static void init(){ 
		FlatRegistrationDAOImpl = new  FlatRegistrationDAOImpl();
	}
		
	

	@Test
	void testDAO() {
		FlatRegistrationDTO dto = new FlatRegistrationDTO();
		
		dto.setOwnerid(3);
		dto.setFlattype(1);
		dto.setFlatarea(458);
		dto.setRent(100);
		dto.setDepositamount(25000);
		FlatRegistrationDTO dto1 = FlatRegistrationDAOImpl.registerFlat(dto);
		assertEquals(1015, dto1.getFlatreg());
	}
	@Test
	void testId() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		assertEquals(arrayList,FlatRegistrationDAOImpl.getAllOwnerIds());
	}

}
