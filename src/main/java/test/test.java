package test;

import java.sql.Connection;

import DataBase.ConnectData;

public class test {
	public static void main(String[] args) {
		Connection con = ConnectData.getConnect();
		System.out.println(con);
		ConnectData.closeConnect(con);
		System.out.println(con);
	}
}
