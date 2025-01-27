package com.mindhub.banking.repositories;

import com.mindhub.banking.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LoanRepository  extends JpaRepository<Loan, Long> {
}
