@echo off
call doMaven-webapp.bat -Pgwt-codeserver -Dmaven.test.skip=true prepare-package tomcat7:run
