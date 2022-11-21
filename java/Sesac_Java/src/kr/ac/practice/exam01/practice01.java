package kr.ac.practice.exam01;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class practice01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	String a = "admin";
	String b = new String("admin");
	
	System.out.println(a == b);
	System.out.println(a.equals(b));
	System.out.println(a.compareTo(b)==0);
		
	

	String c = new String("12345");
	int num = Integer.parseInt(c);
	System.out.println(num * 1);
	
	int[] score = {1,2,3};
	ArrayList<String> list = new ArrayList<String>();
	ArrayList<String> a;
	
	}
}
