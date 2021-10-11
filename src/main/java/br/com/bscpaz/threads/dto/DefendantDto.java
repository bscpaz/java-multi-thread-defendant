package br.com.bscpaz.threads.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.bscpaz.threads.entity.Defendant;

/* This is a class decorator for Defendant entity */
public class DefendantDto {
    
    private boolean isSuccessfullyProcessed = false;
    private Defendant defendant = null;

    public DefendantDto(Defendant defendant) {
        this.defendant = defendant;
    }

    public Defendant getDefendant() {
        return defendant;
    }

    public boolean isSuccessfullyProcessed() {
        return isSuccessfullyProcessed;
    }

    public void setSuccessfullyProcessed(boolean isSuccessfullyProcessed) {
        this.isSuccessfullyProcessed = isSuccessfullyProcessed;
    }

    public static List<DefendantDto> convert(List<Defendant> defedants) {
        return defedants.stream().map(DefendantDto::new).collect(Collectors.toList()) ;
    }

    @Override
    public String toString() {
        return String.format("%s - Successfully Processed = [%s]", this.defendant.toString(), isSuccessfullyProcessed);
    }
}
