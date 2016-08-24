# Shorty - URL shortener
##### (minimal implementation for carousell.com)
  
### Clone
`git clone https://github.com/dusan-eremic/Shorty.git`

### Build
`mvn clean package`

### Database config 
Database URL is located inside the `src/main/resource/application.properties` file. The URL currently points to my test database hosted at mlab.com.
  
### Run
`java -jar target/shorty-0.0.1-SNAPSHOT.jar`

### Run the ShortyWebClient
`cd ShortyWebClient`

then run any HTTP server while iside that directory for instance

`python -m SimpleHTTPServer`
