- [Some tricks](#some-tricks)
  - [Add dependency to a jar in a file system](#add-dependency-to-a-jar-in-a-file-system)
  - [Connect to svn and add revision number to the manifest](#connect-to-svn-and-add-revision-number-to-the-manifest)


# Some tricks

## Add dependency to a jar in a file system

```xml
<dependency>
    <groupId>sample</groupId>
    <artifactId>com.sample</artifactId>
    <version>1.0</version>
    <scope>system</scope>   
    <systemPath>${project.basedir}/src/main/resources/yourJar.jar</systemPath>
</dependency>
```

## Connect to svn and add revision number to the manifest

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.example</groupId>
        <artifactId>example-parent</artifactId>
        <version>1</version>
    </parent>
    <groupId>com.example</groupId>
    <artifactId>ExampleCore</artifactId>
    <version>1.0.1</version>
    <packaging>jar</packaging>
        <scm>
        <connection>scm:svn:svn://host:port/products/core/fx/ExampleCore/trunk</connection>
        <developerConnection>scm:svn:svn://host:port/products/core/fx/ExampleCore/trunk</developerConnection>
        <tag>HEAD</tag>
        <url>scm:svn:svn://host:port/products/core/fx/ExampleCore/trunk</url>
    </scm>
    <build>
        <finalName>ExampleCore</finalName>
        <plugins>
            <!-- 
            Collect dependencies to build directory. These classes will be included in the jar. 
            But exclude transitive dependencies. Copy only com.example
            -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-dependency-plugin</artifactId>
                <version>2.8</version>
                <executions>
                    <execution>
                        <id>unpack-dependencies</id>
                        <phase>prepare-package</phase>
                        <goals>
                            <goal>unpack-dependencies</goal>
                        </goals>
                        <configuration>
                            <outputDirectory>${project.build.outputDirectory}</outputDirectory>
                            <excludeTransitive>true</excludeTransitive>
                            <includeGroupIds>
                                com.example      
                            </includeGroupIds>
                            <excludeTypes>pom</excludeTypes>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>2.4</version>
                <configuration>
                    <archive>
                        <manifest>
                            <classpathPrefix>lib/</classpathPrefix>
                            <addClasspath>true</addClasspath>
                            <classpathLayoutType>custom</classpathLayoutType> 
                            <customClasspathLayout>$${artifact.artifactId}.$${artifact.extension}</customClasspathLayout>
                        </manifest>
                        <manifestEntries>
                            <SCM-Revision>${buildNumber}</SCM-Revision>
                        </manifestEntries>
                    </archive>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>buildnumber-maven-plugin</artifactId>
                <version>1.4</version>
                <executions>
                    <execution>
                        <phase>validate</phase>
                        <goals>
                            <goal>create</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <doCheck>false</doCheck>
                    <doUpdate>true</doUpdate>
                    <providerImplementations>
                        <svn>javasvn</svn>
                    </providerImplementations>
                    <username>${svnLogin}</username>
                    <password>${svnPassword}</password>
                </configuration>
            </plugin>
        </plugins>
    </build> 
    
    <dependencies>
        <dependency>
            <groupId>com.google.code.maven-scm-provider-svnjava</groupId>
            <artifactId>maven-scm-provider-svnjava</artifactId>
            <version>2.1.0</version>
        </dependency>
    </dependencies>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>
</project>




