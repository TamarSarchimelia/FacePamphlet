
/*
 * File: FacePamphletDatabase.java
 * -------------------------------
 * This class keeps track of the profiles of all users in the
 * FacePamphlet application.  Note that profile names are case
 * sensitive, so that "ALICE" and "alice" are NOT the same name.
 */

import java.util.*;

import acm.graphics.GImage;

public class FacePamphletDatabase implements FacePamphletConstants {
	// here I creat hashmap with string of the name and facepamphletprofile
	private HashMap<String, FacePamphletProfile> profiles;

	/**
	 * Constructor This method takes care of any initialization needed for the
	 * database.
	 */
	public FacePamphletDatabase() {
		// You fill this in
		// here I create (initialization) hashmap
		profiles = new HashMap<String, FacePamphletProfile>();
	}

	/**
	 * This method adds the given profile to the database. If the name associated
	 * with the profile is the same as an existing name in the database, the
	 * existing profile is replaced by the new profile passed in.
	 */
	public void addProfile(FacePamphletProfile profile) {
		profiles.put(profile.getName().toLowerCase(), profile);
		// here i add new profile and because about this is not no word I save profile
		// name with lowercase and
		// for example aA and Aa is for me identical.
	}

	/**
	 * This method returns the profile associated with the given name in the
	 * database. If there is no profile in the database with the given name, the
	 * method returns null.
	 */
	public FacePamphletProfile getProfile(String name) {
		// You fill this in. Currently always returns null.
		// here I search profile and return it
		return profiles.get(name.toLowerCase());
	}

	/**
	 * This method removes the profile associated with the given name from the
	 * database. It also updates the list of friends of all other profiles in the
	 * database to make sure that this name is removed from the list of friends of
	 * any other profile.
	 * 
	 * If there is no profile in the database with the given name, then the database
	 * is unchanged after calling this method.
	 */
	public void deleteProfile(String name) {
		// You fill this in
		//here i delete account
		profiles.remove(name.toLowerCase());
	}

	/**
	 * This method returns true if there is a profile in the database that has the
	 * given name. It returns false otherwise.
	 */
	public boolean containsProfile(String name) {
		// You fill this in. Currently always returns false.
		// this code returns true if there is this profile and false if there is not this profile
		// and also, as I say(write), everything is with LowerCase.
		return profiles.containsKey(name.toLowerCase());
	}

	public String toString() {
		String s = "****";
		for (FacePamphletProfile p : profiles.values()) {
			s += p.toString() + "\n";
		}
		return s;
	}

}
