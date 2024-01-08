package com.diworksdev.login.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//MySQL接続に必要な情報を設定します。
public class DBConnector {
	private static String driverName ="com.mysql.jdbc.Driver";
	private static String url ="jdbc:mysql://localhost:8889/logindb";
//	jdbc:mysql://localhost:8889/
	private static String user ="root";
	private static String password ="root";
	public Connection getConnection() {
		Connection con = null;
//設定した情報を使って自分のパソコンにインストールされているMySQLサーバへ接続するための記述です。
		try {
			Class.forName(driverName);
			con = (Connection) DriverManager.getConnection(url,user,password);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return con;
//		MySQLサーバに接続した結果をメソッドの呼び出し元に渡します。
	}
}