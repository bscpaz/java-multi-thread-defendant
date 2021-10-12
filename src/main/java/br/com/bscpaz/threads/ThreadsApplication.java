package br.com.bscpaz.threads;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.bscpaz.threads.dto.DefendantDto;
import br.com.bscpaz.threads.entity.Defendant;
import br.com.bscpaz.threads.runnable.DefendantHashRunnable;
import br.com.bscpaz.threads.service.DefendantService;

/**
This is a concept of proof of multi-thread execution
@author Bruno Paz
*/
@SpringBootApplication
public class ThreadsApplication {

	private boolean isAllProcessedSucessfully = true;

	@Autowired
	private DefendantService defendantService;

	public static void main(String[] args) {
		SpringApplication.run(ThreadsApplication.class, args);
	}

	@PostConstruct
	public void generateDefendantsHashsNamesInMultiThreadProcess() {
		List<Defendant> defedants = defendantService.getAll();
		List<DefendantDto> defedantsDtos = DefendantDto.convert(defedants);

		CountDownLatch countDownLatch = new CountDownLatch(defedantsDtos.size());
		ExecutorService executor = Executors.newFixedThreadPool(2);

		try {
			for (DefendantDto defendantDto : defedantsDtos) {
				executor.execute(new DefendantHashRunnable(defendantDto, countDownLatch));
			}

			countDownLatch.await();

			//This can be only executed after all "excute()" method has finished.
			for (DefendantDto defendantDto : defedantsDtos) {
				System.out.println(defendantDto);

				if (!defendantDto.isSuccessfullyProcessed()) {
					isAllProcessedSucessfully = false;
				}
			}
			System.out.println(String.format("\n\nIs All Processed Sucessfully = [%s]\n\n", isAllProcessedSucessfully));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!executor.isShutdown()) {
				executor.shutdown();
			}
		}
	}
}
