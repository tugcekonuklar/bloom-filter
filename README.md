# Bloom Filters

This project is providing bloom filtering algorithm with a simple terminal application, 
which you can search your input value is from the predefined data source.

The project is using `wordlist.txt` as resource of the dictionary.You can find in resource file.

To exit the app you can type `exit`. Exit command is not case sensitive.

You can find more information about Bloom Filtering from [here](https://en.wikipedia.org/wiki/Bloom_filter)

** Note: This project does not calculate false positive probability.

## Sample

```shell script
LOADING : Please wait ...
WELCOME : Please write a word to search :
john
RESULT : john might contain : true
Tugce
RESULT : Tugce might contain : false
exit
```

## Assumptions

* Don't see any restriction for using Lombok, that's why I used Lombok.

## Libraries & Tools

* Java 11
* Maven 3.6
* Apache Commons Codec
* Lombok
* Junit 

## Building Application

Useful commands:

#### `mvn clean install`
 fully clean and install dependencies
#### `mvn test`
 runs tests
#### `mvn compile`
 compiles application
#### `mvn package`
 creates package of application

## Running Application

After you create package of the application, in the path of the application on terminal, write the command which is below to run application.

#### `java -jar target/bloom-filter-1.0-SNAPSHOT.jar`

## Importing & Building


### 1. Enable Plugins

Enable the following plugins in IDEA:
* [Lombok Plugin](https://projectlombok.org/setup/eclipse)

### 2. Configure Annotation Processing

##### For Intellij IDEA:

Open _Settings_ → _Build, Execution, Deployment_ → _Compiler_ →
_Annotation Processors_.

Check options:
* _Enable annotation processing_

###### Don't forget to enable Lombok in your IDEA

For Intelij IDEA, you can follow below

Open _Settings_ → _Other settings_ → _Lombok plugin_.

Check _Enable Lombok plugin for this project_.
