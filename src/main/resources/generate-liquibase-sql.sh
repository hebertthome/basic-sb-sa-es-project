#! /bin/sh

cd ../../..

mvn -Dliquibase.url="jdbc:postgresql://localhost:5432/ctrl_lc_contract" \
  -Dliquibase.username="postgres" -Dliquibase.password="postgres" \
  -Dliquibase.driver="org.postgresql.Driver" \
  -Dliquibase.changeLogFile=src/main/resources/db/changelog/db.changelog-master.yaml \
  -Dliquibase.dialect=org.hibernate.dialect.PostgreSQLDialect \
  clean compile liquibase:updateSQL

echo "\n-\nFile saved on target folder /liquibase/migrate.sql"
