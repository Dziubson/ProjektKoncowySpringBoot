package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;


@Service
public class TransferService {

	@Autowired
	UserRepository userRepository;
	public int transfer(String source,String dest,int amount)
	{
		String timestamp=userRepository.getDate();
		return userRepository.transfer(source,dest,timestamp,amount);
	}
	public int loan(Integer AccNo,Integer intrest,int loanval)
	{
		String timestamp=userRepository.getDate();
		return userRepository.loan(AccNo,intrest,loanval,timestamp);
	}
	public int deposit(Integer AccNo,int depoval)
	{
		String timestamp=userRepository.getDate();
		return userRepository.deposit(AccNo,depoval,timestamp);
	}
	public int withdraw(Integer AccNo,int withval)
	{
		String timestamp=userRepository.getDate();
		return userRepository.withdraw(AccNo,withval,timestamp);
	}




}
