# Database  setup

## Install PostgreSQL + PostGIS

First we need to install PostgreSQL and PostGIS. PostgreSQL is an open source object-relational database system and PostGIS is an extensions to work with geographic information on PostgreSQL.

```
$ sudo apt-get install postgresql postgresql-contrib postgis
```

## Create user

Now we need to create the user to work with the database.

Create Linux user.

```
$ sudo useradd -M -p password map_provider_user
$ sudo su - postgres
$ psql
```

Create PostgreSQL user.

```
postgres=# CREATE USER map_provider_user WITH PASSWORD 'password';
```

## Create database

Once we have created the user, is time to create the database.

```
$ sudo su - postgres
$ psql
```

Create database.

```
postgres=# CREATE DATABASE map_provider;
```

## Add user to the database

On this point we have created a database and a user, now we need to attach the user to the database and give him some privileges over the database.

```
$ sudo su - postgres
$ psql
```

Grant `map_provider_user` all privileges on `map_provider` database.

```
postgres=# GRANT ALL PRIVILEGES ON DATABASE map_provider to map_provider_user;
```

## Test using the user `map_provider_user`

Now we are goint to test if the user can login to the database.

```
$ sudo su - map_provider_user
$ psql -d map_provider -U map_provider_user
```

## Adding postgis extension

Adding postgis extension to the database, is necessary to do this with a `postgres` superuser.

```
$ sudo su - postgres
$ psql -d map_provider -U postgres
```

Enable `postgis` extension on `map_provider` database.

```
map_provider=# CREATE EXTENSION postgis;
```

## Using sh scripts

To make this process easier first we open a root session. 
```
$ sudo su
```
Script to run all steps above.

PostgreSQL + PostGIS.

```
$ cd db
$ ./install_postgres_postgis.sh
```

Create user, database, etc.

```
$ cd db
$ ./install_user_database.sh <USER> <PASSWORD> <DATABASE>
```

Example

The user, password and database are `user_test`, `123`, and `database_test`.  

```
$ cd db
$ ./install_user_database.sh user_test 123 database_test
```
## Importing .shp files to PostgreSQL

Unzip `shp.zip` file from `db/layers` dir.

```
$ cd db
$ unzip layers/shp.zip -d layers
```

**NOTE:** The `shp.zip` is managed as Git LFS file on this repo.

Importing layers from `db/layers/shp` dir to the database in PostgreSQL. To know about shapefiles go to [arcgis-online](https://doc.arcgis.com/en/arcgis-online/reference/shapefiles.htm "arcgis-online reference").

```
$ cd db
$ ./import_layers.sh <USER> <PASSWORD> <DATABASE> <PATH>
```

Example

For this example the shapefiles are in `db/layers/shp` dir, our user, password and database are `user_test`, `123`, and `database_test`. The user, password and database are the same we created before.  

```
$ cd db
$ ./import_layers.sh user_test 123 database_test layers/shp 
```