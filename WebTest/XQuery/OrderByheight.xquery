xquery version "1.0";

<CATALOG>
{
for $data in doc('picture.xml')/CATALOG/picture
order by $data /basics/pixel/@height/number() 

return$data
}
</CATALOG>