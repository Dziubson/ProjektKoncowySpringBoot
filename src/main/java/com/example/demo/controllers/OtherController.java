package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.CheckProfile;
import com.example.demo.service.RegistrationService;
import com.example.demo.service.ShowService;
import com.example.demo.service.TransferService;


@Controller
public class OtherController {
    @Autowired
    UserRepository userRepository;
@Autowired
CheckProfile checkProfile;

@Autowired 
TransferService transferService;
 
@Autowired
RegistrationService registrationService;

@Autowired
ShowService showService;

 @GetMapping(path="/showimage")
 public String showHome() {
	return "showimage";
 }


 @GetMapping("/getDetails")
 public String showDetails(@CookieValue("User") String fooCookie, @CookieValue("Role") String foooCookie, ModelMap model) {
	 System.out.println("------ ----------------------------"+fooCookie+"-------");
	 model.put("user",checkProfile.getDetails(fooCookie));
	 System.out.println(checkProfile.getDetails(fooCookie).toString());
	 if (foooCookie.equals("admin")){
		 model.put("choose", 2);
	 }else if(foooCookie.equals("emp")){
		 model.put("choose", 1);
	 }
	return "/showdetails";
 }
 
 @GetMapping(path="/transfermoney")
 public String transferMoney() {
	return "transfer";
 }

	@GetMapping(path="/loanregister")
	public String loanMoney() {
		return "loanregister";
	}
	@PostMapping(path="/"
			+ "loanregister")
	public String loanMoney(@RequestParam Integer accno,
							@RequestParam Integer intrestval,
							@RequestParam Integer loanval,
							ModelMap model, RedirectAttributes redirAttrs) {
		int s=transferService.loan(accno,intrestval,loanval);
		if(s==0)
		{
			redirAttrs.addFlashAttribute("message", "Transaction Unsuccessful");
		}else if(s==1)
		{
			redirAttrs.addFlashAttribute("message", "Transaction Successful");
		}

		return "redirect:/loanregister";
	}
	@GetMapping(path="/deposit")
	public String depositMoney() {
		return "deposit";
	}
	@PostMapping(path="/"
			+ "deposit")
	public String depositMoney(@RequestParam Integer accno,
							@RequestParam Integer depositval,
							ModelMap model, RedirectAttributes redirAttrs) {
		int s=transferService.deposit(accno,depositval);
		if(s==0)
		{
			redirAttrs.addFlashAttribute("message", "Transaction Unsuccessful");
		}else if(s==1)
		{
			redirAttrs.addFlashAttribute("message", "Transaction Successful");
		}

		return "redirect:/deposit";
	}
	@GetMapping(path="/withdraw")
	public String withdrawMoney() {
		return "withdraw";
	}
	@PostMapping(path="/"
			+ "withdraw")
	public String withdrawMoney(@RequestParam Integer accno,
							@RequestParam Integer withdrawval,
							ModelMap model, RedirectAttributes redirAttrs) {
		int s=transferService.withdraw(accno,withdrawval);
		if(s==0)
		{
			redirAttrs.addFlashAttribute("message", "Transaction Unsuccessful");
		}else if(s==1)
		{
			redirAttrs.addFlashAttribute("message", "Transaction Successful");
		}

		return "redirect:/withdraw";
	}

 @PostMapping(path="/"
 		+ "transfermoney")
 public String transferMoney(@RequestParam String username,@RequestParam int amount,@RequestParam String user,ModelMap model, RedirectAttributes redirAttrs) {
	 System.out.println("##########"+LoginController.uname+"######");
	 int s=transferService.transfer(LoginController.uname,user,amount);
	 if(s==0)
	 {
		 redirAttrs.addFlashAttribute("message", "Transaction Unsuccessful");
	 }else if(s==1)
	 {
		 redirAttrs.addFlashAttribute("message", "Transaction Successful");
	 }
	 return "redirect:/transfermoney";
 }
 
 @GetMapping(path="/about")
 public String showAbout() {
	return "about";
 }
 @GetMapping(path="/contact")
 public String showContact() {
	return "contact";
 }
 @GetMapping(path="/addadmin")
 public String addAdmin() {
	return "adminregister";
 }
 @GetMapping(path="/addemp")
 public String addEmp() {
	return "empregister";
 }
 @PostMapping(path="/addadmin")
 public String regAdmin(@RequestParam String name,@RequestParam String username,
		 @RequestParam String password,
		 @RequestParam String accno,@RequestParam int mobno,
		 @RequestParam String address,@RequestParam int ifsc, @RequestParam int balance) {
	 
	 int s=registrationService.addAdmin(name,username,accno,mobno,address,ifsc,balance);
	 int ss=registrationService.addAdminLogin(username,password,"admin");
	return "adminregister";
 }
 @PostMapping(path="/addemp")
 public String regEmp(@RequestParam String name,@RequestParam String username,
		 @RequestParam String password,
		 @RequestParam String accno,@RequestParam int mobno,
		 @RequestParam String address,@RequestParam int ifsc, @RequestParam int balance) {
	 
	 int s=registrationService.addAdmin(name,username,accno,mobno,address,ifsc,balance);
	 int ss=registrationService.addAdminLogin(username,password,"emp");
	return "empregister";
 }
  
 @GetMapping(path="/addcust")
 public String addCust(@CookieValue("Role") String foooCookie,ModelMap model) {
	 if (foooCookie.equals("admin")){
		 model.put("choose", 2);
	 }else if(foooCookie.equals("emp")){
		 model.put("choose", 1);
	 }
	return "custregister";
 }
 @PostMapping(path="/addcust")
 public String regCust(@RequestParam String name,@RequestParam String username,
		 @RequestParam String password,
		 @RequestParam String accno,@RequestParam int mobno,
		 @RequestParam String address,@RequestParam int ifsc, @RequestParam int balance,
					   @CookieValue("Role") String foooCookie,ModelMap model) {
	 
	 int s=registrationService.addAdmin(name,username,accno,mobno,address,ifsc,balance);
	 int ss=registrationService.addAdminLogin(username,password,"cust");
	 if (foooCookie.equals("admin")){
		 model.put("choose", 2);
	 }else if(foooCookie.equals("emp")){
		 model.put("choose", 1);
	 }
	return "custregister";
 }
 
 @GetMapping(path="/showtransaction")
 public String showTransaction(ModelMap model,@CookieValue("User") String foooCookie) {
	 model.put("transaction",showService.showTransaction(foooCookie));
	return "showtransaction";
 }
 
 @GetMapping(path="/logout")
 public String showLogout() {
	 System.out.println(LoginController.uname);
	 LoginController.uname="";
	return "logout";
 }
}