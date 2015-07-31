#!/bin/bash 
SCRIPTPATH=$(readlink -f "$0")
SCRIPTDIR=$(dirname "$SCRIPTPATH")
POMPATH=$SCRIPTDIR/../pom.xml
mvn -f $POMPATH -N clean install
