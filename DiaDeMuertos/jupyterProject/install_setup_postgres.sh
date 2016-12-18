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

PATH_BIN="/usr/bin/"
PATH="layers"

# # echo -e "${COLOR}Running sudo apt-get -y install postgresql postgresql-contrib postgis${NC}"
# ${PATH_BIN}sudo apt-get -y install postgresql postgresql-contrib postgis pgadmin3

${PATH_BIN}sudo -u postgres psql -c "ALTER USER postgres WITH PASSWORD '123';"

echo -e "${COLOR}Running psql CREATE DATABASE test;${NC}"
${PATH_BIN}sudo -u postgres psql -c "DROP DATABASE IF EXISTS test;"
${PATH_BIN}sudo -u postgres psql -c "CREATE DATABASE test;"

echo -e "${COLOR}Running psql CREATE EXTENSION postgis;${NC}"
${PATH_BIN}sudo -u postgres psql -d test -c "CREATE EXTENSION postgis;"

echo -e "${COLOR}Importing puntos.shp file to posrgrest psql CREATE EXTENSION postgis;${NC}"
${PATH_BIN}shp2pgsql -s 4326 $PATH/puntos.shp  public.puntos | PGPASSWORD=123 ${PATH_BIN}psql -q -d test -U postgres -h localhost