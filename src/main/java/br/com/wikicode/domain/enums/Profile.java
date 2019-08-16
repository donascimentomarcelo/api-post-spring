package br.com.wikicode.domain.enums;

public enum Profile {
	
	ADMIN(1, "ADMINISTRATOR"),
	USER(2, "SIMPLEUSER"),
	UNDEFINED(0, "UNDEFINED");
	
	private Integer code;
	private String description;
	
	private Profile(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static Profile getUndefinedProfile() {
		return Profile.UNDEFINED;
	}
	
	public static Profile toEnum(Integer code) {
		for(Profile profile: Profile.values()) {
			if(code.equals(profile.getCode())) {
				return profile;
			}
		}
		return getUndefinedProfile();
	}
}
