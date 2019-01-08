xquery version "1.0";
<result>
{
for $data in doc('picture.xml')/CATALOG/picture
where ($data/basics/@type="jpg"or $data/basics/@type="gif")and $data/basics/size/number() < 20480


return $data}

</result>