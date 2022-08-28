package fa.training.service;

import fa.training.entities.Book;
import fa.training.entities.Magazine;

import java.util.List;

public interface MagazineService {
    boolean addMagazine(Magazine magazine);

    List<Magazine> findMagazineByPublicationYearAndPublisher(int publicationYear, String publisher);

    List<Magazine> getTenMagazinesWithLargestVolume();
}
