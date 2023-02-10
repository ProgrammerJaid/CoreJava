package com.semanticssquare.basics;
public class CarPriceEstimtor{
	
		/*public double getSalePrice(String makeAndMOdel,int yearManufactured,double milesDriven,int airBagsCount,boolean hasAbs,
							boolean hasEbd,boolean hasRearViewCamera,boolean hasSunRoof,boolean hasAutoAC,boolean hasAccidentHistory)
					{
					double salePrice = getPrice(makeAndMOdel,yearManufactured);
					int currentYear = LocalDate.now().getYear();
					int ageOfCar = currentYear-yearManufactured+1;
					System.out.println("ageOfCar: "+ ageOfCar);
					
					if(ageOfCar<=10)
					{
						salePrice = salePrice*ageOfCar*.95;
						System.out.println("salePrice after depriciation: "+salePrice);
						if((airBagsCount>=2)&&hasAbs&&hasEbd)
							continue;
						else
							salePrice=salePrice-1000;
					}
					else
						return salePrice*0.1;
					
					System.out.println("salePrice after accounting for security features: "+salePrice);
					
					if(hasRearViewCamera&& hasSunRoof||hasAutoAC)
						salePrice+=500;
					
					System.out.println("salePrice after accounting comfort features: " +salePrice);
					
					if(hasAccidentHistory)
						salePrice-=500;
					
					System.out.println("salePrice after accounting for past accidents: "+salePrice);
					
					double expectedMIlesDriven = ageOfCar*10000.0;
					double additionalMiles = milesDriven - expectedMIlesDriven;
					
					if(additionalMiles>1000 && additionalMiles<=10000)
						salePrice-=500;
					
					else if(additionalMiles>10000 && additionalMiles<=30000)
						salePrice-=1000;
					
					else
						salePrice-=1500;
					
					System.out.println("salePrice after accounting for miles driven : "+salePrice);
					
					return salePrice;
					
					}
			
		private double getPrice(String makeAndMOdel,int yearManufactured){
			if(makeAndMOdel.equalsIgnoreCase("ford ecosport"))
					return 20000.0;
			else if(makeAndMOdel.equalsIgnoreCase("honda city"))
					return 25000.0;
			else if(makeAndMOdel.equalsIgnoreCase("toyota camry hybrid"))
					return 30000.0;
			else
				return 20000.0;
		}
	
	public static void main(String[] args) {
		CarPriceEstimator carPriceEstimator = new CarPriceEstimator();
		double salesPrice = carPriceEstimator.getSalePrice("ford ecosport", 2018, 60000.0, 2, true, false, true, false, false, true);		
	}*/
}