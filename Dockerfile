FROM jboss/wildfly:20.0.1.Final

MAINTAINER "Pedro" "pedrolop90@gmail.com"

RUN /opt/jboss/wildfly/bin/add-user.sh pedro pedro --silent

ADD target/pedro.war /opt/jboss/wildfly/standalone/deployments/

EXPOSE 8080 9990 8009

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]