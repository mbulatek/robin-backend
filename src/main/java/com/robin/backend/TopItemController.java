package com.robin.backend;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.robin.backend.TopItem;

@RestController
public class TopItemController {
	private static final Logger LOGGER = Logger.getLogger( TopItemController.class.getName() );
	
	@RequestMapping("/insertProgress")
    public InsertingResult insertProgress(@RequestParam(value="userName", required=true) String userName,
    		@RequestParam(value="userMail", required=true) String userMail,
    		@RequestParam(value="levelReached", required=true) int levelReached) {
		
		LOGGER.log(Level.INFO, "insertProgress request: userName=[" + userName + "], userMail=[" + userMail + "], levelReached=[" + levelReached + "]");
		
		MySQLAccess dbAccess = new MySQLAccess();
		
		dbAccess.updateResult(new TopItem(userName, userMail, levelReached));
				
		return new InsertingResult(true, 1);
    }
}
