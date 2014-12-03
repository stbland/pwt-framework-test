#!/bin/bash 
SCRIPTPATH=$(readlink -f "$0")
SCRIPTDIR=$(dirname "$SCRIPTPATH")
POMPATH=$SCRIPTDIR/../webapp/pom.xml
mvn -f $POMPATH -Pgwt-codeserver gwt:compile tomcat7:run
