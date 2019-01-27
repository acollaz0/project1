package doa_test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import service.TransactionService;

public class TransactionDAOTest {

	@Test
	public void getTransactions() {
		assertTrue(TransactionService.getTransactions(166).size() > 0);
	}
	
	@Test
	public void getTransactionsFalse() {
		assertFalse(TransactionService.getTransactions(166).size() == 0);
	}
}
