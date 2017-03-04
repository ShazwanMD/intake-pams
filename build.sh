#!/bin/bash
echo "TOMCAT_HOME=/opt/tomcat"
echo "Stoping tomcat..."
systemctl stop tomcat
echo git pull
git pull
echo "mvn clean & tomcat clean"
mvn clean
rm -rf /opt/tomcat/webapps/intake
rm /opt/tomcat/webapps/intake.war
echo mvn package
mvn package -DskipTests=true
mv target/intake.war target/intake.war
echo copying ntake.war
cp target/intake.war /opt/tomcat/webapps
echo Starting tomcat
echo TOMCAT_HOME=/opt/tomcat
systemctl start tomcat
echo Script Completed!
