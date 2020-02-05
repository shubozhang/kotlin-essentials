# Misc

### Contents
1. [Default imports](#1-default-imports)
2. [imports](#2-imports)



### 1. Default Imports
A number of packages are imported into every Kotlin 􏰀file by default:
* kotlin.*
* kotlin.annotation.*
* kotlin.collections.*
* kotlin.comparisons.*(since1.1) — kotlin.io.*
* kotlin.ranges.*
* kotlin.sequences.*
* kotlin.text.*

**[⬆ Back to top](#contents)**


### 2. Imports
* import class
    ```
    import org.example.Message // Message is now accessible without qualification
    
    import org.example.* // everything in 'org.example' becomes accessible
    
    import org.example.Message // Message is accessible
    import org.test.Message as testMessage // testMessage stands for 'org.test.Message'
    ```

* The import keyword is not restricted to importing classes; you can also use it to import other declarations:
    * top-level functions and properties;
    * functions and properties declared in object declarations; — enumconstants.



**[⬆ Back to top](#contents)**
