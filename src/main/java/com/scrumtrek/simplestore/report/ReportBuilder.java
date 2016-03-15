package com.scrumtrek.simplestore.report;

import com.scrumtrek.simplestore.*;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReportBuilder {
    
    /**
     * все известные системе прайс-коды
     */
    private final Map<String, PriceCode> priceCodes;
    
    /**
     * парсит конфиг с прайс кодами.
     * <br> формат конфига (разделитель - пробел): 
     * <br> название_прайс_кода
     * <br> не_зависящая_от_количества_дней_цена_оенты
     * <br> количество дней ренты, за превышение которых начисляется доплата
     * <br> коэффициент расчета доплаты за превышение срока ренты <code>PriceCode.days</code>
     * @param priceCodesSource путь к конфигу с прайс кодами
     */
    public ReportBuilder(String priceCodesSource) {
        priceCodes = new HashMap<>();
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(priceCodesSource)) {
              Scanner sc = new Scanner(is);
              while (sc.hasNextLine()) {
                  String line = sc.nextLine();
                  String[] tokens = line.split(" ");
                  PriceCode.TYPE type = PriceCode.TYPE.valueOf(tokens[4]);
                  PriceCode pc = null;
                  switch(type) {
                      case R :
                          pc = new RegularPriceCode(tokens[0], new Double(tokens[1]),
                          new Integer(tokens[2]), new Double(tokens[3]));
                          break;
                      case C:
                          pc = new ChildrensPriceCode(tokens[0], new Double(tokens[1]),
                          new Integer(tokens[2]), new Double(tokens[3]));
                          break;
                      case N:
                          pc = new NewReleasePriceCode(tokens[0], new Double(tokens[1]),
                          new Integer(tokens[2]), new Double(tokens[3]));
                          break;
                  }
                  priceCodes.put(pc.getName(), pc);
              }
        } catch (Exception e) {
            System.out.println("failed to parce price codes config");
            e.printStackTrace();
        }
        
    }
    
	public String buildReport(Customer customer) throws Exception
	{
		double totalAmount = 0;
		int frequentRenterPoints = 0;
				
		String result = "Rental record for " + customer.getName() + "\n";
		
		for(Rental rental: customer.getM_Rentals()) {
			double thisAmount = 0;
			
			// Determine amounts for each line
                        PriceCode pc = priceCodes.get(rental.getMovie().getPriceCodeName());
                        thisAmount = pc.countAmount(rental);
                        
                        if (thisAmount < 0) {
                            throw new Exception("amount is less than 0!");
                        }
                        
			// Add frequent renter points
			frequentRenterPoints++;

			// Add bonus for a two-day new-release rental
			if ((rental.getMovie().getPriceCodeName().equals("NEW_RELEASE")) 
                                && (rental.getDaysRented() > 1))
			{
				frequentRenterPoints ++;
			}

			// Show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}

		// Add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points.";
		return result;
	}

    public String buildReportJson(Customer customer) throws Exception {
        String result = "customer: {\n" + "\tname: " + customer.getName() + " \n \trentals: {\n";
        for (Rental rental : customer.getM_Rentals()) {
            result += "\t\tmovie:" + rental.getMovie().getM_Title() +
                    "\n\t\tpriceName:" + rental.getMovie().getPriceCodeName() +
                    "\n\t\tdays:" + rental.getDaysRented() + "\n\t\t}";
            result += "\n}";
        }
        return result;
    }

}
