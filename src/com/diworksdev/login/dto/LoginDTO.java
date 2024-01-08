package com.diworksdev.login.dto;
public class LoginDTO {
	private int id;
	private String name;
	private String password;
//	テーブルから取得するデータに対応したフィールド変数を宣言します。

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	フィールド変数に対応したgetter とsetterを定義します。
	public String getName() {
		return name;
	}
//	Actionクラスから呼び出され、nameフィールドの値をActionに渡します。
	public void setName(String name){
		this.name = name;
	}
	//DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のnameフィールドに格納します。
	public String getPassword() {
		return password;
	}
	//Actionクラスから呼び出され、passwordフィールドの値をActionに渡します。
	public void setPassword(String password){
		this.password = password;
	}
//	DAOクラスから呼び出され、引数として受け取ったテーブルの値を自身のpasswordフィールドに格納します。
}
//①DAOクラスでselectされた値を格納するためのクラス
//②フィールドで格納する値を宣言
//③②の各フィールドのgetterとsetterを定義
//getter：Actionクラスから呼び出されActionへ値を渡す
//setter：DAOクラスから呼び出され、テーブルの値を自身（DTO）のフィールドに格納