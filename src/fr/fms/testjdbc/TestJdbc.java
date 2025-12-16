package fr.fms.testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import fr.fms.exo1.Article;

public class TestJdbc {
	public static void main(String[] args) {
		ArrayList<Article> articles = new ArrayList<Article>();
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shop", "root", "root")) {
			String req = "SELECT * FROM t_articles;";
			try(Statement s = c.createStatement()){
				try(ResultSet r = s.executeQuery(req)){
					while(r.next()) {
						articles.add(new Article(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4)));
					}
				}
			}
			
			for (Article a : articles) {
				System.out.println("[" + a.getIdArticle() + "]: " + a.getDescription() + " | " + a.getBrand() + " = " + a.getUnitaryPrice() + "€");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
