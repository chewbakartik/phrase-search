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

[1]: http://en.wikipedia.org/wiki/Polymorphism_(computer_science)#Ad_hoc_polymorphism
[2]: http://en.wikipedia.org/wiki/Polymorphism_(computer_science)#Parametric_polymorphism
[3]: http://en.wikipedia.org/wiki/Polymorphism_(computer_science)#Subtyping
[4]: http://en.wikipedia.org/wiki/Polymorphism_(computer_science)#Polytypism
[5]: http://stackoverflow.com/questions/17803621/why-is-it-called-open-or-closed-recursion