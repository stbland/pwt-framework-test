SCRIPTPATH=$(readlink -f "$0")
SCRIPTDIR=$(dirname "$SCRIPTPATH")
$SCRIPTDIR/doGradle-webapp.sh tomcatDraftWar

