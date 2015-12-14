Spock Scope Extension
=====================

[![Build Status](https://travis-ci.org/mkutz/spock-wildcard-iteration-extension.svg?branch=master)](https://travis-ci.org/mkutz/spock-wildcard-iteration-extension) [![Coverage Status](https://img.shields.io/coveralls/mkutz/spock-wildcard-iteration-extension.svg)](https://coveralls.io/r/mkutz/spock-wildcard-iteration-extension) [![Maven Central](https://img.shields.io/maven-central/v/de.assertagile.spockframework.extensions/spock-wildcard-iteration-extension.svg)](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22spock-wildcard-iteration-extension%22)

An extension for the [Spock Framework](http://spockframework.org/) to enable usage of the wildcard `_` in `where` blocks (especially in data tables) to express that a parameter should not influence the outcome of a test no matter which value is used for it.

Usage
-----

For a detailed view on how to use this extension please have a look into the [demonstation folder](https://github.com/mkutz/spock-wildcard-iteration-extension/tree/master/demonstration) of this repository.

Add this as a test dependency to your project.

For instance in your pom.xml:
```xml
<dependency>
  <groupId>de.assertagile.spockframework.extensions</groupId>
  <artifactId>spock-wildcard-iteration-extension</artifactId>
  <version>${spock-wildcard-iteration-extension.version}</version>
  <scope>test</scope>
</dependency>
```

Now you can use the wildcard in your data tables `_`:

```groovy
@Unroll
def "result should be 0 for a = #a, b = #b and c = #c"(Integer a, Integer b, Integer c) {
    expect:
    a * b - c == 0

    where:
    a | b | c
    0 | _ | 0
    _ | 0 | 0
    1 | 1 | 1
}
```

The first line in the data table will generate the cases
- result should be 0 for a = 0, b = 0 and c = 0 and
- result should be 0 for a = 0, b = 1 and c = 0
for `b` was wildcarded and is therefore replaced with all values used for it in the rest of the table.

The second line accordingly generates
- result should be 0 for a = 0, b = 0 and c = 0
- result should be 0 for a = 1, b = 0 and c = 0

The third line does not use any wildcard but adds variants for `a` and `b`. It generates only one additional test case.
- result should be 0 for a = 1, b = 1 and c = 1
