package za.co.nedj.train.currencyconverter.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.nedj.train.currencyconverter.model.Quotes;

@Repository
public interface QuotesRepo extends JpaRepository<Quotes, Integer> {

}
