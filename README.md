# shoe-platform

## What is it?
The shoe-platform consists of two services: shoe-service (Spring-Boot) and shoe-ui (NodeJS/React). The shoe-service is a RESTful API that consumes shoe brand and model information along with a true-to-size value and persists it to a database. These values can be retrieved as an average for each brand/model combination. The shoe-ui is a friendly web client that allows users to enter and view true to size data. 

Support services include an authorization-server and Spring-Boot-Admin-Server. The authorization-server supports OAuth2 grant types and returns a JWT to the requester and a JWKS endpoint for JWT verification. The Spring-Boot-Admin-Server provides monitoring and health information for the authorization-server as well as the shoe-service.

#### Services Diagram

![Image](https://github.com/wkennedy/shoe-platform/blob/dev/images/shoe-platform-diagram.png)

## Quickstart
First of all, you'll need to clone this project:

    git clone https://github.com/wkennedy/shoe-platform.git

In order to run the platform all you need is Docker installed in order to use Docker Compose,

https://docs.docker.com/v17.09/engine/installation/

Then from shoe-platform/docker run:

    docker-compose up

Once everything is up and running you can navigate to http://localhost:3000 and see the service interface.

NOTE: If you have trouble with ports due to applications on your machine already utilizing those ports, please edit the ports in the docker-compose.yml file appropriately.

## How to build

#### shoe-service
In order to build the shoe-service you need Java 8 (and set JAVA_HOME) or above installed and Maven. In the shoe-service root (shoe-platform/shoe-service) execute:

    mvn install

If you don't or can't install Maven, you can use the included Maven wrapper:

    ./mvnw install

From here you can build your own docker images. In the shoe-platform/shoe-service directory execute (replace <YOUR PREFIX> with your docker hub name):

     docker build -t <YOUR PREFIX>/shoe-service .

#### shoe-ui
In order to use the UI you need NodeJS installed (https://nodejs.org/en/download/). You don't have to build the UI in order to run it. From the shoe-platform/shoe-ui directory you can execute:

    npm run dev

Please note that you'll need the shoe-service running in order for the UI to operate correctly.

From here you can build your own docker images. In the shoe-platform/shoe-ui directory execute (replace <YOUR PREFIX> with your docker hub name):

     docker build -t <YOUR PREFIX>/shoe-ui .

## How to run

Now that your docker images are built, you can update the docker-compose.yml file in shoe-platform/docker with your image names. For example, 

    shoe-service:
      image: "<YOUR PREFIX>/shoe-service"
    shoe-ui:
      image: "<YOUR PREFIX>/shoe-ui"

Once that's done you can run:

    docker-compose up

and then navigate to http://localhost:3000 in your browser.

## Useful Endpoints

http://localhost:8091/admin

This will show you basic monitoring and configuration of the shoe-service.

http://localhost:8080/swagger-ui.html

This is the swagger endpoint to display the API provided by the shoe-service. Because the shoe-service is a protected resource, you must provide Swagger authorization with 'Bearer <token>'. Replace <token> with the access token provided by:
    
    curl -X POST \
      http://localhost:8090/auth/oauth/token \
      -H 'Accept: */*' \
      -H 'Authorization: Basic Y2xpZW50OnNlY3JldA==' \
      -H 'Content-Type: application/x-www-form-urlencoded' \
      -H 'Host: localhost:8090' \
      -H 'cache-control: no-cache' \
      -d 'client_id=client&client_secret=secret&grant_type=client_credentials&scope=shoes'
    http://localhost:5433/browser/

http://localhost:5433/browser/

This is the PGAdmin 4 browser for Postgres, you can login to the admin console with:

    user: admin@shoe-service.com
    password: admin
