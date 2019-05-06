	public static String getSecurityAnswer(String S1) {
		
		Connection conn = getConnection();
		
		String PassStr = "SELECT SecurityAnswer FROM Username WHERE Username = ?";
		
		try {
			PreparedStatement presecurityAnswer = conn.prepareStatement(securityAnswerStr);
		
			presecurityAnswer.setString(1, u1.getUser());
			
			ResultSet set = preSecurityAnswer.executeQuery();
			
			while(set.next()) {
				
				Sting securityAnswer;
				return this.SecurityAnswer;
			}
			
		}
		catch(NullPointerException npe) {
			AlertBox.display("Problem", "The Security Answer You Are Trying To find Does Not Seem To Exist, try again.");
			npe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
