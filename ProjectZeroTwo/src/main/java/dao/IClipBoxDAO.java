package dao;

import java.util.List;

import models.ClipBox;
import models.Transaction;
import models.User;

public interface IClipBoxDAO {
	
	public boolean isExtantClipBox(String boxID);
	public int getBalance(String boxID);
	public ClipBox getClipBox(String boxID);
	public ClipBox addClipBox(User user);
	public boolean deleteClipBox(ClipBox box);
	/**
	 * @return all clipboxes in database
	 */
	public List<ClipBox> getClipBoxes();
	/**
	 * @param user
	 * @return all clipboxes belonging to user
	 */
	public List<ClipBox> getClipBoxes(User user);
	public ClipBox addClipBox(User user, String description);
	public Transaction makeTransaction(String boxID, int withdrawl);
	

}
