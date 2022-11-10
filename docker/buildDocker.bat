@echo off
CD /D %~dp0

echo init ================================
set GRADLE_USER_HOME=D:\Program Files\JetBrains\.gradle

echo clean ===============================
call .\gradlew.bat clean

echo build ===============================
call .\gradlew.bat build -x test

echo build wlxx-system ===================
call docker container stop wlxx-system
call docker container rm wlxx-system
call docker rmi wlxx-system-provider:0.0.1-SNAPSHOT
call cd .\wlxx-services\wlxx-system\wlxx-system-provider
call ..\..\..\gradlew.bat dockerBuildImage
call cd ..\..\..\

echo build wlxx-user =====================
call docker container stop wlxx-user
call docker container rm wlxx-user
call docker rmi wlxx-user-provider:0.0.1-SNAPSHOT
call cd .\wlxx-services\wlxx-user\wlxx-user-provider
call ..\..\..\gradlew.bat dockerBuildImage
call cd ..\..\..\

echo build wlxx-gateway ==================
call docker container stop wlxx-gateway
call docker container rm wlxx-gateway
call docker rmi wlxx-gateway:0.0.1-SNAPSHOT
cd .\wlxx-gateway
call ..\gradlew.bat dockerBuildImage
cd ..\

echo docker-compose ======================
call docker-compose -f .\docker-compose.yml up -d