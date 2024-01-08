package com.diworksdev.login.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.diworksdev.login.dto.LoginDTO;
import com.diworksdev.login.util.DBConnector;

public class LoginDAO {
	public LoginDTO select(String name,String password) throws SQLException{
		//LoginDTO型を最後に呼び出し元に渡すので、LoginDTO型を戻り値にしたメソッドを作ります。 Actionクラスの値を引数として受け取ります。
		LoginDTO dto=new LoginDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql="select * from user where user_name=? and password=?";
		try {PreparedStatement ps = con.prepareStatement(sql);
		//	定義したSQL文の1番目の?にActionから送られたname、2番目の?にActionから送られたpasswordがそれぞれ入ります。
			ps.setString(1, name);
			ps.setString(2, password);
		//	select文のSQL文を実行するメソッドで、戻り値はResultSet になります。
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				dto.setName(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
			}
			//select文でDBから取得した情報をString型に変換してDTOクラスに格納します。
			//LoginDTOクラスのsetName、setPassword（setter）を利用します。
		}catch (SQLException e){
			e.printStackTrace();
			//処理中にSQL関連のエラーが発生した際に実行する処理です。
		}finally {
			con.close();
			//DB接続を終了する際は必ず書くメソッドです。
		}
		return dto;
		//dtoに入った値を、呼び出し元であるActionクラスに渡す。
	}
}
//①クラス、メソッドの定義
//②DBConnectorのインスタンス化
//③getConnectionの呼び出し（DBと接続する）
//④sql文を書く：値は ? を入れておく（どんな値でも使いまわしできるようにするため）
//⑤PreparedStatement（DBまで運んでくれる箱のイメージ）に代入
//⑥sql文の?に入れる値をsetする
//⑦executeQuery()/executeUpdate()で実行（select文の場合はexectuteQuery()を使う）
//⑧結果の処理（select文で取得した値をDTOに格納）
//⑨con.close()で接続を切る
