# Camel Native Example: C++

Examples for calling native C++ libraries via Camel.

_This example requires the compiled library from the "C++ Calculator" project (referenced below). It was made to compile/run on Linux __using the GNU `g++` tool__, but could easily be modified to run on Windows or any other OS. If you do modify it, be sure to take account of the different [name mangling](https://en.wikipedia.org/wiki/Name_mangling) strategies for your compiler and update the `applicationContext.xml` file accordingly. **Tip**: On Linux, you can use the `nm` command to find the mangled names (ie, `nm -D libc-calculator.so`)._

## Requirements

- [Apache Maven 3.x](http://maven.apache.org)
- [C++ Calculator](https://github.com/joshdreagan/cpp-calculator)

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
