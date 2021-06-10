package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class DepositSpec  extends Specification{

    static BankOperation bank;

    def setupSpec() {
        bank = new Bank();
    }

    @Unroll
    def "should add #amount to #accountNumber"() {

        given:"Bank"
            bank.createAccount();

        when: "the account is deleted"
            def bool = bank.deposit(accountNumber,amount)
        then: "expected result"
            bool == expectedResult

        where:
        accountNumber   | amount  | expectedResult
        1               | 250     | true
        123             | 1245    | false
    }
}
