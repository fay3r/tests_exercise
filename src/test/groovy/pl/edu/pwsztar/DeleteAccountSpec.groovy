package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class DeleteAccountSpec extends Specification{

    static BankOperation bank;

    def setupSpec() {
        bank = new Bank();
    }

    @Unroll
    def "should delete account with #accountNumber"() {

        given:"Bank"
            bank.createAccount()
            bank.createAccount()
            bank.deposit(accountNumber,amount)


        when: "the account is deleted"
            def expectedAmount = bank.deleteAccount(accountNumber)
        then: "expected result"
            expectedAmount == expectedResult

        where:
            accountNumber   | amount  | expectedResult
            1               | 250     | 250
            123             | 1245    | -1
    }

}
