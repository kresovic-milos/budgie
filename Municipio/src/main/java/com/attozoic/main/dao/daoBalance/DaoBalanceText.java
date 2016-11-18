package com.attozoic.main.dao.daoBalance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.model.balance.BalanceText;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.repositoriesBalance.RepositoryBalanceText;

@Repository
public class DaoBalanceText extends DaoEntity {

	@Autowired
	private RepositoryBalanceText repoBalanceText;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoBalanceText;
	}

	@Override
	public SuperEntity update(SuperEntity superEntity) {
		BalanceText bt = (BalanceText)superEntity;
		BalanceText balanceText = (BalanceText)getRepoEntity().findOne(superEntity.getUid());
		balanceText.setValue(bt.getValue());
		return super.update(balanceText);
	}
	
}
