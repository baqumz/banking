package com.mindhub.banking;

import com.mindhub.banking.models.*;
import com.mindhub.banking.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class BankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(
			ClientRepository cli
			, AccountRepository acc
			, TransactionRepository tra
			, LoanRepository loa
			, ClientLoanRepository clil
			, CardRepository ca
			) {
		return(args) -> {

			LocalDate currentDate = LocalDate.now();

			// App data
			//loa.save(new Loan("Hipotecario", 500000.0, List.of(12,24, 36, 48, 60)));
			//loa.save(new Loan("Personal", 100000.0, List.of(6,12, 24)));
			//loa.save(new Loan("Automotriz", 300000.0, List.of(6,12, 24, 36)));

			// Melba client data

			Client melba = new Client("Melba", "Morel", "Morel@gmail.com");

			Account melbaAccount1 = new Account("VIN001", currentDate, 5000.0);
			Account melbaAccount2 = new Account("VIN002", currentDate.plusDays(1), 7500.0);

			Transaction melbaTransaction1 = new Transaction(TransactionType.CREDIT, LocalDate.now(), "description1", -1000.0, melbaAccount1);
			Transaction melbaTransaction2 = new Transaction(TransactionType.DEBIT, LocalDate.now(), "description1", -1000.0, melbaAccount1);

			Loan melbaLoan1 = new Loan("Hipotecario", 400000.0, List.of(60));
			Loan melbaLoan2 = new Loan("Personal", 50000.0, List.of(12));


			ClientLoan melbaClientLoan1 = new ClientLoan(melba, melbaLoan1, 60, 400000.0);
			ClientLoan melbaClientLoan2 = new ClientLoan(melba, melbaLoan2, 12, 50000.0);

			Card melbaCard1 = new Card(melba, 123, CardType.DEBIT, CardColor.GOLD);
			Card melbaCard2 = new Card(melba, 321, CardType.CREDIT, CardColor.TITANIUM);

			melba.addAccount(melbaAccount1);
			melba.addAccount(melbaAccount2);

			melbaAccount1.addTransaction(melbaTransaction1);
			melbaAccount1.addTransaction(melbaTransaction2);

			melba.addClientLoan(melbaClientLoan1);
			melba.addClientLoan(melbaClientLoan2);

			melbaLoan1.addClientLoan(melbaClientLoan1);
			melbaLoan2.addClientLoan(melbaClientLoan2);

			melba.addCard(melbaCard1);
			melba.addCard(melbaCard2);

			cli.save(melba);
			acc.save(melbaAccount1);
			acc.save(melbaAccount2);
			tra.save(melbaTransaction1);
			tra.save(melbaTransaction2);
			loa.save(melbaLoan1);
			loa.save(melbaLoan2);
			ca.save(melbaCard1);
			ca.save(melbaCard2);
			clil.save(melbaClientLoan1);
			clil.save(melbaClientLoan2);

			// Other client

			Client other = new Client("other", "other", "other@gmail.com");

			Account otherAccount1 = new Account("VIN003", currentDate, 5000.0);
			Account otherAccount2 = new Account("VIN004", currentDate.plusDays(1), 7500.0);

			Transaction otherTransaction1 = new Transaction(TransactionType.CREDIT, LocalDate.now(), "description1", -1000.0, otherAccount1);
			Transaction otherTransaction2 = new Transaction(TransactionType.DEBIT, LocalDate.now(), "description1", -1000.0, otherAccount1);

			Loan otherLoan1 = new Loan("Personal", 100000.0, List.of(24));
			Loan otherLoan2 = new Loan("Automotriz", 200000.0, List.of(36));

			ClientLoan otherClientLoan1 = new ClientLoan(other, otherLoan1, 60, 400000.0);
			ClientLoan otherClientLoan2 = new ClientLoan(other, otherLoan2, 12, 50000.0);

			Card otherCard1 = new Card(other, 345, CardType.CREDIT, CardColor.SILVER);

			other.addAccount(otherAccount1);
			other.addAccount(otherAccount2);

			otherAccount1.addTransaction(otherTransaction1);
			otherAccount1.addTransaction(otherTransaction2);

			other.addClientLoan(otherClientLoan1);
			other.addClientLoan(otherClientLoan2);

			otherLoan1.addClientLoan(otherClientLoan1);
			otherLoan2.addClientLoan(otherClientLoan2);

			other.addCard(otherCard1);

			cli.save(other);
			acc.save(otherAccount1);
			acc.save(otherAccount2);
			tra.save(otherTransaction1);
			tra.save(otherTransaction2);
			loa.save(otherLoan1);
			loa.save(otherLoan2);
			ca.save(otherCard1);
			clil.save(otherClientLoan1);
			clil.save(otherClientLoan2);

		};
	}

}

