package com.csi.repo;
import com.csi.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface  CustomerRepo extends MongoRepository<Customer,Integer> {

//
    //
    //

}
