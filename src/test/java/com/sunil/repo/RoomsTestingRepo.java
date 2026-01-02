package com.sunil.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import com.sunil.model.Rooms;
import com.sunil.repository.HMSRoomsRepository;

@DataJpaTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoomsTestingRepo {
	

	
	@Autowired
	private HMSRoomsRepository repo;
	
	
	@Test
	@Commit
	public void rommsSaveCallTesting() {
		
		Rooms room =new	Rooms(null,"AC","789",  "empty");
		
		repo.saveAndFlush(room);
	}

}
