import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class HelloJava {
	
	public static void main(String[] args) {
        int k = 10;
        String date = "2020-01-08";
        String[] records = {
                "2019-12-19 uid1 pid1",
                "2019-12-22 uid1 pid2",
                "2019-12-22 uid1 pid2",
                "2019-12-22 uid1 pid4",
                "2019-12-29 uid1 pid5",
                "2019-12-30 uid2 pid5",
                "2019-12-30 uid1 pid4",
                "2019-12-30 uid1 pid4",
                "2019-12-30 uid2 pid4",
                "2019-12-30 uid1 pid5",
                "2019-12-30 uid2 pid5",
                "2020-01-02 uid1 pid5",
                "2020-01-27 uid1 pid5",
                "2019-01-27 uid2 pid5",
        };

        System.out.println("목표날짜:"+date);
        System.out.println("K:"+k);
        System.out.println("----데이터----");
        for(String record: records) {
        	System.out.println(record);
        }
        System.out.println("----------");
        
        String[] result = solution(records, date, k);
        System.out.println("----결과----:");
        for (String str : result) {
            System.out.println(str);
        }
	}

	public static String[] solution(String[] records,String date,int k) {
		String tradeDate="",tradeUserId="",tradeProductId="";
		
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

	    LocalDate endDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    
	    //System.out.println("endDate : " + endDate);

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
	    //System.out.print(day+"일");
	    int month=endDate.getMonthValue()+addMonth;
	    //System.out.print(month+"월");
	    int year = endDate.getYear()+addYear;
	    //System.out.print(year+"년");
	    
	    String tempStartDate = Integer.toString(year)+Integer.toString(month)+Integer.toString(day); 
	    
	    LocalDate startDate = LocalDate.parse(tempStartDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
	    
	    //System.out.println("\nstartDate: "+startDate);
	    
	    List<DataEntry> dataList = new ArrayList<>();
		List<String> productList = new ArrayList<>();
	    Map<String, Integer> productMap = new HashMap<>();
	    Map<String, Integer> userMap = new HashMap<>();
	    
		for(DataEntry et : allDataList) {
	        if (et.getDate().isEqual(startDate) || et.getDate().isAfter(startDate)) {
	        	if(et.getDate().isAfter(endDate)) {
	        		continue;
	        	}
	            //System.out.println("같은 날짜 혹은 N일 이내입니다.");
	            dataList.add(et);
	            
	        } else {
	            //System.out.println("이전 날짜입니다.");
	        } 
	        
		}
		
		for(DataEntry et : dataList) {
			if(productList.contains(et.getProductId())) {
				continue;
			}
			productList.add(et.getProductId());
		}
		
		for(String s : productList) {
			List<String> userList = new ArrayList<>();
			List<String> userList2 = new ArrayList<>();
			for(DataEntry et : dataList) {
				if (s.equals(et.getProductId())) {
					if(productMap.containsKey(s)) {
						if(userList.contains(et.getUserId())) {
							if(!userList2.contains(et.getUserId())) {
								userList2.add(et.getUserId());
							}
						}
						if(!userList.contains(et.getUserId())) {
							productMap.put(s, productMap.get(s) + 1);
						}
		        		userList.add(et.getUserId());
					}else {
		        		productMap.put(s, 1);
		        		userList.add(et.getUserId());
					}
	        	}
			}
			userMap.put(s, userList2.size());
		}
		
		Map<String, Double> finalTable = new HashMap<>();
		
		for (Map.Entry<String, Integer> entry : productMap.entrySet()) {
			int a =userMap.get(entry.getKey());
			int b =entry.getValue();
			
			finalTable.put(entry.getKey() , (double)a/b );
		}
		

		System.out.println("-----검사데이터----");
		for(DataEntry et : dataList) {
			System.out.println(et.getDate()+" uid"+et.getUserId()+" pid" + et.getProductId());
		}
		System.out.println("----------------");

//		for(String s : productList) {
//			
//			System.out.println("product List"+s+" ");
//		}
//
//		System.out.println("------구매횟수------");
//        for (Map.Entry<String, Integer> entry : productMap.entrySet()) {
//            System.out.println("productMap 키: "+entry.getKey() + "값: " + entry.getValue());
//        }
//		System.out.println("------------------");
//        for (Map.Entry<String, Integer> entry : userMap.entrySet()) {
//            System.out.println("userMap 키: "+entry.getKey() + "값: " + entry.getValue());
//        }
//        for (Map.Entry<String, Double> entry : finalTable.entrySet()) {
//            System.out.println("finalTable 키: "+entry.getKey() + "값: " + entry.getValue());
//        }

        List<Map.Entry<String, Double>> sortedFinalTable = new ArrayList<>(finalTable.entrySet());
        sortedFinalTable.sort(Comparator
        		.comparing(Map.Entry<String, Double>::getValue, Comparator.reverseOrder())
                .thenComparing((entry1, entry2) -> 
                productMap.get(entry2.getKey()).compareTo(productMap.get(entry1.getKey())))
                .thenComparing(Map.Entry::getKey)
        );

		System.out.println("------재구매율(정렬)------");
        // 정렬된 결과 출력
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Double> entry : sortedFinalTable) {
        	result.add("pid" + entry.getKey());
            System.out.printf("pid"+entry.getKey());
            System.out.printf(" %6.1f" , (float)(entry.getValue()*100));
            System.out.println("% ,상품을 한 번 이상 구매한 고객 수: " + productMap.get(entry.getKey()));
        }
        if (result.isEmpty()) {
            result.add("no result");
        }

        return result.toArray(new String[0]);
        

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
