package exercise01;

import java.time.LocalDate;  

public class Singer {
	
	//field
	int singerId; //instance variables: private if not declared public or protected
	String singerName;
	String singerAddress;
	LocalDate singerBirth;
	int singerNumberOfAlbums;
	
	//constructor syntax: just the name of the class
	//constructor with no arguments
	Singer(){
		
	}
	//constructor with 1 arguments
	Singer (int singerId){
		this.singerId = singerId;
	}
	//constructor with 2 arguments
	Singer(int singerId, String singerName){
		this.singerId = singerId;
		this.singerName = singerName;
	}
	//constructor with 3 arguments
	Singer(int singerId, String singerName, String singerAddress){
		this.singerId = singerId;
		this.singerName = singerName;
		this.singerAddress = singerAddress;
	}
	//constructor with 4 arguments
	Singer(int singerId, String singerName, String singerAddress, LocalDate singerBirth){
		this.singerId = singerId;
		this.singerName = singerName;
		this.singerAddress = singerAddress;
		this.singerBirth = singerBirth;
	}
	//constructor with 5 arguments
	Singer(int singerId, String singerName, String singerAddress, LocalDate singerBirth, int singerNumberOfAlbums){
		this.singerId = singerId;
		this.singerName = singerName;
		this.singerAddress = singerAddress;
		this.singerBirth = singerBirth;
		this.singerNumberOfAlbums = singerNumberOfAlbums;
	}
	
	//SETTERS
	
	//5 individuals setters:
	
	//1
	public void setSingerId(int singerId) {
		this.singerId = singerId;
	}
	
	//2
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	
	//3
	public void setSingerAddress(String singerAddress) {
		this.singerAddress = singerAddress;
	}
	
	//4
	public void setSingerBirth(LocalDate singerBirth) {
		this.singerBirth = singerBirth;
	}
	
	//5
	public void setSingerNumberOfAlbums(int singerNumberOfAlbums) {
		this.singerNumberOfAlbums = singerNumberOfAlbums;
	}
	
	//One setter to set all values:
	public void setAllValues(Singer otherSinger) {
		this.singerId = otherSinger.singerId;
		this.singerName = otherSinger.singerName;
		this.singerAddress = otherSinger.singerAddress;
		this.singerBirth = otherSinger.singerBirth;
		this.singerNumberOfAlbums = otherSinger.singerNumberOfAlbums;
	}
	
	//GETTERS

	//5 individuals getters:
	
	//1
	public int getSingerId() {
		return singerId;
	}
	
	//2
	public String getSingerName() {
		return singerName;
	}
	
	//3
	public String getSingerAddress() {
		return singerAddress;
	}
	
	//4
	public LocalDate getSingerBirth() {
		return singerBirth;
	}
	
	//5
	public int getSingerNumberOfAlbums() {
		return singerNumberOfAlbums;
	}
	
	//Creating a toString method
	public String toString() {
		return "Singer's Id : \t\t" + singerId + "\nSinger's Name : \t" + singerName + "\nSinger's Address : \t" + singerAddress + "\nSinger's Birth : \t" + singerBirth + "\nSinger's Albums : \t" + singerNumberOfAlbums + "\n";
	}

}
