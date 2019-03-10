package com.cg.frs;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.frs.dto.FlatRegistrationDTO;
import com.cg.frs.exceptions.custom;
import com.cg.frs.exceptions.custom1;
import com.cg.frs.exceptions.custom2;
import com.cg.frs.exceptions.custom3;
import com.cg.frs.exceptions.custom4;
import com.cg.frs.service.FlatRegistrationServiceImpl;
import com.cg.frs.service.IFlatRegistrationService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	Scanner sc = new Scanner(System.in);
    	IFlatRegistrationService rs = new FlatRegistrationServiceImpl(); 
    	System.out.println("1.Register Flat");
    	System.out.println("2.Exit");
    	int ch = sc.nextInt();
    	switch(ch) {
    	case 1 :
    		FlatRegistrationDTO fr =new FlatRegistrationDTO();
    		ArrayList<Integer> arrayList = new ArrayList<Integer>();
    		arrayList=rs.getAllOwnerIds();
    		System.out.println("Exsisting owner id's are:"+arrayList);
    		System.out.println("please enter your owner id from exsisting above list:");
    		int id= sc.nextInt();
    		if(arrayList.contains(id))
    		{
    			fr.setOwnerid(id);
    		if(fr!=null) {
    	    System.out.println("select flat type(1-1BHK,2-2BHk):");
    	    int type = sc.nextInt();
    	   if(type==1||type==2) {		
            System.out.println("enter flat area in sq ft:");
    	   int area = sc.nextInt();
    	   if(area>0) {
    	   System.out.println("enter desired rent amount");
    	   int rent = sc.nextInt();	
    	   if(rent>0) {
    	   System.out.println("enter desired deposit amount ");
    	   int depo = sc.nextInt();
    	   if(depo>0) {
    	   fr.setFlattype(type);
    	   fr.setFlatarea(area);
    	   fr.setRent(rent);
    	   fr.setDepositamount(depo);
    	   FlatRegistrationDTO ft = rs.registerFlat(fr);
    	   System.out.println("Flat successfully registered.Registration id:<"+ft.getFlatreg()+">");
    	   }
    	   else
    	   {
    		   try
    		   {
    			   throw new custom4();
    		   }catch(custom4 e) {}
    	   }
    	   }
    	   else {
    		   try
    		   {
    			   throw new custom3();
    		   }catch(custom3 e) {}
    	   }
    	   }
    	   else
    	   {
    		   try
    		   {
    			   throw new custom2();
    		   }
    		   catch(custom2 e) {}
    	   }
    	   }
    	   else
    	   {
    		   try
    		   {
    			   throw new custom1();
    		   }
    		   catch(custom1 e) {}
    	   }
    		}
    		}
    		else {
    			try
    			{
    				throw new custom();
    			}catch(custom e) {}
    	
    		}
    		
    	case 2 :
    		System.exit(0);
    	
    		}

    	}

    
    }


    
    

