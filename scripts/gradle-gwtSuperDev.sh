SCRIPTPATH=$(readlink -f "$0")
SCRIPTDIR=$(dirname "$SCRIPTPATH")
PROJECTPATH=$SCRIPTDIR/../webapp/build.gradle
gradle -b $PROJECTPATH gwtSuperDev
