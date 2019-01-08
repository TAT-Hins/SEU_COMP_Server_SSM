<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" version="1.0" encoding="gb2312" standalone="yes"/>

  <xsl:template match="/">  
  <html>  
	  <head>  
	  <title>数据验证</title>  
	  </head>  
  <body> 
  <p>错误数据将用粉底展示</p> 
  <table border="1">
     <tr>
        <th>name</th>
        <th>type</th>
        <th>height</th>
        <th>wedth</th>
        <th>size</th>
        <th>modify time</th>
     </tr>
	 <xsl:for-each select="//CATALOG/picture">
	 <xsl:sort select="@name"/>
	 <tr>
		<th><xsl:value-of select="@name"/></th>
		<xsl:for-each select="basics">
	    <xsl:choose>
          <xsl:when test="./@type='jpg'">
            <th><xsl:value-of select="./@type"/></th>
          </xsl:when>
          <xsl:when test="./@type='png'">
            <th><xsl:value-of select="./@type"/></th>
          </xsl:when>
          <xsl:when test="./@type='gif'">
            <th><xsl:value-of select="./@type"/></th>
          </xsl:when>
          <xsl:otherwise>
            <th bgcolor="#ff00ff"><xsl:value-of select="./@type"/></th>
          </xsl:otherwise>
        </xsl:choose>
        
        <xsl:for-each select="pixel">
        <xsl:choose>
          <xsl:when test="./@height &gt; 10000">
            <th bgcolor="#ff00ff">
            <xsl:value-of select="./@height"/></th>
          </xsl:when>
          <xsl:when test="./@height &lt; 0">
            <th bgcolor="#ff00ff">
            <xsl:value-of select="./@height"/></th>
          </xsl:when>
          <xsl:otherwise>
            <th><xsl:value-of select="./@height"/></th>
          </xsl:otherwise>
        </xsl:choose>
        
        <xsl:choose>
          <xsl:when test="./@width &gt; 10000">
            <th bgcolor="#ff00ff">
            <xsl:value-of select="./@width"/></th>
          </xsl:when>
          <xsl:when test="./@width &lt; 0">
            <th bgcolor="#ff00ff">
            <xsl:value-of select="./@width"/></th>
          </xsl:when>
          <xsl:otherwise>
            <th><xsl:value-of select="./@width"/></th>
          </xsl:otherwise>
        </xsl:choose>
        
        </xsl:for-each>
        
        <th><xsl:value-of select="size"/></th>
        
        </xsl:for-each>
        
        <xsl:for-each select="time/modify">
        <xsl:choose>
          <xsl:when test="./@year &lt; 1970">
            <th bgcolor="#ff00ff">
            <xsl:value-of select="."/></th>
          </xsl:when>
          <xsl:otherwise>
          
        <xsl:choose>
          <xsl:when test="./@month &gt; 12">
            <th bgcolor="#ff00ff">
            <xsl:value-of select="."/></th>
          </xsl:when>
          <xsl:when test="./@month &lt; 0">
            <th bgcolor="#ff00ff">
            <xsl:value-of select="."/></th>
          </xsl:when>
          <xsl:otherwise>
            
         <xsl:choose>
          <xsl:when test="./@day &gt; 31">
            <th bgcolor="#ff00ff">
            <xsl:value-of select="."/></th>
          </xsl:when>
          <xsl:when test="./@day &lt; 0">
            <th bgcolor="#ff00ff">
            <xsl:value-of select="."/></th>
          </xsl:when>
          <xsl:otherwise>
            <th><xsl:value-of select="."/></th>
          </xsl:otherwise>
        </xsl:choose>
        
          </xsl:otherwise>
        </xsl:choose>
        
          </xsl:otherwise>
        </xsl:choose>
   
        </xsl:for-each>
     </tr>
     </xsl:for-each>
  </table>
	 </body>
	 </html>
    </xsl:template>
</xsl:stylesheet>
