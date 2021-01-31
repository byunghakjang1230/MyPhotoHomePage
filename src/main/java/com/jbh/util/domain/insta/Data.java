package com.jbh.util.domain.insta;

import java.util.List;

public class Data {

	private String id;
	private User user;
	private Images images;
	private String created_time;
	private Caption caption;
	private boolean user_has_liked;
	private Likes likes;
	private List<String> tags;
	private String filter;
	private Comments comments;
	private String type;
	private String link;
	private Location location;
	private String attribution;
	private List<UsersInPhoto> users_in_photo;
	
	public void setId(String id) { this.id = id; }
	public void setUser(User user) { this.user = user; }
	public void setImages(Images images) { this.images = images; }
	public void setCreated_time(String created_time) { this.created_time = created_time; }
	public void setCaption(Caption caption) { this.caption = caption; }
	public void setUser_has_liked(boolean user_has_liked) { this.user_has_liked = user_has_liked; }
	public void setLikes(Likes likes) { this.likes = likes; }
	public void setTags(List<String> tags) { this.tags = tags; }
	public void setFilter(String filter) { this.filter = filter; }
	public void setComments(Comments comments) { this.comments = comments; }
	public void setType(String type) { this.type = type; }
	public void setLink(String link) { this.link = link; }
	public void setLocation(Location location) { this.location = location; }
	public void setAttribution(String attribution) { this.attribution = attribution; }
	public void setUsers_in_photo(List<UsersInPhoto> users_in_photo) { this.users_in_photo = users_in_photo; }
	
	public String getId() { return this.id; }
	public User getUser() { return this.user; }
	public Images getImages() { return this.images; }
	public String getCreated_time() { return this.created_time; }
	public Caption getCaption() { return this.caption; }
	public boolean getUser_has_liked() { return this.user_has_liked; }
	public Likes getLikes() { return this.likes; }
	public List<String> getTags() { return this.tags; }
	public String getFilter() { return this.filter; }
	public Comments getComments() { return this.comments; }
	public String getType() { return this.type; }
	public String getLink() { return this.link; }
	public Location getLocation() { return this.location; }
	public String getAttribution() { return this.attribution; }
	public List<UsersInPhoto> getUsers_in_photo() { return this.users_in_photo; }
	
	public String toString() {
		return "Data [id="+this.id+", user="+this.user+", images="+this.images+", created_time="+this.created_time+
				", caption="+this.caption+", user_has_liked="+this.user_has_liked+", likes="+this.likes+", tags="+this.tags+
				", filter="+this.filter+", comments="+this.comments+", type="+this.type+", link="+this.link+", location="+this.location+
				", attribution="+this.attribution+", users_in_photo="+this.users_in_photo+"]";
	}
}
