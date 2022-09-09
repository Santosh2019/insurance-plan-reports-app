package org.reports.runner;

import org.reports.bean.EligibilityDetails;
import org.reports.dao.EligibilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

	@Autowired
	private EligibilityRepository repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		EligibilityDetails elgDetails = new EligibilityDetails();
		elgDetails.setEligibilityId(1);
		elgDetails.setName("Santosh");
		elgDetails.setPlanName("JAVA");
		elgDetails.setMobileNumber(9325691241l);
		elgDetails.setGender('M');
		elgDetails.setSsn(1256545646l);
		elgDetails.setPlanStatus("Approved");
		elgDetails.setEmaiId("slimbale@gmail.com");
		repo.save(elgDetails);

		EligibilityDetails object = new EligibilityDetails();
		object.setEligibilityId(2);
		object.setName("Gajanan");
		object.setPlanName("JAVA");
		object.setMobileNumber(9325691241l);
		object.setGender('F');
		object.setSsn(1256545646l);
		object.setPlanStatus("Denied");
		object.setEmaiId("gajananl.coder@gmail.com");
		repo.save(object);

		EligibilityDetails object1 = new EligibilityDetails();
		object1.setEligibilityId(3);
		object1.setName("Govind");
		object1.setPlanName("LINUX");
		object1.setMobileNumber(9325691241l);
		object1.setGender('M');
		object1.setSsn(1256545646l);
		object1.setPlanStatus("Approved");
		object1.setEmaiId("slimbale@gmail.com");
		repo.save(object1);
	
		EligibilityDetails object2 = new EligibilityDetails();
		object2.setEligibilityId(4);
		object2.setName("Krish");
		object2.setPlanName("AWS");
		object2.setMobileNumber(9552231581l);
		object2.setGender('T');
		object2.setSsn(1256545646l);
		object2.setPlanStatus("Denied");
		object2.setEmaiId("ganesh@gmail.com");
		repo.save(object2);
	}
}
