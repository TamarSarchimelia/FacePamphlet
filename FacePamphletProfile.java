
/*
 * File: FacePamphletProfile.java
 * ------------------------------
 * This class keeps track of all the information for one profile
 * in the FacePamphlet social network.  Each profile contains a
 * name, an image (which may not always be set), a status (what 
 * the person is currently doing, which may not always be set),
 * and a list of friends.
 */

import acm.graphics.*;
import java.util.*;

public class FacePamphletProfile implements FacePamphletConstants {

	/**
	 * Constructor This method takes care of any initialization needed for the
	 * profile.
	 */
	
	// I create string profilename
	private String profilename;
	// here I create hashset, that is only for firend list
	private   HashSet<String> friendslist = new   HashSet<String>();
	// here I create string of the status of profile, and at this time it's EMPTY_LABEL_TEXT
	private  String namestatus = EMPTY_LABEL_TEXT;
	// here i create gimage for profile
	private GImage nameimage;

	public FacePamphletProfile(String name) {
		// You fill this in
		// here i save profilename
		profilename = name;
	}

	/** This method returns the name associated with the profile. */
	public String getName() {
		// You fill this in. Currently always returns the empty string.
		// here this program returns profile name
		return profilename;
	}

	/**
	 * This method returns the image associated with the profile. If there is no
	 * image associated with the profile, the method returns null.
	 */
	public GImage getImage() {
		// You fill this in. Currently always returns null.
		//here this program returns profile image
		return nameimage;
	}

	/** This method sets the image associated with the profile. */
	public void setImage(GImage image) {
		// You fill this in
		// here program revrotes image
		nameimage= image;
	}

	/**
	 * This method returns the status associated with the profile. If there is no
	 * status associated with the profile, the method returns the empty string ("").
	 */
	public String getStatus() {
		// You fill this in. Currently always returns the empty string.
		//here this program returns profile status
		return namestatus;
	}

	/** This method sets the status associated with the profile. */
	public void setStatus(String status) {
		// You fill this in
		//here program revrotes profile status
		namestatus= status;
	}

	/**
	 * This method adds the named friend to this profile's list of friends. It
	 * returns true if the friend's name was not already in the list of friends for
	 * this profile (and the name is added to the list). The method returns false if
	 * the given friend name was already in the list of friends for this profile (in
	 * which case, the given friend name is not added to the list of friends a
	 * second time.)
	 */
	public boolean addFriend(String friend) {
		// You fill this in. Currently always returns true.
		// this code adds friend in the friendlist
		if (friendslist.contains(friend)){
			return false;
		}else {
			friendslist.add(friend);
		return true;
		}

	}

	/**
	 * This method removes the named friend from this profile's list of friends. It
	 * returns true if the friend's name was in the list of friends for this profile
	 * (and the name was removed from the list). The method returns false if the
	 * given friend name was not in the list of friends for this profile (in which
	 * case, the given friend name could not be removed.)
	 */
	public boolean removeFriend(String friend) {

		// You fill this in. Currently always returns false.
		// here removes friend in the firend list
		if (friendslist.contains(friend)){
			friendslist.remove(friend);
			return true;
		}else {
			
		return false;
		}

	}

	/**
	 * This method returns an iterator over the list of friends associated with the
	 * profile.
	 */
	// i create iterator
	public Iterator<String> getFriends() {
		// You fill this in. Currently always returns null.
		return friendslist.iterator();
	}

	/**
	 * This method returns a string representation of the profile. This string is of
	 * the form: "name (status): list of friends", where name and status are set
	 * accordingly and the list of friends is a comma separated list of the names of
	 * all of the friends in this profile.
	 * 
	 * For example, in a profile with name "Alice" whose status is "coding" and who
	 * has friends Don, Chelsea, and Bob, this method would return the string:
	 * "Alice (coding): Don, Chelsea, Bob"
	 */
	public String toString() {
		// here i create string that contains all information about the profile
		// You fill this in. Currently always returns the empty string.
		String string=null;
		for (String s:friendslist) if (string==null) string=profilename + " (" + namestatus + ") : "+s;else string+=", "+s;
		
		if (string==null) return profilename + " (" + namestatus + ") : ";
		
		return string;
	}

}
