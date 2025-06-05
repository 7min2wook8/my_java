package com.orcle.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connectOracle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String driver = "oracle.jdbc.driver.OracleDriver"; 
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String userid = "test";
        String passwd = "1234";

        
        Connection con = null; //db 연결
        Statement stmt = null; //connect를 이용해 sql명령을 실행하는 객체
        ResultSet rs = null; //sql실행 후 select 결과를 저장하는 객체

        
        try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,userid,passwd);
			System.out.println("오라클 접속 성공");
			
			if (con != null) {
				System.out.println("오라클 접속 해제");
				con.close();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("오라클 드라이버를 못찾음!!");
			e.printStackTrace();
			
		}catch (SQLException e) {
			System.out.println("오라클 접속 에러!!");
			e.printStackTrace();
		}
        
	}

}
