# JPA_HIBERNATE_PROJECT
 @RequestMapping(value = "/sendSMS", method = RequestMethod.POST,
	            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	  public void sendSms(@RequestBody SMS sms) {
		 
		 try {
			 String apiKey="apiKey="+"OTA1YjBjYmMyODAyNDQ5MmMxNWNjNjAzOTdmODhhYzg=";
			 String message=URLEncoder.encode(sms.getMessage(), "UTF-8");
			 String apiURL="https://api.textlocal.in/send/?"+apiKey+""
			 		+ "&message="+message+"&numbers="+sms.getTo();
			 URL url=new URL(apiURL);
			 URLConnection connection=url.openConnection();
			 connection.setDoOutput(true);
			 BufferedReader reader=new BufferedReader(
					 new InputStreamReader(connection.getInputStream()));
			 String line ="";
			 StringBuffer sb=new StringBuffer();
			 while((line=reader.readLine())!=null) {
				 sb.append(line).append("\n");
			 }
			 System.out.println(sb.toString());
		} catch (Exception e) {
			
		}
		 
		 
	  }
