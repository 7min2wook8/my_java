package com.sec.bankapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sec.bankapp.model.Customer;
import com.sec.bankapp.ui.RendData;

public class DbManager {
	private String CLASS = "oracle.jdbc.driver.OracleDriver";
	private String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private String USER = "scott";
	private String PASSWD = "tiger";
	private Connection con;
	private static DbManager inst = null;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pstmt = null;
	public DbManager() {
		dbConnect();
	}

	public static DbManager getInst() {
		if (inst == null) {
			inst = new DbManager();
		}
		return inst;
	}

	public void dbConnect() {
		try {
			Class.forName(CLASS);
			con = DriverManager.getConnection(URL, USER, PASSWD);
			con.setAutoCommit(false);
			System.out.println("오라클 접속 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버를 못찾음!!");
			e.printStackTrace();
			System.exit(0);
		} catch (SQLException e) {
			System.out.println("오라클 접속 에러!!");
			e.printStackTrace();
		}
	}

	public void dbClose() {
		// 오라클 접속 해제
		if (con != null) {
			System.out.println("오라클 접속 해제");
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("오라클 해제 에러!!");
				e.printStackTrace();
			}
		}
	}

	public void createTable() {

		String sql = "create table customer_t (\r\n"
				+ "    cno varchar2(10) primary key,\r\n"
				+ "    name varchar2(10) not null,\r\n"
				+ "    tel varchar2(20) not null,\r\n"
				+ "    addr varchar2(30) not null)";
		
		
		try {
			st = con.createStatement();
			st.executeQuery(sql);
			
			System.out.println("테이블 생성 성공!");
			con.commit();
		} catch (SQLException e) {
			showErr(e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void showErr(SQLException e) {
		System.out.println("###################");
		System.out.println("오류 코드:" + e.getErrorCode());
		System.out.println("오류 내용:" + e.getMessage());
		System.out.println("###################");
	}

	public void dropTable() {
		String sql = "drop table customer_t";
		try {
			st = con.createStatement();
			st.executeQuery(sql);
			con.commit();
			
			
			System.out.println("테이블 삭제 성공!");
		} catch (SQLException e) {
			showErr(e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void insertDb(Customer customer) {
		insertDb3(customer.getName(), customer.getTel(), customer.getAddr());
	}
	
	public void insertDb3(String name, String tel, String address) {

		
		String sql = "insert into customer_t values(?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, getLastCno());
			pstmt.setString(2, name);
			pstmt.setString(3, tel);
			pstmt.setString(4, address);
			
			rs = pstmt.executeQuery();
			
			System.out.println("데이터 삽입 완료!!!!");
			pstmt.close();
			rs.close();
		} catch (SQLException  e) {
			// TODO: handle exception
			System.out.println("DB연결 실패하거나, SQL문이 틀렸습니다.");
			System.out.print("사유 : " + e.getMessage());
		}
		
	
		
	}
	
	private String cnoFormat(int number) {
		return String.format("C%05d", number);
	}
	
	private int getCnoLastCnoNum() {
		String cno = "";
		int number = 0;
		//cno 는 C0000형식이다. substr("",2)는 2번째 자리를 기준으로 자르고 그 값을 저장 
		String sql = "select cno from customer_t order by to_number(substr(cno, 2)) desc";
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				cno = rs.getString("cno");//마지막 cno 저장				
			}
			
			System.out.println("cno : "  + cno);
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		//System.out.println(cno);
		if (cno == "") {
			number = 1;
		}else {
			cno = cno.substring(1);//C를 잘라냄
			
			number = Integer.parseInt(cno);//문자열을 숫자로 변환
			
			number += 1;
		}
		
		return number;
		
	}
	
	private String getLastCno() {
		String cno = "";
		int number = 0;
		//cno 는 C0000형식이다. substr("",2)는 2번째 자리를 기준으로 자르고 그 값을 저장 
		String sql = "select cno from customer_t order by to_number(substr(cno, 2)) desc";
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				cno = rs.getString("cno");//마지막 cno 저장				
			}
			
			System.out.println("cno : "  + cno);
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		//System.out.println(cno);
		if (cno == "") {
			number = 1;
		}else {
			cno = cno.substring(1);//C를 잘라냄
			
			number = Integer.parseInt(cno);//문자열을 숫자로 변환
			
			number += 1;
		}
		cno = String.format("C%05d", number);
		return cno;
	}
	
	public void insertDb2(String name, String tel, String address) {

		String cno = "";
		int number = 0;
		String sql = "select max(cno) as max from customer_t";
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if (rs.next()) {
				cno = rs.getString("max");//마지막 cno 저장
			}
			
			System.out.println("cno : "  + cno);
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		System.out.println(cno);
		if (cno == "") {
			number = 1;
		}else {
			cno = cno.substring(1);//C를 잘라냄
			
			number = Integer.parseInt(cno);//문자열을 숫자로 변환
			
			number += 1;
		}
		//C000 ~ C999
		sql = "insert into customer_t values ("
				+ "'C'||TO_Char("+number+",'FM0000'),"
				+"'"+name+"', "
				+"'"+tel+"', "
				+"'"+address+"')";
		
		try {
			st = con.createStatement();
			st.executeQuery(sql);
			System.out.println("데이터 추가 성공!");
			con.commit();
		} catch (SQLException e) {
			showErr(e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	public void insertDb(String name, String tel, String address) {

		String cno = "";
		int number = 0;
		String sql = "select cno from customer_t";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next() ) {
				cno = rs.getString("cno");//마지막 cno 저장
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		if (cno == "") {
			number = 1;
		}else {
			cno = cno.substring(1);//C를 잘라냄
			
			number = Integer.parseInt(cno);//문자열을 숫자로 변환
			
			number += 1;
		}
		//C000 ~ C999
		sql = "insert into customer_t values ("
				+ "'C'||TO_Char("+number+",'FM0000'),"
				+"'"+name+"', "
				+"'"+tel+"', "
				+"'"+address+"')";
		
		try {
			st = con.createStatement();
			st.executeQuery(sql);
			System.out.println("데이터 추가 성공!");
			con.commit();
		} catch (SQLException e) {
			showErr(e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void showAllDb() {
		String sql = "select * from customer_t";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			int i = 1;
			while (rs.next()) {
				System.out.println("번호:"+ (i++));
				System.out.println(
						"고객번호:" + rs.getString("cno") + "\n" +
						"이름:" + rs.getString("name") + "\n" +
						"전화:" + rs.getString("tel") + "\n" +
						"주소:" + rs.getString("addr"));
				System.out.println("----------------------------");				
			}
			
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public void insertRendomData() {
		// TODO Auto-generated method stub
		String name = "";
		String tel = "";
		String address = "";
		
		
		String sql = "insert into customer_t values(?,?,?,?)";
		int getCno = getCnoLastCnoNum();//마지막 번호를 가져옴
		
		try {
			
			for (int i = 0; i < 100; i++) {
				
			
			name = RendData.getRandName();
			tel = RendData.getRandTel();
			address = RendData.getRandAdress();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cnoFormat(getCno));
			pstmt.setString(2, name);
			pstmt.setString(3, tel);
			pstmt.setString(4, address);
			getCno += 1;
			rs = pstmt.executeQuery();
			
			}
			
			System.out.println("데이터 삽입 완료!!!!");
			pstmt.close();
			rs.close();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

public void deleteData(String cno) {
		
		
		if (serchCno(cno)) {
			
			String sql = "delete customer_t where cno = ? ";
			
			try {
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, cno);				
				rs = pstmt.executeQuery();
				
				System.out.println("데이터 삭제 완료!!!!");
				pstmt.close();
				rs.close();
				con.commit();
			}  catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("cno를 못 찾았습니다.");
		}
	}



	public void updateData(int updateMenu, String cno, String text) {
		
		
		if (serchCno(cno)) {
			
			String sql = "";
			switch (updateMenu) {
			case 1: 
				sql = "update customer_t SET name = ? where cno = ? ";
				break;
			case 2: 
				sql = "update customer_t SET tel = ? where cno = ? ";
				break;
			case 3:
				sql = "update customer_t SET addr = ? where cno = ? ";
				break;
			default:
				//throw new IllegalArgumentException("Unexpected value: " + updateMenu);
			}
			
			try {
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, text);
				pstmt.setString(2, cno);
				rs = pstmt.executeQuery();
				
				System.out.println("데이터 수정 완료!!!!");
				pstmt.close();
				rs.close();
				con.commit();
			}  catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("cno를 못 찾았습니다.");
		}
	}

	//입력 받은 cno가 있는지 체크
	public boolean serchCno(String cno) {
		String sql = "select cno from customer_t where cno = ?";
		boolean b = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cno);
		
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				b = true;
			}
			
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return b;
	}
}
