package org.stepdefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class GenrateReports {
	
	public static void jvmScript(String jsonpath) {
		File f= new File("C:\\Users\\AFRITH\\eclipse-workspace\\MyProject\\target\\cucumber-reports\\jvmreport");
		Configuration c=new Configuration(f, "plumdeluxe");
		List<String>l=new ArrayList<String>();
		l.add(jsonpath);
		
		ReportBuilder r=new ReportBuilder(l, c);
		r.generateReports();
		
	}

}
