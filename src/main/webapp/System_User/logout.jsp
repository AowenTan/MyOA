<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>退出My OA系统</title>
	<link href="../style/blue/logout.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<table border=0 cellspacing=0 cellpadding=0 width=100% height=100%>
		<tr>
			<td align=center>
				<div id=Logout>
					<div id=AwokeMsg><img id=LogoutImg src="../style/blue/images/logout/logout.gif" border=0 /><img id=LogoutTitle src="../style/blue/images/logout/logout1.gif" border=0 /></div>
					<div id=LogoutOperate>
                    <img src="../style/blue/images/logout/logout2.gif" border=0 /> <a href="loginUI.jsp">继续登录使用系统</a>
                    <img src="../style/blue/images/logout/logout3.gif" border=0 /> <a href="javascript: window.close();">退出当前系统</a>
                    </div>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
