package com.cg.frs.service;

import java.util.ArrayList;

import com.cg.frs.dao.FlatRegistrationDAOImpl;
import com.cg.frs.dao.IFlatRegistrationDAO;
import com.cg.frs.dto.FlatRegistrationDTO;

public class FlatRegistrationServiceImpl  implements IFlatRegistrationService{
IFlatRegistrationDAO fd = new FlatRegistrationDAOImpl();
	public FlatRegistrationDTO registerFlat(FlatRegistrationDTO dto) {
		// TODO Auto-generated method stub
		return fd.registerFlat(dto);
	}

	public ArrayList<Integer> getAllOwnerIds() {
		// TODO Auto-generated method stub
		return fd.getAllOwnerIds();
				
				
				
	}

}
