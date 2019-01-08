xquery version "1.0";

<CATALOG>
{
for $data in doc('picture.xml')/CATALOG/picture
order by $data /@id/number() ascending

return$data
}
</CATALOG>