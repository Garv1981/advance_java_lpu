package com.project.lms.service;

import com.project.lms.entity.Loan;
import java.time.LocalDate;
import java.util.List;

public interface LoanService {

    Loan issueBook(Long memberId, Long bookId, LocalDate dueDate);

    Loan returnBook(Long loanId);

    Loan getLoanById(Long loanId);

    List<Loan> getAllLoans();

    List<Loan> getLoansByMember(Long memberId);
}