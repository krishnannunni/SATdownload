<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.util.logging.Logger" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="com.SATdownload.SATdownloadAction"%>
<!DOCTYPE html>
<html>
<%--  <% String contextPath=request.getContextPath();%>--%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>GatewayERP(i)</title>
<jsp:include page="../../includes.jsp"></jsp:include>

<script type="text/javascript">
	$(document).ready(function() {
		 
		 $("#jqxStartDate").jqxDateTimeInput({ width: '125px', height: '15px', formatString:"dd.MM.yyyy"});
		 $("#jqxEndDate").jqxDateTimeInput({ width: '125px', height: '15px', formatString:"dd.MM.yyyy"});
		 $('#unameWindow').jqxWindow({width: '30%', height: '58%',  maxHeight: '70%' ,maxWidth: '51%' , title: 'Search',position: { x: 300, y: 87 } , theme: 'energyblue', showCloseButton: true});
		   $('#unameWindow').jqxWindow('close');
		   $('#fleetWindow').jqxWindow({width: '51%', height: '58%',  maxHeight: '70%' ,maxWidth: '51%' , title: 'Search',position: { x: 300, y: 87 } , theme: 'energyblue', showCloseButton: true});
		   $('#fleetWindow').jqxWindow('close');
		   /* $('#loadsalikdata').jqxWindow({width: '51%', height: '58%',  maxHeight: '70%' ,maxWidth: '51%' , title: 'Search',position: { x: 300, y: 87 } , theme: 'energyblue', showCloseButton: true});
		   $('#loadsalikdata').jqxWindow('close'); */
		   
		   
	});
</script>

<style>
.hidden-scrollbar {
  overflow: auto;
  height: 530px;
}
</style>
<script type="text/javascript">

function fundisable(){
	
	//alert("hahahahahahahahaha");
	
	if (document.getElementById('radio_salik').checked) {
		 $("table#traffic input").prop("disabled", true);
		 $("table#traffic select").prop("disabled", true);
		 $('#radio_traffic').attr('disabled', false);
		 $('#chck_salikautomatic').attr('checked', true);
		 $('#chck_trafficautomatic').attr('checked', false);
		 $("table#salik input").prop("disabled", false);
		/*  $("table#salik select").prop("disabled", false); */
		 $('#jqxStartDate').jqxDateTimeInput({ disabled: true});
		 $('#jqxEndDate').jqxDateTimeInput({ disabled: true});
		  if(document.getElementById('chck_salikautomatic').checked) {
			 $("table#salik input").prop("disabled", true);
			 /* $("table#salik select").prop("disabled", true); */
			 $("#cmbsaliksite").attr("disabled", false);
			 $("#chck_salikautomatic").attr("disabled", false);
			 $('#jqxStartDate').jqxDateTimeInput({ disabled: true});
			 $('#jqxEndDate').jqxDateTimeInput({ disabled: true});
			 $("#txtusername").attr("disabled", false);
			 $("#radio_salik").attr("disabled", false);
			 
		 }
		  if((document.getElementById('cmbtype').value=='lcdays')) {
			  $('#jqxStartDate').jqxDateTimeInput({ disabled: false});
				 $('#jqxEndDate').jqxDateTimeInput({ disabled: false});
			 }
		  $('#loadsalikdata').show();
		  $('#loadtrafficdata').hide();
		  
		}
	 else if (document.getElementById('radio_traffic').checked) {
		 $("table#salik input").prop("disabled", true);
		 $("table#salik select").prop("disabled", true);
		 $("#chck_salikautomatic").attr("checked", false);
		 $('#radio_salik').attr('disabled', false);
		 $("table#traffic input").prop("disabled", false);
		 $("table#traffic select").prop("disabled", false);
		 $('#jqxStartDate').jqxDateTimeInput({ disabled: true});
		 $('#jqxEndDate').jqxDateTimeInput({ disabled: true});
		 if ((document.getElementById('chck_trafficautomatic').checked)) {
			 $("table#traffic input").prop("disabled", true);
			 $("table#traffic select").prop("disabled", true);
			 $("#cmbtrafficsite").attr("disabled", false);
			 $("#chck_trafficautomatic").attr("disabled", false);
			 $("#radio_traffic").attr("disabled", false);
			// $("#chck_trafficfileno").attr("disabled", false);
			 //$("#chck_trafficfileno").attr("readonly", true);
			 
		 }
		 if ((document.getElementById('chck_trafficfileno').checked)) {
			 $('#txttrafficplatecode').attr('disabled', true);
			 $('#txttrafficcategory').attr('disabled', true);
			 $('#txttrafficauthority').attr('disabled', true);
			 
		 }
		 $('#loadsalikdata').hide();
		  $('#loadtrafficdata').show();
		 
		}
	 }

function funSearchdblclick(){
	//alert("funSearchdblclick");
  	 //alert("here");

	//  $('#txtaccname').dblclick(function(){
		  var url=document.URL;
		     var reurl=url.split("com");
		     unameSearchContent('satUsernameSearch.jsp');
		//  });  
}

function getUname(event){
	//alert("getUname");
    var x= event.keyCode;
    if(x==114){
  	 //alert("here");
   	 var url=document.URL;
	     var reurl=url.split("com");
	     unameSearchContent('satUsernameSearch.jsp');
    }
    else{
     }
    }
    
function unameSearchContent(url) {
	//alert("unameSearchContent");
	  $('#unameWindow').jqxWindow('open');
		 $.get(url).done(function (data) {
			 //alert(data);
		$('#unameWindow').jqxWindow('setContent', data);
	}); 
	}
	

function searchfleetclick(){
	//alert("funSearchdblclick");
  	 //alert("here");

	//  $('#txtaccname').dblclick(function(){
		  var url=document.URL;
		     var reurl=url.split("com");
		    // alert("searchfleetclick[0]"+reurl[0]);
		     fleetSearchContent('satFleetSearch.jsp');
		//  });  
}

function getFleet(){
	//alert("getFleet");
    var x= event.keyCode;
    if(x==114){
  	 //alert("here");
   	 var url=document.URL;
	     var reurl=url.split("com");
	     //alert("getFleet[0]"+reurl[0]);
	     fleetSearchContent('satFleetSearch.jsp');
    }
    else{
     } 
}

function getBrowser(){
	
	if (document.getElementById('radio_salik').checked) {
		setTimeout(function() {alert('please follow browser option!!!!!');},30000);
}
}

function fleetSearchContent(url) {
	//alert("fleetSearchContent");
	  $('#fleetWindow').jqxWindow('open');
		 $.get(url).done(function (data) {
			// alert(data);
		$('#fleetWindow').jqxWindow('setContent', data);
	}); 
	}
    
function setValues() {
	//alert($('#hiddencategory').val());
	
	/* if(document.getElementById("docs").value!="0")
			   {
				   var indexVal =document.getElementById("docs").value;
				    //alert("==================="+indexVal);
				    if(indexVal>0&&$('#hiddencategory').val()=='salik'){
				    	//alert("======23232323232323232============="+indexVal);
				         $("#loadsalikdata").load("SATloadDetails.jsp?xdocs="+indexVal);
				         $('#loadsalikdata').show();
				    	
				    } 
				    if(indexVal>0&&$('#hiddencategory').val()=='traffic'){
				    	//alert("======23232323232323232=====traffic========"+indexVal);
				    	
				         $("#loadtrafficdata").load("SATTrafficloadDetails.jsp?trxdocs="+indexVal);
				    	
				    }
			   } */
	
	//alert($('#hiddencategory').val());
	if($('#hiddencategory').val()=='salik'){
		document.getElementById("radio_salik").checked = true;
		$('#loadtrafficdata').hide();
		var indexVal =document.getElementById("docs").value;
		$("#loadsalikdata").load("SATloadDetails.jsp?xdocs="+indexVal);
        $('#loadsalikdata').show();
	}
	if($('#hiddencategory').val()=='traffic'){
		document.getElementById("radio_traffic").checked = true;
		$('#loadsalikdata').hide();
		var indexVal =document.getElementById("docs").value;
		//alert("trxdocstrxdocstrxdocstrxdocstrxdocs"+indexVal);
		 $("#loadtrafficdata").load("SATTrafficloadDetails.jsp?trxdocs="+indexVal);
		 $('#loadtrafficdata').show();
	}
	
}

</script>

</head>
<body onload="setValues();">
<form  id="frmSATdownload" action="processSATdownload" method="post" >
<div id="mainBG" class="homeContent" data-type="background">

<div  class='hidden-scrollbar'>
<table width="100%">
<tr>
<td width="50%">
<fieldset><legend>Salik</legend>
<table width="100%" id="salik">
    <tr>
    <td width="11%"><input type="radio" id="radio_salik" name="category" value="salik" onchange="fundisable();">Salik</td>
    <td width="11%"><input type="hidden" id="hiddencategory" name="hiddencategory" value='<s:property value="hiddencategory"/>'></td>
    <td width="25%" align="right">Site</td>
    <td width="36%"><select id="cmbsaliksite" name="cmbsaliksite" style="width:40%;" value='<s:property value="cmbsaliksite"/>'>
    <option value="DXB">DXB</option></select>
    <input type="hidden" id="hidcmbsaliksite" name="hidcmbsaliksite" value='<s:property value="hidcmbsaliksite"/>'/> </td>
    <td width="38%" align="center"><input type="checkbox" id="chck_salikautomatic" name="chck_salikautomatic" value="salikautomatic" onchange="fundisable();">&nbsp;Automatic</td>
  </tr>
  <tr>
 <td colspan="4">
<fieldset>
<table width="100%">
  <tr>
    <td align="right" width="12%">Time-Period</td>
    <td width="18%"><select id="cmbtype" name="cmbtype" style="width:100%;" value='<s:property value="cmbtype"/>' onchange="fundisable();">
    <option value="ldays">Last 7 Days</option><option value="lhrs">Last 24 Hours</option><option value="lcdays">Custom Days</option></select>
    <input type="hidden" id="hidcmbtype" name="hidcmbtype" value='<s:property value="hidcmbtype"/>'/> </td>
    <td width="24%" align="right">Start Date</td>
    <td width="23%"><div id="jqxStartDate" name="jqxStartDate" value='<s:property value="jqxStartDate"/>'></div>
    <input type="hidden" id="hidjqxStartDate" name="hidjqxStartDate" value='<s:property value="hidjqxStartDate"/>'/></td>
    <td width="11%" align="right">End Date</td>
    <td width="20%"><div id="jqxEndDate" name="jqxEndDate" value='<s:property value="jqxEndDate"/>'></div>
    <input type="hidden" id="hidjqxEndDate" name="hidjqxEndDate" value='<s:property value="hidjqxEndDate"/>'/></td>
  </tr>
  <tr>
    <td width="9%" align="right">Username</td>
    <td colspan="4"><input type="text" id="txtusername" name="txtusername" style="width:40%;" value='<s:property value="txtusername"/>' ondblclick="funSearchdblclick();" onkeydown="getUname(event);" readonly placeholder="Press F3 to Search" /></td>
   </tr>
</table>
</fieldset>
</td></tr>
<tr><td colspan="4">
<fieldset>
<table width="100%">
  <tr>
    <td width="7%" align="right">Fleet No.</td>
    <td width="48%"><input type="text" id="txtsalikfleetno" name="txtsalikfleetno" style="width:40%;" value='<s:property value="txtsalikfleetno"/>' ondblclick="searchfleetclick();" onkeydown="getFleet(event);" readonly="true" placeholder="Press F3 to Search" /></td></td>
    <td width="10%" align="right">Salik Tag</td>
    <td width="35%"><input type="text" id="txtsaliktagno" name="txtsaliktagno" style="width:40%;" value='<s:property value="txtsaliktagno"/>'/></td>
    </tr>
   <%--  <tr>
    <td align="right">Category</td>
    <td><input type="text" id="txtsalikcategory" name="txtsalikcategory" style="width:50%;" value='<s:property value="txtsalikcategory"/>'/></td>
    <td align="right">Authority</td>
    <td><input type="text" id="txtsalikauthority" name="txtsalikauthority" style="width:50%;" value='<s:property value="txtsalikauthority"/>'/></td>
  </tr> --%>
</table>
</fieldset>
</td></tr></table>
</fieldset>
</td>

<td width="50%">
<fieldset><legend>Traffic</legend>
<table width="100%" id="traffic">
  <tr>
    <td width="11%"><input type="radio" id="radio_traffic" name="category" value="traffic" onchange="fundisable();">Traffic</td>
    
    <td width="25%" align="right">Site</td>
    <td width="30%"><select id="cmbtrafficsite" name="cmbtrafficsite" style="width:40%;" value='<s:property value="cmbtrafficsite"/>' >
    <option value="AUH">AUH</option><option value="DXB">DXB</option></select></select>
    <input type="hidden" id="hidcmbtrafficsite" name="hidcmbtrafficsite" value='<s:property value="hidcmbtrafficsite"/>'/> </td>
    <td width="15%" align="center"><input type="checkbox" id="chck_trafficfileno" name="chck_trafficfileno" value="trafficfileno" onchange="fundisable();">&nbsp;Traffic File No.</td>
    <td width="30%" align="center"><input type="checkbox" id="chck_trafficautomatic" name="chck_trafficautomatic" value="trafficautomatic" onchange="fundisable();">&nbsp;Automatic</td>
  </tr>
  <tr>
    <td colspan="5">
    <fieldset>
    <table width="100%">
  <tr>
    <td width="7%" align="right">plate No.</td>
    <td width="48%"><input type="text" id="txttrafficplateno" name="txttrafficplateno" style="width:40%;" value='<s:property value="txttrafficplateno"/>'/></td>
    <td width="10%" align="right">Plate Code</td>
    <td width="35%"><input type="text" id="txttrafficplatecode" name="txtsalikplatecode" style="width:40%;" value='<s:property value="txttrafficplatecode"/>'/></td>
    </tr>
    <tr>
    <td align="right">Category</td>
    <td><input type="text" id="txttrafficcategory" name="txttrafficcategory" style="width:50%;" value='<s:property value="txttrafficcategory"/>'/></td>
    <td align="right">Authority</td>
    <td><input type="text" id="txttrafficauthority" name="txttrafficauthority" style="width:50%;" value='<s:property value="txttrafficauthority"/>'/></td>
  </tr>
</table>
<br/><br/><br/><br/><br/>
</fieldset>
    </td>
  </tr>
</table>
</fieldset>
</td>
</tr>
<tr>
    <td colspan="4" align="center"><button class="myButton" type="submit" id="btnGo" name="btnGo" onClick="getBrowser()" >Go</button> </td>
  </tr>
<tr>
<td>
<br/>
</td>
</tr>
<tr>
<td>
<div id="loadcaptcha">
				<jsp:include page="captcha.jsp"></jsp:include> 
			</div> </td>
<%-- <td colspan="2"><textarea id="txtdescription" name="txtdescription" rows="5" style="width:98%;resize:none;"><s:property value="txtdescription"/></textarea></td> --%>
<td><input type="hidden" type="textbox" id="docs" name="docs" style="width:50%;" value='<s:property value="docs"/>'/></td></td>

</tr>



</table>
<tr><div id="loadsalikdata">
				<jsp:include page="SATloadDetails.jsp"></jsp:include> 
			</div></tr>
		
<tr><div id="loadtrafficdata">
				 <jsp:include page="SATTrafficloadDetails.jsp"></jsp:include> 
				</div></tr>
</div>
</div>

<div id="unameWindow">
				<div></div><div></div>
				</div> 
<div id="fleetWindow">
				<div></div><div></div>
				</div>
				</form>
</body>
</html>