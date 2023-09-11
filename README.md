# Build
mvn clean package && docker build -t br.com.carlos/crud-mysql .

# RUN

docker rm -f crud-mysql || true && docker run -d -p 8080:8080 -p 4848:4848 --name crud-mysql br.com.carlos/crud-mysql 