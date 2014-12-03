@echo off
rem DEBUT Configuration
set PROJECT_SHORTNAME=test-pwt
rem FIN Configuration
set POMFILE=..\pom.xml
set DOMAVENARGS=%*
set JAVA_HOME=%JDK7_HOME%
set PATH=%JAVA_HOME%\bin;%PATH%
set MAVEN_OPTS=-Xss1M
if "%DOMAVENARGS%" == "" goto paramKo
if exist %POMFILE% goto mavenOk
:paramKo
echo "Usage: doMaven [options] [<goal(s)>] [<phase(s)>]"
goto Fin
:mavenKO
echo Le fichier du projet Maven est introuvable
goto Fin
:mavenOk
title Maven %PROJECT_SHORTNAME% %DOMAVENARGS%
echo Lancement de Maven %DOMAVENARGS% ...
call mvn -f %POMFILE% %DOMAVENARGS%
:fin