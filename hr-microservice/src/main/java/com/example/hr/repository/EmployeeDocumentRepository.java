package com.example.hr.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.hr.document.EmployeeDocument;

public interface EmployeeDocumentRepository extends MongoRepository<EmployeeDocument, String>{
	List<EmployeeDocument> findByBirthYearBetweenAndJobStyle(int fromYear,int toYear,String jobStyle);
	@Query("""
		{
		   $and: [
		      {"birthYear": {$gte: ?1, $lte: ?2}},
		      {"jobStyle": ?3}
		  ]
		}
    """)	
	List<EmployeeDocument> bulGetir(int fromYear,int toYear,String jobStyle);
	
}
