# 04 Classes And Objects

### Contents

[Visibility Modifiers](#visibility-modifiers)
### Visibility Modifiers
* Top-Level Items

    |Access Modifier| Kotlin                         | Java                   |
    |--------------------------------|------------------------|----|
    |`private`| only visible inside the file   | Can't be used          |
    |`protected`| can't be used                  | can't be used          |
    |`internal` | visible within the same module | N/A                    |
    |`public`| visible everywhere             | visible everywhere     |
    |(default)| default is `pubic`             | visible within package |
    
   * In Java, you can only have one public class, since the name of public class should match to the file name.
    However, in kotlin, there is no matching requirement between file name and class name. So you can
    have many public classes in a single kotlin file.
   * `internal`  will be compiled to public in class file. In Kotlin, `internal` class is only visible within module,
    but if you have Java code inside the project, Java code is able to see `internal` code from outside module.
   * In Kotlin, all classes are `private final` by default.

* Class member

### Open Keyword
* All classes, functions, and fields are `final` by default that means they cannot 
be extended or overridden.

* `open` is a keyword that the annotated item is open to be extended or overridden.

**[⬆ Back to top](#contents)**


### Interfaces