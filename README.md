﻿# hello-docker-world

The simple spring-boot app which can
1) accept an Http Get request on 'writeLastRequest' to write a request timestamp into the file 'custom_volume/timestamp.txt'
2) accept an Http Get request on 'readLastRequest' to read a last written timestamp from the same file 'custom_volume/timestamp.txt'

The goal of that is to have a kind of persistent data, which 
1) should be persisted (in contrary to docker container live circle) 
2) and could be considered as a Volume in term of Docker containers.
