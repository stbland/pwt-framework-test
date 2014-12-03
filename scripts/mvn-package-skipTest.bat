@echo off
call doMaven-webapp.bat clean package -Dmaven.test.skip=true
