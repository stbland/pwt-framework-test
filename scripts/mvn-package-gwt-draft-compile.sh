#!/bin/bash 
SCRIPTPATH=$(readlink -f "$0")
SCRIPTDIR=$(dirname "$SCRIPTPATH")
$SCRIPTDIR/doMaven-webapp.sh -Pgwt-draft-compile package
