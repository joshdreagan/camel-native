# Camel Native Example: C

Examples for calling native C libraries via Camel.

_This example requires the compiled library from the "C Calculator" project (referenced below). It was made to compile/run on Linux, but could easily be modified to run on Windows or any other OS._

## Requirements

- [Apache Maven 3.x](http://maven.apache.org)
- [C Calculator](https://github.com/joshdreagan/c-calculator)

## Building Example

Run the following commands from a terminal window.

```
~$ cd $PROJECT_ROOT
~$ mvn clean install
```

## Running Camel

Run the following commands from a terminal window.

```
~$ cd $PROJECT_ROOT
~$ mvn -Djna.library.path=<PATH_TO_DLL_DIR> camel:run
```
