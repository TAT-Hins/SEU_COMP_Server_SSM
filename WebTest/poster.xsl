<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:svg="http://www.w3.org/2000/svg">
	<xsl:template match="/">
		<html>
			<head>
				<title>Data Sheet
				</title>
				<link rel="shortcut icon" href="picture/favicon.ico"></link>
				<link href="style.css" rel="stylesheet" type="text/css" media="all"></link>
				<link href="fonts.css" rel="stylesheet" type="text/css" media="all"></link>
			</head>
			<body>
				<div id="page" class="container">
					<div id="header">
						<div id="logo">
							<img src="picture/icon.jpg" height="75" width="75"/>
							<h1><xsl:value-of select="Information/GroupInfo/GroupName"/></h1>
						</div>
						<xsl:for-each select="Information/GroupInfo/GroupMember/Member">
							<xsl:apply-templates select="."/>
						</xsl:for-each>
					</div>
					<div id="main">
						<xsl:for-each select="Information/DataInfo/Content/picture">
							<xsl:apply-templates select="."/>
						</xsl:for-each>
					</div>
				</div>
			</body> 
		</html>
    </xsl:template>
	
	<xsl:template match="Information/GroupInfo/GroupMember/Member">
		<div id="member_{@no}">
			<p><xsl:value-of select="position"/>：</p>
			<table align="center" border="0">
				<tbody>
					<tr><td align="center"><img alt="" src="picture/{@name}.jpg" height="80" width="60"/></td></tr>
					<tr><td align="center" style="font-size: 14pt;"><xsl:value-of select="stuName"/></td></tr>
					<tr><td align="center"><xsl:value-of select="gender"/></td></tr>
					<tr><td align="center"><xsl:value-of select="@stuNum"/></td></tr>
					<tr><td align="center"><xsl:value-of select="phone"/></td></tr>
					<tr><td align="center"><xsl:value-of select="email"/></td></tr>
					<tr><td align="center"><font size="5" color="#F0F745"><b>负责内容：</b></font></td></tr>
					<tr><td align="center"><xsl:value-of select="responsibility"/></td></tr>
				</tbody>
			</table>
		</div>
	</xsl:template>
	
	<xsl:template match="Information/DataInfo/Content/picture"> 
		<div>
			<p><font size="8" color="F70909"><b>图片编号：<xsl:value-of select="@name"/></b></font></p>
			<img src="{basics/address}"/>
			<p>图片名称：<xsl:value-of select="@name"/>.<xsl:value-of select="basics/@type"/></p>
			<p>图片大小：<xsl:value-of select="basics/size"/><font size="4" color="F70909"><b>B</b></font></p>
			<p>图片尺寸：<xsl:value-of select="basics/pixel"/></p>
			<p>图片创建日期：<xsl:value-of select="time/create"/></p>
			<p>图片修改日期：<xsl:value-of select="time/modify"/></p>
			<p>图片访问日期：<xsl:value-of select="time/visit"/></p>
		</div><br/>
	</xsl:template>
 </xsl:stylesheet>
