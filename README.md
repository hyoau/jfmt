# jfmt: An easy-to-use code format tool for Java

## How to use

### Format the code with default style
```Bash
java -jar formatter.jar Test.java
```

```Bash
java -jar formatter.jar /home/test/code_base
```

### Specify style
```Bash
java -jar formatter.jar --style google /home/test/code_base
```

```Bash
java -jar formatter.jar --style aosp /home/test/code_base
```

## How to compile

```Bash
mvn clean install
```

Wish this tool could be helpful to you :)