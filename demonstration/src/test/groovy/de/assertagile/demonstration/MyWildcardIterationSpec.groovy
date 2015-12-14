package de.assertagile.demonstration

import spock.lang.Specification
import spock.lang.Unroll

class MyWildcardIterationSpec extends Specification {

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
}
