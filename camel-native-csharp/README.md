# Camel Native Example: C&#35;

Examples for calling native C# libraries via Camel.

_This example requires the compiled library from the "C# Calculator" project (referenced below). It utilizes the [jni4net](http://jni4net.com/) tool and can only be run on Windows._

## Requirements

- [Apache Maven 3.x](http://maven.apache.org)
- [jni4net 0.8.8.0](http://jni4net.com/)
- [C# Calculator](https://github.com/joshdreagan/csharp-calculator)

## Building Example

Run the following commands from a terminal window.

Be sure to set the following properties:

 - jni4net.home: The absolute path to the jni4net installation directory.
 - visual-studio.home: The absolute path to the Visual Studio installation directory.
 - dll.path: The absolute path to the C# DLL file.

```
~$ cd $PROJECT_ROOT
~$ mvn clean install -Djni4net.home=<JNI4NET_HOME> -Dvisual-studio.home=<VISUAL_STUDIO_HOME> -Ddll.path=<DLL_PATH>
```

## Running Camel

Run the following commands from a terminal window.

```
~$ cd $PROJECT_ROOT
~$ mvn camel:run
```
