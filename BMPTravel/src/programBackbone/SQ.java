	public static String getSecurityQuestion(String S) {
		
		Connection conn = getConnection();
		
		String PassStr = "SELECT SecurityQuestion FROM Username WHERE Username = ?";
		
		try {
			PreparedStatement presecurityQuestion = conn.prepareStatement(securityQuestionStr);
		
			presecurityQuestion.setString(1, u1.getUser());
			
			ResultSet set = preSecurityQuestion.executeQuery();
			
			while(set.next()) {
				
				Sting securityQuestion;
				return this.SecurityQuestion;
			}
			
		}
		catch(NullPointerException npe) {
			AlertBox.display("Problem", "The Security Question You Are Trying To find Does Not Seem To Exist, try again.");
			npe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
