# hello-docker-world

<b>The simple spring-boot app which can</b>
1) accept an Http Get request on <i>'writeLastRequest'</i> to write a request timestamp into the file 'custom_volume/timestamp.txt'
2) accept an Http Get request on <i>'readLastRequest'</i> to read a last written timestamp from the same file 'custom_volume/timestamp.txt'

<b>The goal of that is to have a kind of persistent data</b>, which 
1) should be persisted (in contrary to docker container live circle) 
2) and could be considered as a Volume in term of Docker containers.

<h4>To build and package the source code into jar</h4>
<i>mvn clean install</i>

<h4>To build a docker image</h4> 
<i>docker image build -t kiryldrabysheuski/hello-docker-world .</i>
