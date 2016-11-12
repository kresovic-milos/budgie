package com.attozoic.main.repositories.repositoriesBalance;

import org.springframework.stereotype.Repository;

import com.attozoic.main.model.balance.BalanceEconomicAccount;
import com.attozoic.main.repositories.RepositoryEntity;

@Repository
public interface RepositoryBalanceEconomicAccount<T extends BalanceEconomicAccount> extends RepositoryEntity<T> {
}
