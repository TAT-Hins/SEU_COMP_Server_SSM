xquery version "1.0";
<NEWCATALOG>
<jpg>
{
	for $data in doc('picture_30.xml')/CATALOG/picture
	where $data/basics/@type="jpg"
	

	return<picture>
	      {$data /@id}
	      {$data /@name}
          {$data /basics/@sort}
          {$data /basics/size}
	      {$data /basics/pixel}
	      {$data /basics/address}
	      </picture>
}
</jpg>
<png>
{
	for $data in doc('picture_30.xml')/CATALOG/picture
	where $data/basics/@type="png"
	

	return<picture>
	      {$data /@id}
	      {$data /@name}
          {$data /basics/@sort}
          {$data /basics/size}
	      {$data /basics/pixel}
	      {$data /basics/address}
	      </picture>
}
</png>
<gif>
{
	for $data in doc('picture_30.xml')/CATALOG/picture
	where $data/basics/@type="png"
	

	return<picture>
	      {$data /@id}
	      {$data /@name}
          {$data /basics/@sort}
          {$data /basics/size}
	      {$data /basics/pixel}
	      {$data /basics/address}
	      </picture>
}
</gif>
</NEWCATALOG>