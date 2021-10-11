package br.com.bscpaz.threads.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.bscpaz.threads.entity.Defendant;

/*
    This is a fake repository
*/
@Repository
public class DefendantRepository {
    
    public List<Defendant> getAll() {
        List<Defendant> defendants = new ArrayList<>();
        
        defendants.add(new Defendant("Jack Bauer"));
        defendants.add(new Defendant("Teri Bauer"));
        defendants.add(new Defendant("Nina Myers"));
        defendants.add(new Defendant("Kim Bauer"));
        defendants.add(new Defendant("David Palmer"));
        defendants.add(new Defendant("Tony Almeida"));
        defendants.add(new Defendant("Sherry Palmer"));
        defendants.add(new Defendant("George Mason"));
        defendants.add(new Defendant("Milo Pressman"));
        defendants.add(new Defendant("Kate Warner"));
        defendants.add(new Defendant("Michelle Dessler"));
        defendants.add(new Defendant("Chase Edmunds"));
        defendants.add(new Defendant("Chloe O'Brian"));
        defendants.add(new Defendant("Wayne Palmer"));
        defendants.add(new Defendant("Audrey Raines"));
        defendants.add(new Defendant("Erin Driscoll"));
        defendants.add(new Defendant("Sarah Gavin"));
        defendants.add(new Defendant("Curtis Manning"));
        defendants.add(new Defendant("James Heller"));
        defendants.add(new Defendant("Bill Buchanan"));
        defendants.add(new Defendant("Charles Logan"));
        defendants.add(new Defendant("Edgar Stiles"));
        defendants.add(new Defendant("Martha Logan"));
        defendants.add(new Defendant("Morris O'Brian"));
        defendants.add(new Defendant("Karen Hayes"));
        defendants.add(new Defendant("Tom Lennox"));
        defendants.add(new Defendant("Nadia Yassir"));
        defendants.add(new Defendant("Sandra Palmer"));
        defendants.add(new Defendant("Ethan Kanin"));
        defendants.add(new Defendant("Allison Taylor"));
        defendants.add(new Defendant("Henry Taylor"));
        defendants.add(new Defendant("Renee Walker"));
        defendants.add(new Defendant("Larry Moss"));
        defendants.add(new Defendant("Sean Hillinger"));
        defendants.add(new Defendant("Janis Gold"));
        defendants.add(new Defendant("Omar Hassan"));
        defendants.add(new Defendant("Brian Hastings"));
        defendants.add(new Defendant("Dana Walsh"));
        defendants.add(new Defendant("Rob Weiss"));
        defendants.add(new Defendant("Arlo Glass"));
        defendants.add(new Defendant("Cole Ortiz"));
        defendants.add(new Defendant("Kate Morgan"));
        defendants.add(new Defendant("Mark Boudreau"));
        defendants.add(new Defendant("Erik Ritter"));
        defendants.add(new Defendant("Jordan Reed"));
        defendants.add(new Defendant("Adrian Cross"));
        defendants.add(new Defendant("Steve Navarro"));
        defendants.add(new Defendant("Eric Carter"));
        defendants.add(new Defendant("Rebecca Ingram"));
        defendants.add(new Defendant("Nicole Carter"));
        defendants.add(new Defendant("Keith Mullins"));
        defendants.add(new Defendant("Isaac Carter"));
        defendants.add(new Defendant("Andy Shalowitz"));
        defendants.add(new Defendant("Mariana Stiles"));
        defendants.add(new Defendant("Ben Grimes"));
        defendants.add(new Defendant("Nilaa Mizrani"));
        defendants.add(new Defendant("Jadalla bin-Khalid"));
        defendants.add(new Defendant("Henry Donovan"));
        
        return defendants;
    }
}



