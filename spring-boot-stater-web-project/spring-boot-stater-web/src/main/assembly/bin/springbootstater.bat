@echo OFF
title Spring boot stater web
set RUNDIR=%~dp0
cd %RUNDIR%\..
%JAVA_HOME%\bin\java -Djava.net.preferIPv4Stack=true -Duser.timezone=UTC -Djava.io.tmpdir=temp -Dspring.profiles.active=production -DPIDFILE=bin\springbootstaterweb.pid -jar lib\spring-boot-stater-web.jar