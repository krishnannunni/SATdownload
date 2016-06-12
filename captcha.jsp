<%-- <jsp:include page="../../../../includes.jsp"></jsp:include> --%>
<% String contextPath=request.getContextPath();
System.out.println("contextPath===="+contextPath);%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
</head>
 <body bgcolor="#E0ECF8">
<div id=btnok>
<table width="100%" >
  <tr >
  <td width="7%" align="right">Captcha</td>
    <td width="30%"><input type="text" id="txtcaptcha" name="txtcaptcha" style="width:40%;" value='<s:property value="txtcaptcha"/>'/></td>
    </tr>
    <tr>
   <td align="right"><input type="button" name="btnOk" id="btnOk" class="myButton" value="OK" onclick="funUpdate();"></td>
   <td>
   <tr><div id="Captcha">
   <img src="<%=contextPath%>/icons/captcha.png" width="100" height="120" alt="img"/>
		</div></tr>
   </td>
   </tr>
   </table>
   </div>
   </body>
   </html>
