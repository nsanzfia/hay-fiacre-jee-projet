package model.collectManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.logging.Logger;

import model.Action;
import model.Bourse;
import model.Company;
import model.databaseManager.ActionManager;
import model.databaseManager.BourseManager;
import model.databaseManager.CompanyManager;
import model.databaseManager.Database;

public class Extract {

	private static boolean extractActionFile(String companySymbol) {
		URL url;
		try {
			url = new URL("http://ichart.finance.yahoo.com/table.csv?s=" + companySymbol +
					"&d=9&e=20&f=2013&g=d&a=7&b=19&c=2004&ignore=.csv");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			Logger.getLogger("model.collectManager.Extract.extractActionFile()").warning("\n" +
					"Il y a une erreur d'URL" + "\n" + e.getMessage());
			return false;
		}
		
		File file = new File("src/model/collectManager/dataFiles/actions.text");
		
		if(downloadFileFromUrl(url, file)) return true;
		else return false;
	}
	
	private static boolean extractBourseFile(String bourseName) {
		URL url;
		try {
			url = new URL("http://www.nasdaq.com/screening/companies-by-industry.aspx?exchange=" +
					bourseName + "&render=download");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			Logger.getLogger("model.collectManager.Extract.extractBourseFile" +
					"(String bourseName)").warning("\nIl y a une erreur d'URL" 
							+ "\n" + e.getMessage());
			return false;
		}
		
		File file = new File("src/model/collectManager/dataFiles/bourses.text");
		
		if(downloadFileFromUrl(url, file)) return true;
		else return false;
	}	
	
	public static boolean downloadFileFromUrl(URL url, File source) {
		if(!source.exists()) return false;
		else {
			try {
				org.apache.commons.io.FileUtils.copyURLToFile(url, source);
			} catch (IOException e) {
				e.printStackTrace();
				Logger.getLogger("model.collectManager.Extract.downloadFileFromUrl(URL url, " +
						"File source)").warning("\nIl y a une erreur d'URL" + "\n" + 
								e.getMessage());
				return false;
			}
			return true;
		}
	}
		
	public static boolean download() {
		if(extractActionFile("GOOG") && extractBourseFile("NASDAQ")) return true;
		else return false;
	}
	
//	public static void main(String args[]) {
////		if(extractActionFile("GOOG") && extractBourseFile("NASDAQ")) System.out.println("Ca marche");
////		else System.out.println("Ca marche pas");
//		Database d = new Database();
//		insertTableAction(d);
//	}
	
	public static boolean insertTableAction(Database database, String companySymbol, 
			int lineNumberToInsert) {
		ActionManager actionManager = new ActionManager(database);
//		String chaine="";
		String fichier ="src/model/collectManager/dataFiles/actions.text";
		if(!extractActionFile(companySymbol)) return false;
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String line;
			int lineNumber = 0;
			while ((line=br.readLine())!=null){
//				System.out.println(line);
				String str[] = line.split(",");
				
				if(lineNumber != 0 && lineNumber <= lineNumberToInsert) {
					String date[] = str[0].split("-");
					@SuppressWarnings("deprecation")
					java.sql.Date dSql = new Date(Integer.parseInt(date[0]), 
							Integer.parseInt(date[1]), Integer.parseInt(date[2]));
					Action action = new Action(dSql, Float.parseFloat(str[1]), Float.parseFloat(str[2])
							, Float.parseFloat(str[3]), Float.parseFloat(str[4]), 
							Float.parseFloat(str[5]), Float.parseFloat(str[6]), null);
					
					actionManager.addAction(action);
//					chaine+=line+"\n";
				}
				lineNumber++;
			}
			br.close(); 
		}		
		catch (Exception e){
			e.printStackTrace();
			Logger.getLogger("model.collectManager.Extract.downloadFileFromUrl(URL url, " +
					"File source)").warning("\nIl y a une erreur dans les chaines à insérer" 
							+ "\n" + e.getMessage());
			return false;
		}
		return true;
	}
	
	public static boolean insertTableCompany(Database database, String bourseName, int lineNumberToInsert) {
		CompanyManager companyManager = new CompanyManager(database);
//		String chaine="";
		String fichier ="src/model/collectManager/dataFiles/bourses.text";
		if(!extractBourseFile(bourseName)) return false;
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String line;
			int lineNumber = 0;
			while ((line=br.readLine())!=null){
//				System.out.println(line);
				String str[] = line.split("\",\"");
				
				if(lineNumber != 0 && lineNumber <= lineNumberToInsert) {
					Company company = new Company(str[0], str[1],Float.parseFloat(str[2]),
							Float.parseFloat(str[3]), str[4], str[5], str[6], str[7], str[8]);
					companyManager.addCompany(company);
//					chaine+=line+"\n";
				}
				lineNumber++;
			}
			br.close(); 
		}		
		catch (Exception e){
			e.printStackTrace();
			Logger.getLogger("model.collectManager.Extract.downloadFileFromUrl(URL url, " +
					"File source)").warning("\nIl y a une erreur dans les chaines à insérer" 
							+ "\n" + e.getMessage());
			return false;
		}
		return true;
	}
	
	public static void insertTableBourse(Database database) {
		BourseManager bm = new BourseManager(database);
		bm.addBourse(new Bourse("NASDAQ"));
		bm.addBourse(new Bourse("NYSE"));
		bm.addBourse(new Bourse("AMEX"));
	}
}

