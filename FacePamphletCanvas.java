/*
 * File: FacePamphletCanvas.java
 * -----------------------------
 * This class represents the canvas on which the profiles in the social
 * network are displayed.  NOTE: This class does NOT need to update the
 * display when the window is resized.
 */

import acm.graphics.*;
import java.awt.*;
import java.util.*;

public class FacePamphletCanvas extends GCanvas implements FacePamphletConstants {

	/**
	 * Constructor This method takes care of any initialization needed for the
	 * display
	 */
	// here i create glabels and grects
	public FacePamphletCanvas() {
		// You fill this in
		label = new GLabel("");
		name = new GLabel("");
		rect = new GRect(0, 0);
		noImage = new GLabel("");
		status = new GLabel(" ");
		friend = new GLabel("");
		
	}

	/**
	 * This method displays a message string near the bottom of the canvas. Every
	 * time this method is called, the previously displayed message (if any) is
	 * replaced by the new message text passed in.
	 */
	public void showMessage(String msg) {
		// You fill this in
// here is code for message 
		label.setLabel(msg);
		label.setFont(MESSAGE_FONT);
		label.setLocation(getWidth() / 2 - label.getWidth() / 2,
				getHeight() - BOTTOM_MESSAGE_MARGIN - label.getDescent());
		
		add(label);
	}

	/**
	 * This method displays the given profile on the canvas. The canvas is first
	 * cleared of all existing items (including messages displayed near the bottom
	 * of the screen) and then the given profile is displayed. The profile display
	 * includes the name of the user from the profile, the corresponding image (or
	 * an indication that an image does not exist), the status of the user, and a
	 * list of the user's friends in the social network.
	 */
	public void displayProfile(FacePamphletProfile profile) {
		// You fill this in
		// this code is body of the canva
		// first of all he removes everything and than creates a new one
		removeAll();
		name.setLabel(profile.getName());
		name.setFont(PROFILE_NAME_FONT);
		name.setLocation(LEFT_MARGIN, TOP_MARGIN);
		name.setColor(Color.blue);
		
		add(name);
		GImage image = profile.getImage();
		if (image == null) {
			constructor();
		} else {
			image.setLocation(LEFT_MARGIN, TOP_MARGIN + name.getDescent() + IMAGE_MARGIN);
			image.setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
			add(image);
		}
		status.setLabel(status(profile.getStatus(), profile.getName()));
		status.setFont(PROFILE_STATUS_FONT);
		double y = TOP_MARGIN + name.getDescent() + IMAGE_MARGIN + IMAGE_HEIGHT + STATUS_MARGIN;
		status.setLocation(LEFT_MARGIN, y);
		
		add(status);
		friend(profile);
	}

	private void friend(FacePamphletProfile profile) {
		// here is friend list label
		friend.setLabel("Friends:");
		
		friend.setLocation(getWidth()/2, TOP_MARGIN + name.getHeight() + IMAGE_MARGIN);
		
		friend.setFont(PROFILE_FRIEND_LABEL_FONT);
		
		add(friend);
		Iterator<String> friends = profile.getFriends();
		int i=-1;
		while(friends.hasNext()) {i++;
		list = new GLabel(" ");
		    String s = (String)friends.next();
			list.setLabel(s);
			list.setFont(PROFILE_FRIEND_FONT);
			list.setLocation(getWidth() / 2,
					TOP_MARGIN + name.getHeight() + IMAGE_MARGIN + friend.getHeight()*2 + list.getHeight() * i);
			
			add(list);
		}
		
		
		
		
	}

	private String status(String s, String m) {
		// here is string of the status
		if (s == " ") {
			String t = "No current status";
			return t;
		} else {
			String t = m + " is " + s;
			return t;
		}
	}

	private void constructor() {
		// this constructor is maybe i can say image if there is no image. 
		// it paint rectangle and glabel text
		rect.setLocation(LEFT_MARGIN, TOP_MARGIN + name.getDescent() + IMAGE_MARGIN);
		rect.setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
		add(rect);
		noImage.setLabel("No Image");
		noImage.setFont(PROFILE_IMAGE_FONT);
		double x = LEFT_MARGIN + IMAGE_WIDTH / 2 - noImage.getWidth()/2;
		double y = TOP_MARGIN + name.getHeight() + IMAGE_MARGIN + IMAGE_HEIGHT / 2 - noImage.getHeight()/2;
		noImage.setLocation(x, y);
		
		add(noImage);
	}

	private GLabel label;
	private GLabel name;
	private GRect rect;
	private GLabel noImage;
	private GLabel status;
	private GLabel friend;
	private GLabel list;
}
