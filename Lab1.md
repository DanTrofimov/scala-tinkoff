# Lab #1 - Scala Basics
>Themes: sbt, library dependencies

###### tags: `scala` `scala-innopolis` `lab`

## Links
- Intellij IDEA setup: https://docs.scala-lang.org/getting-started/intellij-track/getting-started-with-scala-in-intellij.html, https://www.baeldung.com/scala/intellij-with-sbt
- Scala project structure: https://docs.scala-lang.org/getting-started/intellij-track/building-a-scala-project-with-intellij-and-sbt.html
- Testing: https://docs.scala-lang.org/getting-started/intellij-track/testing-scala-in-intellij-with-scalatest.html
- Sbt basic commands: https://www.scala-sbt.org/1.x/docs/Running.html

### Labs submission
- this lab - zip archive without .idea and target directory in moodle
- from the next lab we will use GitHub Classroom, where you will get assigments in individual repos. REMEMBER: Do not load all code just in master. You should create a new branch, push all code to it and open pull request onto master. Only in this case Github Action job with autotests will run.
- Since we will use github you all should have a github account by the next lab

### Intellij IDEA
- jdk 8/11/17
- env setup
- sbt build settings in IDE

### sbt
- basics commands
- deps
- plugins(scalafmt, dependencyTree)
- tests

### Exercise
#### Step 1 - Setup Intellij
- Install JDK 8/11/16 as you wish, Scala does not take much advantage from jdk 8+ features.
  -- [Generic system](https://openjdk.java.net/install/)
  -- [Mac OS Brew](https://formulae.brew.sh/formula/openjdk)
- Download and Install IntelliJ IDEA. [Link](https://www.jetbrains.com/idea/download/)
- Open Intellij IDEA Plugins and install Scala plugin, or download it from Web Intellij Marketplace [Link](https://plugins.jetbrains.com/plugin/1347-scala)

#### Step 2 - Setup Project
- Create a new project from File -> New -> Project -> Scala -> sbt: Next button -> Project with name 'Currency Converter', choose you JDK, sbt: 1.3.13, Scala: 2.13.6 with sources.
- After project creation open sbt window from the right sidebar, then its settings and check that options project reload and builds under 'sbt shell used for' are activated. Also disable 'Allow overriding sbt version' option
  ![](https://i.imgur.com/l9ARde1.png)
- Create a package `<your-name>.<your-surname>` in `src/main/scala`
- Take some time to explore project's structure

#### Step 3 - Simple program
- Create a Scala sbt project with sbt 1.6.2 and Scala 2.13.8
- Your program should request output to console "Enter your name:", request an input and output back "Hello, 'entered name'!" on new line