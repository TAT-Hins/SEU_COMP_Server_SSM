xquery version "1.0";
<NEWCATALOG>
	<advertising>
{
	for $data in doc('picture_30.xml')/CATALOG/picture
	where $data/basics/@sort="advertising"
	

	return<picture>
	      {$data /@id}
	      {$data /@name}
          {$data /basics/@type}
          {$data /basics/size}
	      {$data /basics/pixel}
	      {$data /basics/address}
	      </picture>
}
	</advertising>
	<item>
{
	for $data in doc('picture_30.xml')/CATALOG/picture
	where $data/basics/@sort="item"
	

	return<picture>
	      {$data /@id}
	      {$data /@name}
          {$data /basics/@type}
          {$data /basics/size}
	      {$data /basics/pixel}
	      {$data /basics/address}
	      </picture>
}
	</item>
	<logo>
{
	for $data in doc('picture_30.xml')/CATALOG/picture
	where $data/basics/@sort="logo"
	

	return<picture>
	      {$data /@id}
	      {$data /@name}
          {$data /basics/@type}
          {$data /basics/size}
	      {$data /basics/pixel}
	      {$data /basics/address}
	      </picture>
}
	</logo>
	<poster>
{
	for $data in doc('picture_30.xml')/CATALOG/picture
	where $data/basics/@sort="poster"
	

	return<picture>
	      {$data /@id}
	      {$data /@name}
          {$data /basics/@type}
          {$data /basics/size}
	      {$data /basics/pixel}
	      {$data /basics/address}
	      </picture>
}
	</poster>
	<technology>
{
	for $data in doc('picture_30.xml')/CATALOG/picture
	where $data/basics/@sort="technology"
	

	return<picture>
	      {$data /@id}
	      {$data /@name}
          {$data /basics/@type}
          {$data /basics/size}
	      {$data /basics/pixel}
	      {$data /basics/address}
	      </picture>
}
	</technology>
	<view>
{
	for $data in doc('picture_30.xml')/CATALOG/picture
	where $data/basics/@sort="view"
	

	return<picture>
	      {$data /@id}
	      {$data /@name}
          {$data /basics/@type}
          {$data /basics/size}
	      {$data /basics/pixel}
	      {$data /basics/address}
	      </picture>
}
	</view>
</NEWCATALOG>