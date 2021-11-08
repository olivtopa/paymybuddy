package com.olivtopa.paymybuddy.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.olivtopa.paymybuddy.model.MoneyTransaction;

@Repository
public interface MoneyTransactionRepository extends CrudRepository<MoneyTransaction, Integer> {

	Iterable<MoneyTransaction> findAllByContactEmailOrigin(String emailOrigin);
}
