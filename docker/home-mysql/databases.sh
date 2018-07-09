#!/bin/bash
DATABASES[0]="light_service"

TEST_DATABASE_PREFIX="test_"

function setupDatabase {
	mysql -u home-control --password=home-control -e "CREATE DATABASE IF NOT EXISTS ${1};"
	echo "\tDatabase ${1} created."

}

mysql -u root --password=home-control -e "CREATE USER test@'%' IDENTIFIED BY 'test';"

mysql -u root --password=home-control -e "GRANT ALL ON *.* to 'home-control'@'%' IDENTIFIED BY 'home-control'; FLUSH PRIVILEGES;"
mysql -u root --password=home-control -e "GRANT ALL ON *.* to 'test'@'%' IDENTIFIED BY 'test'; FLUSH PRIVILEGES;"

for DATABASE in "${DATABASES[@]}"; do
	echo "Setting up dev and test database for ${DATABASE}..."
	setupDatabase $DATABASE
	setupDatabase "$TEST_DATABASE_PREFIX$DATABASE"
	echo ""
done
