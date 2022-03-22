FROM tomcat:9
RUN apt-get update && apt-get -y upgrade
COPY target/*.war /usr/local/tomcat/webapps/
RUN sed -i '/Access log processes all example./i \ \ \ \ \ \ \ \ <Context path="" docBase="/usr/local/tomcat/webapps/StudentApplication" reloadable="true" crossContext="true"/>' /usr/local/tomcat/conf/server.xml
CMD ["catalina.sh", "run"]
EXPOSE 8080