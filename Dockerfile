FROM airhacks/glassfish
COPY ./target/crud-mysql.war ${DEPLOYMENT_DIR}
