#!/bin/bash

# To run this scritp:
# ./install_setup_postgres.sh

# Black        0;30     Dark Gray     1;30
# Red          0;31     Light Red     1;31
# Green        0;32     Light Green   1;32
# Brown/Orange 0;33     Yellow        1;33
# Blue         0;34     Light Blue    1;34
# Purple       0;35     Light Purple  1;35
# Cyan         0;36     Light Cyan    1;36
# Light Gray   0;37     White         1;37

COLOR='\033[1;33m'
NC='\033[0m' # No Color

sudo=$(which sudo)
psql=$(which psql)
shp2pgsql=$(which shp2pgsql)
PATH="layers"

echo -e "${COLOR}Running sudo apt-get -y install postgresql postgresql-contrib postgis${NC}"
${sudo} apt-get -y install postgresql postgresql-contrib postgis pgadmin3

${sudo} -u postgres ${psql} -c "ALTER USER postgres WITH PASSWORD '123';"

echo -e "${COLOR}Running psql CREATE DATABASE geospatial_ws1;${NC}"
${sudo} -u postgres ${psql} -c "DROP DATABASE IF EXISTS geospatial_ws1;"
${sudo} -u postgres ${psql} -c "CREATE DATABASE geospatial_ws1;"

echo -e "${COLOR}Running psql CREATE EXTENSION postgis;${NC}"
${sudo} -u postgres ${psql} -d geospatial_ws1 -c "CREATE EXTENSION postgis;"

echo -e "${COLOR}Importing puntos.shp file to posrgrest${NC}"
${shp2pgsql} -s 4326 $PATH/puntos.shp  public.puntos | PGPASSWORD=123 ${psql} -q -d geospatial_ws1 -U postgres -h localhost