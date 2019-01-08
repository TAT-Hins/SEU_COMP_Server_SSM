xquery version "1.0";
<result>
{
for $data in doc('picture.xml')/CATALOG/picture
where $data/basics/@type!="gif"and $data/basics/size/number() > 100000 and ($data/basics/@sort="poster"or $data/basics/@sort="logo") and $data/basics/pixel/@height/number() >400 and $data/basics/pixel/@height/number() < 800

order by $data /@id/number() ascending

return $data}

</result>