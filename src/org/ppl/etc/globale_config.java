package org.ppl.etc;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.Session;

import org.quartz.Scheduler;

import com.google.inject.Injector;
import com.mongodb.MongoClient;

public class globale_config {
	public static globale_config config = null;
	
	public static String dbCase = "PGSource";  // db source
	public static String PropertiesPath = "properties/";
	public static String ext = ".properties";
	public static String Config = PropertiesPath+"config"+ext;
	public static String Mongo = PropertiesPath+"mongo"+ext;
	public static String Mysql = PropertiesPath+"mysql"+ext;
	public static String PostGre = PropertiesPath+"pg"+ext;
	public static String DBCONFIG = Mysql;
	public static String UrlMap = PropertiesPath+"UrlMap"+ext;
	public static String Mail = PropertiesPath+"mail"+ext;
	
	//Kaptch
	public static String Kaptch = PropertiesPath+"kaptch"+ext;
	public static String KaptchSes = "KAPTCH";
	//session
	public static String SessSalt = "session.salt";
	public static String Ontime = "session.ontime";
	public static String sessAcl = "session.acl";
	public static String CookieSalt = "cookie.csalt";
	
	public static String TimeDelay = "time.delay";
	public static String TimeOut = "time.out";
	
	public static String SubRole = "subrole"; 
	
	public static String CookieRegion = "Region";
	
	//cookie user info
	public static String Uinfo = "iCore";
	
	public static Injector injector = null;
	
	//public static RConnection rcoonnect = null;
	
	public static Map<Long, Connection> GDB = null;
		
//	//listQueue
//	public static List<Map<String, Object>> RapidListQueue;
//	public static Map<String, Map<String, Object>> RapidList;
//	
//	//CrontList
//	public static Map<String, Map<String, Object>> CronListQueue;
	
	public static MongoClient mongoClient = null;
	
	public static Map<String, Session> allSession = new HashMap<String, Session>();
	
	//Quartz
	public static Scheduler scheduler = null;
	
	public static String allStaticVer = "";
				
	public static globale_config getInstance() {
		if (config == null) {
			config = new globale_config();
		}

		return config;
	}
	


}
