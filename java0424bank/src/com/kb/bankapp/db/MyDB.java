package com.kb.bankapp.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kb.bankapp.model.Account;
import com.kb.bankapp.model.Branch;
import com.kb.bankapp.model.Customer;
import com.kb.bankapp.model.KbCust;
import com.kb.bankapp.model.SavingAcc;

public class MyDB extends DbManager {
	private static MyDB inst = null;

	public static MyDB getInst() {
		if (inst == null) {
			inst = new MyDB();
		}
		return inst;
	}
	
	public MyDB() {
		super();
	}
	
	public void insertDb(KbCust cu) {
		PreparedStatement pstmt = null;
		String sql = "insert into customer21 values (?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cu.getCno());
			pstmt.setString(2, cu.getName());
			pstmt.setString(3, cu.getTel());
			pstmt.setString(4, cu.getAddr());
			pstmt.setString(5, cu.getBirth());
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

	
	@Override
	public String getCno() {
		String cno = null;
		String sql = "select cno from customer21 "
				+ "order by to_number(substr(cno, 6)) desc";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				cno = rs.getString("cno");
				break;
			}
			rs.close();
		} catch (SQLException e) {
			showErr(e);
		}
		
		if (cno == null) {
			cno = "C000-1";
		}
		else {
			String[] arr = cno.split("-");
			int n = Integer.parseInt(arr[1]);
			cno = "C000-" + (n+1);
		}
		return cno;
	}
	
	public String getAcNo() {
		String acno = null;
		String sql = "select acno from account21 "
				+ "order by to_number(substr(acno, 4)) desc";
		try {
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
			pstmt.setString(4, br.getBeName());
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

	public String getSaNo() {
		String sano = null;
		String sql = "select sano from savingacc21" +
			" order by to_number(substr(sano, 3)) desc";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				sano = rs.getString("sano");
				break;
			}
			rs.close();
		} catch (SQLException e) {
			showErr(e);
		}
		
		if (sano == null) {
			sano = "SA0001";
		}
		else {
			int n = Integer.parseInt(sano.substring(2));
			String str = String.format("%04d", n+1);
			sano = "SA" + str;
		}
		return sano;
	}

	public KbCust getKbCust(String acno) {
		KbCust kc = null;
		String sql = String.format("select * from customer21 where " +
			"cno=(select cno from account21 where acno='%s')", acno);
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next() ) {
				kc = new KbCust(
					rs.getString("cno"),
					rs.getString("cname"),
					rs.getString("ctel"),
					rs.getString("caddr"),
					rs.getString("cbirth"));
			}
			rs.close();
		} catch (SQLException e) {
			showErr(e);
		}
		return kc;
	}
	
	//계좌 정보를 리턴하는 클래스
	public Account getAccount(String acno) {
		Account kc = null;
		String sql = String.format("select * from account21 where acno = '%s'", acno);
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next() ) {
				kc = new Account(
					rs.getString("ACNO"),
					rs.getString("BNAME"),
					rs.getString("CNO"));
			}
			rs.close();
		} catch (SQLException e) {
			showErr(e);
		}
		return kc;
	}

	public int getJango(int deposit) {
		int sajango = 0;
		String sql = String.format("select sajango from ("
				+ "select sajango from savingacc21 where acno = '%s' \r\n"
				+ "order by to_number(substr(sano, 3)) desc) where rownum <= 1; ", deposit);
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next() ) {
				sajango = Integer.parseInt(rs.getString("sajango"));
			}
			rs.close();
		} catch (SQLException e) {
			showErr(e);
		}
		return sajango;
	}
	
	public SavingAcc getSavingAcc(String acno, KbCust kbCust, Account account) {
		SavingAcc savingAcc = null;
		String sql = String.format("select * from ("
				+ "select * from savingacc21 where acno = '%s' \r\n"
				+ "order by to_number(substr(sano, 3)) desc) where rownum <= 1 ", acno);
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next() ) {
				
				savingAcc = new SavingAcc(
						rs.getString("SANO"), 
						kbCust,
						account,
						rs.getString("SADATE"),
						rs.getString("SAINOUT"),
						rs.getInt("SAMONEY"),
						rs.getInt("SAJANGO"),
						rs.getString("TRANSFER"));			
			}
			rs.close();
		} catch (SQLException e) {
			showErr(e);
		}
		return savingAcc;
	}

	public void insertDb(SavingAcc saObj) {
		
		PreparedStatement pstmt = null;
		String sql = "insert into savingacc21 values (?,?,?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, saObj.getSano());
			pstmt.setString(2, saObj.getKbcu().getCno());
			pstmt.setString(3, saObj.getAc().getAcNo());
			pstmt.setString(4, saObj.getSadate());
			pstmt.setString(5, saObj.getSaInOut());
			int money = saObj.getSaMoney();
			pstmt.setInt(6, money);
			
			if (saObj.getSaInOut().equals("입금")) {
				pstmt.setInt(7, saObj.getSaJango() + money);
			}else {
				pstmt.setInt(7, saObj.getSaJango() - money);
			}
			
			pstmt.setString(8, saObj.getTransfer());
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

	public List<SavingAcc> getSavingAcc(String acno) {		
		
		List<SavingAcc> saList = new ArrayList<>();		
		PreparedStatement pstmt = null;
		String sql = String.format("select * from savingacc21 where acno = '%s'", acno);
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next() ) {
				
				String sano = rs.getString("sano");
				
				KbCust cKbCust = getKbCust(rs.getString("cno"));
				Account account = getAccount(rs.getString("acno"));
				
				String sadate = rs.getString("sadate");
				String sainout = rs.getString("sainout");
				int samoney = rs.getInt("samoney");
				int sajango = rs.getInt("sajango");
				String transfer = rs.getString("transfer");
				
				SavingAcc sa = new SavingAcc(sano,cKbCust, account, sadate,
						sainout, samoney, sajango, transfer);
				
				saList.add(sa);
				
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			showErr(e);
		}
		
		return saList;
	}
	
}


