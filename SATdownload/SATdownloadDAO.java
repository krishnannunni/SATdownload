package com.SATdownload;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.connection.ClsConnection;
import com.sun.org.apache.bcel.internal.generic.DCONST;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class SATdownloadDAO {
	
	Connection conn = ClsConnection.getMyConnection();
	
public static JSONArray sat_fleetsearch() throws SQLException {
		
        JSONArray RESULTDATA=new JSONArray();
		try {
			
			//System.out.println("=====sat_unamesearch");
				Connection conn = ClsConnection.getMyConnection();
				Statement stmt = conn.createStatement ();
            	
				ResultSet resultSet = stmt.executeQuery ("SELECT flname,salik_tag,fleet_no FROM gl_vehmaster");

				RESULTDATA=convertToJSON(resultSet);
				System.out.println("=====RESULTDATA"+RESULTDATA);
				stmt.close();
				conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
        return RESULTDATA;
    }
public static JSONArray sat_unamesearch() throws SQLException {
	
    JSONArray RESULTDATA=new JSONArray();
	try {
		
		System.out.println("=====sat_unamesearch");
			Connection conn = ClsConnection.getMyConnection();
			Statement stmt = conn.createStatement ();
        	
			ResultSet resultSet = stmt.executeQuery ("SELECT username FROM gl_webid");

			RESULTDATA=convertToJSON(resultSet);
			System.out.println("=====RESULTDATA"+RESULTDATA);
			stmt.close();
			conn.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
    return RESULTDATA;
}

	
public static JSONArray convertToJSON(ResultSet resultSet)
		throws Exception {
		JSONArray jsonArray = new JSONArray();
		while (resultSet.next()) {
		int total_rows = resultSet.getMetaData().getColumnCount();
		JSONObject obj = new JSONObject();
		for (int i = 0; i < total_rows; i++) {
			obj.put(resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase(), ((resultSet.getObject(i + 1)==null) ? "NA" : resultSet.getObject(i + 1).toString()));
		}
		jsonArray.add(obj);
		}
		return jsonArray;
		}

public boolean trafficInsert(String Ticket_No,java.sql.Date traffic_date,String Time,String fine_Source,String regNo,String PlateCategory,String pcolor,String LicenseNo,String LicenseFrom,String NotPayReason, Double Amount,String location,String fine,String remarks,java.sql.Date sd,String type,String category,int sr_no,String tcno,int xdoc){
	
	
	
boolean result=false;
PreparedStatement prest;
int dno=0;

try
{
	System.out.println("inside trafficInsert");

 boolean xflag=true;
 ResultSet sub=null;
 if(category.equalsIgnoreCase("traffic")){
//	 System.out.println("inside trafficInsert======>>>category");
//	 try{
//			ResultSet rs = conn.createStatement().executeQuery("Select coalesce(max(doc_no)+1,1) max from gl_traffic ");
//			
//			 if(rs.next())
//			   {	
//				 dno=rs.getInt("max");
//				 System.out.println("dnooooooooooooooooo"+dno);
//			   }	
//		}catch (Exception e2) {e2.printStackTrace();}
//	 xdoc=dno;
sub = conn.createStatement(
			ResultSet.TYPE_SCROLL_SENSITIVE,
			ResultSet.CONCUR_UPDATABLE).executeQuery(
					"Select * from  gl_traffic where doc_no="+xdoc);
	//int xlen = fBrowse.cache.size();
	int xsrno = 1;
	String fineno="";
	
	//for (int rw = 0; rw < xlen; rw++) {
		
		//fBrowse.cache.Rows = (Vector<Object>) fBrowse.cache.get(rw);
		fineno=Ticket_No;
		 ResultSet rs = conn.createStatement().executeQuery("Select * from gl_traffic t where t.Ticket_No='"+fineno+"'");
        if(rs.next()){
String loc=rs.getString("Location");String inv="";String sts="";
Double lo=0.0;
FileInputStream in=null;
Properties props = new Properties();
int dwno=0; 
//try {
//in = new FileInputStream("Reports/db.properties");
//props.load(in);
//  in.close();
//  //this. props.getProperty("jdbc.url");
//  dwno=Integer.parseInt((props.getProperty("gateway.downloadOnly")));
//} catch (IOException e) {
//e.printStackTrace();
////MyLib.Print("property file..not found");
//}
sts=rs.getString("status");
String fines=String.valueOf(rs.getDouble("fine"));
if(loc!=null&&!loc.equalsIgnoreCase("")){
lo=Double.parseDouble(loc);
loc=String.valueOf(lo);
}
        	
inv=rs.getString("Invoice") ;
//if(dwno==1&&sts!=null){
////continue;
//	return false;
//}
if(!loc.equalsIgnoreCase(fine)){
	//continue;
System.out.println("------loc.equalsIgnoreCase(fine)-------");
        	return false;
}
if(inv!=null)
{
if(inv.equalsIgnoreCase("1")){
//continue;
	return false;
}
}
        	else{
        		System.out.println("INSIDE OF ELSEEEEEEEEEE");
        		 prest =conn.prepareStatement("Delete from  gl_traffic  where Ticket_No='"+fineno+"'");
		         prest.executeUpdate();	
		         //sub.moveToInsertRow(); // moves cursor to the insert
					// row
                   //fBrowse.SaveBrowse(sub, rw);
                   //sub.updateInt("sr_no",xsrno++);
                  // sub.insertRow();
		         System.out.println("INSERTTTTTTTTTTTTTTTTT");
        	   }
        }
		         if(fineno!=null&&!fineno.equals(""))
					{
						System.out.println("LAAAASSSSSTTTTTTTTTTTTTTTTTT");
						
					System.out.println("Insert Into gl_traffic(regno, Ticket_No, Remarks,status,Doc_no,Time,Traffic_Date,Amount,sr_no,type,location,fine_source,pcolor,fine,tcno,Licence_no,Licence_From)" +
		                    " VALUES('"+regNo+"','"+Ticket_No+"','"+remarks+"',0,'"+xdoc+"','"+Time+"','"+traffic_date+"',"+Amount+",'"+sr_no+"','"+type+"','"+location+"','"+fine_Source+"','"+pcolor+"',"+fine+",'"+tcno+"','"+LicenseNo+"','"+LicenseFrom+"'");
					
					prest =conn.prepareStatement("Insert Into gl_traffic(regno, Ticket_No, Remarks,status,Doc_no,Time,Traffic_Date,Amount,sr_no,type,location,fine_source,pcolor,fine,tcno,Licence_no,Licence_From)" +
		                    " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					prest.setString(1,regNo);
					prest.setString(2,Ticket_No); 
					prest.setString(3,remarks);
					prest.setInt(4,0);
					prest.setInt(5,xdoc);
					prest.setString(6,Time);
					prest.setDate(7,traffic_date);
					prest.setDouble(8,Amount);
					prest.setInt(9,sr_no);
					prest.setString(10,type);
					prest.setString(11,location);
					prest.setString(12,fine_Source);
					prest.setString(13,pcolor);
					prest.setString(14,fine);
					prest.setString(15,tcno);
					prest.setString(16,LicenseNo);
					prest.setString(17,LicenseFrom);
					
					prest.executeUpdate();

					result=true;
					conn.commit();
					//System.out.println("kekekekekekekekekkekekekekekekekeke");
        	}
        	

}
}catch(Exception e){result=false;}
finally{
	
	if(conn!=null)
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
return result;
}

public boolean salikInsert(String ts,String plno,String tag,String Trans,java.sql.Date dtripvalue,String Loc,String Dir,String src,Double Amount,String time,java.sql.Date dtvalue,int xsadoc,java.sql.Date sd,int xsasrno,String type,String salik_fdate){
	
	
	//Connection conn = ClsConnection.getMyConnection();
	boolean result=false;
	PreparedStatement prest;
	int dno=0,xdoc=0;
	
	ResultSet rs;
	try {
		System.out.println(" 3rd LAAAASSSSSTTTTTTTTTTTTTTTTTT"+Trans);
		rs = conn.createStatement().executeQuery("Select * from gl_salik t where t.trans='"+Trans+"'");
		
		
		if(rs.next())
		{
			return false;
		}
		else
		{
			System.out.println("SECOND LAST");
			if(Trans!=null&&!Trans.equals(""))
			{
				System.out.println("LAAAASSSSSTTTTTTTTTTTTTTTTTT");
				xsasrno++;
				
			System.out.println("Insert Into gl_salik(Salik_User, regno, TagNo,Trans,salik_date,Location,Direction,Source,Amount,Salik_time,sal_date,Doc_no,date,sr_no,TYPE,salik_fdate,sal_post)" +
                    " VALUES('"+ts+"','"+plno+"','"+tag+"','"+Trans+"','"+dtripvalue+"','"+Loc+"','"+Dir+"','"+src+"','"+Amount+"','"+time+"','"+dtvalue+"',"+xsadoc+",'"+sd+"',"+xsasrno+",'SAL',"+salik_fdate+"");
			
			prest =conn.prepareStatement("Insert Into gl_salik(Salik_User, regno, TagNo,Trans,salik_date,Location,Direction,Source,Amount,Salik_time,sal_date,Doc_no,date,sr_no,TYPE,salik_fdate,sal_post)" +
                    " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			prest.setString(1,ts);
			prest.setString(2,plno); 
			prest.setString(3,tag);
			prest.setString(4,Trans);
			prest.setDate(5,dtripvalue);
			prest.setString(6,Loc);
			prest.setString(7,Dir);
			prest.setString(8,src);
			prest.setDouble(9,Amount);
			prest.setString(10,time);
			prest.setDate(11,dtripvalue);
			prest.setInt(12,xsadoc);
			prest.setDate(13,sd);
			prest.setInt(14,xsasrno);
			prest.setString(15,"SAL");
			prest.setString(16,salik_fdate);
			prest.setDate(17,dtvalue);
			
			prest.executeUpdate();

			
			
			
			try {
				prest = conn.prepareStatement("Update gl_salik set salik_date= concat(date(salik_date),' ',time(salik_time)) where doc_no="+xsadoc);
				
				 int aa=prest.executeUpdate();
				 
				 result=true;
				 //conn.commit();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		}	
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	finally{
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	return result;

}



public static JSONArray loadSalikData(String xdocs) throws SQLException {
	
    JSONArray RESULTDATA=new JSONArray();
	try {
		
		System.out.println("=====sat_unamesearch");
			Connection conn = ClsConnection.getMyConnection();
			Statement stmt = conn.createStatement ();
        	
			ResultSet resultSet = stmt.executeQuery ("Select Salik_User,trans,salik_date,salik_time,sal_date,regno,source,tagno,location,direction,amount,date from gl_salik where Doc_no in ("+xdocs+")");
System.out.println("============"+stmt);
			RESULTDATA=convertToJSON(resultSet);
			System.out.println("=====RESULTDATA"+RESULTDATA);
			stmt.close();
			conn.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
    return RESULTDATA;
}


public static JSONArray loadTrafficData(String xdocs) throws SQLException {
	
	System.out.println("==xdocs===="+xdocs);
	
    JSONArray RESULTDATA=new JSONArray();
	try {
		
		System.out.println("==loadTrafficData===sat_unamesearch");
			Connection conn = ClsConnection.getMyConnection();
			Statement stmt = conn.createStatement ();
        	
			
			
			
			ResultSet resultSet = stmt.executeQuery ("Select tcno,ticket_no,traffic_date,time,fine_source,amount,regno,Pcolor,licence_no,licence_from,tick_violat,tick_location from gl_traffic where Doc_no in ("+xdocs+")");

			RESULTDATA=convertToJSON(resultSet);
			System.out.println("==loadTrafficData===RESULTDATA"+RESULTDATA);
			stmt.close();
			conn.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
    return RESULTDATA;
}

}