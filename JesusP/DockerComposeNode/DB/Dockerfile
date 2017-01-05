FROM mysql:5.7.15

#Import Database && Tables
ADD data/database.sql /docker-entrypoint-initdb.d/01-database.sql
ADD data/user_data.sql /docker-entrypoint-initdb.d/03-user_data.sql

#ADD user and set permissions
ADD data/config.sql /docker-entrypoint-initdb.d/02-config.sql
