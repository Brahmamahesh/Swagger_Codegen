package com.kaiburrtask2.swagger_codegen;

import com.kaiburrtask2.swagger_codegen.model.Server;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//This interface named 'ServerRepository' that extends the 'MongoRepository' interface
//In this interface, we are defining a custom method 'findByNameContaining' that will be used to find servers by name.
public interface ServerRepository  extends MongoRepository<Server,String>
{
    List<Server> findByNameContaining(String name);

}
