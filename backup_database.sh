set -x
docker exec oop01_project-db-1  bash -c "mysqldump -u root --password=thisisnotsafe oasisdb > /tmp/dump.sql"
docker cp oop01_project-db-1:/tmp/dump.sql $PWD/dump.sql
