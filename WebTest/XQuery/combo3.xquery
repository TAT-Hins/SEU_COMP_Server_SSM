xquery version "1.0";
<result>
{
for $data in doc('picture.xml')/CATALOG/picture
where ($data/basics/@sort="advertising"or $data/basics/@sort="type")and $data/basics/@type !="jpg"


return $data}

</result>