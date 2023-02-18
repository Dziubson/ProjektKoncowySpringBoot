package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Transaction;
import com.example.demo.repository.DataRepository;
import com.example.demo.repository.UserRepository;


@Service
public class ShowService {

	@Autowired
	DataRepository dataRepository;
	@Autowired
	UserRepository userRepository;

	public List<Transaction> showTransaction(String uname) {
		return dataRepository.showTransaction(uname);
	}
}
