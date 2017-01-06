!#/bin/sh

# First create dir where we will put out apps.
sudo mkdir /var/app

# Create "web" group.
sudo addgroup web

# Set user to "root" and group to "web".
sudo chown -R root:web /var/app

# Set 755 permission to all directories.
sudo chmod -R 755 /var/app

#Set the groud ID, so this way all new files and directories will inherit "web" group.
sudo chmod g+s /var/app

# Set 664 permission to all files, so users in "web" can edit files.
sudo find /var/app -type f -exec chmod 664 {} \;

# Add current user to "web" group.
sudo usermod -aG web $(whoami)
