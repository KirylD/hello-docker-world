# hello-docker-world


<h3>22.01.2020: Configure kubernetes in a declarative way using '.yaml' files.</h3>
1) mysql-pv.yaml is responsible to create a PersistentVolume within the PersistentVolumeClaim
2) mysql_deployment.yaml is in charge of deploying mysql connected to previously create PersistentVolume
3) spring_boot.yaml is to deploy exposed 'spring-boot' app connected to 'mysql' database,
 which is reachable only within the pod.
<hr>

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
