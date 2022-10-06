
/* 
 * File: FacePamphlet.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import javax.swing.*;

public class FacePamphlet extends Program implements FacePamphletConstants {

	/**
	 * This method has the responsibility for initializing the interactors in the
	 * application, and taking care of any other initialization that needs to be
	 * performed.
	 */
	// here i create buttons textfield labels profiles databases, string and canvas
	private JButton LookupButton, DeleteButton, AddButton, changestatusButton, changepictureButton, addfriendButton;
	private JTextField nametextfield, changestatustextfield, changepicturetextfield, addfriendtextfield;
	private JLabel namelabel;
	private FacePamphletProfile profile;
	private FacePamphletDatabase profileBasa;
	private String mininame;
	private FacePamphletCanvas canvas;

	public void init() {
		// You fill this in
		// here is west buttons and textfields
		
		profileBasa=new FacePamphletDatabase();
		
		changestatustextfield = new JTextField(TEXT_FIELD_SIZE);
		changestatusButton = new JButton("Change Status");

		changepicturetextfield = new JTextField(TEXT_FIELD_SIZE);
		changepictureButton = new JButton("Change Picture");

		addfriendtextfield = new JTextField(TEXT_FIELD_SIZE);
		addfriendButton = new JButton("Add Friend");

		changestatustextfield.addKeyListener(new MyKeyListener(changestatustextfield));
		changepicturetextfield.addKeyListener(new MyKeyListener(changepicturetextfield));
		addfriendtextfield.addKeyListener(new MyKeyListener(addfriendtextfield));

		add(changestatustextfield, WEST);
		add(changestatusButton, WEST);
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);
		add(changepicturetextfield, WEST);
		add(changepictureButton, WEST);
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);
		add(addfriendtextfield, WEST);
		add(addfriendButton, WEST);
		// here is north buttonds, textfields and labels
		namelabel = new JLabel("Name");
		nametextfield = new JTextField(TEXT_FIELD_SIZE);
		AddButton = new JButton("Add");
		DeleteButton = new JButton("Delete");
		LookupButton = new JButton("Lookup");
		add(namelabel, NORTH);
		add(nametextfield, NORTH);
		add(AddButton, NORTH);
		add(DeleteButton, NORTH);
		add(LookupButton, NORTH);

		addActionListeners();
		canvas = new FacePamphletCanvas(); 
		add(canvas);

		

	}
	// here i create new class to wrote one keylistener to enter, and do not wrote this code for everu textsfield
	// also i didn't do that for name, because I did not think that this needs
	
	class MyKeyListener implements KeyListener {
		Object source;

		MyKeyListener(Object _source) {
			source = _source;
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub

			if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				if (source.equals(changestatustextfield)) {
					changestatus();
				} else if (source.equals(changepicturetextfield)) {
					changepicture();
				} else if (source.equals(addfriendtextfield)) {
					addfriend();
				}

			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}
	};

	/**
	 * This class is responsible for detecting when the buttons are clicked or
	 * interactors are used, so you will have to add code to respond to these
	 * actions.
	 */
	
	// here is action performance that is maybe body of this program
	public void actionPerformed(ActionEvent e) {

		// You fill this in as well as add any additional methods

		Object click = e.getSource();
		if (click == LookupButton) {
			lookup();
		} else if (click == DeleteButton) {
			deletebutton();
		} else if (click == AddButton) {
			add();
		} else if (click == changestatusButton) {
			changestatus();
		} else if (click == changepictureButton) {
			changepicture();
		} else if (click == addfriendButton) {
			addfriend();
		}
	}

	private void lookup() {
		// this code is for lookup. it search the profile and do something
		mininame = nametextfield.getText();
		if (mininame != EMPTY_LABEL_TEXT &&profileBasa.containsProfile(mininame)) {
			profile = profileBasa.getProfile(mininame);
			canvas.displayProfile(profile);
			canvas.showMessage("Displaying " + mininame);
		}
	}

	private void deletebutton() {
		// this code deletes the profile 
		mininame = nametextfield.getText();
		if (mininame != EMPTY_LABEL_TEXT &&profileBasa.containsProfile(mininame)) {
			profileBasa.deleteProfile(mininame);
			profile.removeFriend(mininame);
			canvas.removeAll();
			canvas.showMessage("Profile of "+  mininame + " deleted");
		}else {
			canvas.removeAll();
			canvas.showMessage("A profile with the name "+  mininame + " already exists");
		}
	}

	private void add() {
		// this code adds the new profile
		// and also it displays this new profile
		mininame = nametextfield.getText();
		String name = nametextfield.getText();
		if (name != EMPTY_LABEL_TEXT&&!profileBasa.containsProfile(name)) {
			profile = new FacePamphletProfile(name);
			profileBasa.addProfile(profile);
			canvas.displayProfile(profile);
			canvas.showMessage("New profile created");
		} else if(profileBasa.containsProfile(name)){
			canvas.showMessage("A profile with the name " + name+" already exists");
		}
	}

	private void changestatus() {
		// this code changes status of the profile that was last added or lookedup, but not deleted because it is not in the base.
		String name = changestatustextfield.getText();
		if (name != EMPTY_LABEL_TEXT && profileBasa.containsProfile(mininame)) {
			profile.setStatus(name);
			canvas.displayProfile(profile);
			canvas.showMessage("Status updated to " + profile.getStatus());
		}else {
			canvas.showMessage("Please select a profile to change status");
		}
	}

	private void changepicture() {
		// this code changes picture
		String name = changepicturetextfield.getText();

		if (name != EMPTY_LABEL_TEXT && profileBasa.containsProfile(mininame)) {
			GImage image = null;
			try {
				image = new GImage(name);
				profile.setImage(image);
				//println("Change Picture: " + name);
			} catch (ErrorException ex) {
				// Code that is executed if the filename cannot be opened.
			}
			println("change picture: " + profile.getImage());
			if(profile.getImage()==null) {
				canvas.showMessage("Unable to open image file: " + image);
			}else {
				canvas.displayProfile(profile);
				canvas.showMessage("Picture updated");
			}
		}else {
			canvas.showMessage("Please select a profile to change picture");
		}
	}

	private void addfriend() {
		// this code adds friend and also wrotes some messiges
		String name = addfriendtextfield.getText();
		if (name != EMPTY_LABEL_TEXT && profileBasa.containsProfile(mininame)) {
			if (profile.addFriend(name)) {
				// if profile wants to add friend his profile he will write that he has already his friend
				profile.addFriend(name);
				canvas.displayProfile(profile);
				canvas.showMessage(name + " added as a friend");
				profile = new FacePamphletProfile(name);
				profile.addFriend(mininame);
				
			}else {
				canvas.showMessage(mininame + " already has " + name + " as a friend");
			}

		}else if(profileBasa.containsProfile(name)) {
			canvas.showMessage(name + "does not exist");
		}else {
			canvas.showMessage( "Please select a profile to add friend" );
		}
	}

}
