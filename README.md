phrase-search
=============

## Purpose

This program takes 2 inputs (phrase, directory path) and outputs a list of files that contain the search phrase in the directory path.  Matched files must be output on separate lines.

Scala was selected for this program to satisfy some of the constraints that had been placed on solving this problem.  It has given me an opportunity to get some hands on experience developing with this language

## Constraints

* Coded in a statically compiled and type-checked language
* Runtime casts are forbidden
* Functional Programming
    * Everything should be representable as a function
    * Immutable: every abstraction should be used in an immutable manner. It is permissible to have mutable code hidden beneath the covers (for an abstraction), but try and avoid it unless there’s real need for it.
* Type Safety
    * each function should have a fixed type
    * [ad-hoc polymorphism][1] is forbidden
    * [parametric polymorphism][2] is allowed
    * [subtyping polymorphism][3] is forbidden
    * [polytypic programming][4] is allowed
    * casting and runtime type checking is forbidden
* Recursion
    * recursion ([open or closed][5]) is the only kind of looping construct permitted. ie.ie, no "for" loops
* OS/Platform
    * must compile and run on Ubuntu 14.04 LTS (64-bit)

## Installation

This project makes use of Scala's Build Tool (SBT).  SBT handles the projects dependencies, and will download any of the necessary libraries.  The latest package of SBT at the writing of this readme is 0.13.7. To install SBT on Ubuntu 14.04 follow the instructions below.

```bash
wget https://dl.bintray.com/sbt/debian/sbt-0.13.7.deb
sudo dpkg -i sbt-0.13.7.deb
```

## Compile, Test, and Run

Now that sbt is installed on your system, you can compile, test, and run the application directly from their console.  First start the sbt console by:

```bash
sbt
```

To compile, type the following into the sbt console. Note that upon first run, compile will take a little longer as SBT downloads the projects dependencies.

```bash
compile
```

To test, type the following into the sbt console.

```bash
test
```

To run, type the following into the sbt console, then follow the console prompts from the application.

```bash
run
```

There are some sample files that are included with this application if you don't have a folder set up yet, and still want to try running it.  The folder path for those files is 'src/test/resources/files'.
The search string can also include regex.  For example, if you want to do a case insensitive search, add '(?i)' to the beginning of your search string.

```bash
Please enter search string:
(?i)everything
```

[1]: http://en.wikipedia.org/wiki/Polymorphism_(computer_science)#Ad_hoc_polymorphism
[2]: http://en.wikipedia.org/wiki/Polymorphism_(computer_science)#Parametric_polymorphism
[3]: http://en.wikipedia.org/wiki/Polymorphism_(computer_science)#Subtyping
[4]: http://en.wikipedia.org/wiki/Polymorphism_(computer_science)#Polytypism
[5]: http://stackoverflow.com/questions/17803621/why-is-it-called-open-or-closed-recursion