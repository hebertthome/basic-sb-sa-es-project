#!/bin/sh

# if [ -z ${JASYPT_ENCRYPTOR_PASSWORD} ];
# then
#   echo "Variavel JASYPT_ENCRYPTOR_PASSWORD nao configurada"
#   exit 1
# fi

JAVA_OPTS="${JAVA_OPTS} -Dnetworkaddress.cache.ttl=0"
JAVA_OPTS="${JAVA_OPTS} -Dnetworkaddress.cache.negative.ttl=0"
JAVA_OPTS="${JAVA_OPTS} -Dsun.net.inetaddr.ttl=0"
JAVA_OPTS="${JAVA_OPTS} -Dsun.net.inetaddr.negative.ttl=0"

java $JAVA_OPTS \
  -jar $ARTIFACT_NAME $APP_OPTS
