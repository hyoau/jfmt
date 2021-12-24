# jfmt: 一个易于使用的 Java 代码格式化工具

## 如何使用

### 以默认格式格式化代码
```Bash
java -jar formatter.jar Test.java
```

```Bash
java -jar formatter.jar /home/test/code_base
```

### 声明格式
```Bash
java -jar formatter.jar --style google /home/test/code_base
```

```Bash
java -jar formatter.jar --style aosp /home/test/code_base
```

## 如何编译

```Bash
mvn clean install
```

希望这个项目能够给您带来帮助~