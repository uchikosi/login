package com.diworksdev.login.action;
import java.sql.SQLException;

import com.diworksdev.login.dao.LoginDAO;
import com.diworksdev.login.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
//	struts2が持つActionSupportというクラスを継承します。（Actionクラスは基本的にこのクラスを継承します）
	private String name;
	private String password;
//	フィールド変数 JSPから受け取る値、ここではnameとpassword を定義します。
//	※必ずJSPでの定義と同じ名前にします！
	public String execute() throws SQLException {
		String ret = ERROR;
//		メソッドの戻り値「ret」 String ret = ERROR; を定義し、初期値としてERRORを代入します
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();
//		ユーザーが入力した「ログインID」（name）と「パスワード」(password)が、DTOからもってきた値
//		（dto = dao.select(name,password));が(dto.getName()）と(dto.getPassword())にそれぞれ一致するか確認をします。
		dto = dao.select(name,password);
//		JSPから送られてきたnameとpasswordを引数として、LoginDAOクラスのselectメソッドを呼び出します。
//		その後、DAOで取得した結果をLoginDTOに代入します。

		if(name.equals(dto.getName())) {
			if(password.equals(dto.getPassword())){
//				ユーザーが入力した「ログインID」（name）と「パスワード」(password)が、DTOからもってきた値
//				(dto.getName()）と(dto.getPassword())にそれぞれ一致するか確認をします。
				ret = SUCCESS;
//				if文の条件を満たした場合、戻り値「ret」の内容をreturn ret; SUCCESSに書き換えます。
			}
		}
		return ret;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
//			setName、setPassword(setter）を定義することでJSPでユーザーが入力したnameとpasswordの値がそれぞれのフィールド変数に格納されます。
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
//				※このログイン認証機能の課題では、 getNameとgetPasswordは使われませんが、次画面に値を引き渡すサイトの場合、
//				getterが必要です。後々の不具合を防ぐため、現段階ではgetterとsetterは両方書くようにしてください。
	}
}


//① setterを定義することで、JSPでユーザーが入力した値が
//フィールドに格納される
//②execute()メソッドを定義
//③条件分岐でSUCCESSかERRORかを決める
//（ここでは、ユーザーがJSPで入力した値とDTOに格納してある値を比較している）
//④execute()メソッドの結果 SUCCESS、ERRORを返す
//（それにより、あらかじめstruts.xmlに遷移先として定義したそれぞれのJSPに振り分けられる）