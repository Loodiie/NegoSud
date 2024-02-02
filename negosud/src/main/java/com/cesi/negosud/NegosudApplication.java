package com.cesi.negosud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class NegosudApplication {

	public static void main(String[] args) {
		SpringApplication.run(NegosudApplication.class, args);


		/*Timer timer = new Timer();
		Date firstTime = new Date(System.currentTimeMillis()+5000);
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				System.out.println("info "+ Calendar.getInstance().getTime());
			}
		};
		timer.schedule(task,firstTime,5000);*/

	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
