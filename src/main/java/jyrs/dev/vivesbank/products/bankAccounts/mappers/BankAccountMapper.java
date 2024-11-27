package jyrs.dev.vivesbank.products.bankAccounts.mappers;

import jyrs.dev.vivesbank.products.bankAccounts.dto.BankAccountRequest;
import jyrs.dev.vivesbank.products.bankAccounts.dto.BankAccountResponse;
import jyrs.dev.vivesbank.products.bankAccounts.models.BankAccount;
import jyrs.dev.vivesbank.products.bankAccounts.models.Type.AccountType;
import jyrs.dev.vivesbank.products.creditCards.dto.CreditCardResponse;
import jyrs.dev.vivesbank.products.creditCards.models.CreditCard;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {

    public BankAccountResponse toResponse(BankAccount account) {
        if (account == null) {
            return null;
        }

        return BankAccountResponse.builder()
                .iban(account.getIban())
                .accountType(account.getAccountType())
                .balance(account.getBalance())
                .creditCard(toCardDto(account.getCreditCard()))
                .build();
    }

    public CreditCardResponse toCardDto(CreditCard creditCard){
        if (creditCard == null) {
            return null;
        }

        return new CreditCardResponse(
                creditCard.getNumber(),
                creditCard.getExpirationDate().toString(),
                creditCard.getCvc()
        );
    }

    public BankAccount toBankAccount(BankAccountRequest bankAccountRequest) {
        if (bankAccountRequest == null) {
            return null;
        }

        return BankAccount.builder()
                .accountType(AccountType.valueOf(bankAccountRequest.getAccountType()))
                .balance(0.0)
                .creditCard(null)
                .build();
    }


}