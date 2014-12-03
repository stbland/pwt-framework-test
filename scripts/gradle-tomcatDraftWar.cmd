@echo off
set PROJECTPATH=..\test-pwt-webapp\build.gradle
call gradle -b %PROJECTPATH% tomcatDraftWar

