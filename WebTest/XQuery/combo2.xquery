xquery version "1.0";
<result>
{
for $data in doc('picture.xml')/CATALOG/picture
where $data/basics/pixel/@height/number() >700and $data/basics/pixel/@width/number() >600


return $data}

</result>