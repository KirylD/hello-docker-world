# hello-docker-world

<b>The <i>web spring-boot app</i> in conjunction with <i>MySql database</i> is capable to</b>
1) accept an Http Get request on <i>'/'</i> or <i>/request</i> to write a request timestamp into the mysql database
2) accept an Http Get request on <i>'/all'</i> to read all persisted requests in database

<b>The goal of that is to have a kind of persistent data</b>, which 
1) should be persisted (in contrary to docker container live circle) 
2) and is considered as a Volume in term of Docker containers.
3) Exercise Docker-compose, Docker-network and Docker-volume

<h3>Docker-compose</h3>
Using <b>docker-compose</b> demonstrates working two containers 'web spring boot' and 'mysql database'
within single private network where only web app exposes its port and database is invisible outside of network.
MySql database uses volume.

<h3>See docker repository: https://hub.docker.com/repository/docker/kiryldrabysheuski/hello-docker-world </h3>
