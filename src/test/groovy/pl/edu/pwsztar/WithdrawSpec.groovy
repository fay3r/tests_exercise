package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class WithdrawSpec extends Specification {

    static BankOperation bank;

    def setupSpec() {
        bank = new Bank();
    }

    @Unroll
    def "should withdraw #amount to #accountNumber"() {

        given:"Bank"
            bank.createAccount()
            bank.deposit(accountNumber,amount)

        when: "the account is deleted"
            def bool = bank.withdraw(accountNumber,withdrawAmount)
        then: "expected result"
            bool == expectedResult

        where:
        accountNumber   | amount | withdrawAmount  | expectedResult
        1               | 250    | 100             | true
        2               | 2      | 123             | false
    }
}
