# Jupyter Notebook

## Install Jupyter Notebook

First we need to install pip.

```
$ sudo apt-get install python-pip
$ pip install --upgrade pip
```

Before to install jupyter Notebook we are goint to create a virtualenv.

```
$ pip install virtualenv
$ virtualenv venv  
$ source venv/bin/activate
```
**NOTE:** to `deactivate` type `deactivate`.


Now we can to install Jupyter Notebook with pip.

```
$ pip install jupyter
```

To start Jupyter Notebook.

```
$ jupyter notebook
```

Once jupyter notebook is running, we just open `GeoSpatial.ipynb` file.

# Libraries we need to install

Ipyleaflet: A Jupyter / Leaflet bridge enabling interactive maps in the Jupyter notebook.

```
$ pip install ipyleaflet
$ jupyter nbextension enable --py --sys-prefix widgetsnbextension
$ jupyter nbextension enable --py --sys-prefix ipyleaflet
```

Sqlalchemy: is the Python SQL toolkit and Object Relational Mapper that gives application developers the full power and flexibility of SQL.

```
$ pip install sqlalchemy
```

psycopg2: Is the most popular PostgreSQL adapter for the Python programming language.

```
$ apt install libpq-dev python-dev
$ pip install psycopg2
```

GeoAlchemy2: Provides extensions to SQLAlchemy for working with spatial databases.

```
$ pip install geoalchemy2
```