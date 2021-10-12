package br.com.bscpaz.threads.runnable;

import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;

import br.com.bscpaz.threads.dto.DefendantDto;
import br.com.bscpaz.threads.entity.Defendant;

public class DefendantHashRunnable implements Runnable {
    
    private static final String ENCONDE_SHA256 = "SHA-256";
    private static final String ENCONDE_UTF8 = "UTF-8";

    private CountDownLatch countDownLatch = null;
    private DefendantDto defendantDto = null;

    public DefendantHashRunnable(DefendantDto defendantDto, CountDownLatch countDownLatch) {
        this.defendantDto = defendantDto;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(String.format("[%s] Processing the '%s'...", 
            Thread.currentThread().getName(), this.defendantDto.getDefendant().getName() ));

        generateHashOfName();
    }

    private void generateHashOfName() {
        try {
            Defendant defendant = this.defendantDto.getDefendant();
            String hash = getHash(defendant.getName());
            defendant.setHashName(hash);

            this.defendantDto.setSuccessfullyProcessed(true);
        } catch (Exception e) {
            this.defendantDto.setSuccessfullyProcessed(false);
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }

    private String getHash(String name) throws Exception {
        /*
        //This simulates an error in some entity.
        if (name.equals("Isaac Carter")) {
            throw new RuntimeException();
        }
        */

        StringBuilder text = new StringBuilder();
        MessageDigest algorithm = MessageDigest.getInstance(ENCONDE_SHA256);
        byte hash[] = algorithm.digest(name.getBytes(ENCONDE_UTF8));

        for (byte b : hash) {
            /*  %[flags][width]conversion
                    flag '0': the result will be zero-padded
                    width = 2
                    conversion 'X': the result is formatted as a hexadecimal integer, uppercase 
            */
            text.append(String.format("%02X", b));
        }
        return text.toString();
    }
}
