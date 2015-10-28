/**
 * Created by vikasv on 10/9/2015.
 */


import spock.lang.Ignore
import spock.lang.Specification

//@Stepwise
class FristGroovyClass extends Specification{

    // Below methods are known as Fixture methods
    def setupSpec(){
        println("Entered setup spec method")
    }

    def cleanupSpec(){
        println("Entered cleanup spec method")
    }

    def setup(){
        println("Entered setup method")
    }


    def cleanup(){
        println("Entered clean up method")
    }

    // Below methods are known as Feature methods

    @Ignore
    def "Sample Feature Test Method"(){
        println("Entered in to sample feature test method")
        when:
        println("Entered in to when clause")

        then:
        println("Entered in to then clause")
        true
    }

    @Ignore
    def "Adding all blocks of spock features"(){
        setup:
        println("setup or given: This is used for setting up this feature method. We can also use give name instead of setup. " +
                "This should be used only once and shouldn't be repeated and no others blocks should be preceded before this block")

        when:
        println("when: This method is used for specifying the operation that has to be performed")

        then:
        println("then: This method is used for verifying whether the response is valid or not based on above when condition")

        expect:
        println("expect: This method is used to perform both operation and validation of responses under single block")

        cleanup:
        println("cleanup: This method is used to perform clean up operations after execution of above blocks is completed. " +
                "This should be used only once and shouldn't be repeated and only where block can be written after this block")

        //where:
        //println("This method is used to perform data driven features in spock. This should be used only once and shouldn't be repeated")
    }

    @Ignore
    def "Implement a simple data driven scenario"(){

        when:
        def v = (a+b)

        then:
        v == c


        where:
        a << [1,2]
        b << [5,6]
        c << [6,8]

    }

    @Ignore
    def "Implement a simple data driven scenario like username and password"(){

        when:
        enterunsernameandpassword(username,password)

        then:
        true

        where:
        username << ["user1","user2"]
        password << ["pass1","pass2"]
    }

    def "Implement a simple data driven scenario like username and password using data table"(){

        when:
        enterunsernameandpassword(username,password)

        then:
        true

        where:
        username|password
        "user1"|"pass1"
        "user2"|"pass2"
    }


    def enterunsernameandpassword(u,p){
        println("u name:"+u)
        println("p name:"+p)
    }


}
