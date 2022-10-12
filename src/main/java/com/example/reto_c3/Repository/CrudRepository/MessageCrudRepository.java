package com.example.reto_c3.Repository.CrudRepository;

import com.example.reto_c3.Model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
