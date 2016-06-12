package com.SATdownload;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.common.ClsCommon;
import com.connection.ClsConnection;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.DCONST;
import com.sun.xml.internal.ws.api.server.Adapter.Toolkit;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.apache.catalina.connector.Request;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.jetty.html.Image;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.seleniumhq.jetty7.io.BufferCache;



public class SATdownloadAction extends ActionSupport {
	
	private static final Logger log = Logger.getLogger( SATdownloadAction.class.getName() );
	
	private static final String JAVASCRIPT_SRC = 
            " var impl = { " +
            "     run: function() { " +
            "         println ('Hello, World!'); " +
            "     } " +
            " }; ";
	
	private String category="";
	private String hiddencategory="";
	private String chck_salikautomatic="";
	private String cmbsaliksite="";
	private String hidcmbsaliksite="";
	private String cmbtype="ldays";
	private String hidcmbtype="";
	private String jqxStartDate="";
	private String jqxEndDate="";
	private String hidjqxStartDate="";
	private String hidjqxEndDate="";
	private String txtusername="";
	private String txtsalikfleetno="";
	private String txtsaliktagno="";
	private String docs="0";
	private String captcha="";
	//private boolean radio_traffic=false;
	private String chck_trafficautomatic="";
	private String cmbtrafficsite="";
	private String hidcmbtrafficsite="";
	private String chck_trafficfileno="";
	private String txttrafficplateno="";
	private String txtsalikplatecode="";
	private String txttrafficcategory="";
	private String txttrafficauthority="";
	
	
	private String txtdescription="";
		
	
	
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public String getHiddencategory() {
		return hiddencategory;
	}
	public void setHiddencategory(String hiddencategory) {
		this.hiddencategory = hiddencategory;
	}
	public String getDocs() {
		return docs;
	}
	public void setDocs(String docs) {
		this.docs = docs;
	}
	public String getTxtdescription() {
		return txtdescription;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setTxtdescription(String txtdescription) {
		this.txtdescription = txtdescription;
	}
//	public boolean isCategory() {
//		return category;
//	}
//	public void setCategory(boolean category) {
//		this.category = category;
//	}




	public String getChck_salikautomatic() {
		return chck_salikautomatic;
	}
	public void setChck_salikautomatic(String chck_salikautomatic) {
		this.chck_salikautomatic = chck_salikautomatic;
	}
	public String getCmbsaliksite() {
		return cmbsaliksite;
	}
	public void setCmbsaliksite(String cmbsaliksite) {
		this.cmbsaliksite = cmbsaliksite;
	}


	public String getHidcmbsaliksite() {
		return hidcmbsaliksite;
	}
	public void setHidcmbsaliksite(String hidcmbsaliksite) {
		this.hidcmbsaliksite = hidcmbsaliksite;
	}





	public String getCmbtype() {
		return cmbtype;
	}
	public void setCmbtype(String cmbtype) {
		this.cmbtype = cmbtype;
	}


	public String getHidcmbtype() {
		return hidcmbtype;
	}
	public void setHidcmbtype(String hidcmbtype) {
		this.hidcmbtype = hidcmbtype;
	}


	public String getJqxStartDate() {
		return jqxStartDate;
	}
	public void setJqxStartDate(String jqxStartDate) {
		this.jqxStartDate = jqxStartDate;
	}





	public String getJqxEndDate() {
		return jqxEndDate;
	}
	public void setJqxEndDate(String jqxEndDate) {
		this.jqxEndDate = jqxEndDate;
	}


	public String getHidjqxStartDate() {
		return hidjqxStartDate;
	}
	public void setHidjqxStartDate(String hidjqxStartDate) {
		this.hidjqxStartDate = hidjqxStartDate;
	}


	public String getHidjqxEndDate() {
		return hidjqxEndDate;
	}
	public void setHidjqxEndDate(String hidjqxEndDate) {
		this.hidjqxEndDate = hidjqxEndDate;
	}





	public String getTxtusername() {
		return txtusername;
	}
	public void setTxtusername(String txtusername) {
		this.txtusername = txtusername;
	}


	public String getTxtsalikfleetno() {
		return txtsalikfleetno;
	}
	public void setTxtsalikfleetno(String txtsalikfleetno) {
		this.txtsalikfleetno = txtsalikfleetno;
	}


	public String getTxtsaliktagno() {
		return txtsaliktagno;
	}
	public void setTxtsaliktagno(String txtsaliktagno) {
		this.txtsaliktagno = txtsaliktagno;
	}



	public void setChck_trafficautomatic(String chck_trafficautomatic) {
		this.chck_trafficautomatic = chck_trafficautomatic;
	}
	private String getChck_trafficautomatic() {
		// TODO Auto-generated method stub
		return  chck_trafficautomatic;
	}
	
	public String getCmbtrafficsite() {
		return cmbtrafficsite;
	}
	public void setCmbtrafficsite(String cmbtrafficsite) {
		this.cmbtrafficsite = cmbtrafficsite;
	}


	public String getHidcmbtrafficsite() {
		return hidcmbtrafficsite;
	}
	public void setHidcmbtrafficsite(String hidcmbtrafficsite) {
		this.hidcmbtrafficsite = hidcmbtrafficsite;
	}


	public String getChck_trafficfileno() {
		return chck_trafficfileno;
	}
	public void setChck_trafficfileno(String chck_trafficfileno) {
		this.chck_trafficfileno = chck_trafficfileno;
	}





	public String getTxttrafficplateno() {
		return txttrafficplateno;
	}
	public void setTxttrafficplateno(String txttrafficplateno) {
		this.txttrafficplateno = txttrafficplateno;
	}





	public String getTxtsalikplatecode() {
		return txtsalikplatecode;
	}
	public void setTxtsalikplatecode(String txtsalikplatecode) {
		this.txtsalikplatecode = txtsalikplatecode;
	}


	public String getTxttrafficcategory() {
		return txttrafficcategory;
	}
	public void setTxttrafficcategory(String txttrafficcategory) {
		this.txttrafficcategory = txttrafficcategory;
	}



	public String getTxttrafficauthority() {
		return txttrafficauthority;
	}
	public void setTxttrafficauthority(String txttrafficauthority) {
		this.txttrafficauthority = txttrafficauthority;
	}


	static String url="",urldet="",ts="",pass="";
	static String browser="chrome";
	WebDriver driver=null;
	private static ChromeDriverService service;
	String defaultwindow = "";
	String popupwindow = "";
	Document docDet,doc;
	boolean flag=false;
	String fineno="",dat="0",time="",curPage="0",timeappend="",salik_fdate="" ;
	String [] tformat=new String[10];
	static int txtStPage=1;
	static int srno=0,xsasrno,xsadoc,serno=0,xdoc=0;
	int dno=0;
	static  String xdocs="0";
	
	Connection conn = ClsConnection.getMyConnection();
	
	public String process() throws ParseException{
		
		boolean result=false;
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		
		
		
		 String qryapnd="";
		
		 txtusername=getTxtusername();
		 category=getCategory();
		 cmbsaliksite=getCmbsaliksite();
		 
		 setHiddencategory(getCategory());
		 
		 System.out.println("===setHiddencategory==="+getHiddencategory());
		 
		// chck_salikautomatic=getChck_salikautomatic();
		 System.out.println("====category===="+category+"==chck_salikautomatic=="+chck_salikautomatic+"==txtusername==="+txtusername);
		 
		 if(getCategory().equalsIgnoreCase("salik"))
		 {
			 
			 if(getChck_salikautomatic().equalsIgnoreCase("salikautomatic"))
			 {
				 System.out.println("Inside of getChck_salikautomatic");
				 System.out.println("===cmbsaliksite==="+cmbsaliksite);
				 if(cmbsaliksite.equalsIgnoreCase("DXB")&&getCategory().equalsIgnoreCase("salik"))
				 {
					 if(txtusername==null ||txtusername.equalsIgnoreCase(""))
					 {
						 qryapnd="and 1=1" ;
					 }
					 else
					 {
						 qryapnd="and t.username='"+txtusername+"'";
					 }
					 ResultSet rssalik;
					try {
						System.out.println("Select * from gl_webid t where t.site='DXB'"+qryapnd+"");
						rssalik = conn.createStatement().executeQuery("Select * from gl_webid t where t.TYPE='U' and t.Desc1='Salik' "+qryapnd+"");
					
						while(rssalik.next())
						 {	
							ts=rssalik.getString("username");
							 pass=rssalik.getString("password");
							 url="https://customers.salik.ae/default.aspx?ReturnUrl=%2fModuleCustomer%2fDefault.aspx%3fculture%3deng&culture=eng";
							 	
                         }
						try {
							result=loadfresh();
							if(result==true)
							{
							request.setAttribute("resultdata", result);	
							
							}
							 setHiddencategory(getCategory());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 
				 
				 
			 }
		
		   }
			 
			 
		 }
		 else if(getCategory().equalsIgnoreCase("traffic"))
		 {
			 System.out.println("getCategory()====="+getCategory());
			 System.out.println("=====getCmbtrafficsite======="+getCmbtrafficsite());
			 System.out.println("===getChck_trafficautomatic()===="+getChck_trafficautomatic());
			 if(getChck_trafficautomatic().equalsIgnoreCase("trafficautomatic"))
			 {
				 //System.out.println("Inside of getChck_salikautomatic");
				// System.out.println("===cmbsaliksite==="+cmbsaliksite);
				 if(getCmbtrafficsite().equalsIgnoreCase("AUH")&&getCategory().equalsIgnoreCase("traffic"))
					{
							 try{
								
								 ResultSet rstraffic = conn.createStatement().executeQuery("Select * from gl_webid t where t.site='AUH'");
							
								   while(rstraffic.next())
								   {
									   ts=rstraffic.getString("username");
									   url="https://es.adpolice.gov.ae/trafficservices/FinesPublic/InquiryResult.aspx?TS="+rstraffic.getString("username")+"&IT=TS&Culture=en";
									  try{
									//	MyApp.frmMain.descriptionPane.setText(MyApp.frmMain.descriptionPane.getText()+"\n"+"Loading...\n\nURL:"+url+"\n");
									  loadfresh();
									  }catch (Exception ec) {ec.printStackTrace();}					   
									  
								   }
								   rstraffic.close();
									//boolean sveflg= SaveFormData(1, con);
//									if(sveflg)
//									{
//										
//									}
									}catch(Exception ex){ex.printStackTrace();}
						
					}
				 if(getCmbtrafficsite().equalsIgnoreCase("DXB")&&getCategory().equalsIgnoreCase("traffic")){
						try
						{
							
							 ResultSet rsTables = conn.createStatement().executeQuery("Select * from gl_webid t where t.site='DXB'");
							 while(rsTables.next())
							 {	
								 ts=rsTables.getString("username");
								 url="http://traffic.rta.ae/trfesrv/public_resources/ffu/fines-payment.do?actionParam=doSearch&searchMethod=3&trafficFileNo="+rsTables.getString("username")+"";
								 try{ loadfresh();}
								 catch (Exception ec) {ec.printStackTrace();}
							 }rsTables.close();
//							 boolean sveflg= SaveFormData(1, con);
//							 if(sveflg){}
					   }catch(Exception ex){ex.printStackTrace();}
			
			
					
					}
				
		
		   }
			 else
			 {
				 if(!(getChck_trafficfileno()==null))
				 {
				    if(getChck_trafficfileno().equalsIgnoreCase("trafficfileno")){
						if(getCmbtrafficsite().equalsIgnoreCase("DXB")&&getCategory().equalsIgnoreCase("traffic")){
							 try{
								
									 ts=getTxttrafficplateno();
									 if(ts.equalsIgnoreCase("")){
//										 JOptionPane.showMessageDialog(null,"Enter Plate no and continue!!!"); 
//										 return;
									 }else{
											url="http://traffic.rta.ae/trfesrv/public_resources/ffu/fines-payment.do?actionParam=doSearch&searchMethod=3&trafficFileNo="+ts+"";
						  try{
							   loadfresh();
							 
							  }catch (Exception ec) {ec.printStackTrace();}  
//						boolean sveflg= SaveFormData(1, con);
//						if(sveflg){
//							
//						}
									 }
							}catch(Exception ex){ ex.printStackTrace();}
				
				
						
						}
					  else if(getCmbtrafficsite().equalsIgnoreCase("AUH")&&getCategory().equalsIgnoreCase("traffic")){
							 try{
								 
								 ts=getTxttrafficplateno();
								 if(ts.equalsIgnoreCase("")){
									 //JOptionPane.showMessageDialog(null,"Enter Plate no and continue!!!"); 
									 //return;
								 }else{
					url="http://traffic.rta.ae/trfesrv/public_resources/ffu/fines-payment.do?actionParam=doSearch&searchMethod=3&trafficFileNo="+ts+"";
									  try{
									//	MyApp.frmMain.descriptionPane.setText(MyApp.frmMain.descriptionPane.getText()+"\n"+"Loading...\n\nURL:"+url+"\n");
									   loadfresh();
									  }catch (Exception ec) {ec.printStackTrace();}
									   
									  
								   }
//									boolean sveflg= SaveFormData(1, con);
//									if(sveflg){
//										
//									}
									}catch(Exception ex){ ex.printStackTrace();}
						
						}
				
				   }}
				 
				 
			 }
			 
		 }
		
		
		
		return "success";
	}
	
	
	
	public boolean loadfresh() throws IOException, InterruptedException
	{
		boolean result=false;
		java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
		java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);
		System.out.println("browser============>>>>"+browser);
		
/*		if (browser!=null && browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();

			options.addExtensions(new File("/home/user/projects/selenium/extension_1_12.crx"));
			DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();	
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver(chromeCapabilities);
			//driver.manage().window().setPosition(new Point(-2000, 0));
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    System.out.println("tabssss====="+tabs);
		    driver.switchTo().window(tabs.get(0));			
		}*/
//		else
			driver = new FirefoxDriver();
//		
//       We could use any driver for our tests...
//		File file = new File("chromedriver.exe"); //path to the chromedriver.exe so downloaded
//		System.out.println("PAAAAATTTHHHHH"+file.getAbsolutePath());
//		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		//System.setProperty("-Dwebdriver.chrome.driver", "chromedriver.exe");
		// ... but only if it supports javascript
		
		// Get a handle to the driver. This will throw an exception
		// if a matching driver cannot be located
		 //driver = new RemoteWebDriver(new URL("http://127.0.0.1:9515"),capabilities);
		
/*		DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
		service = new ChromeDriverService.Builder().usingDriverExecutable(new File("chromedriver.exe")).usingAnyFreePort().build();
         service.start();
		capabilities.setJavascriptEnabled(true);
		System.out.println("service.getUrl()======"+service.getUrl());
		driver = new RemoteWebDriver(service.getUrl(),capabilities);
		
		Capabilities actualCapabilities = ((RemoteWebDriver) driver).getCapabilities();
*/
		
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(url);
	    defaultwindow = driver.getWindowHandle();
	    
	    // System.out.println(driver.getPageSource());
	    doc= Jsoup.parse(driver.getPageSource());
//	    if(getCategory().equalsIgnoreCase("traffic"))
//	    {
//	        org.openqa.selenium.Dimension screenResolution = new org.openqa.selenium.Dimension(2000,2000);
//     	    driver.manage().window().setSize(screenResolution);
//     	    driver.manage().window().setPosition(new Point(2000,2000));
//	    }
	    //if(getCategory().equalsIgnoreCase("salik"))
	    if(getCategory().equalsIgnoreCase("traffic"))
        {
        	//driver.manage().window().setPosition(new Point(-2000, 0));
        }
	    result=jsoupGetTableData(1);
	       
	        if(getCategory().equalsIgnoreCase("traffic"))
	        {
	        	driver.manage().window().setPosition(new Point(-2000, 0));
	        	
	        	if(getCmbtrafficsite().equalsIgnoreCase("AUH"))
	        	{	
	        		int rowsize=150;
	        		
	        		for(int i=2;i< rowsize;i++)
	        		{
//	        			descriptionPane.setText(descriptionPane.getText()+"\n"+"Processing Page :"+i+"");
//	        			descriptionPane.update(descriptionPane.getGraphics());
	        			
	        			if (driver instanceof JavascriptExecutor) 
	        				((JavascriptExecutor)driver).executeScript("__doPostBack('ctl00$ContentPlaceHolder1$gvTickets','Page$"+i+"');");
	        			
	        			
       			
	        			//now ctl00_ContentPlaceHolder1_UpdateProgress1
	        			
	        			WebElement we=null;
						int cnt=0;
						do
						 {  
							 //Thread.sleep(5000);//commented by krish
							we = driver.findElement(By.id("ctl00_ContentPlaceHolder1_UpdateProgress1"));
							 String style = we.getAttribute("style").trim();
							 System.out.println("findinggggggg we - "+style+" - "+style.equalsIgnoreCase("display: none;")+" - "+cnt);
							 if (!style.equalsIgnoreCase("display: none;"))
								 we=null;
							 cnt++;
						 }while(we==null && cnt<10);
						
	        			url=driver.getCurrentUrl();

	        			doc= Jsoup.parse(driver.getPageSource());
	        			if(getCategory().equalsIgnoreCase("traffic"))
//	        			{
//							 org.openqa.selenium.Dimension screenResolution = new org.openqa.selenium.Dimension(2000,1000);
//							 driver.manage().window().setSize(screenResolution);
//							 driver.manage().window().setPosition(new Point(2000,1000));
//	        			}
	        				result=jsoupGetTableData(i);
	        		}
	   	      	}
	        	
	        	if(getCmbtrafficsite().equalsIgnoreCase("DXB"))
	        	{	        	
	        		
	        		WebElement rowsizeWebElement=driver.findElement(By.id("totalFinesAndAmountLabels"));
	        		System.out.println("totalFinesAndAmountLabels"+rowsizeWebElement);
	        		//System.out.println("rowsizeWebElement==========="+rowsizeWebElement.getAttribute("totalnum").trim());
	        		int rowsize=150;
	        		//	 int p=0; boolean flag=false;WebElement elementsFound=null;
	        		for(int i=2;i< rowsize;i++)
	        		{
	        			System.out.println("rowsize====================rowsize======="+rowsize);
//	        			descriptionPane.setText(descriptionPane.getText()+"\n"+"Processing Page :"+(i-1));
//	        			descriptionPane.update(descriptionPane.getGraphics());
	        			
	        				System.out.println("sfknsgknskgnskgnskgnskgnskgnskgnskgngk"+i);
//	        				if (driver instanceof JavascriptExecutor) 
//		        				((JavascriptExecutor)driver).executeScript("goToPage("+i+"-1);");
	        				
	        				if (driver instanceof JavascriptExecutor) 
		        				((JavascriptExecutor)driver).executeScript("goToPage("+i+"-1);");
	        				
	        				        			
	        			//now ctl00_ContentPlaceHolder1_UpdateProgress1
	        			
	        			WebElement we=null;
						int cnt=0;
						do
						 {  
							// Thread.sleep(5000);//commented by krish
							 
							we = driver.findElement(By.id("noFinesRow"));
							System.out.println("WEEEEEE"+we);
							 String style = we.getAttribute("style").trim();
							 System.out.println("findiiiiiing we - "+style+" - "+style.equalsIgnoreCase("display: block;")+" - "+cnt);
							 if (!style.equalsIgnoreCase("display: block;"))
								 we=null;
							 cnt++;
						 }while(we==null && cnt<10);
						
	        			url=driver.getCurrentUrl();

	        			doc= Jsoup.parse(driver.getPageSource());
//	        			if(radioT.isSelected())
//	        			{
//							 org.openqa.selenium.Dimension screenResolution = new org.openqa.selenium.Dimension(2000,1000);
//							 driver.manage().window().setSize(screenResolution);
//							 driver.manage().window().setPosition(new Point(2000,1000));
//	        			}
	        			result=jsoupGetTableData(i);
	        		}
	   	      	}
	        }
	        
	        if(getCategory().equalsIgnoreCase("salik"))
	        { 
	        	if(getCmbsaliksite().equalsIgnoreCase("DXB"))	
	        	{
	        		if(flag)
	        		{
						String k="";
						int d=Integer.parseInt(dat);
						int stpage =txtStPage;
						int count=2,i;
						System.out.println("No. of pages - "+d);
						//int stimer=0;						
						
						for(i=2;i<=d;i++)
						{
							boolean getdata = true;
							k=String.valueOf((i));
							if(Integer.parseInt(k)<10) k="0"+k;
							WebElement s;
							try
							{
								System.out.println("St page# -"+stpage+"; retrieved - "+(i-1)+" abt to click ----"+i);
							//	stimer=(i%2==0?30:(i%11==0?6:15));		//15 and 30 for alternate page. for next set of pages 6 seconds.
								
								//if (i%11==0)
									//inputCaptcha("Processing "+i+" of "+d+" Pages");
								
								//Thread.sleep(15*1000);//commented by krish
								
								if(stpage>d)
								{
									//JOptionPane.showMessageDialog(this.getParent(),MyLib.getUID("Start Page# exceeds total no. of pages - "+d));
									driver.quit();
									return false;
								}
								else if (stpage>1 && i<stpage)
								{
									if (stpage <= (i+(10-(i%10))))
									{
										System.out.println("St page# -"+stpage+"; stpage<="+(i+(10-(i%10))));
										s=driver.findElement(By.partialLinkText(String.valueOf(stpage)));
										s.click();
										i=stpage;
									}
									else
									{
										//System.out.println("HAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHAHA");
										
										s=driver.findElement(By.xpath("//*[@title='Next pages']"));
										s.click();
										i+=(10-(i%10));
										System.out.println("Next pages; i-"+i);
										getdata=false;
									}
								}
								else
								{
									System.out.println("Next page; Stpage -"+stpage+" i-"+i);
									s=driver.findElement(By.linkText(String.valueOf(i)));
									//s=driver.findElement(By.partialLinkText(String.valueOf((i))));   				
									s.click();
								}
							}
							catch (Exception e)
							{
								try
								{
									e.printStackTrace();
									System.out.println("Exception - next page"+i);
									s=driver.findElement(By.xpath("//*[@title='Next page']"));
									s.click();
								}catch(Exception e1)
								{
									 e1.printStackTrace();
									 //Thread.sleep(5000);--commented by krish
						             driver.quit();
						             
//									 int response = JOptionPane.showConfirmDialog(this.getParent(), "Website Server Error! Do you want to resume?", "Confirm",
//						            		 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//			ck			             
//						             if (response == JOptionPane.NO_OPTION) return;
						             						             
						             txtStPage=i-1;						             
						             loadfresh();
								}
							}
				       		 /*if (driver instanceof JavascriptExecutor) {       		
				       		
				       			((JavascriptExecutor)driver).executeScript("AjaxNS.AR('ctl00$WorkSpace$ctlCustAVIHistory$rgResult$ctl01$ctl03$ctl01$ctl"+k+"','', 'WorkSpace_ctlCustAVIHistory_ajxResultPanel', event);");
				       			String s="ctl00$WorkSpace$ctlCustAVIHistory$rgResult$ctl01$ctl03$ctl01$ctl10";
				       	
				       		 }*/
							System.out.println(" fetching page - "+i);
							doc=null;
							//int cnt=0;
//							Elements taEl=null;
//							do
//							{
//								//Thread.sleep(30000);
//								//if(cnt%2==0)
//								doc= Jsoup.parse(driver.getPageSource()); 
//								taEl = doc.select("table#WorkSpace_ctlCustAVIHistory_rgResult_ctl01");
//								//cnt++;
//								count++;
//							}while(taEl.isEmpty());

							WebElement we=null;
							int cnt=0;
							do
							 {  
								if(count==d)
								{
									System.out.println("count==d"+count+"+cd+");
									Thread.sleep(1000);	
								}
								 //Thread.sleep(1000);//--commented by krish
								 we = driver.findElement(By.id("ctl00_WorkSpace_ctlCustAVIHistory_RadAjaxPanelPlate"));
								 String style = we.getAttribute("style").trim();
								 System.out.println("findddddding we - "+style+" - "+style.isEmpty()+" - "+count);
								 if (!style.isEmpty())
									 we=null;
								 cnt++;
							 }while(we==null && cnt<10);
							count++;
							//	 Thread.sleep(20000);
							System.out.println("count----"+count);

							url=driver.getCurrentUrl();

							//  doc= Jsoup.parse(driver.getPageSource());
							
							
							if (getdata)
								result=jsoupGetTableData(i);
							
							if(count>d)
							{
								//Thread.sleep(5000);
								//loadData();
								Thread.interrupted();
								driver.quit();
							}
							//  count++;
					}
	       		}
	       	}
	    }
			return result;
	}
	
	public boolean jsoupGetTableData(int v) throws IOException, InterruptedException
	{
		ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        
        // evaluate JavaScript code from String
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		//Connection conn = ClsConnection.getMyConnection();
		
		System.out.println("HEHEHEHEHEHEHEHEHEHEHEHEHEHE");
		boolean result=false;
		//  doc = Jsoup.connect(url).get();
		Elements tableElements = null;
		//Elements detElements = null;
		// WebElement webel=null;
		 Elements rowItems=null;
		 Elements roi=null;
		 PreparedStatement prepst,iprepst;
		String textdescription="";
		 
		
		//DXB//
		 if(getCategory().equalsIgnoreCase("traffic"))
		 {			 
			 System.out.println(getCmbtrafficsite()+"==getCmbtrafficsite()=======");
			 if(getCmbtrafficsite().trim().equalsIgnoreCase("DXB"))
			 {
				 tableElements = doc.select("table.srchrsult");//div#pnlResults
				 System.out.println("table.srchrsult==============="+tableElements);
			 }
			 else if(getCmbtrafficsite().equalsIgnoreCase("AUH"))
			 {
				tableElements = doc.select("table#ctl00_ContentPlaceHolder1_gvTickets");
				tableElements.size();
			 }
			 Elements tableHeaderEles = tableElements.select("thead tr th");
			 System.out.println("headers");
			 for (int i = 0; i < tableHeaderEles.size(); i++) 
			 {
			    System.out.println(tableHeaderEles.get(i).text());
			    System.out.println("tableHeaderEles.size()========tableHeaderEles.size()======="+tableHeaderEles.size());
			 }
			// MyApp.frmMain.descriptionPane.setText(MyApp.frmMain.descriptionPane.getText()+"\n"+"Retrieving data...\n\n");
	
			 try{
	    			ResultSet rs = conn.createStatement().executeQuery("Select coalesce((max(doc_no)+1),1) max from gl_traffic");
	    			
	    			 if(rs.next())
	    			   {	
	    				 
	    				 dno=rs.getInt("max");
	    				 System.out.println("dnooooooooooooooooo"+dno);
	    				 xdoc=dno;
	    				 xdocs=xdocs+","+xdoc;
	    				
	    			   }
	    			 request.setAttribute("trxdocs", xdocs);
	    			 setDocs(String.valueOf(dno));
	    		}catch (Exception e2) {e2.printStackTrace();}
	    	
			 
			 
			 Elements tableRowElements = tableElements.select(":not(thead) tr");
			 String k="";
			 for (int i = 0; i < tableRowElements.size(); i++) 
			 {
				 System.out.println("tableRowElements-------------"+tableRowElements.size());
				 
				 if(getCmbtrafficsite().equalsIgnoreCase("AUH"))
				 {
					 k=String.valueOf((i+1));
					 if(Integer.parseInt(k)<10)
						 k="0"+k;
				 }
			// System.out.println("driver.getPageSource()--"+driver.getPageSource());
		 
		
			String aid="ctl00_ContentPlaceHolder1_gvTickets_ctl"+k+"_HyperLink1";
		    Element row = tableRowElements.get(i);
		    System.out.println("======rowrowrowrowrowrowrow==========="+row);
		    if(getCmbtrafficsite().equalsIgnoreCase("AUH"))
		    {
			    Element r=tableRowElements.get(1);
			    roi=r.select("td");
			    System.out.println("Roi - "+roi.get(0).text());
			    System.out.println("row---"+row.className());
				    if(row.className().equalsIgnoreCase("")||row.className().equalsIgnoreCase("gridViewFooter")
				    		||row.className().equalsIgnoreCase("gridViewPager"))
				    {
				    	continue;
				    }
		    }
		    rowItems = row.select("td");
		    System.out.println("@@@@@@@@@rowItems#############33"+rowItems);
		    if(rowItems.size()>0)
		    {
		    	if(getCmbtrafficsite().equalsIgnoreCase("DXB"))
		    	{
		    		rowItems = row.select("td");
		    		System.out.println("========rowItemsrowItemsrowItemsrowItemsrowItems========="+rowItems.size());
		    		
		    	}
		    }
		    String data="",disc="",Fees="",remark="";
		    String Time="",fine_Source="",regNo="",PlateCategory="",pcolor="",Amount="",Ticket_No="",Tick_violat="",DESC1="",type="";
			 java.sql.Date date = null,traffic_date=null;
			 System.out.println("========32323232323232323232323========="+rowItems.size());
		    for (int j = 0; j < rowItems.size(); j++) 
		    {	
//		    	if(rowItems.get(j).text().equalsIgnoreCase(null))
//			    	  return;
		       System.out.println("qwqwqwqwqwqwqwqwwqwqwqw"+rowItems.get(j).text());		       
		     
		       data=rowItems.get(j).text();
		      
		       if(getCmbtrafficsite().equalsIgnoreCase("AUH")){
		       
		       if(j==3)
		    	   Fees=data;
      		   if(j==5)
      			   disc=data;
      		   if(j==4)
      			   remark=data;
		       if(rowItems.get(j).text().equalsIgnoreCase("Details.."))
		       {
		    	   System.out.println("row--len-"+i);
//		    cmk	   descriptionPane.setText(descriptionPane.getText()+"\n"+"Retrieving Row#"+i+" - ");		    	   
//		    	   descriptionPane.update(descriptionPane.getGraphics());
		    	   //setTxtdescription(getTxtdescription()+"\n"+"Retrieving Row#"+i+" - ");
		    	   
	
		    	   new Actions(driver).moveToElement(driver.findElement(By.xpath("//a[@id='"+aid+"']")));
		    	   driver.findElement(By.xpath("//a[@id='"+aid+"']")).click();
		    	  
		    	   popupwindow=driver.getWindowHandle();
		    	   driver.switchTo().window(popupwindow);
		    	   //driver.switchTo().alert().dismiss();
		    	  	
		    	   detailsNewlyOpenedwindow(disc,Fees,srno+i,remark,i);
	      	     
		       }
		       }  
		       String vio="Black Points:";
		       if(getCmbtrafficsite().equalsIgnoreCase("DXB")){
		    	
		    	 System.out.println("================DXB========="+rowItems.get(j).text());
		      if(j==1){
		    	  System.out.println("=======j1======");
		    	   data = rowItems.get(j).text();
		    	 
		    	   data = rowItems.get(j).text().substring(0,rowItems.get(j).text().indexOf(' ') );
		    	 
		    		  
		    		   DateFormat   formatter = new SimpleDateFormat("dd/MM/yyyy");
					
					   data=(data.substring(0,2)+"/"+data.substring(3,5) +"/"+ data.substring(6,10));
					   
					   try {
						java.util.Date date1 = formatter.parse(data);
						   java.sql.Date dtvalue=new java.sql.Date(date1.getTime());
						  //fBrowse.cache.setData("traffic_date", dtvalue);
						   traffic_date=dtvalue;
						   System.out.println("==traffic_date==="+traffic_date);
					} catch (ParseException e) {e.printStackTrace();} 
					
					   Time=rowItems.get(j).text().substring( rowItems.get(j).text().lastIndexOf( ' ') + 1);
					   System.out.println("==Time==="+Time);
		       }
		      if(j==2){ 
		    	  System.out.println("=======j2======");
		    	  
		    	  
		    	  fine_Source=rowItems.get(j).text();
		    	  System.out.println("==fine_Source==="+fine_Source);
		       }
		      if(j==3){ 
		    	  System.out.println("=======j2======");
		    	  String s = rowItems.get(j).text();

		    	  s = s.substring(s.indexOf(' ') + 1);
		    	  s = s.substring(0, s.indexOf(' '));
		    	  String plc="",plcat="";
		    	  if(s.length()>3){
		    		  plc=rowItems.get(j).text().substring( rowItems.get(j).text().lastIndexOf( ' ') + 1);
		    		  plcat=s;
		    		  System.out.println("==plcat==="+plcat);
		    	  }  else{
		    		  plc=s;
		    		  plcat=rowItems.get(j).text().substring( rowItems.get(j).text().lastIndexOf( ' ') + 1);
		    		  System.out.println("==plcat==="+plcat);
		    	  }
		    	  regNo=rowItems.get(j).text().substring(0,rowItems.get(j).text().indexOf(' ') );
		    	  PlateCategory=plcat;
		    	  System.out.println("==PlateCategory==="+PlateCategory);
		    	  pcolor=plc;
		    	  System.out.println("==pcolor==="+pcolor);
					
		       }
		      if(j==4){ 
		    	  System.out.println("=======j4======");
		    	  Amount=rowItems.get(j).text();
		    	  System.out.println("==Amount==="+Amount);
		       }
		      if(j==5){ 
		    	  System.out.println("=======j5======");
					 vio=vio+rowItems.get(j).text();
					 System.out.println("==vio==="+vio);
		       }
		      if(j==6){ 
		    	  System.out.println("=======j6======");
		    	  Ticket_No=rowItems.get(j).text();
		    	  System.out.println("==Ticket_No==="+Ticket_No);
		       }
		       
			      if(j==7){ 
			    	  System.out.println("=======j7======");
			    	  vio=vio+rowItems.get(5).text()+"  "+rowItems.get(j).text();
			    	  Tick_violat=vio;
			    	  System.out.println("===Tick_violat===="+Tick_violat);
			    	  DESC1=vio;
			    	  System.out.println("===DESC1===="+DESC1);
			       }
			      java.util.Date dates=new  java.util.Date();
	      		   
     
			    date=ClsCommon.getSqlDate(dates);
			    System.out.println("===date======"+date);
			    type="TRF";
			    
			   
		       }
		       
		    }
		    System.out.println("=========rowItems=========="+rowItems+"=====rowItems.size()===="+rowItems.size());
		    if(rowItems!=null&&rowItems.size()>0&&getCmbtrafficsite().equalsIgnoreCase("DXB"))
		    {
		    SATdownloadDAO dao=new SATdownloadDAO();
      		 result=dao.trafficInsert(Ticket_No,traffic_date,Time,fine_Source,regNo,PlateCategory,pcolor,null,null,null,Double.parseDouble(Amount),null,null,DESC1,null,type,category,srno+i,ts,xdoc);
		    }
		    
		 }
		 if(getCmbtrafficsite().equals("AUH"))
		 {
			 System.out.println("Fine# - "+fineno);
			 if(!fineno.equalsIgnoreCase(""))
			 {
				 if(fineno.equalsIgnoreCase(roi.get(0).text()))
				 {
					 driver.quit();
	  		     }
				 else
				 {
					 fineno=roi.get(0).text();
					 System.out.println("Fine# Assign - "+fineno);
					
				 }
	  		 }
			 else	
			 if(fineno.equalsIgnoreCase(""))
			 {
				 fineno=roi.get(0).text();
				 System.out.println("Fine# Assign - "+fineno);
	  		 }
		 }
	}
	else if(getCategory().equalsIgnoreCase("salik"))	//salik
	{
			 Elements tabEl = null;
			 Elements tableRowElements=null;
			 if(v<=1)
			 {
//				 if(zone.equalsIgnoreCase("DXB"))
//					 System.out.println("driver.getPageSource()--"+doc);
//				 tableElements = doc.select("table#WorkSpace_Login1");
//				 driver.findElement(By.id("WorkSpace_Login1_UserName")).sendKeys(ts);
//				 driver.findElement(By.id("WorkSpace_Login1_Password")).sendKeys(pass);
//				 WebElement submit = driver.findElement(By.id("WorkSpace_Login1_LoginButton"));
				 
				 tableElements = doc.select("table#ctl00_WorkSpace_Login1");
				 driver.findElement(By.id("ctl00_WorkSpace_Login1_UserName")).sendKeys(ts);
				 driver.findElement(By.id("ctl00_WorkSpace_Login1_Password")).sendKeys(pass);
				 WebElement submit = driver.findElement(By.id("ctl00_WorkSpace_Login1_LoginButton"));

				 
				 submit.click();
	
				 doc=null;
			
				 doc= Jsoup.parse(driver.getPageSource());
				 if(doc!=null)
				 {
					  System.out.println("driver.getPageSource()--"+getCmbtype());
					 driver.findElement(By.linkText("Trips")).click();
//					 driver.findElement(By.id("ct100_WorkSpace_ctlCustAVIHistory_QuickDates1_rblQuickSearch_"+
//							 (getCmbtype().equalsIgnoreCase("lhrs")?"0":
//								 getCmbtype().equalsIgnoreCase("ldays")?"1":"2"))).click();
//							 				 (rbL24Hrs.isSelected()?"0":
//							 				  rbL7Days.isSelected()?"1":"2"))).click();
					 
					 driver.findElement(By.linkText("Trips")).click();
					 driver.findElement(By.id("ctl00_WorkSpace_ctlCustAVIHistory_QuickDates1_rblQuickSearch_"+
							 (getCmbtype().equalsIgnoreCase("lhrs")?"0":
								 getCmbtype().equalsIgnoreCase("ldays")?"1":"2"))).click();
//		cmnted by krish					 				 (rbL24Hrs.isSelected()?"0":
//							 				  rbL7Days.isSelected()?"1":"2"))).click();
					 
					 
					 //inputCaptcha("Retrieving Data...");
					 
		 
					 try{
			    			ResultSet rs = conn.createStatement().executeQuery("Select coalesce((max(doc_no)+1),1) max from gl_salik");
			    			
			    			 if(rs.next())
			    			   {	
			    				 
			    				 xsadoc=rs.getInt("max");
			    				 System.out.println("=xdocxdoc===xdocxdoc====xdocxdoc===="+xsadoc);
			    				 xdocs=xdocs+","+xsadoc;	
			    				 xsasrno=0;
			    			   }
			    			 request.setAttribute("xdocs", xdocs);
			    			 setDocs(String.valueOf(xsadoc));
			    			 
			    		}catch (Exception e2) {e2.printStackTrace();}
					 
					 doc=null;
		        
					 int count=0;
					 do
					 {  
						// Thread.sleep(1000);//--commented by krish
						 if(count%2==0)
		        		//  JOptionPane.showMessageDialog(this, MyLib.getUID("Please follow browser option!! and click search button"));
							 doc= Jsoup.parse(driver.getPageSource()); 
						 tabEl = doc.select("table#ctl00_WorkSpace_ctlCustAVIHistory_rgResult_ctl01");
						 count++;
					 }while(tabEl.isEmpty());
				 }
			 }
			 doc= Jsoup.parse(driver.getPageSource()); 
	     		tabEl = doc.select("table#ctl00_WorkSpace_ctlCustAVIHistory_rgResult_ctl01");
	     		
	     		System.out.println("ct100_WorkSpace_ctlCustAVIHistory_rgResult_ctl01"+tabEl);
	     		
          if(tabEl!=null){   
    
  
    			    tableRowElements = tabEl.select(":not(thead) tr");
    			    
					
    				
    				 for (int i = 0; i < tableRowElements.size(); i++) {
    					 
    					 String Trans="";
  				    	String Loc="";
  				    	String Dir="";
  				    	Double Amount=0.0;
  				    	 java.sql.Date dtvalue=null,dtripvalue=null;
  				    	 java.sql.Date sd = null;
  				    	 String plno="",tag="",src="";
    			
    					 if(i>tableRowElements.size())
    						 flag=false;
    				 
    				
    				    Element row = tableRowElements.get(i);
    				 
    				 rowItems = row.select("td");
    				    if(rowItems.size()>0){
    				    	
    				    		rowItems = row.select("td");
    				    //sBrowse.cache.Rows=sBrowse.cache.NewRow();
    				    
    				    	
    				    }
    				   
    				    for (int j = 0; j < rowItems.size(); j++) {
    				    	
    				       System.out.println("wewewewewewewewewewewewewewewewewewewewewewe   "+rowItems.get(j).text());
    				      if(rowItems.get(j).text().equalsIgnoreCase("No transactions to display."))
    				    	  return false;
    				     
    				       if(row.className().equalsIgnoreCase("")||row.className().equalsIgnoreCase("GridPager_Default"))
    				       {
    				    	   flag=true;
    				    	   dat = rowItems.get(j).text();
    				    	   System.out.println(dat+" - "+curPage+" - "+dat.substring(dat.indexOf("Displaying page")+15, dat.indexOf("of")));
    				    	   dat=dat.substring(dat.indexOf("of")+1);
    				    	   dat=dat.substring(0,dat.indexOf(','));
    				    	   dat=dat.substring(dat.indexOf(' ')+1);
    					       continue;
    					    }
    				  
    							
    				    	   if(j==0)
    				    	   {
    				    	      	 //sBrowse.cache.setData("Trans", rowItems.get(j).text()); 
    				    	   Trans=rowItems.get(j).text();
    				    	   System.out.println("Trans======================"+Trans);
    				    	   
    				    	   }
    				    	   
    				    	      	if(j==1){
    				    	      	String	 data = rowItems.get(j).text();//.substring(0,rowItems.get(j).text().indexOf(' ') );
    				    		    	 
    						    		  // java.sql.Date xidate=null;
    						    		  
    						    		   DateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
    						    	
    									 //  xidate=MyLib.getSqlDate(data);
    									   data=(data.substring(0,2)+"/"+data.substring(3,6) +"/"+ data.substring(7,11)+" "+data.substring(12,20));
    									 
    									
    									   
    									   time=rowItems.get(j).text().substring(rowItems.get(j).text().indexOf(' ')+1 );
    									   
    									   System.out.println("===time1111===time1111====time111====time111==="+time);
    									   
    									   salik_fdate=time;
    									   System.out.println("===tformat===tformat====tformat====tformat==="+tformat);

    									   											tformat=time.split(" ");
    									      									   timeappend=tformat[0].trim().substring(2,tformat[0].length());
    									      									   
    									      									   System.out.println("===tformat===tformat====tformat====tformat==="+tformat[1]);
    									      									   
    									      									   time=time.substring(0,time.indexOf(' '));
    									      									   //System.out.println("Testing before am/pm chk "+time);
    									      									   if(tformat[1].trim().equalsIgnoreCase("PM"))
    									      									   {
    									      										   //System.out.println("Time.parse(((((((((((((("+Time.parse(time)+12);
//    									      										   System.out.println("tformat[0]"+tformat[0].substring(0,2));
//    									      										   System.out.println("TAKING THE FIRST TIME"+(Integer.parseInt(tformat[0].substring(0,2))+12));
    									      										   if(!tformat[0].substring(0,2).equals("12"))
    									      										   { 
    									      										   time=(Integer.parseInt(tformat[0].trim().substring(0,2))+12)+"";
    									      										   time=time+timeappend;
    									      										   System.out.println("time=========="+time);
    									      										   }
    									      									   }
    									      									 
    									      									   
    									      									   if(tformat[1].trim().equalsIgnoreCase("AM"))
    									      									   {
    									      										   //System.out.println("Time.parse(((((((((((((("+Time.parse(time)+12);
    									      										   System.out.println("tformat[0]"+tformat[0].substring(0,2));
    									      										   System.out.println("TAKING THE FIRST TIME"+(Integer.parseInt(tformat[0].substring(0,2))-12));
    									      										   if(tformat[0].substring(0,2).equals("12"))
    									      										   { 
    									      										   time=(Integer.parseInt(tformat[0].trim().substring(0,2))-12)+"";
    									      										   time=time+timeappend;
    									      										   System.out.println("time=========="+time);
    									      										   }
    									      									   }

    									   System.out.println("===time===time====time====time==="+time);
    									   
    									   //sBrowse.cache.setData("salik_time", time);
    									   
//    									   Date date=new Date();
//    						      		   
//    							      		 
//    		cmnted by krish						      		        sd = MyLib.getSqlDate((date));
    							      		 //sBrowse.cache.setData("date", sd);
    							      	   try {
       										java.util.Date dat = formatter.parse(data);
       									
       										    dtripvalue=new java.sql.Date(dat.getTime());
       										    
       										    System.out
														.println("-============dtripvalue===================="+dtripvalue);
       										   
       										 // sBrowse.cache.setData("salik_date", dtvalue);
       									} catch (ParseException e) {e.printStackTrace();}
    				    	      	}
    				    	     //String plno="",tag="",src="";
    				    	      	if(j==3)
    				    	      	{
    				    	      		 String s = rowItems.get(j).text();

    				    	      		plno = s.substring(s.indexOf('-') + 1);
    				    	      		s=s.substring(0, s.indexOf('-'));
    				    	      		tag = s.substring(s.indexOf(':')+1);
    				    	      		src = tag.substring(tag.indexOf(' ')+1);
    				    	      		tag=tag.substring(0,tag.indexOf(' '));
    				    	      		plno = plno.substring(plno.indexOf(' ') + 1);
    				    	      		plno = plno.substring(plno.indexOf(' ') + 1);
    				    	      		
    				    	      		setTxtdescription(getTxtdescription()+"\n"+"Retrieving Row#"+i+"  "+"Retrieving page#"+j+"    TAG NO:"+tag+" - ");
    				    	      		textdescription=(getTxtdescription()+"\n"+"Retrieving Row#"+i+""  +"Retrieving page#"+j+"    TAG NO:"+tag+" - ");
    				    	      		System.out.println("textdescription"+textdescription);
    				    	      		log.log( Level.FINE, "processing {0} entries in loop",textdescription);
//    				    	      		 sBrowse.cache.setData("regNo", plno); 
//    				    	      		 sBrowse.cache.setData("Source", src); 
//    				    	      		 sBrowse.cache.setData("TagNo", tag); 
    				    	      	}
    				    	    	if(j==4)
    				    	    	{
    				    	        	// sBrowse.cache.setData("Location", rowItems.get(j).text()); 
    				    	    	Loc= rowItems.get(j).text();
    				    	    	}
    				    	    	if(j==5)
    				    	    	{
    				    	       	 //sBrowse.cache.setData("Direction", rowItems.get(j).text());
    				    	    	Dir= rowItems.get(j).text();
    				    	    	}
    				    	    	
    				    	    	if(j==2){
    				    	    		String	 data = rowItems.get(j).text();
    				    	    		  DateFormat   formatter = new SimpleDateFormat("dd/MMM/yy");
    				    	    		 data=(data.substring(0,2)+"/"+data.substring(3,6) +"/"+ data.substring(7,9));
    				    	    		java.util.Date date = null;
										try {
										 date = formatter.parse(data);
 										   dtvalue=new java.sql.Date(date.getTime());
 										  //sBrowse.cache.setData("sal_date",dtvalue); 
										} catch (ParseException e) {e.printStackTrace();}
    				    	    	}
    				    	    	if(j==6)
    				    	    	{
    				    	    		Amount=Double.parseDouble(rowItems.get(j).text());
    				    	        	 //sBrowse.cache.setData("Amount", rowItems.get(j).text()); 
    				    	    	}
    				    	    	
        				    	 
        				    	  // sBrowse.cache.setData("Salik_User", ts);
    				       }
    				      	   
						try {
							xsasrno++;
							SATdownloadDAO dao=new SATdownloadDAO();
							 
				      		 result=dao.salikInsert(ts,plno,tag,Trans,dtripvalue,Loc,Dir,src,Amount,time,dtvalue,xsadoc,sd,xsasrno,"",salik_fdate);
				      		 
				      		setDocs(String.valueOf(xsadoc));
							
											} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
    				    
    				 }
    				 
    				 }
  		    }
		 return  result;
		 
		 }
	
	private void detailsNewlyOpenedwindow(String disc, String fees, int k, String remark,int srno) 
	{
		
		String Time="",fine_Source="",regNo="",PlateCategory="",pcolor="",Ticket_No="",Tick_violat="",DESC1="",type="",LicenseNo="",LicenseFrom="",NotPayReason="",location="",fine="",remarks="",tcno="";
		java.sql.Date traffic_date=null,sd = null;
		Double Amount=0.0;
		System.out.println("detailsNewlyOpenedwindow");
	
	        Set<String> windowHandles1 = driver.getWindowHandles();
	        int size = windowHandles1.size();
	        System.out.println(size); 
	        for (String string : windowHandles1) 
	        {
	           driver.switchTo().window(string);

	           if(string.equals(defaultwindow))
	           { //driver.manage().window().setPosition(new Point(0, 0));
	               //System.out.println("On Main Window");
	               //Reporter.log("On Main Window");
	        	 
	           }
	           else
	           {
//	        	   org.openqa.selenium.Dimension screenResolution = new org.openqa.selenium.Dimension(-2000,-2000);
//	        	   driver.manage().window().setSize(screenResolution);
//	        	   driver.manage().window().setPosition(new Point(-2000, -2000));
	        	   ((JavascriptExecutor)driver).executeScript("window.resizeTo(0, 0);");
	        	   docDet= Jsoup.parse(driver.getPageSource());
	               Elements tabEl = null;
	               tabEl = docDet.select("table#dtTicDetails");
	             
	             	       		
	      		 Elements tableHeaderEles = tabEl.select("thead tr th");
	      		 System.out.println("headers");
	      		 for (int i = 0; i < tableHeaderEles.size(); i++) {
	      		    System.out.println(tableHeaderEles.get(i).text());
	      		 }
	      		 System.out.println();

	      		 Elements tableRowElements = tabEl.select("tr");
	      		 
	      		 tcno=ts;
	      		    for (int j = 0; j < tableRowElements.size(); j++) {
	      		    	
	      		     Element row = tableRowElements.get(j);
	      		     Elements rowItems = row.select("span");
		      		    String tddata="";
		      		  for (Element nextTurn : rowItems) {
		      		    System.out.println(nextTurn.text());
		      		  tddata=nextTurn.text();
		      		}
		      		if(j==0)
//		ck      		
//		      		  descriptionPane.setText(descriptionPane.getText()+"Fine# "+tddata);		      		
		      		//descriptionPane.update(descriptionPane.getGraphics());
		      		{
		      			Ticket_No=tddata;
		      		continue;
		      		}
		      		  if(j==3){
		      			String tddatadate = tddata;
		      		
		      		traffic_date=ClsCommon.getSqlDate(tddatadate);
		      		   
		      		  }
		      		 if(j==4)
		      		 {
		      			 Time=tddata;
		      		 }
		      		 if(j==2)
		      		 {
		      			fine_Source=tddata;
		      		 }
		      		 if(j==9){
		      			//pcolor=tddata;
		      			regNo=tddata;
		      		 }
		      		 if(j==11){
		      			 String cat="";
		      			 try{
		      				//Connection conn = ClsConnection.getMyConnection();
		      				String z="";
							 if(getCmbtrafficsite().equalsIgnoreCase("DXB"))
								 z="dubai";
							 else
								 z=cmbtrafficsite;
							 ResultSet rs= conn.createStatement().executeQuery("Select * from gl_webcat t where t.codeno='"+tddata+"' and emirate='"+z+"' ");
							 if(rs.next())
							 cat=rs.getString("itemno");
		      			 }catch (Exception e) {
						e.printStackTrace();
						}
	      			PlateCategory=tddata;
		      			pcolor=cat;
		      		 }
		      		
		      		if(j==16)
		      		{
		      			LicenseNo=tddata;
		      		}
		      		if(j==17)
		      		{
		      			LicenseFrom=tddata;
		      		}
		      		if(j==7)
		      		{
		      			NotPayReason=" ";
		      		}
		      		if(j==3)
		      		{
		      			Amount=Double.parseDouble(disc);
		      		}
		      		location=disc;
		      		fine=fees;
		      		remarks=remark;
		      		
		      		
		      		java.util.Date date=new java.util.Date();
		      		  
		      		 sd=ClsCommon.getSqlDate(date);
		      		type="TRF";
		      		System.out.println("END OF LOOP");
	      		    }
	      		  System.out.println("After LOOP");
	      		    SATdownloadDAO dao=new SATdownloadDAO();
	      		boolean result=dao.trafficInsert(Ticket_No,traffic_date,Time,fine_Source,regNo,PlateCategory,pcolor,LicenseNo,LicenseFrom,NotPayReason,Amount,location,fine,remarks,sd,type,category,srno,tcno,xdoc);
	      		setDocs(String.valueOf(xdoc));
	      		 
	      		  serno=k;
	      		  srno=srno+k;
	      		  
	      		    System.out.println();
	      		    
	      		  driver.close();
	      		  
	      		docDet=null;
	           }
	          
	         driver.switchTo().window(defaultwindow);
	         
	        }
	}
	
	public void loadData() throws IOException, InterruptedException
	{
		ArrayList list =new ArrayList();
		HashMap map =new HashMap();
		 
		try{
			
			
			
			System.out.println("Select Salik_User,Trans,salik_date,salik_time,sal_date,regNo,Source,TagNo,Location,Direction,Amount,date from gl_salik where Doc_no in ("+xdocs+")");
			
			ResultSet rsload = conn.createStatement().executeQuery("Select Salik_User,Trans,salik_date,salik_time,sal_date,regNo,Source,TagNo,Location,Direction,Amount,date from gl_salik where Doc_no in ("+xdocs+")");
			
			
			 while(rsload.next())
			 {	


			 }	
		}catch (Exception e2) {e2.printStackTrace();}
		
		
		
		
	}
	
/*	public void inputCaptcha(String xPmsg)
	{
		 String imgPath = "icons/captcha.png";
		 try
		 {
			 File temp=new File(imgPath);
			 if (temp.exists()){
				 System.out.println("temp.exists() - "+temp.exists());
			 }
				 temp.delete();
			 
			 //JDialog jd = new JDialog();
			 jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			 jd.setTitle("Input Captcha");
			 jd.setIconImage(Toolkit.getDefaultToolkit().getImage("icons/logogatetrans.png"));
			 jd.setPreferredSize(new Dimension(300,200));
		     			     
		     GWPanel pnlCaptcha = new GWPanel();
		     pnlCaptcha.setLayout(new BoxLayout(pnlCaptcha,BoxLayout.Y_AXIS));
		     pnlCaptcha.setAlignmentY(CENTER_ALIGNMENT);
		     pnlCaptcha.setAlignmentX(CENTER_ALIGNMENT);
		     
			 DownloadImage(By.xpath("//img[contains(@src,'CaptchaImage')]"),imgPath);
			 					
					driver.findElement(By.id("SearchCapthcaControl")).sendKeys(getCaptcha());
					doc= Jsoup.parse(driver.getPageSource()); 
		     		Elements tabEl = doc.select("table#WorkSpace_ctlCustAVIHistory_rgResult_ctl01");
		     		boolean xSrch = (tabEl.isEmpty()); 
		     		System.out.println(tabEl+" - "+(tabEl.isEmpty()));
					if (xSrch)
						driver.findElement(By.id("btnSearch")).click();
										
					try
					{
						WebElement we=null;
						int count=0;
						int cnt=0;
						do
						 {  
							
							 //Thread.sleep(1000);//--commented by krish
							 we = driver.findElement(By.id("ctl00_WorkSpace_ctlCustAVIHistory_RadAjaxPanelPlate"));
							 String style = we.getAttribute("style").trim();
							 System.out.println("fiiiiiiiinding we - "+style+" - "+style.isEmpty()+" - "+count);
							 if (!style.isEmpty())
								 we=null;
							 cnt++;
						 }while(we==null && cnt<10);
						count++;
						 
						//Thread.sleep(20000);
						we = driver.findElement(By.id("ct100_WorkSpace_ctlCustAVIHistory_lblErrorMessage"));
						String errMsg = we.getText().trim();
						System.out.println("Expired - "+errMsg);
						
						if (!errMsg.isEmpty())
						{														
							inputCaptcha("The code you typed has expired after 90 seconds.");
							return;
						}
					}catch(Exception e){e.printStackTrace();}						
				
		 }catch(Exception e){e.printStackTrace();}
}
		 
public void DownloadImage(By by,String loc)
{
	try
	{
		System.out.println("===DownloadImage=====");
		WebElement Image=driver.findElement(by);
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        int width=Image.getSize().getWidth();
        int height=Image.getSize().getHeight();
        BufferedImage img=ImageIO.read(screen);
        BufferedImage dest=img.getSubimage(Image.getLocation().getX(), Image.getLocation().getY(), width, height);
        ImageIO.write(dest, "png", screen);
        File temp=new File(loc);
        FileUtils.copyFile(screen,temp);
        System.out.println("===DownloadImage=LAST===="+img);
	}catch(Exception e){e.printStackTrace();}
}
*/	
	

}
