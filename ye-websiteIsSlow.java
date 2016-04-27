1.unoptimized images
  PNG files are best used for icons and logos while JPEG is preferred for photos.
  Bacause PNG support transparency while JPEGS do not. 
2.Content served without HTTP compression
  Enabling HTTP compression on your webserver can dramatically reduce the size of the downloaded page
  significantly improving load time.
3. Combinable CSS images
  Browsers make an individual HTTP request for every background image specified in your CSS pages. 
  It is not uncommon for over half of your total HTTP requests from a single web page to be used for loading background CSS images. 
  By combining related images into a small number of CSS sprites, 
  you can significantly reduce the number of HTTP requests made during your page load

4.images without caching information
  HTTP Caching allows the browser to store a copy of an image for a period of time, 
  preventing the browser from reloading the same image on subsequent page loads and thus dramatically increasing performance. 
  To cache your images, update your webserver configuration to provide an Expires header to your image responses from the server. 
  For images that do not change often, you should specify a “far future” Expires header, typically a date 6 months to a year out from the current date.
  Note that even with a far future Expires date, you can always change the image later by modifying the referenced filename using versioning, 
  for example MyImage.png becomes MyImage_v2.png
5.Domain Sharding Not Implemented
  Most browsers typically support 2-4 concurrent downloads of static resources for each hostname. Therefore, if your page is loading many static resources from the same hostname, the browser will bottleneck in a stair-step fashion downloading all the content. By splitting resources across 2 different domains, you can effectively double browser throughput downloading the required links.

Note that it may be administratively difficult to physically move your files to different hostnames, so as a clever “trick” you can utilize DNS CNAME records to map different hostnames to the same origin. For example, static1.example.com and static2.example.com could both map to static.example.com, thus prompting the browser to load twice as many links concurrently as before, without requiring you physically move the files on the server. For more information see Maximizing Parallel Downloads in the Carpool Lane

Of course too much concurrency has its own drawbacks on performance, so testing should be done to find the optimal balance.