package com.palza.ex.dto;

public class infoDto {

   private String id;
   private String pwd;
   private String name;
   private String email;
   private String tel;
   private String address;
   
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }
   
   public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getTel() {
      return tel;
   }

   public void setTel(String tel) {
      this.tel = tel;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }


   
   
   public infoDto(String id,String pwd, String name, String email, String tel, String address) {
      super();
      this.id = id;
      this.pwd = pwd;
      this.name = name;
      this.email = email;
      this.tel = tel;
      this.address = address;
   }
   

    private infoDto() {
    	
    }
   
}
