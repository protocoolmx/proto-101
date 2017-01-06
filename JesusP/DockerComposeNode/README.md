# Docker Compose Demo

This is just a demo about how getting started tou use Docker Compose with Node JS and MySQL using a sails project

# Install Docker Engine

First we need to install Docker.

```
$ sudo apt-get update
$ sudo apt-get install linux-image-extra-$(uname -r) linux-image-extra-virtual
$ sudo apt-get install docker-engine
```
https://docs.docker.com/engine/installation/linux/ubuntulinux

Start Docker daemon
```
$ sudo service docker start
```
# Install Docker Compose

Once we have Docker engine installed we procced to install Docker Compose via pip.

```
$ pip install docker-compose
```

# Commands

## Run Demo

After install Docker Engine and Docker Compose we are ready to run this demo by running the next command.

```
$ docker-compose up
```
Note: If you want to run your services in the background, you can pass the -d flag to docker-compose and the --build flag for rebuilding the project, also you can add --abort-on-container-exit flag which stop docker-compose when some container exits. 

## Stop Demo

```
$ docker-compose stop
```

If you want to remove all data in containers when stopping containers you must user

```
$ docker-compose down --volumes
```

## Environment variables

You can see environment variables of a specific service by running this command

```
$ docker-compose run serviceName env
```
