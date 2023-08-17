package com.flamingo.flightbookings.Flamingo.Flights.Booking.services;

import com.flamingo.flightbookings.Flamingo.Flights.Booking.entities.CustomSequences;
import com.mongodb.client.model.Filters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class NextSequenceService
{
    @Autowired
    private MongoOperations mongoOperations;

    public int getNextSequence(String seqName)
    {
        CustomSequences counter = mongoOperations.findAndModify(Query.query(Criteria.where("_id").is(seqName)),
                new Update().inc("seq",1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                CustomSequences.class);
        return  counter.getSeq();
    }
}
