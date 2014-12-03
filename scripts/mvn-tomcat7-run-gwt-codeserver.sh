#!/bin/bash 
SCRIPTPATH=$(readlink -f "$0")
SCRIPTDIR=$(dirname "$SCRIPTPATH")
$SCRIPTDIR/doMaven-webapp.sh -Pgwt-codeserver -Dmaven.test.skip=true prepare-package tomcat7:run
