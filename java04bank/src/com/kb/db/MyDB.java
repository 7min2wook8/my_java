package com.kb.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kb.model.Account;
import com.kb.model.Branch;
import com.kb.model.Customer;
import com.kb.model.KbCust;

public class MyDB extends DbManager {

	private static MyDB inst;
	
	public static MyDB getInst() {
		if (inst == null) {
			inst = new MyDB();
		}		
		return inst;
		
	}
	
	
	public MyDB() {
		// TODO Auto-generated constructor stub
		super();
	}

	

	public void insertDb(KbCust cu) {
		// TODO Auto-generated method stub
		String sql = "insert into customer21(cno, cName, cTel, cAddr, cBirth) values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, cu.getCno());
			pstmt.setString(2, cu.getName());
			pstmt.setString(3, cu.getTel());
			pstmt.setString(4, cu.getAddr());
			pstmt.setString(5, cu.getBirth());			

			System.out.println("쿼리 완료!!!!");
			
			pstmt.executeUpdate();
			pstmt.close();
			con.commit();
			System.out.println("데이터 삽입 완료!!!!");
			
			
		} catch (SQLException  e) {
			// TODO: handle exception
			super.showErr(e);
		}
	}
	
	
	@Override
	public String getLastCno() {
		String cno = "";
		
		//cno 는 C000-0형식이다. substr("",2)는 2번째 자리를 기준으로 자르고 그 값을 저장 
		String sql = "select cno from customer21 order by to_number(substr(cno, 6)) desc";
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cno = rs.getString("cno");//마지막 cno 저장				
			}
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		//System.out.println(cno);
		if (cno == "") {
			cno = "C000-1";
			//number = 1;
		}else {
			
			cno = cno.substring(5);//C를 잘라냄
			
			int number = Integer.parseInt(cno);//문자열을 숫자로 변환
			
			number += 1;
			
			cno = "C000-" + number;
			
		}
		
		return cno;
		
	}

	
	public String getAcNo() {
		String acno = null;
		String sql = "select acno from account21 "
				+ "order by to_number(substr(acno, 4)) desc";
		try {
			ResultSet rs = null;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				acno = rs.getString("acno");
				break;
			}
			rs.close();
		} catch (SQLException e) {
			showErr(e);
		}
		
		if (acno == null) {
			acno = "BO-0001";
		}
		else {
			String[] arr = acno.split("-");
			int n = Integer.parseInt(arr[1]);
			String str = String.format("%04d", n+1);
			acno = "BO-" + str;
		}
		return acno;
	}
	
	

	public void insertDb(Account ac) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String sql = "insert into account21 values (?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ac.getAcNo());
			pstmt.setString(2, ac.getbName());
			pstmt.setString(3, ac.getCno());
			pstmt.executeUpdate();
			pstmt.close();
			con.commit();
		} catch (SQLException e) {
			showErr(e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				showErr(e1);
			}
		}
		
	}
	
	
	public void insertDb(Branch br) {
		PreparedStatement pstmt = null;
		String sql = "insert into branch21 values (?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, br.getbName());
			pstmt.setString(2, br.getbCity());
			pstmt.setString(3, br.getbJasan());
			pstmt.setString(4, br.getbEname());
			pstmt.setString(5, br.getbOpen());
			pstmt.setString(6, br.getbTel());
			pstmt.executeUpdate();
			pstmt.close();
			con.commit();
		} catch (SQLException e) {
			showErr(e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				showErr(e1);
			}
		}
	}
	
	
	public Map<String, List> getAccount() {
		Map<String, List> map = new HashMap<>();
		List<KbCust> cuList = new ArrayList<>();
		List<Branch> brList = new ArrayList<>();
		List<Account> acList = new ArrayList<>();
		PreparedStatement pstmt = null;
		String sql = 
			"SELECT * FROM account21 ac NATURAL JOIN customer21 cu "
			+ "JOIN branch21 br ON ac.bname=br.bname";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next() ) {
				cuList.add(new KbCust(
						rs.getString("cno"), 
						rs.getString("cname"), 
						rs.getString("ctel"),
						rs.getString("caddr"),
						rs.getString("cbirth")));
				brList.add(new Branch(
						rs.getString("bname"), 
						rs.getString("bcity"), 
						rs.getString("bjasan"),
						rs.getString("bename"),
						rs.getString("bopendate"),
						rs.getString("btel")));
				acList.add(new Account(
						rs.getString("acno"),
						rs.getString("bname"),
						rs.getString("cno")));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			showErr(e);
		}
		map.put("customer", cuList);
		map.put("branch", brList);
		map.put("account", acList);
		return map;
	}
	
	
}
