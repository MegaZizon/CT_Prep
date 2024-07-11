import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class HelloJava {

	public static void main(String[] args) {
		String tradeDate="",tradeUserId="",tradeProductId="";
		int k=10;
		String date="2020-01-05";
	    String[] records = {
	            "2019-12-24 uid1 pid1",
	            "2019-12-27 uid2 pid2",
	            "2020-01-04 uid3 pid3",
	            "2020-01-04 uid3 pid3"
	        };
	    List<DataEntry> allDataList = new ArrayList<>();
	    
	    for (String entry : records) {
	        String[] parts = entry.split(" ");
	        tradeDate = parts[0];
	        tradeUserId = parts[1].substring(3); // "uid" 이후의 숫자 부분
	        tradeProductId = parts[2].substring(3); // "pid" 이후의 숫자 부분
	        DataEntry dataEntry = new DataEntry(LocalDate.parse(
	        		tradeDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")), tradeUserId, tradeProductId);
	        allDataList.add(dataEntry);
	    }
		for(DataEntry et : allDataList) {
			System.out.println(et);
		}
	    
	    LocalDate endDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    
	    System.out.println("endDate : " + endDate);

	    int addMonth=0,addYear=0;
		int day=endDate.getDayOfMonth();
	    for(int i=0; i<k-1; i++) {
	    	if(day == 0) {
	    		day=30;
	    		addMonth = -1;
	    		if(endDate.getMonthValue()==1) {
	    			addYear = -1;
	    			addMonth = 11;
	    		}
	    	}
	    	day--;
	    	
	    }
	    System.out.print(day+"일");
	    int month=endDate.getMonthValue()+addMonth;
	    System.out.print(month+"월");
	    int year = endDate.getYear()+addYear;
	    System.out.print(year+"년");
	    
	    String tempStartDate = Integer.toString(year)+Integer.toString(month)+Integer.toString(day); 
	    
	    LocalDate startDate = LocalDate.parse(tempStartDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
	    
	    System.out.println("\nstartDate: "+startDate);
	    
	    List<DataEntry> dataList = new ArrayList<>();
		List<String> productList = new ArrayList<>();
	    Map<String, Integer> productMap = new HashMap<>();
	    
		for(DataEntry et : allDataList) {
	        if (et.getDate().isEqual(startDate) || et.getDate().isAfter(startDate)) {
	        	if(et.getDate().isAfter(endDate)) {
	        		continue;
	        	}
	            System.out.println("같은 날짜 혹은 N일 이내입니다.");
	            dataList.add(et);
	            
	        } else {
	            System.out.println("이전 날짜입니다.");
	        } 
	        
		}
		
		
		for(DataEntry et : dataList) {
			if(productList.contains(et.getProductId())) {
				continue;
			}
			productList.add(et.getProductId());
		}
		
		for(String s : productList) {
			for(DataEntry et : dataList) {
				if (productMap.containsKey(et.getProductId())) {
	        		productMap.put(et.getProductId(), productMap.get(et.getProductId()) + 1);
	        	} else {
	        		productMap.put(et.getProductId(), 1);
	        	}
			}
		}
		
		

        
//        for (DataEntry et : dataList) {
//        	if (userMap.containsKey(et.getProductId())) {
//        		productMap.put(et.getProductId(), productMap.get(et.getProductId()) + 1);
//        	} else {
//        		productMap.put(et.getProductId(), 1);
//        	}
//      	}
 
    	
//        Map<String, Integer> productMap = new HashMap<>();
//        Set<DataEntry> productSet = new HashSet<>(dataList);
        
        
//      if (countMap.containsKey(str)) {
//      countMap.put(str, countMap.get(str) + 1);
//  } else {
//      countMap.put(str, 1);
//  }

        
        
//        for (String str : uniqueSet) {
//            System.out.println(str);
//        }
//        
//    	for(DataEntry et : dataList) {
//    		if(countCustomer.containsKey(et.getProductId()))
//    	}
//    	
//    	List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("a");
//        list.add("a");
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("c");
//
//        // 각 요소의 개수를 저장할 맵
//        Map<String, Integer> countMap = new HashMap<>();
//        Set<String> uniqueSet = new HashSet<>(list);
//
//        // 리스트를 순회하며 개수 세기
//        for (String str : list) {
//            if (countMap.containsKey(str)) {
//                countMap.put(str, countMap.get(str) + 1);
//            } else {
//                countMap.put(str, 1);
//            }
//        }
//
//        // 결과 출력
        for (Map.Entry<String, Integer> entry : productMap.entrySet()) {
            System.out.println(entry.getKey() + "의 개수: " + entry.getValue());
        }
//    	
//    	
//    	
//	
	}

}

class DataEntry {
    private LocalDate date;
    private String userId;
    private String productId;
    

    public DataEntry(LocalDate date, String userId, String productId) {
        this.date = date;
        this.userId = userId;
        this.productId = productId;
    }

    // Getters and setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

}


class ProductEntry {
    private String productId;
    private int repeatCustomers;
    private int totalCustomers;
    private int purchaseCount;

    public ProductEntry(String productId) {
        this.productId = productId;
    }

    public void incrementRepeatCustomers() {
        repeatCustomers++;
    }

    public void incrementTotalCustomers() {
        totalCustomers++;
    }

    public void incrementPurchaseCount() {
        purchaseCount++;
    }

    public String getProductId() {
        return productId;
    }

    public int getRepeatCustomers() {
        return repeatCustomers;
    }

    public int getTotalCustomers() {
        return totalCustomers;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public double getRepurchaseRate() {
        return totalCustomers == 0 ? 0 : (double) repeatCustomers / totalCustomers * 100;
    }





}