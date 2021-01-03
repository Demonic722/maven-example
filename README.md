# maven-example

An example Java project configured with maven.

## Instructions

Creates a standalone maven Java project using the archetype `maven-archetype-quickstart`.
```shell
% mvn archetype:generate -DgroupId=com.syntechx -DartifactId=maven-example -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
- `mvn` command runs the maven script
- `archetype:generate` - maven goal - describes a unit of work in maven (in this case, creating a project using this goal `archetype:generate`)
- `-D` - parameters to this goal
    - `groupId` - package name where our project that we're creating will be stored in the maven repo
    - `artifactId` - name of our project
    - `archetypeArtifactId` - what type of project are we creating?
    - `maven-archetype-quickstart` - standalone java project
    - `maven-archetype-webapp` - webapp
    - `interactiveMode` - on by default so set to false when running this (you'd need to input these dynamically otherwise)

Compile/build, clean, run tests, and package the project. This creates a target folder and puts all the compiled files into here.
```shell
% mvn clean install
```
If you get this error:
```
[ERROR] COMPILATION ERROR :
[INFO] -------------------------------------------------------------
[ERROR] Source option 5 is no longer supported. Use 7 or later.
[ERROR] Target option 5 is no longer supported. Use 7 or later.
[INFO] 2 errors
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.015 s
[INFO] Finished at: 2021-01-02T17:17:50-05:00
[INFO] ------------------------------------------------------------------------
```
You can add the `org.apache.maven.plugins` `plugin` to the `pom.xml`. 
```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>3.8.1</version>
      <configuration>
        <verbose>true</verbose>
        <source>1.8</source>
        <target>1.8</target>
        <showWarnings>true</showWarnings>
      </configuration>
    </plugin>
  </plugins>
</build>
```
The `maven-compiler-plugin` is used to compile the source code of a maven project. The plugin has two goals, which are already bound to specific phases of the default lifecycle:
- compile – compile main source files
- testCompile – compile test source files

> By default, the compiler plugin compiles source code compatible with Java 5, and the generated classes also work with Java 5 regardless of the JDK in use. We can modify these settings in the configuration element:
```xml
<configuration>
  <source>1.8</source>
  <target>1.8</target>
  <-- other customizations -->
</configuration>
```
> For convenience, we can set the Java version as properties of the POM:
```xml
<properties>
  <maven.compiler.source>1.8</maven.compiler.source>
  <maven.compiler.target>1.8</maven.compiler.target>
</properties>
```
Running the program.
```shell
% java -cp target/maven-example-1.0-SNAPSHOT.jar com.syntechx.App
```

## Credits

This knowledge was derived from the Udemy course [Maven Crash Course](https://www.udemy.com/course/mavencrashcourse/) by Bharath Thippireddy and [Baeldung](https://www.baeldung.com/maven-compiler-plugin). All Java code used in this repo is from Bharath Thippireddy.