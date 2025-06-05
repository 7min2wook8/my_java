package com.oracle.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.oracle.Student.Student;


public class DbManager {

	private static  DbManager inst;
	
	
    private String driver = "oracle.jdbc.driver.OracleDriver"; 
    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String userid = "scott";
    private String passwd = "tiger";

    
    private Connection con = null; //db 연결
    private Statement stmt = null; //connect를 이용해 sql명령을 실행하는 객체
    private ResultSet rs = null; //sql실행 후 select 결과를 저장하는 객체
    
	
	public DbManager() {
		connect();
	}
	
	public static DbManager getInstance() {
		if (inst == null) {
			inst = new DbManager();
		}
		
		return inst;
		
	}
	
	public void showDB() {
		inst.connect();
		
		try {			
			
			String sql = "Select * from student_t";
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("데이터 출력중....");
			
			int i = 1;
			while (rs.next()) {
				System.out.println("번호" + (i++));
				System.out.println("학번: " + rs.getString("sno")+"\n"+
									"이름: "+ rs.getString("sname")+"\n"+
									"전화번호: "+ rs.getString("tel")+"\n"+
									"학과: "+ rs.getString("major")+"\n");
				System.out.println("------------------------------------");				
			}
			rs.close();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("데이터 보기 실패!!");
			System.out.println(e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	
	public void insertTable(Student st) {
		inst.connect();
		String sno = st.getSno();
		String sname = st.getName();
		String tel = st.getTel();;
		String major = st.getMajor();
		try {			
			
			String sql = "insert into student_t(sno, sname, tel, major) "
					+ "values('"+sno+"','"+sname+"','"+tel+"','"+major+"')";
			
			stmt = con.createStatement();
			stmt.executeQuery(sql);
			System.out.println(sno + "학번 데이터 삽입 완료");
			con.commit();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("데이터 삽입 실패!!");
			System.out.println(e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	
	public void createTable() {
		inst.connect();
		
		try {			
			
			String sql = "create table student_t("
					+ "sno 		varchar(10) primary key,"
					+ "sname 	Varchar(10) not null,"
					+ "tel 		Varchar(30) not null,"
					+ "major 	Varchar(30) not null)";
			
			stmt = con.createStatement();
			stmt.executeQuery(sql);
			System.out.println("테이블 생성 완료");
			con.commit();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("테이블 생성 실패!!");
			System.out.println(e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	public void dropTable() {
		inst.connect();
		
		try {			
			
			String sql = "drop table student_t";
			
			stmt = con.createStatement();
			stmt.executeQuery(sql);
			System.out.println("테이블 삭제 완료");
			con.commit();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("테이블 삭제 실패!!");
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		
	}
	
	public void connect() {
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,userid,passwd);
			System.out.println("오라클 접속 성공");
			con.setAutoCommit(false); // 트랜잭션 수동 설정
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("오라클 드라이버를 못찾음!!");
			e.printStackTrace();
			
		}catch (SQLException e) {
			System.out.println("오라클 접속 에러!!");
			e.printStackTrace();
		}
	}
	
	
	public void close() {
		
		if (con != null) {
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("오라클 접속 해제");
		}
	}
}
