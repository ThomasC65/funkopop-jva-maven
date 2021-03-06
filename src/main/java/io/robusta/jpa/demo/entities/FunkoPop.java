package io.robusta.jpa.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FunkoPop
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	

	private String name;
	
	@ManyToOne
	private Universe universe;
	
	
	private boolean waterproof;
	private double latitude;
	private double longitude;

	public FunkoPop()
	{
	}

	
	public FunkoPop( int id, String name, Universe universe, boolean waterproof, double latitude, double longitude )
	{
		this.id = id;
		this.name = name;
		this.universe = universe;
		this.waterproof = waterproof;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	
	

	public FunkoPop(String name, Universe universe) {

		this.name = name;
		this.universe = universe;
	}


	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}


	
	public Universe getUniverse() {
		return universe;
	}


	public void setUniverse(Universe universe) {
		this.universe = universe;
	}


	public boolean isWaterproof()
	{
		return waterproof;
	}

	public void setWaterproof( boolean waterproof )
	{
		this.waterproof = waterproof;
	}

	public int getId()
	{
		return id;
	}

	public void setId( int id )
	{
		this.id = id;
	}

	public double getLatitude()
	{
		return latitude;
	}

	public void setLatitude( double latitude )
	{
		this.latitude = latitude;
	}

	public double getLongitude()
	{
		return longitude;
	}

	public void setLongitude( double longitude )
	{
		this.longitude = longitude;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name+" ("+this.universe.name+")";
	}
}
